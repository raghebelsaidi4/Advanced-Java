# Object Creation Order by Web Container

The web container creates objects in a specific order when a web application is deployed and requests are made. Here's the order:

1. **ServletContext**:
    - Created by the web container when the web application is deployed on the server.
    - Represents the entire web application and is shared across all servlets.

2. **User-Defined Servlet**:
    - Created by the web container when the first request comes to the servlet.
    - The servlet is initialized using the `init()` method.

3. **ServletConfig**:
    - Created by the web container when the `init()` method of the servlet is called.
    - Provides configuration information specific to the servlet.

4. **ServletRequest & ServletResponse**:
    - Created by the web container for every request.
    - `ServletRequest` represents the client's request, and `ServletResponse` represents the response sent back to the client.

---

## `jakarta.servlet.ServletRequest`

The `ServletRequest` interface is used to retrieve data sent by the client in the request. It provides methods to access request parameters, headers, and other information.

### Key Methods:
1. **`getParameter(String name)`**:
    - Returns the value of a request parameter as a `String`.
    - Example:
      ```java
      String username = request.getParameter("username");
      ```

2. **`getParameterValues(String name)`**:
    - Returns an array of values for a request parameter (useful for multi-select inputs).
    - Example:
      ```java
      String[] hobbies = request.getParameterValues("hobbies");
      ```

3. **`getParameterMap()`**:
    - Returns a `Map` of all request parameters.
    - Example:
      ```java
      Map<String, String[]> params = request.getParameterMap();
      ```

4. **`getAttribute(String name)`**:
    - Returns the value of an attribute set in the request.
    - Example:
      ```java
      Object attribute = request.getAttribute("myAttribute");
      ```

5. **`setAttribute(String name, Object value)`**:
    - Sets an attribute in the request.
    - Example:
      ```java
      request.setAttribute("myAttribute", "Hello");
      ```

6. **`getRequestDispatcher(String path)`**:
    - Returns a `RequestDispatcher` object for forwarding or including requests.
    - Example:
      ```java
      RequestDispatcher dispatcher = request.getRequestDispatcher("/welcome.jsp");
      dispatcher.forward(request, response);
      ```

---

## Example: HTML Form and Servlet

### `index.html`
```html
<!DOCTYPE html>
<html>
<head>
    <title>Form Example</title>
</head>
<body>
    <form action="submit" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username"><br><br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password"><br><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
```

### `FormServlet.java`
```java
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class FormServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Submitted Data</h1>");
        out.println("<p>Username: " + username + "</p>");
        out.println("<p>Password: " + password + "</p>");
        out.println("</body></html>");
    }
}
```

---

## HTTP Methods

There are **7 HTTP methods**:
1. **GET** (default): Retrieves data from the server.
2. **POST**: Submits data to the server.
3. **DELETE**: Deletes a resource on the server.
4. **HEAD**: Retrieves headers without the response body.
5. **PUT**: Updates a resource on the server.
6. **OPTIONS**: Returns the HTTP methods supported by the server.
7. **TRACE**: Echoes the received request for debugging.

---

## Differences Between GET and POST

| **GET**                                | **POST**                                |
|----------------------------------------|-----------------------------------------|
| Data is appended to the URL.           | Data is sent in the request body.       |
| Limited data size (URL length limit).  | No data size limit.                     |
| Not secure (data visible in URL).      | More secure (data hidden in body).      |
| Can be bookmarked.                     | Cannot be bookmarked.                   |
| Used for retrieving data.              | Used for submitting data.               |

---

## Differences Between `GenericServlet` and `HttpServlet`

| **GenericServlet**                     | **HttpServlet**                         |
|----------------------------------------|-----------------------------------------|
| Protocol-independent.                  | HTTP protocol-specific.                 |
| Supports common services (e.g., forwarding, including). | Supports HTTP-specific services (e.g., redirecting, session tracking). |
| Uses common services only.             | Uses both common and HTTP-specific services (inherits from `GenericServlet`). |

---

## `jakarta.servlet.http.HttpServlet`

The `HttpServlet` class extends `GenericServlet` and provides methods to handle HTTP-specific requests.

### Key Methods:
1. **`doGet(HttpServletRequest req, HttpServletResponse res)`**:
    - Handles GET requests.
    - Example:
      ```java
      protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
          res.getWriter().write("Handling GET request");
      }
      ```

2. **`doPost(HttpServletRequest req, HttpServletResponse res)`**:
    - Handles POST requests.
    - Example:
      ```java
      protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
          res.getWriter().write("Handling POST request");
      }
      ```

3. **`service(HttpServletRequest req, HttpServletResponse res)`**:
    - Handles both GET and POST requests.
    - Example:
      ```java
      protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
          res.getWriter().write("Handling all requests");
      }
      ```

---

## Example: Handling GET and POST Requests

### `MyServlet.java`
```java
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class MyServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.getWriter().write("Handling GET request");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.getWriter().write("Handling POST request");
    }
}
```

---

## Conclusion

- The web container creates objects in a specific order: `ServletContext`, user-defined servlets, `ServletConfig`, and `ServletRequest`/`ServletResponse`.
- `ServletRequest` is used to retrieve request parameters and data.
- HTTP methods like GET and POST are used for different purposes, with key differences in how data is sent and handled.
- `GenericServlet` is protocol-independent, while `HttpServlet` is HTTP-specific and provides methods like `doGet()` and `doPost()` to handle requests.
