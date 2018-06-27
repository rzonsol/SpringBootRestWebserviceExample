package pl.rzonsol.springboot.rest.webservice.example.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.rzonsol.springboot.rest.webservice.example.dto.HelloWorldDto;

@RestController
public class HalloWolrdController {

    @GetMapping(path = "/hello-world")
    public String helloWorld(){
        return "Hello World!";
    }

    @GetMapping(path = "/hello-world-dto")
    public HelloWorldDto helloWorldDto(){
        return new HelloWorldDto("Hello World!");
    }
}
