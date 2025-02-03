# RowSets

A **RowSet** is an object that encapsulates a set of rows from a database. It provides a more flexible way to work with data than `ResultSet`. Some RowSets are connected, while others are disconnected and serializable.

## Types of RowSets

### 1. JDBCRowSet
- It is a **serializable** object.
- It is a **connected** object.
- It is a **Java Bean**.
- Requires a **JDBCRowSet implementation class**.

#### Example:
```java
import javax.sql.rowset.JdbcRowSet;
import com.sun.rowset.JdbcRowSetImpl;
import java.sql.*;

public class JDBCRowSetExample {
    public static void main(String[] args) throws Exception {
        JdbcRowSet jrs = new JdbcRowSetImpl();
        jrs.setUrl("jdbc:mysql://localhost:3306/testdb");
        jrs.setUsername("root");
        jrs.setPassword("password");
        jrs.setCommand("SELECT * FROM users");
        jrs.execute();
        
        while (jrs.next()) {
            System.out.println(jrs.getString("name"));
        }
    }
}
```

### 2. CachedRowSet
- It is a **serializable** object.
- It is a **disconnected** object.
- It is a **Java Bean**.
- Requires a **CachedRowSet implementation class**.

#### Example:
```java
import javax.sql.rowset.CachedRowSet;
import com.sun.rowset.CachedRowSetImpl;

public class CachedRowSetExample {
    public static void main(String[] args) throws Exception {
        CachedRowSet crs = new CachedRowSetImpl();
        crs.setUrl("jdbc:mysql://localhost:3306/testdb");
        crs.setUsername("root");
        crs.setPassword("password");
        crs.setCommand("SELECT * FROM users");
        crs.execute();
        
        while (crs.next()) {
            System.out.println(crs.getString("name"));
        }
    }
}
```

### 3. WebRowSet
- It is similar to **CachedRowSet**.
- Additionally, it allows **writing data to an XML file**.
- `writeXml()` method is used to generate XML.
- **XML (Extensible Markup Language)** is used for data exchange over the internet.

#### Example:
```java
import javax.sql.rowset.WebRowSet;
import com.sun.rowset.WebRowSetImpl;
import java.io.FileOutputStream;

public class WebRowSetExample {
    public static void main(String[] args) throws Exception {
        WebRowSet wrs = new WebRowSetImpl();
        wrs.setUrl("jdbc:mysql://localhost:3306/testdb");
        wrs.setUsername("root");
        wrs.setPassword("password");
        wrs.setCommand("SELECT * FROM users");
        wrs.execute();
        
        FileOutputStream fos = new FileOutputStream("users.xml");
        wrs.writeXml(fos);
    }
}
```

### 4. FilteredRowSet
- It is similar to **CachedRowSet**.
- Additionally, it allows **filtering data** using custom conditions.

#### Example:
```java
import javax.sql.rowset.FilteredRowSet;
import com.sun.rowset.FilteredRowSetImpl;
import java.sql.*;

public class FilteredRowSetExample {
    public static void main(String[] args) throws Exception {
        FilteredRowSet frs = new FilteredRowSetImpl();
        frs.setUrl("jdbc:mysql://localhost:3306/testdb");
        frs.setUsername("root");
        frs.setPassword("password");
        frs.setCommand("SELECT * FROM users");
        frs.execute();
        
        while (frs.next()) {
            if (frs.getInt("age") > 25) {
                System.out.println(frs.getString("name"));
            }
        }
    }
}
```

### 5. JoinRowSet
- It is similar to **CachedRowSet**.
- Additionally, it allows **joining multiple RowSets**.

#### Example:
```java
import javax.sql.rowset.JoinRowSet;
import com.sun.rowset.JoinRowSetImpl;
import javax.sql.rowset.CachedRowSet;
import com.sun.rowset.CachedRowSetImpl;

public class JoinRowSetExample {
    public static void main(String[] args) throws Exception {
        CachedRowSet crs1 = new CachedRowSetImpl();
        crs1.setUrl("jdbc:mysql://localhost:3306/testdb");
        crs1.setCommand("SELECT id, name FROM users");
        crs1.execute();

        CachedRowSet crs2 = new CachedRowSetImpl();
        crs2.setUrl("jdbc:mysql://localhost:3306/testdb");
        crs2.setCommand("SELECT id, salary FROM salaries");
        crs2.execute();

        JoinRowSet jrs = new JoinRowSetImpl();
        jrs.addRowSet(crs1, "id");
        jrs.addRowSet(crs2, "id");

        while (jrs.next()) {
            System.out.println(jrs.getString("name") + " - " + jrs.getInt("salary"));
        }
    }
}
```

