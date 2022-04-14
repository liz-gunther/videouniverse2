package jpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {


    @GetMapping("/")
    public String showHomePage() { return "index"; }

    @GetMapping("/aboutus")
    public String showAboutUsPage() {
        return "aboutus";
    }

    @GetMapping("/login")
    public String showLogin(Model model) {
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession httpSession = request.getSession();
        httpSession.invalidate();
        return "redirect:/";
    }
}
