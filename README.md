# 💰 Expense Tracking API

A secure RESTful API built using **Java**, **Spring Boot**, and **PostgreSQL** that allows users to register, log in, and manage their personal expenses. Includes JWT authentication and Swagger UI documentation.

---

## 🔧 Features

- ✅ User Registration & Login (JWT Auth)
- ✅ Secure CRUD operations on expenses
- ✅ PostgreSQL database integration
- ✅ Swagger UI for API testing
- ✅ Password encryption using BCrypt
- ✅ Token-based access control

---

## 📁 Project Structure

```
com.expensetracker
├── controller
├── dto
├── model
├── repository
├── security
├── service
└── config
```

---

## 🛠️ Technologies Used

- Java 17
- Spring Boot
- Spring Security
- JWT (JSON Web Token)
- PostgreSQL
- Swagger / OpenAPI 3
- Maven
- Eclipse IDE

---

## 🚀 API Endpoints

### 👤 Auth

| Method | Endpoint         | Description       |
|--------|------------------|-------------------|
| POST   | `/api/auth/register` | Register user    |
| POST   | `/api/auth/login`    | Login, get token |

### 💼 Expense

> Add `Authorization: Bearer <JWT>` header to all endpoints below

| Method | Endpoint           | Description         |
|--------|--------------------|---------------------|
| GET    | `/api/expenses`    | List all expenses   |
| POST   | `/api/expenses`    | Add new expense     |
| PUT    | `/api/expenses/{id}` | Update expense    |
| DELETE | `/api/expenses/{id}` | Delete expense    |

---

## 🧪 Swagger UI

Once the app is running, visit:

```
http://localhost:8080/swagger-ui/index.html
```

---

## 🖥️ Run Locally

### 1. Clone the project

```bash
git clone https://github.com/your-username/expense-tracker-api.git
cd expense-tracker-api
```

### 2. Configure `application.properties`

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/your_db
spring.datasource.username=your_user
spring.datasource.password=your_pass
spring.jpa.hibernate.ddl-auto=update
```

### 3. Run the application

Run the app from Eclipse or with Maven:

```bash
mvn spring-boot:run
```

---

## 🔐 Sample Token Usage

```
Authorization: Bearer eyJhbGciOiJIUzI1...
```

---

## 👨‍💻 Author

**Kongari Sivaram**  
📍 Hyderabad, India  
📧 sivaramkongari@gmail.com  
🔗 [LinkedIn](https://linkedin.com/in/kongari-sivaram)  
🔗 [GitHub](https://github.com/Sivaram-Kongari)

---

## ⭐️ Show Your Support

If you found this project useful, don’t forget to **⭐ the repository**!
