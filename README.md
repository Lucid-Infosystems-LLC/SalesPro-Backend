# SalesPro Backend

SalesPro is a comprehensive recruiting management system built with Spring Boot that helps streamline IT consulting operations. This backend service provides robust APIs for managing candidate profiles, tracking market trends, and integrating with LinkedIn.

## Features

- 🔐 JWT Authentication & Authorization
- 👤 Complete candidate profile management
- 📊 Market trend analysis with AI integration
- 🔗 LinkedIn profile integration
- 📧 Automated email notifications
- ✅ Input validation and error handling
- 🧪 Comprehensive test coverage

## Technology Stack

- Java 17
- Spring Boot 3.x
- Spring Security
- Spring Data JPA
- PostgreSQL
- JWT for authentication
- Maven
- JUnit 5 & MockMVC for testing

## Prerequisites

Before running the application, ensure you have:

- Java 17 or higher installed
- Maven 3.6+ installed
- PostgreSQL 12+ running locally
- SMTP server access for email notifications

## Configuration

### Environment Variables

Create a `.env` file in the project root with the following variables:

```env
DB_USERNAME=your_db_username
DB_PASSWORD=your_db_password
MAIL_USERNAME=your_email_username
MAIL_PASSWORD=your_email_password
JWT_SECRET=your_jwt_secret_key
```

### Database Configuration

The application uses PostgreSQL by default. Update `application.yml` if needed:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/salespro
    username: ${DB_USERNAME}
    password: ${DB_PASSWORD}
```

## Installation & Running

1. Clone the repository:
```bash
git clone https://github.com/yourusername/salespro-backend.git
cd salespro-backend
```

2. Build the project:
```bash
mvn clean install
```

3. Run the application:
```bash
mvn spring-boot:run
```

The server will start on `http://localhost:8080`

## API Documentation

### Authentication

```http
POST /api/v1/auth/login
Content-Type: application/json

{
    "email": "user@example.com",
    "password": "password"
}
```

### Candidate Management

```http
# Create candidate profile
POST /api/v1/candidates
Authorization: Bearer <jwt_token>
Content-Type: application/json

{
    "name": "John Doe",
    "email": "john@example.com",
    "phone": "+1234567890",
    "linkedInId": "johndoe"
}

# Update candidate profile
PUT /api/v1/candidates/{id}
Authorization: Bearer <jwt_token>

# Delete candidate profile
DELETE /api/v1/candidates/{id}
Authorization: Bearer <jwt_token>

# Get candidate profile
GET /api/v1/candidates/{id}
Authorization: Bearer <jwt_token>
```

### LinkedIn Integration

```http
# Get LinkedIn profile by ID
GET /api/v1/candidates/linkedin/{linkedInId}
Authorization: Bearer <jwt_token>

# Get LinkedIn profile by email
GET /api/v1/candidates/linkedin/email/{email}
Authorization: Bearer <jwt_token>

# Get LinkedIn profile by phone
GET /api/v1/candidates/linkedin/phone/{phone}
Authorization: Bearer <jwt_token>
```

### Market Trends

```http
# Get current trends
GET /api/v1/trends/current
Authorization: Bearer <jwt_token>

# Get trend projections
GET /api/v1/trends/projection
Authorization: Bearer <jwt_token>
```

## Testing

Run the test suite:

```bash
# Run all tests
mvn test

# Run integration tests only
mvn test -Dtest=*IT

# Run with coverage report
mvn test jacoco:report
```

## Error Handling

The application uses a global exception handler to manage errors:

- 400: Bad Request (validation errors)
- 401: Unauthorized (invalid/missing token)
- 404: Not Found (resource doesn't exist)
- 500: Internal Server Error

Example error response:
```json
{
    "error": "Resource not found",
    "message": "Candidate with ID 123 not found",
    "timestamp": "2024-12-07T10:15:30Z"
}
```

## Security

- All endpoints except `/api/v1/auth/**` require authentication
- JWT tokens expire after 24 hours
- Passwords are encrypted using BCrypt
- Input validation prevents SQL injection and XSS attacks

## Contributing

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Support

For support, email support@lucidinfosystems.com or open an issue in the GitHub repository.
