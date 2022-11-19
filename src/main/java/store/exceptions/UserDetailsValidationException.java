package store.exceptions;

public class UserDetailsValidationException extends RuntimeException{
    public UserDetailsValidationException(String message){
        super(message);
    }
}
