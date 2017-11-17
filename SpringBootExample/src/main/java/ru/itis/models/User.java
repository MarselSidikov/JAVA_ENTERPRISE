package ru.itis.models;

import lombok.*;
import ru.itis.security.role.Role;
import ru.itis.security.states.State;

import javax.persistence.*;
import java.util.Set;

/**
 * 03.11.2017
 * User
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
@Table(name = "owner")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String color;

    private Integer age;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "owner")
    private Set<Auto> autos;

    @Column(unique = true)
    private String login;

    private String hashPassword;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    private State state;

    private String hashTempPassword;

    private String email;

}
