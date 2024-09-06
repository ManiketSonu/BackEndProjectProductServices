package com.mani.example.productservices;
//import com.mani.example.productservices.Repository.Projection.ProductProjection;
import com.mani.example.productservices.Model.Category;
import com.mani.example.productservices.Repository.CategoryRepo;
import com.mani.example.productservices.Repository.ProductRepo;
import com.mani.example.productservices.Repository.Projection.ProductProjection;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProductServicesApplicationTests {

	@Autowired
	private ProductRepo productRepository;

	@Autowired
	private CategoryRepo categoryRepository;

//	@Test
//	@Transactional
	void contextLoads() {

	}

    @Test
    @Transactional
    void testingQueries()
    {
		List<ProductProjection> list = productRepository.
                getTitleAndPriceProductFromTitle("phone charger");
        System.out.println(list.get(0).getId());
        System.out.println(list.get(0).getPrice());

        List<ProductProjection> list1 = productRepository.
                getTitleAndPriceProductFromTitle("Google pixle pro");
        System.out.println(list1.get(0).getId());
        System.out.println(list1.get(0).getPrice());
        System.out.println(list1.get(0).getDescription());

        Category cat = categoryRepository.findByTitle("Mobile");
        System.out.println(cat);
        System.out.println(cat.getProducts());
        System.out.println(cat);

    }
}
