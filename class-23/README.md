# Web.xml Configuration File

The `web.xml` file is a deployment descriptor used in Java web applications to configure servlets, JSPs, welcome files, initialization parameters, context parameters, and more. It is an XML file that resides in the `WEB-INF` directory of a web application.

## Initialization Parameters

Initialization parameters are used to initialize servlets. These parameters are specific to a particular servlet and are configured in the `web.xml` file using the `<init-param>`, `<param-name>`, and `<param-value>` tags.

### Example of Initialization Parameters in `web.xml`:

```xml
<servlet>
    <servlet-name>MyServlet</servlet-name>
    <servlet-class>com.example.MyServlet</servlet-class>
    <init-param>
        <param-name>databaseURL</param-name>
        <param-value>jdbc:mysql://localhost:3306/mydb</param-value>
    </init-param>
    <init-param>
        <param-name>username</param-name>
        <param-value>root</param-value>
    </init-param>
    <init-param>
        <param-name>password</param-name>
        <param-value>password</param-value>
    </init-param>
</servlet>
```

### Retrieving Initialization Parameters in a Servlet:

To retrieve these parameters in a servlet, you can use the `getInitParameter(String name)` method of the `jakarta.servlet.ServletConfig` interface.

```java
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyServlet extends HttpServlet {
    private String databaseURL;
    private String username;
    private String password;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        databaseURL = config.getInitParameter("databaseURL");
        username = config.getInitParameter("username");
        password = config.getInitParameter("password");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("Database URL: " + databaseURL + "\n");
        resp.getWriter().write("Username: " + username + "\n");
        resp.getWriter().write("Password: " + password + "\n");
    }
}
```

## Context Parameters

Context parameters are used to initialize the entire web application. These parameters are common to all servlets within the web application and are configured in the `web.xml` file using the `<context-param>`, `<param-name>`, and `<param-value>` tags.

### Example of Context Parameters in `web.xml`:

```xml
<context-param>
    <param-name>appName</param-name>
    <param-value>MyWebApp</param-value>
</context-param>
<context-param>
    <param-name>appVersion</param-name>
    <param-value>1.0.0</param-value>
</context-param>
```

### Retrieving Context Parameters in a Servlet:

To retrieve context parameters in a servlet, you can use the `getInitParameter(String name)` method of the `jakarta.servlet.ServletContext` interface.

```java
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyServlet extends HttpServlet {
    private String appName;
    private String appVersion;

    @Override
    public void init() throws ServletException {
        ServletContext context = getServletContext();
        appName = context.getInitParameter("appName");
        appVersion = context.getInitParameter("appVersion");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("Application Name: " + appName + "\n");
        resp.getWriter().write("Application Version: " + appVersion + "\n");
    }
}
```

## ServletConfig vs ServletContext

| Feature                | ServletConfig                          | ServletContext                         |
|------------------------|----------------------------------------|----------------------------------------|
| **Creation**           | Created by the web container when the `init()` method of a servlet is called. | Created by the web container when the web application is deployed. |
| **Scope**              | Specific to a single servlet.          | Common to all servlets in the web application. |
| **Memory**             | Memory is specific to the servlet.     | Memory is shared across all servlets.  |
| **Usage**              | Used to retrieve initialization parameters from `web.xml`. | Used to retrieve context parameters from `web.xml`. |
| **Methods**            | `getInitParameter(String name)`        | `getInitParameter(String name)`        |

### Example of ServletConfig and ServletContext in a Servlet:

```java
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyServlet extends HttpServlet {
    private String databaseURL; // ServletConfig parameter
    private String appName;     // ServletContext parameter

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        // Retrieving ServletConfig parameter
        databaseURL = config.getInitParameter("databaseURL");

        // Retrieving ServletContext parameter
        ServletContext context = config.getServletContext();
        appName = context.getInitParameter("appName");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("Database URL: " + databaseURL + "\n");
        resp.getWriter().write("Application Name: " + appName + "\n");
    }
}
