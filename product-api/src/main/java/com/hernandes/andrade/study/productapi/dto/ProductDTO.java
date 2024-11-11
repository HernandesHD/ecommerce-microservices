package com.hernandes.andrade.study.productapi.dto;

import com.hernandes.andrade.study.productapi.model.Category;
import com.hernandes.andrade.study.productapi.model.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    @NotBlank
    private String productIdentifier;
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotNull
    private Float price;
    @NotNull
    private CategoryDTO categoryDTO;

    public static ProductDTO convert(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        productDTO.setProductIdentifier(product.getProductIdentifier());
        productDTO.setDescription(product.getDescription());
        if (product.getCategory() != null) {
            productDTO.setCategoryDTO(CategoryDTO.convert(product.getCategory()));
        }
        return productDTO;
    }
}
