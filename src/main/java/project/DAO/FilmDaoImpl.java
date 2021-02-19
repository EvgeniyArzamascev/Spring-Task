package project.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import project.model.Film;
import project.model.User;

import java.util.List;


@Repository
public class FilmDaoImpl implements FilmDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Film film) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(film);
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        //Film film = session.get(Film.class, id);
        Film film = getId(id);
        session.delete(film);
    }

    @Override
    public void edit(Film film) {
        Session session = sessionFactory.getCurrentSession();
        session.update(film);
    }

    @Override
    public Film getId(int id) {
        Session session = sessionFactory.getCurrentSession();
        Film film = session.get(Film.class, id);
        return film;
    }

    @Override
    public List<Film> filmList() {
        Session session = sessionFactory.getCurrentSession();
        List<Film> filmList = session.createQuery("from Film").list();
        return filmList;
    }
}
