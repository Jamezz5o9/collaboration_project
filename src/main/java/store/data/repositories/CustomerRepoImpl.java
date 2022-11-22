package store.data.repositories;

import store.data.models.Customer;
import store.exceptions.CustomerNotFound;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CustomerRepoImpl implements CustomerRepo{
    private final List<Customer> customers = new ArrayList<>();
    @Override
    public Customer save(Customer customer) {
        int id = getNumberOfCustomers() + 1;
        customer.setId(id);
        customers.add(customer);
        return customer;
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        for (int i = 0; i < customers.size(); i++) {
            Customer getCustomer = customers.get(i);
            if(getCustomer.getId() == customer.getId()){
                customers.add(i, customer);
                return customer;
            }
        }
        throw new RuntimeException("Customer doesnt exist");
    }

    @Override
    public Customer findById(int id) {
        for (Customer customer: customers){
            if(id == customer.getId())return customer;
        }
        throw new CustomerNotFound("Customer doesnt exist");
    }

    @Override
    public Customer findByEmail(String email) {
        for (Customer customer: customers){
            if(Objects.equals(email, customer.getEmail()))return customer;
        }
        throw new CustomerNotFound("Customer doesnt exist");
    }

    @Override
    public int getNumberOfCustomers() {
        return customers.size();
    }

    @Override
    public void deleteById(int id) {
        for (Customer customer: customers){
            if(id == customer.getId()){
                customers.remove(customer);
                break;
            }
            else throw new CustomerNotFound("Customer doesnt exist");
        }


    }

    @Override
    public void deleteByEmail(String email) {
        for (Customer customer: customers){
            if(Objects.equals(email, customer.getEmail())){
                customers.remove(customer);
                break;
            }
            else throw new CustomerNotFound("Customer doesnt exist");
        }

    }
}
