package com.mani.example.productservices;
//import com.mani.example.productservices.Repository.Projection.ProductProjection;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProductServicesApplicationTests {

//	@Autowired
//	private ProductRepo productRepository;

//	@Autowired
//	private CategoryRepo categoryRepository;

//	@Test
//	@Transactional
//	void contextLoads() {
////		List<ProductProjection> list = productRepository.getTitleAndPriceProductFromTitle("Test");
////		System.out.println(list.get(0).getPrice());
//		List<ProductProjection> pros = productRepository.getIdAndPriceFromProductTitle("phone charger");
////		System.out.println(pros.size());
//		System.out.println(pros.get(0).getId());
////		System.out.println(pros.get(0).getPrice());
//	}

}
