package ru.itis.rest.services;

import org.springframework.http.ResponseEntity;
import ru.itis.rest.dto.LoginPasswordDto;
import ru.itis.rest.dto.TokenDto;

/**
 * 17.04.2018
 * LoginService
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface LoginService {

    TokenDto login(LoginPasswordDto loginPassword);
}
