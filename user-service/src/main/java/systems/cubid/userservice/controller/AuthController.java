package systems.cubid.userservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import systems.cubid.userservice.model.User;
import systems.cubid.userservice.model.auth.login.LoginRequest;
import systems.cubid.userservice.model.auth.register.RegisterRequest;
import systems.cubid.userservice.repository.UserRepository;
import systems.cubid.userservice.services.AuthService;

/**
 * @author Nikolas Rummel
 * @since 29.09.22
 */

@RestController
public class AuthController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody LoginRequest loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getEmail());

        if (user == null) {
            return new ResponseEntity<>("This email is not registered!", HttpStatus.FORBIDDEN);
        }

        if (!user.getPassword().equals(loginRequest.getPassword())) {
            return new ResponseEntity<>("Password wrong. Please try again!", HttpStatus.FORBIDDEN);
        }

        return new ResponseEntity<>(authService.login(user).toString(), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody RegisterRequest registerRequest) {
        User user = userRepository.findByEmail(registerRequest.getUser().getEmail());

        if (user != null) {
            return new ResponseEntity<>("This email is already registered. Please log in",
                HttpStatus.FORBIDDEN);
        }

        userRepository.save(registerRequest.getUser());

        return this.loginUser(new LoginRequest(registerRequest.getUser().getEmail(),
            registerRequest.getUser().getPassword()));
    }

}
