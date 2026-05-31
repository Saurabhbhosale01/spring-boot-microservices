# Spring Boot Microservices E-Commerce Platform

A scalable and production-ready microservices-based e-commerce backend built using Spring Boot and Spring Cloud. The application demonstrates modern distributed system architecture with API Gateway, service communication, centralized security, and independent deployment of business services.

## 🚀 Project Overview

This project follows the Microservices Architecture pattern, where each business capability is developed and deployed independently.

The system consists of:

* Product Service
* Order Service
* Inventory Service
* API Gateway

The architecture is designed to improve scalability, maintainability, fault isolation, and independent service deployment.

---

## 🏗️ Architecture

```text
Client
   │
   ▼
API Gateway
   │
   ├── Product Service
   │
   ├── Order Service
   │
   └── Inventory Service
```

### Request Flow

1. Client sends a request to the API Gateway.
2. API Gateway routes the request to the appropriate service.
3. Order Service validates product availability through Inventory Service.
4. If stock is available, the order is placed successfully.
5. Response is returned through the API Gateway.

---

## 📦 Microservices

### Product Service

Responsible for product management.

#### Features

* Create Product
* Update Product
* Delete Product
* View Product Details
* Product Catalog Management

#### Technologies

* Spring Boot
* Spring Data JPA
* PostgreSQL

---

### Order Service

Responsible for order processing.

#### Features

* Place Order
* Validate Product Availability
* Manage Order Information
* Generate Order Records

#### Technologies

* Spring Boot
* REST Client Communication
* PostgreSQL

---

### Inventory Service

Responsible for inventory management.

#### Features

* Maintain Product Stock
* Check Product Availability
* Update Inventory Quantities
* Support Real-Time Stock Validation

#### Technologies

* Spring Boot
* Spring Data JPA
* PostgreSQL

---

### API Gateway

Single entry point for all client requests.

#### Features

* Request Routing
* Centralized Security
* Load Balancing Support
* Service Abstraction
* Cross-Cutting Concerns Management

#### Technologies

* Spring Cloud Gateway MVC
* Spring Boot

---

## 🔐 Security

Authentication and Authorization are implemented using Keycloak.

### Features

* User Authentication
* Role-Based Access Control (RBAC)
* Token-Based Security
* OAuth2 & OpenID Connect

---

## 🛠️ Tech Stack

### Backend

* Java 21
* Spring Boot
* Spring Cloud Gateway MVC
* Spring Data JPA
* Hibernate

### Database

* PostgreSQL

### Security

* Keycloak
* OAuth2
* JWT Authentication

### Development Tools

* IntelliJ IDEA / Eclipse
* Maven
* DBeaver
* Git & GitHub
* Postman

### Frontend (Planned / Integration)

* Angular 18

---

## ✨ Key Features

* Microservices Architecture
* API Gateway Pattern
* Centralized Authentication
* JWT Security
* RESTful APIs
* Service Isolation
* Independent Deployment
* Database Per Service Pattern
* Scalable Design

---

## 📈 Learning Outcomes

This project helped in understanding:

* Microservices Architecture
* Service-to-Service Communication
* API Gateway Implementation
* Distributed System Design
* Authentication using Keycloak
* JWT Security
* Database Design
* Spring Boot Best Practices
* Production-Ready Backend Development

---

## 🔮 Future Enhancements

* Service Discovery using Eureka
* Distributed Tracing
* Centralized Logging
* Circuit Breaker using Resilience4j
* Docker Containerization
* Kubernetes Deployment
* Kafka Event-Driven Communication
* CI/CD Pipeline Integration

---

## 👨‍💻 Author

Saurabh Bhosale

Backend Developer | Java | Spring Boot | Microservices | SQL

If you found this project useful, feel free to star the repository and connect with me on LinkedIn.
