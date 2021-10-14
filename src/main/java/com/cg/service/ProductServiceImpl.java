package com.cg.service;


import com.cg.exception.DataInputException;
import com.cg.model.Product;
import com.cg.model.dto.ProductDTO;
import com.cg.repository.ProductRepository;
import com.cg.utils.UploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;


@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UploadService uploadService;

    @Autowired
    private UploadUtils uploadUtils;


    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product create(ProductDTO productDTO) {

//        String imageUrl = productDTO.getImage().getName();

        Product product = productDTO.toProduct();

        productRepository.save(product);

        uploadAndSaveProductImage(productDTO, product);

        return product;
    }


    private void uploadAndSaveProductImage(ProductDTO productDTO, Product product) {
        try {
            Map uploadResult = uploadService.upload(productDTO.getImage(), uploadUtils.buildUploadParams(product));
            String imageUrl = (String) uploadResult.get("secure_url");
            String imageFormat = (String) uploadResult.get("format");
            String imageName = String.format("product_%d", product.getId());
            System.out.println("url: " + imageName);

//            String publicId = "{signature=a2d386ca9a9ef7dd1b097b846e036a06ac409752, format=png, resource_type=image, secure_url=https://res.cloudinary.com/toanphat/image/upload/v1633962426/product_images/avatar/product_20.png, created_at=2021-10-11T14:27:06Z, asset_id=57d5dc83cc1c3528547532692a100f95, version_id=781b8145092aac88eda0e4c0944c8e2e, type=upload, version=1633962426, url=http://res.cloudinary.com/toanphat/image/upload/v1633962426/product_images/avatar/product_20.png, public_id=product_images/avatar/product_20, tags=[], original_filename=file, api_key=113674834486315, bytes=46834, width=623, etag=25f187c678874613a149353b2a8649d1, placeholder=false, height=467}";

            product.setImageName(imageName + "." + imageFormat);
            product.setImageUrl(imageUrl);
            product.setCloudId(product.getImageFolder() + "/" + imageName);
            productRepository.save(product);
        } catch (IOException e) {
            e.printStackTrace();
            throw new DataInputException("Upload hình ảnh thất bại");
        }
    }

    @Override
    public void delete(Long id) throws IOException {

        Optional<Product> product = productRepository.findById(id);

        if (!product.isPresent()) {
            throw new DataInputException("Sản phẩm không tồn tại");
        }

        String publicId = product.get().getCloudId();

        productRepository.deleteById(id);

        uploadService.destroy(publicId, uploadUtils.buildDestroyParams(product.get()));
    }
}
