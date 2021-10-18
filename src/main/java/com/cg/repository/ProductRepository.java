package com.cg.repository;

import com.cg.model.Product;
import com.cg.model.dto.IProductDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<Product, String> {


    @Query("SELECT " +
            "ip.product.id AS id, " +
            "ip.product.name AS name, " +
            "ip.product.description as description, " +
            "ip.imageName AS imageName, " +
            "ip.imageFolder AS imageFolder, " +
            "ip.imageUrl AS imageUrl " +
            "FROM ImageProduct ip " +
            "ORDER BY ip.product.ts ASC"
    )
    Iterable<IProductDTO> findAllIProductDTO();


    @Query("SELECT " +
            "ip.product.id AS id, " +
            "ip.product.name AS name, " +
            "ip.product.description as description, " +
            "ip.imageName AS imageName, " +
            "ip.imageFolder AS imageFolder, " +
            "ip.imageUrl AS imageUrl " +
            "FROM ImageProduct ip " +
            "WHERE ip.product.id = :id"
    )
    IProductDTO findIProductDTOById(@Param("id") String id);

}
