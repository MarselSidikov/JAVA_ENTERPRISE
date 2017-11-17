package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.itis.services.AdminService;

/**
 * 17.11.2017
 * AdminController
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService service;

    @GetMapping("/users")
    public String getMainAdminPage(@ModelAttribute("model") ModelMap model) {
        model.addAttribute("users", service.getAllUsers());
        return "admin";
    }

    @GetMapping("/password/temp/{user-id}")
    public String getNewPasswordOfUserPage(@ModelAttribute("model") ModelMap model,
                                           @PathVariable("user-id") Long userId) {
        model.addAttribute("tempPassword", service.createTempPassword(userId));
        return "temp_password_page";
    }
}
