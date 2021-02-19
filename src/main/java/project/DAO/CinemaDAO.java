package project.DAO;

import org.springframework.stereotype.Component;
import project.model.Cinema;

import java.util.List;

@Component
public interface CinemaDAO {
    void add(Cinema cinema);
    Cinema getId(int id);
    List<Cinema> cinemaList();

}
