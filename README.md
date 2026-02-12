# Java Microservice Coding Exam

This project is a **Java 8 Spring Boot 2.6** microservice implementing two main functionalities:

1. **Account Creation Service**
2. **Customer Inquiry Service**

It uses **H2 in-memory database** and **Spring Data JPA** for persistence.

---

## Technologies

- Java 8
- Spring Boot 2.6.15
- Spring Data JPA
- H2 Database (in-memory)
- Spring Web / REST
- Bean Validation (JSR-380)
- Maven for build

---
1. Account creation service (50 pts) – expose an endpoint that would enable client facing
application to create new Customer account.

<img width="1553" height="1212" alt="201 created" src="https://github.com/user-attachments/assets/adcd731c-3477-45c9-81a5-231be4c50f84" />


<img width="1536" height="1212" alt="create account status 400" src="https://github.com/user-attachments/assets/4230f229-65b6-4cb9-b416-2cb4af3f7af7" />

2. Customer inquiry service (50 pts) – expose an endpoint that search customer account
information from the database.


<img width="1551" height="1212" alt="302 found get customer by number" src="https://github.com/user-attachments/assets/0157b947-f72c-41b1-9bf8-109a8711b027" />

<img width="1530" height="1212" alt="status 401 customer not found" src="https://github.com/user-attachments/assets/8ca668e8-6c09-4b07-b82a-209252c6e8ce" />
