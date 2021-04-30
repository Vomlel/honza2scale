package net.toscalecz.test.services;

import java.util.List;

import net.toscalecz.test.others.Hashing;
import net.toscalecz.test.entities.User;
import net.toscalecz.test.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//This service is for manipulating with UserRepository
@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //return list of all users in database
    public List<User> list() {
        return userRepository.findAll();
    }

    //return user found by id
    public User getUserById(long id) {
        List<User> getAll = userRepository.findAll();
        return getAll.get((int)id-1);
    }

    //return user found by name
    //get to list all users
    //find from list user with same userName like input
    //TODO - get all to list bad idea BUG #4
    public User getUserByName(String userName) {
        List<User> getAll = userRepository.findAll();
        int i = 0;
        int max = getAll.size();
        User user;
        while (i<max) {
            user = getAll.get(i);
            if (user.getUserName().equals(userName)) {
                return user;
            }
            i += 1;
        }
        return null;
    }

    public User getUserByNamePassword(String userName, String password) {
        List<User> getAll = userRepository.findAll();
        int i = 0;
        int max = getAll.size();
        User user;
        while (i<max){
            user = getAll.get(i);
            if ((user.getUserName().equals(userName)) && (user.getPassword().equals(Hashing.hashThisString(password)))) {
                return user;
            }
            i += 1;
        }
        return null;
    }

    public User createUser(String userName, String password) {
        User user = new User(userName, Hashing.hashThisString(password));
        userRepository.save(user);
        return user;
    }
}