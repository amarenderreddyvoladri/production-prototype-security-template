package com.harinitech.springboot_security_jwt_rbac_app1.security;

import java.util.List;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import com.harinitech.springboot_security_jwt_rbac_app1.entity.Permission;
import com.harinitech.springboot_security_jwt_rbac_app1.entity.Role;
import com.harinitech.springboot_security_jwt_rbac_app1.repo.PermissionRepository;
import com.harinitech.springboot_security_jwt_rbac_app1.repo.RoleRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
@Order(1)
public class RoleInitializationService implements CommandLineRunner {

	private final RoleRepository roleRepository;
	private final PermissionRepository permissionRepository;

	@Override
	public void run(String... args) {

		// ==================== STEP 1: CREATE ALL PERMISSIONS ====================
		List<String> allPermissions = List.of(

				// =========================================================================
				// 👤 USER MANAGEMENT
				// =========================================================================

				"READ_USER", "CREATE_USER", "UPDATE_USER", "DELETE_USER", "VIEW_USERS",

				// =========================================================================
				// 🔘 USER STATUS & ACCESS CONTROL
				// =========================================================================

				"UPDATE_USER_STATUS", "TOGGLE_USER_ACCESS", "ACCOUNT_LOCK", "ACCOUNT_UNLOCK",

				// =========================================================================
				// 🔐 SESSION & TOKEN SECURITY
				// =========================================================================

				"FORCE_LOGOUT", "REVOKE_TOKEN", "SESSION_REVOKE",

				// =========================================================================
				// 🛡️ ROLE & RBAC MANAGEMENT
				// =========================================================================

				"ASSIGN_ADMIN", "ASSIGN_MANAGER", "ASSIGN_HR", "ASSIGN_VENDOR",

				// =========================================================================
				// 📊 AUDIT & SECURITY MONITORING
				// =========================================================================

				"VIEW_AUDIT_LOGS", "VIEW_SECURITY_EVENTS", "VIEW_AUDIT_DASHBOARD", "VIEW_SECURITY_STATISTICS",
				"VIEW_SYSTEM_STATISTICS",

				// =========================================================================
				// ⚙️ SYSTEM ADMINISTRATION
				// =========================================================================

				"SYSTEM_ADMIN",

				// =========================================================================
				// 🌐 GENERAL
				// =========================================================================

				"HELLO_USERS");

		allPermissions.forEach(name -> permissionRepository.findByName(name).orElseGet(() -> {

			Permission permission = new Permission();

			permission.setName(name);

			log.info("✅ Permission created: {}", name);

			return permissionRepository.save(permission);
		}));

		// =========================================================================
		// 📌 FETCH PERMISSIONS
		// =========================================================================

		Permission readUser = get("READ_USER");
		Permission createUser = get("CREATE_USER");
		Permission updateUser = get("UPDATE_USER");
		Permission deleteUser = get("DELETE_USER");
		Permission viewUsers = get("VIEW_USERS");

		Permission updateUserStatus = get("UPDATE_USER_STATUS");
		Permission toggleUserAccess = get("TOGGLE_USER_ACCESS");
		Permission accountLock = get("ACCOUNT_LOCK");
		Permission accountUnlock = get("ACCOUNT_UNLOCK");

		Permission forceLogout = get("FORCE_LOGOUT");
		Permission revokeToken = get("REVOKE_TOKEN");
		Permission sessionRevoke = get("SESSION_REVOKE");

		Permission assignAdmin = get("ASSIGN_ADMIN");
		Permission assignManager = get("ASSIGN_MANAGER");
		Permission assignHR = get("ASSIGN_HR");
		Permission assignVendor = get("ASSIGN_VENDOR");

		Permission viewAuditLogs = get("VIEW_AUDIT_LOGS");
		Permission viewSecurityEvents = get("VIEW_SECURITY_EVENTS");
		Permission viewAuditDashboard = get("VIEW_AUDIT_DASHBOARD");
		Permission viewSecurityStatistics = get("VIEW_SECURITY_STATISTICS");
		Permission viewSystemStatistics = get("VIEW_SYSTEM_STATISTICS");

		Permission systemAdmin = get("SYSTEM_ADMIN");

		Permission helloUsers = get("HELLO_USERS");

		// ==================== STEP 3: SYNC ROLES WITH PERMISSIONS ====================

		// 🔴 ADMIN — full access to everything
		createOrUpdateRole("ADMIN",
				Set.of(readUser, createUser, updateUser, deleteUser, updateUserStatus, toggleUserAccess, forceLogout,
						assignAdmin, assignManager, assignHR, assignVendor, helloUsers, viewUsers, viewAuditLogs,
						viewSecurityEvents, viewAuditDashboard, systemAdmin, viewSecurityStatistics,
						viewSystemStatistics, accountLock, accountUnlock, revokeToken, sessionRevoke));

		// 🟠 MANAGER — can manage HR and VENDOR users, read & create
		createOrUpdateRole("MANAGER",
				Set.of(readUser, createUser, updateUser, assignHR, assignVendor, helloUsers, viewUsers));

		// 🟡 HR — read-only access
		createOrUpdateRole("HR", Set.of(readUser, helloUsers));

		// 🟢 USER — basic access
		createOrUpdateRole("USER", Set.of(helloUsers));

		// ⚪ VENDOR — no permissions
		createOrUpdateRole("VENDOR", Set.of());
	}

	// ==================== HELPERS ====================

	private Permission get(String name) {
		return permissionRepository.findByName(name)
				.orElseThrow(() -> new RuntimeException("Permission not found after init: " + name));
	}

	private void createOrUpdateRole(String roleName, Set<Permission> permissions) {
		Role role = roleRepository.findByName(roleName).orElseGet(() -> {
			Role newRole = new Role();
			newRole.setName(roleName);
			return newRole;
		});
		role.setPermissions(permissions);
		roleRepository.save(role);
		log.info("✅ Role synced: {} with {} permissions", roleName, permissions.size());
	}
}