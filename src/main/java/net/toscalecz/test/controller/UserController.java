package net.toscalecz.test.controller;

import net.toscalecz.test.Hashing;
import net.toscalecz.test.UserRegister;
import net.toscalecz.test.entities.User;
import net.toscalecz.test.repositories.UserRepository;
import net.toscalecz.test.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/register")
    public User createUser(@RequestBody UserRegister userRegister){
        return userService.createUser(userRegister.getUserName(), userRegister.getPassword());
    }
}