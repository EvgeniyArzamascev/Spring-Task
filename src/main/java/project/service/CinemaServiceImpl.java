package project.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.DAO.CinemaDAO;
import project.model.Cinema;

import java.util.List;

@Service
public class CinemaServiceImpl implements CinemaService{

    @Autowired
    private CinemaDAO cinemaDAO;

    @Override
    @Transactional
    public List<Cinema> cinemaList() {
        return cinemaDAO.cinemaList();
    }

    @Override
    @Transactional
    public void add(Cinema cinema) {
        cinemaDAO.add(cinema);
    }
}
