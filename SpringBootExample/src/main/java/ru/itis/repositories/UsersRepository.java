package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.models.User;
import ru.itis.security.role.Role;

import java.util.List;
import java.util.Optional;

/**
 * 03.11.2017
 * UsersRepository
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface UsersRepository extends JpaRepository<User, Long> {
    List<User> findAllByColorAndAge(String color, int age);
    Optional<User> findOneByLogin(String login);

    List<User> findAllByRole(Role role);

    Optional<User> findById(Long userId);
}
