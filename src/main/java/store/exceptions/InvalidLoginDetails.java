package store.exceptions;

public class InvalidLoginDetails extends RuntimeException{
    public InvalidLoginDetails(String message){
        super(message);
    }
}
