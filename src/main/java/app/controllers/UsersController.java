package app.controllers;

import app.model.Users;
import app.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/users")
public class UsersController {


    private final UsersService usersService;
    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping
    public String getAllUsers(Model model) {
        model.addAttribute("users", usersService.getAllUsers() );
        return "users/GetUsers";
    }

    @GetMapping("/{id}")
    public String showUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", usersService.showUser(id));
        return "users/showUser";
    }

//    @GetMapping()
//    public String getUserForId (@RequestMapping(value = "id", defaultValue = "1") int id, Model model) {
//
//    }

    @GetMapping("/new")
    public String newUesr(Model model) {
        model.addAttribute("user", new Users());
        return "users/newUser";
    }

    @PostMapping
    public String createUser(@ModelAttribute("user") Users user) {
        if (!(user.getName().equals(""))) {
            usersService.add(user);
        }
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String editUser(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", usersService.showUser(id));
        return "users/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") Users user, @PathVariable("id") int id) {
        user.setId(id);
        usersService.update(user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}/delete")
    public String deleteUser(@ModelAttribute("user") Users user, @PathVariable("id") int id) {
        usersService.delete(user);
        return "redirect:/users";
    }
}
