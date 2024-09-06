package com.mani.example.productservices.Service;

import com.mani.example.productservices.Model.Category;
import com.mani.example.productservices.Model.Product;
import com.mani.example.productservices.Repository.CategoryRepo;
import com.mani.example.productservices.Repository.ProductRepo;
import com.mani.example.productservices.Repository.Projection.ProductProjection;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    public Product createProduct(String title, String price, String category, String description,
                                  String image) {
        Category existingCategory = categoryRepo.findByTitle(category);

        if(existingCategory==null)
        {
            existingCategory = new Category();
            existingCategory.setTitle(category);
            existingCategory.setCreatedAt(new Date());
            existingCategory.setLastUpdatedAt(new Date());
            existingCategory.setDeleted(false);

            existingCategory = categoryRepo.save(existingCategory);
            System.out.println("category is created");
        }
        Product product = new Product();
        product.setCategory(existingCategory);
        product.setDescription(description);
        product.setTitle(title);
        product.setCreatedAt(new Date());
        product.setLastUpdatedAt(new Date());
        product.setImageURL(image);
        product.setPrice(price);
        product.setDeleted(false);

        Product returnProduct= productRepo.save(product);
        return returnProduct;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    public Product getProductByIdAndTitle(Integer id, String title) {
        Product product = productRepo.getProductFromIdAndTitle(id, title);
        ProductProjection productProjection = productRepo.getTitleAndPriceProductFromId(id);
        return product;
    }
}
