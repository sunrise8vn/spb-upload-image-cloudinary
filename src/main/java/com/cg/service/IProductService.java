package com.cg.service;


import com.cg.model.Product;
import com.cg.model.dto.ProductDTO;

import java.io.IOException;

public interface IProductService {

    Iterable<Product> findAll();

    Product create(ProductDTO productDTO);

    void delete(Long id) throws IOException;
}
