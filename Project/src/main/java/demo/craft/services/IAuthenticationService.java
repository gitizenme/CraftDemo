package demo.craft.services;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IAuthenticationService {
    abstract Authentication getAuthentication();

    String currentUserName();

    String currentUserId();

    void logout(HttpServletRequest request, HttpServletResponse response);
}
