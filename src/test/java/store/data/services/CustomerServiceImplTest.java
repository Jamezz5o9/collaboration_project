package store.data.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import store.data.dto.CustomerRegistrationRequest;
import store.data.dto.CustomerRegistrationResponse;
import store.data.dto.LoginRequest;
import store.data.dto.LoginResponse;
import store.data.models.Customer;

import static org.junit.jupiter.api.Assertions.*;

class CustomerServiceImplTest {
    private CustomerService customerService;
    private CustomerRegistrationRequest customerRegistrationRequest;

    private LoginRequest loginRequest;


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
    }
}