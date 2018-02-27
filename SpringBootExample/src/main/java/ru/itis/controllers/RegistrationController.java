package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.itis.forms.UserRegistrationForm;
import ru.itis.services.RegistrationService;
import ru.itis.validators.UserRegistrationFormValidator;

import javax.validation.Valid;

/**
 * 10.11.2017
 * RegistrationController
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */

/**
 * контроллер, который обрабатывает запросы,
 * связанные с регистрацией пользователя.
 */
@Controller
public class RegistrationController {

    @Autowired
    private RegistrationService service;

    // подключаем компонент - валидатор,
    // который будет проверять нашу форму при регистрации
    @Autowired
    private UserRegistrationFormValidator userRegistrationFormValidator;

    // прикручиваем валидатор ко всем формам, у которых название
    // userForm
    @InitBinder("userForm")
    public void initUserFormValidator(WebDataBinder binder) {
        binder.addValidators(userRegistrationFormValidator);
    }

    // Метод, который принимает запрос на регистрацию
    // пользователя
    // Метод принимает на вход данные пользователя

    // Прежде, чем метод будет обработан контроллером
    // он пройдет специальную валидацию - проверка корректности формы
    // если при валидации возникнут ошибки
    // их текст будет помещен в errors
    // если ошибки возникли, мы должны сообщить об этом пользователю
    // но не на той же странице, а на новой -
    // для этого заводим специальные RedirectAttributes
    @PostMapping(value = "/signUp")
    public String signUp(@Valid @ModelAttribute("userForm") UserRegistrationForm userRegistrationForm,
                         BindingResult errors, RedirectAttributes attributes) {
        // если есть ошибки - например, логин занят
        if (errors.hasErrors()) {
            // кладем специальный атрибут error
            attributes.addFlashAttribute("error", errors.getAllErrors().get(0).getDefaultMessage());
            // перенаправляем пользователя снова на эту же страницу
            // но у же с атрибутом ошибки
            return "redirect:/signUp";
        }
        // вызывается сервис, который регистрирует пользователя
        service.register(userRegistrationForm);
        // вернули страницу, где написано "Вы успешно зарегистрировались"
        return "success_registration";
    }

    // запрос на получение страницы, где пользователь
    // может зарегистрироваться
    @GetMapping(value = "/signUp")
    public String getSignUpPage() {
        return "sign_up";
    }
}
