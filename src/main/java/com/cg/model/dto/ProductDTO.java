package com.cg.model.dto;

import com.cg.model.Product;
import com.cg.model.ProductMedia;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;


@Data
public class ProductDTO {

    private String id;

    private String name;

    private String description;

    private String fileName;

    private String fileFolder;

    private String fileUrl;

    private String cloudId;

    private String fileProductId;

    private MultipartFile file;

    private String fileType;

    public Product toProduct() {
        return new Product()
                .setId(id)
                .setName(name)
                .setDescription(description);
    }

    public ProductMedia toProductMedia() {
        return new ProductMedia()
                .setId(fileProductId)
                .setFileName(fileName)
                .setFileFolder(fileFolder)
                .setFileUrl(fileUrl)
                .setCloudId(cloudId)
                .setFileType(fileType);
    }
}
