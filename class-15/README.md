# Transaction Management in JDBC

A **transaction** is a single unit of work that consists of one or more operations. In JDBC, transaction management allows executing multiple operations as a single unit, ensuring data consistency and integrity.

## Managing Transactions Manually in JDBC
By default, **auto-commit mode** is `true` in JDBC, meaning each SQL statement is treated as a transaction and committed automatically.

To manage transactions manually, we can use the following methods:

### Methods:
- `setAutoCommit(false)`: Disables auto-commit mode.
- `commit()`: Commits the transaction, making changes permanent.
- `rollback()`: Rolls back the transaction, undoing changes.

### commit vs rollback
- **commit()**: If all operations within a transaction are successful, `commit()` saves the changes.
- **rollback()**: If any operation fails, `rollback()` undoes all changes since the last commit.

---

## Example: Using Commit and Rollback in JDBC

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionExample {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;
        
        try {
            // Establishing connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "password");
            
            // Disabling auto-commit mode
            conn.setAutoCommit(false);
            
            // First SQL operation
            String sql1 = "INSERT INTO accounts (id, name, balance) VALUES (?, ?, ?)";
            pstmt1 = conn.prepareStatement(sql1);
            pstmt1.setInt(1, 1);
            pstmt1.setString(2, "John");
            pstmt1.setDouble(3, 5000.00);
            pstmt1.executeUpdate();
            
            // Second SQL operation (introducing an error for rollback test)
            String sql2 = "INSERT INTO transactions (id, account_id, amount) VALUES (?, ?, ?)";
            pstmt2 = conn.prepareStatement(sql2);
            pstmt2.setInt(1, 1);
            pstmt2.setInt(2, 1);
            pstmt2.setDouble(3, -2000.00);
            pstmt2.executeUpdate();
            
            // Commit transaction if both statements succeed
            conn.commit();
            System.out.println("Transaction committed successfully.");
        } catch (SQLException e) {
            try {
                if (conn != null) {
                    conn.rollback(); // Rollback changes if an error occurs
                    System.out.println("Transaction rolled back.");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                if (pstmt1 != null) pstmt1.close();
                if (pstmt2 != null) pstmt2.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
