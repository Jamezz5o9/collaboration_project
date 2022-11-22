package store.data.services;

import store.data.dto.*;
import store.data.models.Customer;
import store.data.models.Product;
import store.data.repositories.CustomerRepo;
import store.data.repositories.CustomerRepoImpl;
import store.exceptions.CustomerNotFound;
import store.utils.validators.UserDetailsValidator;

import java.util.Objects;

public class CustomerServiceImpl implements CustomerService{
    private CustomerRepo customerRepo = new CustomerRepoImpl();
    private ProductService productService = new ProductServiceImpl();
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
        Customer foundCustomer = customerRepo.findByEmail(loginRequest.getEmail());
        if (Objects.equals(foundCustomer.getPassword(), loginRequest.getPassword())){
            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setMessage("login successful");
            return loginResponse;
        }
        else throw new CustomerNotFound("Invalid login details provided");
    }

    @Override
    public ProductOrderResponse orderProduct(ProductOrderRequest productOrderRequest) {
        Customer foundCustomer = customerRepo.findById(productOrderRequest.getCustomerId());
        ProductOrderResponse productOrderResponse = new ProductOrderResponse();
        if (foundCustomer != null){

            Product product = productService.getProductByName(productOrderRequest.getProductName());

            if (product.getQuantity() < productOrderRequest.getQuantity())productOrderResponse.setMessage("Insufficient product");
            else {
                int newProductQuantity = product.getQuantity() - productOrderRequest.getQuantity();
                Product orderedProduct = new Product();
                orderedProduct.setQuantity(productOrderRequest.getQuantity());
                orderedProduct.setName(productOrderRequest.getProductName());
                orderedProduct.setCategory(productOrderRequest.getCategory());
                foundCustomer.getOrders().add(orderedProduct);
                productOrderResponse.setMessage("Order successful");
            }
        }
        return productOrderResponse;

    }
}
