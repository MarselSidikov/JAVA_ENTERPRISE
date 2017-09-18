package ru.itis.models;

import lombok.*;

/**
 * 18.09.2017
 * Auto
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Getter
@Setter
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString(exclude = "owner")
/*
CREATE TABLE auto (
  id SERIAL PRIMARY KEY,
  color VARCHAR(50),
  model VARCHAR(50),
  owner_id INTEGER REFERENCES owner(id)
);
 */
public class Auto {
    private Long id;
    private String color;
    private String model;
    private Human owner;
}
