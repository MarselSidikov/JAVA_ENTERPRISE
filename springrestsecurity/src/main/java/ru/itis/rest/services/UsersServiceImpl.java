package ru.itis.rest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.rest.dto.UserDto;
import ru.itis.rest.repositories.UsersRepository;

import java.util.List;

import static ru.itis.rest.dto.UserDto.from;

/**
 * 17.04.2018
 * UsersServiceImpl
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<UserDto> getAll() {
        return from(usersRepository.findAll());
    }
}
