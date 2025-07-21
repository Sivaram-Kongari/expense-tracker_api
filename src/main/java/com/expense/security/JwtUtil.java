package com.expense.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

	private static final long EXPIRATION_TIME = 1000 * 60 * 60 * 10; // 10 hours
	private final Key secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);

	public String generateToken(String email) {

		return Jwts.builder()
				.setSubject(email)
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
				.signWith(secretKey)
				.compact();
	}

	public String extractEmail(String token) {
		return Jwts.parserBuilder().setSigningKey(secretKey).build()
				.parseClaimsJws(token).getBody().getSubject();
	}

	public boolean validateToken(String token) {
		try {

			Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token);
			return true;

		} catch (JwtException | IllegalArgumentException e) {

			return false;
		}
	}
}
