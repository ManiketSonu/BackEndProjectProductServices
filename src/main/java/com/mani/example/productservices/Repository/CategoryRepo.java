package com.mani.example.productservices.Repository;

import com.mani.example.productservices.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
