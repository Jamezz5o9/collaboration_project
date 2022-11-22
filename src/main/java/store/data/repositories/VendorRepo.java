package store.data.repositories;

import store.data.models.Product;
import store.data.models.Vendor;

import java.util.List;

public interface VendorRepo {
   Vendor save(Vendor vendor);
   Vendor findById(int id);
   Vendor findByEmail(String email);
   List<Vendor> findAll();
   void delete(Vendor vendor);
   void deleteByEmail(String email);
}
