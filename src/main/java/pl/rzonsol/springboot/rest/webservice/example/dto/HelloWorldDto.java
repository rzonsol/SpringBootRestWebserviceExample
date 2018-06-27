package pl.rzonsol.springboot.rest.webservice.example.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class HelloWorldDto {

    private final String message;

}
