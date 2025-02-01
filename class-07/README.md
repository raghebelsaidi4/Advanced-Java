# JDBC PreparedStatement Example: Student Data Insertion

This project demonstrates how to use JDBC `PreparedStatement` to safely insert data into a MySQL database table. It includes parameterized SQL queries to prevent SQL injection and improve performance for repeated executions.


---

## Key Features
- Uses `PreparedStatement` for secure parameterized queries
- Dynamic insertion of student data (ID, Name, Age)
- MySQL database integration
- Error handling with try-catch blocks

---

## Prerequisites
- **Java Development Kit (JDK) 8+**
- **MySQL Server** (local or remote instance)
- **MySQL Connector/J JDBC Driver** ([Download](https://dev.mysql.com/downloads/connector/j/))
- Database table structure:
  ```sql
  CREATE DATABASE jdbc_db;
  USE jdbc_db;
  
  CREATE TABLE student (
      id INT PRIMARY KEY,
      name VARCHAR(50),
      age INT
  );
  ```

---

## 🛠 Setup Instructions

1. **Add MySQL JDBC Driver**  
   Download the MySQL Connector/J JAR file and:
    - For command-line usage: Add to classpath using `-cp` flag
      ```bash
      javac -cp mysql-connector-java-8.0.30.jar com/ragheb/App.java
      ```
    - For IDEs (Eclipse/IntelliJ): Add JAR to project libraries

2. **Configure Database Credentials**  
   Modify connection URL in code if needed:
   ```java
   DriverManager.getConnection(
       "jdbc:mysql://localhost:3306/jdbc_db",  // URL
       "root",                                 // Username
       "ragheb01276323608"                     // Password
   );
   ```

---

## 🧑💻 Code Explanation

### 1. Database Connection Setup
```java
Class.forName("com.mysql.cj.jdbc.Driver");
Connection connection = DriverManager.getConnection(url, user, pass);
```
- Loads MySQL JDBC driver class
- Establishes connection using credentials

### 2. PreparedStatement Usage
```java
PreparedStatement pstmt = connection.prepareStatement(
    "INSERT INTO student VALUES(?,?,?)"
);
```
- `?` acts as placeholder for dynamic values
- Parameter indices start at `1`

### 3. Parameter Binding
```java
pstmt.setInt(1, Integer.parseInt(args[0]));    // ID
pstmt.setString(2, args[1]);                   // Name
pstmt.setInt(3, Integer.parseInt(args[2]));    // Age
```
- Type-safe value assignment
- Prevents SQL injection attacks

### 4. Query Execution
```java
pstmt.executeUpdate();
```
- Executes the parameterized INSERT statement
- Returns number of affected rows

---

## 🚀 Running the Project

**Command Syntax:**
```bash
java -cp mysql-connector-java-8.0.30.jar:. com.ragheb.App <id> <name> <age>
```

**Example:**
```bash
java -cp mysql-connector-java-8.0.30.jar:. com.ragheb.App 101 "Alice Smith" 22
```

**Expected Output:**
```
Student inserted
```

**Verify in MySQL:**
```sql
SELECT * FROM jdbc_db.student;
```

---

## ✅ Best Practices

1. **Use Try-with-Resources** (Auto-closable):
   ```java
   try (Connection conn = DriverManager.getConnection(...);
        PreparedStatement pstmt = conn.prepareStatement(...)) {
       // Your code
   }
   ```

2. **Input Validation**  
   Add checks for argument count and data types:
   ```java
   if(args.length != 3) {
       throw new IllegalArgumentException("Requires 3 arguments: id name age");
   }
   ```

3. **Secure Credential Management**  
   Store database credentials in environment variables/properties files instead of hardcoding.

---

## 🚨 Troubleshooting

| Error                          | Solution                                  |
|--------------------------------|-------------------------------------------|
| `ClassNotFoundException`       | Check JDBC driver JAR in classpath       |
| `SQLException: Access denied`  | Verify username/password/database name   |
| `NumberFormatException`        | Ensure ID and Age arguments are integers |
| `Communications link failure`  | Check MySQL server status and port (3306)|

---

**Note:** Replace placeholder values (`jdbc_db`, `root`, `ragheb01276323608`) with your actual database credentials and adjust MySQL connector version in commands as needed.