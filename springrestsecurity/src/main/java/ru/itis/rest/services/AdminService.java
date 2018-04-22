package ru.itis.rest.services;

import ru.itis.rest.dto.TokenDto;

import java.util.List;

/**
 * 17.04.2018
 * AdminService
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface AdminService {
    List<TokenDto> getAllTokens();
}
