package store.data.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Customer extends User{
    private int id;
    private String firstName;
    private String lastName;
    private List<Product> orders = new ArrayList<>();
    private Set<String> deliveryAddresses = new TreeSet<>();
}
