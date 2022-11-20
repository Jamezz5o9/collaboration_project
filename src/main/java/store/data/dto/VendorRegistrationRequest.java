package store.data.dto;

import lombok.Data;

@Data
public class VendorRegistrationRequest {
    private String name;
    private String email;
    private String password;
}
