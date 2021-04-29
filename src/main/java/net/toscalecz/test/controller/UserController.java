package net.toscalecz.test.controller;

import net.toscalecz.test.UserLogin;
import net.toscalecz.test.UserRegister;
import net.toscalecz.test.entities.User;
import net.toscalecz.test.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController //tato trida vytvari rest api
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")//adresa
    public User findUser(@RequestBody UserLogin userLogin){//RequestBody je anotace, vezmi to z requestu z frontendu body a zkus to dat do beany userLogin
        return userService.getUserByNamePassword(userLogin.getUserName(), userLogin.getPassword());
    }
    @PostMapping("/register")
    public User createUser(@RequestBody UserRegister userRegister){
        return userService.createUser(userRegister.getUserName(), userRegister.getPassword());
    }
}
