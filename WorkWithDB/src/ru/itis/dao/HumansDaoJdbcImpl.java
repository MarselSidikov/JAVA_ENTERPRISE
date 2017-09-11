package ru.itis.dao;

import ru.itis.models.Human;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 11.09.2017
 * HumansDaoJdbcImpl
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class HumansDaoJdbcImpl implements HumansDao {

    private Connection connection;

    public HumansDaoJdbcImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(Human model) {
        try {
            PreparedStatement statement =
                    connection.prepareStatement("INSERT INTO owner(name, age, color) VALUES (?,?,?)");
            statement.setString(1, model.getName());
            statement.setInt(2, model.getAge());
            statement.setString(3, model.getColor());
            statement.execute();
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public Human find(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Human model) {

    }
}
