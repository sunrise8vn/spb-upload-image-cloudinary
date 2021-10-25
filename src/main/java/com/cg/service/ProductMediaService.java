package com.cg.service;

import com.cg.model.ProductMedia;

public interface ProductMediaService {

    Iterable<ProductMedia> findAll();

    ProductMedia create(ProductMedia productMedia);

    void delete(ProductMedia productMedia);
}
