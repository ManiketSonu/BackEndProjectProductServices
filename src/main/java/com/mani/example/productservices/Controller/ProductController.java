package com.mani.example.productservices.Controller;

import com.mani.example.productservices.Builder.ProductMapper;
import com.mani.example.productservices.DTO.CreateProductRequestDTO;
import com.mani.example.productservices.DTO.ProductResponseDTO;
import com.mani.example.productservices.Exception.InvalidProductIDException;
import com.mani.example.productservices.Exception.ProductNotFoundException;
import com.mani.example.productservices.Model.Product;
import com.mani.example.productservices.Service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
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
    public ProductResponseDTO createProduct(@RequestBody CreateProductRequestDTO dto)
    {
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
        return mapper.converToProductResponseDTO(product);
    }

    @GetMapping("/products")
    public List<ProductResponseDTO> getAllProducts()
    {
        List<Product> productList = productService.getAllProducts();
        if(productList==null || productList.size()==0)
        {
            return null;
        }
        List<ProductResponseDTO> response = new ArrayList<>();

        //converting model to dtosList..
        for(Product p:productList)
        {
            response.add(mapper.converToProductResponseDTO(p));
        }
        return response;
    }

    @GetMapping("/product/{id}")
    public ProductResponseDTO getProductById(@PathVariable("id") Integer id)
            throws InvalidProductIDException, ProductNotFoundException {
//        validateRequestParams(id);
        if(id==null)
        {
            System.out.println("Inside controller");
            //throw an exception
//            System.out.println("id is null");
            throw  new InvalidProductIDException("some message");
        }

        //s1. call to service layer
        Product product = productService.getProductById(id);
        if(product==null)
        {
            System.out.println("Inside controller2");
            throw new ProductNotFoundException();
        }
        //s2. map to response DTO
        ProductResponseDTO response = mapper.converToProductResponseDTO(product);

        //s3. Return
        return response;
    }

    private void validateRequestParams(Long id) {
        if(id==null)
        {
            //trow an exception
        }
    }


//    private ProductResponseDTO converToProductResponseDTO(Product product) {
//        ProductResponseDTO dto = new ProductResponseDTO();
//        dto.setCategory(product.getCategory());
//        dto.setDescription(product.getDescription());
//        dto.setId(product.getId());
//        dto.setPrice(product.getPrice());
//        dto.setTitle(product.getTitle());
//
//        if(product.getId()!=null)
//        {
//            dto.setId(product.getId());
//        }
//        return dto;
//    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable("id") Long id)
    {

    }
}
