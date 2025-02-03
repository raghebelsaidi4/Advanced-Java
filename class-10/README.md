# CallableStatement Interface

The `CallableStatement` interface is used to execute stored procedures and functions in a database. It extends the `PreparedStatement` interface and allows invoking PL/SQL programs.

### Creating a CallableStatement
```java
CallableStatement cs = connection.prepareCall("{call procedure_name(?, ?)}");
cs.setInt(1, 100);
cs.setString(2, "example");
cs.execute();
```

---

# ResultSet Enhancements

A `ResultSet` is an object that encapsulates a set of rows retrieved from a database.

## Methods to Execute Queries

1. **execute()**: Can be used for any SQL statement (DDL/DML/Queries). Returns `true` if the result is a `ResultSet`, otherwise `false`.
   ```java
   Statement stmt = connection.createStatement();
   boolean hasResultSet = stmt.execute("SELECT * FROM users");
   ```

2. **executeUpdate()**: Used for DML (INSERT, UPDATE, DELETE) statements. Returns the number of affected rows.
   ```java
   int rowsAffected = stmt.executeUpdate("UPDATE users SET name='John' WHERE id=1");
   ```

3. **executeQuery()**: Used for executing SELECT queries, returns a `ResultSet`.
   ```java
   ResultSet rs = stmt.executeQuery("SELECT * FROM users");
   while(rs.next()) {
       System.out.println(rs.getString("name"));
   }
   ```

---

# ResultSet Enhancements

ResultSet enhancements are divided into two categories:

### 1. ResultSet Types
There are three types of `ResultSet` (defined as static members in `java.sql.ResultSet` interface):

1. **TYPE_FORWARD_ONLY**: The cursor can only move forward.
2. **TYPE_SCROLL_INSENSITIVE**: The cursor can move both forward and backward, but changes in the database after fetching data are not reflected.
3. **TYPE_SCROLL_SENSITIVE**: The cursor can move forward and backward, and changes in the database after fetching are reflected.

#### Example of Using Different ResultSet Types
```java
Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
ResultSet rs = stmt.executeQuery("SELECT * FROM users");
if(rs.last()) {
    System.out.println("Last record: " + rs.getString("name"));
    rs.beforeFirst();
}
```

### 2. Concurrency Types
Concurrency determines whether the ResultSet is updatable.

1. **CONCUR_READ_ONLY**: The ResultSet cannot be updated.
2. **CONCUR_UPDATABLE**: The ResultSet can be updated.

#### Example of an Updatable ResultSet
```java
Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
ResultSet rs = stmt.executeQuery("SELECT * FROM users");
while(rs.next()) {
    rs.updateString("name", "Updated Name");
    rs.updateRow();
}
```