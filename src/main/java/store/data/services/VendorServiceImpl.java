package store.data.services;

import store.data.dto.*;
import store.data.models.Product;
import store.data.models.Vendor;
import store.data.repositories.VendorRepo;
import store.data.repositories.VendorRepoImpl;
import store.exceptions.InvalidLoginDetails;

import java.util.Objects;

public class VendorServiceImpl implements VendorService {
    private final VendorRepo vendorRepository = new VendorRepoImpl();

    @Override
    public VendorRegistrationResponse register(VendorRegistrationRequest vendorRequest) {
        Vendor vendor = new Vendor();
        vendor.setStoreName(vendorRequest.getName());
        vendor.setEmail(vendorRequest.getEmail());
        vendor.setPassword(vendorRequest.getPassword());
        VendorRepo vendorRepo = new VendorRepoImpl();
        var savedVendor = vendorRepo.save(vendor);

        VendorRegistrationResponse response = new VendorRegistrationResponse();
        response.setVendorId(savedVendor.getId());
        response.setMessage("Vendor registration completed successfully");
        response.setStatus(200);
        return response;
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        Vendor vendor = vendorRepository.findByEmail(loginRequest.getEmail());
        LoginResponse response = new LoginResponse();

        if (Objects.equals(vendor.getPassword(), loginRequest.getPassword())) {
            response.setMessage("Login successful");
            return response;
        }
        response.setMessage("Authentication Failed");
        return response;
    }

    @Override
    public void delete(Product product) {

    }

    @Override
    public Product update(Product product) {
        return null;
    }

}

