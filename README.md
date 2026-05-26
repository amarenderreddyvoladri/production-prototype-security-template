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
