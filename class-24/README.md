# Forwarding vs Redirecting in Servlets

## Definitions

### Forwarding
- **Forwarding** is a mechanism where the request and response of one servlet are passed to another servlet, JSP, or HTML page.
- The server implicitly forwards the request and response to the target resource.
- Both data and control are passed to the next servlet.
- Only one pair of request and response is created by the web container.
- The URL in the browser's address bar does not change.
- Forwarding works within the same server only.

### Redirecting
- **Redirecting** is a mechanism where the server instructs the browser to execute a new URL.
- Only control is passed to the next resource.
- A separate pair of request and response is created by the web container for each resource.
- The URL in the browser's address bar changes.
- Redirecting can work within the same server or between different servers.

---

## Examples

### Servlet Forwarding Example

**Servlet1.java**
```java
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Set an attribute to pass data to the next servlet
        req.setAttribute("message", "Hello from Servlet1!");

        // Forward the request and response to Servlet2
        RequestDispatcher dispatcher = req.getRequestDispatcher("/servlet2");
        dispatcher.forward(req, resp);
    }
}
```

**Servlet2.java**
```java
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Retrieve the attribute set by Servlet1
        String message = (String) req.getAttribute("message");

        // Send a response to the client
        resp.getWriter().write("Message from Servlet1: " + message);
    }
}
```

**web.xml**
```xml
<servlet>
    <servlet-name>Servlet1</servlet-name>
    <servlet-class>Servlet1</servlet-class>
</servlet>
<servlet>
    <servlet-name>Servlet2</servlet-name>
    <servlet-class>Servlet2</servlet-class>
</servlet>

<servlet-mapping>
    <servlet-name>Servlet1</servlet-name>
    <url-pattern>/servlet1</url-pattern>
</servlet-mapping>
<servlet-mapping>
    <servlet-name>Servlet2</servlet-name>
    <url-pattern>/servlet2</url-pattern>
</servlet-mapping>
```

---

### Servlet Redirecting Example

**Servlet1.java**
```java
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Redirect the request to Servlet2
        resp.sendRedirect("servlet2");
    }
}
```

**Servlet2.java**
```java
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Send a response to the client
        resp.getWriter().write("Welcome to Servlet2!");
    }
}
```

**web.xml**
```xml
<servlet>
    <servlet-name>Servlet1</servlet-name>
    <servlet-class>Servlet1</servlet-class>
</servlet>
<servlet>
    <servlet-name>Servlet2</servlet-name>
    <servlet-class>Servlet2</servlet-class>
</servlet>

<servlet-mapping>
    <servlet-name>Servlet1</servlet-name>
    <url-pattern>/servlet1</url-pattern>
</servlet-mapping>
<servlet-mapping>
    <servlet-name>Servlet2</servlet-name>
    <url-pattern>/servlet2</url-pattern>
</servlet-mapping>
```

---

# Session Tracking

Session tracking is a mechanism used by servlets to maintain client state information across multiple requests from the same user over a period of time.

- A **session** is the time period between a user's login and logout.
- Client state information can include username, password, examination ID, account number, shopping items, etc.
- Session tracking is required because the HTTP protocol is stateless and does not maintain state information.

---

## Session Tracking Methods

1. **Cookies**
2. **URL Rewriting**
3. **Http Sessions**
4. **Hidden Form Fields**

---

### 1. Cookies

Cookies are small pieces of information stored on the client side to maintain client state information.

**Example:**

**CookieServlet.java**
```java
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Create a cookie
        Cookie cookie = new Cookie("username", "JohnDoe");

        // Set the cookie's maximum age (in seconds)
        cookie.setMaxAge(60 * 60 * 24); // 1 day

        // Add the cookie to the response
        resp.addCookie(cookie);

        // Send a response to the client
        resp.getWriter().write("Cookie has been set!");
    }
}
```

**ReadCookieServlet.java**
```java
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ReadCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Retrieve cookies from the request
        Cookie[] cookies = req.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    resp.getWriter().write("Username from cookie: " + cookie.getValue());
                }
            }
        } else {
            resp.getWriter().write("No cookies found!");
        }
    }
}
```

---

### 2. URL Rewriting

URL rewriting appends session information to the URL as a query string.

**Example:**

**URLRewriteServlet.java**
```java
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class URLRewriteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = "JohnDoe";

        // Append session information to the URL
        String url = "nextServlet?username=" + username;

        // Redirect to the next servlet
        resp.sendRedirect(url);
    }
}
```

---

### 3. Http Sessions

Http sessions are used to store user-specific data on the server side.

**Example:**

**SessionServlet.java**
```java
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

public class SessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Create or retrieve the session
        HttpSession session = req.getSession();

        // Store data in the session
        session.setAttribute("username", "JohnDoe");

        // Send a response to the client
        resp.getWriter().write("Session data has been set!");
    }
}
```

---

### 4. Hidden Form Fields

Hidden form fields store session information in HTML forms.

**Example:**

**HiddenFormServlet.java**
```java
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HiddenFormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<form action='nextServlet' method='post'>");
        out.println("<input type='hidden' name='username' value='JohnDoe'>");
        out.println("<input type='submit' value='Submit'>");
        out.println("</form>");
    }
}
```
