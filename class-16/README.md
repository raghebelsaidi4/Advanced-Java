# Auto Loading Driver Class (JDBC 4.0)

With JDBC 4.0, the JDBC driver class is automatically loaded when a connection is established. This eliminates the need to explicitly call `Class.forName()` in the program.

### Example Without Explicit Driver Loading
```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AutoLoadingDriverExample {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "password");
            System.out.println("Connection established successfully.");
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
```

---

# Introduction to Servlet
A **Servlet** is a Java programming language specification for developing web applications. It runs on a **Java EE server** and extends the capabilities of a web server by handling requests and generating dynamic responses.

### Example: Simple Servlet
```java
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>Hello, Servlet!</h1>");
    }
}
```

---

# Web Applications
A **Web Application** is a distributed application that runs on a **browser and a server**. It allows users to interact with a central server via a web interface.

### Example: Web Application Components
- **Client:** Web browser
- **Server:** Tomcat, Jetty, WildFly, etc.
- **Servlets:** Handle HTTP requests and responses
- **JSP (Java Server Pages):** Generate dynamic web pages
- **Databases:** Store application data

---

# Distributed Applications
A **Distributed Application** is an application that is installed on one computer but runs on multiple computers. This architecture improves **scalability**, **performance**, and **availability**.

### Example: Characteristics of a Distributed Application
- **Client-Server Model:** The app is hosted on a server and accessed by clients.
- **Load Balancing:** Distributes requests across multiple servers.
- **Microservices Architecture:** Divides an application into independent services.

---


