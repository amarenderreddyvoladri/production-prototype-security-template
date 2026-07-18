# 🚀 Production Prototype Security Template

> Enterprise Authentication & Authorization Platform built using Spring Boot Microservices.

---

![Java](https://img.shields.io/badge/Java-21-orange)

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)

![Microservices](https://img.shields.io/badge/Microservices-Spring%20Cloud-blue)

![Docker](https://img.shields.io/badge/Docker-Compose-blue)

![Redis](https://img.shields.io/badge/Redis-7-red)

![MySQL](https://img.shields.io/badge/MySQL-8.4-blue)

![JWT](https://img.shields.io/badge/Security-JWT-success)

![License](https://img.shields.io/badge/License-MIT-green)

---

# Project Setup Guide

Welcome to the **Production Prototype Security Template**.

This document is the **official onboarding guide** for every developer, contributor, collaborator and maintainer working on this repository.

Following this guide exactly will ensure your local development environment matches the project architecture used throughout the repository.

---

## Audience

This guide is intended for

- New Contributors
- Collaborators
- Open Source Contributors
- Software Engineers
- Java Developers
- Spring Boot Developers
- DevOps Engineers
- Project Maintainers

---

## Document Version

| Item | Value |
|------|------|
| Version | 1.0 |
| Last Updated | July 2026 |
| Maintainer | Repository Owner |
| Document Type | Official Project Documentation |

---
# 📑 Table of Contents

## 1. Introduction

- Project Overview
- Project Goals
- Features
- Technology Stack

---

## 2. Environment Setup

- System Requirements
- Install Git
- Install JDK
- Install Maven
- Install Docker
- Install Docker Compose
- Install IDE

---

## 3. Clone Repository

- Git Clone
- Verify Repository
- Checkout Branch

---

## 4. Configure Environment

- .env
- Environment Variables
- Database Credentials
- JWT Secret
- Redis Password

---

## 5. Build Project

- Maven Build
- Docker Build
- Docker Compose

---

## 6. Run Project

- Start MySQL
- Start Redis
- Config Server
- Eureka
- Notification Service
- Security Service
- API Gateway

---

## 7. Verify Setup

- Swagger
- Eureka Dashboard
- Docker Containers
- Health APIs

---

## 8. Project Architecture

- Microservices
- Database
- Redis
- Authentication
- JWT
- Internal Communication

---

## 9. Development Workflow

- Branch Naming
- Commit Convention
- Pull Requests
- Issue Workflow

---

## 10. Troubleshooting

- Docker
- MySQL
- Redis
- Maven
- Java
- Port Conflicts

---

## 11. Useful Commands

---

## 12. References

---

## 13. FAQ

---
# 📌 Project Overview

The Production Prototype Security Template is an enterprise-ready Spring Boot microservices platform focused on secure authentication and authorization.

The project demonstrates production-grade implementation patterns including:

- Spring Security
- JWT Authentication
- Refresh Token Rotation
- Role Based Access Control
- OTP Authentication
- Account Lock Protection
- Redis Integration
- Spring Cloud Config
- Eureka Discovery
- API Gateway
- Dockerized Deployment
- Audit Logging
- Notification Service
- Internal Service Communication
- Centralized Configuration

The repository is intended to serve as both a production-ready starter template and a learning resource for developers building secure distributed systems.

---
# 🎯 Project Goals

The objectives of this repository are:

- Demonstrate enterprise software architecture.
- Follow clean code principles.
- Follow SOLID design principles.
- Implement production-grade security.
- Showcase modern Spring Boot development.
- Demonstrate Docker-based development.
- Encourage contribution from open source developers.
- Maintain high code quality.
- Provide reusable enterprise components.
- Promote secure coding practices.

---
# 💻 System Requirements

Before cloning or running this project, ensure your development machine meets the minimum requirements below.

---

# Minimum Hardware Requirements

| Component | Minimum | Recommended |
|-----------|----------|-------------|
| Processor | Dual Core | Quad Core or higher |
| RAM | 8 GB | 16 GB+ |
| Storage | 15 GB Free | 50 GB SSD |
| Internet | Required | High Speed |
| Operating System | Windows 10 / Ubuntu 22.04 / macOS | Latest Stable Version |

---

# Supported Operating Systems

- Windows 10
- Windows 11
- Ubuntu 22.04+
- Debian 12+
- macOS Ventura+
- Other Linux distributions supporting Docker

---

# Required Software

| Software | Version |
|----------|----------|
| Git | Latest Stable |
| JDK | Java 21 |
| Maven | 3.9.x |
| Docker Desktop | Latest |
| Docker Compose | Latest |
| IntelliJ IDEA / STS | Latest |
| VS Code (Optional) | Latest |

---

# Verify Installed Software

## Git

```bash
git --version
```

Expected Output

```text
git version 2.x.x
```

---

## Java

```bash
java -version
```

Expected

```text
openjdk version "21"
```

---

## Javac

```bash
javac -version
```

Expected

```text
javac 21
```

---

## Maven

```bash
mvn -version
```

Expected

```text
Apache Maven 3.9.x
```

---

## Docker

```bash
docker --version
```

---

## Docker Compose

```bash
docker compose version
```

---

## Docker Running

```bash
docker info
```

If Docker is running successfully, system information will be displayed.

---

# 📥 Clone the Repository

Clone the latest version of the project.

```bash
git clone https://github.com/amarenderreddyvoladri/production-prototype-security-template.git
```

Navigate into the project.

```bash
cd production-prototype-security-template
```

Verify the repository.

```bash
git status
```

Expected Output

```text
On branch master

Your branch is up to date with 'origin/master'.

nothing to commit, working tree clean
```

View all files.

Windows

```bash
dir
```

Linux/macOS

```bash
ls -la
```

---

# 🌿 Create Your Development Branch

Never develop directly on the master branch.

Update your local repository.

```bash
git checkout master
```

```bash
git pull origin master
```

Create your branch.

```bash
git checkout -b feature/<issue-name>
```

Example

```bash
git checkout -b fix/001-admin-unlock-clear-redis-counter
```

Verify the active branch.

```bash
git branch
```

The active branch will be marked with `*`.

---

# 📁 Project Directory Structure

```text
production-prototype-security-template
│
├── api-gateway
├── config-server
├── eureka-server
├── notification-service
├── springboot-security-jwt-rbac-app4
│
├── docker-compose.yml
├── .env.example
├── README.md
├── CONTRIBUTING.md
│
├── docs
│   ├── getting-started
│   ├── architecture
│   ├── authentication
│   ├── redis
│   ├── deployment
│   └── troubleshooting
│
└── .github
    ├── ISSUE_TEMPLATE
    └── workflows
```

---

# ⚙️ Environment Configuration

The application uses environment variables for all sensitive configuration.

Never hardcode credentials.

---

## Copy the Environment File

Linux/macOS

```bash
cp .env.example .env
```

Windows PowerShell

```powershell
Copy-Item .env.example .env
```

---

## Verify the File Exists

Windows

```bash
dir
```

Linux

```bash
ls -la
```

Expected

```text
.env
.env.example
```

---

# Required Environment Variables

| Variable | Required | Description |
|----------|-----------|-------------|
| DB_USERNAME | Yes | MySQL username |
| DB_PASSWORD | Yes | MySQL password |
| REDIS_PASSWORD | Yes | Redis password |
| JWT_SECRET | Yes | 256-bit signing key |
| INTERNAL_API_KEY | Yes | Internal service communication |
| SENDGRID_API_KEY | Yes | SendGrid API Key |
| SENDGRID_SENDER_MAIL | Yes | Sender Email |
| SENDGRID_SENDER_NAME | Yes | Sender Name |

---

# Security Notice

Never commit

```
.env
```

Never commit

```
application-local.properties
```

Never commit

```
application-prod.properties
```

Never expose

- JWT Secret
- Database Password
- Redis Password
- SendGrid API Key
- Internal API Key

Always verify

```bash
git status
```

before every commit.

If `.env` appears in staged files,

remove it immediately.

```bash
git restore --staged .env
```

or

```bash
git reset HEAD .env
```

The `.env` file must remain local and is ignored by Git through `.gitignore`.

---

# ✅ Next Section

The next chapter will cover:

- Docker Architecture
- Container Startup Order
- Docker Compose Explained
- MySQL Container
- Redis Container
- Config Server
- Eureka Server
- Notification Service
- Security Service
- API Gateway
- Health Checks
- Complete Docker Commands
- Container Logs
- Restart Individual Services
- Debugging Docker Issues

---

# 🐳 Docker Architecture

## Why Docker?

This project is fully containerized to provide a consistent and reproducible development environment. Every contributor, regardless of operating system, runs the exact same software versions and service configuration.

Docker eliminates issues such as:

- "Works on my machine"
- Java version mismatch
- Maven dependency conflicts
- Different MySQL versions
- Different Redis versions
- Local configuration differences

No local installation of MySQL or Redis is required.

---

# Architecture Overview

```

```
                        Docker Network
┌─────────────────────────────────────────────────────────────┐

                  Config Server (8888)
                          │
                          ▼
                  Eureka Server (8761)
                          │
        ┌─────────────────┴─────────────────┐
        ▼                                   ▼

Notification Service                 Security Service
      (8182)                             (8181)
                                             │
                                             ▼
                                    API Gateway (8085)

                                             │

                        ┌────────────────────┴───────────────┐
                        ▼                                    ▼

                    MySQL 8.4                         Redis 7

```

```

Every container communicates through Docker's internal bridge network.

Services never communicate using localhost inside Docker.

Example:

Correct

```
http://config-server:8888
```

Incorrect

```
http://localhost:8888
```

---

# Docker Network

Compose automatically creates

```
production-prototype-security-template_default
```

All containers join this network automatically.

Verify

```bash
docker network ls
```

Inspect

```bash
docker network inspect production-prototype-security-template_default
```

---

# Container Startup Order

The project uses Docker health checks.

Containers start only after dependencies become healthy.

```
MySQL
      │
      ▼

Redis
      │
      ▼

Config Server
      │
      ▼

Eureka Server
      │
      ▼

Notification Service
      │
      ▼

Security Service
      │
      ▼

API Gateway
```

This prevents startup failures caused by unavailable dependencies.

---

# Docker Compose File

Main file

```
docker-compose.yml
```

This file defines

- Containers
- Images
- Networks
- Volumes
- Environment Variables
- Health Checks
- Restart Policies
- Port Mapping

---

# Docker Images

| Service | Image |
|----------|-------------------------------|
| MySQL | mysql:8.4 |
| Redis | redis:7-alpine |
| Config Server | Built locally |
| Eureka Server | Built locally |
| Notification Service | Built locally |
| Security Service | Built locally |
| API Gateway | Built locally |

---

# Multi-stage Docker Build

Every Spring Boot application uses a multi-stage Docker build.

Stage 1

```
maven:3.9.9-eclipse-temurin-21
```

Responsibilities

- Download dependencies
- Compile source
- Execute tests
- Build executable JAR

Stage 2

```
eclipse-temurin:21-jre-jammy
```

Responsibilities

- Copy JAR
- Run application
- Lightweight runtime image

Advantages

- Smaller image size
- Faster startup
- Better security
- Reduced attack surface

---

# Non-root Containers

All Spring Boot services run as

```
spring
```

instead of

```
root
```

Benefits

- Better security
- Reduced privilege escalation
- Enterprise best practice
- Docker CIS Benchmark compliance

---

# Build Everything

Build all services.

```bash
docker compose build
```

Build without cache.

```bash
docker compose build --no-cache
```

Build a specific service.

Example

```bash
docker compose build security-service
```

---

# Start Entire Platform

```bash
docker compose up
```

Detached mode

```bash
docker compose up -d
```

Force rebuild

```bash
docker compose up --build
```

Recreate all containers

```bash
docker compose up --force-recreate
```

---

# Verify Running Containers

```bash
docker ps
```

Expected

```
mysql

redis

config-server

eureka-server

notification-service

security-service

api-gateway
```

---

# View All Containers

```bash
docker ps -a
```

---

# View Docker Images

```bash
docker images
```

---

# View Logs

All containers

```bash
docker compose logs
```

Live logs

```bash
docker compose logs -f
```

Single service

```bash
docker compose logs security-service
```

Live single service

```bash
docker compose logs -f security-service
```

---

# Restart Services

Restart all

```bash
docker compose restart
```

Restart one

```bash
docker compose restart security-service
```

Restart MySQL

```bash
docker compose restart mysql
```

Restart Redis

```bash
docker compose restart redis
```

---

# Stop Services

Stop containers

```bash
docker compose stop
```

Stop one container

```bash
docker compose stop security-service
```

---

# Shutdown Platform

```bash
docker compose down
```

Remove volumes

```bash
docker compose down -v
```

Remove orphan containers

```bash
docker compose down --remove-orphans
```

---

# Execute Commands Inside Containers

Security Service

```bash
docker exec -it security-service bash
```

MySQL

```bash
docker exec -it mysql bash
```

Redis

```bash
docker exec -it redis sh
```

---

# Container Health

Inspect

```bash
docker inspect security-service
```

Filter health

```bash
docker inspect --format='{{json .State.Health}}' security-service
```

---

# Docker Troubleshooting

## Container not starting

Check

```bash
docker compose logs
```

---

## Container unhealthy

Inspect

```bash
docker inspect security-service
```

---

## Port already in use

Windows

```bash
netstat -ano | findstr :8085
```

Linux

```bash
sudo lsof -i :8085
```

Kill process before restarting Docker.

---

## Remove Everything

⚠️ Development only.

```bash
docker compose down -v
docker system prune -a
docker volume prune
```

---

# Verification Checklist

Before continuing, verify:

- [ ] Docker Desktop is running
- [ ] All seven containers are healthy
- [ ] No restart loops
- [ ] No failed health checks
- [ ] Docker network created
- [ ] Docker volumes created
- [ ] All logs are clean
- [ ] `docker ps` shows all expected containers
- [ ] No port conflicts
- [ ] Platform starts successfully with `docker compose up --build`

---

⬆️ **Back to:** [Table of Contents](#-table-of-contents)

➡️ **Next Section:** MySQL Database Setup

---

# 🗄️ MySQL Database Setup

## Overview

MySQL is the primary relational database used by the platform.

All business-critical data is persisted in MySQL including:

- Users
- Roles
- Permissions
- User-Role Mapping
- Role-Permission Mapping
- OTP Metadata (if persisted)
- Audit Logs
- Notification Records
- Refresh Tokens
- Login History
- Security Events

The application uses **Spring Data JPA + Hibernate** to manage the schema automatically during local development.

---

# Database Version

| Component | Version |
|-----------|----------|
| Database | MySQL 8.4 |
| Driver | MySQL Connector/J |
| ORM | Hibernate |
| Access | Spring Data JPA |
| Container | mysql:8.4 |

---

# Container Information

Container Name

```
mysql
```

Internal Port

```
3306
```

Host Port

```
3307
```

Database Name

```
jwt_security
```

---

# Verify MySQL Container

List running containers.

```bash
docker ps
```

Expected Output

```
mysql
```

---

View container logs.

```bash
docker logs mysql
```

or

```bash
docker compose logs mysql
```

Expected

```
ready for connections
```

---

# Connect to MySQL Container

Open shell.

```bash
docker exec -it mysql bash
```

Login.

```bash
mysql -u root -p
```

Enter password from

```
.env
```

---

# Verify Database

Show databases.

```sql
SHOW DATABASES;
```

Expected

```text
information_schema

mysql

performance_schema

jwt_security
```

Switch database.

```sql
USE jwt_security;
```

---

# View Tables

```sql
SHOW TABLES;
```

Expected tables include

```
users

roles

permissions

user_roles

role_permissions

audit_logs

notifications

user_tokens
```

---

# Describe Table

Example

```sql
DESC users;
```

---

# Count Records

```sql
SELECT COUNT(*) FROM users;
```

---

# View Users

```sql
SELECT * FROM users;
```

---

# View Roles

```sql
SELECT * FROM roles;
```

---

# View Audit Logs

```sql
SELECT * FROM audit_logs
ORDER BY created_at DESC;
```

---

# View Refresh Tokens

```sql
SELECT * FROM user_tokens;
```

---

# Exit MySQL

```sql
exit;
```

---

# Database Initialization

The application automatically creates

- Database
- Tables
- Constraints
- Indexes

using Hibernate.

No manual SQL execution is required for local development.

---

# Hibernate Configuration

The project uses

```
spring.jpa.hibernate.ddl-auto=update
```

Development

```
update
```

Production

```
validate
```

Never use

```
create
```

or

```
create-drop
```

in production.

---

# Database Connection Flow

```
Spring Boot

      │

      ▼

HikariCP

      │

      ▼

MySQL Driver

      │

      ▼

MySQL Container
```

---

# Hikari Connection Pool

The project uses

```
HikariCP
```

Benefits

- Fast connections
- Low latency
- Production ready
- Automatic pooling
- Reduced overhead

---

# Verify Connection Pool

Application logs

```
HikariPool-1 - Start completed
```

indicates successful initialization.

---

# Connect Using DBeaver

Host

```
localhost
```

Port

```
3307
```

Database

```
jwt_security
```

Username

```
root
```

Password

```
From .env
```

---

# Recommended SQL Queries

Current users

```sql
SELECT * FROM users;
```

Locked users

```sql
SELECT *
FROM users
WHERE account_locked = true;
```

Admins

```sql
SELECT *
FROM users
WHERE role='ADMIN';
```

Audit count

```sql
SELECT COUNT(*)
FROM audit_logs;
```

Latest notifications

```sql
SELECT *
FROM notifications
ORDER BY created_at DESC;
```

Latest refresh tokens

```sql
SELECT *
FROM user_tokens
ORDER BY created_at DESC;
```

---

# Database Backup

Export

```bash
docker exec mysql mysqldump \
-u root \
-p jwt_security > backup.sql
```

Restore

```bash
docker exec -i mysql mysql \
-u root \
-p jwt_security < backup.sql
```

---

# Reset Database

⚠️ Development only.

```bash
docker compose down -v
```

Then

```bash
docker compose up --build
```

Hibernate recreates the schema.

---

# Common Database Issues

## Database Not Found

Verify

```sql
SHOW DATABASES;
```

---

## Access Denied

Check

```
DB_USERNAME

DB_PASSWORD
```

inside

```
.env
```

---

## Connection Refused

Verify container.

```bash
docker ps
```

---

## Port Already Used

Windows

```bash
netstat -ano | findstr :3307
```

Linux

```bash
sudo lsof -i :3307
```

---

## Table Missing

Check

Application startup logs.

Hibernate should create missing tables automatically.

---

# Verification Checklist

Before proceeding verify

- [ ] MySQL container running
- [ ] Database exists
- [ ] All expected tables created
- [ ] Hibernate initialized successfully
- [ ] DBeaver connection works
- [ ] CRUD operations successful
- [ ] No startup SQL errors
- [ ] HikariCP initialized
- [ ] Audit logs accessible
- [ ] Refresh token table available

---

# Useful MySQL Commands

List databases

```sql
SHOW DATABASES;
```

Select database

```sql
USE jwt_security;
```

List tables

```sql
SHOW TABLES;
```

Describe table

```sql
DESC users;
```

View records

```sql
SELECT * FROM users;
```

Exit

```sql
EXIT;
```

---

💡 **Developer Tip**

Do **not** manually edit production data directly in MySQL unless the task specifically requires it. Prefer using application APIs or service-layer logic to maintain business rules, audit logging, and data integrity.

---

⬆️ **Back to:** [Table of Contents](#-table-of-contents)

➡️ **Next Section:** Redis Setup & Caching Architecture

---

---

# 🔴 Redis Setup & Caching Architecture

## Overview

Redis is used as an **in-memory data store** for temporary, high-speed data that should not be permanently stored in MySQL.

Unlike MySQL, Redis stores data in memory for extremely fast read and write operations.

In this project Redis is **NOT** used as a general-purpose cache.

Redis is intentionally limited to security-related features.

---

# Why Redis?

Authentication systems frequently need to store temporary information.

Examples include

- One Time Passwords (OTP)
- Failed Login Attempts
- Session Metadata
- Rate Limiting
- Temporary Security Tokens

Using MySQL for these operations would generate unnecessary disk I/O and slower response times.

Redis provides

- Extremely fast reads
- Extremely fast writes
- Automatic expiration (TTL)
- Lightweight memory usage
- High throughput
- Production-grade performance

---

# Redis Version

| Component | Version |
|-----------|----------|
| Redis | 7.x Alpine |
| Deployment | Docker Container |
| Storage | In-Memory + AOF Persistence |
| Port | 6379 |

---

# Redis Container

Container Name

```
redis
```

Internal Port

```
6379
```

Host Port

```
6379
```

Docker Image

```
redis:7-alpine
```

---

# Redis Configuration

Redis starts with

```bash
redis-server \
--appendonly yes \
--requirepass ${REDIS_PASSWORD}
```

Meaning

- Password Protected
- Append Only File enabled
- Persistent across restarts

---

# Verify Redis Container

```bash
docker ps
```

Expected

```
redis
```

---

View Logs

```bash
docker logs redis
```

or

```bash
docker compose logs redis
```

Expected

```
Ready to accept connections
```

---

# Connect to Redis

```bash
docker exec -it redis sh
```

Authenticate

```bash
redis-cli
```

```text
AUTH your_redis_password
```

---

# Verify Connection

```text
PING
```

Expected

```text
PONG
```

---

# View All Keys

```text
KEYS *
```

---

# Current Redis Usage

Redis stores only temporary security information.

### OTP Keys

```
otp:REGISTER:user@email.com

otp:LOGIN:user@email.com

otp:RESET:user@email.com
```

Each key automatically expires.

---

### Login Attempts

```
login:attempts:john

login:attempts:admin
```

These counters determine account locking.

---

# Redis Architecture

```
                    Authentication

                          │

                          ▼

                 LoginAttemptService

                          │

          ┌───────────────┴──────────────┐

          ▼                              ▼

 RedisLoginAttemptService          UserService

          │                              │

          ▼                              ▼

       Redis                      MySQL Database
```

---

# OTP Workflow

```
User

   │

   ▼

Generate OTP

   │

   ▼

Store OTP in Redis

   │

   ▼

TTL = 5 Minutes

   │

   ▼

Send Email

   │

   ▼

User Verification

   │

   ▼

Delete OTP
```

---

# Failed Login Workflow

```
Incorrect Password

        │

        ▼

Increment Redis Counter

        │

        ▼

Counter >= Maximum?

        │

        ▼

Lock Account

        │

        ▼

Update Database
```

---

# Verify OTP Keys

Generate OTP.

Execute

```text
KEYS otp:*
```

Expected

```
otp:REGISTER:user@email.com
```

---

View OTP

```text
GET otp:REGISTER:user@email.com
```

---

Remaining TTL

```text
TTL otp:REGISTER:user@email.com
```

Expected

```
280

279

278

...

0
```

---

# Verify Login Attempts

```text
KEYS login:*
```

Example

```
login:attempts:john
```

View value

```text
GET login:attempts:john
```

---

Remaining Expiry

```text
TTL login:attempts:john
```

---

# Delete Login Counter

Development Only

```text
DEL login:attempts:john
```

---

# Flush Database

⚠️ Development Only

```text
FLUSHDB
```

Clear everything

```text
FLUSHALL
```

Never execute these commands on production.

---

# Redis Persistence

The project enables

```
Append Only File (AOF)
```

Benefits

- Better durability
- Recoverable after restart
- Production ready
- Minimal data loss

---

# Redis Security

Redis requires authentication.

Password is loaded from

```
.env
```

Never hardcode

```
REDIS_PASSWORD
```

Never commit

```
.env
```

---

# Redis Data Expiration

OTP

```
5 Minutes
```

Login Attempts

```
Configured by

security.account.failed-attempt-expiry-minutes
```

Automatic cleanup occurs after TTL expires.

---

# Common Redis Commands

Ping

```text
PING
```

View Keys

```text
KEYS *
```

View OTP

```text
GET otp:REGISTER:user@email.com
```

View Login Attempts

```text
GET login:attempts:john
```

Remaining TTL

```text
TTL login:attempts:john
```

Delete Key

```text
DEL login:attempts:john
```

Exit

```text
EXIT
```

---

# Troubleshooting

## Redis Container Not Running

Verify

```bash
docker ps
```

---

Restart

```bash
docker compose restart redis
```

---

## Authentication Failed

Verify

```
REDIS_PASSWORD
```

inside

```
.env
```

---

## No Keys Found

```text
KEYS *
```

If empty

Generate OTP

or

Trigger failed login

Redis stores temporary data only.

---

## Connection Refused

Verify

```bash
docker logs redis
```

---

## Port Conflict

Windows

```bash
netstat -ano | findstr :6379
```

Linux

```bash
sudo lsof -i :6379
```

---

# Best Practices

✔ Never use `KEYS *` in production environments with large datasets. Prefer the `SCAN` command for incremental key iteration.

✔ Keep Redis focused on temporary security data unless the architecture is intentionally expanded.

✔ Allow Redis to manage expiration through TTL rather than manually deleting keys wherever possible.

✔ Store only transient, non-sensitive data in Redis. Permanent business records belong in MySQL.

✔ Monitor memory usage if new Redis features are introduced.

---

# Verification Checklist

Before proceeding ensure

- [ ] Redis container running
- [ ] Authentication successful
- [ ] PING returns PONG
- [ ] OTP keys created correctly
- [ ] Login attempt keys increment correctly
- [ ] TTL working
- [ ] Expired keys removed automatically
- [ ] Redis password loaded from `.env`
- [ ] No hardcoded secrets
- [ ] Application communicates successfully with Redis

---

# Developer Notes

Redis is a critical part of the authentication flow.

Before modifying Redis-related code, understand:

- Which service creates the key.
- Which service reads the key.
- Who deletes the key.
- What TTL is configured.
- Whether the data is security-sensitive.
- Whether MySQL also stores related information.

Always verify that changes keep Redis and MySQL in sync where required (for example, account lock state).

---

⬆️ **Back to:** [Table of Contents](#-table-of-contents)

➡️ **Next Section:** Spring Cloud Config Server Setup

---
---

# ☁️ Spring Cloud Config Server Setup

## Overview

The Config Server is the central configuration management service for the entire microservices platform.

Instead of storing application properties separately inside each service, configuration is centralized and managed from one location.

This approach ensures consistency across environments and simplifies configuration updates.

---

# Why Config Server?

Without a centralized configuration service:

- Every microservice maintains its own configuration.
- Configuration values become duplicated.
- Environment changes require updates in multiple places.
- Configuration drift becomes common.

The Config Server solves these problems by acting as a single source of truth for application configuration.

---

# Responsibilities

The Config Server is responsible for:

- Centralized configuration management
- Environment-specific properties
- Shared application configuration
- Service startup configuration
- Spring Cloud configuration distribution

---

# Technology Stack

| Component | Value |
|-----------|-------|
| Framework | Spring Cloud Config Server |
| Discovery | Eureka Client |
| Port | 8888 |
| Configuration Source | Local File System |
| Environment | Docker |

---

# Service Information

| Property | Value |
|----------|-------|
| Service Name | config-server |
| Port | 8888 |
| Docker Container | config-server |
| Discovery | Registered with Eureka |

---

# Startup Sequence

The Config Server starts immediately after

```
MySQL

↓

Redis
```

and before every business service.

```
MySQL

↓

Redis

↓

Config Server

↓

Eureka Server

↓

Notification Service

↓

Security Service

↓

API Gateway
```

No service should start before the Config Server becomes healthy.

---

# Project Structure

Example

```text
config-server

├── src
│
├── resources
│   ├── application.yml
│   ├── configs
│   │     security-service.yml
│   │     api-gateway.yml
│   │     notification-service.yml
│   │
│   └── bootstrap.yml
│
└── Dockerfile
```

---

# Configuration Flow

```
Application Startup

        │

        ▼

Spring Boot

        │

        ▼

Config Client

        │

        ▼

Config Server

        │

        ▼

Configuration Files

        │

        ▼

Application Context

        │

        ▼

Application Starts
```

---

# Verify Config Server Container

```bash
docker ps
```

Expected

```
config-server
```

---

View Logs

```bash
docker logs config-server
```

or

```bash
docker compose logs config-server
```

Expected

```
Started ConfigServerApplication
```

---

# Verify Health

Open browser

```
http://localhost:8888/actuator/health
```

Expected

```json
{
  "status": "UP"
}
```

---

# Verify Service Registration

Open

```
http://localhost:8761
```

Expected

```
CONFIG-SERVER
```

should appear as

```
UP
```

---

# Verify Configuration

Open

```
http://localhost:8888/security-service/default
```

Example Response

```json
{
   "name":"security-service",
   "profiles":["default"],
   "propertySources":[]
}
```

---

# Configuration Loading Process

Every microservice performs the following steps during startup.

```
Start Service

       │

       ▼

Locate Config Server

       │

       ▼

Download Configuration

       │

       ▼

Load Spring Environment

       │

       ▼

Register With Eureka

       │

       ▼

Application Ready
```

---

# Configuration Files

The Config Server manages properties such as:

- Database configuration
- Redis configuration
- JWT configuration
- Internal API keys
- Logging
- Eureka configuration
- Gateway routes
- Mail configuration
- Spring Security configuration

---

# Common Configuration Examples

Database

```properties
spring.datasource.url=...
```

Redis

```properties
spring.data.redis.host=...
```

JWT

```properties
jwt.secret=...
```

Logging

```properties
logging.level.root=INFO
```

---

# Configuration Best Practices

✔ Keep shared configuration inside the Config Server.

✔ Never duplicate configuration across services.

✔ Use environment variables for sensitive values.

✔ Never commit production secrets.

✔ Separate development and production configurations.

---

# Refresh Configuration

If Spring Cloud Bus is introduced in the future, services can refresh configuration without restarting.

Current development workflow:

1. Update configuration.
2. Restart affected service.
3. Verify changes.

---

# Troubleshooting

## Config Server Not Starting

Check logs

```bash
docker compose logs config-server
```

---

## Configuration Not Loaded

Verify

```
application.yml
```

Check

```
spring.config.import
```

Verify connection to Config Server.

---

## Service Waiting Forever

Usually indicates

- Config Server unavailable
- Wrong URL
- Incorrect Docker network
- Startup order problem

---

## Health Check Failed

Verify

```
http://localhost:8888/actuator/health
```

---

## Eureka Registration Failed

Verify

```
http://localhost:8761
```

Confirm Config Server appears as

```
UP
```

---

# Verification Checklist

Before continuing verify

- [ ] Config Server container running
- [ ] Health endpoint returns UP
- [ ] Registered with Eureka
- [ ] Configuration loads successfully
- [ ] No startup exceptions
- [ ] All dependent services connect successfully

---

# Developer Notes

Do not hardcode configuration values inside services if they belong in the centralized configuration.

Whenever adding a new configurable feature:

- Determine whether it should be centralized.
- Add appropriate configuration keys.
- Document default values.
- Validate required properties during startup.
- Keep sensitive values externalized.

---

⬆️ **Back to:** [Table of Contents](#-table-of-contents)

➡️ **Next Section:** Eureka Service Discovery Setup

---
---

# 🔍 Eureka Service Discovery Setup

## Overview

Eureka Server acts as the **Service Registry** for the entire microservices platform.

Instead of hardcoding service URLs, every microservice registers itself with Eureka during startup.

Other services discover and communicate with each other dynamically through Eureka.

This enables:

- Dynamic Service Discovery
- Load Balancing
- High Availability
- Reduced Configuration
- Easy Horizontal Scaling

---

# Why Eureka?

Without Service Discovery

```
API Gateway

↓

http://192.168.1.120:8181

↓

Security Service
```

Problems

- IP Address Changes
- Port Changes
- Scaling Issues
- Manual Configuration
- Difficult Maintenance

---

With Eureka

```
API Gateway

↓

lb://SECURITY-SERVICE

↓

Eureka Server

↓

Security Service Instance
```

No hardcoded IP addresses are required.

---

# Responsibilities

Eureka Server provides

- Service Registration
- Service Discovery
- Service Health Monitoring
- Load Balancing Support
- Dynamic Service Lookup

---

# Technology Stack

| Component | Value |
|------------|--------|
| Framework | Spring Cloud Netflix Eureka |
| Port | 8761 |
| Service Name | EUREKA-SERVER |
| Discovery | Registry |
| Docker Container | eureka-server |

---

# Startup Order

```
MySQL

↓

Redis

↓

Config Server

↓

Eureka Server

↓

Notification Service

↓

Security Service

↓

API Gateway
```

Every application waits until Eureka becomes healthy.

---

# Architecture

```
                 Eureka Server
                    (8761)

        ┌────────────┼─────────────┐

        ▼            ▼             ▼

Security Service  Notification  API Gateway
                  Service
```

Every application registers itself.

---

# Service Registration Flow

```
Application Starts

        │

        ▼

Loads Configuration

        │

        ▼

Connects to Eureka

        │

        ▼

Registers Service

        │

        ▼

Heartbeat Every 30 Seconds

        │

        ▼

Service Available
```

---

# Verify Eureka Container

```bash
docker ps
```

Expected

```
eureka-server
```

---

# View Logs

```bash
docker logs eureka-server
```

or

```bash
docker compose logs eureka-server
```

Expected

```
Started EurekaServerApplication
```

---

# Open Eureka Dashboard

```
http://localhost:8761
```

You should see

```
Spring Eureka Dashboard
```

---

# Expected Registered Services

```
CONFIG-SERVER

EUREKA-SERVER

NOTIFICATION-SERVICE

SECURITY-SERVICE

API-GATEWAY
```

Every service should display

```
UP
```

Status.

---

# Verify Registration

Click

```
SECURITY-SERVICE
```

Example

```
Status

UP
```

```
Instance

security-service:8181
```

---

# Verify Notification Service

```
NOTIFICATION-SERVICE

↓

Status

UP
```

---

# Verify Gateway

```
API-GATEWAY

↓

UP
```

---

# Heartbeat Mechanism

Every registered service periodically sends a heartbeat.

```
Service

↓

Heartbeat

↓

Eureka

↓

Service Alive
```

If heartbeats stop

```
Service

↓

Marked Down

↓

Removed
```

---

# Service Discovery Flow

```
Client Request

↓

API Gateway

↓

Eureka Lookup

↓

Security Service

↓

Response
```

The Gateway never needs to know the physical IP.

---

# API Gateway Route

Instead of

```
http://localhost:8181
```

Gateway uses

```
lb://SECURITY-SERVICE
```

The

```
lb://
```

prefix enables Spring Cloud LoadBalancer.

---

# Verify Gateway Routing

Open

```
http://localhost:8085
```

Call any API.

Gateway automatically routes requests to

```
SECURITY-SERVICE
```

through Eureka.

---

# Eureka Dashboard Information

Dashboard displays

- Registered Services
- Service Status
- Number of Instances
- Last Heartbeat
- Instance Information
- Availability

---

# Common Configuration

Example

```properties
eureka.client.service-url.defaultZone=http://eureka-server:8761/eureka/
```

Service Name

```properties
spring.application.name=security-service
```

---

# Troubleshooting

## Service Not Registered

Check

```bash
docker compose logs security-service
```

Verify

```
Registered with Eureka
```

---

## Eureka Dashboard Empty

Verify

```
http://localhost:8761
```

Check

```bash
docker ps
```

---

## Registration Failed

Possible Causes

- Config Server unavailable
- Wrong Eureka URL
- Docker network issue
- Startup dependency failure

---

## Service Down

If dashboard shows

```
DOWN
```

Check

```bash
docker compose logs
```

Verify service started successfully.

---

## Gateway Cannot Find Service

Verify

```
SECURITY-SERVICE
```

appears in Eureka.

Verify Gateway route

```
lb://SECURITY-SERVICE
```

---

# Best Practices

✔ Never hardcode service IP addresses.

✔ Always communicate using service names.

✔ Register every microservice with Eureka.

✔ Keep health endpoints enabled.

✔ Verify registration before debugging inter-service communication.

✔ Use Spring Cloud LoadBalancer with `lb://` routes.

---

# Verification Checklist

Before continuing verify

- [ ] Eureka Server container running
- [ ] Dashboard accessible
- [ ] Config Server registered
- [ ] Notification Service registered
- [ ] Security Service registered
- [ ] API Gateway registered
- [ ] All services show UP
- [ ] Gateway routes requests successfully
- [ ] No registration errors in logs

---

# Developer Notes

Whenever a new microservice is added to the platform:

1. Configure a unique `spring.application.name`.
2. Enable Eureka Client.
3. Configure the correct Eureka URL.
4. Expose a health endpoint.
5. Verify successful registration in the dashboard.
6. Update Gateway routes if external access is required.
7. Document the new service in the architecture guide.

Following these steps ensures every service participates correctly in the platform's service discovery mechanism.

---

⬆️ **Back to:** [Table of Contents](#-table-of-contents)

➡️ **Next Section:** 🔐 Spring Security Service (Authentication & Authorization)

---
---

# 🔐 Security Service (Authentication & Authorization)

## Overview

The Security Service is the core business service of this platform.

It is responsible for authenticating users, authorizing access to protected resources, managing user accounts, handling OTP verification, generating JWT tokens, enforcing role-based access control, recording audit events, and coordinating with other services.

Every external client request that requires authentication ultimately passes through this service.

---

# Responsibilities

The Security Service manages the following features:

- User Registration
- User Login
- JWT Authentication
- Refresh Token Management
- Logout
- Password Encryption
- Role-Based Access Control (RBAC)
- Permission Management
- OTP Generation
- OTP Verification
- Forgot Password
- Password Reset
- Account Lock Protection
- Failed Login Tracking
- Audit Logging
- User Profile Management
- Admin Operations
- Internal Service Communication
- API Security
- Global Exception Handling

---

# Service Information

| Property | Value |
|----------|-------|
| Service Name | SECURITY-SERVICE |
| Port | 8181 |
| Framework | Spring Boot |
| Java Version | 21 |
| Authentication | JWT |
| Database | MySQL |
| Cache | Redis |
| Documentation | Swagger/OpenAPI |

---

# Architecture

```
                Client

                  │

                  ▼

             API Gateway

                  │

                  ▼

          Security Service

      ┌──────────┼─────────────┐

      ▼          ▼             ▼

   MySQL      Redis     Notification Service
```

---

# Core Modules

```
Authentication

↓

Authorization

↓

OTP Verification

↓

JWT Management

↓

Refresh Tokens

↓

RBAC

↓

Audit Logging

↓

Admin Management
```

---

# Security Layers

```
HTTP Request

↓

Spring Security Filter Chain

↓

JWT Authentication Filter

↓

Token Validation

↓

User Authentication

↓

Role Validation

↓

Permission Validation

↓

Controller

↓

Business Logic

↓

Database
```

---

# Authentication Workflow

```
User Login

↓

Validate Credentials

↓

Load User

↓

Verify Password

↓

Generate JWT

↓

Generate Refresh Token

↓

Store Refresh Token

↓

Return Response
```

---

# Registration Workflow

```
User Registration

↓

Validate Input

↓

Email Available?

↓

Encrypt Password

↓

Generate OTP

↓

Store OTP (Redis)

↓

Send Email

↓

OTP Verification

↓

Activate Account

↓

Persist User
```

---

# Password Encryption

Passwords are never stored in plain text.

The application uses

```
BCrypt Password Encoder
```

Example

```
Raw Password

↓

BCrypt

↓

Encrypted Password
```

---

# JWT Workflow

```
User Login

↓

Generate Access Token

↓

Generate Refresh Token

↓

Return Tokens

↓

Client Stores Tokens

↓

Protected API

↓

JWT Validation

↓

Access Granted
```

---

# Refresh Token Workflow

```
Expired JWT

↓

Client Sends Refresh Token

↓

Validate Refresh Token

↓

Generate New JWT

↓

Return New Access Token
```

---

# Role-Based Access Control

Roles

```
SUPER_ADMIN

ADMIN

USER
```

Permissions

```
CREATE_USER

UPDATE_USER

DELETE_USER

VIEW_USERS

MANAGE_ROLES

MANAGE_PERMISSIONS
```

Authorization Flow

```
JWT

↓

Extract Roles

↓

Extract Permissions

↓

Authorization Decision
```

---

# OTP Flow

```
Generate OTP

↓

Store Redis

↓

5 Minute TTL

↓

Send Email

↓

Verify OTP

↓

Delete Redis Key
```

---

# Failed Login Protection

```
Wrong Password

↓

Increment Redis Counter

↓

Maximum Attempts Reached?

↓

Yes

↓

Lock Account

↓

Save Database
```

---

# Account Unlock

Admin

↓

Unlock User

↓

Reset Database Counter

↓

Reset Redis Counter

↓

Allow Login Again

---

# Internal Service Communication

The Security Service communicates with the Notification Service using

```
Spring WebClient
```

Authentication

```
X-Internal-Api-Key
```

Validation

```
MessageDigest.isEqual()
```

This prevents timing attacks during API key comparison.

---

# Database Usage

Main tables

```
users

roles

permissions

user_roles

role_permissions

audit_logs

user_tokens

notifications
```

---

# Redis Usage

Redis stores

```
OTP

↓

Login Attempt Counters
```

No business-critical data is permanently stored in Redis.

---

# Swagger Documentation

Open

```
http://localhost:8181/swagger-ui.html
```

Verify

- Authentication APIs
- User APIs
- Admin APIs
- Role APIs
- Permission APIs
- OTP APIs

---

# Health Check

```
http://localhost:8181/actuator/health
```

Expected

```json
{
  "status":"UP"
}
```

---

# Verify Service Registration

Open Eureka Dashboard

```
http://localhost:8761
```

Verify

```
SECURITY-SERVICE

↓

UP
```

---

# Logs

View Logs

```bash
docker compose logs security-service
```

Live Logs

```bash
docker compose logs -f security-service
```

Search Errors

```bash
docker compose logs security-service | grep ERROR
```

Windows PowerShell

```powershell
docker compose logs security-service | Select-String ERROR
```

---

# Restart Service

```bash
docker compose restart security-service
```

---

# Build Service

```bash
docker compose build security-service
```

---

# Rebuild Service

```bash
docker compose up --build security-service
```

---

# Common Issues

## Invalid JWT

Verify

- JWT Secret
- Token Expiration
- Authorization Header

---

## Login Fails

Check

- User Exists
- Password
- Account Locked
- Redis Counter
- Database Status

---

## OTP Not Received

Verify

- Notification Service Running
- SendGrid Configuration
- Redis Key Exists
- Email Address

---

## Account Locked

Check

Redis

```
login:attempts:<username>
```

Database

```
account_locked=true
```

---

## Unauthorized (401)

Verify

```
Authorization

Bearer <JWT>
```

Header present.

---

## Forbidden (403)

Verify

- User Role
- Assigned Permissions
- Endpoint Security Configuration

---

# Best Practices

✔ Never disable Spring Security for testing.

✔ Never hardcode JWT secrets.

✔ Always validate JWT before accessing protected resources.

✔ Use BCrypt for all password storage.

✔ Keep authentication logic inside the Security Service.

✔ Never bypass service-layer authorization checks.

✔ Record security-sensitive operations in the audit log.

✔ Validate all input before processing.

---

# Verification Checklist

Before proceeding verify

- [ ] Security Service container running
- [ ] Registered with Eureka
- [ ] Health endpoint returns UP
- [ ] Swagger accessible
- [ ] User registration successful
- [ ] Login successful
- [ ] JWT generated
- [ ] Refresh token generated
- [ ] OTP workflow functional
- [ ] Redis integration working
- [ ] MySQL persistence working
- [ ] RBAC enforced correctly
- [ ] Audit logs recorded
- [ ] Internal API communication successful

---

# Developer Notes

The Security Service is the heart of the platform.

Before modifying authentication or authorization logic:

1. Understand the complete authentication flow.
2. Review the Spring Security filter chain.
3. Verify JWT validation behavior.
4. Understand Redis usage for OTP and login attempts.
5. Ensure MySQL and Redis remain consistent.
6. Add or update automated tests.
7. Validate backward compatibility.
8. Update documentation if authentication behavior changes.

Changes in this service can impact every authenticated request across the platform, so modifications should be thoroughly reviewed and tested.

---

⬆️ **Back to:** [Table of Contents](#-table-of-contents)

➡️ **Next Section:** 📧 Notification Service (Email Delivery & Internal Communication)

---
---

# 📧 Notification Service (Email Delivery & Internal Communication)

## Overview

The Notification Service is a dedicated microservice responsible for sending all outbound email notifications generated by the platform.

Instead of allowing every service to communicate directly with third-party email providers, all email requests are routed through this centralized service.

This design follows the **Single Responsibility Principle (SRP)** and keeps email delivery isolated from the core business logic.

The Security Service never communicates directly with SendGrid. It always sends an internal request to the Notification Service, which validates the request and forwards it to SendGrid.

---

# Responsibilities

The Notification Service is responsible for:

- OTP Email Delivery
- Welcome Email Delivery
- Password Reset Email
- Account Unlock Notifications
- Account Lock Notifications
- Email Delivery Tracking
- Internal API Authentication
- Email Template Management
- Error Handling
- Retry Logic (Future Enhancement)
- Audit Logging (Optional)

---

# Service Information

| Property | Value |
|-----------|--------|
| Service Name | NOTIFICATION-SERVICE |
| Port | 8182 |
| Framework | Spring Boot |
| Java Version | 21 |
| Email Provider | SendGrid |
| Communication | REST API |
| Authentication | X-Internal-Api-Key |

---

# High-Level Architecture

```
               Client

                  │

                  ▼

          Security Service

                  │

      Internal REST Request

                  │

                  ▼

        Notification Service

                  │

                  ▼

             SendGrid API

                  │

                  ▼

             Recipient Email
```

Only trusted internal services may communicate with the Notification Service.

---

# Email Flow

```
User Registers

↓

Security Service

↓

Generate OTP

↓

Store OTP in Redis

↓

Call Notification Service

↓

Validate Internal API Key

↓

Generate Email

↓

SendGrid

↓

Recipient Inbox
```

---

# Password Reset Flow

```
Forgot Password

↓

Generate OTP

↓

Store OTP

↓

Notification Service

↓

SendGrid

↓

User Receives OTP
```

---

# Internal Authentication

The Notification Service does **NOT** accept public requests.

Every internal request must include

```
X-Internal-Api-Key
```

Example

```
POST /api/internal/send-email

Headers

X-Internal-Api-Key: ************
```

The request is validated before any email is processed.

---

# Secure API Key Validation

API Keys are compared using

```java
MessageDigest.isEqual()
```

instead of

```java
String.equals()
```

This prevents timing attacks.

---

# SendGrid Integration

Email delivery is handled through

```
SendGrid REST API
```

Configuration is loaded from

```
.env
```

Required variables

```
SENDGRID_API_KEY

SENDGRID_SENDER_MAIL

SENDGRID_SENDER_NAME
```

---

# Email Types

The Notification Service currently supports

- Registration OTP
- Login OTP
- Password Reset OTP
- Account Unlock Notification
- Welcome Email

Future enhancements may include

- Email Verification
- Security Alerts
- Password Change Confirmation
- Account Activity Notifications

---

# Email Request Flow

```
Receive Request

↓

Validate API Key

↓

Validate Payload

↓

Build Email

↓

Call SendGrid

↓

Receive Response

↓

Return Status
```

---

# Docker Information

Container

```
notification-service
```

Port

```
8182
```

---

# Verify Container

```bash
docker ps
```

Expected

```
notification-service
```

---

# View Logs

```bash
docker compose logs notification-service
```

Live logs

```bash
docker compose logs -f notification-service
```

---

# Restart Service

```bash
docker compose restart notification-service
```

---

# Build Service

```bash
docker compose build notification-service
```

---

# Health Check

Open

```
http://localhost:8182/actuator/health
```

Expected

```json
{
    "status":"UP"
}
```

---

# Verify Eureka Registration

Open

```
http://localhost:8761
```

Verify

```
NOTIFICATION-SERVICE

↓

UP
```

---

# Verify Email Sending

Perform

```
User Registration
```

Expected

```
Generate OTP

↓

Redis Stores OTP

↓

Notification Service Called

↓

SendGrid Request

↓

Email Delivered
```

---

# Common Log Messages

Successful Startup

```
Started NotificationServiceApplication
```

Email Sent

```
Email successfully delivered
```

Failed Delivery

```
Failed to send email
```

Authentication Failure

```
Invalid Internal API Key
```

---

# Common Issues

## Email Not Received

Verify

- SendGrid API Key
- Internet Connection
- Sender Email
- Recipient Email
- Notification Service Logs

---

## Invalid API Key

Check

```
INTERNAL_API_KEY
```

inside

```
.env
```

Verify both services use the same key.

---

## SendGrid Authentication Failed

Verify

```
SENDGRID_API_KEY
```

is valid.

Generate a new key if required.

---

## Notification Service Not Registered

Verify

```
http://localhost:8761
```

Service should appear

```
UP
```

---

## Internal API Failure

Verify

- Security Service Running
- Notification Service Running
- Docker Network
- Config Server
- Eureka Registration

---

# Security Best Practices

✔ Never expose Notification APIs publicly.

✔ Always validate the Internal API Key.

✔ Never log API keys.

✔ Never expose SendGrid credentials.

✔ Validate email payloads before processing.

✔ Handle delivery failures gracefully.

✔ Keep email templates centralized.

✔ Log delivery status without exposing sensitive information.

---

# Developer Workflow

When adding a new email notification

1. Create Email Template.
2. Create Request DTO.
3. Create Response DTO.
4. Add Service Method.
5. Add Controller Endpoint.
6. Validate Internal API Key.
7. Test with SendGrid Sandbox.
8. Verify Delivery.
9. Update Documentation.

---

# Verification Checklist

Before continuing verify

- [ ] Notification Service container running
- [ ] Registered with Eureka
- [ ] Health endpoint returns UP
- [ ] Internal API authentication working
- [ ] SendGrid configuration loaded
- [ ] OTP emails delivered
- [ ] Password reset emails delivered
- [ ] No authentication failures
- [ ] No email delivery exceptions
- [ ] Logs contain no startup errors

---

# Future Enhancements

Potential improvements

- HTML Email Templates
- Template Engine (Thymeleaf/Freemarker)
- Asynchronous Email Queue (Kafka/RabbitMQ)
- Retry Mechanism
- Dead Letter Queue (DLQ)
- Delivery Metrics
- Email Rate Limiting
- Attachment Support
- Multi-provider Support (SES, Mailgun, SMTP)

---

# Developer Notes

The Notification Service should remain focused solely on email delivery and related concerns.

Avoid introducing unrelated business logic into this service. Authentication, authorization, user management, and domain-specific workflows should remain within the appropriate business services, while the Notification Service continues to act as a reusable infrastructure component for outbound communications.

---

⬆️ **Back to:** [Table of Contents](#-table-of-contents)

➡️ **Next Section:** 🌐 API Gateway (Routing, Filters & Request Flow)

---

---

# 🌐 API Gateway (Routing, Filtering & Request Flow)

## Overview

The API Gateway is the single entry point for all external client requests.

Clients never communicate directly with individual microservices. Instead, every request is routed through the API Gateway, which is responsible for request forwarding, authentication, routing, and cross-cutting concerns.

This architecture improves security, maintainability, scalability, and observability by centralizing request handling.

---

# Responsibilities

The API Gateway is responsible for:

- Single Entry Point for Clients
- Dynamic Service Routing
- Service Discovery Integration
- JWT Validation (if configured)
- Request Forwarding
- Response Routing
- Centralized Logging
- Request Filtering
- Cross-Origin Resource Sharing (CORS)
- Circuit Breaker Integration
- Load Balancing
- Request Monitoring
- Error Handling

---

# Service Information

| Property | Value |
|-----------|--------|
| Service Name | API-GATEWAY |
| Port | 8085 |
| Framework | Spring Cloud Gateway |
| Discovery | Eureka |
| Routing | Dynamic |
| Load Balancer | Spring Cloud LoadBalancer |

---

# High-Level Architecture

```
                     Client

                        │

                        ▼

                 API Gateway (8085)

                        │

        ┌───────────────┼────────────────┐

        ▼                                ▼

 Security Service              Notification Service

        │                                │

        ▼                                ▼

     MySQL                           SendGrid
```

---

# Why API Gateway?

Without Gateway

```
Client

↓

Security Service

↓

Notification Service

↓

Another Service
```

The client must know every service URL.

Problems

- Multiple Endpoints
- Hardcoded URLs
- Security Challenges
- Difficult Versioning
- Tight Coupling

---

With Gateway

```
Client

↓

API Gateway

↓

Microservices
```

The client only communicates with one endpoint.

---

# Request Lifecycle

```
Incoming Request

↓

Gateway

↓

Filter Chain

↓

Authentication

↓

Service Discovery

↓

Load Balancer

↓

Target Service

↓

Business Logic

↓

Response

↓

Gateway

↓

Client
```

---

# Route Discovery

The Gateway does not use hardcoded service URLs.

Instead it queries Eureka.

Example

```
lb://SECURITY-SERVICE
```

Spring Cloud automatically resolves

```
SECURITY-SERVICE

↓

Available Instance

↓

Forward Request
```

---

# Route Configuration

Typical Route

```
Client

↓

/api/auth/**

↓

Security Service
```

Another Example

```
/api/notifications/**

↓

Notification Service
```

---

# Gateway Components

```
Gateway

│

├── Route Locator

├── Global Filters

├── Gateway Filters

├── Load Balancer

├── Service Discovery

├── Error Handler

└── Circuit Breaker
```

---

# Request Flow

```
HTTP Request

↓

Gateway

↓

Global Filter

↓

Authentication Filter

↓

Logging Filter

↓

Route Matching

↓

Eureka Lookup

↓

Load Balancer

↓

Target Service
```

---

# Service Discovery Flow

```
Gateway

↓

Eureka

↓

SECURITY-SERVICE

↓

Available Instance

↓

Forward Request
```

---

# Load Balancing

Gateway routes requests using

```
Spring Cloud LoadBalancer
```

Example

```
Gateway

↓

Instance 1

↓

Instance 2

↓

Instance 3
```

Requests are distributed automatically.

---

# Circuit Breaker

If downstream services become unavailable

```
Gateway

↓

Circuit Breaker

↓

Fallback Response
```

Benefits

- Improved Resilience
- Better User Experience
- Prevent Cascading Failures

---

# CORS

Gateway centrally manages

```
Cross-Origin Resource Sharing
```

Benefits

- Single Configuration
- Better Security
- Easier Frontend Integration

---

# JWT Flow

```
Client

↓

Authorization Header

↓

Gateway

↓

Forward Request

↓

Security Service

↓

JWT Validation

↓

Protected Resource
```

Depending on architecture, JWT validation may happen in the Gateway, the Security Service, or both.

---

# Verify Gateway Container

```bash
docker ps
```

Expected

```
api-gateway
```

---

# View Logs

```bash
docker compose logs api-gateway
```

Live Logs

```bash
docker compose logs -f api-gateway
```

---

# Restart Gateway

```bash
docker compose restart api-gateway
```

---

# Build Gateway

```bash
docker compose build api-gateway
```

---

# Health Check

Open

```
http://localhost:8085/actuator/health
```

Expected

```json
{
  "status":"UP"
}
```

---

# Verify Eureka Registration

Open

```
http://localhost:8761
```

Verify

```
API-GATEWAY

↓

UP
```

---

# Verify Routing

Example

```
GET

http://localhost:8085/api/auth/login
```

Expected Flow

```
Gateway

↓

Security Service

↓

Response
```

---

# Verify Swagger

Depending on configuration

```
http://localhost:8085/swagger-ui.html
```

or access individual service Swagger endpoints.

---

# Logging

Gateway logs typically include

- Incoming Request
- Route Matched
- Target Service
- Response Status
- Execution Time
- Error Details

---

# Common Issues

## Route Not Found (404)

Verify

- Route Configuration
- Service Name
- Request Path
- Gateway Startup Logs

---

## Service Unavailable (503)

Possible causes

- Target service down
- Eureka registration missing
- Circuit breaker open

Verify

```
http://localhost:8761
```

---

## Gateway Not Starting

Check

```bash
docker compose logs api-gateway
```

Look for

- Configuration errors
- Eureka connection issues
- Config Server issues

---

## Authentication Failure

Verify

```
Authorization

Bearer <JWT>
```

header is present if required.

---

## Gateway Cannot Reach Service

Verify

- Service registered in Eureka
- Service health is UP
- Docker network connectivity
- Correct route configuration

---

# Best Practices

✔ Keep business logic out of the Gateway.

✔ Use the Gateway only for cross-cutting concerns.

✔ Route requests using service names (`lb://SERVICE-NAME`).

✔ Enable centralized logging.

✔ Configure CORS at the Gateway level.

✔ Protect sensitive routes appropriately.

✔ Use resilience patterns such as circuit breakers and retries where appropriate.

---

# Verification Checklist

Before proceeding verify

- [ ] API Gateway container running
- [ ] Registered with Eureka
- [ ] Health endpoint returns UP
- [ ] Routes resolve correctly
- [ ] Requests forwarded successfully
- [ ] Service discovery working
- [ ] Load balancing functioning
- [ ] No startup errors
- [ ] Logs contain no routing exceptions
- [ ] Gateway accessible on port 8085

---

# Developer Notes

The API Gateway should remain lightweight and infrastructure-focused.

When introducing a new microservice:

1. Register the service with Eureka.
2. Define or enable Gateway routing.
3. Verify route resolution.
4. Test end-to-end request flow.
5. Update API documentation if public endpoints change.
6. Validate authentication and authorization behavior.
7. Ensure monitoring and logging capture the new routes.

Avoid placing domain-specific business logic in the Gateway. Its primary responsibility is to manage traffic, routing, and platform-level concerns while delegating business operations to the appropriate backend services.

---

⬆️ **Back to:** [Table of Contents](#-table-of-contents)

➡️ **Next Section:** 🔑 JWT Authentication & Refresh Token Architecture

---
---

# 🔑 JWT Authentication & Refresh Token Architecture

## Overview

JSON Web Token (JWT) is the primary authentication mechanism used by this platform.

After successful authentication, the Security Service generates two tokens:

- Access Token (Short-lived)
- Refresh Token (Long-lived)

The Access Token is used to authorize API requests, while the Refresh Token allows clients to obtain a new Access Token without requiring the user to log in again.

The platform uses **stateless authentication**, meaning user session data is not stored on the server for every request.

---

# Why JWT?

Traditional Session Authentication

```
Client

↓

Server Session

↓

Database / Memory

↓

Every Request
```

Problems

- Session Storage
- Poor Scalability
- Sticky Sessions
- Increased Memory Usage

---

JWT Authentication

```
Client

↓

JWT

↓

Server Validation

↓

Access Granted
```

Benefits

- Stateless
- Scalable
- Fast
- Suitable for Microservices
- No Server Session Storage

---

# Authentication Flow

```
User Login

↓

Validate Credentials

↓

Generate Access Token

↓

Generate Refresh Token

↓

Store Refresh Token

↓

Return Tokens

↓

Client Stores Tokens
```

---

# Token Types

## Access Token

Purpose

- Authenticate API Requests
- Carry User Identity
- Carry Roles & Permissions

Characteristics

- Short Expiration
- Signed
- Self-contained
- Sent with Every Request

---

## Refresh Token

Purpose

- Generate New Access Token

Characteristics

- Longer Expiration
- Stored Securely
- Revocable
- Saved in Database

---

# JWT Architecture

```
User

↓

Login

↓

Security Service

↓

Generate JWT

↓

Return Access Token

↓

Client Stores Token

↓

Protected Request

↓

JWT Validation

↓

Controller

↓

Business Logic
```

---

# JWT Structure

A JWT consists of three parts:

```
Header

.

Payload

.

Signature
```

Example

```
xxxxx.yyyyy.zzzzz
```

---

# Header

Contains metadata.

Example

```json
{
  "alg":"HS256",
  "typ":"JWT"
}
```

---

# Payload

Contains claims.

Example

```json
{
  "sub":"john@example.com",
  "roles":["ADMIN"],
  "permissions":["CREATE_USER"],
  "iat":1710000000,
  "exp":1710003600
}
```

---

# Signature

Created using

```
HS256
```

with

```
JWT_SECRET
```

This prevents token tampering.

---

# Login Flow

```
Username

+

Password

↓

AuthenticationManager

↓

UserDetailsService

↓

Password Validation

↓

Generate JWT

↓

Generate Refresh Token

↓

Return Response
```

---

# Protected API Flow

```
Client

↓

Authorization Header

↓

Bearer Token

↓

JWT Filter

↓

Validate Token

↓

Extract User

↓

Load Authorities

↓

Security Context

↓

Controller
```

---

# Refresh Token Flow

```
Expired Access Token

↓

Client Sends Refresh Token

↓

Validate Refresh Token

↓

Generate New Access Token

↓

Return New Token

↓

Continue Session
```

---

# Logout Flow

```
User Logout

↓

Delete Refresh Token

↓

Client Removes Access Token

↓

Session Ended
```

---

# Token Validation

Every request follows:

```
Receive Token

↓

Extract Header

↓

Verify Signature

↓

Check Expiration

↓

Load User

↓

Validate User

↓

Grant Access
```

---

# Authorization Header

Clients must send

```
Authorization

Bearer <JWT>
```

Example

```
Authorization:
Bearer eyJhbGciOiJIUzI1NiIs...
```

---

# JWT Secret

Configured through

```
.env
```

Example

```
JWT_SECRET
```

Requirements

- Minimum 256-bit key
- Random
- Secure
- Never committed
- Never hardcoded

---

# Token Expiration

Typical Configuration

| Token | Expiration |
|---------|------------|
| Access Token | 15–60 Minutes |
| Refresh Token | Several Days |

The exact values depend on project configuration.

---

# JWT Filter

The Security Filter Chain performs:

```
Extract Header

↓

Bearer Exists?

↓

Parse JWT

↓

Validate Signature

↓

Check Expiration

↓

Load User

↓

Create Authentication

↓

Continue Filter Chain
```

---

# Refresh Token Storage

Unlike Access Tokens,

Refresh Tokens are stored in

```
MySQL
```

Example table

```
user_tokens
```

Benefits

- Revocation
- Rotation
- Logout Support
- Device Management

---

# Token Rotation

Recommended Workflow

```
Refresh Token Used

↓

Validate

↓

Generate New Access Token

↓

Generate New Refresh Token

↓

Invalidate Previous Token
```

This minimizes token reuse attacks.

---

# JWT Security

The platform protects against

- Token Tampering
- Expired Tokens
- Invalid Signature
- Unauthorized Access
- Replay Attempts (through refresh token management)

---

# Verify Login

Open Swagger

```
http://localhost:8181/swagger-ui.html
```

Login

Expected

```
Access Token

Refresh Token
```

returned.

---

# Verify Protected API

Copy

```
Access Token
```

Authorize

```
Bearer <token>
```

Call

```
GET

/api/users/me
```

Expected

```
200 OK
```

---

# Verify Expired Token

Wait until

```
Access Token

↓

Expired
```

Expected

```
401 Unauthorized
```

Refresh using

```
Refresh Token
```

Receive

```
New Access Token
```

---

# Common Issues

## Invalid JWT

Verify

- JWT Secret
- Signature
- Token Integrity

---

## Expired Token

Expected

```
401 Unauthorized
```

Use Refresh Token.

---

## Invalid Refresh Token

Verify

- Exists in Database
- Not Revoked
- Not Expired

---

## Missing Authorization Header

Expected

```
401 Unauthorized
```

---

## Invalid Signature

Possible Causes

- Wrong Secret
- Modified Token
- Different Environment Secret

---

# Best Practices

✔ Use HTTPS in production.

✔ Keep Access Tokens short-lived.

✔ Rotate Refresh Tokens.

✔ Never expose JWT secrets.

✔ Store Refresh Tokens securely.

✔ Validate every incoming token.

✔ Reject malformed tokens.

✔ Log authentication failures.

✔ Never place sensitive data in the JWT payload.

---

# Verification Checklist

Before continuing verify

- [ ] Login generates Access Token
- [ ] Refresh Token generated
- [ ] Protected APIs require JWT
- [ ] Expired JWT rejected
- [ ] Refresh Token works
- [ ] Invalid JWT rejected
- [ ] JWT secret loaded from `.env`
- [ ] No hardcoded secrets
- [ ] Logout invalidates Refresh Token
- [ ] Authorization works correctly

---

# Developer Notes

JWT authentication is one of the most security-critical components of the platform.

Before modifying authentication logic:

1. Understand the complete authentication and authorization flow.
2. Verify changes against existing security requirements.
3. Preserve backward compatibility where appropriate.
4. Ensure Refresh Token lifecycle remains secure.
5. Update automated tests for authentication scenarios.
6. Document any changes to token structure or expiration policies.

Any changes to JWT generation, validation, or refresh workflows should undergo careful review, as they affect every authenticated request in the system.

---

⬆️ **Back to:** [Table of Contents](#-table-of-contents)

➡️ **Next Section:** 👥 Role-Based Access Control (RBAC) & Authorization Architecture

---
