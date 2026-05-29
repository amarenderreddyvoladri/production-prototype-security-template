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
![Visitor Badge](https://visitor-badge.laobi.icu/badge?page_id=amarenderreddyvoladri.production-prototype-security-template&color=7b2fbe)

<br/>

> ### 🚀 *"Security is not a feature you add at the end — it is the foundation you build from the start. I am building mine, commit by commit, every single day."*

</div>

---

> ### 🚨 ACTIVE DEVELOPMENT NOTICE
> **This project is under daily, continuous development.** Security bugs are being fixed, new enterprise features are being added, and every architectural decision is hardened with real debugging and documented reasoning. This is a **living, production-style security system** — not a tutorial copy-paste. Every line of code here was written, broken, debugged, and understood by me personally.

---

## 📋 Table of Contents

| # | Section |
|---|---------|
| 01 | [🎯 What This Project Is & Why It Exists](#-what-this-project-is--why-it-exists) |
| 02 | [🏗️ System Architecture](#️-system-architecture) |
| 03 | [🛠️ Tech Stack](#️-tech-stack) |
| 04 | [⚡ Complete Feature Matrix](#-complete-feature-matrix) |
| 05 | [🗂️ Full Project Structure](#️-full-project-structure) |
| 06 | [✅ Implemented Concepts — Deep Dive](#-implemented-concepts--deep-dive) |
| 07 | [🔐 JWT Architecture — The Critical Design Decision](#-jwt-architecture--the-critical-design-decision) |
| 08 | [🔒 Security Filter Chain — 9-Step JwtFilter Pipeline](#-security-filter-chain--9-step-jwtfilter-pipeline) |
| 09 | [👑 RBAC System — Role & Permission Hierarchy](#-rbac-system--role--permission-hierarchy) |
| 10 | [📊 Audit Logging System](#-audit-logging-system) |
| 11 | [🔴 Brute Force Protection & Account Lockout](#-brute-force-protection--account-lockout) |
| 12 | [📩 OTP System — Secure by Design](#-otp-system--secure-by-design) |
| 13 | [📬 Email Notification System](#-email-notification-system) |
| 14 | [📡 Complete API Reference](#-complete-api-reference) |
| 15 | [⚙️ Configuration Reference](#️-configuration-reference) |
| 16 | [🐛 Bug Fixes & Root Cause Resolutions](#-bug-fixes--root-cause-resolutions) |
| 17 | [🗺️ Roadmap — What's Coming Next](#️-roadmap--whats-coming-next) |
| 18 | [🚀 Quick Start](#-quick-start) |
| 19 | [📈 My Learning Philosophy](#-my-learning-philosophy) |
| 20 | [👨‍💻 About the Developer](#-about-the-developer) |

---

## 🎯 What This Project Is & Why It Exists

This is a **fully hand-crafted, production-prototype Spring Boot Security system** built from scratch using **Java 21, Spring Boot 3.4.5, Spring Security 6, and JJWT 0.11.5**. Every major security concept that modern enterprise applications require is implemented here — not from a tutorial, but through genuine architectural thinking, real bug-fixing sessions, and decisions documented directly in the code.

### Why Most Security Tutorials Fail — And How This Project Fixes It

| What tutorials teach ❌ | What this project implements ✅ |
|---|---|
| Username (email) as JWT subject — breaks on email change | `userId` (Long DB PK) as JWT subject — always stable |
| No token revocation — logout is fake | DB-backed revocation — `revoked + expired` flags checked per request |
| No audit trail | 40+ event types, write-once, independent transaction |
| No brute force protection | 5-attempt lockout, 15-min auto-unlock, `REQUIRES_NEW` tx |
| No OTP verification | bcrypt-hashed OTP, purpose-locked, attempt-limited |
| Just `ROLE_ADMIN` and `ROLE_USER` | 5 roles, 22+ fine-grained permissions, dual-gate enforcement |
| No token reuse detection | Refresh token reuse → all sessions revoked immediately |
| No employee approval workflow | `PENDING_APPROVAL` state, admin approval queue with emails |

> 💡 **Every item in the right column above was a real problem I discovered, debugged, and solved myself during development — not a checklist I read somewhere.**

---

## 🏗️ System Architecture

```
                    ┌──────────────────────────────────────────────┐
                    │         CLIENT  (Browser / Postman / App)     │
                    └──────────────────┬───────────────────────────┘
                                       │  HTTP  +  Authorization: Bearer <token>
                                       │
                    ┌──────────────────▼───────────────────────────┐
                    │           🔒 JWT FILTER  (9 Steps)            │
                    │   Runs OncePerRequest — before every route    │
                    │   Bearer → Crypto → Type → DB → Expiry →     │
                    │   Claims → ForceChange → SecurityContext      │
                    └──────────────────┬───────────────────────────┘
                                       │  Authenticated Principal
                    ┌──────────────────▼───────────────────────────┐
                    │        🛡️  SPRING SECURITY FILTER CHAIN       │
                    │  CORS → CSRF-off → STATELESS → Headers       │
                    │  PUBLIC_AUTH_MATCHERS  (no token needed)      │
                    │  PUBLIC_USER_MATCHERS  (register/OTP/reset)   │
                    │  SWAGGER_MATCHERS      (docs access)          │
                    │  @PreAuthorize         (permission gate)      │
                    └────────┬────────────────┬─────────────────────┘
                             │                │
               ┌─────────────▼───┐  ┌─────────▼──────────────────┐
               │  🔑 AUTH        │  │  👤 USER     🔧 ADMIN       │
               │  CONTROLLER     │  │  CONTROLLER  CONTROLLER     │
               │  /api/v1/auth/* │  │  /api/v1/users/*            │
               │                 │  │  /api/v1/admin/*            │
               │  login          │  │  register     force-logout  │
               │  refresh        │  │  send-otp     approve       │
               │  logout         │  │  profile      reject        │
               │  sessions       │  │  change-pwd   lock/unlock   │
               └────────┬────────┘  └─────────┬──────────────────┘
                        │                     │
               ┌────────▼─────────────────────▼─────────────────┐
               │              🗄️  SERVICE LAYER                   │
               │  AuthServiceImpl  |  AdminServiceImpl           │
               │  UserServiceImpl  |  LoginAttemptService        │
               │  AuditService     |  TokenCleanupService        │
               │  EmailService     |  AuditQueryService          │
               └────────┬─────────────────────┬─────────────────┘
                        │                     │
               ┌────────▼──────────┐  ┌───────▼──────────────────┐
               │  🗄️ MySQL Database │  │  📧 SendGrid API          │
               │  users            │  │  OTP emails               │
               │  roles            │  │  Approval notifications   │
               │  permissions      │  │  Rejection notices        │
               │  user_tokens      │  │  Admin alerts             │
               │  otp_tokens       │  └──────────────────────────┘
               │  audit_logs       │
               │  password_reset   │
               └───────────────────┘
```

---

## 🛠️ Tech Stack

| Layer | Technology | Version | Purpose |
|---|---|---|---|
| **Language** | Java | 21 | Records, pattern matching, modern APIs |
| **Framework** | Spring Boot | 3.4.5 | Application backbone |
| **Security** | Spring Security | 6.x | Filter chain, `@PreAuthorize`, method security |
| **JWT** | JJWT (api + impl + jackson) | 0.11.5 | Token generation, signing, parsing |
| **Database** | MySQL | 8.x | Persistent storage |
| **ORM** | Spring Data JPA + Hibernate | — | Entity management, repositories |
| **JPA Auditing** | Spring JPA Auditing | — | `@EnableJpaAuditing`, `AuditorAware<Long>` |
| **Email** | SendGrid Java SDK | 4.10.0 | Transactional email delivery |
| **Validation** | Spring Validation (Jakarta) | — | `@Valid`, `@NotBlank`, `@Email` |
| **API Docs** | SpringDoc OpenAPI (Swagger UI) | 2.8.6 | JWT Bearer auth in live Swagger UI |
| **Boilerplate** | Lombok | 1.18.38 | `@Data`, `@Builder`, `@Slf4j`, `@RequiredArgsConstructor` |
| **Build** | Maven | 3.x | Dependency management + build lifecycle |
| **Server** | Embedded Tomcat | — | Runs on port `8181` |
| **Timezone** | UTC Enforcement | — | JVM + Hibernate + Jackson all aligned |
| **Scheduling** | Spring `@Scheduled` | — | Automated expired token cleanup |

---

## ⚡ Complete Feature Matrix

> ✅ Implemented & Working | 🔄 In Progress | 🔜 Planned | 🐛 Recently Fixed

### 🔐 Authentication & Token Management

| Feature | Status | Implementation Detail |
|---|---|---|
| JWT Login | ✅ | `POST /api/v1/auth/login` — credentials verified via `AuthenticationManager` |
| Stateless Sessions | ✅ | `SessionCreationPolicy.STATELESS` — no `HttpSession` ever created |
| Access Token (15 min) | ✅ | Short-lived, embeds `userId`, `role`, `permissions[]`, `tokenType=ACCESS` |
| Refresh Token (7 days) | ✅ | Long-lived, DB-persisted, one-time-use only, `tokenType=REFRESH` |
| Token Refresh Rotation | ✅ | Old token marked `revoked+expired+refreshUsed=true`; new DB record created |
| Token Reuse Detection | ✅ | Replayed used refresh token → **ALL sessions revoked** + `TOKEN_REUSE_ATTACK` audit |
| Token Type Enforcement | ✅ | `JwtFilter` explicitly rejects any `REFRESH` token used as `ACCESS` → 401 |
| Token Validation Endpoint | ✅ | `POST /api/v1/auth/validate-token` — checks signature, expiry, revocation, DB state |
| Logout Single Session | ✅ | Marks current `access+refresh` pair as `revoked=true, expired=true` in DB |
| Logout All Devices | ✅ | Bulk-revokes all active sessions across every device for the user |
| Active Session Listing | ✅ | Returns `sessionId`, device info, IP, expiry per session |
| Individual Session Revoke | ✅ | Revoke one specific device session by token ID |
| Force Password Change Gate | ✅ | `JwtFilter` blocks all API access with `403` if `forcePasswordChange=true` |
| Post-Role-Change Revoke | ✅ | Role update immediately revokes all active tokens for that user |
| Post-Disable Revoke | ✅ | `enabled=false` blocks login AND revokes all tokens immediately |

### 🛡️ RBAC — Role-Based Access Control

| Feature | Status | Detail |
|---|---|---|
| 5 Built-in Roles | ✅ | `ADMIN`, `MANAGER`, `HR`, `USER`, `VENDOR` — auto-seeded at startup |
| 22+ Fine-Grained Permissions | ✅ | Named constants: `DELETE_USER`, `FORCE_LOGOUT`, `VIEW_AUDIT_LOGS`, etc. |
| Permissions Embedded in JWT | ✅ | Permission set in every token — **no DB call needed** per request |
| `@PreAuthorize` on All Endpoints | ✅ | Permission checked at controller level (Gate 1) |
| Defense-in-Depth — Gate 2 | ✅ | `requirePermission()` re-validated inside `AdminServiceImpl` — bypass impossible |
| `@EnableMethodSecurity` | ✅ | Activated in `SecurityConfig` for full method-level security support |
| Role Name Normalization | ✅ | `@PrePersist` / `@PreUpdate` on `Role` auto-uppercases role names |
| Idempotent Role Sync on Startup | ✅ | `RoleInitializationService` (`CommandLineRunner @Order(1)`) — safe to restart anytime |
| Hierarchical Approval Policy | ✅ | `ADMIN` approves `MANAGER/HR/VENDOR`; `MANAGER` approves `HR/VENDOR` — enforced in service |
| Self-Action Guard | ✅ | Admin cannot delete, lock, disable, or force-logout their own account |

### 👤 User Management

| Feature | Status | Detail |
|---|---|---|
| OTP-Verified Registration | ✅ | `send-registration-otp` → `register` — email verified before account creation |
| Employee Registration Flow | ✅ | `POST /employee-register` — creates account in `PENDING_APPROVAL` state |
| Admin Approval / Rejection | ✅ | Admin reviews queue, approves with role or rejects with reason + email |
| Password Change | ✅ | Validates current password, prevents reuse, forces re-login by token revocation |
| Forgot Password (OTP) | ✅ | Sends reset OTP; **does not reveal if email exists** — anti-enumeration compliant |
| Password Reset (OTP-Gated) | ✅ | OTP validated with purpose check (`RESET_PASSWORD`) before allowing reset |
| Profile Endpoint | ✅ | Returns `userId`, `username`, `role`, `status`, `lastLoginAt` |
| Last Login Tracking | ✅ | Stores `lastLoginAt`, `lastLoginIp`, `lastLoginDevice` on every successful login |
| Force Password Change Flag | ✅ | Admin-triggered; blocks all API access until changed |
| Status Management | ✅ | `ACTIVE`, `INACTIVE`, `PENDING_APPROVAL` — admin-controlled transitions |

### 📊 Audit & Monitoring

| Feature | Status | Detail |
|---|---|---|
| Tamper-Evidence Design | ✅ | `AuditLog` is write-once — `@PrePersist` only, no update path |
| 40+ Event Types | ✅ | `LOGIN`, `TOKEN_REUSE_ATTACK`, `ACCOUNT_LOCKED`, `REGISTRATION_APPROVED`, and 36+ more |
| Independent Transaction | ✅ | `@Transactional(propagation = REQUIRES_NEW)` — audit never blocks business logic |
| Fault-Tolerant Logging | ✅ | `try-catch` in `AuditService.log()` — failure never breaks login or admin ops |
| Full Request Metadata | ✅ | `userId`, `username`, `role`, `action`, `status`, `endpoint`, `method`, `ip`, `device` |
| IPv6-Ready IP Capture | ✅ | `X-Forwarded-For` aware, stores up to 100 chars |
| DB Indexed for Performance | ✅ | Indexes on `user_id`, `action`, `status`, `created_at` |
| Paginated Audit Log API | ✅ | Pageable queries with sort support |
| Failed Login Report | ✅ | Dedicated endpoint for security team review |
| Suspicious Activity Report | ✅ | Flags token reuse, rapid failed attempts, unusual patterns |

---

## 🗂️ Full Project Structure

```
src/main/java/com/harinitech/springboot_security_jwt_rbac_app1/
│
├── 📁 config/
│   ├── AppConfig.java              → BCryptPasswordEncoder bean (configurable strength)
│   ├── AuditConfig.java            → @EnableJpaAuditing activation
│   ├── AuditorAwareImpl.java       → Resolves current userId (Long) for createdBy/updatedBy
│   ├── SecurityConfig.java         → Full filter chain: CORS, CSRF-off, stateless,
│   │                                  PUBLIC_AUTH_MATCHERS, PUBLIC_USER_MATCHERS,
│   │                                  SWAGGER_MATCHERS, @EnableMethodSecurity
│   ├── SwaggerConfig.java          → SpringDoc OpenAPI 2.8.6 with JWT Bearer SecurityScheme
│   └── TimeZoneConfig.java         → UTC enforcement: JVM + Hibernate + Jackson aligned
│
├── 📁 controller/
│   ├── AuthController.java         → login, refresh-token, validate-token,
│   │                                  logout, logout-all, sessions, revoke-session
│   ├── UserController.java         → register, send-otp, profile, change-password,
│   │                                  forgot-password, reset-password, employee-register
│   ├── AdminController.java        → force-logout, revoke-tokens, lock/unlock,
│   │                                  enable/disable, maintenance-mode, cache-clear,
│   │                                  statistics, pending-registrations, approve,
│   │                                  reject, permanent-delete (20+ operations)
│   └── AuditController.java        → audit-logs (paginated), by-user, failed-logins,
│                                      suspicious-activity, statistics
│
├── 📁 entity/
│   ├── Auditable.java              → JPA base class: @CreatedBy, @LastModifiedBy,
│   │                                  @CreatedDate, @LastModifiedDate (auto-filled)
│   ├── User.java                   → Full entity: auth fields, role, status, lock,
│   │                                  OTP, lastLoginAt/Ip/Device, forcePasswordChange,
│   │                                  requestedRole, failedLoginAttempts, lockTime
│   ├── Role.java                   → ManyToMany with Permission, @PrePersist normalize
│   ├── Permission.java             → name auto-uppercased via @PrePersist
│   ├── UserToken.java              → accessToken, refreshToken, accessExpiry,
│   │                                  refreshExpiry, revoked, expired, refreshUsed,
│   │                                  deviceInfo, ipAddress, tokenId (UUID)
│   ├── OtpToken.java               → otpHash (bcrypt), expiryTime, used (boolean),
│   │                                  attempts, lastAttemptAt, purpose (enum)
│   └── AuditLog.java               → Write-once entity: full metadata, DB-indexed,
│                                      createdAt set by @PrePersist only
│
├── 📁 filter/
│   └── JwtFilter.java              → OncePerRequestFilter — 9-step validation pipeline
│                                      (Bearer → Crypto → Type → DB-revocation → DB-expiry
│                                       → Claims → ForceChange → Authorities → SecurityContext)
│
├── 📁 service/
│   ├── IAuthService.java           → Auth service interface
│   ├── AuthServiceImpl.java        → Login (userId-based), refresh with rotation,
│   │                                  logout, logout-all, validate, sessions, revoke-session
│   ├── IAdminService.java          → 20+ method contracts
│   ├── AdminServiceImpl.java       → Full admin ops: dual-gate checks, self-guard,
│   │                                  hierarchical approval policy enforcement
│   ├── IUserService.java           → User service interface
│   ├── UserServiceImpl.java        → OTP registration, employee flow, profile,
│   │                                  password management, admin notification
│   ├── AuditService.java           → REQUIRES_NEW transaction, fault-tolerant log writer
│   ├── AuditQueryService.java      → Paginated read-side: logs, per-user, failed-logins,
│   │                                  suspicious events, statistics
│   ├── EmailService.java           → SendGrid SDK 4.10.0: OTP, approval, rejection,
│   │                                  admin notification emails
│   ├── LoginAttemptService.java    → REQUIRES_NEW tx: increment attempts, lockout
│   │                                  at threshold, auto-unlock, reset on success
│   └── TokenCleanupService.java    → @Scheduled cleanup of expired/revoked tokens
│
├── 📁 security/
│   ├── RoleInitializationService.java  → CommandLineRunner @Order(1):
│   │                                      creates 22+ permissions + syncs 5 roles
│   │                                      idempotently every startup
│   └── UserDataInitializer.java        → Seeds default ADMIN user on first run
│                                          (flag-controlled, @Order(2))
│
├── 📁 model/  (DTOs, Requests, Responses, Enums)
│   ├── JwtRequest.java             → { username, password }
│   ├── JwtResponse.java            → { accessToken, refreshToken, role }
│   ├── ApiResponse.java            → Unified wrapper: { success, message, data }
│   ├── RegisterRequest.java        → { username, password, otp }
│   ├── EmployeeRegisterRequest.java → { email, password, otp, requestedRole }
│   ├── ChangePasswordRequest.java  → { currentPassword, newPassword, confirmPassword }
│   ├── UserResponseDto.java        → { userId, username, role, status, enabled, lastLoginAt }
│   ├── UserSummaryDto.java         → Lightweight summary for list endpoints
│   ├── UserMapper.java             → Static mapper: User → ResponseDto / SummaryDto
│   ├── AuditAction.java            → 40+ audit event constants (enum)
│   ├── AuditStatus.java            → SUCCESS, FAILED, BLOCKED, WARNING
│   ├── OtpPurpose.java             → REGISTER, RESET_PASSWORD
│   ├── Status.java                 → ACTIVE, INACTIVE, PENDING_APPROVAL
│   ├── RoleUpdateRequest.java      → { role }
│   └── TokenInfo.java              → Token metadata wrapper
│
├── 📁 repo/
│   ├── UserRepository.java         → findByUsername, existsByUsername, findByStatus
│   ├── UserTokenRepository.java    → findByAccessToken, findByRefreshToken,
│   │                                  findAllByUserAndRevokedFalseAndExpiredFalse
│   ├── RoleRepository.java         → findByName
│   ├── PermissionRepository.java   → findByName
│   ├── OtpRepository.java          → findTopByUsernameOrderByIdDesc,
│   │                                  invalidateAllActiveOtps (custom @Query)
│   └── AuditLogRepository.java     → Pageable queries by user, action, status
│
├── 📁 utility/
│   ├── JwtUtility.java             → generateAccessToken(userId, role, permissions[]),
│   │                                  generateRefreshToken(userId), extractUserId,
│   │                                  extractRole, extractPermissions, extractTokenType,
│   │                                  isTokenValid (cryptographic check)
│   ├── RequestInfoUtil.java        → getClientIp() — X-Forwarded-For aware,
│   │                                  getDeviceInfo() — User-Agent parsing
│   └── TokenCleanupScheduler.java  → @Scheduled task for expired token purge
│
└── 📁 exceptions/
    ├── ErrorResponse.java          → { timestamp, status, error, message, path }
    └── GlobalExceptionHandler.java → Handles: BadCredentials, Disabled, Locked,
                                      RuntimeException, MethodArgumentNotValid,
                                      AccessDenied, AuthenticationException
                                      — structured JSON, no stack trace leaks
```

---

## ✅ Implemented Concepts — Deep Dive

### 🔐 1. JWT Authentication — Stateless Token System
- `JwtUtility` generates **Access Tokens** (15 min) embedding `userId`, `role`, and `permissions[]` as JWT claims
- Separate **Refresh Token** (7 days) containing only `userId` — used exclusively to issue new access tokens
- All tokens stored in `UserToken` DB table with `revoked`, `expired`, `refreshUsed`, `deviceInfo`, `ipAddress`, and UUID `tokenId` fields
- Token invalidation is **DB-backed** — cryptographic validity alone is never enough to pass authentication
- **`userId` (Long)** used as JWT subject — not email — ensuring tokens survive username/email changes
- **What I learned:** Stateless auth design, token lifecycle management, the critical difference between access vs refresh tokens, why DB-backed revocation is non-negotiable in production

### 🛡️ 2. Spring Security Filter Chain — Full Configuration
- `SecurityConfig` configures: CORS, CSRF disabled (stateless), `SessionCreationPolicy.STATELESS`
- **Public matchers** defined: `PUBLIC_AUTH_MATCHERS` (login, refresh), `PUBLIC_USER_MATCHERS` (register, OTP, reset), `SWAGGER_MATCHERS` (docs)
- `@EnableMethodSecurity` activates `@PreAuthorize` and `@PostAuthorize` at controller level
- `JwtFilter` injected into chain via `addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)`
- Custom `AuthenticationManager` bean wired through `SecurityConfig` — breaking the circular dependency with `@Lazy`
- **What I learned:** Spring Security 6 filter chain configuration, bean ordering, circular dependency resolution patterns

### 🔒 3. JwtFilter — 9-Step Validation Pipeline
- Extends `OncePerRequestFilter` — guaranteed single execution per request regardless of filter chain
- Each of the 9 steps is a distinct security gate with its own failure response code and audit event
- Step 8 (`forcePasswordChange` gate) returns a **descriptive JSON body** with `403` — not a generic error
- Step 9 builds `GrantedAuthority` list from the **permissions array in the JWT** — no DB call needed
- **What I learned:** Deep Spring Security filter internals, `OncePerRequestFilter`, thread-safety of `SecurityContextHolder`, why each step order matters

### 👑 4. Role-Based Access Control — 5-Tier Permission System
- `RoleInitializationService` (`CommandLineRunner @Order(1)`) creates **22+ permissions** and syncs **5 roles** idempotently on every startup
- Permissions stored in DB with `ManyToMany` between `Role` ↔ `Permission` — fully relational
- Every endpoint uses `@PreAuthorize("hasAuthority('PERMISSION_NAME')")` — **Gate 1**
- `AdminServiceImpl.requirePermission()` re-validates inside service — **Gate 2** (defense-in-depth)
- Self-guard logic: admin cannot modify, lock, delete, or force-logout their own account
- Hierarchical approval: map-driven policy (`ADMIN` → can approve `MANAGER/HR/VENDOR`; `MANAGER` → only `HR/VENDOR`)
- **What I learned:** Permission-based vs role-based security, why dual-gate enforcement matters, idempotent seed data patterns

### 📊 5. Comprehensive Audit Logging
- `AuditService` uses `@Transactional(propagation = REQUIRES_NEW)` — audit is **always committed independently**, never rolls back with business logic
- `AuditLog` entity is **write-once**: `createdAt` set by `@PrePersist`, no update method exists anywhere
- `AuditAction` enum has **40+ event constants** covering auth, security attacks, user ops, admin ops, system events
- Full metadata per record: `userId`, `username`, `role`, `action`, `status`, `endpoint`, `httpMethod`, `ipAddress`, `deviceInfo`
- `AuditQueryService` exposes paginated read-side: all logs, per-user, failed-logins, suspicious events, statistics
- DB indexes on `user_id`, `action`, `status`, `created_at` — ready for high-volume querying
- **What I learned:** Audit trail design, `REQUIRES_NEW` propagation semantics, write-once entity patterns, why audit must never fail silently

### 🔴 6. Brute Force Protection — Login Attempt Tracking
- `LoginAttemptService` uses `@Transactional(propagation = REQUIRES_NEW)` — **attempt always committed even if outer transaction rolls back**
- After **5 failed attempts**: `accountLocked=true`, `lockTime=Instant.now()` persisted
- `ACCOUNT_LOCKED` audit event fired automatically with full metadata
- **Auto-unlock after 15 minutes**: `unlockIfLockExpired()` called on every login attempt before credential check
- Successful login triggers `resetFailedAttempts()`: zeroes counter, clears lock, nullifies `lockTime`
- **What I learned:** `REQUIRES_NEW` transaction isolation for safety-critical writes, time-based unlock patterns, progressive lockout UX design

### 📩 7. OTP System — Secure by Design
- OTP generated using `SecureRandom` (cryptographically secure) — always 6 digits
- Stored as **bcrypt hash only** — plain text OTP never written to DB
- **5-minute expiry**, **5-attempt limit**, `purpose` tag (cross-purpose attacks rejected)
- `invalidateAllActiveOtps(email)` called before issuing any new OTP — no OTP accumulation
- `passwordEncoder.matches()` for comparison — **constant-time, immune to timing attacks**
- **What I learned:** Secure token design, why bcrypt for short secrets, constant-time comparison importance

### 📧 8. Email Notifications — SendGrid Integration
- `EmailService` wraps **SendGrid Java SDK 4.10.0** for transactional emails
- Four distinct email types: OTP delivery, registration approval, rejection with reason, admin alert on new employee registration
- Admin notification sent to **all ADMIN users** in system when new employee registers
- **What I learned:** SendGrid API integration, transactional email patterns, async notification design in Spring

### 🕰️ 9. UTC Timezone Enforcement
- `TimeZoneConfig` sets `TimeZone.setDefault(TimeZone.getTimeZone("UTC"))` at JVM startup via `@PostConstruct`
- Hibernate `hibernate.jdbc.time_zone=UTC` and Jackson `spring.jackson.time-zone=UTC` both configured
- Ensures consistent timestamp storage and serialization regardless of server deployment region
- **What I learned:** Why multi-layer UTC enforcement matters, the subtle bugs timezone mismatches cause in token expiry and audit timestamps

### 🏗️ 10. JPA Auditing — Automatic Metadata Tracking
- `Auditable` base class: `@CreatedBy`, `@LastModifiedBy`, `@CreatedDate`, `@LastModifiedDate`
- `AuditorAwareImpl` resolves **current userId (Long)** from `SecurityContext` for `createdBy`/`updatedBy`
- All entities extending `Auditable` get audit fields populated automatically — zero manual code
- **What I learned:** Spring Data JPA auditing internals, `AuditorAware<T>` generic contract, audit field lifecycle

### 🧹 11. Scheduled Token Cleanup
- `TokenCleanupScheduler` uses `@Scheduled` to periodically delete expired and revoked tokens from DB
- Prevents unbounded `user_tokens` table growth — a production concern most tutorials never address
- **What I learned:** Spring `@Scheduled` task configuration, DB hygiene patterns in token-heavy systems

### 📖 12. Swagger UI with JWT Bearer Auth
- `SwaggerConfig` configures SpringDoc OpenAPI 2.8.6 with `SecurityScheme` (HTTP Bearer + JWT format)
- Every protected endpoint shows the 🔒 lock icon in Swagger UI
- Developers authenticate once in the UI and test all secured endpoints live
- **What I learned:** OpenAPI 3 security scheme configuration, `OperationCustomizer` for per-endpoint security

---

## 🔐 JWT Architecture — The Critical Design Decision

### Why `userId` — Not Email — Is The JWT Subject

> **This is the single most important architectural decision in this entire project. It was discovered as a real bug during development and fixed properly.**

```
❌ WRONG — Username (email) as JWT subject:
────────────────────────────────────────────
User registers:     email = john@old.com
JWT issued:         { "sub": "john@old.com" }
User changes email: john@new.com
JwtFilter runs:     extracts sub = "john@old.com"
loadUserByUsername("john@old.com") → UserNotFoundException
Result:             User forcibly logged out on every email change  ← PRODUCTION BUG

✅ CORRECT — userId (Long DB PK) as JWT subject:
─────────────────────────────────────────────────
User registers:     DB assigns userId = 42
JWT issued:         { "sub": "42" }
User changes email: anything they want
JwtFilter runs:     extracts sub = "42"
userRepository.findById(42L) → always works
Result:             Session unaffected by username changes  ← CORRECT
```

### JWT Payload Structure

**Access Token** (valid 15 minutes):
```json
{
  "sub": "42",
  "role": "ADMIN",
  "permissions": [
    "DELETE_USER", "FORCE_LOGOUT", "VIEW_AUDIT_LOGS",
    "ASSIGN_MANAGER", "REVOKE_TOKEN", "SYSTEM_ADMIN"
  ],
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
// When /refresh-token is called:
// Step 1: Find token record in DB by refresh token string
// Step 2: If refreshUsed=true OR revoked=true OR expired=true
//            → TOKEN REUSE ATTACK DETECTED
//            → revokeAllActiveTokens(user) — every session killed
//            → auditService.log(TOKEN_REUSE_ATTACK, ...)
//            → throw SecurityException("Token reuse detected")
// Step 3: If valid
//            → mark old record: revoked=true, expired=true, refreshUsed=true
//            → generate new accessToken + refreshToken pair
//            → save new UserToken record to DB
//            → return new token pair to client
```

---

## 🔒 Security Filter Chain — 9-Step JwtFilter Pipeline

```
  Incoming Request
       │
       ▼
  ┌─────────────────────────────────────────────────────────────────────┐
  │  [Step 1]  Extract Bearer token from Authorization header           │
  │            No header or no "Bearer " prefix?                        │
  │            └──► pass through directly (public endpoints hit next)   │
  └──────────────────────────────────┬──────────────────────────────────┘
                                     │ Token string extracted
       ▼
  ┌─────────────────────────────────────────────────────────────────────┐
  │  [Step 2]  SecurityContextHolder.clearContext()                     │
  │            Ensures previous request's auth never bleeds into this   │
  │            thread — critical for thread pool safety                  │
  └──────────────────────────────────┬──────────────────────────────────┘
                                     │
       ▼
  ┌─────────────────────────────────────────────────────────────────────┐
  │  [Step 3]  JWT cryptographic validation                             │
  │            jwtUtility.isTokenValid(token) — signature + structure  │
  │            FAIL? → mark DB token as expired → return HTTP 401      │
  └──────────────────────────────────┬──────────────────────────────────┘
                                     │ Signature valid
       ▼
  ┌─────────────────────────────────────────────────────────────────────┐
  │  [Step 4]  Token type enforcement                                   │
  │            Extract "tokenType" claim — must equal "ACCESS"         │
  │            REFRESH token presented as ACCESS? → return HTTP 401    │
  └──────────────────────────────────┬──────────────────────────────────┘
                                     │ Type = ACCESS confirmed
       ▼
  ┌─────────────────────────────────────────────────────────────────────┐
  │  [Step 5]  DB revocation + expiry flag check                        │
  │            Find UserToken by accessToken string                     │
  │            revoked=true OR expired=true? → return HTTP 401         │
  └──────────────────────────────────┬──────────────────────────────────┘
                                     │ Not revoked, not expired
       ▼
  ┌─────────────────────────────────────────────────────────────────────┐
  │  [Step 6]  DB accessExpiry timestamp check  (clock drift guard)    │
  │            dbToken.getAccessExpiry().isBefore(Instant.now())?      │
  │            YES? → set expired=true in DB → return HTTP 401         │
  └──────────────────────────────────┬──────────────────────────────────┘
                                     │ Within time window
       ▼
  ┌─────────────────────────────────────────────────────────────────────┐
  │  [Step 7]  Extract claims from JWT                                  │
  │            userId (Long), role (String), permissions (List<String>) │
  │            Any claim null? → return HTTP 401                        │
  └──────────────────────────────────┬──────────────────────────────────┘
                                     │ All claims present
       ▼
  ┌─────────────────────────────────────────────────────────────────────┐
  │  [Step 8]  forcePasswordChange gate                                 │
  │            user.isForcePasswordChange() == true?                   │
  │            AND request path NOT in allowedPaths?                   │
  │            YES? → return HTTP 403 with descriptive JSON body       │
  └──────────────────────────────────┬──────────────────────────────────┘
                                     │ No force-change block
       ▼
  ┌─────────────────────────────────────────────────────────────────────┐
  │  [Step 9]  Build authorities + populate SecurityContext             │
  │            Map permissions[] → List<GrantedAuthority>              │
  │            Set UsernamePasswordAuthenticationToken in context       │
  │            Call filterChain.doFilter(request, response)            │
  └──────────────────────────────────┬──────────────────────────────────┘
                                     │
                                     ▼
                          ✅  Controller reached — request processed
```

---

## 👑 RBAC System — Role & Permission Hierarchy

```
  ADMIN ── Full System Access ────────────────────────────────────────────────
    ├── READ_USER, CREATE_USER, UPDATE_USER, DELETE_USER, VIEW_USERS
    ├── UPDATE_USER_STATUS, TOGGLE_USER_ACCESS, ACCOUNT_LOCK, ACCOUNT_UNLOCK
    ├── FORCE_LOGOUT, REVOKE_TOKEN, SESSION_REVOKE
    ├── ASSIGN_ADMIN, ASSIGN_MANAGER, ASSIGN_HR, ASSIGN_VENDOR
    ├── VIEW_AUDIT_LOGS, VIEW_SECURITY_EVENTS, VIEW_AUDIT_DASHBOARD
    ├── VIEW_SECURITY_STATISTICS, VIEW_SYSTEM_STATISTICS
    └── SYSTEM_ADMIN, HELLO_USERS                              [22 permissions]

  MANAGER ── Team Lead Access ─────────────────────────────────────────────────
    ├── READ_USER, CREATE_USER, UPDATE_USER, VIEW_USERS
    └── ASSIGN_HR, ASSIGN_VENDOR, HELLO_USERS                   [7 permissions]

  HR ── Human Resources Access ────────────────────────────────────────────────
    └── READ_USER, HELLO_USERS                                   [2 permissions]

  USER ── Standard Access ─────────────────────────────────────────────────────
    └── HELLO_USERS                                              [1 permission]

  VENDOR ── Restricted External Access ────────────────────────────────────────
    └── (no permissions assigned — read-only scoped access)     [0 permissions]
```

### Dual-Gate Permission Enforcement

```java
// ── GATE 1: Controller layer ──────────────────────────────────────────────
@PreAuthorize("hasAuthority('DELETE_USER')")
public ResponseEntity<?> deleteUserPermanently(@PathVariable Long id) {
    return adminService.deleteUserPermanently(id);
}

// ── GATE 2: Service layer (defense-in-depth) ──────────────────────────────
private void requirePermission(String permission) {
    boolean hasIt = SecurityContextHolder.getContext()
        .getAuthentication().getAuthorities().stream()
        .anyMatch(a -> a.getAuthority().equals(permission));
    if (!hasIt) {
        auditService.log(AuditAction.ACCESS_DENIED, AuditStatus.BLOCKED, ...);
        throw new RuntimeException("Access denied. Missing: " + permission);
    }
}
// Called at the top of every admin service method — bypassing Gate 1 is impossible
```

### Hierarchical Registration Approval

```java
private static final Map<String, Set<String>> APPROVAL_HIERARCHY = Map.of(
    "ADMIN",   Set.of("MANAGER", "EMPLOYEE", "VENDOR", "HR", "FINANCE", "SUPPORT"),
    "MANAGER", Set.of("VENDOR", "HR", "EMPLOYEE", "SUPPORT"),
    "HR",      Set.of("EMPLOYEE")
);
// MANAGER cannot approve ADMIN (only ADMIN can)
// HR cannot approve MANAGER (only ADMIN/MANAGER can)
// All enforcement in AdminServiceImpl.approveRegistration()
```

---

## 📊 Audit Logging System

```
  AuditLog Entity — Written on every security-significant event
  ┌───────────────────────────────────────────────────────────────┐
  │  id          → Auto-generated PK                              │
  │  userId      → Who performed the action (nullable for public) │
  │  username    → Email address, or "ANONYMOUS"                  │
  │  role        → "ADMIN" / "USER" / "PUBLIC"                    │
  │  action      → AuditAction enum  (40+ event types)            │
  │  status      → SUCCESS / FAILED / BLOCKED / WARNING           │
  │  details     → Human-readable description of what happened    │
  │  endpoint    → e.g. /api/v1/auth/login                        │
  │  httpMethod  → POST / GET / PUT / DELETE                      │
  │  ipAddress   → Client IP  (X-Forwarded-For aware, 100 chars)  │
  │  deviceInfo  → Full User-Agent string                         │
  │  createdAt   → Instant.now() via @PrePersist — IMMUTABLE      │
  └───────────────────────────────────────────────────────────────┘

  Why REQUIRES_NEW transaction?
  ──────────────────────────────
  Business tx fails → rolls back → WITHOUT REQUIRES_NEW → audit lost
  Business tx fails → rolls back → WITH REQUIRES_NEW    → audit saved ✅
  This is why: failed logins, lockouts, and attack events are ALWAYS recorded.

  Complete AuditAction Enum — 40+ Events:
  ─────────────────────────────────────────
  AUTH:       LOGIN, LOGOUT, TOKEN_REFRESH, VALIDATE_TOKEN, LOGOUT_ALL
  SECURITY:   TOKEN_REUSE_ATTACK, INVALID_TOKEN, REVOKED_TOKEN_USAGE,
              EXPIRED_TOKEN_USAGE, ACCOUNT_LOCKED, ACCOUNT_UNLOCKED,
              SELF_ACTION_BLOCKED, ACCESS_DENIED, FORCE_LOGOUT,
              SESSION_REVOKED, SESSION_INVALIDATED, TOKEN_REVOKED,
              VIEW_ACTIVE_SESSIONS
  USER:       REGISTER, REGISTRATION_OTP_SENT, VIEW_PROFILE, VIEW_USERS,
              VIEW_USER, DELETE_USER, PASSWORD_CHANGED, PASSWORD_RESET,
              PASSWORD_RESET_REQUEST, ROLE_CHANGED, STATUS_CHANGED,
              ACCESS_TOGGLED
  EMPLOYEE:   REGISTRATION_APPROVED, REGISTRATION_REJECTED,
              VIEW_PENDING_REGISTRATIONS
  OTP:        OTP_FAILED
  SYSTEM:     SYSTEM_MAINTENANCE_ENABLED, SYSTEM_MAINTENANCE_DISABLED,
              SYSTEM_CACHE_CLEARED, PERMISSION_CACHE_REFRESHED
```

---

## 🔴 Brute Force Protection & Account Lockout

```
  LOGIN ATTEMPT FLOW WITH BRUTE FORCE PROTECTION
  ────────────────────────────────────────────────

  Every attempt:
    └──► unlockIfLockExpired() called FIRST
          IF lockTime + 900_000ms (15 min) < Instant.now()
            → accountLocked=false, failedLoginAttempts=0, lockTime=null
            → user = reload from DB (stale object bug prevention)
          ELSE
            → throw "Account is locked. Try again in X minutes" → BLOCKED

  Attempts 1–4 (wrong credentials):
    └──► loginAttemptService.incrementFailedAttempts(user)
          [REQUIRES_NEW transaction — committed even if outer tx rolls back]
          → failedLoginAttempts++
          → save to DB
          → return 401 Unauthorized

  Attempt 5 (threshold reached):
    └──► loginAttemptService.lockAccount(user)
          → failedLoginAttempts = 5
          → accountLocked = true
          → lockTime = Instant.now()
          → save to DB  [REQUIRES_NEW]
          → auditService.log(ACCOUNT_LOCKED, BLOCKED, ...)
          → return "Account locked due to too many failed attempts"

  Successful login:
    └──► loginAttemptService.resetFailedAttempts(user)
          → failedLoginAttempts = 0
          → accountLocked = false
          → lockTime = null
          → save to DB  [REQUIRES_NEW]
    └──► Generate new accessToken + refreshToken pair
    └──► Save UserToken record with deviceInfo + ipAddress
    └──► Update lastLoginAt, lastLoginIp, lastLoginDevice on User
    └──► auditService.log(LOGIN, SUCCESS, ...)
    └──► Return JwtResponse { accessToken, refreshToken, role }
```

---

## 📩 OTP System — Secure by Design

```java
// ── OTP Generation (cryptographically secure) ─────────────────────────────
private static final SecureRandom secureRandom = new SecureRandom();

private String generateOtp() {
    int otp = secureRandom.nextInt(900_000) + 100_000; // always 6 digits
    return String.valueOf(otp);
}

// ── OTP Storage (NEVER plain text) ───────────────────────────────────────
otpRepository.invalidateAllActiveOtps(normalizedEmail); // kill previous OTPs first

OtpToken token = OtpToken.builder()
    .username(normalizedEmail)
    .otpHash(passwordEncoder.encode(rawOtp))           // bcrypt hash stored
    .expiryTime(Instant.now().plusSeconds(300))         // 5-minute window
    .used(false)
    .attempts(0)
    .purpose(OtpPurpose.REGISTER)                       // purpose-locked
    .build();
otpRepository.save(token);
emailService.sendOtpEmail(normalizedEmail, rawOtp);     // only time plain OTP exists
// rawOtp is now out of scope — never stored, never logged

// ── OTP Validation (8 security checks in order) ──────────────────────────
// 1. Load most recent OTP record for email
// 2. Check attempts < 5  (block at 5 regardless of correctness)
// 3. Check purpose matches expected  (REGISTER ≠ RESET_PASSWORD)
// 4. Check used == false  (prevent replay)
// 5. Check expiryTime.isAfter(Instant.now())  (5-min window)
// 6. passwordEncoder.matches(input, hash)  (constant-time bcrypt compare)
// 7. If WRONG → increment attempts, update lastAttemptAt, save
// 8. If CORRECT → used=true, invalidateAllActiveOtps(email)
```

---

## 📬 Email Notification System

| Email Type | Trigger | Recipient | Content |
|---|---|---|---|
| **OTP Email** | Registration or password reset requested | Requester | 6-digit OTP + 5-min expiry notice |
| **Pending Approval Alert** | New employee registers | All `ADMIN` users in system | Employee name, requested role, action link |
| **Approval Confirmation** | Admin approves registration | Approved employee | Welcome message + assigned role |
| **Rejection Notice** | Admin rejects registration | Rejected employee | Rejection reason + contact guidance |

All emails use HTML templates with inline styles for maximum email client compatibility. Delivery powered by **SendGrid Java SDK 4.10.0**.

---

## 📡 Complete API Reference

### 🔐 Auth Endpoints — `/api/v1/auth`

| Method | Endpoint | Auth | Description |
|---|---|---|---|
| `POST` | `/login` | ❌ Public | Login → access token + refresh token |
| `POST` | `/refresh-token` | ❌ Public | Exchange refresh token → new token pair |
| `POST` | `/validate-token` | ❌ Public | Validate token: signature + DB + expiry |
| `POST` | `/logout` | ✅ | Revoke current session token pair |
| `POST` | `/logout-all` | ✅ | Revoke ALL sessions across all devices |
| `GET`  | `/sessions` | ✅ | List active sessions (device, IP, expiry) |
| `DELETE` | `/sessions/{id}` | ✅ | Revoke one specific session by ID |

### 👤 User Endpoints — `/api/v1/users`

| Method | Endpoint | Auth | Description |
|---|---|---|---|
| `GET`  | `/` | ✅ `VIEW_USERS` | All users (DTO list) |
| `GET`  | `/me` | ✅ | Current user profile |
| `POST` | `/send-registration-otp` | ❌ | Send OTP to email |
| `POST` | `/register` | ❌ | Register with OTP verification |
| `POST` | `/employee-register` | ❌ | Submit employee registration (PENDING_APPROVAL) |
| `POST` | `/forgot-password` | ❌ | Request password reset OTP (anti-enumeration) |
| `POST` | `/reset-password` | ❌ | Reset password with valid OTP |
| `POST` | `/change-password` | ✅ | Change password (requires current password) |

### 🔴 Admin Endpoints — `/api/v1/admin` — Requires `ROLE_ADMIN`

| Method | Endpoint | Permission | Description |
|---|---|---|---|
| `GET`  | `/users` | `VIEW_USERS` | All users (paginated) |
| `GET`  | `/users/{id}` | `VIEW_USERS` | User detail by ID |
| `PUT`  | `/users/{id}/role` | `ASSIGN_{ROLE}` | Update user role |
| `PUT`  | `/users/{id}/status` | `UPDATE_USER_STATUS` | Set ACTIVE / INACTIVE |
| `PUT`  | `/users/{id}/lock` | `ACCOUNT_LOCK` | Lock account |
| `PUT`  | `/users/{id}/unlock` | `ACCOUNT_UNLOCK` | Unlock account |
| `PUT`  | `/users/{id}/enable` | `TOGGLE_USER_ACCESS` | Enable user |
| `PUT`  | `/users/{id}/disable` | `TOGGLE_USER_ACCESS` | Disable + revoke all tokens |
| `POST` | `/users/{id}/force-logout` | `FORCE_LOGOUT` | Force logout all sessions |
| `POST` | `/users/{id}/revoke-tokens` | `REVOKE_TOKEN` | Revoke all tokens |
| `DELETE` | `/users/{id}/permanent` | `DELETE_USER` | Hard delete |
| `GET`  | `/pending-registrations` | `VIEW_USERS` | View approval queue |
| `POST` | `/registrations/{id}/approve` | `ASSIGN_{ROLE}` | Approve with role |
| `POST` | `/registrations/{id}/reject` | `UPDATE_USER_STATUS` | Reject with reason |
| `PUT`  | `/system/maintenance-mode/enable` | `SYSTEM_ADMIN` | Enable maintenance mode |
| `PUT`  | `/system/maintenance-mode/disable` | `SYSTEM_ADMIN` | Disable maintenance mode |
| `POST` | `/system/cache/clear` | `SYSTEM_ADMIN` | Clear system cache |
| `GET`  | `/statistics/system` | `VIEW_SYSTEM_STATISTICS` | User counts by role/status |
| `GET`  | `/statistics/security` | `VIEW_SECURITY_STATISTICS` | Token counts, locked accounts |

### 📊 Audit Endpoints — `/api/v1/admin/audit` — Requires `ROLE_ADMIN`

| Method | Endpoint | Permission | Description |
|---|---|---|---|
| `GET`  | `/logs` | `VIEW_AUDIT_LOGS` | All logs (paginated, sortable) |
| `GET`  | `/logs/{id}` | `VIEW_AUDIT_LOGS` | Single audit entry |
| `GET`  | `/users/{userId}` | `VIEW_AUDIT_LOGS` | Full history for one user |
| `GET`  | `/security/failed-logins` | `VIEW_SECURITY_EVENTS` | All failed login events |
| `GET`  | `/security/suspicious` | `VIEW_SECURITY_EVENTS` | Suspicious activity events |
| `GET`  | `/statistics` | `VIEW_AUDIT_DASHBOARD` | Dashboard statistics |

---

## ⚙️ Configuration Reference

```properties
# ─── SERVER ───────────────────────────────────────────────────────────────
server.port=8181

# ─── DATABASE ─────────────────────────────────────────────────────────────
spring.datasource.url=jdbc:mysql://localhost:3306/jwt_security?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD
spring.jpa.hibernate.ddl-auto=update
spring.jpa.open-in-view=false              # Disabled — prevents N+1 + LazyInit issues
spring.jpa.show-sql=true

# ─── JWT ──────────────────────────────────────────────────────────────────
jwt.secret=YOUR_256_BIT_HEX_SECRET_KEY
jwt.access-token-expiration-ms=900000      # 15 minutes
jwt.refresh-token-expiration-ms=604800000  # 7 days

# ─── SECURITY ─────────────────────────────────────────────────────────────
security.account.max-login-attempts=5
security.account.lock-duration-ms=900000   # 15 minutes auto-unlock

# ─── EMAIL (SendGrid) ─────────────────────────────────────────────────────
sendgrid.api.key=SG.YOUR_API_KEY           # ← Move to environment variable
sendgrid.sender.email=youremail@domain.com
sendgrid.sender.name=YourAppName

# ─── SWAGGER ──────────────────────────────────────────────────────────────
springdoc.api-docs.enabled=true
springdoc.swagger-ui.enabled=true
springdoc.swagger-ui.path=/swagger-ui.html
springdoc.swagger-ui.operations-sorter=method
springdoc.swagger-ui.tags-sorter=alpha

# ─── TIMEZONE ─────────────────────────────────────────────────────────────
spring.jpa.properties.hibernate.jdbc.time_zone=UTC
spring.jackson.time-zone=UTC
# JVM timezone set via TimeZoneConfig @PostConstruct — all three layers aligned

# ─── CORS ─────────────────────────────────────────────────────────────────
allowed.origins=http://localhost:4200      # Replace with production URL
```

---

## 🐛 Bug Fixes & Root Cause Resolutions

> Every bug here was **discovered during actual development, debugged from first principles, and properly fixed**. No shortcuts taken. No Stack Overflow copy-paste without understanding.

### 🔴 Critical Bugs Fixed

| Bug | Root Cause | Fix Applied |
|---|---|---|
| **Username-based JWT subject** | `sub = email` → breaks on email change → `UserNotFoundException` | Switched to `userId` (Long PK) as `sub` across entire stack |
| **Circular dependency at startup** | `SecurityConfig` ↔ `AuthServiceImpl` both needed each other | Added `@Lazy` on `IAuthService` injection in `SecurityConfig` constructor |
| **Refresh token not revoked on password change** | `changePassword()` only updated password field, sessions stayed alive | Added `revokeAllActiveTokens(user)` + `SecurityContextHolder.clearContext()` after update |
| **Refresh token reuse not detected** | No `refreshUsed` flag — old refresh tokens could be replayed indefinitely | Added `refreshUsed` field; on reuse: revoke ALL sessions + log `TOKEN_REUSE_ATTACK` |
| **Refresh token accepted as access token** | `JwtFilter` checked signature only, not token type | Added `tokenType` claim extraction; `!ACCESS.equals(type)` → explicit 401 |
| **Account lockout not persisting** | `LoginAttemptService` used parent transaction which rolled back on bad credentials | Changed to `@Transactional(propagation = REQUIRES_NEW)` — committed separately |
| **Stale user object after auto-unlock** | After `unlockIfLockExpired()`, old `user` object used — stale `accountLocked=true` in memory | Added explicit `user = userRepository.findById(userId)` reload post-unlock |
| **DB expiry not checked (clock drift bug)** | JWT cryptographically valid but DB `accessExpiry` already past | Added `dbToken.getAccessExpiry().isBefore(Instant.now())` check in Step 6 of JwtFilter |
| **Stack trace leaking in error responses** | `GlobalExceptionHandler` returned raw `e.getMessage()` with traces | Replaced with structured `ErrorResponse` DTO — stack trace gated behind dev profile |
| **OTP stored in plain text** | OTP value written directly to `otp` column | Replaced with `passwordEncoder.encode(otp)` → `otpHash` column |
| **OTP reuse possible** | No `used` flag — same OTP could verify multiple times | Added `used=true` on first valid verification; reuse throws immediately |
| **OTP cross-purpose attack** | Registration OTP could be used for password reset | Added `OtpPurpose` enum; purpose mismatch = rejection |
| **Admin self-delete possible** | No guard in delete endpoint | Added `guardSelf(userId, "delete")` check at top of `AdminServiceImpl.deleteUserPermanently()` |
| **Role change not invalidating tokens** | Old tokens still carried pre-change permissions after role update | Added `revokeAllActiveTokens(targetUser)` inside `updateUserRole()` |
| **Git merge conflict in `application.properties`** | Unresolved `<<<<<<< HEAD` markers left in file after merge | Identified, flagged, and cleaned — UTC timezone config applied correctly |
| **`spring.jpa.open-in-view=true` default** | `LazyInitializationException` risk in production + performance overhead | Explicitly set `spring.jpa.open-in-view=false` |

### 🟡 In-Progress Fixes

| ID | Issue | Status |
|---|---|---|
| BUG-017 | `application.properties` contains residual Git merge conflict markers | 🔄 Cleanup in next commit |
| BUG-018 | `sendgrid.api.key` hardcoded in properties — must move to env variable | 🔄 Moving to `.env` / environment variable pattern |
| BUG-019 | `TokenCleanupService` processes full table — may timeout on large datasets | 🔄 Adding batch-based cleanup with configurable page size |
| BUG-020 | `getSystemStatistics()` uses `findAll()` stream — O(n) count | 🔄 Replacing with dedicated `countByRole()` JPA queries |

---

## 🗺️ Roadmap — What's Coming Next

### 🏃 This Week
- [ ] Fix unresolved Git merge conflict markers in `application.properties`
- [ ] Move all secrets to environment variables — no hardcoded keys anywhere
- [ ] Add `ASSIGN_EMPLOYEE`, `ASSIGN_FINANCE` to permission set
- [ ] Add `EMPLOYEE`, `FINANCE`, `SUPPORT` roles to `RoleInitializationService`
- [ ] Replace O(n) `findAll()` streams in statistics with dedicated JPA `count` queries

### 🏗️ Next 2 Weeks
- [ ] **Password History** — prevent last 5 password reuse
- [ ] **Username Change API** — safe update with token continuity (already works via `userId` design)
- [ ] **Spring Boot Actuator** — `/actuator/health`, `/actuator/info` endpoints, secured
- [ ] **Docker Compose** — MySQL + Spring Boot application fully containerized
- [ ] **Unit Tests** — JUnit 5 + Mockito: `AuthServiceImpl`, `AdminServiceImpl`, `JwtUtility`
- [ ] **Integration Tests** — `@SpringBootTest` + `MockMvc` for full auth flows

### 🔭 Planned Milestones
- [ ] **Redis Session Store** — move active token tracking to Redis for horizontal scaling
- [ ] **OAuth2 Social Login** — Google + GitHub SSO
- [ ] **TOTP Two-Factor Auth** — authenticator app QR code + verify endpoint
- [ ] **API Rate Limiting** — per-user + per-IP with configurable thresholds
- [ ] **Soft Delete** — `deletedAt` timestamp instead of hard delete
- [ ] **Pagination Everywhere** — `Page<T>` responses on all list endpoints
- [ ] **Kubernetes Deployment** — Helm chart + K8s manifests
- [ ] **OWASP ZAP CI** — automated security scan on each PR in GitHub Actions

---

## 🚀 Quick Start

### Prerequisites
```
☑ Java 21+
☑ Maven 3.8+
☑ MySQL 8.x running on port 3306
```

### 1. Clone
```bash
git clone https://github.com/amarenderreddyvoladri/production-prototype-security-template.git
cd production-prototype-security-template
```

### 2. Database
MySQL database `jwt_security` is **auto-created** by `createDatabaseIfNotExist=true`. No manual setup needed. Tables created automatically by `spring.jpa.hibernate.ddl-auto=update`.

### 3. Configure
Edit `src/main/resources/application.properties`:
```properties
spring.datasource.password=your_mysql_password
sendgrid.api.key=your_sendgrid_api_key
sendgrid.sender.email=your_verified_sender@domain.com
jwt.secret=your_minimum_256_bit_hex_secret
```

### 4. Run
```bash
./mvnw spring-boot:run
```
Application starts at: `http://localhost:8181`

### 5. Explore the API
Swagger UI: **`http://localhost:8181/swagger-ui.html`**
Click **Authorize** → enter `Bearer YOUR_TOKEN` → test all secured endpoints live

### 6. Default Admin Credentials
```
Username: admin@example.com
Password: Admin@123
```
*(Seeded by `UserDataInitializer` on first run — change immediately in production)*

---

## 📈 My Learning Philosophy

```
📅 DAILY    → Read documentation, write code, debug real errors — understand WHY not just HOW
🌿 WEEKLY   → One new security concept implemented end-to-end with proper testing
🐛 ALWAYS   → Every bug is documented, root-caused, and fixed properly — no workarounds
🔁 MONTHLY  → Refactor old code with new knowledge, harden architecture decisions
📝 COMMIT   → Every commit message explains what changed and why — no "fix stuff" commits
💬 NEVER    → Copy-paste without understanding — every line in this repo I can explain
```

> *"Security engineering is not about adding locks — it is about understanding every way a door can be opened. I am learning every attack vector by building the defense myself."*

---

## 💼 Why This Project Stands Out

- 🎯 **Real Production Decisions** — `userId` as JWT subject, DB-backed revocation, `REQUIRES_NEW` audit — these are not tutorial choices, these are battle-tested patterns
- 🐛 **Documented Bug Fixes** — 16+ real bugs found, root-caused, and properly resolved during development
- 🔒 **Defense-in-Depth** — Two security gates on every sensitive operation — permission annotation + service-layer re-validation
- 📊 **Full Observability** — 40+ audit event types, tamper-evident write-once logs, indexed for performance
- 🧱 **Clean Architecture** — Controller → Service → Repository with interfaces, DTOs, mappers, and proper layering
- 🌐 **Latest Stack** — Java 21, Spring Boot 3.4.5, Spring Security 6, JJWT 0.11.5 — current, not outdated
- 📈 **Growth-Documented** — Roadmap, bug tracker, and daily commits prove consistent, intentional improvement

---

## 👨‍💻 About the Developer

**Amarender Reddy Voladri** — Full-Stack Developer | Spring Boot Specialist | Security-Focused Engineer

I built this project not to follow a tutorial, but to deeply understand every tradeoff in security engineering — from why `userId` must be the JWT subject to why audit logs must run in independent transactions. Every architecture decision, every bug, every fix is something I debugged myself, understood fully, and documented in code.

**Skills demonstrated in this project:**
- Spring Boot 3.x + Spring Security 6 production-grade configuration
- Stateless JWT with full token lifecycle management and rotation
- RBAC with fine-grained permission enforcement at multiple architectural layers
- OTP-based email verification with bcrypt hashing and attempt limiting
- JPA Auditing, entity relationship modeling, write-once patterns
- Production bug identification, root-cause analysis, and proper resolution
- Clean, layered, maintainable architecture with clear separation of concerns

<p align="center">
  <a href="https://linkedin.com/in/amarenderreddyvoladri">
    <img src="https://img.shields.io/badge/LinkedIn-Connect-0077B5?style=for-the-badge&logo=linkedin&logoColor=white"/>
  </a>
  <a href="https://github.com/amarenderreddyvoladri">
    <img src="https://img.shields.io/badge/GitHub-Follow-181717?style=for-the-badge&logo=github&logoColor=white"/>
  </a>
</p>

---

## 📜 License

MIT License — Free to use, study, modify, and distribute with attribution.

---

<div align="center">

<img src="https://capsule-render.vercel.app/api?type=waving&color=0:0f0c29,50:302b63,100:24243e&height=120&section=footer&animation=twinkling" width="100%"/>

### ⭐ If this project demonstrates the kind of engineering quality you're looking for — please star it.
**Every star tells recruiters, senior engineers, and hiring managers that this work stands out.**

*This repository is updated daily. Watch it to follow progress in real time.*

</div>
