package ru.itis.dao;

import ru.itis.models.Human;

import java.sql.Connection;

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
