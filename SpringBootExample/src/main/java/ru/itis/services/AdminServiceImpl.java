package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.models.User;
import ru.itis.repositories.UsersRepository;
import ru.itis.security.role.Role;
import ru.itis.utils.PasswordGenerator;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 17.11.2017
 * AdminServiceImpl
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordGenerator passwordGenerator;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private EmailService emailService;

    private ExecutorService executorService = Executors.newCachedThreadPool();

    @Override
    public List<User> getAllUsers() {
        return usersRepository.findAllByRole(Role.USER);
    }

    // метод выполняется полностью, либо вообще не выполняется
    @Transactional
    @Override
    public void createTempPassword(Long userId) {
        // получаем пользователя
        Optional<User> existedUser = usersRepository.findById(userId);
        // никому не говорите
        User admin = usersRepository.findOne(1L);
        // если пользователя нет
        if (!existedUser.isPresent()) {
            throw new IllegalArgumentException("User not found");
        }
        // получаем пользтвателя
        User user = existedUser.get();
        // генерирурем пароль
        String tempPassword = passwordGenerator.generate();
        // и этому пользователю кладем временный пароль
        user.setHashTempPassword(encoder.encode(tempPassword));
        // сохраняем пользователя в бд в новым временным паролем
        usersRepository.save(user);

        executorService.submit(() -> {
            // админу на почту скидываем новый пароль
            emailService.sendMail("<h1>" + tempPassword + "</h1>",
                    "Временный пароль для пользователя " + user.getLogin(),
                    admin.getEmail());
        });

    }
}
