package jpa.services;

import jpa.models.User;
import jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void saveUser(User user) {
        this.userRepository.save(user);
    }

    @Override
    public User getUserById(long id) {
//        User user = userRepository.findById(id).orElse(null);
//        if (user != null) {
//            throw new UserNotFoundException();
//        }
//        return user;
        return userRepository.getById(id);
    }

    @Override
    public void deleteUserById(long id) {
        this.userRepository.deleteById(id);
    }
}
