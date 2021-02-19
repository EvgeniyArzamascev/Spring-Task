package project.DAO;

import org.springframework.stereotype.Component;
import project.model.User;

import java.util.List;

@Component
public interface UserDAO {
    void add(User user);
    void delete(int id);
    void edit(User user);
    User getId(int id);
    List<User> UserList();
}
