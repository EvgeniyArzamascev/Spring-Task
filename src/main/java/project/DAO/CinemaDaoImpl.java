package project.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import project.model.Cinema;
import project.model.Film;

import java.util.List;

@Repository
public class CinemaDaoImpl implements CinemaDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Cinema getId(int id) {
        Session session = sessionFactory.getCurrentSession();
        Cinema cinema = session.get(Cinema.class, id);
        return cinema;
    }

    @Override
    public List<Cinema> cinemaList() {
        Session session = sessionFactory.getCurrentSession();
        List<Cinema> cinemaList = session.createQuery("from Cinema").list();
        return cinemaList;
    }

    @Override
    public void add(Cinema cinema) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(cinema);
    }


}
