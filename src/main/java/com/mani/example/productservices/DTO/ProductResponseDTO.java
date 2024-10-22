package com.mani.example.productservices.DTO;

import com.mani.example.productservices.Model.Category;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ProductResponseDTO implements Serializable {
    private Integer id;
    private String title;
    private String description;
    private String price;
    private String imageURL;
    private Category category;
}
