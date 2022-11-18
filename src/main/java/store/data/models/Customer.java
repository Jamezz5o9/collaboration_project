package store.data.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Customer extends User{
    private String firstName;
    private String lastName;
    private Address address;
    private List<Product> orders = new ArrayList<>();
}
