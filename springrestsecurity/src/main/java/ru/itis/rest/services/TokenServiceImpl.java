package ru.itis.rest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.rest.models.Token;
import ru.itis.rest.models.User;
import ru.itis.rest.repositories.TokensRepository;
import ru.itis.rest.repositories.UsersRepository;

import java.util.Optional;

/**
 * 17.04.2018
 * TokenServiceImpl
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private TokensRepository tokensRepository;

    @Override
    public Optional<User> loadUserByToken(String token) {
        Token model = tokensRepository.findByValue(token);
        if (model == null) {
            return Optional.empty();
        }
        return Optional.of(model.getUser());
    }
}
