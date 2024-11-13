package com.hernandes.andrade.study.productapi.service;

import com.hernandes.andrade.study.productapi.dto.ProductDTO;
import com.hernandes.andrade.study.productapi.model.Product;
import com.hernandes.andrade.study.productapi.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<ProductDTO> getAll() {
        List<Product> products = productRepository.findAll();
        return products
                .stream()
                .map(ProductDTO::convert)
                .collect(Collectors.toList());
    }
}
