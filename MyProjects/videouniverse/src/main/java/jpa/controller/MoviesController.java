package jpa.controller;

import jpa.models.Movies;
import jpa.services.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MoviesController {

    private MoviesService moviesService;

    @Autowired
    public MoviesController(MoviesService moviesService) {
        this.moviesService = moviesService;
    }

    @GetMapping("/explore")
    public String showExplorePage() {
        return "explore";
    }

    @GetMapping("/horror")
    public String explorePage(Model model) {
        Movies movie = moviesService.getMovieByGenre("horror");
        model.addAttribute("movie", movie);
        return "movieTemplate";
    }

    @GetMapping("/drama")
    public String explorePageDrama(Model model) {
        Movies movie = moviesService.getMovieByGenre("drama");
        model.addAttribute("movie", movie);
        return "movieTemplate";
    }

    @GetMapping("/thriller")
    public String explorePageThriller(Model model) {
        Movies movie = moviesService.getMovieByGenre("thriller");
        model.addAttribute("movie", movie);
        return "movieTemplate";
    }

    @GetMapping("/romance")
    public String explorePageRomance(Model model) {
        Movies movie = moviesService.getMovieByGenre("romance");
        model.addAttribute("movie", movie);
        return "movieTemplate";
    }
}

