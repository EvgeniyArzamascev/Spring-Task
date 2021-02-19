package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.DAO.FilmDAO;
import project.model.Film;

import java.util.List;

@Service
public class FilmServiсeImpl implements FilmService{

    @Autowired
    private FilmDAO filmDAO;


    @Override
    @Transactional
    public void add(Film film) {
        filmDAO.add(film);
    }


    @Override
    @Transactional
    public void delete(int id) {
        filmDAO.delete(id);
    }

    @Override
    @Transactional
    public void edit(Film film) {
        filmDAO.edit(film);
    }

    @Override
    @Transactional
    public Film getId(int id) {
        return filmDAO.getId(id);
    }

    @Override
    @Transactional
    public List<Film> filmList() {
        return filmDAO.filmList();
    }
}
