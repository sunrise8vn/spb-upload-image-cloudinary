package com.cg.service;

import com.cg.model.ImageProduct;
import com.cg.model.Product;
import com.cg.repository.ImageProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;


@Service
@Transactional
public class ImageProductImpl implements IImageProductService {

    @Autowired
    private ImageProductRepository imageProductRepository;


    @Override
    public Iterable<ImageProduct> findAll() {
        return imageProductRepository.findAll();
    }

    @Override
    public ImageProduct create(ImageProduct imageProduct) {
        return imageProductRepository.save(imageProduct);
    }

    @Override
    public void delete(ImageProduct imageProduct) {
        imageProductRepository.delete(imageProduct);
    }

}
