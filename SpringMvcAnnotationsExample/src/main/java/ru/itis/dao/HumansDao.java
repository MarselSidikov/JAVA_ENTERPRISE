package ru.itis.dao;

import ru.itis.models.Human;

import java.util.List;

/**
 * 11.09.2017
 * HumansDao
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface HumansDao extends CrudDao<Human, Long> {
    List<Human> findAllByAge(int age);
}
