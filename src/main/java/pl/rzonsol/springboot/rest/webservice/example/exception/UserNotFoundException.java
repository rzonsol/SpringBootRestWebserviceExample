package pl.rzonsol.springboot.rest.webservice.example.exception;


public class UserNotFoundException extends NotFoundExceptionAbstract {

    public UserNotFoundException(String message) {
        super(message);
    }
}
