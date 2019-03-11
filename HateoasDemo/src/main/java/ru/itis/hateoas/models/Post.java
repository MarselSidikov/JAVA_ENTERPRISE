package ru.itis.hateoas.models;

import javafx.geometry.Pos;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

/**
 * 11.03.2019
 * Post
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @Enumerated(value = EnumType.STRING)
    private PostState state;

    public void ban() {
        this.state = PostState.BANNED;
    }

    public boolean isActive() {
        return this.state.equals(PostState.ACTIVE);
    }

}
