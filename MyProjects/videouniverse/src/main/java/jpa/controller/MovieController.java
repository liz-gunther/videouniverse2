package jpa.controller;

import jpa.models.Movie;
import jpa.models.User;
import jpa.models.Wishlist;
import jpa.services.MovieService;
import jpa.services.UserService;
import jpa.services.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Set;

@Controller
public class MovieController {

    private MovieService movieService;
    private UserService userService;
    private WishlistService wishlistService;


    @Autowired
    public MovieController(MovieService movieService, UserService userService, WishlistService wishlistService) {
        this.movieService = movieService;
        this.userService = userService;
        this.wishlistService = wishlistService;
    }

    @GetMapping("/explore")
    public String showExplorePage() {

        return "explore";
    }

    @GetMapping("/category/{genre}")
    public String explorePageHorror(@PathVariable(value = "genre") String genre, Principal principal, Model model) {
        Movie movie = movieService.getMovieByGenre(genre);
        User currentUser = userService.findByEmail(principal.getName());
        model.addAttribute("wishlists", currentUser.getWishlists());
        model.addAttribute("movie", movie);
        return "movieTemplate";
    }

    @GetMapping("/random")
    public String explorePageRandom(Principal principal, Model model) {
        Movie movie = movieService.getRandomMovie();
        User currentUser = userService.findByEmail(principal.getName());
        model.addAttribute("wishlists", currentUser.getWishlists());
        model.addAttribute("movie", movie);
        return "movieTemplate";
    }

    @GetMapping("/thebatman")
    public String explorePageBatman(Principal principal, Model model) {
        User currentUser = userService.findByEmail(principal.getName());
        model.addAttribute("wishlists", currentUser.getWishlists());
        Movie movie = movieService.getMovieById(309);
        model.addAttribute("movie", movie);
        return "movieTemplate";
    }

    @GetMapping("/minari")
    public String explorePageMinari(Principal principal, Model model) {
        User currentUser = userService.findByEmail(principal.getName());
        model.addAttribute("wishlists", currentUser.getWishlists());
        Movie movie = movieService.getMovieById(102);
        model.addAttribute("movie", movie);
        return "movieTemplate";
    }

    @GetMapping("/encanto")
    public String explorePageEncanto(Principal principal, Model model) {
        User currentUser = userService.findByEmail(principal.getName());
        model.addAttribute("wishlists", currentUser.getWishlists());
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

