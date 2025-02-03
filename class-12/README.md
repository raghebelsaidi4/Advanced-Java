# RowSets

A `RowSet` is an object that encapsulates a set of rows from a database. It is generated based on an SQL query. When a `RowSet` is created, its pointer (or cursor) initially points to **before the first record**.

## Types of RowSets
There are five types of RowSets, all of which are interfaces in the `javax.sql.rowset` package:

1. **JDBCRowSet** - Connected `RowSet` that operates like `ResultSet`.
2. **CachedRowSet** - Disconnected `RowSet` that can be serialized and shared.
3. **WebRowSet** - XML representation of `RowSet`.
4. **FilteredRowSet** - Allows filtering rows based on a condition.
5. **JoinRowSet** - Supports joining multiple `RowSet` objects.

### Example of Using CachedRowSet
```java
import javax.sql.rowset.CachedRowSet;
import com.sun.rowset.CachedRowSetImpl;
import java.sql.*;

public class RowSetExample {
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

---

# Differences between ResultSet & RowSets

| Feature | ResultSet | RowSet |
|---------|----------|--------|
| Connection | Requires active connection | Can be connected or disconnected |
| Serialization | Not serializable | Serializable (except JDBCRowSet) |
| Memory Efficiency | Holds database connection | Can store data in memory |
| Filtering | No filtering capability | `FilteredRowSet` allows filtering |
| XML Support | No XML support | `WebRowSet` provides XML support |

---

# Serialization

Serialization is the process of converting an object into a series of bits for storage or transmission.

## Use Cases of Serialization:
1. Writing an object to a file.
2. Reading an object from a file.
3. Sending an object over a network.
4. Receiving an object from a network.

### Making a Class Serializable
To make a class serializable, it must implement the `java.io.Serializable` interface. This interface is known as a **marker interface** (or tag interface) because it has no methods or fields.

### Example of Serialization
```java
import java.io.*;

class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    String name;
    int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class SerializationExample {
    public static void main(String[] args) {
        try {
            Person p = new Person("John Doe", 30);
            FileOutputStream fileOut = new FileOutputStream("person.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(p);
            out.close();
            fileOut.close();
            System.out.println("Object has been serialized");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### Example of Deserialization
```java
public class DeserializationExample {
    public static void main(String[] args) {
        try {
            FileInputStream fileIn = new FileInputStream("person.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Person p = (Person) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Deserialized Person: " + p.name + ", " + p.age);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
```
