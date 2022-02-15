package by.projectCinema.services;

import by.projectCinema.entities.User;
import by.projectCinema.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteId(int id) {
        userRepository.deleteById(id);
    }

    public boolean create(String username, String password) {
        if (!userRepository.existsByUsername(username)) {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setRole("user");
            userRepository.save(user);
            return true;
        }
        return false;
    }
}
