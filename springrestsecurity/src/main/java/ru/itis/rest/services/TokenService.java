package ru.itis.rest.services;

import ru.itis.rest.models.User;

import java.util.Optional;

/**
 * 17.04.2018
 * TokenService
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface TokenService {
    Optional<User> loadUserByToken(String token);
}
