package pl.rzonsol.springboot.rest.webservice.example.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HalloWolrdController {

    @GetMapping(path = "/hello-world")
    public String helloWolrd(){
        return "Hello World!";
    }
}
