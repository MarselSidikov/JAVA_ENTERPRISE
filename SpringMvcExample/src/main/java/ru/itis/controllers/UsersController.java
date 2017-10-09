package ru.itis.controllers;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import ru.itis.dao.HumansDao;
import ru.itis.models.Human;

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

    private HumansDao humansDao;

    public UsersController(HumansDao humansDao) {
        this.humansDao = humansDao;
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        if (httpServletRequest.getMethod().equals("GET")) {
            List<Human> humans = humansDao.findAll();
            ModelAndView modelAndView = new ModelAndView();

            modelAndView.addObject("owners", humans);
            modelAndView.setViewName("all_users_page");

            return modelAndView;
        }
        return null;
    }
}
