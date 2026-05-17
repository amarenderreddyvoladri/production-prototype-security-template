package com.harinitech.springboot_security_jwt_rbac_app1.service;

import java.time.Instant;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.harinitech.springboot_security_jwt_rbac_app1.repo.UserTokenRepository;

@Service
public class TokenCleanupService {

	private final UserTokenRepository userTokenRepository;

	// ✅ Constructor Injection (Best Practice)
	public TokenCleanupService(UserTokenRepository userTokenRepository) {
		this.userTokenRepository = userTokenRepository;
	}

	// 🔥 Runs every 1 hour
	@Scheduled(fixedRate = 60 * 60 * 1000)
	@Transactional
	public void cleanupExpiredRefreshTokens() {

		Instant now = Instant.now();

		System.out.println("🧹 Cleaning expired refresh tokens at: " + now);

		userTokenRepository.deleteAllByRefreshExpiryBefore(now);
	}
}