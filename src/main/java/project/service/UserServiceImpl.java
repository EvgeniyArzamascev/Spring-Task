package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.DAO.UserDAO;
import project.model.User;

import java.util.List;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDAO userDAO;


    @Override
    @Transactional
    public void add(User user) {
        userDAO.add(user);
    }

    @Override
    @Transactional
    public void delete(int id) {
        userDAO.delete(id);
    }

    @Override
    @Transactional
    public void edit(User user) {
        userDAO.edit(user);
    }

    @Override
    @Transactional
    public User getId(int id) {
        return userDAO.getId(id);
    }

    @Override
    @Transactional
    public List<User> UserList() {
        return userDAO.UserList();
    }
}
