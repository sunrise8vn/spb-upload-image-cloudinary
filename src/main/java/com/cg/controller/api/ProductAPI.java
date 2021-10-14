package com.cg.controller.api;


import com.cg.exception.DataInputException;
import com.cg.model.Product;
import com.cg.model.dto.ProductDTO;
import com.cg.service.IProductService;
import com.cg.util.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/api/products")
public class ProductAPI {

    @Autowired
    IProductService productService;

    @GetMapping
    public ResponseEntity<Iterable<?>> findAll() {
        try {
            Iterable<Product> products = productService.findAll();

            if (((List) products).isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(products, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<?> create(ProductDTO productDTO) {

//        String fileName = fileImage.getOriginalFilename();
//        String email = product.getEmail();

        try {
//            String uploadDir = "./uploads/";

//            FileUploadUtil.saveFile(uploadDir, fileName, fileImage);

//            productDTO.setImage(fileName);

            Product createdProduct = productService.create(productDTO);

            return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);

        } catch (DataIntegrityViolationException e) {
            throw new DataInputException("Product creation information is not valid, please check the information again");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws IOException {

        try {
            productService.delete(id);

            return new ResponseEntity<>(HttpStatus.ACCEPTED);

        } catch (DataIntegrityViolationException e) {
            throw new DataInputException("Invalid product information");
        }
    }

}
