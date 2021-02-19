package project.service;

import org.springframework.stereotype.Component;
import project.model.User;

import java.util.List;

@Component
public interface UserService {
    public void add(User user);
    public void delete(int id);
    public void edit(User user);
    public User getId(int id);
    public List<User> UserList();
}
