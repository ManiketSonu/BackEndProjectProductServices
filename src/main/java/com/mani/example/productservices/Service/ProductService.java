package com.mani.example.productservices.Service;

/*
    *this will only have the function declaration.
 */

import com.mani.example.productservices.Model.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    public Product getProductById(Integer id);

    public Product createProduct(String title,
                              String description,
                              String price,
                              String Image,
                              String Category);

    public List<Product> getAllProducts();

    public Page<Product> getPaginatedProduct(int page, int size);
}
