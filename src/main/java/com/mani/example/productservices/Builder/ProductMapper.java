package com.mani.example.productservices.Builder;

import com.mani.example.productservices.DTO.FakeStoreProductDTO;
import com.mani.example.productservices.DTO.ProductResponseDTO;
import com.mani.example.productservices.Model.Category;
import com.mani.example.productservices.Model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public ProductResponseDTO converToProductResponseDTO(Product product) {
        ProductResponseDTO dto = new ProductResponseDTO();
        dto.setCategory(product.getCategory());
        dto.setDescription(product.getDescription());
        dto.setId(product.getId());
        dto.setPrice(product.getPrice());
        dto.setTitle(product.getTitle());

        if(product.getId()!=null)
        {
            System.out.println("Inside product mapper");
            dto.setId(product.getId());
        }
        return dto;
    }

    public Product mapToProduct(FakeStoreProductDTO dto)
    {
        Product product = new Product();
        Category category  = new Category();
        category.setTitle(dto.getCategory());

        product.setCategory(category);
        product.setTitle(dto.getTitle());
        product.setId(dto.getId());
        product.setImageURL(dto.getImage());
        product.setPrice(String.valueOf((dto.getPrice())));
        product.setDescription(dto.getDescription());
        return product;
    }
}
