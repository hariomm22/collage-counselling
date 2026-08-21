package gov.counselling.collagecounselling.service;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Date;
import javax.crypto.SecretKey;


@Service
public class JwtAuthService {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiry}")
    private long expiry;

    // Authentication -> JWT
    public String generateToken(
            Authentication authentication
    ) {

        return Jwts.builder()

                .subject(authentication.getName())

                .claim(
                        "authorities",
                        authentication.getAuthorities()
                                .stream()
                                .map(
                                        GrantedAuthority::getAuthority
                                )
                                .toList()
                )
                .issuedAt(new Date())

                .expiration(
                        new Date(
                                System.currentTimeMillis()
                                        + expiry * 1000L
                        )
                )

                .signWith(getSigningKey())

                .compact();
    }

    // Converts Base64 secret String into SecretKey
    private SecretKey getSigningKey() {

        byte[] keyBytes =
                Decoders.BASE64.decode(secret);

        return Keys.hmacShaKeyFor(keyBytes);
    }

    // extract username from token
    public String extractUsername(String token) {
        return extractAllClaims(token)
                .getSubject();
    }


    // token and claims verify
    public Claims extractAllClaims(String token) {

        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }


    //
    public boolean isTokenValid(String token) {

        try {
            extractAllClaims(token);
            return true;

        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }


    }
