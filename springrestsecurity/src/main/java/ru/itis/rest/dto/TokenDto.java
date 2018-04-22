package ru.itis.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.rest.models.Token;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 17.04.2018
 * TokenDto
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TokenDto {
    private String value;
    private String expiredDate;
    private String userLogin;

    public static TokenDto from(Token model) {
        return TokenDto.builder()
                .value(model.getValue())
                .expiredDate(model.getExpiredDate().toString())
                .userLogin(model.getUser().getLogin())
                .build();
    }

    public static List<TokenDto> from(List<Token> models) {
        return models.stream().map(TokenDto::from).collect(Collectors.toList());
    }
}
