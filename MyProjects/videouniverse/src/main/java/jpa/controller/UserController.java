package jpa.controller;

import jpa.models.User;
import jpa.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/aboutus")
    public String showAboutUsPage() {
        return "aboutus";
    }
    //show the list of users
    @GetMapping("/profile")
    public String showUsers(Model model) {

        model.addAttribute("users", userService.getAllUsers());
        return "profile";
    }
    //save user to database
    @GetMapping("/signup")
    public String showSignupForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "signup";
    }
    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }


    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "updateUser";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable(value = "id") long id) {
        this.userService.deleteUserById(id);
        return "redirect:/profile";
    }

//    @GetMapping("/wishlist/{id}")
//    public String showWishlist(@PathVariable(value = "id") long id, Model model) {
//        User user = userService.getUserById(id);
//        model.addAttribute("wishlists", user.getWishlists());
//        return "listofwishlists";
//    }

}
