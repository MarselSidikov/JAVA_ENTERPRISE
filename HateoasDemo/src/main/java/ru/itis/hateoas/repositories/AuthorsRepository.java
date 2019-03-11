package ru.itis.hateoas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.itis.hateoas.models.Author;

/**
 * 11.03.2019
 * AuthorsRepository
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@RepositoryRestResource
public interface AuthorsRepository extends JpaRepository<Author, Long> {
}
