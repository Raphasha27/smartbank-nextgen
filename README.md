# SmartBank NextGen


[![Coverage](https://img.shields.io/badge/Coverage-JaCoCo-blue?style=flat-square&logo=codecov)](https://github.com/Raphasha27/smartbank-nextgen/actions)
[![CI](https://github.com/koketseraphasha/smartbank-nextgen/actions/workflows/ci.yml/badge.svg)](https://github.com/koketseraphasha/smartbank-nextgen/actions/workflows/ci.yml)

Next-generation digital banking platform with AI-powered features. Flagship Java/Spring Boot project for banking portfolios.

## Modules
- Customer Management, Accounts, Transactions, Fraud Detection, Loans, KYC, Notifications, Audit Logs, AI Assistant


## Architecture

```mermaid
graph LR
    CL[Client] --> GW[API Gateway]
    GW --> AUTH[Auth Service]
    GW --> SVC[Banking Service]
    SVC --> DB[(PostgreSQL)]
    SVC --> EVT[Event Bus]
    EVT --> AUD[Audit Log]
    EVT --> FRAUD[Fraud Detection]
```

Microservices-based architecture with API Gateway, authentication layer, PostgreSQL persistence, and event-driven communication.

## Stack
Java 21, Spring Boot, Spring Security, PostgreSQL, Docker, GitHub Actions

## Quick Start
```bash
docker compose up -d
```

## Deployment & Architecture

This project is designed with cloud-ready principles:

- **Containerized** using Docker for consistent deployment
- **Environment-based configuration** — no hardcoded secrets
- **Modular structure** for independent scaling
- **Stateless design** where applicable
- **Separation of concerns** for maintainability

### Run Locally

`ash
docker-compose up --build
`

---

*Part of the Kirov Dynamics Technology portfolio — backend engineering focused on security, scalability, and system design.*
