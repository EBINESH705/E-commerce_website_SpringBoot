# 🛒 E-commerce Website (Spring Boot)

This is a sample E-commerce website built using **Spring Boot**. The project demonstrates a modular, scalable back-end for an online shopping platform, including user authentication, product management, cart functionality, and order processing.

---

## ✅ Features

- 🔐 User registration and authentication 
- 👥 Role-based access (customer/admin)
- 📦 Product catalog management (CRUD)
- 🛒 Shopping cart for authenticated users
- 🧾 Order placement and order history
- 🔁 RESTful APIs for frontend integration  
- ⚠️ Exception handling and validation
- 💳 (Optional) Integration with payment gateways

---

## 🧰 Technologies Used

- ☕ Java 17+  
- 🌱 Spring Boot  
- 🌐 Spring MVC  
- 🔐 Spring Security  
- 🗃️ Spring Data JPA / Hibernate  
- 🐬 MySQL (or H2 for testing)  
- 🧪 JUnit/TestNG  
- 📦 Maven / Gradle  
- ✨ Lombok  
- 📘 Swagger / OpenAPI (for API documentation)

---

## 🚀 Getting Started

### 🔧 Prerequisites

- Java 17 or later
- Maven or Gradle
- MySQL (or use embedded H2 for development)

---
### Project Structure
<pre>src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── yourpackage/
│   │           ├── controller/
│   │           ├── model/
│   │           ├── repository/
│   │           ├── service/
│   │           └── security/
│   └── resources/
│       └── application.properties
└── test/
 </pre>

 ---

## ⚙️ Configure the Database

Open the `src/main/resources/application.properties` file and update the following values with your MySQL configuration:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

### 📥 Clone the Repository

```bash
git clone https://github.com/EBINESH705/E-commerce_website_SpringBoot.git
cd E-commerce_website_SpringBoot
