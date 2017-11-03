package ru.kpfu.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.kpfu.itis.models.User;
import ru.kpfu.itis.services.UsersService;

import java.util.List;

/**
 * 02.11.2017
 *
 * @author Kuznetsov Maxim
 * @version v1.0
 */
@Controller
public class UsersController {

    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/annotation/users/jsp", method = RequestMethod.GET)
    public ModelAndView getAll() {
        ModelAndView result = new ModelAndView("usersView");
        List<User> users = usersService.getAll();
        result.addObject("usersModel", users);
        return result;
    }

    @RequestMapping(value = "/annotation/users/ftl", method = RequestMethod.GET)
    public String getAll(@ModelAttribute("model") ModelMap model) {
        List<User> users = usersService.getAll();
        model.addAttribute("usersModel", users);
        return "usersView";
    }
}