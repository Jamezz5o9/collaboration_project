package store.data.services;

import store.data.dto.*;
import store.data.models.Customer;
import store.data.repositories.CustomerRepo;
import store.data.repositories.CustomerRepoImpl;
import store.utils.validators.UserDetailsValidator;

public class CustomerServiceImpl implements CustomerService{
    private CustomerRepo customerRepo = new CustomerRepoImpl();
    @Override
    public CustomerRegistrationResponse register(CustomerRegistrationRequest customerRegistrationRequest) {
        boolean isValidEmail = UserDetailsValidator.isValidEmail(customerRegistrationRequest.getEmail());
        boolean isValidPhoneNumber = UserDetailsValidator.isValidPhoneNumber(customerRegistrationRequest.getPhoneNumber());
        boolean isValidPassword = UserDetailsValidator.isValidPassword(customerRegistrationRequest.getPassword());

        if (isValidEmail && isValidPhoneNumber && isValidPassword){
            Customer customer = buildCustomer(customerRegistrationRequest);
            Customer savedCustomer = customerRepo.save(customer);
            CustomerRegistrationResponse response = getCustomerRegistrationResponse(savedCustomer);
            return response;
        }
        return null;
    }

    private CustomerRegistrationResponse getCustomerRegistrationResponse(Customer savedCustomer) {
        CustomerRegistrationResponse response = new CustomerRegistrationResponse();
        response.setId(savedCustomer.getId());
        response.setStatusCode("201");
        response.setMessage("Registration successful");
        return response;
    }

    private Customer buildCustomer(CustomerRegistrationRequest customerRegistrationRequest) {
        Customer customer = new Customer();
        customer.setEmail(customerRegistrationRequest.getEmail());
        customer.setPhoneNumber(customerRegistrationRequest.getPassword());
        customer.setPassword(customerRegistrationRequest.getPassword());
        return customer;
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        return null;
    }

    @Override
    public ProductOrderResponse orderProduct(ProductOrderRequest productOrderRequest) {
        return null;
    }
}
