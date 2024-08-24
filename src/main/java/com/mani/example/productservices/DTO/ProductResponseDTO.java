package com.mani.example.productservices.DTO;

import com.mani.example.productservices.Model.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDTO {
    private Integer id;
    private String title;
    private String description;
    private String price;
    private String imageURL;
    private Category category;
}
