package com.cg.model.dto;

import com.cg.model.ImageProduct;
import com.cg.model.Product;
import com.cg.utils.UploadUtils;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;


@Data
public class ProductDTO {

    private String id;

    private String name;

    private String description;

    private String imageName;

    private String imageFolder = UploadUtils.UPLOAD_FOLDER;

    private String imageUrl;

    private String cloudId;

    private String imageProductId;

    private MultipartFile image;

    public Product toProduct() {
        return new Product()
                .setId(id)
                .setName(name)
                .setDescription(description);
    }

    public ImageProduct toImageProduct() {
        return new ImageProduct()
                .setId(imageProductId)
                .setImageName(imageName)
                .setImageFolder(imageFolder)
                .setImageUrl(imageUrl)
                .setCloudId(cloudId);
    }
}
