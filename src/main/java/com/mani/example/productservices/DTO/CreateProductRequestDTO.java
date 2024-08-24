package com.mani.example.productservices.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductRequestDTO {
    private String title;
    private String price;
    private String category;
    private String description;
    private String image;
}
