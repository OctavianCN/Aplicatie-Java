package exceptions;

public class InexistentRouteIdException extends RuntimeException{
    public InexistentRouteIdException(){
        super("Route id doesn't exist!");
    }
}
