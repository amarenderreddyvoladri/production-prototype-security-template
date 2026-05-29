package com.harinitech.springboot_security_jwt_rbac_app1.utility;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

/**
 * ✅ PRODUCTION FIX — userId-based JWT design.
 *
 * WHY userId and NOT username as JWT subject:
 * ───────────────────────────────────────────── Username (email) can change at
 * any time by the user. If a token was issued with the old username, and the
 * user changes their email, ALL in-flight tokens become unresolvable → forced
 * logout on every username change.
 *
 * userId (Long, DB primary key) is: ✔ Immutable — never changes ✔ Unique —
 * guaranteed by DB PK constraint ✔ Stable — safe to embed in tokens with 15-min
 * or 7-day lifespan
 *
 * What we store in the JWT: sub → userId (Long, as String) ← THE ONLY identity
 * claim role → role name (e.g. "ADMIN") permissions → ["READ_USER",
 * "DELETE_USER", ...]
 *
 * JwtFilter reads sub → parses as Long → sets as principal in SecurityContext.
 * All services call getCurrentUserId() → Long.parseLong(principal.toString()).
 */
@Component
public class JwtUtility {

	private final Key key;
	private final long accessTokenExpirationMs;
	private final long refreshTokenExpirationMs;

	public JwtUtility(@Value("${jwt.secret}") String secret,
			@Value("${jwt.access-token-expiration-ms}") long accessTokenExpirationMs,
			@Value("${jwt.refresh-token-expiration-ms}") long refreshTokenExpirationMs) {
		this.key = Keys.hmacShaKeyFor(secret.getBytes());
		this.accessTokenExpirationMs = accessTokenExpirationMs;
		this.refreshTokenExpirationMs = refreshTokenExpirationMs;
	}

	// ===================== TOKEN GENERATION =====================

	/**
	 * Generates an access token.
	 *
	 * @param userId      DB primary key of the user — used as JWT subject
	 * @param role        role name (e.g. "ADMIN", "USER")
	 * @param permissions set of permission strings (e.g. "READ_USER",
	 *                    "DELETE_USER")
	 */
	public String generateAccessToken(Long userId, String role, Set<String> permissions) {
		Map<String, Object> claims = new HashMap<>();
		claims.put("role", role);
		claims.put("permissions", permissions);
		claims.put("tokenType", "ACCESS");
		// subject = userId (as String) — immutable, username-change-safe
		return buildToken(claims, String.valueOf(userId), accessTokenExpirationMs);
	}

	/**
	 * Generates a refresh token.
	 *
	 * @param userId DB primary key — embedded as subject, no extra claims needed
	 */
	public String generateRefreshToken(Long userId) {

		Map<String, Object> claims = new HashMap<>();
		claims.put("tokenType", "REFRESH");

		return buildToken(claims, String.valueOf(userId), refreshTokenExpirationMs);
	}

	private String buildToken(Map<String, Object> claims, String subject, long expiration) {
		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + expiration))
				.signWith(key, SignatureAlgorithm.HS256).compact();
	}

	// ===================== EXTRACTION =====================

	/**
	 * Extracts userId from the JWT subject. Returns null safely if token is
	 * malformed.
	 */
	public Long extractUserId(String token) {
		try {
			String subject = extractClaim(token, Claims::getSubject);
			return subject != null ? Long.parseLong(subject) : null;
		} catch (Exception e) {
			return null;
		}
	}

	public String extractRole(String token) {
		return extractClaim(token, claims -> claims.get("role", String.class));
	}

	public List<String> extractPermissions(String token) {
		try {
			Object raw = extractClaim(token, claims -> claims.get("permissions"));
			if (raw instanceof List<?> rawList) {
				return rawList.stream().map(Object::toString).toList();
			}
			return List.of();
		} catch (Exception e) {
			return List.of();
		}
	}

	public Date extractExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}

	public <T> T extractClaim(String token, Function<Claims, T> resolver) {
		return resolver.apply(extractAllClaims(token));
	}

	private Claims extractAllClaims(String token) {
		return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
	}

	// ===================== VALIDATION =====================

	public boolean isTokenValid(String token) {

		try {

			Claims claims = extractAllClaims(token);

			return claims.getExpiration().after(new Date());

		} catch (Exception e) {

			return false;
		}
	}

	private boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}

	public String extractTokenType(String token) {
		return extractClaim(token, claims -> claims.get("tokenType", String.class));
	}
}