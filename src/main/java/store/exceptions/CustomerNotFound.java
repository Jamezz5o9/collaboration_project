package store.exceptions;

public class CustomerNotFound extends RuntimeException{
    public CustomerNotFound(String message){
        super(message);
    }
}
