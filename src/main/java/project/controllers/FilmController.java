package project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.model.Film;
import project.service.FilmService;

@Controller
public class FilmController {

    @Autowired
    private FilmService filmService;

    @GetMapping("/film")
    public String index(Model model){
        model.addAttribute("film", filmService.filmList());
        return "film/index";
    }

    @GetMapping("/film/{id}")
    public String info(@PathVariable("id") int id, Model model){
        model.addAttribute("film", filmService.getId(id));
        return "film/info";
    }

    @GetMapping("/film/{id}/edit")
    public String editGET(@PathVariable("id") int id, Model model){
        model.addAttribute("film", filmService.getId(id));
        return "film/edit";
    }

    @PatchMapping("/film")
    public String editPATCH(@ModelAttribute("film") Film film){
        filmService.edit(film);
        return "redirect:/film";
    }

    @GetMapping("/film/new")
    public String newGET(@ModelAttribute("film") Film film){
        return "/film/new";
    }

    @PostMapping("/film/new")
    public String newPOST(@ModelAttribute("film") Film film){
        filmService.add(film);
        return "redirect:/film";
    }

    @DeleteMapping("/film/{id}")
    public String delete(@PathVariable("id") int id){
        filmService.delete(id);
        return "redirect:/film";
    }

}
