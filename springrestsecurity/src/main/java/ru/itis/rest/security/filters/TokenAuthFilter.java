package ru.itis.rest.security.filters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.stereotype.Component;
import ru.itis.rest.security.authentication.TokenAuthentication;
import ru.itis.rest.services.TokenService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 17.04.2018
 * TokenAuthFilter
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */

/**
 * Фильтр преобразует запрос в объект аутентификации
 */
@Component
public class TokenAuthFilter extends AbstractAuthenticationProcessingFilter {
    protected TokenAuthFilter() {
        super("/rest/**");
        setAuthenticationSuccessHandler((request, response, authentication) ->
            SecurityContextHolder.getContext().setAuthentication(authentication));
    }

    @Override
    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        super.setAuthenticationManager(authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {

        String token = request.getHeader("Auth-Token");

        if (token == null)
            token = request.getParameter("token");
        if (token == null) {
            TokenAuthentication authentication = new TokenAuthentication(null);
            authentication.setAuthenticated(false);
            return authentication;
        }

        TokenAuthentication authentication = new TokenAuthentication(token);
        authentication.setAuthenticated(true);
        authentication = (TokenAuthentication)getAuthenticationManager().authenticate(authentication);
        return authentication;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);
        chain.doFilter(request, response);
    }
}
