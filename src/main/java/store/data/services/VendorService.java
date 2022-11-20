package store.data.services;

import store.data.dto.*;

public interface VendorService {
    VendorRegistrationResponse register(VendorRegistrationRequest vendorRequest);
    LoginResponse login(LoginRequest loginRequest);
    StoreProductResponse storage(StoreProductRequest storeProductRequest);
}
