# Hidden Form Fields

Hidden form fields are a session tracking mechanism where client-side state information is stored in hidden input fields within an HTML form. This method is easy to implement but has limitations in terms of security and data size.

## Features of Hidden Form Fields
- **Client State Info**: Stored in hidden fields within an HTML form.
- **Implementation**: Requires only HTML code.
- **Data Type**: Supports text only.
- **Size Limitation**: The size of data is limited.
- **Lifetime**: It is not possible to set a time interval.
- **Security**: Not secure because hidden fields can be viewed by users through the "View Page Source" option.
- **Form Submission**: Always requires form submission.

---

## Example of Hidden Form Fields

**index.html**
```html
<!DOCTYPE html>
<html>
<head>
    <title>Hidden Form Fields Example</title>
</head>
<body>
    <form action="processForm" method="post">
        <input type="hidden" name="username" value="JohnDoe">
        <input type="hidden" name="sessionID" value="12345">
        <input type="submit" value="Submit">
    </form>
</body>
</html>
```

**ProcessFormServlet.java**
```java
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProcessFormServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Retrieve hidden form fields
        String username = req.getParameter("username");
        String sessionID = req.getParameter("sessionID");

        // Send a response to the client
        resp.getWriter().write("Username: " + username + "<br>");
        resp.getWriter().write("Session ID: " + sessionID);
    }
}
```

---

# Servlet URL Mapping

There are three ways to map servlets in the `web.xml` file:

1. **Exact Match**
    - The URL pattern must exactly match the specified path.
    - Example:
      ```xml
      <url-pattern>/time</url-pattern>
      ```
      Browser URL: `http://localhost:8080/example/time`

2. **Directory Match**
    - The URL pattern matches a directory and all its sub-paths.
    - Example:
      ```xml
      <url-pattern>/demo/*</url-pattern>
      ```
      Browser URL: `http://localhost:8080/demo/test` or `http://localhost:8080/demo/sample`

3. **Extension Match**
    - The URL pattern matches any URL with the specified extension.
    - Example:
      ```xml
      <url-pattern>*.cpp</url-pattern>
      ```
      Browser URL: `http://localhost:8080/demo/test.cpp` or `http://localhost:8080/demo/sample.cpp`

---

# Welcome File Configuration

Welcome files are default files that are displayed when a user accesses a directory without specifying a file name. They are configured using the `<welcome-file-list>` and `<welcome-file>` tags in `web.xml`.

## Default Welcome Files
- `index.html`
- `index.htm`
- `index.jsp`
- `default.html`
- `default.jsp`

---

## Example of Welcome File Configuration

**web.xml**
```xml
<welcome-file-list>
    <welcome-file>index.html</welcome-file>
    <welcome-file>index.jsp</welcome-file>
    <welcome-file>default.html</welcome-file>
</welcome-file-list>
```

**index.html**
```html
<!DOCTYPE html>
<html>
<head>
    <title>Welcome Page</title>
</head>
<body>
    <h1>Welcome to the Home Page!</h1>
</body>
</html>
```

---

# `<load-on-startup>` Tag

The `<load-on-startup>` tag is used to instruct the web container to load, instantiate, and initialize a servlet when the web application is deployed or the server starts. This is useful for preloading servlets that are frequently used.

- **Note**: Zero and negative numbers are not considered.

---

## Example of `<load-on-startup>`

**web.xml**
```xml
<servlet>
    <servlet-name>PreloadServlet</servlet-name>
    <servlet-class>com.example.PreloadServlet</servlet-class>
    <load-on-startup>1</load-on-startup>
</servlet>
```

**PreloadServlet.java**
```java
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.ServletException;

public class PreloadServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("PreloadServlet initialized!");
    }
}
```
**note**: zero & negative numbers are not considered

---

