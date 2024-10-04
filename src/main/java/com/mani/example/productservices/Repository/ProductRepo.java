package com.mani.example.productservices.Repository;

import com.mani.example.productservices.Model.Product;
import com.mani.example.productservices.Repository.Projection.ProductProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Integer> {
    List<Product> findAll();

    Product findProductById(Integer id);

    Product findByDescription(String description);

    Product save(Product p);

    List<Product> findAllByCategory_TitleEquals(String title);

    /*
    * Get a Product from id and title
    * */
    @Query("select p from Product p where p.id = :id and p.title = :title")
    Product getProductFromIdAndTitle(@Param("id") Integer id, @Param("title") String title);

    /*
    * Get Title and Id, Return something called as Projection
    * */
    @Query("select p.id as id, p.title as title, p.price as price from Product p where p.id = :id")
    ProductProjection getTitleAndPriceProductFromId(@Param("id") Integer id);

    @Query("select p.id as id,  p.price as price from Product p where p.title = :title")
    List<ProductProjection> getTitleAndPriceProductFromTitle(@Param("title") String title);


}
