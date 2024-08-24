package com.mani.example.productservices.Service;

/*
    *this will only have the function declaration.
 */

import com.mani.example.productservices.Model.Product;

import java.util.List;

public interface ProductService {
    public Product getProductById(Long id);

    public Product createProduct(String title,
                              String description,
                              String Category,
                              String Image,
                              String price);

    public List<Product> getAllProducts();
}
