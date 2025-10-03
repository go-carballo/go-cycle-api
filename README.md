# Go Biciman - Bicycle Rental API

A Spring Boot-based REST API for managing bicycle rentals, allowing users to find and rent bikes based on different criteria like gender, brand, type, and model.

## Features

- Browse bicycles by:
    - Gender (Men/Women/Unisex)
    - Brand
    - Type (Mountain/Road/City/etc.)
    - Model
- Manage bicycle inventory
- Handle rental operations

## Technology Stack

- Java 21
- Spring Boot 3.5
- PostgreSQL Database
- Gradle
- JPA/Hibernate

## Getting Started

### Prerequisites

- JDK 21+
- PostgreSQL
- Gradle 8+

### Configuration

Configure your database connection in `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/biciman
spring.datasource.username=your_username
spring.datasource.password=your_password
