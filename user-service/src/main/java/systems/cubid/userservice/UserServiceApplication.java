package systems.cubid.userservice;

import java.util.UUID;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import systems.cubid.userservice.model.User;
import systems.cubid.userservice.repository.UserRepository;
import systems.cubid.userservice.services.AuthService;

@SpringBootApplication
public class UserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

    @Bean
    UserRepository userRepository() {
        UserRepository repository = new UserRepository();
        repository.add(new User(-1L, "john@smith.de", "john", "pass",
            (UUID.randomUUID() + "" + UUID.randomUUID()), System.currentTimeMillis()));
        return repository;
    }

}
