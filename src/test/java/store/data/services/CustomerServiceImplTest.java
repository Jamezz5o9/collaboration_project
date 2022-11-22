package store.data.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import store.data.dto.*;
import store.data.models.Customer;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CustomerServiceImplTest {
    private CustomerService customerService;
    private CustomerRegistrationRequest customerRegistrationRequest;

    private LoginRequest loginRequest;

    private ProductService productService;
    private AddProductRequest addProductRequest;
    private ProductOrderRequest productOrderRequest;


    @BeforeEach
    void setUp() {
        customerService = new CustomerServiceImpl();
        customerRegistrationRequest = new CustomerRegistrationRequest();
        customerRegistrationRequest.setPhoneNumber("08065923833");
        customerRegistrationRequest.setEmail("kabir@gmail.com");
        customerRegistrationRequest.setPassword("Kunde&8760");

        loginRequest = new LoginRequest();
        loginRequest.setEmail("kabir@gmail.com");
        loginRequest.setPassword("Kunde&8760");








    }

    @Test
    void register() {
        CustomerRegistrationResponse response = customerService.register(customerRegistrationRequest);
        assertEquals(1, response.getId());
        assertEquals("Registration successful", response.getMessage());
    }

    @Test
    void login() {
        customerService.register(customerRegistrationRequest);
        LoginResponse response = customerService.login(loginRequest);
        assertEquals("login successful", response.getMessage());
    }

    @Test
    void orderProduct() {
        productService = new ProductServiceImpl();
        addProductRequest = new AddProductRequest();
        productOrderRequest = new ProductOrderRequest();
        addProductRequest.setName("milk");
        addProductRequest.setQuantity(5);
        addProductRequest.setPrice(BigDecimal.valueOf(30));
        productService.addProduct(addProductRequest);
        CustomerRegistrationResponse response = customerService.register(customerRegistrationRequest);
        productOrderRequest.setCustomerId(response.getId());
        productOrderRequest.setProductName("milk");
        productOrderRequest.setQuantity(2);
        ProductOrderResponse productOrderResponse = customerService.orderProduct(productOrderRequest);
        assertEquals("Product order successful", productOrderResponse.getMessage());
    }
}