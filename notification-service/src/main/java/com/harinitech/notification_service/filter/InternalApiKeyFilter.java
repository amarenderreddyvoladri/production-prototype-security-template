package com.harinitech.notification_service.filter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class InternalApiKeyFilter extends OncePerRequestFilter {

	private static final String API_KEY_HEADER = "X-Internal-Api-Key";

	@Value("${notification.internal-api-key}")
	private String expectedApiKey;

	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) {
		String path = request.getRequestURI();
		return path.startsWith("/actuator") || path.startsWith("/swagger-ui") || path.startsWith("/v3/api-docs")
				|| path.startsWith("/api-docs");
	}

	@Override
	protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response,
			@NonNull FilterChain filterChain) throws ServletException, IOException {

		String providedKey = request.getHeader(API_KEY_HEADER);

		if (providedKey == null || providedKey.isBlank()) {
			log.warn("INTERNAL API KEY MISSING | uri={} | remoteAddr={}", request.getRequestURI(),
					request.getRemoteAddr());
			sendUnauthorized(response, "Missing X-Internal-Api-Key header");
			return;
		}

		if (!expectedApiKey.equals(providedKey)) {
			log.warn("INTERNAL API KEY INVALID | uri={} | remoteAddr={}", request.getRequestURI(),
					request.getRemoteAddr());
			sendUnauthorized(response, "Invalid X-Internal-Api-Key");
			return;
		}

		filterChain.doFilter(request, response);
	}

	private void sendUnauthorized(HttpServletResponse response, String message) throws IOException {
		response.setStatus(HttpStatus.UNAUTHORIZED.value());
		response.setContentType("application/json");
		response.getWriter().write("{\"status\":401,\"error\":\"Unauthorized\",\"message\":\"" + message + "\"}");
	}
}
