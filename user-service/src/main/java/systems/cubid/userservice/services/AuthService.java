package systems.cubid.userservice.services;

import java.util.HashMap;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import systems.cubid.userservice.model.User;
import systems.cubid.userservice.model.auth.login.LoginResponse;
import systems.cubid.userservice.repository.UserRepository;

/**
 * @author Nikolas Rummel
 * @since 29.09.22
 */
@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    private HashMap<Long, String> keyCache = new HashMap<>();

    public LoginResponse login(User user) {
        final String authKey = this.generateKey();
        final String refreshKey = this.generateKey();

        user.setRefreshToken(refreshKey);

        keyCache.put(user.getId(), authKey);
        userRepository.save(user);

        return new LoginResponse(authKey, refreshKey);
    }

    private String generateKey() {
        return UUID.randomUUID() + "" + UUID.randomUUID();
    }

}
