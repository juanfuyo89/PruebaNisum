package cl.nisum.techtest.security;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TokenGenerator {

    private final Long expiration = 43200000l;

    public String getJWTToken(String username) {
        JwtBuilder builder = Jwts.builder().setId(JWTAuthorizationFilter.JWT_ID)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(SignatureAlgorithm.HS512,
                        JWTAuthorizationFilter.SECRET.getBytes());
        return JWTAuthorizationFilter.PREFIX + builder.compact();
    }

}
