package systems.cubid.userservice.repository;

import java.util.ArrayList;
import java.util.List;
import systems.cubid.userservice.model.User;

/**
 * @author Nikolas Rummel
 * @since 25.09.22
 */
public class UserRepository {

    private List<User> users = new ArrayList<>();

    public User add(User user) {
        user.setId((long) (users.size()+1));
        users.add(user);
        return user;
    }

    public User save(User user) {
        this.findById(user.getId()).update(user);
        return user;
    }

    public User remove(User user) {
        users.remove(user);
        return user;
    }

    public User findById(Long id) {
        return users.stream()
            .filter(usr -> usr.getId().equals(id))
            .findFirst()
            .orElseThrow();
    }

    public User findByEmail(String email) {
        return users.stream()
            .filter(usr -> usr.getEmail().equals(email))
            .findFirst()
            .orElseThrow();
    }

    public User findByUsername(String username) {
        return users.stream()
            .filter(usr -> usr.getUsername().equals(username))
            .findFirst()
            .orElseThrow();
    }

    public List<User> findAll() {
        return users;
    }

}
