package com.mani.example.productservices.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Product extends BaseModel implements Serializable {
    private String title;
    private String description;
    private String price;
    private String imageURL;
    private String productAddress;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    private Category category;
}
