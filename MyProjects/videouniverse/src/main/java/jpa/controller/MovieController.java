package jpa.controller;

import jpa.models.Movie;
import jpa.models.Wishlist;
import jpa.services.MovieService;
import jpa.services.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class MovieController {

    private MovieService movieService;
    private WishlistService wishlistService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/explore")
    public String showExplorePage() {
        return "explore";
    }

    @GetMapping("/horror")
    public String explorePageHorror(Model model) {
        Movie movie = movieService.getMovieByGenre("horror");
        model.addAttribute("movie", movie);
        return "movieTemplate";
    }

    @GetMapping("/drama")
    public String explorePageDrama(Model model) {
        Movie movie = movieService.getMovieByGenre("drama");
        model.addAttribute("movie", movie);
        return "movieTemplate";
    }

    @GetMapping("/thriller")
    public String explorePageThriller(Model model) {
        Movie movie = movieService.getMovieByGenre("thriller");
        model.addAttribute("movie", movie);
        return "movieTemplate";
    }

    @GetMapping("/romance")
    public String explorePageRomance(Model model) {
        Movie movie = movieService.getMovieByGenre("romance");
        model.addAttribute("movie", movie);
        return "movieTemplate";
    }

    @GetMapping("/scifi")
    public String explorePageScifi(Model model) {
        Movie movie = movieService.getMovieByGenre("sci-fi");
        model.addAttribute("movie", movie);
        return "movieTemplate";
    }

    @GetMapping("/classic")
    public String explorePageClassic(Model model) {
        Movie movie = movieService.getMovieByGenre("classic");
        model.addAttribute("movie", movie);
        return "movieTemplate";
    }

    @GetMapping("/kids")
    public String explorePageKids(Model model) {
        Movie movie = movieService.getMovieByGenre("kids");
        model.addAttribute("movie", movie);
        return "movieTemplate";
    }

    @GetMapping("/comedy")
    public String explorePageComedy(Model model) {
        Movie movie = movieService.getMovieByGenre("comedy");
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

    @PostMapping("/saveToWishlist")
    public String saveMovieToWishlist(@ModelAttribute("movie") @Valid Wishlist wishlist) {
        wishlistService.saveToWishlist(wishlist);
        return "wishlist";
    }

}

