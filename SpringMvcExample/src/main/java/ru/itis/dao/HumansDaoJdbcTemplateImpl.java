package ru.itis.dao;

import com.google.common.collect.Lists;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import ru.itis.models.Auto;
import ru.itis.models.Human;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            "SELECT * FROM owner, auto WHERE auto.owner_id = owner.id AND owner.id = ?";

    private final static String SQL_SELECT_ALL =
            "SELECT * FROM owner " +
                    "  LEFT JOIN auto ON owner.id = auto.owner_id;";

    private final static String SQL_SELECT_ALL_BY_COLOR_OR_AGE =
            "SELECT * FROM owner WHERE color = :color OR " +
                    "age = :age";

    private JdbcTemplate template;
    private NamedParameterJdbcTemplate namedParameterTemplate;

    private Map<Long, Human> humans;

    public HumansDaoJdbcTemplateImpl(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
        this.namedParameterTemplate = new NamedParameterJdbcTemplate(dataSource);
        this.humans = new HashMap<>();
    }

    private RowMapper<Human> humanRowMapper = (resultSet, rowNumber) -> {
        // смотрим id текущего пользователя
        Long currentOwnerId = resultSet.getLong(1);
        // если такой пользователь еще не был зарегистрирован - кладем его в map
        if (humans.get(currentOwnerId) == null) {
                    humans.put(currentOwnerId,Human.builder()
                            .id(currentOwnerId)
                            .name(resultSet.getString(2))
                            .age(resultSet.getInt(3))
                            .color(resultSet.getString(4))
                            .autos(Lists.newArrayList())
                            .build());
        }
        // вытаскиваем машину, кладем хозяина
        if (resultSet.getLong(5) != 0) {
            Auto auto = Auto.builder()
                    .id(resultSet.getLong(5))
                    .color(resultSet.getString(6))
                    .model(resultSet.getString(7))
                    .owner(humans.get(currentOwnerId))
                    .build();
            humans.get(currentOwnerId).getAutos().add(auto);
        }
        return humans.get(currentOwnerId);
    };

    @Override
    public List<Human> findAll() {
        template.query(SQL_SELECT_ALL, humanRowMapper);
        List<Human> result = Lists.newArrayList(humans.values());
        humans.clear();
        return result;
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
        Human result = template.query(SQL_SELECT_OWNER_BY_ID,
                new Long[]{id}, humanRowMapper).get(0);
        humans.clear();
        return result;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Human model) {

    }

    @Override
    public List<Human> findAllByColorOrAge(String color, int age) {
        Map<String, Object> params = new HashMap<>();
        params.put("color", color);
        params.put("age", age);
        return namedParameterTemplate.query(SQL_SELECT_ALL_BY_COLOR_OR_AGE,
                params, humanRowMapper);
    }
}
