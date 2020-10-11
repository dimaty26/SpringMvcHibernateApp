package com.zmeevsky.springdemo.rest;

import com.zmeevsky.springdemo.entity.User;
import com.zmeevsky.springdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public ModelAndView getUsers(ModelAndView model) {

        List<User> users = userService.getUsers();

        model.addObject("userList", users);
        model.setViewName("users");

        return model;
    }

    @RequestMapping(value = "/new_user", method = RequestMethod.GET)
    public ModelAndView newUser(ModelAndView model) {
        User user = new User();
        model.addObject("user", user);
        model.setViewName("userForm");
        return model;
    }

    @PostMapping("/save_user")
    public ModelAndView saveUser(@ModelAttribute User user) {

        userService.saveUser(user);

        return new ModelAndView("redirect:/users");
    }

    @RequestMapping(value = "/update_user", method = RequestMethod.GET)
    public ModelAndView updateUser(HttpServletRequest request) {

        int userId = Integer.parseInt(request.getParameter("id"));
        User user = userService.getUser(userId);
        ModelAndView model = new ModelAndView("userForm");
        model.addObject("user", user);

        return model;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView deleteCustomer(HttpServletRequest request) {

        int userId = Integer.parseInt(request.getParameter("id"));
        userService.deleteUser(userId);

        return new ModelAndView("redirect:/users");
    }
}
