package intro.spring.dao;

import intro.spring.model.User;
import java.util.List;

public interface UserDao {
    void add(User user);

    List<User> getListUsers();

    User getById(Long id);
}
