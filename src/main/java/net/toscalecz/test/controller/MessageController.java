package net.toscalecz.test.controller;

import net.toscalecz.test.rest.User;
import net.toscalecz.test.rest.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private final UserRepository repository;

    @Autowired
    public MessageController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello Chris!";
    }
    @GetMapping("/user/{id}")
    public Optional<User> helloUser(@PathVariable Long id){
        return repository.findById(id);
    }
}
