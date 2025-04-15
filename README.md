# MicroServicesLab 

This project demonstrates a microservice architecture using **Spring Boot**, **Spring Cloud**, **Eureka**, **OpenFeign**, and **API Gateway**.

## 🔧 Microservices

- `UserServiceLab` → Manages users (PostgreSQL)
- `OrderServiceLab` → Manages orders and connects to UserService via Feign
- `EurekaService` → Service Registry (http://localhost:8755)
- `APIGateway` → Gateway to route requests (http://localhost:8080)

## Running the Services

Start the apps **in this order**:

1. `EurekaService` (port: 8755)
2. `UserServiceLab` (port: 8082)
3. `OrderServiceLab` (port: 8081)
4. `APIGateway` (port: 8080)

> Make sure your PostgreSQL is running and ports are free.

## API Gateway Access

Use Postman or browser to test:
- `http://localhost:8080/api/v1/users`
- `http://localhost:8080/api/v1/orders`

## Database

Ensure PostgreSQL is running and databases are pre-created:
- `UserServiceLabDB`
- `OrderServiceLabDB`

Login: `Arm / 1234` (change in `application.properties` if needed)

---

Built by ArmBro24
