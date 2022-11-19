package store.exceptions;

public class VendorNotFound extends RuntimeException{
    public VendorNotFound(String message){
        super(message);
    }
}
