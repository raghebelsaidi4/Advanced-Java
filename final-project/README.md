```markdown
# Car Rental Web Application

A Java-based web application for managing car rentals, users, and orders with role-based access control (Admin/User). Built using JSP, Servlets, PostgreSQL, and following MVC architecture.

## Table of Contents
- [Features](#features)
- [Technologies](#technologies)
- [Project Structure](#project-structure)
- [Database Schema](#database-schema)
- [Setup & Installation](#setup--installation)
- [Configuration](#configuration)
- [License](#license)

## Features
- **User Authentication**
  - Login/Logout functionality
  - MD5 password encryption
  - Session management
- **Role-Based Access**
  - Admin: Manage users/cars
  - User: View cars & place orders
- **Car Management**
  - CRUD operations for cars
  - Car availability tracking
- **Order System**
  - Create/View rental orders
  - Date-based reservations
- **Error Handling**
  - Custom error pages (404, 500)
  - Logging with Log4j2
- **Testing**
  - JUnit tests for DAO layer

## Technologies
- **Backend**: Java 17, JSP/Servlets
- **Database**: PostgreSQL
- **Testing**: JUnit 4, H2 Database (tests)
- **Logging**: Log4j2
- **Frontend**: JSP, Bootstrap 4, JSTL
- **Build**: Maven
- **Dependency Management**: DAO/Service factories

## Project Structure
```
src/
├── main/
│   ├── java/
│   │   ├── com.ragheb.service.impl     # Service layer implementations
│   │   ├── com.ragheb.dao.impl         # Database access objects
│   │   ├── com.ragheb.domain           # Domain models (Car, User, Order)
│   │   ├── com.ragheb.util             # Utilities (MD5, Properties)
│   │   └── com.ragheb.constants        # Database/Controller constants
│   ├── webapp/
│   │   ├── WEB-INF/pages/              # JSP views
│   │   └── resources/                  # Config files & images
└── test/                               # JUnit test classes
```

## Database Schema
![Database Schema](docs/db_schema.png) *Replace with actual schema image*

Tables:
- **users_table**: Stores user credentials and roles
- **cars_table**: Vehicle inventory management
- **orders_table**: Rental transaction records

## Setup & Installation
1. **Database Setup**
   ```sql
   CREATE DATABASE car_rental;
   psql -U postgres -d car_rental -f src/main/resources/schema.sql
   ```
2. **Configure Properties**
    - Update `database.properties` with your PostgreSQL credentials
    - Modify `log4j2.properties` for logging preferences

3. **Build & Deploy**
   ```bash
   mvn clean package
   # Deploy WAR file to Tomcat
   ```


## Configuration
- **DB Connection**: Edit `src/main/resources/database.properties`
  ```
  jdbcUrl=jdbc:postgresql://localhost:5432/car_rental
  postgres.username=your_username
  postgres.password=your_password
  ```

- **Logging**: Configure in `log4j2.properties`
  ```properties
  property.filename = logs
  appender.file.fileName=${filename}/carRentalLog.log
  ```

- **Factories**: Singleton pattern used for:
    - `ServiceFactory`: Manages service instances
    - `DaoFactory`: Handles DAO instances and DB connections