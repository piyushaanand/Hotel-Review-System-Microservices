# 🏨 Hotel Review System - Microservices Architecture

This is a scalable **Hotel Review System** built using **Spring Boot Microservices Architecture**. It allows users to review hotels, view ratings, and manage hotel-related data. The project is structured into multiple services to demonstrate clean separation of concerns, resilience, and scalability.

---

## 🔧 Tech Stack

- Java 17
- Spring Boot
- Spring Cloud
- Spring Data JPA
- Eureka Server (Service Registry)
- API Gateway
- Config Server (Centralized Config)
- PostgreSQL / MySQL (for persistence)
- RESTful APIs
- Lombok, Feign Client, Resilience4j, etc.

---

## 🧩 Microservices Overview

### 1. 👤 User Service
- Manages user data.
- Users can be added, updated, deleted.
- Fetches hotel ratings using **inter-service communication** via FeignClient.

### 2. 🌟 Rating Service
- Handles all hotel ratings by users.
- Each rating links a `userId` to a `hotelId` with a score and comment.
- Exposes APIs to retrieve ratings by user or by hotel.

### 3. 🏨 Hotel Service
- Manages hotel information (name, location, description).
- APIs to create, update, delete, and fetch hotel data.

---

## 🔌 Supporting Services

### 4. 🌐 API Gateway
- Acts as a single entry point for all microservices.
- Routes requests to appropriate services.
- Handles centralized logging, CORS, rate limiting, etc.

### 5. 🧭 Service Registry (Eureka Server)
- Enables **service discovery**.
- Each service registers itself and discovers others dynamically.

### 6. ⚙️ Config Server
- Centralized configuration management for all microservices.
- Externalized `application.yml` configurations stored in a Git repo.

---

## 📁 Folder Structure

Hotel-Review-System-Microservices/
│
├── apigateway/
├── configServer/
├── serviceRegistory/
├── hotelService/
├── ratingService/
├── userService/
└── README.md



---

## 🚀 Getting Started

### ✅ Prerequisites
- JDK 17+
- Maven
- Git
- PostgreSQL / MySQL
- Spring Boot-compatible IDE (IntelliJ / VS Code / Eclipse)

---

### 📦 Steps to Run

1. **Clone the repository**
   ```bash
   git clone https://github.com/piyushaanand/Hotel-Review-System-Microservices.git
   cd Hotel-Review-System-Microservices

