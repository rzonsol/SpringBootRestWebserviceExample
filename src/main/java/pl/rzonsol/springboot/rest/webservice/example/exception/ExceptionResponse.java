package pl.rzonsol.springboot.rest.webservice.example.exception;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

@Getter
public class ExceptionResponse {

    private final Date time;
    private final String message;
    private final String details;

    public ExceptionResponse(String message) {
        this(message, StringUtils.EMPTY);
    }

    public ExceptionResponse(String message, String details) {
        this.time = new Date();
        this.message = message;
        this.details = details;
    }
}
