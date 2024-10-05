package com.mani.example.productservices.Scheduled;

import com.mani.example.productservices.Model.Product;
import com.mani.example.productservices.Service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DBFetcherPerMinute {
    private ProductService productService;
    public DBFetcherPerMinute(@Qualifier("SelfProductService") ProductService productService) {
        this.productService = productService;
    }

    @Scheduled(cron = "0 * * * * *")
    public void execute()
    {
        Product product = productService.getProductById(6);
        System.out.println("Product is: " + product.getId());
    }
}
