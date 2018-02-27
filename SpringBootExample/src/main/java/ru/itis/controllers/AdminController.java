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

/**
 * Контроллер, который обрабатывает запросы администратора
 * все запросы начинаются с префикса /admin
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    // сервис администратора
    @Autowired
    private AdminService service;

    // получить список всех пользователей
    @GetMapping("/users")
    public String getMainAdminPage(@ModelAttribute("model") ModelMap model) {
        // получаем пользователей
        model.addAttribute("users", service.getAllUsers());
        // отдаем страницу
        return "admin";
    }

    // позволяет получить временный пароль
    // для того, чтобы зайти под пользователем каким-либо
    @GetMapping("/password/temp/{user-id}")
    public String getNewPasswordOfUserPage(@ModelAttribute("model") ModelMap model,
                                           @PathVariable("user-id") Long userId) {
        // генерируем пароль и отправляем на почту
        service.createTempPassword(userId);
        // скидываем админу страничку - что пароль отправлен на почту
        return "temp_password_page";
    }
}
