<div align="center">

# 🛡️ Production Prototype Security Template

### Enterprise-Grade Authentication & Authorization Microservices Platform

**JWT • RBAC • OTP • Redis • Kafka • API Gateway • Service Discovery • Centralized Config**

[![Java](https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)](https://spring.io/projects/spring-boot)
[![Spring Security](https://img.shields.io/badge/Spring%20Security-6-6DB33F?style=for-the-badge&logo=springsecurity&logoColor=white)](https://spring.io/projects/spring-security)
[![Redis](https://img.shields.io/badge/Redis-DC382D?style=for-the-badge&logo=redis&logoColor=white)](https://redis.io/)
[![Apache Kafka](https://img.shields.io/badge/Kafka-231F20?style=for-the-badge&logo=apachekafka&logoColor=white)](https://kafka.apache.org/)
[![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white)](https://www.mysql.com/)
[![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)](https://www.docker.com/)
[![JWT](https://img.shields.io/badge/JWT-Auth-000000?style=for-the-badge&logo=jsonwebtokens&logoColor=white)](https://jwt.io/)

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg?style=flat-square)](LICENSE)
[![Maintained](https://img.shields.io/badge/Maintained-Yes-brightgreen.svg?style=flat-square)]()
[![Services](https://img.shields.io/badge/Microservices-5-blue.svg?style=flat-square)]()
[![Bugs Fixed](https://img.shields.io/badge/Production%20Bugs%20Fixed-18%2B-orange.svg?style=flat-square)]()

**A real-world, production-style microservices security backbone — built the way a platform team would build the auth layer underneath an actual product.**

[Architecture](#-system-architecture) • [Tech Stack](#-technology-stack) • [Security Design](#-security-engineering-deep-dive) • [Services](#-microservices-breakdown) • [API Reference](#-api-reference) • [Setup](#-getting-started) • [Engineering Decisions](#-key-engineering-decisions--why-they-matter)

</div>

---

## 📌 What This Project Actually Is

Most "auth project" repos on GitHub are a single Spring Boot app with a login endpoint and a JWT filter bolted on. **This is not that.**

This is a **distributed, multi-service security platform** — the kind of system a dedicated platform/identity team builds *underneath* a real product, so every other microservice in the company can authenticate, authorize, and audit users without reinventing security logic. It was built to mirror how authentication, authorization, and notification concerns are decomposed and isolated in production-grade systems at scale.

> 💡 **The core idea:** Security shouldn't live inside your business logic. It should be a standalone, horizontally scalable, independently deployable platform that every other service trusts and talks to.

This repository demonstrates that philosophy end-to-end — from the JWT filter chain, to Redis-backed token revocation, to Kafka-driven async notifications, to a full audit trail that's tamper-resistant by design.

---

## 🏗️ System Architecture

### High-Level Service Topology

```mermaid
graph TB
    Client["🌐 Client Applications<br/>(Web / Mobile / Postman)"]

    subgraph Gateway["API Gateway Layer"]
        GW["🚪 API Gateway<br/>Spring Cloud Gateway<br/>+ Resilience4j Circuit Breaker"]
    end

    subgraph Discovery["Service Discovery"]
        EUREKA["📡 Netflix Eureka<br/>Service Registry"]
    end

    subgraph ConfigLayer["Centralized Configuration"]
        CONFIG["⚙️ Spring Cloud Config Server"]
    end

    subgraph CoreServices["Core Domain Services"]
        AUTH["🔐 Core Security Service<br/>Auth · RBAC · JWT · OTP · Audit"]
        NOTIF["📨 Notification Service<br/>SendGrid Email Dispatch"]
    end

    subgraph DataLayer["Data & Messaging Infrastructure"]
        MYSQL[("🗄️ MySQL<br/>Flyway Migrations")]
        REDIS[("⚡ Redis<br/>Token Blacklist · OTP TTL")]
        KAFKA["📬 Apache Kafka<br/>Async Event Bus"]
    end

    EXTERNAL["✉️ SendGrid<br/>(External Email API)"]

    Client -->|HTTPS Request| GW
    GW -->|Route + Auth Check| AUTH
    AUTH <-.->|Register / Discover| EUREKA
    NOTIF <-.->|Register / Discover| EUREKA
    GW <-.->|Register / Discover| EUREKA

    AUTH -->|Fetch Config| CONFIG
    NOTIF -->|Fetch Config| CONFIG
    GW -->|Fetch Config| CONFIG

    AUTH -->|JWT Subject = userId<br/>RBAC · Audit Logs| MYSQL
    AUTH -->|Blacklist Tokens<br/>bcrypt-hashed OTPs| REDIS
    AUTH -->|Publish Events<br/>e.g. OTP_GENERATED, USER_REGISTERED| KAFKA

    KAFKA -->|Consume Events| NOTIF
    NOTIF -->|Internal API Key Auth| AUTH
    NOTIF -->|Dispatch Email| EXTERNAL

    style Client fill:#4A90D9,color:#fff
    style GW fill:#E8743B,color:#fff
    style EUREKA fill:#6DB33F,color:#fff
    style CONFIG fill:#6DB33F,color:#fff
    style AUTH fill:#C0392B,color:#fff
    style NOTIF fill:#8E44AD,color:#fff
    style MYSQL fill:#005C84,color:#fff
    style REDIS fill:#DC382D,color:#fff
    style KAFKA fill:#231F20,color:#fff
    style EXTERNAL fill:#1A82E2,color:#fff
```

### Request Lifecycle — The 9-Step JWT Filter Chain

Every authenticated request to the Core Security Service flows through a deliberately ordered filter chain — order matters, and each step exists to close a specific class of vulnerability.

```mermaid
sequenceDiagram
    participant C as Client
    participant GW as API Gateway
    participant F as JWT Filter Chain
    participant R as Redis
    participant DB as MySQL
    participant S as Auth Service

    C->>GW: Request + Bearer Token
    GW->>F: Forward Request

    Note over F: Step 1 — Extract Authorization header
    F->>F: Step 2 — Validate Bearer prefix & format
    F->>F: Step 3 — Parse & verify JWT signature
    F->>R: Step 4 — Check token against blacklist
    R-->>F: Not Blacklisted ✅
    F->>F: Step 5 — Validate expiry & claims
    F->>DB: Step 6 — Load user by userId (JWT subject)
    DB-->>F: User + Roles + Permissions
    F->>F: Step 7 — Detect token reuse pattern
    F->>F: Step 8 — Build SecurityContext (roles/permissions)
    F->>S: Step 9 — Forward to controller w/ context
    S->>DB: Step 10 — Write audit log (REQUIRES_NEW txn)
    S-->>C: 200 OK + Response
```

### Token Reuse Detection & Session Revocation Flow

```mermaid
flowchart LR
    A["🔁 Refresh Token<br/>Reuse Detected"] --> B{"Already<br/>Used Before?"}
    B -->|Yes — Reuse!| C["🚨 Security Breach<br/>Signal"]
    B -->|No — First Use| D["✅ Issue New<br/>Access + Refresh Token"]
    C --> E["⛔ Revoke ALL Sessions<br/>for this User"]
    E --> F["📝 Write Audit Event<br/>SESSION_REVOKED_REUSE_DETECTED"]
    E --> G["🗑️ Blacklist Every<br/>Active Token in Redis"]
    F --> H["📨 Trigger Security<br/>Alert via Kafka → Notification Service"]

    style A fill:#E8743B,color:#fff
    style C fill:#C0392B,color:#fff
    style E fill:#C0392B,color:#fff
    style D fill:#27AE60,color:#fff
    style H fill:#8E44AD,color:#fff
```

### OTP Lifecycle (Redis-Backed, Purpose-Isolated)

```mermaid
flowchart TD
    A["User requests OTP<br/>(e.g., LOGIN, PASSWORD_RESET, EMAIL_VERIFY)"] --> B["Generate 6-digit OTP"]
    B --> C["bcrypt-hash the OTP"]
    C --> D["Store in Redis<br/>Key = userId:purpose<br/>TTL = configured expiry"]
    D --> E["Publish OTP_GENERATED<br/>event to Kafka"]
    E --> F["Notification Service<br/>consumes event"]
    F --> G["SendGrid dispatches<br/>OTP email"]

    H["User submits OTP"] --> I{"Match bcrypt hash<br/>+ correct purpose<br/>+ not expired?"}
    I -->|Valid| J["✅ Action authorized<br/>OTP deleted from Redis"]
    I -->|Invalid / Expired| K["❌ Reject<br/>+ Audit log entry"]

    style D fill:#DC382D,color:#fff
    style E fill:#231F20,color:#fff
    style J fill:#27AE60,color:#fff
    style K fill:#C0392B,color:#fff
```

---

## 🧰 Technology Stack

<table>
<tr>
<th>Layer</th>
<th>Technology</th>
<th>Why It's Here</th>
</tr>

<tr>
<td><b>Language & Runtime</b></td>
<td>Java 17, Spring Boot 3.x</td>
<td>Modern Spring Boot 3 baseline with Jakarta namespace, virtual-thread-ready runtime</td>
</tr>

<tr>
<td><b>Security</b></td>
<td>Spring Security 6, JWT (JJWT), RBAC</td>
<td>Stateless authentication with claims-based authorization across 5 roles and 22+ granular permissions</td>
</tr>

<tr>
<td><b>API Gateway</b></td>
<td>Spring Cloud Gateway, Resilience4j</td>
<td>Single entry point, dynamic routing, and circuit-breaking to prevent cascading failures across services</td>
</tr>

<tr>
<td><b>Service Discovery</b></td>
<td>Netflix Eureka</td>
<td>Dynamic service registration so the Gateway never hardcodes service locations</td>
</tr>

<tr>
<td><b>Centralized Config</b></td>
<td>Spring Cloud Config Server</td>
<td>Externalized, environment-aware configuration shared across every microservice</td>
</tr>

<tr>
<td><b>Caching & Ephemeral State</b></td>
<td>Redis</td>
<td>Token blacklist for instant revocation, OTP storage with native TTL expiry — no cron cleanup jobs needed</td>
</tr>

<tr>
<td><b>Messaging / Event Bus</b></td>
<td>Apache Kafka</td>
<td>Decouples the auth service from the notification service — auth never blocks on email delivery</td>
</tr>

<tr>
<td><b>Persistence</b></td>
<td>MySQL, Flyway</td>
<td>Versioned, repeatable schema migrations — no manual SQL scripts, no schema drift between environments</td>
</tr>

<tr>
<td><b>Transactional Email</b></td>
<td>SendGrid</td>
<td>Reliable transactional email delivery for OTPs, alerts, and account notifications</td>
</tr>

<tr>
<td><b>Containerization</b></td>
<td>Docker, Docker Compose</td>
<td>One-command spin-up of the entire 5-service distributed system, locally or in CI</td>
</tr>

<tr>
<td><b>Resilience</b></td>
<td>Resilience4j</td>
<td>Circuit breakers and retries at the Gateway so one struggling downstream service can't take down the whole platform</td>
</tr>

</table>

---

## 🧩 Microservices Breakdown

```mermaid
graph LR
    subgraph " "
        direction TB
        S1["1️⃣ Core Security Service<br/>━━━━━━━━━━━━━<br/>Auth · JWT · RBAC<br/>OTP · Audit Logging"]
        S2["2️⃣ Notification Service<br/>━━━━━━━━━━━━━<br/>Kafka Consumer<br/>SendGrid Dispatch"]
        S3["3️⃣ API Gateway<br/>━━━━━━━━━━━━━<br/>Routing<br/>Resilience4j"]
        S4["4️⃣ Eureka Server<br/>━━━━━━━━━━━━━<br/>Service Registry"]
        S5["5️⃣ Config Server<br/>━━━━━━━━━━━━━<br/>Centralized Config"]
    end

    style S1 fill:#C0392B,color:#fff
    style S2 fill:#8E44AD,color:#fff
    style S3 fill:#E8743B,color:#fff
    style S4 fill:#6DB33F,color:#fff
    style S5 fill:#6DB33F,color:#fff
```

| # | Service | Core Responsibility | Key Tech |
|---|---------|---------------------|----------|
| 1 | **Core Security Service** | User auth, registration, JWT issuance/validation, RBAC enforcement, OTP generation/verification, write-once audit logging | Spring Security 6, JWT, Redis, MySQL |
| 2 | **Notification Service** | Consumes Kafka events, sends transactional emails via SendGrid, authenticated via internal API key | Kafka Consumer, SendGrid, Eureka Client |
| 3 | **API Gateway** | Single entry point for all client traffic, dynamic request routing, circuit breaking | Spring Cloud Gateway, Resilience4j |
| 4 | **Eureka Server** | Service registry — every service self-registers and discovers peers dynamically | Netflix Eureka |
| 5 | **Config Server** | Single source of truth for configuration across all environments | Spring Cloud Config |

---

## 🔐 Security Engineering Deep Dive

This is the section that separates a tutorial project from a production-minded one. Every decision below was made deliberately, with a specific failure mode in mind.

### 🎯 JWT Subject = `userId`, Not Email

> Emails change. User IDs don't. Using a mutable field as the cryptographic subject of a token is a subtle but real production bug — this system avoids it from day one by using the immutable internal `userId` as the JWT subject claim.

### 🎯 Write-Once Audit Logging in `REQUIRES_NEW` Transactions

> Audit logs are written in a **separate, independent transaction** (`@Transactional(propagation = Propagation.REQUIRES_NEW)`) so that even if the parent business transaction rolls back, the audit trail survives. **40+ distinct audit event types** are tracked — covering everything from login attempts to permission changes to token revocations — making the system forensically traceable.

### 🎯 Token Reuse Detection with Full Session Revocation

> Refresh token rotation is implemented with reuse detection: if a previously-used refresh token is ever presented again, it's treated as a signal of token theft, and **every active session for that user is revoked immediately** — not just the compromised token.

### 🎯 Redis-Backed, bcrypt-Hashed OTPs with Purpose Isolation

> OTPs are never stored in plaintext — they're bcrypt-hashed before being cached in Redis. Each OTP is scoped to a specific **purpose** (login, password reset, email verification), so an OTP issued for one flow can never be replayed against another.

### 🎯 The 9-Step JWT Filter Chain

> Rather than a single monolithic filter, request authentication is broken into nine discrete, independently testable steps — extraction, format validation, signature verification, blacklist check, expiry/claims validation, user resolution, reuse detection, security context construction, and forwarding. Each step fails fast and fails loud.

### 🎯 RBAC at Real Granularity

> Role-based access control here isn't a toy `ADMIN` / `USER` switch. The system models:

| Dimension | Scope |
|---|---|
| **Roles** | 5 distinct roles |
| **Permissions** | 22+ granular, independently assignable permissions |
| **Microservices Enforcing RBAC** | 5 services, consistently |
| **Audit Event Types Tracked** | 40+ distinct event categories |

---

## 🔄 Internal Service Communication

```mermaid
graph TB
    subgraph "Synchronous Communication"
        GW2["API Gateway"] -->|"REST + Internal API Key"| AUTH2["Core Security Service"]
        NOTIF2["Notification Service"] -->|"REST + Internal API Key Auth"| AUTH2
    end

    subgraph "Asynchronous Communication"
        AUTH2 -->|"Publish Event"| TOPIC["Kafka Topic"]
        TOPIC -->|"Consume Event"| NOTIF2
    end

    subgraph "Service Discovery (All Services)"
        AUTH2 -.->|register/heartbeat| EUREKA2["Eureka Server"]
        NOTIF2 -.->|register/heartbeat| EUREKA2
        GW2 -.->|register/heartbeat| EUREKA2
    end

    style AUTH2 fill:#C0392B,color:#fff
    style NOTIF2 fill:#8E44AD,color:#fff
    style GW2 fill:#E8743B,color:#fff
    style TOPIC fill:#231F20,color:#fff
    style EUREKA2 fill:#6DB33F,color:#fff
```

Inter-service calls are authenticated with an **internal API key**, separate from end-user JWTs — meaning even if a service-to-service call is intercepted, it cannot be replayed as a user-facing credential, and vice versa. The Notification Service was specifically hardened to register with Eureka and authenticate every inbound call from the Core Security Service through this internal key mechanism.

---

## 📡 API Reference

> Full endpoint-level documentation lives in the codebase. High-level surface area:

| Category | Example Endpoints | Auth Required |
|---|---|---|
| **Authentication** | `POST /api/auth/register`, `POST /api/auth/login`, `POST /api/auth/refresh` | No (login/register) |
| **OTP** | `POST /api/otp/generate`, `POST /api/otp/verify` | Varies by purpose |
| **User & RBAC** | `GET /api/users/{id}`, `PUT /api/users/{id}/roles` | JWT + Permission Check |
| **Session Management** | `POST /api/auth/logout`, `POST /api/auth/revoke-all` | JWT |
| **Audit** | `GET /api/audit/logs` | JWT + Admin Permission |
| **Notifications (Internal)** | `POST /internal/notify/email` | Internal API Key |

---

## 🛠️ Key Engineering Decisions — Why They Matter

| Decision | Naive Alternative | Why This Approach Wins |
|---|---|---|
| Redis token blacklist | DB-backed revocation table | Sub-millisecond lookups, native TTL — no cleanup jobs |
| Kafka for notifications | Direct synchronous REST call | Auth service never blocks waiting on SendGrid |
| `userId` as JWT subject | Email as JWT subject | Immutable identity — survives email changes |
| `REQUIRES_NEW` audit transactions | Audit log in same transaction | Audit trail survives even on business-logic rollback |
| Internal API key for service calls | Reusing user JWTs internally | Clean credential separation between user-facing and service-facing auth |
| Config Server | `.env` files per service | One source of truth, environment-aware, no config drift |
| Eureka service discovery | Hardcoded service URLs | Services scale up/down without redeploying the Gateway |

---

## 🐛 Production Hardening — 18+ Real Bugs Found & Fixed

This wasn't built once and left untouched — it went through multiple rounds of real debugging that mirror actual production incidents:

- 🔧 Resolved a **method signature mismatch** between `NotificationClient` and its callers
- 🔧 Added **internal API key authentication** to the Notification Service
- 🔧 Fixed **missing Eureka registration** in the Notification Service
- 🔧 Corrected an **unstable SNAPSHOT dependency** that broke reproducible builds
- 🔧 Added missing configuration properties causing silent startup failures
- 🔧 ...and 13+ additional fixes spanning serialization, transaction boundaries, and security filter ordering

---

## 🚀 Getting Started

```bash
# Clone the repository
git clone https://github.com/amarenderreddyvoladri/production-prototype-security-template.git
cd production-prototype-security-template

# Spin up the entire 5-service distributed system
docker-compose up --build

# Services will register with Eureka automatically.
# Eureka Dashboard:        http://localhost:8761
# API Gateway entrypoint:  http://localhost:8080
```

**Prerequisites:** Java 17+, Docker & Docker Compose, Maven

---

## 👤 About the Engineer

**Amarender Reddy Voladri**
Java Backend Developer | Spring Boot · Microservices · Distributed Systems Security

This project was built as a hands-on deep dive into how real platform teams architect identity and authorization infrastructure — not as a tutorial clone, but as a system designed, broken, debugged, and hardened the way production software actually gets built.

[![GitHub](https://img.shields.io/badge/GitHub-amarenderreddyvoladri-181717?style=flat-square&logo=github)](https://github.com/amarenderreddyvoladri)
[![Portfolio](https://img.shields.io/badge/Portfolio-Visit-FF5722?style=flat-square&logo=netlify)](https://amarenderreddyvoladri-portfolio.netlify.app)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-Connect-0A66C2?style=flat-square&logo=linkedin)](https://linkedin.com/in/amarender-reddy-voladri)

---

<div align="center">

**⭐ If this architecture was useful as a reference for your own backend system design, consider starring the repo.**

</div>
