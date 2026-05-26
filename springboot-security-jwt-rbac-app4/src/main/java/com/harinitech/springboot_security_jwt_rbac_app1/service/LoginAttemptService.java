package com.harinitech.springboot_security_jwt_rbac_app1.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.harinitech.springboot_security_jwt_rbac_app1.entity.User;
import com.harinitech.springboot_security_jwt_rbac_app1.model.AuditAction;
import com.harinitech.springboot_security_jwt_rbac_app1.model.AuditStatus;
import com.harinitech.springboot_security_jwt_rbac_app1.repo.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LoginAttemptService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AuditService auditService;

	@Value("${security.account.max-login-attempts}")
	private int maxLoginAttempts;

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void recordFailedAttempt(User user, String username) {

		int attempts = user.getFailedLoginAttempts() + 1;

		user.setFailedLoginAttempts(attempts);

		boolean accountLocked = false;

		if (attempts >= maxLoginAttempts) {

			user.setAccountLocked(true);
			user.setLockTime(Instant.now());

			accountLocked = true;

			log.error("ACCOUNT LOCKED | userId={} | username={} | attempts={}", user.getId(), username, attempts);

			auditService.log(AuditAction.ACCOUNT_LOCKED, AuditStatus.BLOCKED,
					"Account locked due to multiple failed login attempts", null);
		}

		userRepository.saveAndFlush(user);

		log.warn("LOGIN FAILED | userId={} | username={} | attempts={} | locked={}", user.getId(), username, attempts,
				accountLocked);

		auditService.log(AuditAction.LOGIN, AuditStatus.FAILED, "Invalid username or password", null);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void resetFailedAttempts(User user, String username) {

		user.setFailedLoginAttempts(0);
		user.setAccountLocked(false);
		user.setLockTime(null);

		userRepository.saveAndFlush(user);

		log.info("FAILED LOGIN ATTEMPTS RESET | userId={} | username={}", user.getId(), username);
	}
}