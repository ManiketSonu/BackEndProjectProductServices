package com.mani.example.productservices.Repository;

import com.mani.example.productservices.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Integer> {

    List<Product> findAll();

//    Product findById();

    Product findProductById(Integer id);
    Product findByDescription(String description);

    Product save(Product p);
}
