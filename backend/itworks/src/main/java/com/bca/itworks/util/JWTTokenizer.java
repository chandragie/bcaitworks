package com.bca.itworks.util;

import java.util.HashMap;
import java.util.List;

import javax.crypto.SecretKey;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JWTTokenizer {
    static String keyStr = "b286bf66c888ea8518e2fc537531a78cd244d9a2a1dd6f7ef8d4012e7d3c3211";
    static byte[] bytes = keyStr.getBytes();
    static SecretKey key = Keys.hmacShaKeyFor(bytes);

    public static String generateJWT(HashMap<String, String> claims) {
        JwtBuilder jwt = Jwts.builder();
        for (HashMap.Entry<String, String> claim : claims.entrySet()) {
            jwt.claim(claim.getKey(), claim.getValue());
        }
        return jwt.signWith(key).compact();
    }

    public static String generateObjectJWT(HashMap<String, Object> claims) {
        JwtBuilder jwt = Jwts.builder();
        for (HashMap.Entry<String, Object> claim : claims.entrySet()) {
            jwt.claim(claim.getKey(), claim.getValue());
        }
        return jwt.signWith(key).compact();
    }

    public static String generateListJWT(List<HashMap<String, String>> claims) {
        JwtBuilder jwt = Jwts.builder();
        int i = 1;
        for (HashMap<String, String> claim : claims) {
            jwt.claim(i + "", claim);
            i++;
        }
        return jwt.signWith(key).compact();
    }

    public static Claims validateJWT(String jwtString) {
        try {
            // JWT OK!
            Jws<Claims> claims = Jwts.parser().setSigningKey(bytes).parseClaimsJws(jwtString);
            return claims.getBody();
        } catch (JwtException e) {
            // don't trust the JWT!
            e.printStackTrace();
            // return null;
            throw e;
        }
    }

}
