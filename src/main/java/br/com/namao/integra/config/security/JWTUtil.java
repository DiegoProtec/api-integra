package br.com.namao.integra.config.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
public class JWTUtil {

    private static final long EXPIRATION_LIMIT = 30;

    private Key key = Keys.secretKeyFor(SignatureAlgorithm.HS512);

    String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(getExpirationDate())
                .signWith(key)
                .compact();
    }

    private Date getExpirationDate() {
        long currentTimeInMillis = System.currentTimeMillis();
        long expMilliSeconds = TimeUnit.MINUTES.toMillis(EXPIRATION_LIMIT);
        return new Date(currentTimeInMillis + expMilliSeconds);
    }

}
