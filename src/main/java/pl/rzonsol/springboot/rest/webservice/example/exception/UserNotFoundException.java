package pl.rzonsol.springboot.rest.webservice.example.exception;


public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message) {
        super(message);
    }
}
