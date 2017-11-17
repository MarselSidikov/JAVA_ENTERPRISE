package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.models.User;
import ru.itis.repositories.UsersRepository;
import ru.itis.security.role.Role;
import ru.itis.utils.PasswordGenerator;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<User> getAllUsers() {
        return usersRepository.findAllByRole(Role.USER);
    }

    @Override
    public String createTempPassword(Long userId) {
        Optional<User> existedUser = usersRepository.findById(userId);

        if (!existedUser.isPresent()) {
            throw new IllegalArgumentException("User not found");
        }

        User user = existedUser.get();

        String tempPassword = passwordGenerator.generate();

        user.setHashTempPassword(encoder.encode(tempPassword));

        usersRepository.save(user);

        return tempPassword;
    }
}
