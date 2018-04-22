package ru.itis.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.rest.dto.UserDto;
import ru.itis.rest.models.User;
import ru.itis.rest.services.UsersService;

import java.util.List;

/**
 * 17.04.2018
 * UsersController
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@RestController
@RequestMapping("/rest/user")
public class UsersController {

    @Autowired
    private UsersService service;

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(service.getAll());
    }
}
