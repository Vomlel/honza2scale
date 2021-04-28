package net.toscalecz.test.rest;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

// tag::hateoas-imports[]
// end::hateoas-imports[]

@RestController
public class UserController {

    private final UserRepository repository;

    @Autowired
    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    // Aggregate root

    // tag::get-aggregate-root[]
    @GetMapping("/users")
    public CollectionModel<EntityModel<User>> all() {
        List<EntityModel<User>> users = repository.findAll().stream()
            .map(user -> EntityModel.of(user,
                linkTo(methodOn(UserController.class).one(user.getId())).withSelfRel(),
                linkTo(methodOn(UserController.class).all()).withRel("users")))
            .collect(Collectors.toList());

        return CollectionModel.of(users, linkTo(methodOn(UserController.class).all()).withSelfRel());
    }
    // end::get-aggregate-root[]

    @PostMapping("/users")
    public User newUser(@RequestBody User newUser) {
        return repository.save(newUser);
    }

    // Single item

    // tag::get-single-item[]
    @GetMapping("/user/{id}")
    public EntityModel<User> one(@PathVariable Long id) {

        User user = repository.findById(id) //
            .orElseThrow(() -> new UserNotFoundException(id));

        return EntityModel.of(user, //
            linkTo(methodOn(UserController.class).one(id)).withSelfRel(),
            linkTo(methodOn(UserController.class).all()).withRel("users"));
    }
    // end::get-single-item[]

    @PutMapping("/user/{id}")
    public User replaceUser(@RequestBody User newUser, @PathVariable Long id) {
        return repository.findById(id) //
            .map(user -> {
                user.setUsername(newUser.getUsername());
                user.setPassword(newUser.getPassword());
                return repository.save(user);
            }) //
            .orElseGet(() -> {
                newUser.setId(id);
                return repository.save(newUser);
            });
    }

    @DeleteMapping("/user/{id}")
    void deleteUser(@PathVariable Long id) {
        repository.deleteById(id);
    }
}