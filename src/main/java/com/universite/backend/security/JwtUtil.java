package com.universite.backend.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JwtUtil {

    private static final String SECRET =
            "ma_cle_secrete_super_longue_123456";

    private static final Key key =
            Keys.hmacShaKeyFor(SECRET.getBytes());

    // Générer token
    public static String generateToken(String username) {

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(
                        new Date(System.currentTimeMillis() + 86400000)
                ) // 24h
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // Extraire username
    public static String extractUsername(String token) {

        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}

