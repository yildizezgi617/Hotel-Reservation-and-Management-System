package com.tobeto.hotel_reservation.core.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.logging.Logger;

@Service
public class JwtService {

    @Value("${jwt.key}")
    private String SECRET_KEY;

    @Value("${jwt.expiration}")
    private long EXPIRATION;
    public String generateToken(String userName, Map<String,Object> extraClaims){
    return Jwts
            .builder()
            .issuedAt(new Date(System.currentTimeMillis()))
            .expiration(new Date(System.currentTimeMillis()+EXPIRATION))
            .claims(extraClaims)
            .subject(userName)
            .signWith(getSignKey())
            .compact();
    }

    //İmza Anahtarı
    public Key getSignKey(){
        byte[] keyBytes= Decoders.BASE64URL.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
    //

    //Token Doğrulama Kontrolü
    private Claims getClaimsFromToken(String token){
        SecretKey Key=(SecretKey) getSignKey();
        return Jwts
                .parser()
                .verifyWith(Key)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public Boolean validateToken(String token){return getClaimsFromToken(token).getExpiration().after(new Date());}

    public String extracthUserName(String token){return getClaimsFromToken(token).getSubject();}
    //
    public int extractUserId(String token) {
        Claims claims = getClaimsFromToken(token);
        return Integer.parseInt(claims.get("UserId").toString());
    }


    public String extractUserRole(String token){
        return getClaimsFromToken(token).get("UserRole", String.class);
    }
}
