package pl.rzonsol.springboot.rest.webservice.example.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.rzonsol.springboot.rest.webservice.example.entity.User;
import pl.rzonsol.springboot.rest.webservice.example.exception.UserNotFoundException;
import pl.rzonsol.springboot.rest.webservice.example.services.UserService;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserResource {

    private final UserService userService;

    @GetMapping(path = "/users")
    public List<User> getUsers() {
        return userService.findAll();
    }

    @GetMapping(path = "/users/{id}")
    public User getUser(@PathVariable(name = "id") Integer id) {
        User user = userService.findOne(
                Optional.ofNullable(id).orElse(-1)
        );
        return Optional.ofNullable(user)
                .orElseThrow(
                        () -> new UserNotFoundException("User with id: " + id + " not exist.")
                );
    }

    @DeleteMapping(path = "/users/{id}")
    public void deleteUserById(@PathVariable(name = "id") Integer id) {
        userService.deleteById(id);
    }

    @PostMapping(path = "/users")
    public ResponseEntity addUser(@RequestBody User user) {

        Optional.ofNullable(user).ifPresent(userService::save);

        URI locations = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(locations).build();
    }
}
