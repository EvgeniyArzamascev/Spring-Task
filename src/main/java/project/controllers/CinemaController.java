package project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import project.DAO.CinemaDAO;
import project.service.CinemaService;

@Controller
public class CinemaController {

    @Autowired
    private CinemaService cinemaService;

    @GetMapping("/cinema")
    public String index(Model model){
        model.addAttribute("cinema", cinemaService.cinemaList());
        return "cinema/index";
    }

    @GetMapping("/cinema/{id}")
    public String info(@PathVariable("id") int id, Model model){
        //model.addAttribute("cinema", cinemaService.);
        return "cinema/info";
    }
}
