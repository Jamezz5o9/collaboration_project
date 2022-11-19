package store.data.repositories;

import store.data.models.Customer;

public interface CustomerRepo {
    Customer save(Customer customer);
    Customer updateCustomer(Customer customer);
    Customer findById(int id);
    Customer findByEmail(String email);
    int getNumberOfCustomers();
    void deleteById(int id);
    void deleteByEmail(String email);
}
