package ch.csbe.uek295_boilerplate.resources.security;

import ch.csbe.uek295_boilerplate.resources.Users.UserService;
import ch.csbe.uek295_boilerplate.resources.Users.MyUserPrincipal;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.IOException;

public class JwtRequestFilter {
    // Schritt 1
    @Autowired
    private UserService userService;

    private final String SECRET_KEY = "Th1s1sMySup3rS3cr37K3y70Cr3at3JW770k3nsW17h";


    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain
    ) throws ServletException, IOException {
        // Schritt 2
        final String authorizationHeader = request.getHeader("Authorization");

        String email = null;
        String jwt = null;

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwt = authorizationHeader.substring(7);
            email = Jwts.parser().setSigningKey(SECRET_KEY).build().parseClaimsJws(jwt).getBody().getSubject();
        }

        // Schritt 3
        if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            User user = userService.findUserByEmail(email);
            MyUserPrincipal userPrincipal = new MyUserPrincipal(user);
            userPrincipal.setEmail(user.getEmail());
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userPrincipal, null, userPrincipal.getAuthorities());
            // Schritt 4
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }

        chain.doFilter(request, response);
    }
}
