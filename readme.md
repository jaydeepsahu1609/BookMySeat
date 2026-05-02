# 🎟️ BookMySeat - Scalable Ticket Booking Platform

A full-stack distributed system inspired by modern ticket booking platforms like BookMyShow.  
This project focuses on solving real-world backend challenges such as concurrency, distributed transactions, and high-scale system design.

---

## Objective

The goal is to go beyond a simple clone and build a **production-grade system** while learning:

- Distributed Systems Architecture
- Concurrency Control & Race Conditions
- Distributed Locking (Seat Booking Problem)
- Idempotent APIs (Safe Payments & Bookings)
- Event-Driven Architecture (Kafka)
- High Availability & Fault Tolerance

It also strengthens:
- Spring Boot Microservices
- Database Design
- Frontend Development with React

---

## Tech Stack

### Frontend
- ReactJS

### Backend
- **Language:** Java 17
- **Framework:** Spring Boot (Microservices)
- **Build Tool:** Maven

### Data & Storage
- **Database:** PostgreSQL
- **Cache:** Redis (locking + caching)

### Messaging
- **Apache Kafka** for:
    - Booking events
    - Payment processing
    - Notifications

### Infrastructure
- Docker (PostgreSQL, Redis, Kafka)

### AI Assistants

- **Google Gemini** Agent (IntelliJ Idea Plugin)
- ChatGPT

---

## 📂 Project Structure & Design

```
BookMySeat/
├── backend/
│   ├── api-gateway/
│   ├── auth-service/
│   ├── booking-service/
│   ├── config-server/
│   ├── management-service/
│   ├── payment-service/
│   └── query-service/
├── docs/
├── frontend/
├── infra/
└── readme.md
```

Detailed documentation including:
- HLD (High-Level Design)
- LLD (Low-Level Design)
- Database Schema
- API Contracts

Available in the [`/docs`](./docs) directory

---

## Getting Started

to be added

---