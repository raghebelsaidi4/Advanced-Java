# Connected Object
A **connected object** means the object is always connected to the database.

### Example:
```java
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "user", "password");
Statement stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery("SELECT * FROM users");
while (rs.next()) {
    System.out.println(rs.getString("name"));
}
// Connection remains open
```

---

# Disconnected Object
A **disconnected object** means the connection is closed after retrieving the object.

### Example:
```java
CachedRowSet crs = new CachedRowSetImpl();
crs.setUrl("jdbc:mysql://localhost:3306/testdb");
crs.setUsername("user");
crs.setPassword("password");
crs.setCommand("SELECT * FROM users");
crs.execute();
// Connection closed, but data is still available in memory
while (crs.next()) {
    System.out.println(crs.getString("name"));
}
```

---

# Java Bean
A **Java Bean** is a reusable software component that follows specific conventions.

## Java Bean Rules:
1. The class must be **public**.
2. The class must implement `java.io.Serializable`.
3. The class must be in a **package**.
4. The class must contain a **public default constructor**.
5. All instance variables (properties) must be **private**.
6. Each property must have **getter and setter methods**.
7. All getter and setter methods must be **public**.

### Example of a Java Bean:
```java
package mypackage;

import java.io.Serializable;

public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;

    public Person() {} // Default constructor

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
```


