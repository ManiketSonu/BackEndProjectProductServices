package com.mani.example.productservices.Repository;

import com.mani.example.productservices.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
    Category findByTitle(String title);
}


//public interface CategoryRepo extends PagingAndSortingRepository<Category, Integer> {
//    Category findByTitle(String title);
//}