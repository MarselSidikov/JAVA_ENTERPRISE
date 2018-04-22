package ru.itis.rest.services;

import ru.itis.rest.dto.UserDto;

import java.util.List;

/**
 * 17.04.2018
 * UsersService
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface UsersService {
    List<UserDto> getAll();
}
