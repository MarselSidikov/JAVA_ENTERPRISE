package ru.itis.hateoas.integration;

import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.stereotype.Component;
import ru.itis.hateoas.models.Post;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

/**
 * 11.03.2019
 * PostsResourceProcessor
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Component
public class PostsResourceProcessor implements ResourceProcessor<Resource<Post>> {
    @Override
    public Resource<Post> process(Resource<Post> postResource) {
        Post post = postResource.getContent();
        if (post.isActive()) {
            postResource.add(linkTo(methodOn(PostsController.class)
                    .ban(post.getId(), null))
                    .withRel("ban"));
        }
        return postResource;
    }
}
