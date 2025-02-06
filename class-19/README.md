# Servlet API

The **Servlet API** is a Java API used to develop web applications. It provides classes and interfaces for handling HTTP requests and responses, managing sessions, and interacting with the web container. The Servlet API is divided into two main packages:

1. **`javax.servlet` or `jakarta.servlet`**
2. **`javax.servlet.http` or `jakarta.servlet.http`**

---

## 1. `javax.servlet` or `jakarta.servlet` Package

This package contains classes and interfaces for generic servlet functionality, which is not specific to HTTP.

### Classes:
- **`GenericServlet`**: An abstract class that provides a generic implementation of the `Servlet` interface.
- **`ServletInputStream`**: Used to read binary data from the client request.
- **`ServletOutputStream`**: Used to write binary data to the client response.
- **`ServletException`**: Thrown when a servlet encounters a problem.
- **`UnavailableException`**: Thrown when a servlet is temporarily or permanently unavailable.

### Interfaces:
- **`Servlet`**: Defines the life cycle methods (`init()`, `service()`, `destroy()`).
- **`ServletRequest`**: Represents the client request.
- **`ServletResponse`**: Represents the client response.
- **`ServletConfig`**: Provides configuration information to the servlet.
- **`ServletContext`**: Provides information about the web application.
- **`RequestDispatcher`**: Used to forward or include requests.
- **`SingleThreadModel`**: Ensures that only one thread executes the servlet's `service()` method at a time (deprecated).

---

## 2. `javax.servlet.http` or `jakarta.servlet.http` Package

This package contains classes and interfaces specific to HTTP servlets.

### Classes:
- **`HttpServlet`**: An abstract class that extends `GenericServlet` and provides methods for handling HTTP requests (`doGet()`, `doPost()`, etc.).
- **`Cookie`**: Represents an HTTP cookie used for session management.

### Interfaces:
- **`HttpServletRequest`**: Extends `ServletRequest` and provides HTTP-specific request information.
- **`HttpServletResponse`**: Extends `ServletResponse` and provides HTTP-specific response functionality.
- **`HttpSession`**: Represents a session between the client and the server.

---

## Servlet API in Tomcat

The Servlet API is part of the `servlet-api.jar` file, which is included in the Tomcat web server. To use the Servlet API, you need to include this JAR file in your project's classpath.

---

## Steps to Download and Start Tomcat Web Server

### Download Tomcat:
1. Go to the [Apache Tomcat website](https://tomcat.apache.org/).
2. Download the latest stable version of Tomcat (e.g., Tomcat 10.x).
3. Extract the downloaded ZIP file to a directory on your computer.

### Start Tomcat:
1. Navigate to the `bin` directory inside the Tomcat installation folder.
2. Run the appropriate startup script:
    - On Windows: Run `startup.bat`.
    - On Linux/macOS: Run `startup.sh`.
3. Open a browser and go to `http://localhost:8080` to verify that Tomcat is running.

---

## `jakarta.servlet.Servlet` Interface

The `Servlet` interface defines the life cycle methods for a servlet:

1. **`init(ServletConfig config)`**: Called by the web container to initialize the servlet.
2. **`service(ServletRequest req, ServletResponse res)`**: Handles client requests.
3. **`destroy()`**: Called by the web container to clean up resources.
4. **`getServletConfig()`**: Returns the `ServletConfig` object.
5. **`getServletInfo()`**: Returns information about the servlet (e.g., author, version).

---

## Ways to Write a Servlet Program

There are three ways to write a servlet program:

1. **Implementing `jakarta.servlet.Servlet` Interface**:
    - Directly implement all methods of the `Servlet` interface.
    - Example:
      ```java
      public class MyServlet implements Servlet {
          public void init(ServletConfig config) throws ServletException {}
          public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {}
          public void destroy() {}
          public ServletConfig getServletConfig() { return null; }
          public String getServletInfo() { return null; }
      }
      ```

2. **Extending `jakarta.servlet.GenericServlet` Class**:
    - Extend the `GenericServlet` class, which provides default implementations for most methods.
    - Example:
      ```java
      public class MyServlet extends GenericServlet {
          public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
              res.getWriter().write("Hello from GenericServlet!");
          }
      }
      ```

3. **Extending `jakarta.servlet.http.HttpServlet` Class**:
    - Extend the `HttpServlet` class, which is specifically designed for HTTP servlets.
    - Example:
      ```java
      public class MyServlet extends HttpServlet {
          protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
              res.getWriter().write("Hello from HttpServlet!");
          }
      }
      ```

---

## `jakarta.servlet.ServletResponse` Interface

The `ServletResponse` interface provides methods for sending data to the client. Key methods include:

- **`getWriter()`**: Returns a `PrintWriter` object for sending text data.
- **`getOutputStream()`**: Returns a `ServletOutputStream` object for sending binary data.
- **`setContentType(String type)`**: Sets the content type of the response (e.g., `text/html`).

---

## JAR Tool

The **JAR tool** is a JDK utility used to create archive files:
- **JAR (Java Archive)**: Used to package Java classes and resources.
- **WAR (Web Archive)**: Used to package web applications.
- **EAR (Enterprise Archive)**: Used to package enterprise applications.
- **RAR (Resource Archive)**: Used to package resource adapters.

### Example: Create a WAR File
```bash
jar -cvf myapp.war *
```

---

## Steps to Deploy a Web Application (WAR File)

1. Copy the `.war` file to the `webapps` directory in the Tomcat installation folder.
2. Start Tomcat (if not already running).
3. Tomcat will automatically deploy the web application.

---

## Steps to Run a Web Application

1. Start Tomcat.
2. Open a browser and navigate to the application URL (e.g., `http://localhost:8080/myapp`).
3. Interact with the web application through the browser.

---

## Example: Simple Servlet Program

### `HelloServlet.java` (Extending `HttpServlet`)
```java
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class HelloServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<html><body>");
        out.println("<h1>Hello, World!</h1>");
        out.println("</body></html>");
    }
}
```

### `web.xml` (Deployment Descriptor)
```xml
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee" version="4.0">
    <servlet>
        <servlet-name>HelloServlet</servlet-name>
        <servlet-class>HelloServlet</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>HelloServlet</servlet-name>
        <url-pattern>/hello</url-pattern>
    </servlet-mapping>
</web-app>
```

### Steps to Run:
1. Compile the servlet and place the `.class` file in the `WEB-INF/classes` directory.
2. Package the application into a `.war` file.
3. Deploy the `.war` file to Tomcat.
4. Access the servlet at `http://localhost:8080/myapp/hello`.

---