package project.service;


import org.springframework.stereotype.Component;
import project.model.Cinema;
import project.model.Film;

import java.util.List;

@Component
public interface CinemaService {
    void add(Cinema cinema);
    List<Cinema> cinemaList();

}
