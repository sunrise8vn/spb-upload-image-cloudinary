package com.cg.repository;

import com.cg.model.ImageProduct;
import com.cg.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ImageProductRepository extends JpaRepository<ImageProduct, String> {


    void deleteByProduct(Product product);

    void deleteByProduct_Id(String productId);

    void deleteByCloudId(String cloudId);

    Optional<ImageProduct> findByProduct(Product product);
}
