package ru.kpfu.itis.repository;

import ru.kpfu.itis.models.User;

public interface UserDao extends CrudDao<User, Long> {
    User findByLogin(String login);
}
