package ru.itis.hateoas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.itis.hateoas.models.Author;
import ru.itis.hateoas.models.Post;
import ru.itis.hateoas.models.PostState;
import ru.itis.hateoas.repositories.AuthorsRepository;
import ru.itis.hateoas.repositories.PostsRepository;

@SpringBootApplication
public class HateoasDemoApplication implements ApplicationRunner {

    @Autowired
    private PostsRepository postsRepository;

    @Autowired
    private AuthorsRepository authorsRepository;

    public static void main(String[] args) {
        SpringApplication.run(HateoasDemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Author marsel  = Author.builder().firstName("Марсель").lastName("Сидиков").build();
        Author semen = Author.builder().firstName("Семен").lastName("Мельников").build();
        Author sasha = Author.builder().firstName("Александр").lastName("Киселев").build();

        authorsRepository.save(marsel);
        authorsRepository.save(semen);
        authorsRepository.save(sasha);

        postsRepository.save(Post.builder().text("A post").state(PostState.BANNED).author(marsel).build());
        postsRepository.save(Post.builder().text("B post").state(PostState.ACTIVE).author(semen).build());
        postsRepository.save(Post.builder().text("C post").state(PostState.ACTIVE).author(sasha).build());
        postsRepository.save(Post.builder().text("D post").state(PostState.ACTIVE).author(marsel).build());
        postsRepository.save(Post.builder().text("E post").state(PostState.ACTIVE).author(semen).build());
        postsRepository.save(Post.builder().text("F post").state(PostState.ACTIVE).author(sasha).build());
        postsRepository.save(Post.builder().text("G post").state(PostState.ACTIVE).author(marsel).build());
        postsRepository.save(Post.builder().text("H post").state(PostState.ACTIVE).author(semen).build());
        postsRepository.save(Post.builder().text("I post").state(PostState.ACTIVE).author(sasha).build());
        postsRepository.save(Post.builder().text("G post").state(PostState.ACTIVE).author(marsel).build());
        postsRepository.save(Post.builder().text("K post").state(PostState.ACTIVE).author(semen).build());
        postsRepository.save(Post.builder().text("L post").state(PostState.ACTIVE).author(sasha).build());

    }
}
