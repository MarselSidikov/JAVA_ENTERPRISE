package ru.itis.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.rest.dto.LoginPasswordDto;
import ru.itis.rest.dto.TokenDto;
import ru.itis.rest.services.LoginService;

/**
 * 17.04.2018
 * LoginController
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@RestController
public class LoginController {

    @Autowired
    private LoginService service;

    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody LoginPasswordDto loginPassword, @RequestParam(value = "jwt",
            required = false, defaultValue = "false") boolean isJwtEnabled) {
        return ResponseEntity.ok(service.login(loginPassword, isJwtEnabled));
    }
}
