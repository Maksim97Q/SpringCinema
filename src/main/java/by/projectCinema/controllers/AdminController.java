package by.projectCinema.controllers;

import by.projectCinema.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AdminController {
    private UserService userService;

    @Autowired
    public void setUserServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("Admin/delete/{id}")
    public String deleteIdUser(@PathVariable(value = "id") int id) {
        userService.deleteId(id);
        return "redirect:/Admin";
    }

    @GetMapping("Admin")
    public String select(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "admin";
    }
}
