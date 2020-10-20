package intro.spring.service;

import intro.spring.model.User;
import java.util.List;

public interface UserService {
    void add(User user);

    List<User> listUsers();

    User getById(Long id);
}
