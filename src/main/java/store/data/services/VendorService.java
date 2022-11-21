package store.data.services;

import store.data.dto.*;
import store.data.models.Product;

public interface VendorService {
    VendorRegistrationResponse register(VendorRegistrationRequest vendorRequest);
    LoginResponse login(LoginRequest loginRequest);
    void delete(Product product);
    Product update(Product product);
}
