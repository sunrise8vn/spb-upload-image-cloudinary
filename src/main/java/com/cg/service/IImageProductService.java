package com.cg.service;

import com.cg.model.ImageProduct;
import com.cg.model.Product;

import java.io.IOException;

public interface IImageProductService {
    Iterable<ImageProduct> findAll();

    ImageProduct create(ImageProduct imageProduct);

    void delete(ImageProduct imageProduct);

}
