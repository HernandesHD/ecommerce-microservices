package com.hernandes.andrade.study.productapi.repository;

import com.hernandes.andrade.study.productapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "select p "
            + "from product p "
            + "join category c on p.category.id = c.id "
            + "where c.id = :categoryId ")
    public List<Product> getProductByCategory(@Param("categoryId") Long categoryId);

    public Product findByProductIdentifier(String productIdentifier);
}
