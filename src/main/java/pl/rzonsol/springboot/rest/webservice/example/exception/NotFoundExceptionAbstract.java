package pl.rzonsol.springboot.rest.webservice.example.exception;

abstract class NotFoundExceptionAbstract extends RuntimeException {
    public NotFoundExceptionAbstract(String message) {
        super(message);
    }
}
