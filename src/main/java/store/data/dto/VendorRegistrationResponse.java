package store.data.dto;

import lombok.Data;

@Data
public class VendorRegistrationResponse {
    private int status;
    private String message;
    private int vendorId;
}