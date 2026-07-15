
![GitHub last commit](https://img.shields.io/github/last-commit/Ummehani18/lead_management_API?style=for-the-badge)
# Lead Management System API


![Java](https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.5-brightgreen?style=for-the-badge&logo=springboot)
![Spring Security](https://img.shields.io/badge/Spring_Security-JWT-success?style=for-the-badge&logo=springsecurity)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-17-blue?style=for-the-badge&logo=postgresql)
![Maven](https://img.shields.io/badge/Maven-Build-red?style=for-the-badge&logo=apachemaven)
![Status](https://img.shields.io/badge/Status-In_Development-yellow?style=for-the-badge)
![License](https://img.shields.io/badge/License-MIT-purple?style=for-the-badge)


A RESTful backend application built with Spring Boot for managing customer leads. The project demonstrates secure authentication, role-based authorization, CRUD operations, search, pagination, validation, exception handling, API documentation, and containerized deployment using Docker.

---

## Features

- JWT Authentication
- Role-Based Authorization (ADMIN & MEMBER)
- Lead CRUD Operations
- Search Leads by Name or Phone
- Pagination Support
- Bean Validation
- Global Exception Handling
- Swagger/OpenAPI Documentation
- Docker & Docker Compose
- Environment Variable Configuration
- PostgreSQL Integration

---

## Tech Stack

### Backend
- Java 17
- Spring Boot 3

### Security
- Spring Security
- JWT

### Database
- PostgreSQL
- Spring Data JPA
- Hibernate

### Documentation
- Swagger / OpenAPI

### Build Tool
- Maven

### Containerization
- Docker
- Docker Compose

---

## Architecture

```text
Client
   │
   ▼
Controller
   │
   ▼
Service
   │
   ▼
Repository
   │
   ▼
PostgreSQL
```

---

## Project Structure

```text
src
└── main
    ├── java
    │   └── com.example.leadmanagement
    │       ├── config
    │       ├── controller
    │       ├── dto
    │       ├── entity
    │       ├── enums
    │       ├── exception
    │       ├── mapper
    │       ├── repository
    │       ├── security
    │       ├── service
    │       └── startup
    └── resources
        └── application.properties
```

---

## Running the Project

### Clone the Repository

```bash
git clone https://github.com/<your-username>/leadmanagement.git
cd leadmanagement
```

### Configure Environment Variables

Create a `.env` file and add:

```text
SERVER_PORT=8080
SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/lead_management
SPRING_DATASOURCE_USERNAME=postgres
SPRING_DATASOURCE_PASSWORD=Postgresql
JWT_SECRET=your-secret-key
JWT_EXPIRATION=3600000
```

### Run Locally

```bash
mvn clean install
mvn spring-boot:run
```

### Run with Docker

```bash
docker compose up --build
```

---

## API Documentation

After starting the application, open:

Local:

```
http://localhost:8080/swagger-ui/index.html
```

Docker:

```
http://localhost:8081/swagger-ui/index.html
```

---

## Default Users

### Administrator

| Username | Password |
|----------|----------|
| admin | admin123 |

### Member

| Username | Password |
|----------|----------|
| member | member123 |

---

## Screenshots

- Swagger UI
![img.png](screenshots/img.png)


- PostgreSQL Tables
![img_4.png](screenshots/img_4.png)


- Login Response
![img_1.png](screenshots/img_1.png)


- CRUD Operations
![img_2.png](screenshots/img_2.png)


- Search API
  ![img_3.png](screenshots/img_3.png)


- Pagination
![img.png](screenshots/img5.png)
