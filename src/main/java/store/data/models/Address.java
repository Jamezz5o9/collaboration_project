package store.data.models;

import lombok.Data;

@Data
public class Address {
    private String streetNumber;
    private String StreetName;
    private String city;
    private String zipcode;
}
