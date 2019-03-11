package ru.itis.hateoas.integration;

import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.*;
import ru.itis.hateoas.models.Post;
import ru.itis.hateoas.repositories.PostsRepository;

import java.util.Optional;

/**
 * 11.03.2019
 * PostsController
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@RepositoryRestController
public class PostsController {

    @Autowired
    private PostsRepository postsRepository;

    @PutMapping(value = "/posts/{post-id}/ban")
    @ResponseBody
    public PersistentEntityResource ban(@PathVariable("post-id") Long postId,
                                        PersistentEntityResourceAssembler assembler) {
        Post post = postsRepository.getOne(postId);
        post.ban();
        return assembler.toFullResource(postsRepository.save(post));
    }
}
