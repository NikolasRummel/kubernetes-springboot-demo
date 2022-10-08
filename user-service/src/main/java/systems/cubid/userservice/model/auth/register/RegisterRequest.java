package systems.cubid.userservice.model.auth.register;

import lombok.AllArgsConstructor;
import lombok.Data;
import systems.cubid.userservice.model.User;

/**
 * @author Nikolas Rummel
 * @since 04.10.22
 */
@AllArgsConstructor
@Data
public class RegisterRequest {

    private User user;

}
