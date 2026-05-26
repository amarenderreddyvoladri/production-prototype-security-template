<div align="center">

<img src="https://capsule-render.vercel.app/api?type=waving&color=0:0f0c29,50:302b63,100:24243e&height=220&section=header&text=🔐%20Spring%20Boot%20Security%20%2B%20JWT%20%2B%20RBAC&fontSize=34&fontColor=ffffff&animation=twinkling&fontAlignY=38&desc=Enterprise-Grade%20%7C%20Production-Ready%20%7C%20Java%2021%20%7C%20Spring%20Boot%203.4.5&descAlignY=58&descSize=16" width="100%"/>

<br/>

![Java](https://img.shields.io/badge/Java-21-FF6B35?style=for-the-badge&logo=openjdk&logoColor=white&labelColor=1a1a2e)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.5-6DB33F?style=for-the-badge&logo=springboot&logoColor=white&labelColor=1a1a2e)
![Spring Security](https://img.shields.io/badge/Spring%20Security-6.x-00D4AA?style=for-the-badge&logo=springsecurity&logoColor=white&labelColor=1a1a2e)
![JWT](https://img.shields.io/badge/JWT-JJWT%200.11.5-7B2FBE?style=for-the-badge&logo=jsonwebtokens&logoColor=white&labelColor=1a1a2e)
![MySQL](https://img.shields.io/badge/MySQL-8.x-F7971E?style=for-the-badge&logo=mysql&logoColor=white&labelColor=1a1a2e)

<br/>

![Status](https://img.shields.io/badge/🔥_STATUS-ACTIVELY_DEVELOPED_DAILY-FF0055?style=for-the-badge&labelColor=1a1a2e)
![Build](https://img.shields.io/badge/BUILD-PASSING-00D4AA?style=for-the-badge&labelColor=1a1a2e)
![Security](https://img.shields.io/badge/SECURITY-PRODUCTION_GRADE-7B2FBE?style=for-the-badge&labelColor=1a1a2e)

<br/>

[![GitHub](https://img.shields.io/badge/GitHub-amarenderreddyvoladri-181717?style=flat-square&logo=github)](https://github.com/amarenderreddyvoladri)
![Last Commit](https://img.shields.io/github/last-commit/amarenderreddyvoladri/production-prototype-security-template?style=flat-square&color=ff6b35)
![Repo Size](https://img.shields.io/github/repo-size/amarenderreddyvoladri/production-prototype-security-template?style=flat-square&color=7b2fbe)
![Stars](https://img.shields.io/github/stars/amarenderreddyvoladri/production-prototype-security-template?style=flat-square&color=gold)

</div>

---

> ### 🚨 ACTIVE DEVELOPMENT NOTICE
> **This project is under daily, continuous development.** Security bugs are being fixed, new enterprise features are being added, and architectural decisions are being hardened every single day. Every commit is intentional and documented. This is a living, breathing production-style security system — not a tutorial project.

---

## 📋 Table of Contents

| # | Section |
|---|---------|
| 01 | [🎯 What This Project Is](#-what-this-project-is) |
| 02 | [🏗️ Tech Stack](#️-tech-stack) |
| 03 | [⚡ Complete Feature Matrix](#-complete-feature-matrix) |
| 04 | [🗂️ Full Project Structure](#️-full-project-structure) |
| 05 | [🔐 JWT Architecture — Deep Dive](#-jwt-architecture--deep-dive) |
| 06 | [🛡️ RBAC System — Deep Dive](#️-rbac-system--deep-dive) |
| 07 | [📡 Complete API Reference](#-complete-api-reference) |
| 08 | [🔍 Security Filter Chain — Step by Step](#-security-filter-chain--step-by-step) |
| 09 | [📩 OTP System](#-otp-system) |
| 10 | [📬 Email Notification System](#-email-notification-system) |
| 11 | [📊 Audit Logging System](#-audit-logging-system) |
| 12 | [🔒 Brute Force & Account Lockout](#-brute-force--account-lockout) |
| 13 | [⚙️ Configuration Reference](#️-configuration-reference) |
| 14 | [🐛 Bug Fixes & Resolutions](#-bug-fixes--resolutions) |
| 15 | [🗺️ Roadmap](#️-roadmap) |
| 16 | [🚀 Quick Start](#-quick-start) |
| 17 | [👨‍💻 About the Developer](#-about-the-developer) |

---

## 🎯 What This Project Is

This is a **fully hand-crafted, production-prototype Spring Boot Security system** built from scratch using **Java 21, Spring Boot 3.4.5, Spring Security 6, and JJWT 0.11.5**. It implements every major security concept that modern enterprise applications require — not from a tutorial, but through genuine architectural thinking, iterative bug fixing, and production-grade decisions documented inline in the code.

### Why This Project Exists

Most security implementations online are:
- ❌ Username-based JWT (breaks on username changes)
- ❌ No token revocation (logout doesn't actually log you out)
- ❌ No audit trail (no visibility into who did what)
- ❌ No brute force protection (unlimited login attempts)
- ❌ No OTP verification (no email confirmation)
- ❌ No hierarchical RBAC (just `ROLE_ADMIN` and `ROLE_USER`)

**This project fixes all of the above and goes much further.**

---

## 🏗️ Tech Stack

| Layer | Technology | Version | Purpose |
|-------|-----------|---------|---------|
| Language | Java | 21 | Records, pattern matching, modern APIs |
| Framework | Spring Boot | 3.4.5 | Application backbone |
| Security | Spring Security | 6.x | Auth, filter chain, `@PreAuthorize` |
| JWT | JJWT (jjwt-api / jjwt-impl / jjwt-jackson) | 0.11.5 | Token generation, signing, parsing |
| Database | MySQL | 8.x | Persistent storage, JPA Auditing |
| ORM | Spring Data JPA + Hibernate | — | Entity management, repositories |
| Email | SendGrid Java SDK | 4.10.0 | Transactional email delivery |
| Validation | Spring Boot Starter Validation (Jakarta) | — | Request body validation |
| API Docs | SpringDoc OpenAPI (Swagger UI) | 2.8.6 | Live API documentation |
| Boilerplate | Lombok | 1.18.38 | `@Data`, `@Builder`, `@Slf4j` |
| Reactive | Spring WebFlux | — | Included for future reactive support |
| Build | Maven | 3.x | Dependency management + build |
| Server | Embedded Tomcat | — | Runs on port `8181` |

---

## ⚡ Complete Feature Matrix

> ✅ = Implemented & Working | 🔄 = In Progress | 🔜 = Planned | 🐛 = Recently Fixed

### 🔐 Authentication

| Feature | Status | Implementation Detail |
|---------|--------|----------------------|
| JWT Login | ✅ | `POST /api/v1/auth/login` — credentials verified via `AuthenticationManager` |
| Stateless Sessions | ✅ | `SessionCreationPolicy.STATELESS` — no `HttpSession` ever created |
| Access Token (15 min) | ✅ | Short-lived, embedded with `userId`, `role`, `permissions`, `tokenType=ACCESS` |
| Refresh Token (7 days) | ✅ | Long-lived, DB-persisted, one-time use, `tokenType=REFRESH` |
| Token Refresh Rotation | ✅ | Old token is marked `revoked+expired+refreshUsed=true`, new record created |
| Token Reuse Detection | ✅ | If a used refresh token is replayed → **all sessions for that user revoked** immediately |
| Token Type Enforcement | ✅ | `JwtFilter` rejects any `REFRESH` token used as `ACCESS` — returns `401` |
| Token Validation Endpoint | ✅ | `POST /api/v1/auth/validate-token` — checks signature, expiry, revocation, DB state |
| Logout (single session) | ✅ | Marks current `access+refresh` token pair as `revoked=true, expired=true` |
| Logout All Devices | ✅ | Bulk-revokes **all** active sessions for the user across every device |
| Active Session Listing | ✅ | `GET /api/v1/auth/sessions` — returns `sessionId`, device info, IP, expiry for each |
| Individual Session Revoke | ✅ | `DELETE /api/v1/auth/sessions/{id}` — revoke one specific device session |
| Force Password Change Gate | ✅ | `JwtFilter` blocks all API access with `403` if `forcePasswordChange=true`, except change-password & logout |

### 🛡️ RBAC — Role-Based Access Control

| Feature | Status | Detail |
|---------|--------|--------|
| 5 Built-in Roles | ✅ | `ADMIN`, `MANAGER`, `HR`, `USER`, `VENDOR` — auto-seeded at startup |
| 22+ Fine-Grained Permissions | ✅ | Named constants like `DELETE_USER`, `FORCE_LOGOUT`, `VIEW_AUDIT_LOGS` |
| Permissions Embedded in JWT | ✅ | Every token carries the user's permission set — no DB call needed per request |
| `@PreAuthorize` on All Endpoints | ✅ | Role + Permission checked at controller level (Gate 1) |
| Defense-in-Depth (Gate 2) | ✅ | `requirePermission()` re-checks inside `AdminServiceImpl` — impossible to bypass |
| `@EnableMethodSecurity` | ✅ | Activated in `SecurityConfig` — `@PreAuthorize`, `@PostAuthorize` support |
| Role Normalization | ✅ | `@PrePersist`/`@PreUpdate` on `Role` entity auto-uppercases names |
| Auto Role Sync on Startup | ✅ | `RoleInitializationService` (implements `CommandLineRunner`, `@Order(1)`) syncs roles and permissions idempotently |
| Hierarchical Approval Policy | ✅ | `ADMIN` can approve `MANAGER`, `EMPLOYEE`, `HR`, `VENDOR`; `MANAGER` can approve `HR`, `EMPLOYEE` — enforced in `approveRegistration()` |
| Self-Action Guard | ✅ | Admin cannot delete, lock, change role of, or force-logout their own account |
| Post-Role-Change Token Revoke | ✅ | Changing a user's role immediately revokes all their active tokens |

### 👤 User Management

| Feature | Status | Detail |
|---------|--------|--------|
| OTP-Verified Registration | ✅ | `send-registration-otp` → `register` — email verified before account creation |
| Employee Registration Flow | ✅ | Separate `POST /employee-register` — creates user in `PENDING_APPROVAL` state |
| Admin Approval / Rejection | ✅ | Admin reviews pending registrations, approves with role or rejects with reason |
| Password Change | ✅ | Validates current password, prevents reuse, forces re-login by revoking all tokens |
| Forgot Password (OTP) | ✅ | Sends reset OTP; **does not reveal if email exists** (anti-enumeration) |
| Password Reset (OTP-Gated) | ✅ | OTP validated with purpose check before allowing reset |
| Profile Endpoint | ✅ | `GET /api/v1/users/me` — returns userId, username, role, status, lastLoginAt |
| Last Login Tracking | ✅ | Stores `lastLoginAt`, `lastLoginIp`, `lastLoginDevice` on every successful login |
| Force Password Change Flag | ✅ | Admin can force users to change password before accessing any API |
| Status Management | ✅ | `ACTIVE`, `INACTIVE`, `PENDING_APPROVAL` — admin-controlled |
| Enable / Disable Access | ✅ | `enabled=false` blocks login; tokens revoked immediately on disable |

### 📊 Audit & Monitoring

| Feature | Status | Detail |
|---------|--------|--------|
| Tamper-Evidence Design | ✅ | `AuditLog` has no update path — `@PrePersist` sets `createdAt`, entity is write-once |
| Captures 40+ Event Types | ✅ | `LOGIN`, `LOGOUT`, `TOKEN_REUSE_ATTACK`, `ACCOUNT_LOCKED`, `REGISTRATION_APPROVED`, and 35+ more |
| Independent Transaction | ✅ | `@Transactional(propagation = REQUIRES_NEW)` — audit never blocks or rolls back business logic |
| Fault-Tolerant | ✅ | `try-catch` inside `AuditService.log()` — audit failure never breaks login, payment, or admin ops |
| Full Request Metadata | ✅ | Captures `userId`, `username`, `role`, `action`, `status`, `endpoint`, `httpMethod`, `ipAddress`, `deviceInfo` |
| IPv6-Ready IP Capture | ✅ | `RequestInfoUtil.getClientIp()` handles `X-Forwarded-For` and stores up to 100 chars |
| DB Indexed for Performance | ✅ | Indexes on `user_id`, `action`, `status`, `created_at` |
| Paginated Audit Log API | ✅ | `GET /api/v1/admin/audit/logs` with `Pageable` |
| Per-User Audit History | ✅ | `GET /api/v1/admin/audit/users/{userId}` |
| Failed Login Report | ✅ | `GET /api/v1/admin/audit/security/failed-logins` |
| Suspicious Activity Report | ✅ | `GET /api/v1/admin/audit/security/suspicious` |
| Audit Statistics Dashboard | ✅ | `GET /api/v1/admin/audit/statistics` |

### 📩 OTP System

| Feature | Status | Detail |
|---------|--------|--------|
| OTP Hashing | ✅ | OTP stored as `bcrypt` hash — plain text **never** stored in DB |
| 5-Minute Expiry | ✅ | `expiryTime = Instant.now().plusSeconds(300)` |
| Purpose Tagging | ✅ | `OtpPurpose` enum: `REGISTER`, `RESET_PASSWORD` — wrong purpose = rejection |
| Attempt Limiting | ✅ | Max 5 attempts; blocked on 6th regardless of correctness |
| Attempt Timestamp | ✅ | `lastAttemptAt` tracked per attempt |
| OTP Reuse Prevention | ✅ | `used=true` flag set on first valid use; reuse throws exception |
| Old OTP Invalidation | ✅ | `otpRepository.invalidateAllActiveOtps(email)` called before issuing new OTP |
| Constant-Time Comparison | ✅ | `passwordEncoder.matches()` used — immune to timing attacks |

---

## 🗂️ Full Project Structure

```
```
src/main/java/com/harinitech/springboot_security_jwt_rbac_app1/
│
├── 📁 config/
│   ├── AppConfig.java              → BCryptPasswordEncoder bean (strength configurable)
│   ├── AuditConfig.java            → @EnableJpaAuditing activation
│   ├── AuditorAwareImpl.java       → Resolves current userId (Long) for JPA createdBy/updatedBy
│   ├── SecurityConfig.java         → Full filter chain: CORS, CSRF-off, stateless, headers,
│   │                                  PUBLIC_AUTH_MATCHERS, PUBLIC_USER_MATCHERS, SWAGGER_MATCHERS
│   ├── SwaggerConfig.java          → SpringDoc OpenAPI configuration with JWT Bearer auth
│   └── TimeZoneConfig.java         → UTC timezone enforcement across JVM + Hibernate + Jackson
│
├── 📁 controller/
│   ├── AuthController.java         → login, refresh-token, validate-token, logout,
│   │                                  logout-all, sessions, revoke-session
│   ├── UserController.java         → register, send-otp, profile, change-password,
│   │                                  forgot-password, reset-password, employee-register
│   ├── AdminController.java        → force-logout, revoke-tokens, lock/unlock, enable/disable,
│   │                                  maintenance-mode, cache-clear, statistics,
│   │                                  pending-registrations, approve, reject, permanent-delete
│   └── AuditController.java        → audit logs (paginated), by-user, failed-logins,
│                                      suspicious, statistics
│
├── 📁 entity/
│   ├── Auditable.java              → JPA base class: createdBy, updatedBy, createdAt, updatedAt
│   ├── User.java                   → Full user entity: auth, role, status, lock, OTP,
│   │                                  lastLoginAt/Ip/Device, forcePasswordChange, requestedRole
│   ├── Role.java                   → Role entity with ManyToMany Permissions, @PrePersist normalize
│   ├── Permission.java             → Permission entity, name auto-uppercased
│   ├── UserToken.java              → Token entity: access+refresh tokens, expiry, revoked,
│   │                                  expired, refreshUsed, deviceInfo, ipAddress, tokenId (UUID)
│   ├── OtpToken.java               → OTP entity: otpHash (bcrypt), expiryTime, used, attempts,
│   │                                  lastAttemptAt, purpose
│   └── AuditLog.java               → Write-once audit entity: full request metadata, indexed
│
├── 📁 filter/
│   └── JwtFilter.java              → 9-step validation pipeline:
│                                      1. Bearer header extraction
│                                      2. SecurityContext clear
│                                      3. JWT cryptographic validation
│                                      4. Token type enforcement (ACCESS only)
│                                      5. DB revocation + expiry check
│                                      6. DB access_expiry timestamp check
│                                      7. userId/role/permissions extraction
│                                      8. Force-password-change gate (403 with JSON body)
│                                      9. Authority building + SecurityContext population
│
├── 📁 service/
│   ├── IAuthService.java           → Auth service interface
│   ├── AuthServiceImpl.java        → Login, refresh, logout, logout-all, validate-token,
│   │                                  sessions, revoke-session — userId-based throughout
│   ├── IAdminService.java          → Admin service interface (20+ method contracts)
│   ├── AdminServiceImpl.java       → Full admin operations with dual-gate permission checks,
│   │                                  self-guard, hierarchical approval
│   ├── IUserService.java           → User service interface
│   ├── UserServiceImpl.java        → OTP registration, employee registration, profile,
│   │                                  password management, admin notification
│   ├── AuditService.java           → Independent-transaction audit logger, fault-tolerant
│   ├── AuditQueryService.java      → Read-side: paginated logs, per-user, failed-logins,
│   │                                  suspicious, statistics
│   ├── EmailService.java           → SendGrid integration: OTP, approval, rejection, notification
│   ├── LoginAttemptService.java    → REQUIRES_NEW transaction: failed attempt tracking,
│   │                                  account lockout, attempt reset
│   └── TokenCleanupService.java    → Scheduled cleanup of expired tokens from DB
│
├── 📁 security/
│   ├── RoleInitializationService.java → CommandLineRunner @Order(1): creates 22+ permissions,
│   │                                     syncs 5 roles with permission sets idempotently
│   └── UserDataInitializer.java    → Seeds default ADMIN user on startup (if enabled by flag)
│
├── 📁 entity/ (continued)
│   └── passwordreset/
│       ├── PasswordResetToken.java
│       ├── PasswordResetTokenRepository.java
│       ├── ForgotPasswordRequest.java
│       └── ResetPasswordRequest.java
│
├── 📁 model/ (DTOs, Requests, Enums)
│   ├── JwtRequest.java             → { username, password }
│   ├── JwtResponse.java            → { accessToken, refreshToken, role }
│   ├── ApiResponse.java            → Unified API response wrapper: { success, message, data }
│   ├── RegisterRequest.java        → { username, password, otp }
│   ├── EmployeeRegisterRequest.java → { email, password, otp, requestedRole }
│   ├── ChangePasswordRequest.java  → { currentPassword, newPassword, confirmPassword }
│   ├── UserResponseDto.java        → { userId, username, role, status, enabled, lastLoginAt }
│   ├── UserSummaryDto.java         → Lightweight user summary for lists
│   ├── UserMapper.java             → Static mapper: User → UserResponseDto / UserSummaryDto
│   ├── AuditAction.java            → 40+ audit event constants enum
│   ├── AuditStatus.java            → SUCCESS, FAILED, BLOCKED, WARNING
│   ├── OtpPurpose.java             → REGISTER, RESET_PASSWORD
│   ├── Status.java                 → ACTIVE, INACTIVE, PENDING_APPROVAL
│   ├── RoleUpdateRequest.java      → { role }
│   └── TokenInfo.java              → Token metadata wrapper
│
├── 📁 repo/
│   ├── UserRepository.java         → findByUsername, findByStatus
│   ├── UserTokenRepository.java    → findByAccessToken, findByRefreshToken,
│   │                                  findAllByUserAndRevokedFalseAndExpiredFalse
│   ├── RoleRepository.java         → findByName
│   ├── PermissionRepository.java   → findByName
│   ├── OtpRepository.java          → findTopByUsernameOrderByIdDesc, invalidateAllActiveOtps
│   └── AuditLogRepository.java     → Pageable queries by user, action, status
│
├── 📁 utility/
│   ├── JwtUtility.java             → generateAccessToken(userId, role, permissions),
│   │                                  generateRefreshToken(userId), extractUserId,
│   │                                  extractRole, extractPermissions, extractTokenType,
│   │                                  isTokenValid
│   ├── RequestInfoUtil.java        → getClientIp (X-Forwarded-For aware), getDeviceInfo
│   └── TokenCleanupScheduler.java  → @Scheduled cleanup task for expired tokens
│
└── 📁 exceptions/
├── ErrorResponse.java          → { timestamp, status, error, message, path }
└── GlobalExceptionHandler.java → Handles: BadCredentials, Disabled, Locked,
RuntimeException, MethodArgumentNotValid,
AccessDenied, AuthenticationException

---

## 🔐 JWT Architecture — Deep Dive

### The Core Design Decision: `userId` as JWT Subject

> **This is the most important architectural decision in this entire project and is the source of multiple critical bugs that were fixed during development.**

**The problem with `username` (email) as JWT subject:**
User registers with email: john@old.com
JWT issued: { "sub": "john@old.com" }
User changes email to: john@new.com
JwtFilter extracts sub = "john@old.com"
loadUserByUsername("john@old.com") → UserNotFoundException
User forcibly logged out on every email change ← BUG

**The fix: `userId` (Long DB primary key) as JWT subject:**
User registers → userId = 42 assigned by DB
JWT issued: { "sub": "42" }
User changes email (username) to anything
JwtFilter extracts sub = "42"
userRepository.findById(42L) → ALWAYS works
Session unaffected by username changes ← CORRECT

### JWT Payload Structure

**Access Token** (valid 15 minutes):
```json
{
  "sub": "42",
  "role": "ADMIN",
  "permissions": ["DELETE_USER", "FORCE_LOGOUT", "VIEW_AUDIT_LOGS", "...22 more"],
  "tokenType": "ACCESS",
  "iat": 1716700000,
  "exp": 1716700900
}
```

**Refresh Token** (valid 7 days):
```json
{
  "sub": "42",
  "tokenType": "REFRESH",
  "iat": 1716700000,
  "exp": 1717304800
}
```

### Token Refresh Rotation Logic

```java
// When refresh is requested:
// 1. Find token in DB by refreshToken string
// 2. If already used/revoked/expired → TOKEN REUSE ATTACK detected
//    → revoke ALL sessions for this user immediately
//    → log AuditAction.TOKEN_REUSE_ATTACK
//    → throw exception
// 3. If valid → mark old token as revoked+expired+refreshUsed=true
// 4. Create NEW UserToken record with new access+refresh pair
// 5. Return new token pair to client
```

### Security Filter Chain (9 Steps in JwtFilter)

Incoming Request
│
▼
[Step 1] Extract Bearer token from Authorization header
│ No header? → pass through (public endpoints)
▼
[Step 2] SecurityContextHolder.clearContext() (thread safety)
▼
[Step 3] JWT cryptographic validation (jwtUtility.isTokenValid)
│ Invalid? → mark DB token expired → return 401
▼
[Step 4] Token type check (tokenType == "ACCESS")
│ REFRESH token used as ACCESS? → return 401
▼
[Step 5] DB lookup — check revoked/expired flags
│ Revoked or expired? → return 401
▼
[Step 6] DB access_expiry timestamp check (handles clock drift)
│ Past expiry? → set expired=true in DB → return 401
▼
[Step 7] Extract userId, role, permissions from JWT claims
│ Null claims? → return 401
▼
[Step 8] forcePasswordChange check
│ Flag set + not on allowed path? → return 403 with JSON body
▼
[Step 9] Build authorities + set SecurityContext
└──► filterChain.doFilter() → controller

---

## 🛡️ RBAC System — Deep Dive

### Role Hierarchy

ADMIN ──────────────────────────────────────────────────────────────
└── READ_USER, CREATE_USER, UPDATE_USER, DELETE_USER, VIEW_USERS
└── UPDATE_USER_STATUS, TOGGLE_USER_ACCESS, ACCOUNT_LOCK, ACCOUNT_UNLOCK
└── FORCE_LOGOUT, REVOKE_TOKEN, SESSION_REVOKE
└── ASSIGN_ADMIN, ASSIGN_MANAGER, ASSIGN_HR, ASSIGN_VENDOR
└── VIEW_AUDIT_LOGS, VIEW_SECURITY_EVENTS, VIEW_AUDIT_DASHBOARD
└── VIEW_SECURITY_STATISTICS, VIEW_SYSTEM_STATISTICS
└── SYSTEM_ADMIN, HELLO_USERS
MANAGER ─────────────────────────────────────────────────────────────
└── READ_USER, CREATE_USER, UPDATE_USER, VIEW_USERS
└── ASSIGN_HR, ASSIGN_VENDOR, HELLO_USERS
HR ──────────────────────────────────────────────────────────────────
└── READ_USER, HELLO_USERS
USER ────────────────────────────────────────────────────────────────
└── HELLO_USERS
VENDOR ──────────────────────────────────────────────────────────────
└── (no permissions — restricted access)

### Dual-Gate Permission Enforcement

```java
// GATE 1 — Controller level
@PreAuthorize("hasAuthority('DELETE_USER')")
public ResponseEntity<?> deleteUserPermanently(@PathVariable Long id) { ... }

// GATE 2 — Service level (defense-in-depth)
private void requirePermission(String permission) {
    boolean hasPermission = SecurityContextHolder.getContext()
        .getAuthentication().getAuthorities().stream()
        .anyMatch(a -> a.getAuthority().equals(permission));
    if (!hasPermission) {
        auditService.log(AuditAction.ACCESS_DENIED, ...);
        throw new RuntimeException("Access denied. Missing permission: " + permission);
    }
}
```

### Hierarchical Registration Approval

```java
private static final Map<String, Set<String>> APPROVAL_HIERARCHY = Map.of(
    "ADMIN",   Set.of("MANAGER", "EMPLOYEE", "VENDOR", "HR", "FINANCE", "SUPPORT"),
    "MANAGER", Set.of("VENDOR", "HR", "EMPLOYEE", "SUPPORT"),
    "HR",      Set.of("EMPLOYEE")
);
// MANAGER cannot approve ADMIN — only ADMIN can approve ADMIN
// HR cannot approve MANAGER — only ADMIN/MANAGER can
```

### Auto-Role Seeding at Startup

`RoleInitializationService` implements `CommandLineRunner` with `@Order(1)`:
- Creates **22 permissions** if they don't exist
- Syncs **5 roles** with their assigned permission sets
- Completely **idempotent** — safe to restart server at any time
- Runs before `UserDataInitializer` due to ordering

---

## 📡 Complete API Reference

### 🔐 Auth Endpoints (`/api/v1/auth`)

| Method | Endpoint | Auth Required | Permission | Description |
|--------|----------|--------------|------------|-------------|
| `POST` | `/login` | ❌ | — | Login with username + password → returns access + refresh token |
| `POST` | `/refresh-token` | ❌ | — | Exchange valid refresh token for new token pair |
| `POST` | `/validate-token` | ❌ | — | Check if a token is valid, active, not revoked |
| `POST` | `/logout` | ✅ | `isAuthenticated()` | Revoke current session's token pair |
| `POST` | `/logout-all` | ✅ | `isAuthenticated()` | Revoke ALL active sessions for current user |
| `GET`  | `/sessions` | ✅ | `isAuthenticated()` | List all active sessions (device, IP, expiry) |
| `DELETE` | `/sessions/{id}` | ✅ | `isAuthenticated()` | Revoke one specific session by ID |

### 👤 User Endpoints (`/api/v1/users`)

| Method | Endpoint | Auth Required | Permission | Description |
|--------|----------|--------------|------------|-------------|
| `GET`  | `/` | ✅ | `VIEW_USERS` | Fetch all users (DTO) |
| `GET`  | `/me` | ✅ | `isAuthenticated()` | Get current user profile |
| `POST` | `/send-registration-otp` | ❌ | — | Send OTP to email for registration |
| `POST` | `/register` | ❌ | — | Register with OTP verification |
| `POST` | `/employee-register` | ❌ | — | Submit employee registration (PENDING_APPROVAL) |
| `POST` | `/forgot-password` | ❌ | — | Request password reset OTP |
| `POST` | `/reset-password` | ❌ | — | Reset password with OTP |
| `POST` | `/change-password` | ✅ | `isAuthenticated()` | Change password (requires current password) |

### 🔴 Admin Endpoints (`/api/v1/admin`) — Requires `ROLE_ADMIN`

| Method | Endpoint | Additional Permission | Description |
|--------|----------|----------------------|-------------|
| `GET`  | `/users` | `VIEW_USERS` | Get all users (summary DTOs) |
| `GET`  | `/users/{id}` | `VIEW_USERS` | Get user detail by ID |
| `PUT`  | `/users/{id}/role` | `ASSIGN_{ROLE}` | Update user's role |
| `PUT`  | `/users/{id}/status` | `UPDATE_USER_STATUS` | Set ACTIVE/INACTIVE |
| `PUT`  | `/users/{id}/lock` | `ACCOUNT_LOCK` | Lock user account |
| `PUT`  | `/users/{id}/unlock` | `ACCOUNT_UNLOCK` | Unlock user account |
| `PUT`  | `/users/{id}/enable` | `TOGGLE_USER_ACCESS` | Enable user access |
| `PUT`  | `/users/{id}/disable` | `TOGGLE_USER_ACCESS` | Disable + revoke tokens |
| `POST` | `/users/{id}/force-logout` | `FORCE_LOGOUT` | Force logout (revoke all sessions) |
| `POST` | `/users/{id}/revoke-tokens` | `REVOKE_TOKEN` | Revoke all tokens |
| `POST` | `/users/{id}/invalidate-sessions` | `SESSION_REVOKE` | Invalidate all sessions |
| `DELETE` | `/users/{id}/permanent` | `DELETE_USER` | Hard delete user |
| `GET`  | `/pending-registrations` | `VIEW_USERS` | View pending employee registrations |
| `POST` | `/registrations/{id}/approve` | `ASSIGN_{ROLE}` | Approve with assigned role |
| `POST` | `/registrations/{id}/reject` | `UPDATE_USER_STATUS` | Reject with reason |
| `PUT`  | `/system/maintenance-mode/enable` | `SYSTEM_ADMIN` | Enable maintenance mode |
| `PUT`  | `/system/maintenance-mode/disable` | `SYSTEM_ADMIN` | Disable maintenance mode |
| `POST` | `/system/cache/clear` | `SYSTEM_ADMIN` | Clear system cache |
| `POST` | `/system/permissions/refresh` | `SYSTEM_ADMIN` | Refresh permissions cache |
| `GET`  | `/statistics/system` | `VIEW_SYSTEM_STATISTICS` | User counts by role/status |
| `GET`  | `/statistics/security` | `VIEW_SECURITY_STATISTICS` | Token counts, locked accounts |

### 📊 Audit Endpoints (`/api/v1/admin/audit`) — Requires `ROLE_ADMIN`

| Method | Endpoint | Permission | Description |
|--------|----------|------------|-------------|
| `GET`  | `/logs` | `VIEW_AUDIT_LOGS` | All audit logs (paginated, sortable) |
| `GET`  | `/logs/{id}` | `VIEW_AUDIT_LOGS` | Single audit log entry |
| `GET`  | `/users/{userId}` | `VIEW_AUDIT_LOGS` | Full history for a specific user |
| `GET`  | `/security/failed-logins` | `VIEW_SECURITY_EVENTS` | All failed login events |
| `GET`  | `/security/suspicious` | `VIEW_SECURITY_EVENTS` | Suspicious activity events |
| `GET`  | `/statistics` | `VIEW_AUDIT_DASHBOARD` | Dashboard statistics |

---

## 📩 OTP System

The OTP system is designed with multiple security controls that go far beyond a simple 6-digit code:

```java
// OTP Generation — using SecureRandom (cryptographically secure)
private static final SecureRandom secureRandom = new SecureRandom();
private String generateOtp() {
    int otp = secureRandom.nextInt(900000) + 100000; // Always 6 digits
    return String.valueOf(otp);
}

// OTP Storage — NEVER store plain text
OtpToken token = OtpToken.builder()
    .username(normalizedEmail)
    .otpHash(passwordEncoder.encode(otp))   // bcrypt hash stored
    .expiryTime(Instant.now().plusSeconds(300)) // 5 min expiry
    .used(false)
    .attempts(0)
    .purpose(OtpPurpose.REGISTER)            // purpose-locked
    .build();

// Before saving → invalidate ALL previous OTPs for this email
otpRepository.invalidateAllActiveOtps(normalizedEmail);
```

### OTP Validation Security Checks (in order)

1. ✅ Load most recent OTP by email
2. ✅ Check attempt count — block at 5 attempts
3. ✅ Check `purpose` matches expected (cross-purpose attacks blocked)
4. ✅ Check `used=false` (reuse blocked)
5. ✅ Check `expiryTime` not in the past
6. ✅ `passwordEncoder.matches(input, hash)` — constant-time bcrypt compare
7. ✅ If wrong — increment `attempts`, update `lastAttemptAt`, save
8. ✅ If correct — mark `used=true`, invalidate all active OTPs for email

---

## 📬 Email Notification System

Powered by **SendGrid Java SDK 4.10.0** — four distinct email types:

| Email Type | Trigger | Recipient |
|-----------|---------|-----------|
| OTP Email | Registration or password reset OTP requested | Requester |
| Pending Approval Notification | New employee registers | All ADMIN users in system |
| Approval Confirmation | Admin approves registration | Approved employee |
| Rejection Notice | Admin rejects registration | Rejected employee |

All emails use **responsive HTML templates** built inline with inline styles for maximum email client compatibility.

---

## 📊 Audit Logging System

Every security-significant event in the system is logged with full context:
AuditLog record structure:
┌─────────────────────────────────────────────────────┐
│ id           → Auto-generated PK                    │
│ userId       → Who performed the action (nullable)  │
│ username     → Email, or "ANONYMOUS" for public     │
│ role         → "ADMIN" / "USER" / "PUBLIC"          │
│ action       → AuditAction enum (40+ values)        │
│ status       → SUCCESS / FAILED / BLOCKED / WARNING │
│ details      → Human-readable description           │
│ endpoint     → /api/v1/auth/login                   │
│ httpMethod   → POST / GET / DELETE                  │
│ ipAddress    → Client IP (X-Forwarded-For aware)    │
│ deviceInfo   → User-Agent string                    │
│ createdAt    → Instant.now() via @PrePersist        │
└─────────────────────────────────────────────────────┘

### Complete AuditAction Enum (40+ events)

```java
// Auth
LOGIN, LOGOUT, TOKEN_REFRESH, VALIDATE_TOKEN, LOGOUT_ALL

// Security
TOKEN_REUSE_ATTACK, INVALID_TOKEN, REVOKED_TOKEN_USAGE,
EXPIRED_TOKEN_USAGE, ACCOUNT_LOCKED, ACCOUNT_UNLOCKED,
SELF_ACTION_BLOCKED, ACCESS_DENIED, FORCE_LOGOUT,
SESSION_REVOKED, SESSION_INVALIDATED, TOKEN_REVOKED,
VIEW_ACTIVE_SESSIONS

// User
REGISTER, REGISTRATION_OTP_SENT, VIEW_PROFILE,
VIEW_USERS, VIEW_USER, DELETE_USER, PASSWORD_CHANGED,
PASSWORD_RESET, PASSWORD_RESET_REQUEST, ROLE_CHANGED,
STATUS_CHANGED, ACCESS_TOGGLED

// Employee Workflow
REGISTRATION_APPROVED, REGISTRATION_REJECTED,
VIEW_PENDING_REGISTRATIONS

// OTP
OTP_FAILED

// System
SYSTEM_MAINTENANCE_ENABLED, SYSTEM_MAINTENANCE_DISABLED,
SYSTEM_CACHE_CLEARED, PERMISSION_CACHE_REFRESHED
```

---

## 🔒 Brute Force & Account Lockout

The `LoginAttemptService` uses `@Transactional(propagation = REQUIRES_NEW)` to ensure failed attempts are **always committed to the DB**, even if the outer login transaction rolls back.

Login Flow with Brute Force Protection:
────────────────────────────────────────
Attempt 1-4:  → credentials wrong → increment failedLoginAttempts → save
Attempt 5:    → credentials wrong → failedLoginAttempts >= max (5)
→ accountLocked = true
→ lockTime = Instant.now()
→ AuditAction.ACCOUNT_LOCKED logged
→ User receives "account locked" response
Next login attempt (while locked):
→ unlockIfLockExpired() called
→ If lockTime + 900000ms (15 min) < now → auto-unlock
→ failedLoginAttempts = 0, accountLocked = false, lockTime = null
→ If still within lock period → throw RuntimeException (blocked)
Successful login:
→ loginAttemptService.resetFailedAttempts()
→ failedLoginAttempts = 0, accountLocked = false, lockTime = null

**Configuration:**
```properties
security.account.max-login-attempts=5
security.account.lock-duration-ms=900000   # 15 minutes
```

---

## ⚙️ Configuration Reference

```properties
# ─── SERVER ───────────────────────────────────────────────────────
server.port=8181

# ─── DATABASE ─────────────────────────────────────────────────────
spring.datasource.url=jdbc:mysql://localhost:3306/jwt_security?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
spring.jpa.open-in-view=false              # Disabled (prevents N+1 issues)
spring.jpa.show-sql=true

# ─── JWT ──────────────────────────────────────────────────────────
jwt.secret=<256-bit-hex-key>
jwt.access-token-expiration-ms=900000      # 15 minutes
jwt.refresh-token-expiration-ms=604800000  # 7 days

# ─── SECURITY ─────────────────────────────────────────────────────
security.account.max-login-attempts=5
security.account.lock-duration-ms=900000   # 15 minutes auto-unlock

# ─── EMAIL (SendGrid) ─────────────────────────────────────────────
sendgrid.api.key=SG.xxxx
sendgrid.sender.email=youremail@domain.com
sendgrid.sender.name=YourAppName

# ─── SWAGGER ──────────────────────────────────────────────────────
springdoc.api-docs.enabled=true
springdoc.swagger-ui.enabled=true
springdoc.swagger-ui.path=/swagger-ui.html
springdoc.swagger-ui.operations-sorter=method
springdoc.swagger-ui.tags-sorter=alpha

# ─── TIMEZONE ─────────────────────────────────────────────────────
spring.jpa.properties.hibernate.jdbc.time_zone=UTC
spring.jackson.time-zone=UTC

# ─── CORS ─────────────────────────────────────────────────────────
allowed.origins=http://localhost:4200      # Add prod URL here
```

---

## 🐛 Bug Fixes & Resolutions

> Every bug listed here was discovered during actual development, debugged, and properly fixed. No shortcuts.

### 🔴 Critical Bugs Fixed

| Bug | Root Cause | Fix Applied |
|-----|-----------|-------------|
| **Username-based JWT subject** | JWT sub = email → breaks on email change | Switched to `userId` (Long) as JWT subject across all layers |
| **Circular dependency: SecurityConfig ↔ AuthServiceImpl** | Both beans depend on each other at startup | Added `@Lazy` on `IAuthService` in `SecurityConfig` constructor |
| **Refresh token not invalidated on password change** | `changePassword()` only updated password field | Added `revokeAllActiveTokens(user)` + `SecurityContextHolder.clearContext()` after password update |
| **Refresh token reuse not detected** | No `refreshUsed` flag tracking | Added `refreshUsed` field to `UserToken`; on reuse: revoke ALL sessions + audit log `TOKEN_REUSE_ATTACK` |
| **Refresh token accepted as access token** | `JwtFilter` only checked JWT validity, not `tokenType` | Added explicit `tokenType` claim extraction and `!ACCESS.equals(tokenType)` check → 401 |
| **Account lockout not persisting** | `LoginAttemptService` used parent transaction that rolled back | Changed to `@Transactional(propagation = REQUIRES_NEW)` — committed separately |
| **Auto-unlock on login not re-loading user** | Stale user object used after unlock | Added explicit `user = getUserByUsername()` reload after `unlockIfLockExpired()` |
| **DB expiry not checked (clock drift bug)** | JWT valid but DB `accessExpiry` already past | Added explicit `dbToken.getAccessExpiry().isBefore(Instant.now())` check in `JwtFilter` |
| **Stack trace leaking in error responses** | `GlobalExceptionHandler` returned raw exception message | Replaced with structured `ErrorResponse` DTO; stack trace gated behind dev profile |
| **OTP plain text storage** | OTP stored directly in DB column | Replaced with `passwordEncoder.encode(otp)` → `otpHash` column |
| **OTP reuse possible** | No `used` flag on first valid verification | Added `used=true` flag; checked before allowing OTP to be accepted |
| **No OTP purpose validation** | Same OTP could be used for different operations | Added `OtpPurpose` enum; cross-purpose OTP use throws exception |
| **Admin could delete their own account** | No self-protection in delete endpoint | Added `guardSelf(userId, "delete")` in `AdminServiceImpl` |
| **Role change not invalidating tokens** | Tokens carried old permissions after role update | Added `revokeAllActiveTokens(targetUser)` in `updateUserRole()` |
| **Git merge conflict in application.properties** | Unresolved `<<<<<<< HEAD` marker remained | Identified and flagged; UTC timezone config applied from feature branch |
| **`spring.jpa.open-in-view=true` (default)** | LazyInitializationException risk + performance hit | Set `spring.jpa.open-in-view=false` explicitly |

### 🟡 In-Progress Fixes

| Bug ID | Issue | Status |
|--------|-------|--------|
| BUG-017 | `application.properties` contains **unresolved Git merge conflict markers** (`<<<<<<< HEAD`) | 🔄 Fixing — cleanup in next commit |
| BUG-018 | `sendgrid.api.key` hardcoded in `application.properties` — should be environment variable | 🔄 Moving to env-var / `.env` pattern |
| BUG-019 | `TokenCleanupService` runs on single thread — large token tables may timeout | 🔄 Adding batch-based cleanup |
| BUG-020 | `getSystemStatistics()` uses `findAll()` stream — O(n) for counting | 🔄 Replacing with `countByRole()` JPA query |

---

## 🗺️ Roadmap

> Features being actively built and committed to this repo daily.

### 🏃 This Week

- [ ] Fix unresolved Git merge conflict in `application.properties`
- [ ] Move all secrets to `.env` / environment variables (no hardcoded keys)
- [ ] Add `ASSIGN_EMPLOYEE` and `ASSIGN_FINANCE` to permission set
- [ ] Add `EMPLOYEE`, `FINANCE`, `SUPPORT` roles to `RoleInitializationService`
- [ ] Replace O(n) `findAll()` streams in statistics with dedicated JPA count queries

### 🏗️ Next 2 Weeks

- [ ] **Password History** — prevent last 5 password reuse
- [ ] **Username Change API** — safe username update with token continuity (already works via userId design)
- [ ] **Spring Boot Actuator** — `/actuator/health`, `/actuator/info` secured
- [ ] **Docker Compose** — MySQL + application containerized
- [ ] **Unit Tests** — JUnit 5 + Mockito for `AuthServiceImpl`, `AdminServiceImpl`, `JwtUtility`
- [ ] **Integration Tests** — `@SpringBootTest` + `MockMvc` for full auth flows

### 🔭 Planned Milestones

- [ ] **Redis Session Store** — move active token tracking to Redis for horizontal scaling
- [ ] **OAuth2 Social Login** — Google + GitHub
- [ ] **TOTP 2FA** — authenticator app QR code + verify endpoint
- [ ] **API Rate Limiting** — per-user + per-IP with configurable limits
- [ ] **Soft Delete** — `deletedAt` field instead of hard delete
- [ ] **Pagination on all list endpoints** — `Page<T>` responses everywhere
- [ ] **Kubernetes Deployment** — Helm chart + K8s manifests
- [ ] **OWASP ZAP CI** — automated security scan on each PR

---

## 🚀 Quick Start

### Prerequisites

Java 21+
Maven 3.8+
MySQL 8.x running on port 3306

### 1. Clone

```bash
git clone https://github.com/amarenderreddyvoladri/production-prototype-security-template.git
cd production-prototype-security-template
```

### 2. Database

MySQL database `jwt_security` is auto-created by `createDatabaseIfNotExist=true`. No manual setup needed.

### 3. Configure

Edit `src/main/resources/application.properties`:
```properties
spring.datasource.password=your_mysql_password
sendgrid.api.key=your_sendgrid_key
sendgrid.sender.email=your_verified_sender@domain.com
jwt.secret=your_256_bit_secret_minimum
```

### 4. Run

```bash
./mvnw spring-boot:run
```

Application starts on: `http://localhost:8181`

### 5. Explore API

Swagger UI: **`http://localhost:8181/swagger-ui.html`**

### 6. Default Admin Credentials
Username: admin@example.com
Password: Admin@123

*(Seeded by `UserDataInitializer` on first run)*

---

## 👨‍💻 About the Developer

<table>
<tr>
<td>

**Amarender Reddy Voladri**
Full-Stack Developer | Spring Boot Specialist | Security-Focused Engineer

I built this project not to follow a tutorial, but to deeply understand every tradeoff in security engineering — from why `userId` must be the JWT subject to why audit logs must run in independent transactions. Every architecture decision, every bug, every fix in this project is something I debugged myself, understood fully, and documented in code.

**Skills demonstrated in this project:**
- Spring Boot 3.x + Spring Security 6 production configuration
- Stateless JWT with full token lifecycle management
- RBAC with fine-grained permission enforcement at multiple layers
- OTP-based email verification with bcrypt hashing
- JPA Auditing, entity design, and relationship modeling
- Production bug identification and root-cause analysis
- Clean, layered architecture with separation of concerns

</td>
</tr>
</table>

[![LinkedIn](https://img.shields.io/badge/LinkedIn-Connect-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://linkedin.com/in/amarenderreddyvoladri)
[![GitHub](https://img.shields.io/badge/GitHub-Follow-181717?style=for-the-badge&logo=github&logoColor=white)](https://github.com/amarenderreddyvoladri)

---

## 📜 License
MIT License
Free to use, study, modify, and distribute with attribution.

---

<div align="center">

<img src="https://capsule-render.vercel.app/api?type=waving&color=0:0f0c29,50:302b63,100:24243e&height=120&section=footer&animation=twinkling" width="100%"/>

**⭐ If this project demonstrates the kind of engineering quality you're looking for, please star it.**
**Every star is a signal to recruiters, managers, and senior engineers that this work stands out.**

*This project is updated daily. Watch this repository to follow progress in real time.*

![Visitor Badge](https://visitor-badge.laobi.icu/badge?page_id=amarenderreddyvoladri.production-prototype-security-template&color=7b2fbe)

</div>
