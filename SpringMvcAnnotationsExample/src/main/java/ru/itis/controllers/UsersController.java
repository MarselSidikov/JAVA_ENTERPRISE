package ru.itis.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.models.Human;
import ru.itis.services.UsersService;

import java.util.List;
import java.util.Optional;

/**
 * 09.10.2017
 * UsersController
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Controller
public class UsersController {

    private UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView getUsers(@RequestParam(value = "age", required = false) Integer age) {
        List<Human> humans;
        if (age != null) {
            humans = usersService.getAllUsersByAge(age);
        } else {
            humans = usersService.getAllUsers();
        }

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("owners", humans);
        modelAndView.setViewName("all_users_page");

        return modelAndView;
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ModelAndView addUser(Human human) {
        usersService.addUser(human);

        ModelAndView modelAndView =  new ModelAndView("redirect:/users");
        return modelAndView;
    }
}
