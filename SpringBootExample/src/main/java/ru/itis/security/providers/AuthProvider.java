package ru.itis.security.providers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import ru.itis.repositories.UsersRepository;

/**
 * 17.11.2017
 * AuthProvider
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class AuthProvider implements AuthenticationProvider {

    @Autowired
    UsersRepository usersRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {



        UserDetails details = userDetailsService.loadUserByUsername(username);
        Collection<? extends GrantedAuthority> authorities = details.getAuthorities();
        return new UsernamePasswordAuthenticationToken(details, password, authorities);
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
