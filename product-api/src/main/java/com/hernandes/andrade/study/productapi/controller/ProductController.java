package com.hernandes.andrade.study.productapi.controller;

import com.hernandes.andrade.study.productapi.dto.ProductDTO;
import com.hernandes.andrade.study.productapi.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<ProductDTO> getProducts() {
        return productService.getAll();
    }

    @GetMapping("/category/{categoryId}")
    public List<ProductDTO> getProductsByCategory(@PathVariable Long categoryId) {
        return productService.getProductsByCategory(categoryId);
    }

    @GetMapping("/{productIdentifier}")
    public ProductDTO findById(@PathVariable String productIdentifier) {
        return productService.findByProductIdentifier(productIdentifier);
    }

    @PostMapping
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO) {
        return productService.save(productDTO);
    }

    @DeleteMapping("/{id}")
    public ProductDTO delete(@PathVariable Long id) {
        return productService.delete(id);
    }

    @PostMapping("/{id}")
    public ProductDTO editProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        return productService.editProduct(id, productDTO);
    }

    @GetMapping("/pageable")
    public Page<ProductDTO> getProductsPage(Pageable pageable) {
        return productService.getAllPage(pageable);
    }

}
