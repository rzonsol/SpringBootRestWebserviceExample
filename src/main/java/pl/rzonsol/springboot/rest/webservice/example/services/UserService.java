package pl.rzonsol.springboot.rest.webservice.example.services;


import org.springframework.stereotype.Service;
import pl.rzonsol.springboot.rest.webservice.example.entity.User;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserService {

    private static List<User> users = new ArrayList<>();
    private int counter = 7;

    static {
        users.add(new User(0, "Name 0", new Date()));
        users.add(new User(1, "Name 1", new Date()));
        users.add(new User(2, "Name 2", new Date()));
        users.add(new User(3, "Name 3", new Date()));
        users.add(new User(4, "Name 4", new Date()));
        users.add(new User(5, "Name 5", new Date()));
        users.add(new User(6, "Name 6", new Date()));
    }

    public List<User> findAll(){
        return users;
    }

    public User findOne(@NotNull Integer id){
        return users.stream()
                .filter(u-> id.equals(u.getId()))
                .findAny()
                .orElse(null);
    }

    public User save(@NotNull User user){
        user.setId(++counter);
        users.add(user);
        return user;
    }
}
