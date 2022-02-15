package by.projectCinema.controllers;

import by.projectCinema.entities.User;
import by.projectCinema.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    private UserService userService;

    @Autowired
    public void setUserServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("Login")
    public String read(@ModelAttribute(value = "user") User user, Model model) {
        model.addAttribute("user", user.getId());
        return "login";
    }

    @GetMapping("Login")
    public String log() {
        return "login";
    }
}
