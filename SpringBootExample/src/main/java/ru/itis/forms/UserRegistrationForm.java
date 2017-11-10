package ru.itis.forms;

import lombok.*;

/**
 * 10.11.2017
 * UserRegistrationForm
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationForm {
    private String login;
    private String password;
}
