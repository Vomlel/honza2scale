package net.toscalecz.test.rest;

class UserNotFoundException extends RuntimeException {

	UserNotFoundException(Long id) {
		super("Could not find user " + id);
	}
}
