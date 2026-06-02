package com.harinitech.springboot_security_jwt_rbac_app1.service;

import java.time.Duration;
import java.util.Optional;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.harinitech.springboot_security_jwt_rbac_app1.model.OtpPurpose;
import com.harinitech.springboot_security_jwt_rbac_app1.model.RedisOtpData;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RedisOtpService {

	private static final Duration OTP_TTL = Duration.ofMinutes(5);

	private final RedisTemplate<String, Object> redisTemplate;

	private String buildKey(String email, OtpPurpose purpose) {

		return "otp:%s:%s".formatted(purpose.name(), email.trim().toLowerCase());
	}

	public void saveOtp(RedisOtpData otpData) {

		redisTemplate.opsForValue().set(buildKey(otpData.getUsername(), otpData.getPurpose()), otpData, OTP_TTL);
	}

	public Optional<RedisOtpData> getOtp(String email, OtpPurpose purpose) {

		return Optional.ofNullable((RedisOtpData) redisTemplate.opsForValue().get(buildKey(email, purpose)));
	}

	public void updateOtp(RedisOtpData otpData) {

		saveOtp(otpData);
	}

	public void deleteOtp(String email, OtpPurpose purpose) {

		redisTemplate.delete(buildKey(email, purpose));
	}
}