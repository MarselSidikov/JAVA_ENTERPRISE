package ru.itis.rest.security.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import ru.itis.rest.models.Token;
import ru.itis.rest.models.User;
import ru.itis.rest.security.authentication.TokenAuthentication;
import ru.itis.rest.services.TokenService;

import java.util.Optional;

/**
 * 17.04.2018
 * TokenAuthManager
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Component
public class TokenAuthManager implements AuthenticationManager {

    @Autowired
    private TokenService service;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        if (authentication instanceof TokenAuthentication) {

            TokenAuthentication tokenAuthentication = (TokenAuthentication) authentication;
            Optional<User> candidateUser = service.loadUserByToken(tokenAuthentication.getName());

            if (candidateUser.isPresent()) {
                User user = candidateUser.get();

                UserDetails userDetails = userDetailsService.loadUserByUsername(user.getLogin());

                tokenAuthentication.setUserDetails(userDetails);
                return tokenAuthentication;
            } else {
                throw new AuthenticationServiceException("User not found");
            }
        } else {
            throw new AuthenticationServiceException("Unsupported authentication");
        }
    }
}
