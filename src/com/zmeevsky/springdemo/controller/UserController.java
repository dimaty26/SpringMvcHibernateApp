package com.zmeevsky.springdemo.controller;

import com.zmeevsky.springdemo.entity.User;
import com.zmeevsky.springdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public String getUsers(Model model) {

        List<User> users = userService.getUsers();

        model.addAttribute("userList", users);

        return "users";
    }

    @GetMapping("/show_form_for_add")
    public String showFormForAdd(Model model) {

        User user = new User();
        model.addAttribute("user", user);

        return "user-form";
    }

    @PostMapping("/save_user")
    public ModelAndView saveUser(@ModelAttribute("user") User user) {

        userService.saveUser(user);

        return new ModelAndView("redirect:/users/list");
    }

    @GetMapping("/show_form_for_update")
    public String updateUser(@RequestParam("userId") int id, Model model) {

        User user = userService.getUser(id);

        model.addAttribute("user", user);

        return "user-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("userId") int id) {

        userService.deleteUser(id);

        return "redirect:/users/list";
    }

    @GetMapping("/search")
    public String searchUsers(@RequestParam("theSearchName") String theSearchName, Model model) {

        List<User> users = userService.searchUsers(theSearchName);

        model.addAttribute("users", users);

        return "users";
    }
}
