# JDBC Core Interfaces: Connections, Statements, and ResultSets

## `java.sql.Connection` Interface
Represents a connection to a database. Key methods include:

| Method                     | Description                                                                 |
|----------------------------|-----------------------------------------------------------------------------|
| `Statement createStatement()` | Creates a `Statement` for executing SQL queries.                          |
| `PreparedStatement prepareStatement(String sql)` | Creates a `PreparedStatement` for parameterized queries.                |
| `CallableStatement prepareCall(String sql)` | Creates a `CallableStatement` for stored procedures.                    |
| `void setAutoCommit(boolean autoCommit)` | Controls transaction auto-commit mode.                                  |
| `void commit()`             | Commits the current transaction.                                           |
| `void rollback()`           | Rolls back the current transaction.                                        |
| `void close()`              | Releases database connection resources.                                    |

---

## Statement Interfaces

### 1. **`Statement`** 
Used for **static SQL queries** (no parameters).  
**Key Methods**:
```java
boolean execute(String sql)              // For DDL (CREATE, ALTER, DROP)
int executeUpdate(String sql)            // For DML (INSERT, UPDATE, DELETE)
ResultSet executeQuery(String sql)       // For DQL (SELECT)
```

### 2. **`PreparedStatement`** (extends `Statement`)
Used for **dynamic SQL queries** with parameters. Prevents SQL injection.  
**Key Features**:
```java
PreparedStatement pstmt = connection.prepareStatement(
  "INSERT INTO users (name, email) VALUES (?, ?)"
);
pstmt.setString(1, "Alice");   // Set first parameter
pstmt.setString(2, "alice@example.com");
pstmt.executeUpdate();
```

### 3. **`CallableStatement`** (extends `PreparedStatement`)
Used to execute **stored procedures** (PL/SQL in Oracle, T-SQL in SQL Server).  
**Example**:
```java
CallableStatement cstmt = connection.prepareCall("{call get_employee(?, ?)}");
cstmt.setInt(1, 101);          // Input parameter
cstmt.registerOutParameter(2, Types.VARCHAR);  // Output parameter
cstmt.execute();
String name = cstmt.getString(2);
```

---

## `java.sql.ResultSet`
A table-like object containing query results. The cursor starts **before the first row**.

### Key Methods
| Method                            | Description                                     |
|-----------------------------------|-------------------------------------------------|
| `boolean next()`                  | Moves to next row (returns `false` if no more) |
| `String getString(int column)`    | Gets column value as String                    |
| `int getInt(int column)`          | Gets column value as integer                   |
| `Date getDate(int column)`        | Gets date value                                |
| `boolean isBeforeFirst()`         | True if cursor is before first row             |
| `boolean isAfterLast()`           | True if cursor is after last row               |

**Example**:
```java
ResultSet rs = statement.executeQuery("SELECT * FROM employees");
while (rs.next()) {
  String name = rs.getString("name");
  int age = rs.getInt("age");
}
```

### ResultSet Types
| Type                          | Description                                     |
|-------------------------------|-------------------------------------------------|
| `TYPE_FORWARD_ONLY`           | Cursor moves forward only (default)            |
| `TYPE_SCROLL_INSENSITIVE`     | Scrollable, insensitive to DB changes          |
| `TYPE_SCROLL_SENSITIVE`       | Scrollable, sensitive to DB changes            |

### Concurrency Modes
| Mode                     | Description                                     |
|--------------------------|-------------------------------------------------|
| `CONCUR_READ_ONLY`       | Read-only (default)                             |
| `CONCUR_UPDATABLE`       | Allows updating ResultSet data                  |

---

## Metadata Interfaces

### 1. **`ResultSetMetaData`**
Provides information about a `ResultSet`'s structure.  
**Key Methods**:
```java
ResultSetMetaData meta = rs.getMetaData();
int columnCount = meta.getColumnCount();       // Number of columns
String columnName = meta.getColumnName(1);     // Name of first column
String columnType = meta.getColumnTypeName(2); // Data type of second column
```

### 2. **`DatabaseMetaData`**
Provides database-level information.  
**Key Methods**:
```java
DatabaseMetaData dbMeta = connection.getMetaData();
String dbName = dbMeta.getDatabaseProductName();    // e.g., "Oracle"
String driverVersion = dbMeta.getDriverVersion();   // e.g., "12.2.0.1"
```

---

## Best Practices
1. **Always close resources** in `finally` blocks or use try-with-resources:
   ```java
   try (Connection conn = DriverManager.getConnection(url);
        Statement stmt = conn.createStatement()) {
     // JDBC operations
   }
   ```
2. Use **`PreparedStatement`** for dynamic queries to prevent SQL injection.
3. Specify **ResultSet type and concurrency** when needed:
   ```java
   Statement stmt = conn.createStatement(
     ResultSet.TYPE_SCROLL_INSENSITIVE,
     ResultSet.CONCUR_UPDATABLE
   );
   ```
