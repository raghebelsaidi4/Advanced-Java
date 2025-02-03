# Java SQL ResultSet and Metadata

The `java.sql.ResultSet` interface represents the result set of a database query. It provides methods to navigate through the rows of data and retrieve column values. Additionally, metadata such as `ResultSetMetaData` and `DatabaseMetaData` provide information about the structure of the result set and the database itself.

---

## ResultSet

A `ResultSet` is an object that encapsulates a set of rows retrieved from a database based on an SQL query. When a `ResultSet` is generated, its cursor (or pointer) is positioned **before the first row**. You can use methods like `next()` to move the cursor and access the data.

### Key Methods of `ResultSet`

1. **`boolean next()`**  
   Moves the cursor to the next row. Returns `true` if the new row is valid; otherwise, `false`.

2. **`getXXX(int columnIndex)` or `getXXX(String columnName)`**  
   Retrieves the value of a column in the current row. Replace `XXX` with the appropriate data type (e.g., `getInt`, `getString`, `getDouble`).

3. **`close()`**  
   Releases the `ResultSet` object's database and JDBC resources.

---

### Example: Using `ResultSet`

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ResultSetExample {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "user", "password");
            Statement stmt = conn.createStatement();
            
            // Execute a SELECT query
            String sql = "SELECT id, name, age FROM Employees";
            ResultSet rs = stmt.executeQuery(sql);
            
            // Iterate through the ResultSet
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

---

## Metadata

### 1. **ResultSetMetaData**
`ResultSetMetaData` provides information about the structure of a `ResultSet`, such as the number of columns, column names, and data types.

#### Key Methods of `ResultSetMetaData`

1. **`int getColumnCount()`**  
   Returns the number of columns in the `ResultSet`.

2. **`String getColumnName(int columnIndex)`**  
   Returns the name of the specified column.

3. **`String getColumnTypeName(int columnIndex)`**  
   Returns the data type of the specified column.

4. **`int getColumnDisplaySize(int columnIndex)`**  
   Returns the maximum width of the specified column.

---

### Example: Using `ResultSetMetaData`

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class ResultSetMetaDataExample {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "user", "password");
            Statement stmt = conn.createStatement();
            
            // Execute a SELECT query
            String sql = "SELECT id, name, age FROM Employees";
            ResultSet rs = stmt.executeQuery(sql);
            
            // Get ResultSetMetaData
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            
            // Display column information
            System.out.println("Column Count: " + columnCount);
            for (int i = 1; i <= columnCount; i++) {
                System.out.println("Column Name: " + rsmd.getColumnName(i));
                System.out.println("Column Type: " + rsmd.getColumnTypeName(i));
                System.out.println("Column Display Size: " + rsmd.getColumnDisplaySize(i));
                System.out.println("-----------------------------");
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

---

### 2. **DatabaseMetaData**
`DatabaseMetaData` provides information about the database itself, such as supported features, database version, and table details.

#### Key Methods of `DatabaseMetaData`

1. **`String getDatabaseProductName()`**  
   Returns the name of the database product.

2. **`String getDatabaseProductVersion()`**  
   Returns the version of the database product.

3. **`String getDriverName()`**  
   Returns the name of the JDBC driver.

4. **`ResultSet getTables(String catalog, String schemaPattern, String tableNamePattern, String[] types)`**  
   Retrieves a list of tables in the database.

---

### Example: Using `DatabaseMetaData`

```java
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class DatabaseMetaDataExample {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "user", "password");
            
            // Get DatabaseMetaData
            DatabaseMetaData dbmd = conn.getMetaData();
            
            // Display database information
            System.out.println("Database Product Name: " + dbmd.getDatabaseProductName());
            System.out.println("Database Product Version: " + dbmd.getDatabaseProductVersion());
            System.out.println("Driver Name: " + dbmd.getDriverName());
            System.out.println("Driver Version: " + dbmd.getDriverVersion());
            
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

---
