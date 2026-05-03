# Mini_Project_Involving_JAVA_SQL_JDBC
This mini‑project demonstrates CRUD operations using Java, JDBC, and MySQL. It manages user accounts and product pricing records with proper database connectivity and transaction handling.
# 🛒 BestPrice & User Management System

##  Overview
This mini‑project demonstrates CRUD operations using **Java, JDBC, and MySQL**. It manages **user accounts and product pricing records** with proper database connectivity, foreign key relationships, and transaction handling.

## Tech Stack
- **Java** (Core + OOP concepts)  
- **JDBC** (Database connectivity)  
- **MySQL** (RDBMS)  
- **Eclipse/IntelliJ** (IDE)  

##  Features
- Create relational tables (`User`, `BestPrice`) with foreign key constraints  
- Add, update, delete, and view **BestPrice records** linked to users  
- Batch processing with JDBC for efficiency  
- Exception handling and logging for reliability  

## 📊 Database Schema
### User Table
```sql
CREATE TABLE User (
  user_id INT AUTO_INCREMENT PRIMARY KEY,
  user_name VARCHAR(50),
  user_age INT,
  user_city VARCHAR(50)
);
