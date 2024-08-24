package com.mani.example.productservices.Model;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Category extends BaseModel implements Serializable {
//    private int id;
    private String title;
}
