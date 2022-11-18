package store.exceptions;

public class InvalidProduct extends RuntimeException {
    public InvalidProduct(String message){
        super(message);
    }
}
