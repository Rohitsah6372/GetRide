## Introduction
**GetRide** is a Spring Boot-based web application that facilitates ride booking. It includes features such as user authentication, ride booking, and payment processing.

## Features
- RESTful API for ride booking
- User authentication and role management
- Integration with **MySQL** for data storage
- Swagger API documentation
- Email notifications for ride confirmations
- Dependency injection with Spring Boot

## Tech Stack
- **Backend:** Java, Spring Boot, Spring Data JPA
- **Database:** MySQL
- **API Documentation:** Swagger (SpringDoc, SpringFox)
- **Tools:** Maven, Lombok, ModelMapper

## Installation

### Prerequisites
- JDK 21
- Maven
- MySQL

### Steps to Run
1. Clone the repository:
   ```sh
   git clone https://github.com/yourusername/GetRide.git
   cd GetRide
   ```

2. Configure database connection in `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/getride
   spring.datasource.username=root
   spring.datasource.password=yourpassword
   ```

3. Build and run the application:
   ```sh
   mvn clean install
   mvn spring-boot:run
   ```

4. Access the API documentation at:
   ```
   http://localhost:8080/swagger-ui.html
   ```

## API Endpoints
| Method | Endpoint         | Description               |
|--------|-----------------|---------------------------|
| GET    | /rides          | Get all rides            |
| POST   | /rides/book     | Book a ride              |
| GET    | /users/{id}     | Get user details         |
| POST   | /users/register | Register a new user      |


