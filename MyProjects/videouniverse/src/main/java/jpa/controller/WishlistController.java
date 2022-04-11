package jpa.controller;

import jpa.models.Movie;
import jpa.models.User;
import jpa.models.Wishlist;
import jpa.services.MovieService;
import jpa.services.UserService;
import jpa.services.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class WishlistController {

    private WishlistService wishlistService;
    private MovieService movieService;
    private UserService userService;

    @Autowired
    private WishlistController(WishlistService wishlistService, MovieService movieService, UserService userService) {
        this.wishlistService = wishlistService;
        this.movieService = movieService;
        this.userService = userService;
    }

    @GetMapping("/listofwishlists/{id}")
    public String showWishlists(@PathVariable(value = "id") long id, Model model) {
        model.addAttribute("wishlists", wishlistService.getWishlistsByUserId(id));
        return "listofwishlists";
    }

    @GetMapping("/addwishlist/")
    public String addWishlist(Model model) {
        Wishlist wishlist = new Wishlist();
        model.addAttribute("wishlist", wishlist);
        return "addwishlist";
    }

    @GetMapping("/showFormForUpdateWishlist/{id}")
    public String showFormForUpdateWishlists(@PathVariable(value = "id") long id, Model model) {
        Wishlist wishlist = wishlistService.getWishlistById(id);
        model.addAttribute("wishlist", wishlist);
        return "updatewishlists";
    }

    @GetMapping("/deleteWishlist/{id}")
    public String deleteWishlist(@PathVariable(value = "id") long id) {

        // call delete employee method
        this.wishlistService.deleteWishlistById(id);
        return "redirect:/listofwishlists";
    }

    @PostMapping("/saveWishlist")
    public String saveWishlist(@ModelAttribute("wishlist") Wishlist wishlist) {
        wishlistService.saveToWishlist(wishlist);
        return "redirect:/listofwishlists";
    }

    @PostMapping("/addmovietouser/{movieid}/{userid}")
    public String addMovieToUser(@PathVariable(value = "movieid") long id, @PathVariable(value = "userid") long userid) {
        Movie movie = movieService.getMovieById(id);
        Wishlist wishlist = wishlistService.getWishlistByUserId(userid);
        wishlist.getMovies().add(movie);
        wishlistService.saveToWishlist(wishlist);
        return String.format("redirect:/wishlist/%d", wishlist.getId());
    }

    @GetMapping("/wishlist/{id}")
    public String showWishlist(@PathVariable(value="id") long id, Model model) {
        Wishlist wishlist = wishlistService.getWishlistById(id);
        model.addAttribute("moviesList", wishlist.getMovies());
        return "wishlist";
    }

}
