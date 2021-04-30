package net.toscalecz.test.controller;

import net.toscalecz.test.controller.addFromRequestBody.UserLogin;
import net.toscalecz.test.controller.addFromRequestBody.UserRegister;
import net.toscalecz.test.entities.User;
import net.toscalecz.test.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//creating rest api
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    //coming from fronend Login.vue
    @PostMapping("/login")//address
    public User findUser(@RequestBody UserLogin userLogin) { //annotation for take request body and try add it to userLogin
        //TODO - just send boolean value BUG #1
        return userService.getUserByNamePassword(userLogin.getUserName(), userLogin.getPassword()); //if user from request exists, send him back to frontend
    }
    //coming from fronend Register.vue
    @PostMapping("/register")
    public User createUser(@RequestBody UserRegister userRegister) {//annotation for take request body and try add it to userRegister
        //TODO - just send boolean value (and maybe reason if is not created) BUG #2
        return userService.createUser(userRegister.getUserName(), userRegister.getPassword()); //if user from request exists, send him back to frontend
    }
}
