package az.stepit.security.jwt;

import java.util.Date;

import az.stepit.exception.AccessTokenExpiredException;
import az.stepit.exception.AccessTokenInvalidException;
import az.stepit.security.services.UserDetailsImpl;
import io.jsonwebtoken.*;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
@Data
public class JwtUtils {
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    @Value("${com.example.jwtSecret}")
    private String jwtSecret;

    @Value("${com.example.jwtExpirationMs}")
    private int jwtExpirationMs;

    public String generateJwtToken(UserDetailsImpl userPrincipal) {
        return generateTokenFromUsername(userPrincipal.getUsername());
    }

    public String generateTokenFromUsername(String username) {
        Date date = new Date((new Date()).getTime() + jwtExpirationMs);
        logger.info("Expiration date {}", date);
        return Jwts.builder().setSubject(username).setIssuedAt(new Date())
                .setExpiration(date).signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (ExpiredJwtException e) {
            throw new AccessTokenExpiredException();

        } catch (Exception e) {
            throw new AccessTokenInvalidException();

        }
    }
}
