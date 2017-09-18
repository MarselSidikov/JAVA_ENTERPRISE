package ru.itis.models;

import lombok.*;

/**
 * 11.09.2017
 * Human
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Getter
@Setter
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class Human {
    private Long id;
    private String name;
    private int age;
    private String color;
}
