package ru.itis.services.vk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ru.itis.services.vk.dto.VkUser;
import ru.itis.services.vk.service.VkUsersService;

import java.util.List;

/**
 * 07.04.2018
 * VkUsersController
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@RestController
public class VkUsersController {

    @Autowired
    private VkUsersService service;

    @GetMapping("/users/{user-id}")
    public ResponseEntity<VkUser> getUserById(@PathVariable("user-id") Long userId) {
        return ResponseEntity.ok(service.getUser(userId));
    }
}
