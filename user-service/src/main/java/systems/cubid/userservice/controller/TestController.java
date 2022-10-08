package systems.cubid.userservice.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import systems.cubid.userservice.model.User;
import systems.cubid.userservice.repository.UserRepository;

/**
 * @author Nikolas Rummel
 * @since 25.09.22
 */
@RestController
public class TestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public List<User> getAllUsers() {
        LOGGER.info("Find all users");
        return userRepository.findAll();
    }

    @PostMapping("/")
    public User add(@RequestBody User user) {
        LOGGER.info("Add user: {}", user);
        return userRepository.add(user);
    }

    @DeleteMapping("/")
    public User delete(@RequestBody User user) {
        LOGGER.info("Delete user: {}", user);
        return userRepository.remove(user);
    }
}
