package com.mani.example.productservices.Service;

import com.mani.example.productservices.Model.Product;
import com.mani.example.productservices.Repository.CategoryRepo;
import com.mani.example.productservices.Repository.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("SelfProductService")
public class SelfProductService implements ProductService{

    private ProductRepo productRepo;
    private CategoryRepo categoryRepo;

    public SelfProductService(ProductRepo productRepo, CategoryRepo categoryRepo) {
        this.productRepo = productRepo;
        this.categoryRepo = categoryRepo;
    }

    @Override
    public Product getProductById(Integer id) {
        Product product = productRepo.findProductById(id);
        return product;
    }

    @Override
    public Product createProduct(String title, String description, String Category,
                                 String Image, String price) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }
}
