package ru.itis.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import ru.itis.models.Human;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 18.09.2017
 * HumansDaoJdbcTemplateImpl
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class HumansDaoJdbcTemplateImpl implements HumansDao {

    private final static String SQL_INSERT_OWNER =
            "INSERT INTO owner(name, age, color) VALUES (?,?,?)";

    private final static String SQL_SELECT_OWNER_BY_ID =
            "SELECT * FROM owner WHERE owner.id = ?";

    private final static String SQL_SELECT_ALL =
            "SELECT * FROM owner";

    private JdbcTemplate template;

    public HumansDaoJdbcTemplateImpl(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    private RowMapper<Human> humanRowMapper = (resultSet, rowNumber) -> Human.builder()
            .id(resultSet.getLong("id"))
            .age(resultSet.getInt("age"))
            .color(resultSet.getString("color"))
            .name(resultSet.getString("name"))
            .build();

    @Override
    public List<Human> findAll() {
        return template.query(SQL_SELECT_ALL, humanRowMapper);
    }

    @Override
    public void save(Human model) {
        // хранитель ключа - хранитель сгенерированного ключа
        KeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(
                connection -> {
                    PreparedStatement preparedStatement =
                            connection.prepareStatement(SQL_INSERT_OWNER, new String[]{"id"});
                    preparedStatement.setString(1, model.getName());
                    preparedStatement.setInt(2, model.getAge());
                    preparedStatement.setString(3, model.getColor());
                    return preparedStatement;
                },
                keyHolder);
        model.setId(keyHolder.getKey().longValue());
    }

    @Override
    public Human find(Long id) {
        return template.query(SQL_SELECT_OWNER_BY_ID,
                new Long[]{id}, humanRowMapper).get(0);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Human model) {

    }
}
