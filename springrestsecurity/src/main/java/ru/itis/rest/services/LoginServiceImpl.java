package ru.itis.rest.services;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.rest.dto.LoginPasswordDto;
import ru.itis.rest.dto.TokenDto;
import ru.itis.rest.models.Token;
import ru.itis.rest.models.User;
import ru.itis.rest.repositories.TokensRepository;
import ru.itis.rest.repositories.UsersRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * 17.04.2018
 * LoginServiceImpl
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private TokensRepository tokensRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public TokenDto login(LoginPasswordDto loginPassword) {
        String rawPassword = loginPassword.getPassword();
        String login = loginPassword.getLogin();

        User user = usersRepository.findOneByLogin(login).orElseThrow(()
                -> new IllegalArgumentException("User not found by login <" + login + ">"));

        if (encoder.matches(rawPassword, user.getHashPassword())) {
            String token = RandomStringUtils.random(15, true, true);

            Token tokenModel = Token.builder()
                    .user(user)
                    .expiredDate(LocalDate.now().plusDays(2))
                    .value(token)
                    .build();

            tokensRepository.save(tokenModel);

            return TokenDto.builder().value(token).build();
        } else
            throw new IllegalArgumentException("User login/password incorrect");
    }
}
