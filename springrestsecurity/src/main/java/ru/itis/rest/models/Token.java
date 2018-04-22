package ru.itis.rest.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * 17.04.2018
 * Token
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
@Entity
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String value;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDate expiredDate;
}
