package com.mani.example.productservices.Repository;

import com.mani.example.productservices.Model.Product;
import com.mani.example.productservices.Repository.Projection.ProductProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Integer> {

    List<Product> findAll();

//    Product findById();

    Product findProductById(Integer id);
    Product findByDescription(String description);

    Product save(Product p);

    //SYNTAX for joins using JPA methods
    List<Product> findAllByCategory_NameEquals(String name);

    /*
     * get a product from id and title
     * */
    @Query("select p from Product p where p.id = :id and p.title = :title")
    Product getProductFromIdAndTitle(@Param("id") Integer id, @Param("title") String title);

    /*
     * get title and id
     * */
    @Query("select p.id, p.title, p.price from Product p where p.id = :id")
    ProductProjection getTitleAndPriceProductFromId(@Param("id") Integer id);

    @Query("select p.id, p.price from Product p where p.title = :title")
    List<ProductProjection> getTitleAndPriceProductFromTitle(@Param("title") String title);
}
