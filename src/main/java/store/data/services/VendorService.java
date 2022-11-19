package store.data.services;

import store.data.dto.LoginRequest;
import store.data.dto.LoginResponse;
import store.data.dto.VendorRegistrationRequest;
import store.data.dto.VendorRegistrationResponse;

public interface VendorService {
    VendorRegistrationResponse register(VendorRegistrationRequest vendorRequest);
    LoginResponse login(LoginRequest loginRequest);
    StoreProductResponse storage(StoreProductRequest storeProductRequest);
}
