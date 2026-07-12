
![GitHub last commit](https://img.shields.io/github/last-commit/Ummehani18/lead_management_API?style=for-the-badge)
# Lead Management System API


![Java](https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.5-brightgreen?style=for-the-badge&logo=springboot)
![Spring Security](https://img.shields.io/badge/Spring_Security-JWT-success?style=for-the-badge&logo=springsecurity)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-17-blue?style=for-the-badge&logo=postgresql)
![Maven](https://img.shields.io/badge/Maven-Build-red?style=for-the-badge&logo=apachemaven)
![Status](https://img.shields.io/badge/Status-In_Development-yellow?style=for-the-badge)
![License](https://img.shields.io/badge/License-MIT-purple?style=for-the-badge)


A secure RESTful backend service for managing leads, built using **Spring Boot**. This project demonstrates backend engineering fundamentals including authentication, authorization, database design, API development, validation, and clean architecture.



This project was developed as part of the **LXD Backend Technical Assessment**.


## Features

### Authentication
- JWT-based authentication
- Secure login endpoint
- Password encryption using BCrypt

### Authorization
- Role-Based Access Control (RBAC)
- Admin role
- Member role

### Lead Management
- Create Lead
- View Lead
- Update Lead
- Delete Lead

### Additional Features
- Search leads by name or phone
- Pagination support
- Input validation
- Global exception handling
- Proper HTTP status codes

### Bonus (Planned)
- Swagger/OpenAPI Documentation
- Docker Support
- Deployment



## Tech Stack

| Technology      | Purpose |
|-----------------|---------|
| Java 17         | Programming Language |
| Spring Boot     | Backend Framework |
| Spring Security | Authentication & Authorization |
| Spring Data JPA | ORM |
| PostgreSQL      | Database |
| Maven           | Build Tool |
| Lombok          | Boilerplate Reduction |
| JWT             | Authentication |
| Hibernate       | ORM Implementation |
| Swagger         | API Documentation (Planned) |
| Docker          | Containerization (Planned) |



## Project Structure

```
src
└── main
    ├── java
    │   └── com.example.leadmanagement
    │       ├── config
    │       ├── controller
    │       ├── dto
    │       ├── entity
    │       ├── exception
    │       ├── repository
    │       ├── security
    │       ├── service
    │       ├── mapper
    │       └── util
    │
    └── resources
        ├── application.properties
        └── data.sql (optional)
```



## Database Design

### User

| Field | Type |
|-------|------|
| id | Long |
| username | String |
| password | String |
| role | Enum |
| createdAt | Timestamp |



### Lead

| Field | Type |
|-------|------|
| id | Long |
| name | String |
| phone | String |
| email | String |
| company | String |
| status | Enum |
| createdAt | Timestamp |
| updatedAt | Timestamp |



## Roles

### ADMIN

Can

- Create Lead
- View Lead
- Update Lead
- Delete Lead
- Search Leads



### MEMBER

Can

- View Leads
- Search Leads



## API Endpoints

### Authentication

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | /auth/login | User Login |



### Leads

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | /leads | Create Lead |
| GET | /leads | Get All Leads |
| GET | /leads/{id} | Get Lead By ID |
| PUT | /leads/{id} | Update Lead |
| DELETE | /leads/{id} | Delete Lead |
| GET | /leads/search | Search Leads |



## Pagination

Example

```
GET /leads?page=0&size=10
```


## Authentication

All protected APIs require a JWT token.

Example Header

```
Authorization: Bearer <JWT_TOKEN>
```



## Validation

The application validates user input using Bean Validation.

Examples

- Required fields
- Email validation
- Phone validation
- Invalid request handling



## Exception Handling

The API returns standardized error responses.

Example

```json
{
  "timestamp": "2026-07-13T12:00:00",
  "status": 400,
  "message": "Phone number is required"
}
```



## Getting Started

### Prerequisites

- Java 21
- Maven
- PostgreSQL
- IntelliJ IDEA (Recommended)



### Clone Repository

```bash
git clone https://github.com/your-username/lead-management-api.git

cd lead-management-api
```



### Create Database

```sql
CREATE DATABASE lead_management;
```



### Configure Database

Update the following properties inside

```
application.properties
```

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/lead_management
spring.datasource.username=postgres
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
```



### Run Application

```bash
mvn spring-boot:run
```

or

Run

```
LeadManagementApplication.java
```



## Testing

Use

- Postman
- Swagger (Coming Soon)



## Future Improvements

- Refresh Token Authentication
- Soft Delete
- Unit Testing
- Integration Testing
- Docker
- CI/CD Pipeline
- Deployment
- API Rate Limiting
- Audit Logging


## Git Commit Strategy

- Initial Project Setup
- Database Configuration
- Entity Design
- JWT Authentication
- Spring Security Configuration
- CRUD Implementation
- Search and Pagination
- Validation and Exception Handling
- Swagger Integration
- Docker Support
- Documentation



## Author

**Umme Hani**

Backend Developer

Java • Spring Boot • PostgreSQL • REST APIs
