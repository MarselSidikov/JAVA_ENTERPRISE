package ru.itis.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.rest.models.User;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 17.04.2018
 * UserDto
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private Long id;
    private String login;

    public static UserDto from(User model) {
        return UserDto.builder()
                .id(model.getId())
                .login(model.getLogin())
                .build();
    }

    public static List<UserDto> from(List<User> models) {
        return models.stream().map(UserDto::from).collect(Collectors.toList());
    }
}
