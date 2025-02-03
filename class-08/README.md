# Java SQL PreparedStatement

The `java.sql.PreparedStatement` interface is used to execute parameterized SQL queries. It extends the `Statement` interface and provides additional functionality to precompile SQL statements, which improves performance and security by preventing SQL injection attacks.

---

## Key Features of `PreparedStatement`

1. **Parameterized Queries**: Allows you to use placeholders (`?`) in SQL statements, which can be replaced with actual values at runtime.
2. **Precompilation**: SQL statements are precompiled, which improves performance for repeated executions.
3. **Security**: Protects against SQL injection by automatically escaping special characters in parameter values.

---

## Key Methods of `PreparedStatement`

1. **`void setXXX(int parameterIndex, XXX value)`**  
   Sets the value of a parameter in the SQL statement. Replace `XXX` with the appropriate data type (e.g., `setInt`, `setString`, `setDouble`).

2. **`boolean execute()`**  
   Executes the SQL statement, which may return multiple result sets or update counts.

3. **`int executeUpdate()`**  
   Executes the SQL statement, which is typically an `INSERT`, `UPDATE`, or `DELETE` statement. Returns the number of rows affected.

4. **`ResultSet executeQuery()`**  
   Executes the SQL statement, which is typically a `SELECT` statement. Returns a `ResultSet` object containing the query results.

5. **`void clearParameters()`**  
   Clears the current parameter values.

6. **`void close()`**  
   Releases the `PreparedStatement` object's database and JDBC resources.

---

## Example: Using `PreparedStatement`

### Example 1: Inserting Data with `PreparedStatement`

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PreparedStatementInsertExample {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "user", "password");
            
            // SQL query with placeholders
            String sql = "INSERT INTO Employees (id, name, age) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            // Set parameter values
            pstmt.setInt(1, 101); // id
            pstmt.setString(2, "Alice"); // name
            pstmt.setInt(3, 25); // age
            
            // Execute the query
            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);
            
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

---

### Example 2: Updating Data with `PreparedStatement`

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PreparedStatementUpdateExample {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "user", "password");
            
            // SQL query with placeholders
            String sql = "UPDATE Employees SET age = ? WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            // Set parameter values
            pstmt.setInt(1, 30); // new age
            pstmt.setInt(2, 101); // id of the employee to update
            
            // Execute the query
            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);
            
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

---

### Example 3: Querying Data with `PreparedStatement`

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PreparedStatementQueryExample {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "user", "password");
            
            // SQL query with placeholders
            String sql = "SELECT id, name, age FROM Employees WHERE age > ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            // Set parameter value
            pstmt.setInt(1, 25); // age condition
            
            // Execute the query
            ResultSet rs = pstmt.executeQuery();
            
            // Iterate through the ResultSet
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                
                System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
            }
            
            rs.close();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

---

### Example 4: Deleting Data with `PreparedStatement`

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PreparedStatementDeleteExample {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "user", "password");
            
            // SQL query with placeholders
            String sql = "DELETE FROM Employees WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            // Set parameter value
            pstmt.setInt(1, 101); // id of the employee to delete
            
            // Execute the query
            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);
            
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```
