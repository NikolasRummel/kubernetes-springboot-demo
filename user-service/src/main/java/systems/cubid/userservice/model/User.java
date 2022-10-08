package systems.cubid.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Nikolas Rummel
 * @since 25.09.22
 */
@Data
@AllArgsConstructor
public class User {

    private Long id;
    private String email;
    private String username;
    private String password;
    private String refreshToken;
    private long accountCreated;


    public void update(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.refreshToken = user.getRefreshToken();
        this.accountCreated = user.getAccountCreated();
    }
}
