package ru.itis.servlets;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.itis.dao.HumansDao;
import ru.itis.dao.HumansDaoJdbcTemplateImpl;
import ru.itis.models.Human;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
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
    public void init() throws ServletException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/java_enterprise_db");
        dataSource.setUsername("postgres");
        dataSource.setPassword("qwerty007");
        humansDao = new HumansDaoJdbcTemplateImpl(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Human> humans = humansDao.findAll();
//        PrintWriter writer = resp.getWriter();
//        writer.write("<table>");
//        for (Human human : humans) {
//            writer.write("<tr>");
//            writer.write("<td>" + human.getName() + "</td>");
//            writer.write("<td>" + human.getAge() + "</td>");
//            writer.write("</tr>");
//        }
//        writer.write("</table>");
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
