package store.data.services;

import store.data.dto.*;

public interface CustomerService {

    CustomerRegistrationResponse register(CustomerRegistrationRequest customerRegistrationRequest);

    LoginResponse login(LoginRequest loginRequest);

    ProductOrderResponse orderProduct(ProductOrderRequest productOrderRequest);

}
