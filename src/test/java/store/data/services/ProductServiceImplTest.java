package store.data.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import store.data.dto.AddProductRequest;
import store.data.dto.AddProductResponse;
import store.data.models.Product;
import store.data.repositories.ProductRepository;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceImplTest {
    private ProductService productService;
    private AddProductRequest productRequest;


    @BeforeEach
    void setUp(){
       productService = new ProductServiceImpl();
       productRequest = new AddProductRequest();
       productRequest.setName("Orange");
       productRequest.setQuantity(4);
       productRequest.setCategory("FRUITS");
       productRequest.setPrice(200.00);
    }

    @Test
    void orderProduct() {
        AddProductResponse response = productService.orderProduct(productRequest);
        assertNotNull(response);
        assertEquals("Orange", response.getProductName());
        assertNotNull(response.getMessage());
    }

    @Test
    void getProductByName() {
        AddProductResponse response = productService.orderProduct(productRequest);
        Product product = productService.getProductByName(response.getProductName());
        assertNotNull(product);
    }
}