package net.toscalecz.test.unused.rest;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long id) {
        super("Could not find employee " + id);
    }
}
