# JSP EL (Expression Language)

JSP EL stands for **Jakarta Server Pages Expression Language**. It was introduced with **JSTL (Jakarta Standard Tag Library)** in **JSP 2.0** to simplify JSP development. JSP EL can be used independently or in conjunction with JSTL.

- **Purpose**: JSP EL simplifies the process of accessing data stored in Java objects (e.g., beans, request attributes, session attributes) and performing operations in JSP.
- **Pattern**: JSP EL is identified by the `${...}` pattern.
- **Default Status**: JSP EL is enabled by default in JSP.
- **Disabling JSP EL**: To disable JSP EL, use the following directive:
  ```jsp
  <%@ page isELIgnored="true"%>
  ```

---

# JSP EL vs JSTL

- **JSP EL**: An alternative to JSP expressions (`<%= ... %>`).
- **JSTL**: An alternative to JSP declarations (`<%! ... %>`) and scriptlets (`<% ... %>`).

By using JSP EL and JSTL, JSP becomes a **100% tag-based application**, making it cleaner and easier to maintain.

---

# JSP EL Implicit Object References

JSP EL provides several implicit objects to access data stored in different scopes:

1. **`pageScope`**: Used to retrieve attributes stored in the **page scope**.
   ```jsp
   ${pageScope.attributeName}
   ```

2. **`requestScope`**: Used to retrieve attributes stored in the **request scope**.
   ```jsp
   ${requestScope.attributeName}
   ```

3. **`sessionScope`**: Used to retrieve attributes stored in the **session scope**.
   ```jsp
   ${sessionScope.attributeName}
   ```

4. **`applicationScope`**: Used to retrieve attributes stored in the **application scope**.
   ```jsp
   ${applicationScope.attributeName}
   ```

---

# `jakarta.servlet.jsp.JspContext`

The `JspContext` class is the base class for `PageContext`. It provides methods to manage attributes in different scopes.

### Key Methods:
- **`setAttribute(String name, Object value)`**: Sets an attribute in the default scope (page scope).
  ```java
  jspContext.setAttribute("username", "JohnDoe");
  ```
- **`getAttribute(String name)`**: Retrieves an attribute from the default scope.
  ```java
  String username = (String) jspContext.getAttribute("username");
  ```

---

# `jakarta.servlet.jsp.PageContext`

The `PageContext` class extends `JspContext` and provides additional methods to manage attributes in specific scopes.

### Key Variables:
- **`PAGE_SCOPE`**: Represents the page scope.
- **`REQUEST_SCOPE`**: Represents the request scope.
- **`SESSION_SCOPE`**: Represents the session scope.
- **`APPLICATION_SCOPE`**: Represents the application scope.

### Key Methods:
- **`setAttribute(String name, Object value, int scope)`**: Sets an attribute in a specific scope.
  ```java
  pageContext.setAttribute("username", "JohnDoe", PageContext.SESSION_SCOPE);
  ```
- **`getAttribute(String name, int scope)`**: Retrieves an attribute from a specific scope.
  ```java
  String username = (String) pageContext.getAttribute("username", PageContext.SESSION_SCOPE);
  ```
- **`removeAttribute(String name, int scope)`**: Removes an attribute from a specific scope.
  ```java
  pageContext.removeAttribute("username", PageContext.SESSION_SCOPE);
  ```

---

# Examples of JSP EL and JSTL

## Example 1: Using JSP EL to Access Attributes

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>JSP EL Example</title>
</head>
<body>
    <%
        // Setting attributes in different scopes
        pageContext.setAttribute("pageAttr", "Page Attribute");
        request.setAttribute("requestAttr", "Request Attribute");
        session.setAttribute("sessionAttr", "Session Attribute");
        application.setAttribute("appAttr", "Application Attribute");
    %>

    <h1>JSP EL Example</h1>
    <p>Page Attribute: ${pageScope.pageAttr}</p>
    <p>Request Attribute: ${requestScope.requestAttr}</p>
    <p>Session Attribute: ${sessionScope.sessionAttr}</p>
    <p>Application Attribute: ${applicationScope.appAttr}</p>
</body>
</html>
```

---

## Example 2: Using JSTL with JSP EL

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>JSTL with JSP EL Example</title>
</head>
<body>
    <c:set var="message" value="Hello, JSTL!" scope="session"/>

    <h1>JSTL with JSP EL Example</h1>
    <p>Message: ${sessionScope.message}</p>

    <c:if test="${not empty sessionScope.message}">
        <p>The message is: ${sessionScope.message}</p>
    </c:if>
</body>
</html>
```