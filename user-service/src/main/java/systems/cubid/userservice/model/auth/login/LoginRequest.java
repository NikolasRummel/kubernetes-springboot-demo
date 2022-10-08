package systems.cubid.userservice.model.auth.login;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Nikolas Rummel
 * @since 29.09.22
 */
@Data
@AllArgsConstructor
public class LoginRequest {

    private String email;
    private String password;
}
