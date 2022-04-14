package jpa.controller;

import jpa.models.Movie;
import jpa.models.User;
import jpa.models.Wishlist;
import jpa.services.MovieService;
import jpa.services.UserService;
import jpa.services.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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

    //This works
    @GetMapping("/wishlists")
    public String showWishlists(Principal principal, Model model) {
        User currentUser = userService.findByEmail(principal.getName());
        model.addAttribute("wishlists", wishlistService.getWishlistsByUserId(currentUser.getId()));
        return "listofwishlists";
    }

    //This works
    @GetMapping("/addwishlist")
    public String addWishlist(Model model) {
        Wishlist wishlist = new Wishlist();
        model.addAttribute("wishlist", wishlist);
        return "addwishlist";
    }
    //This works
    @PostMapping("/addwishlist")
    public String saveNewWishlist(@ModelAttribute("wishlist") Wishlist wishlist, Principal principal) {
        User currentUser = userService.findByEmail(principal.getName());
        wishlistService.saveWishlist(wishlist);
        currentUser.getWishlists().add(wishlist);
        userService.saveUser(currentUser);
        return "redirect:/wishlists";
    }
//
//    @GetMapping("/showFormForUpdateWishlist/{id}")
//    public String showFormForUpdateWishlist(@PathVariable(value = "id") long id, Model model) {
//        Wishlist wishlist = wishlistService.getWishlistById(id);
//        model.addAttribute("wishlist", wishlist);
//        return "updatewishlists";
//    }

    @GetMapping("/deleteWishlist/{id}")
    public String deleteWishlist(@PathVariable(value = "id") long id) {
        wishlistService.deleteWishlistById(id);
        return "redirect:/listofwishlists";
    }

    @PostMapping("/saveWishlist")
    public String saveWishlist(@ModelAttribute("wishlist") Wishlist wishlist, Model model, Principal principal) {
        User currentUser = userService.findByEmail(principal.getName());
        model.addAttribute("userId", currentUser.getId());
        wishlistService.saveToWishlist(wishlist);
        return "redirect:/listofwishlists";
    }

    @PostMapping("/addmovietowishlist/{movieid}/{wishlistid}")
    public String addMovieTowishlist(@PathVariable(value = "movieid") long movieid, @PathVariable(value = "wishlistid") long wishlistid) {
        Movie movie = movieService.getMovieById(movieid);
        Wishlist wishlist = wishlistService.getWishlistById(wishlistid);
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

    @RequestMapping(value = "/populateDropDownList", method = RequestMethod.GET)
    public String populateList(Principal principal, Model model) {
        User currentUser = userService.findByEmail(principal.getName());
        Set<Wishlist> wishlists = wishlistService.getWishlistsByUserId(currentUser.getId());
        model.addAttribute("wishlists", wishlists);
        return "dropDownList/dropDownList.html";
    }

}
