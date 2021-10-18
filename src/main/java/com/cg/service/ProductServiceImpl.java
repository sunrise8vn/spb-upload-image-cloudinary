package com.cg.service;


import com.cg.exception.DataInputException;
import com.cg.model.ImageProduct;
import com.cg.model.Product;
import com.cg.model.dto.IProductDTO;
import com.cg.model.dto.ProductDTO;
import com.cg.repository.ImageProductRepository;
import com.cg.repository.ProductRepository;
import com.cg.utils.UploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;


@Service
@Transactional
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ImageProductRepository imageProductRepository;

    @Autowired
    private UploadService uploadService;

    @Autowired
    private UploadUtils uploadUtils;


    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Iterable<IProductDTO> findAllIProductDTO() {
        return productRepository.findAllIProductDTO();
    }

    @Override
    public Optional<Product> findById(String id) {
        return productRepository.findById(id);
    }

    @Override
    public Product create(ProductDTO productDTO) {

        Product product = productRepository.save(productDTO.toProduct());

        ImageProduct imageProduct = imageProductRepository.save(productDTO.toImageProduct());

        uploadAndSaveProductImage(productDTO, product, imageProduct);

        return product;
    }


    @Override
    public IProductDTO findIProductDTOById(String id) {
        return productRepository.findIProductDTOById(id);
    }

    private void uploadAndSaveProductImage(ProductDTO productDTO, Product product, ImageProduct imageProduct) {
        try {
            Map uploadResult = uploadService.upload(productDTO.getImage(), uploadUtils.buildUploadParams(imageProduct));
            String imageUrl = (String) uploadResult.get("secure_url");
            String imageFormat = (String) uploadResult.get("format");

            imageProduct.setImageName(imageProduct.getId() + "." + imageFormat);
            imageProduct.setImageUrl(imageUrl);
            imageProduct.setCloudId(imageProduct.getImageFolder() + "/" + imageProduct.getId());
            imageProduct.setProduct(product);
            imageProductRepository.save(imageProduct);

        } catch (IOException e) {
            e.printStackTrace();
            throw new DataInputException("Upload hình ảnh thất bại");
        }
    }

    @Override
    public void delete(Product product) throws IOException {

        Optional<ImageProduct> imageProduct = imageProductRepository.findByProduct(product);

        if (imageProduct.isPresent()) {
            String publicId = imageProduct.get().getCloudId();

            uploadService.destroy(publicId, uploadUtils.buildDestroyParams(product, publicId));

            imageProductRepository.delete(imageProduct.get());
        }

        productRepository.delete(product);

    }
}
