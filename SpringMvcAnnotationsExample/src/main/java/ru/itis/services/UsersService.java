package ru.itis.services;

import ru.itis.models.Human;

import java.util.List;

/**
 * 09.10.2017
 * UsersService
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface UsersService {
    List<Human> getAllUsers();
    List<Human> getAllUsersByAge(int age);

    void addUser(Human human);
}
