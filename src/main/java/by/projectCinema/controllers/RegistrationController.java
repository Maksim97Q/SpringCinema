package by.projectCinema.controllers;

import by.projectCinema.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("Registration")
    public String read(@RequestParam(value = "username") String username,
                       @RequestParam(value = "password") String password, Model model) {
        model.addAttribute("name", username);
        if (userService.create(username, password)) {
            return "user";
        } else {
            model.addAttribute("if", userService.create(username, password));
            return "registration";
        }
    }

    @GetMapping("Registration")
    public String read1() {
        return "registration";
    }
}
