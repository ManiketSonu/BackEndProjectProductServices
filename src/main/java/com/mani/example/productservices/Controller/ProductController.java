package com.mani.example.productservices.Controller;

import com.mani.example.productservices.Builder.ProductMapper;
import com.mani.example.productservices.DTO.CreateProductRequestDTO;
import com.mani.example.productservices.DTO.ProductResponseDTO;
import com.mani.example.productservices.Exception.InvalidProductIDException;
import com.mani.example.productservices.Exception.ProductNotFoundException;
import com.mani.example.productservices.Model.Product;
import com.mani.example.productservices.Service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController

//Wherever we have special class in spring this is called beans
public class ProductController {
    private ProductService productService;
    private ProductMapper mapper;

    //Injecting product service in controller
    public ProductController(@Qualifier("SelfProductService") ProductService svc, ProductMapper mapper) {
        this.productService = svc;
        this.mapper = mapper;
    }

    @PostMapping("/product")
    @CachePut(value = "product", condition = "#result.id !=null", key = "#result.id")
    public ProductResponseDTO createProduct(@RequestBody CreateProductRequestDTO dto) {
        //s1. Validate the request

        //s2. call the service layer
        Product product = productService.createProduct(dto.getTitle(),
                dto.getDescription(),
                dto.getCategory(),
                dto.getPrice(),
                dto.getImage());

        //s3. convert this to DTO
//        ProductResponseDTO productresponsedto = mapper.converToProductResponseDTO(product);
//        return productresponsedto;
        ProductResponseDTO responseDTO = mapper.converToProductResponseDTO(product);
        return responseDTO;
    }

    @GetMapping("/products")
    public List<ProductResponseDTO> getAllProducts() {
        List<Product> productList = productService.getAllProducts();
        if (productList == null || productList.size() == 0) {
            return null;
        }
        List<ProductResponseDTO> response = new ArrayList<>();

        //converting model to dtosList..
        for (Product p : productList) {
            response.add(mapper.converToProductResponseDTO(p));
        }
        return response;
    }

    @GetMapping("/product/{id}")
    @Cacheable(value = "product", key = "#id")
    public ProductResponseDTO getProductById(@PathVariable("id") Integer id)
            throws InvalidProductIDException, ProductNotFoundException {
//        validateRequestParams(id);
        if (id == null) {
            System.out.println("Inside controller");
            //throw an exception
//            System.out.println("id is null");
            throw new InvalidProductIDException("some message");
        }

        //s1. call to service layer
        Product product = productService.getProductById(id);
        if (product == null) {
            System.out.println("Inside controller2");
            throw new ProductNotFoundException();
        }
        //s2. map to response DTO
        ProductResponseDTO response = mapper.converToProductResponseDTO(product);

        //s3. Return
        return response;
    }

//    @GetMapping("/product/{id}/{title}")
//    public ProductResponseDTO getProductusingIdAndTitle(@PathVariable("id") Integer id,
//                                                        @PathVariable("title") String title)
//            throws ProductNotFoundException {
//
//        if (id == null) {
//            throw new ProductNotFoundException("Give the ID");
//        }
//        Product product = productService.getProductByIdAndTitle(id, title);
//
//        return mapper.converToProductResponseDTO(product);
//    }

    private void validateRequestParams(Long id) {
        if (id == null) {
            //trow an exception
        }
    }

    @DeleteMapping("/products/{id}")
    @CacheEvict(value = "product", key = "#id")
    public void deleteProduct(@PathVariable("id") Long id) {

    }

    @GetMapping("/products/{page}/{size}")
    public ResponseEntity<List<Product>> getPaginatedProduct(@PathVariable("page") Integer page
                                            , @PathVariable("size") Integer size){
        Page<Product> products = productService.getPaginatedProduct(page, size);
        System.out.println("Received product: "+products);
        return ResponseEntity.ok(products.getContent());
    }
}
