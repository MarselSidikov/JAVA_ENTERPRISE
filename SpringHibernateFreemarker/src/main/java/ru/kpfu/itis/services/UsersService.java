package ru.kpfu.itis.services;

import ru.kpfu.itis.models.User;

import java.util.List;

/**
 * 02.11.2017
 *
 * @author Kuznetsov Maxim
 * @version v1.0
 */
public interface UsersService {
    List<User> getAll();
}
