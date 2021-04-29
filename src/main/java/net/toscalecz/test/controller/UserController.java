package net.toscalecz.test.controller;

import net.toscalecz.test.Hashing;
import net.toscalecz.test.entities.User;
import net.toscalecz.test.repositories.UserRepository;
import net.toscalecz.test.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserRepository repository;
    private final UserService userService;

    @Autowired
    public UserController(UserRepository repository, UserService userService) {
        this.repository = repository;
        this.userService = userService;
    }

    //@GetMapping("/hello")
    //public String hello(){
    //    return "Hello Chris!";
    //}
    @GetMapping("/login/{username}/{password}")
    public User findUser(@PathVariable String userName, @PathVariable String password){
        return userService.getUserByNamePassword(userName, Hashing.hashThisString(password));
    }
    @GetMapping("/register/{username}/{password}")
    public User createUser(@PathVariable String userName, @PathVariable String password){
        return userService.createUser(userName, password);
    }
}
