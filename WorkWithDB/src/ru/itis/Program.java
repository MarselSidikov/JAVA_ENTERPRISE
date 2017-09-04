package ru.itis;

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
                    "qwerty007"
            );
            Statement statement = connection.createStatement();
            statement
                    .execute("INSERT INTO owner(name, age, color) VALUES('Максим', 18, 'White')");
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
