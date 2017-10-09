package ru.itis.controllers;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import ru.itis.dao.HumansDao;
import ru.itis.models.Human;
import ru.itis.services.UsersService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 09.10.2017
 * UsersController
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class UsersController implements Controller {

    private UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        if (httpServletRequest.getMethod().equals("GET")) {
            List<Human> humans = usersService.getAllUsers();
            ModelAndView modelAndView = new ModelAndView();

            modelAndView.addObject("owners", humans);
            modelAndView.setViewName("all_users_page");

            return modelAndView;
        }
        return null;
    }
}
