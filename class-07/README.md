# Java SQL Statement

The `java.sql.Statement` interface is used to execute SQL queries and updates against a database. It provides several methods to execute different types of SQL queries. Below is an overview of the key methods and their usage, along with examples.

## Methods

### `execute()`
The `execute()` method is used to execute SQL statements that return multiple result sets or update counts. It is typically used for executing Data Definition Language (DDL) queries such as `CREATE`, `ALTER`, and `DROP`.

**Example:**
```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ExecuteExample {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "user", "password");
            Statement stmt = conn.createStatement();
            
            // Execute a DDL statement
            String sql = "CREATE TABLE Employees (id INT PRIMARY KEY, name VARCHAR(100), age INT)";
            boolean result = stmt.execute(sql);
            
            System.out.println("Table created: " + result);
            
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

### `executeUpdate()`
The `executeUpdate()` method is used to execute SQL statements that modify the database, such as `INSERT`, `UPDATE`, and `DELETE`. It returns an integer representing the number of rows affected by the SQL statement.

**Example:**
```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ExecuteUpdateExample {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "user", "password");
            Statement stmt = conn.createStatement();
            
            // Execute an INSERT statement
            String sql = "INSERT INTO Employees (id, name, age) VALUES (1, 'John Doe', 30)";
            int rowsAffected = stmt.executeUpdate(sql);
            
            System.out.println("Rows affected: " + rowsAffected);
            
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

### `executeQuery()`
The `executeQuery()` method is used to execute SQL statements that return a result set, such as `SELECT` queries. It returns a `ResultSet` object that contains the data returned by the query.

**Example:**
```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ExecuteQueryExample {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "user", "password");
            Statement stmt = conn.createStatement();
            
            // Execute a SELECT statement
            String sql = "SELECT id, name, age FROM Employees";
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                
                System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
            }
            
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```
