package br.com.namao.integra.config.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Component
public class JWTUtil {

    private static final long EXPIRATION_LIMIT = 30;
    private Key key = Keys.secretKeyFor(SignatureAlgorithm.HS512);

    String generateToken(String username, String senha) {
        return Jwts.builder()
                .setSubject(username)
                .setSubject(senha)
                .setExpiration(getExpirationDate())
                .signWith(key)
                .compact();
    }

    boolean tokenValido(String token) {
        Date now = new Date(System.currentTimeMillis());
        return getClaims(token).map((claims) -> claims.getSubject() != null && claims.getExpiration() != null && now.before(claims.getExpiration())).orElse(false);
    }

    String getUsername(String token) {
        return getClaims(token).map(Claims::getSubject).orElse(null);
    }

    private Date getExpirationDate() {
        return new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(EXPIRATION_LIMIT));
    }

    private Optional<Claims> getClaims(String token) {
        return Optional.of(Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody());
    }
}
