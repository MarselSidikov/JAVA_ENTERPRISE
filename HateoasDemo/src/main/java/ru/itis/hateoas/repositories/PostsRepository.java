package ru.itis.hateoas.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import ru.itis.hateoas.models.Post;

/**
 * 11.03.2019
 * PostsRepository
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@RepositoryRestResource
public interface PostsRepository extends JpaRepository<Post, Long> {

    @Query("select post from Post post where post.state = 'BANNED'")
    @RestResource(path = "banned")
    Page<Post> findBanned(Pageable pageable);
}
