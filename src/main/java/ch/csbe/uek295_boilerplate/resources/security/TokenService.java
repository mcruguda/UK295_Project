package ch.csbe.uek295_boilerplate.resources.security;

import ch.csbe.uek295_boilerplate.resources.Users.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {
    // PLEASE USE A MORE SECURE KEY :-)
    private final String SECRET_KEY = "Th1s1sMySup3rS3cr37K3y70Cr3at3JW770k3nsW17h";


    public String generateToken(User user) {
        return Jwts.builder()
                .setSubject(user.getEmail())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }
}
