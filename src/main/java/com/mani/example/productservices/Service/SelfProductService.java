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
    /*
    * private String title;
    private String description;
    private String price;
    private String imageURL;
    *
    * */
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
    public Product createProduct(String title, String description,
                                 String price, String imageUrl, String categoryTitle) {

        //s1. Find Category by title
        Category existingcategory = categoryRepo.findByTitle(categoryTitle);
        if(existingcategory==null)
        {
            existingcategory = new Category();
            existingcategory.setTitle(categoryTitle);
            existingcategory.setCreatedAt(new Date());
            existingcategory.setLastUpdatedAt(new Date());
            existingcategory.setDeleted(false);


            existingcategory =  categoryRepo.save(existingcategory);
            System.out.println("Category created successfully");
        }

        //s2. create the product..
        Product product = new Product();
        product.setCategory(existingcategory);
        product.setDescription(description);
        product.setTitle(title);
        product.setCreatedAt(new Date());
        product.setLastUpdatedAt(new Date());
        product.setImageURL(imageUrl);
        product.setPrice(price);
        product.setDeleted(false);

        //s3. save the product and return the product
        Product returnProduct = productRepo.save(product);
        return returnProduct;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    public Product getProductFromIdAndTitle(Integer id, String title) {
        Product product  = productRepo.getProductFromIdAndTitle(id, title);
        ProductProjection productProjection = productRepo.getTitleAndPriceProductFromId(id);
        productProjection.getPrice();

        return product;
    }

}
