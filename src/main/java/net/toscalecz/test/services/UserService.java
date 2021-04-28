package net.toscalecz.test.services;

import java.util.List;

import net.toscalecz.test.entities.User;
import net.toscalecz.test.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> list() {
        return userRepository.findAll();
    }
    public User getUserById(long id){
        List<User> getAll = userRepository.findAll();
        return getAll.get((int)id-1);
    }
}