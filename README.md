# 🔐 Spring Boot JWT Authentication

A secure authentication system built using **Spring Boot 4**, **Spring Security**, **JWT (JSON Web Token)**, **BCrypt Password Encoding**, and **MySQL**.

This project demonstrates how modern stateless authentication works using JWT instead of traditional HTTP sessions.

---

# 🚀 Features

- ✅ User Registration
- ✅ User Login
- ✅ Password Encryption using BCrypt
- ✅ Spring Security Authentication
- ✅ JWT Access Token Generation
- ✅ JWT Validation
- ✅ Extract Username from JWT
- ✅ Token Expiration Handling
- 🚧 JWT Authentication Filter (In Progress)
- 🚧 Stateless Authentication (Coming Soon)
- 🚧 Role-Based Authorization (Planned)
- 🚧 Refresh Token Support (Planned)

---

# 🛠 Tech Stack

- Java 21
- Spring Boot
- Spring Security
- Spring Data JPA
- MySQL
- JWT (JJWT 0.12.6)
- Maven
- Lombok

---

# 📂 Project Structure

```
src
│
├── config
│
├── controller
│
├── dto
│
├── entity
│
├── repository
│
├── service
│
└── DemoApplication
```

---

# ⚙ Authentication Flow

## 1. User Registration

```
Client
   │
POST /register
   │
   ▼
Controller
   │
   ▼
Password Encoder (BCrypt)
   │
   ▼
MySQL Database
```

Passwords are never stored in plain text.

---

## 2. User Login

```
Client
   │
POST /login
Email + Password
   │
   ▼
AuthenticationManager
   │
   ▼
DaoAuthenticationProvider
   │
   ▼
CustomUserDetailsService
   │
   ▼
MySQL
   │
Password Verified
   │
   ▼
JwtService
   │
Generate JWT
   │
   ▼
JWT Returned to Client
```

---

# 🔑 JWT Structure

```
Header
   .
Payload
   .
Signature
```

Example

```
eyJhbGciOiJIUzI1NiJ9
.
eyJzdWIiOiJha2FzaEBnbWFpbC5jb20iLCJleHAiOjE3ODQ4NDYxNDh9
.
xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
```

### Header

Contains the signing algorithm.

```
{
  "alg":"HS256"
}
```

### Payload

Contains user information (claims).

```
{
  "sub":"user@gmail.com",
  "iat":1784842548,
  "exp":1784846148
}
```

### Signature

Generated using

```
HS256(
Header +
Payload +
Secret Key
)
```

The signature ensures the token has not been modified.

---

# 🔒 Password Encryption

Passwords are encrypted using BCrypt.

```
Password
      +
Random Salt
      ↓
BCrypt
      ↓
Hashed Password
```

During login:

- BCrypt extracts the stored salt.
- Re-hashes the entered password.
- Compares both hashes.

Passwords are never decrypted.

---

# 🔑 JWT Generation

JWT is generated after successful authentication.

```java
Authentication authentication =
authenticationManager.authenticate(
    new UsernamePasswordAuthenticationToken(
        email,
        password
    )
);

return jwtService.generateToken(userDetails);
```

---

# 📦 API Endpoints

## Register

```
POST /api/users/register
```

Request

```json
{
    "name":"Akash",
    "email":"akash@gmail.com",
    "password":"12345"
}
```

---

## Login

```
POST /api/users/login
```

Request

```json
{
    "email":"akash@gmail.com",
    "password":"12345"
}
```

Response

```json
{
    "token":"eyJhbGciOiJIUzI1NiJ9..."
}
```

---

# 📁 Current Architecture

```
Client
   │
   ▼
Spring Boot
   │
   ▼
AuthenticationManager
   │
   ▼
DaoAuthenticationProvider
   │
   ▼
UserDetailsService
   │
   ▼
Database
   │
   ▼
JwtService
   │
   ▼
JWT Token
```

---

# 🚧 Upcoming Architecture

```
Client
   │
Authorization: Bearer JWT
   │
   ▼
Spring Security Filter Chain
   │
   ├── CorsFilter
   ├── CsrfFilter
   ├── LogoutFilter
   ├── JwtAuthenticationFilter
   ├── UsernamePasswordAuthenticationFilter
   ├── AuthorizationFilter
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
Database
```

---

# ▶ Running the Project

Clone the repository

```bash
git clone <repository-url>
```

Navigate to the project

```bash
cd springboot-jwt-authentication
```

Configure MySQL in

```
application.properties
```

Run

```bash
mvn spring-boot:run
```

---

# 📌 Future Improvements

- JWT Authentication Filter
- Stateless Authentication
- Role-Based Authorization
- Refresh Token
- Logout using Token Blacklisting
- Email Verification
- Password Reset
- Swagger Documentation
- Docker Support
- Unit Testing

---

# 📚 Learning Objectives

This project demonstrates:

- Spring Security Fundamentals
- AuthenticationManager
- UserDetailsService
- Password Encoding with BCrypt
- JWT Authentication
- Claims Extraction
- Token Validation
- Stateless Authentication
- Secure REST APIs

---

# 👨‍💻 Author

**Akash Mohanraj**

B.Tech Artificial Intelligence & Data Science

Passionate about Java Backend Development, Spring Boot, AI, and Secure REST API Development.

---
⭐ If you found this project helpful, consider giving it a star!
