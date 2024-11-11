package com.hernandes.andrade.study.productapi.repository;

import com.hernandes.andrade.study.productapi.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
