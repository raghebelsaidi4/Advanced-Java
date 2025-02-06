# HTTP (HyperText Transfer Protocol)

HTTP is a protocol used to transfer hypertext (HTML) between a browser (client) and a server. It is the foundation of data communication on the World Wide Web.

- **HyperText**: Refers to HTML (HyperText Markup Language), which is used to create web pages.
- **Communication**: HTTP enables browsers and servers to communicate by sending requests and receiving responses.

---

## Localhost

- **Localhost** is a domain name that refers to the current computer.
- If the server is installed on the same machine as the client, you can use `localhost` as the domain name.
- If the server is installed on a different machine, use the computer's name or IP address as the domain name.

---

## Port Numbers

A **port number** is used to identify a specific service running on a server. Some common port numbers include:

- **Tomcat Web Server**: Default port is `8080`.
- **JBoss Application Server**: Default port is `8080`.
- **Oracle Database Server**: Default port is `8080`.
- **WebLogic Server**: Default port is `7001`.

### How to Change the Port Number in Tomcat

1. Open the `conf/server.xml` file in the Tomcat installation directory.
2. Locate the `<Connector>` tag:
   ```xml
   <Connector port="8080" protocol="HTTP/1.1" connectionTimeout="20000" redirectPort="8443" />
   ```
3. Change the `port` attribute to the desired port number (e.g., `8082`):
   ```xml
   <Connector port="8082" protocol="HTTP/1.1" connectionTimeout="20000" redirectPort="8443" />
   ```
4. Save the file and restart Tomcat.

---

## `web.xml` (Deployment Descriptor)

The `web.xml` file is a configuration file used to configure servlets, filters, listeners, JSPs, welcome files, initialization parameters, and context parameters.

### Example: `web.xml` File

```xml
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee" version="4.0">
    <!-- Servlet Configuration -->
    <servlet>
        <servlet-name>HelloServlet</servlet-name>
        <servlet-class>com.example.HelloServlet</servlet-class>
        <init-param>
            <param-name>message</param-name>
            <param-value>Welcome to My Web App!</param-value>
        </init-param>
    </servlet>

    <!-- Servlet Mapping -->
    <servlet-mapping>
        <servlet-name>HelloServlet</servlet-name>
        <url-pattern>/hello</url-pattern>
    </servlet-mapping>

    <!-- Welcome File List -->
    <welcome-file-list>
        <welcome-file>index.html</welcome-file>
        <welcome-file>index.jsp</welcome-file>
    </welcome-file-list>

    <!-- Context Parameters -->
    <context-param>
        <param-name>appName</param-name>
        <param-value>MyWebApp</param-value>
    </context-param>
</web-app>
```

### Explanation:
1. **Servlet Configuration**:
    - `<servlet>`: Defines a servlet with a name and class.
    - `<init-param>`: Specifies initialization parameters for the servlet.

2. **Servlet Mapping**:
    - `<servlet-mapping>`: Maps the servlet to a URL pattern (e.g., `/hello`).

3. **Welcome File List**:
    - `<welcome-file-list>`: Specifies the default files to load when the application is accessed (e.g., `index.html`, `index.jsp`).

4. **Context Parameters**:
    - `<context-param>`: Defines parameters that are accessible to the entire web application.

---

## MIME (Multipurpose Internet Mail Extensions)

MIME is a standard used by browsers and servers to identify the type of content being transferred. It ensures that the browser can correctly interpret and display the content.

### Common MIME Types:
1. **`text/html`**: Default MIME type for HTML content.
2. **`application/pdf`**: For PDF files.
3. **`image/jpeg`**: For JPEG images.
4. **`image/png`**: For PNG images.
5. **`application/msword`**: For Microsoft Word documents.
6. **`application/json`**: For JSON data.
7. **`text/css`**: For CSS files.
8. **`text/javascript`**: For JavaScript files.

### Example: Setting MIME Type in a Servlet

```java
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class MimeTypeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // Set MIME type to "application/json"
        res.setContentType("application/json");

        // Write JSON response
        PrintWriter out = res.getWriter();
        out.println("{\"message\": \"Hello, World!\"}");
    }
}
```

---

## Example: Complete Web Application

### Folder Structure
```
MyWebApp/
│
├── WEB-INF/
│   ├── web.xml
│   ├── classes/
│   │   └── com/
│   │       └── example/
│   │           └── HelloServlet.class
│   └── lib/
│
├── index.html
└── css/
    └── styles.css
```

### `index.html`
```html
<!DOCTYPE html>
<html>
<head>
    <title>My Web App</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <h1>Welcome to My Web App!</h1>
    <a href="/hello">Go to HelloServlet</a>
</body>
</html>
```

### `HelloServlet.java`
```java
package com.example;

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

### `web.xml`
```xml
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee" version="4.0">
    <servlet>
        <servlet-name>HelloServlet</servlet-name>
        <servlet-class>com.example.HelloServlet</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>HelloServlet</servlet-name>
        <url-pattern>/hello</url-pattern>
    </servlet-mapping>
    <welcome-file-list>
        <welcome-file>index.html</welcome-file>
    </welcome-file-list>
</web-app>
```

---

## Conclusion

- **HTTP** is the protocol used for communication between browsers and servers.
- **Localhost** refers to the current machine, and **port numbers** identify specific services.
- The **`web.xml`** file is used to configure web applications.
- **MIME types** ensure that browsers and servers correctly interpret content.

