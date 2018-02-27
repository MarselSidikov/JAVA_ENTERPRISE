package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.forms.UserRegistrationForm;
import ru.itis.models.User;
import ru.itis.repositories.UsersRepository;
import ru.itis.security.role.Role;

/**
 * 10.11.2017
 * RegistrationServiceImpl
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private UsersRepository usersRepository;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public void register(UserRegistrationForm userForm) {
        // создаем нового пользователя для БД с ролью USER
        User newUser = User.builder()
                .login(userForm.getLogin())
                .hashPassword(passwordEncoder.encode(userForm.getPassword()))
                .role(Role.USER)
                .build();
        // сохраняем пользователя
        usersRepository.save(newUser);
    }
}
