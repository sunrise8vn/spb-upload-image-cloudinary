package com.cg.utils;

import com.cg.exception.DataInputException;
import com.cg.model.Product;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class UploadUtils {
    public static final String UPLOAD_FOLDER = "product_images";

    public Map buildUploadParams(Product product) {
        if (product == null || product.getId() == null)
            throw new DataInputException("Không thể upload hình ảnh của sản phẩm chưa được lưu");
        String publicId = String.format("%s/product_%d", UPLOAD_FOLDER, product.getId());
        return ObjectUtils.asMap(
                "public_id", publicId,
                "overwrite", true,
                "resource_type", "image"
        );
    }

    public Map buildDestroyParams(Product product) {
        if (product == null || product.getId() == null)
            throw new DataInputException("Không thể destroy hình ảnh của sản phẩm không xác định");
        String publicId = String.format("%s/product_%d", UPLOAD_FOLDER, product.getId());
        return ObjectUtils.asMap(
                "public_id", publicId,
                "overwrite", true,
                "resource_type", "image"
        );
    }
}
