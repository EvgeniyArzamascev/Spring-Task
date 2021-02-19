package project.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.model.Cinema;
import project.model.Film;
import project.model.User;
import project.service.CinemaService;
import project.service.FilmService;
import project.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private FilmService filmService;

    @Autowired
    private CinemaService cinemaService;




    @GetMapping("/user")
    public String index(Model model){
        model.addAttribute("user", userService.UserList());
        return "user/index";
    }

    @GetMapping("/user/{id}")
    public String info(@PathVariable("id") int id, Model model){
        model.addAttribute("user", userService.getId(id));

        return "/user/info";
    }

    @GetMapping("/user/new")
    public String newUserGET(@ModelAttribute("user") User user){
        return "/user/new";
    }

    @PostMapping("/user/new")
    public String newUserPOST(@ModelAttribute("user") User user){
        userService.add(user);
        return "redirect:/user";
    }

    @GetMapping("/user/{id}/edit")
    public String editGET(@PathVariable("id") int id, Model model){
        model.addAttribute("user", userService.getId(id));
        return "/user/edit";
    }

    @PatchMapping("/user")
    public String editPATH(@ModelAttribute("User") User user) {
        userService.edit(user);
        return "redirect:/user";
    }

    @DeleteMapping("/user/{id}")
    public String delete(@PathVariable("id") int id){
        userService.delete(id);
        return "redirect:/user";
    }

    @GetMapping("/user/{id}/addFilm")
    public String addFilmGET(@PathVariable("id") int id, Model model){
        model.addAttribute("user", userService.getId(id));
        return "/user/addFilm";
    }

    @PostMapping("/user/{id}/addFilm")
    public String addFilmPOST
            (
            @PathVariable("id") int user_id,         //с URL
            @RequestParam("film_id") int film_id     //с формы
            )

            {
            Cinema cinema = new Cinema();
            cinema.setUserMapped(userService.getId(user_id));
            cinema.setFilmMapped(filmService.getId(film_id));

            cinemaService.add(cinema);
            return "redirect:/user";
            }


}
