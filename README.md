# CabApplication
The Cab application aims to provide a convenient way for users to book a cab, track their ride and make payments. The application offers a user-friendly interface and robust security features.


# Tech Stack
- Java
- Spring Framework
- Spring Boot
- Spring Data JPA
- MySQL
- Swagger UI
- Lambok
- Maven


# Features
- Users can register themselves and log into the system
- Users can book a cab for their desired destination and track their ride in real-time
- Users can view their ride history and payment history
- Users can pay for their ride using multiple payment methods
- Cab drivers can register themselves and log into the system
- Cab drivers can view their ride history and payment history
- Cab drivers can accept or reject ride requests from users
- Admin can log into the system and view details of all rides and payments

# Modules

- Login Module
- User Module
- Admin Module


# Installation & Run
 - Before running the API server, you should update the database config inside the application.properties file.
- Update the port number, username and password as per your local database configuration.

```
        server.port=8080

    spring.datasource.url=jdbc:mysql://localhost:3306/MasaiCabDB;
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=root
    spring.datasource.password=root

```

# API Root Endpoint
```
https://localhost:8080/
```
```
http://localhost:8080/swagger-ui/
```
