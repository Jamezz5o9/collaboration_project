package store.data.models;

import lombok.*;

import java.util.Set;
import java.util.TreeSet;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
@Builder
public class Vendor extends User{
    private String storeName;
    private Set<Address> vendorAddress = new TreeSet<>();
    private Address address;
}
