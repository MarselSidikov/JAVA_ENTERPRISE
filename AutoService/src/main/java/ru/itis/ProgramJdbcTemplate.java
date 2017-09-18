package ru.itis;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.itis.dao.HumansDao;
import ru.itis.dao.HumansDaoJdbcTemplateImpl;
import ru.itis.models.Human;

import java.util.List;

/**
 * 18.09.2017
 * ProgramJdbcTemplate
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class ProgramJdbcTemplate {
    public static void main(String[] args) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/java_enterprise_db");
        dataSource.setUsername("postgres");
        dataSource.setPassword("qwerty007");
        HumansDao humansDao = new HumansDaoJdbcTemplateImpl(dataSource);
//        Human human = Human.builder()
//                .name("Бабай")
//                .color("Желтый")
//                .age(157)
//                .build();
//        humansDao.save(human);
//        System.out.println(human.getId());

        List<Human> humans = humansDao.findAll();
        System.out.println(humans);
        System.out.println(humansDao.find(13L));
    }
}
