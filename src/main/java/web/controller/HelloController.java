package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
@RequestMapping(name = "/")
public class HelloController {

    private final UserService userService;

    @Autowired
    public HelloController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String showUser(Model model) {

        List<User> list = userService.inf();
        model.addAttribute("person", list);
        return "users";
    }

    @GetMapping("/users/add")
    public String showAddUser(Model model) {

        model.addAttribute("person", new User());
        return "add-user";
    }

    @PostMapping("/users/add")
    public String addUser(@ModelAttribute("person") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/users/delete")
    public String deleteUser(@RequestParam("id") Long id) {

        userService.delit(id);
        return "redirect:/users";
    }

    @GetMapping("/users/update")
    public String updateUser(@RequestParam("id") Long id, Model model) {

        model.addAttribute("user", userService.get(id));
        return "updateUser";
    }

    @PostMapping("/users/update")
    public String update(@ModelAttribute("user") User user) {

        userService.update(user, user.getId());
        return "redirect:/users";
    }

}