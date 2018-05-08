package ru.itis.rest.controllers;

import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.rest.dto.TokenDto;
import ru.itis.rest.services.AdminService;

import javax.xml.ws.Response;
import java.util.List;

/**
 * 17.04.2018
 * AdminController
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/tokens")
    public ResponseEntity<List<TokenDto>> getAllTokens() {
        return ResponseEntity.ok(adminService.getAllTokens());
    }
}
