package store.data.models;

import lombok.Data;

@Data
public class User {
    private int id;
    private String phoneNumber;
    private String email;
    private String password;
}
