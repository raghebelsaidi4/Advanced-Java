# Cookies vs URL Rewriting vs HttpSessions

## Cookies
- **Client State Info**: Stored at the client side in browser memory.
- **Data Type**: Supports `String` type data only.
- **Lifetime**: By default, cookies are deleted when the browser window is closed. You can set a time interval using the `setMaxAge()` method of the `Cookie` class.
- **Visibility**: Client state info is not displayed in the browser window.
- **Security**: Not secure because cookies can be viewed by users through browser settings.
- **Size Limitation**: The size of data is limited.
- **Dependency**: Fails if cookies are disabled in the browser.

## URL Rewriting
- **Client State Info**: Appended to the URL.
- **Data Type**: Supports `String` type data only.
- **Lifetime**: Client state info is lost when control is passed to the next servlet.
- **Visibility**: Client state info is displayed in the browser's address bar.
- **Security**: Not secure because client state info is visible in the URL.
- **Size Limitation**: The size of data is limited.
- **Dependency**: Always works, regardless of browser settings.

---

## HttpSessions
- **Client State Info**: Stored in server memory.
- **Session ID**: A session ID is created by the web container to recognize the client.
- **Lifetime**: Session ID is passed to the client system with the login response and destroyed upon logout.
- **Implementation**: Requires either cookies or URL rewriting to maintain the session ID.

### Two Ways to Implement HttpSessions:
1. **HttpSession with Cookies**
2. **HttpSession with URL Rewriting**

---

### 1. HttpSession with Cookies
- **Client State Info**: Stored in server memory (session variables).
- **Session ID**: Stored in a cookie on the client system.
- **Lifetime**: Sessions are deleted after 30 minutes (default in Tomcat). You can set the time interval using the `setMaxInactiveInterval()` method of the `HttpSession` interface.

**Example:**

**com.ragheb.LoginServlet.java**
```java
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

public class com.ragheb.LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");

        // Create a session
        HttpSession session = req.getSession();
        session.setAttribute("username", username);

        // Set session timeout to 1 hour (3600 seconds)
        session.setMaxInactiveInterval(3600);

        resp.getWriter().write("Login successful! Session created.");
    }
}
```

**LogoutServlet.java**
```java
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Invalidate the session
        HttpSession session = req.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        resp.getWriter().write("Logged out successfully! Session destroyed.");
    }
}
```

---

### 2. HttpSession with URL Rewriting
- **Client State Info**: Stored in server memory (session variables).
- **Session ID**: Appended to the URL using the `encodeURL()` method of the `HttpServletResponse` interface.

**Example:**

**com.ragheb.LoginServlet.java**
```java
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

public class com.ragheb.LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");

        // Create a session
        HttpSession session = req.getSession();
        session.setAttribute("username", username);

        // Redirect to another page with URL rewriting
        String redirectURL = resp.encodeRedirectURL("welcome.jsp");
        resp.sendRedirect(redirectURL);
    }
}
```

**welcome.jsp**
```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
    <h1>Welcome, <%= session.getAttribute("username") %>!</h1>
</body>
</html>
```

---

## Differences Between HttpSession with Cookies and URL Rewriting

| Feature                  | HttpSession with Cookies                          | HttpSession with URL Rewriting                  |
|--------------------------|--------------------------------------------------|------------------------------------------------|
| **Session ID Storage**   | Stored in a cookie on the client system.         | Appended to the URL.                           |
| **Implementation**       | Session ID is stored implicitly (default).       | Session ID is appended explicitly using `encodeURL()`. |
| **Dependency**           | Fails if cookies are disabled.                   | Always works, regardless of browser settings.  |

---

## Differences Between Cookies and HttpSessions

| Feature                  | Cookies                                          | HttpSessions                                   |
|--------------------------|--------------------------------------------------|------------------------------------------------|
| **Storage Location**     | Stored at the client side.                       | Stored at the server side.                     |
| **Data Type**            | Supports `String` type only.                     | Supports all types of data.                    |
| **Size Limitation**      | Limited size.                                    | No size limitation.                            |
| **Lifetime**             | Deleted when the browser is closed (default).    | Deleted after 30 minutes (default in Tomcat).  |
| **Time Interval**        | Set using `setMaxAge()`.                         | Set using `setMaxInactiveInterval()`.          |
| **Security**             | Not secure (visible in browser settings).        | Secure (stored on the server).                 |
| **Dependency**           | Can be implemented independently.                | Depends on cookies or URL rewriting.           |
| **Session ID**           | No session ID created.                           | Session ID is created.                         |
