package jpa.controller;

import jpa.models.Movie;
import jpa.models.Wishlist;
import jpa.services.MovieService;
import jpa.services.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class MovieController {

    private MovieService movieService;


    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/explore")
    public String showExplorePage(Model model) {
        model.addAttribute("userid", 1);
        return "explore";
    }

    @GetMapping("/category/{genre}")
    public String explorePageHorror(@PathVariable(value = "genre") String genre, Model model) {
        Movie movie = movieService.getMovieByGenre(genre);
        model.addAttribute("movie", movie);
        return "movieTemplate";
    }

    @GetMapping("/random")
    public String explorePageRandom(Model model) {
        Movie movie = movieService.getRandomMovie();
        model.addAttribute("movie", movie);
        return "movieTemplate";
    }

    @GetMapping("/thebatman")
    public String explorePageBatman(Model model) {
        Movie movie = movieService.getMovieById(309);
        model.addAttribute("movie", movie);
        return "movieTemplate";
    }

    @GetMapping("/minari")
    public String explorePageMinari(Model model) {
        Movie movie = movieService.getMovieById(102);
        model.addAttribute("movie", movie);
        return "movieTemplate";
    }

    @GetMapping("/encanto")
    public String explorePageEncanto(Model model) {
        Movie movie = movieService.getMovieById(308);
        model.addAttribute("movie", movie);
        return "movieTemplate";
    }

//    @PostMapping("/saveToWishlist")
//    public String saveMovieToWishlist(@ModelAttribute("movie") @Valid Wishlist wishlist) {
//        wishlistService.saveToWishlist(wishlist);
//        return "wishlist";
//    }

}

