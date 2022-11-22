package store.data.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import store.data.models.Address;
import store.data.models.Category;
import store.data.models.Customer;
import store.data.models.Product;

import java.lang.invoke.CallSite;

import static org.junit.jupiter.api.Assertions.*;

class CustomerRepoImplTest {
    private CustomerRepo customerRepo;
    private Customer customerOne;
    private Customer customerTwo;
    private Address address;

    private Product product;

    @BeforeEach
    void setUp() {
        customerRepo = new CustomerRepoImpl();
        customerOne = new Customer();
        customerTwo = new Customer();
        address = new Address();
        product = new Product();
        address.setStreetNumber("12");
        address.setStreetName("Ibadan");
        address.setCity("Abuja");
        address.setZipcode("1234");

        customerOne.setAddress(address);
        customerOne.setEmail("kabir@gmail.com");
        customerOne.setFirstName("Kabir");
        customerOne.setLastName("Yusuf");
        customerOne.setPhoneNumber("0987654");
        customerOne.setPassword("12345");

        customerTwo.setAddress(address);
        customerTwo.setFirstName("James");
        customerTwo.setLastName("Ade");
        customerTwo.setPassword("23456");
        customerTwo.setPhoneNumber("8908765");
        customerTwo.setEmail("james@gmail.com");





    }

    @Test
    void save() {
        int numberOfCustomers = customerRepo.getNumberOfCustomers();
        assertEquals(0, numberOfCustomers);
        Customer customer1 = customerRepo.save(customerOne);
        numberOfCustomers = customerRepo.getNumberOfCustomers();
        assertEquals(1, numberOfCustomers);
        Customer customer2 = customerRepo.save(customerTwo);
        numberOfCustomers = customerRepo.getNumberOfCustomers();
        assertEquals(2, numberOfCustomers);
        assertEquals(1, customer1.getId());
        assertEquals(2, customer2.getId());
    }

    @Test
    void updateCustomer() {
        Customer customerBeforeUpdate = customerRepo.save(customerOne);
        assertEquals(1,customerBeforeUpdate.getId());
        var orders = customerOne.getOrders();
        assertEquals(0, orders.size());
        customerOne.getOrders().add(product);
        Customer customerAfterUpdate = customerRepo.updateCustomer(customerOne);
        assertEquals(1,customerAfterUpdate.getId());
        var orderOfProduct = customerOne.getOrders().size();
        assertEquals(1, orderOfProduct);

    }

    @Test
    void findById() {
        Customer customer1 = customerRepo.save(customerOne);
        Customer customer2 = customerRepo.save(customerTwo);
        assertEquals(customer1, customerRepo.findById(1));
        assertEquals(customer2, customerRepo.findById(2));
    }

    @Test
    void findByEmail() {
        Customer customer1 = customerRepo.save(customerOne);
        Customer customer2 = customerRepo.save(customerTwo);
        assertEquals(customer1, customerRepo.findByEmail("kabir@gmail.com"));
        assertEquals(customer2, customerRepo.findByEmail("james@gmail.com"));
    }

    @Test
    void getNumberOfCustomers() {
        assertEquals(0, customerRepo.getNumberOfCustomers());
        Customer customer1 = customerRepo.save(customerOne);
        Customer customer2 = customerRepo.save(customerTwo);
        assertEquals(2, customerRepo.getNumberOfCustomers());
    }

    @Test
    void deleteById() {
        assertEquals(0, customerRepo.getNumberOfCustomers());
        Customer customer1 = customerRepo.save(customerOne);
        Customer customer2 = customerRepo.save(customerTwo);
        assertEquals(2, customerRepo.getNumberOfCustomers());
        customerRepo.deleteById(1);
        assertEquals(1, customerRepo.getNumberOfCustomers());
        customerRepo.deleteById(2);
        assertEquals(0, customerRepo.getNumberOfCustomers());

    }

    @Test
    void deleteByEmail() {
        assertEquals(0, customerRepo.getNumberOfCustomers());
        Customer customer1 = customerRepo.save(customerOne);
        Customer customer2 = customerRepo.save(customerTwo);
        assertEquals(2, customerRepo.getNumberOfCustomers());
        customerRepo.deleteByEmail("kabir@gmail.com");
        assertEquals(1, customerRepo.getNumberOfCustomers());
        customerRepo.deleteByEmail("james@gmail.com");
        assertEquals(0, customerRepo.getNumberOfCustomers());
    }
}