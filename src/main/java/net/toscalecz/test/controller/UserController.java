package net.toscalecz.test.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import net.toscalecz.test.entities.User;
import net.toscalecz.test.repositories.UserRepository;
import net.toscalecz.test.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

// tag::hateoas-imports[]
// end::hateoas-imports[]

@Controller
public class UserController {

    private final UserRepository repository;
    private final UserService userService;

    @Autowired
    public UserController(UserRepository repository, UserService userService) {
        this.repository = repository;
        this.userService = userService;
    }

    // Aggregate root

    // tag::get-aggregate-root[]
    //@GetMapping("/users")
    //public CollectionModel<EntityModel<User>> all() {
    //    List<EntityModel<User>> users = repository.findAll().stream()
    //        .map(user -> EntityModel.of(user,
    //            linkTo(methodOn(UserController.class).one(user.getId())).withSelfRel(),
    //            linkTo(methodOn(UserController.class).all()).withRel("users")))
    //        .collect(Collectors.toList());

    //    return CollectionModel.of(users, linkTo(methodOn(UserController.class).all()).withSelfRel());
    //}
    // end::get-aggregate-root[]

    //@PostMapping("/users")
    //public User newUser(@RequestBody User newUser) {
    //    return repository.save(newUser);
    //}

    // Single item

    // tag::get-single-item[]
    //@GetMapping("/user/{id}")
    //public EntityModel<User> one(@PathVariable Long id) {

    //    User user = repository.findById(id) //
    //        .orElseThrow(() -> new UserNotFoundException(id));

    //    return EntityModel.of(user, //
    //        linkTo(methodOn(UserController.class).one(id)).withSelfRel(),
    //        linkTo(methodOn(UserController.class).all()).withRel("users"));
    //}
    // end::get-single-item[]

    //@PutMapping("/user/{id}")
    //public User replaceUser(@RequestBody User newUser, @PathVariable Long id) {
    //    return repository.findById(id) //
    //        .map(user -> {
    //            user.setUsername(newUser.getUsername());
    //            user.setPassword(newUser.getPassword());
    //            return repository.save(user);
    //        }) //
    //        .orElseGet(() -> {
    //            newUser.setId(id);
    //            return repository.save(newUser);
    //        });
    //}

    //@DeleteMapping("/user/{id}")
    //void deleteUser(@PathVariable Long id) {
    //    repository.deleteById(id);
    //}

    @GetMapping("/user")
    public String greeting(@RequestParam(value = "id", required=false, defaultValue = "1") long id, Model model) {
        //model.addAttribute("name", name);
        User user =  userService.getUserById(id);
        model.addAttribute("user", user);
        return "user";
    }
}
