package ru.itis.rest.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.rest.dto.LoginPasswordDto;
import ru.itis.rest.dto.TokenDto;
import ru.itis.rest.models.Token;
import ru.itis.rest.models.User;
import ru.itis.rest.repositories.TokensRepository;
import ru.itis.rest.repositories.UsersRepository;

import java.time.LocalDate;

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

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Override
    public TokenDto login(LoginPasswordDto loginPassword, boolean isJwtEnabled) {
        String rawPassword = loginPassword.getPassword();
        String login = loginPassword.getLogin();

        User user = usersRepository.findOneByLogin(login).orElseThrow(()
                -> new IllegalArgumentException("User not found by login <" + login + ">"));

        if (encoder.matches(rawPassword, user.getHashPassword())) {
            if (!isJwtEnabled) {
                String token = RandomStringUtils.random(15, true, true);
                Token tokenModel = Token.builder()
                        .user(user)
                        .expiredDate(LocalDate.now().plusDays(2))
                        .value(token)
                        .build();
                tokensRepository.save(tokenModel);
                return TokenDto.builder().value(token).build();
            } else {
                return TokenDto.builder().value(Jwts.builder()
                        .claim("role", user.getRole().toString())
                        .claim("login", user.getLogin())
                        .setSubject(user.getId().toString())
                        .signWith(SignatureAlgorithm.HS512, jwtSecret).compact()).build();
            }
        } else
            throw new IllegalArgumentException("User login/password incorrect");
    }
}
