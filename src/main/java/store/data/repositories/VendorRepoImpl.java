package store.data.repositories;

import store.data.models.Address;
import store.data.models.Vendor;
import store.exceptions.StoreException;
import store.exceptions.VendorNotFound;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class VendorRepoImpl implements VendorRepo{
    private final List<Vendor> vendorList = new ArrayList<>();

    @Override
    public Vendor save(Vendor vendor) {
        int id = generateId();
        vendor.setId(id);
        vendorList.add(vendor);
        return  vendor;
    }

    private int generateId() {
        int newId = vendorList.size();
        return newId + 1;
    }

    @Override
    public Vendor findById(int id) {
        for (Vendor vendor : vendorList) {
            if (vendor.getId() == id) return vendor;
        }
        throw new VendorNotFound("Couldn't find store");

    }

    @Override
    public List<Vendor> findAll() {
        return vendorList;
    }

    @Override
    public void delete(Vendor vendor) {
      vendorList.remove(vendor);
    }

    @Override
    public void deleteByEmail(String email) {
        for(int i = 0; i < vendorList.size(); i++){
            if(Objects.equals(vendorList.get(i).getEmail(), email)) vendorList.remove(vendorList.get(i));
        }
        throw new VendorNotFound("Vendor doesn't exist");
    }
}
