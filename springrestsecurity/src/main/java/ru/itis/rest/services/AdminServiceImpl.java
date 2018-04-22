package ru.itis.rest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.rest.dto.TokenDto;
import ru.itis.rest.repositories.TokensRepository;

import java.util.List;

/**
 * 17.04.2018
 * AdminServiceImpl
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private TokensRepository tokensRepository;

    @Override
    public List<TokenDto> getAllTokens() {
        return TokenDto.from(tokensRepository.findAll());
    }
}
