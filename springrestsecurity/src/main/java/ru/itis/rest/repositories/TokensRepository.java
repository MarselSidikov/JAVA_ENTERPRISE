package ru.itis.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.rest.models.Token;

import java.util.Optional;

/**
 * 17.04.2018
 * TokensRepository
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface TokensRepository extends JpaRepository<Token, Long> {
    Token findByValue(String value);
}
