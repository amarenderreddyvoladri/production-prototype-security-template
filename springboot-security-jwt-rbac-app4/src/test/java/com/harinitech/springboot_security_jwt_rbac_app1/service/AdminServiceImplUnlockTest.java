package com.harinitech.springboot_security_jwt_rbac_app1.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.Instant;
import java.util.Collections;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import com.harinitech.springboot_security_jwt_rbac_app1.client.NotificationFacade;
import com.harinitech.springboot_security_jwt_rbac_app1.dto.NotificationType;
import com.harinitech.springboot_security_jwt_rbac_app1.entity.User;
import com.harinitech.springboot_security_jwt_rbac_app1.model.AuditAction;
import com.harinitech.springboot_security_jwt_rbac_app1.model.AuditStatus;
import com.harinitech.springboot_security_jwt_rbac_app1.repo.UserRepository;
import com.harinitech.springboot_security_jwt_rbac_app1.repo.RoleRepository;
import com.harinitech.springboot_security_jwt_rbac_app1.repo.UserTokenRepository;

@ExtendWith(MockitoExtension.class)
class AdminServiceImplUnlockTest {

	@Mock
	private UserRepository userRepository;

	@Mock
	private RoleRepository roleRepository;

	@Mock
	private UserTokenRepository userTokenRepository;

	@Mock
	private AuditService auditService;

	@Mock
	private NotificationFacade notificationFacade;

	@Mock
	private RedisLoginAttemptService redisLoginAttemptService;

	@InjectMocks
	private AdminServiceImpl adminService;

	private SecurityContext originalContext;

	@BeforeEach
	void setUp() {
		originalContext = SecurityContextHolder.getContext();
		
		SecurityContext mockContext = mock(SecurityContext.class);
		Authentication mockAuthentication = mock(Authentication.class);
		
		lenient().when(mockContext.getAuthentication()).thenReturn(mockAuthentication);
		lenient().when(mockAuthentication.getPrincipal()).thenReturn("1"); // Admin ID
		lenient().when(mockAuthentication.getAuthorities()).thenAnswer(invocation -> 
			Collections.singletonList(new SimpleGrantedAuthority("ACCOUNT_UNLOCK"))
		);
		
		SecurityContextHolder.setContext(mockContext);
	}

	@AfterEach
	void tearDown() {
		SecurityContextHolder.setContext(originalContext);
	}

	@Test
	@DisplayName("Unlock successfully resets database fields and deletes Redis counter")
	void unlockUserAccount_Success() {
		// Arrange
		Long userId = 2L;
		User targetUser = new User();
		targetUser.setId(userId);
		targetUser.setUsername("testuser");
		targetUser.setAccountLocked(true);
		targetUser.setFailedLoginAttempts(5);
		targetUser.setLockTime(Instant.now());

		when(userRepository.findById(userId)).thenReturn(Optional.of(targetUser));

		// Act
		ResponseEntity<?> response = adminService.unlockUserAccount(userId);

		// Assert
		assertNotNull(response);
		assertEquals(200, response.getStatusCode().value());
		assertFalse(targetUser.isAccountLocked());
		assertEquals(0, targetUser.getFailedLoginAttempts());
		assertNull(targetUser.getLockTime());

		verify(userRepository, times(1)).save(targetUser);
		verify(redisLoginAttemptService, times(1)).reset("testuser");
		verify(notificationFacade, times(1)).sendNotification("testuser", NotificationType.ACCOUNT_UNLOCKED);
		verify(auditService, times(1)).log(eq(AuditAction.ACCOUNT_UNLOCKED), eq(AuditStatus.SUCCESS), anyString(), any());
	}

	@Test
	@DisplayName("Unlocking an already unlocked account throws exception and does not modify database or Redis")
	void unlockUserAccount_AlreadyUnlocked_ThrowsException() {
		// Arrange
		Long userId = 2L;
		User targetUser = new User();
		targetUser.setId(userId);
		targetUser.setUsername("testuser");
		targetUser.setAccountLocked(false);

		when(userRepository.findById(userId)).thenReturn(Optional.of(targetUser));

		// Act & Assert
		RuntimeException exception = assertThrows(RuntimeException.class, () -> adminService.unlockUserAccount(userId));
		assertEquals("User account is already unlocked.", exception.getMessage());

		verify(userRepository, never()).save(any(User.class));
		verify(redisLoginAttemptService, never()).reset(anyString());
		verify(notificationFacade, never()).sendNotification(anyString(), any());
	}
}
