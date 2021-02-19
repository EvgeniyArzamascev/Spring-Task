package project.service;


import org.springframework.stereotype.Component;
import project.model.Film;

import java.util.List;

@Component
public interface FilmService {
    void add(Film film);
    void delete(int id);
    void edit(Film film);
    Film getId(int id);
    List<Film> filmList();
}
