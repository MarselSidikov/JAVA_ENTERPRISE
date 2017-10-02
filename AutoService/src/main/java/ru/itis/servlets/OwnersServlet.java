package ru.itis.servlets;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.itis.dao.HumansDao;
import ru.itis.models.Human;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 25.09.2017
 * OwnersServlet
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class OwnersServlet extends HttpServlet {

    private HumansDao humansDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ApplicationContext context = (ApplicationContext)config.getServletContext().getAttribute("context");
        humansDao = context.getBean(HumansDao.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Human> humans = humansDao.findAll();
        req.setAttribute("owners", humans);
        req.getRequestDispatcher("/WEB-INF/jsp/owners.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Human human = Human.builder()
                .name(req.getParameter("name"))
                .age(Integer.parseInt(req.getParameter("age")))
                .color(req.getParameter("color"))
                .build();
        humansDao.save(human);

        req.setAttribute("owners", humansDao.findAll());
        req.getRequestDispatcher("/WEB-INF/jsp/owners.jsp").forward(req, resp);
    }
}
