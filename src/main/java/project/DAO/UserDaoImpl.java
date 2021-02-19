package project.DAO;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import project.model.User;


import java.util.List;

@Repository
public class UserDaoImpl implements UserDAO{

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public User getId(int id) {
        Session session = sessionFactory.getCurrentSession();
        //User user = (User) session.load(User.class, id);
        User user = session.get(User.class, id);
        return user;
    }

    @Override
    public void add(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(user);
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        /*User user = (User) session.get(User.class, id);*/
        User user = getId(id);
        session.delete(user);

    }

    @Override
    public void edit(User newUser) {
        Session session = sessionFactory.getCurrentSession();
        session.update(newUser);
    }


    @Override
    //@SuppressWarnings("unchecked")
    public List<User> UserList() {
        Session session = sessionFactory.getCurrentSession();
        List<User> UserList = session.createQuery("from User").list();
        return UserList;
    }
}
