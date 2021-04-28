package net.toscalecz.test.rest;

public class UserNotFoundException extends RuntimeException {

    UserNotFoundException(Long id) {
        super("Could not find employee " + id);
    }
}
