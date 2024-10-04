package com.mani.example.productservices.Service;

import com.mani.example.productservices.Builder.ProductMapper;
import com.mani.example.productservices.DTO.FakeStoreProductDTO;
import com.mani.example.productservices.Model.Category;
import com.mani.example.productservices.Model.Product;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("FakeStoreService")
public class FakeStoreService implements ProductService{

    private RestTemplate restTemplate;
    private ProductMapper mapper;

    public FakeStoreService(RestTemplate restTemplate, ProductMapper mapper) {
        this.restTemplate = restTemplate;
        this.mapper = mapper;
    }

    @Override
    public Product getProductById(Integer id)
    {
//        System.out.print("I am Inside Service and bhai calling fakestore service");
        /*
            1. call to fake store api
            2. get the response
            3. Map the response to our model
            4. return the model service layer
         */
        //s1. call the API
        ResponseEntity<FakeStoreProductDTO> response = restTemplate.
                getForEntity("https://fakestoreapi.com/products/"+id,
                        FakeStoreProductDTO.class);

        if(response==null || response.getBody()==null)
        {
            //throw an exception..
            return null;
        }
        //s2. Get the response
        FakeStoreProductDTO fakeStoreProductDTO = response.getBody();

        //s3. Map the response to our model (i did in FakeStoreProductDTO)

        //s4. finally return
        return mapper.mapToProduct(fakeStoreProductDTO);
    }

    public Product mapToProduct(FakeStoreProductDTO dto)
    {
        Product product = new Product();
        Category category = new Category();
        category.setTitle(dto.getCategory());

        product.setCategory(category);
        product.setTitle(dto.getTitle());
        product.setId(dto.getId());
        product.setImageURL(dto.getImage());
        product.setPrice(String.valueOf(dto.getPrice()));
        product.setDescription(dto.getDescription());
        return product;
    }

    @Override
    public Product createProduct(String title,
                              String description,
                              String Category,
                              String Image,
                              String price) {
        // S1. Create FakeStore DTO Object
        FakeStoreProductDTO requestBody = new FakeStoreProductDTO();
        requestBody.setTitle(title);
        requestBody.setDescription(description);
//        requestBody.setImage(Image);
        requestBody.setPrice(String.valueOf(price));
        requestBody.setCategory(Category);

        // S2. Call FakeStore API
        FakeStoreProductDTO response = restTemplate.postForObject("https://fakestoreapi.com/products",
                requestBody, FakeStoreProductDTO.class);


        // S3. Get ProductModel
        Product product = mapper.mapToProduct(response);

        // S4. Return Product
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        ResponseEntity<FakeStoreProductDTO[]> responseEntity = restTemplate.getForEntity(
                "https://fakestoreapi.com/products",
                FakeStoreProductDTO[].class);

        FakeStoreProductDTO[] dtos = responseEntity.getBody();
        if(dtos==null || dtos.length==0)
        {
            System.out.print("Something went wrong");
            return new ArrayList<>();
        }

        //create product
        for(FakeStoreProductDTO dto : dtos)
        {
            Product product = mapper.mapToProduct(dto);
            products.add(product);
        }
        return products;
    }

    @Override
    public Page<Product> getPaginatedProduct(int page, int size) {
        return null;
    }
}
