package store.data.dto;

import lombok.Data;

@Data
public class CustomerRegistrationResponse {
    private String statusCode;
    private int id;
    private String message;
}
