package ru.itis;

import ru.itis.dao.HumansDao;
import ru.itis.dao.HumansDaoJdbcImpl;
import ru.itis.models.Human;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 04.09.2017
 * Program
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Program {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/java_enterprise_db",
                    "postgres",
                    "qwerty007");

            HumansDao humansDao = new HumansDaoJdbcImpl(connection);
            Human human = new Human.Builder()
                    .name("Гена")
                    .color("Зеленый")
                    .age(99)
                    .build();

            humansDao.save(human);
            System.out.println(human.getId());

        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
