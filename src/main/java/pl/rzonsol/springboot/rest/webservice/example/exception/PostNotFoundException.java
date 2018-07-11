package pl.rzonsol.springboot.rest.webservice.example.exception;


public class PostNotFoundException extends NotFoundExceptionAbstract {

    public PostNotFoundException(String message) {
        super(message);
    }
}
