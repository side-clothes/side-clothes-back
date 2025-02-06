package com.a1.a1.provider;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtProvider {
    private final Key key;

    @Value("${jwt.expiration}")
    private int jwtExpirationMs;

    @Value("${mail.auth-code-expiration-millis}")
    private int jwtEmailExpirationMs;

    public int getExpiration() {
        return jwtExpirationMs;
    }

    public int getEmailExpiration() {
        return jwtEmailExpirationMs;
    }

    public JwtProvider(@Value("${jwt.secret}") String secret, @Value("${jwt.expiration}") int jwtExpirationMs) {
        this.key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret));
        this.jwtExpirationMs = jwtExpirationMs;
    }

    public String generateToken(String id) {
        return Jwts.builder()
                .claim("id", id)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public String removeBearer(String bearerToken) {
        if(bearerToken == null || !bearerToken.startsWith("Bearer ")) {
            throw new RuntimeException("Invalid bearer token");
        }
        return bearerToken.substring("Bearer ".length());
    }

    public Long getIdFromJwt(String token) {
        Claims claims = getClaims(token);
        return claims.get("id", Long.class);
    }

    public boolean isValidToken(String token) {
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            return !claims.getExpiration().before(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    public Claims getClaims(String token) {
        JwtParser jwtParser = Jwts.parserBuilder()
                .setSigningKey(key)
                .build();
        return jwtParser.parseClaimsJws(token).getBody();
    }

    @PostConstruct
    public void init() {
        System.out.println("JWT Provider 초기화 완료");
    }
}