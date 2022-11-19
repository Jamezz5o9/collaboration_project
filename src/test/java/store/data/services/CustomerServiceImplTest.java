package store.data.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import store.data.dto.CustomerRegistrationRequest;
import store.data.dto.CustomerRegistrationResponse;
import store.data.models.Customer;

import static org.junit.jupiter.api.Assertions.*;

class CustomerServiceImplTest {
    private CustomerService customerService;
    private CustomerRegistrationRequest customerRegistrationRequest;


    @BeforeEach
    void setUp() {
        customerService = new CustomerServiceImpl();
        customerRegistrationRequest = new CustomerRegistrationRequest();
        customerRegistrationRequest.setPhoneNumber("08065923833");
        customerRegistrationRequest.setEmail("kabir@gmail.com");
        customerRegistrationRequest.setPassword("Kunde&8760");


    }

    @Test
    void register() {
        CustomerRegistrationResponse response = customerService.register(customerRegistrationRequest);
        assertEquals(1, response.getId());
        assertEquals("Registration successful", response.getMessage());
    }

    @Test
    void login() {
    }

    @Test
    void orderProduct() {
    }
}