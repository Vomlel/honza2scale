package net.toscalecz.test.services;

import java.util.List;

import net.toscalecz.test.Hashing;
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

    public User getUserByName(String userName){
        List<User> getAll = userRepository.findAll();
        boolean found = false;
        int i = 0;
        User user = null;
        while (!found){
            user = getAll.get(i);
            if (user.getUserName()==userName){
                found = true;
            }
        }
        return user;
    }

    public User getUserByNamePassword(String userName, String password){
        List<User> getAll = userRepository.findAll();
        boolean found = false;
        int i = 0;
        User user = null;
        while (!found){
            user = getAll.get(i);
            if ((user.getUserName()==userName) && (user.getPassword()==password)){
                found = true;
            }
        }
        return user;
    }

    public User createUser(String userName, String password){
        User user = new User(userName, Hashing.hashThisString(password));
        userRepository.save(user);
        return user;
    }
}