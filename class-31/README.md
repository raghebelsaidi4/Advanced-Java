# Include Directive

The **Include Directive** is used to include the content of another file (HTML or JSP) into the current JSP during the **translation phase** (when the JSP is converted into a servlet).

- **Syntax**: `<%@include file="..." %>`
- **Attribute**:
    - **`file`**: Specifies the path of the file to be included.
      ```jsp
      <%@include file="header.jsp"%>
      <%@include file="footer.html"%>
      ```

---

# Taglib Directive

The **Taglib Directive** is used to include custom tag libraries (e.g., JSTL tags) in a JSP. It is required when using JSTL (JavaServer Pages Standard Tag Library) or custom tags.

- **Syntax**: `<%@ taglib ... %>`
- **Attributes**:
    - **`uri`**: Specifies the URI of the tag library.
    - **`prefix`**: Defines the prefix used to reference the tags from the library.
      ```jsp
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
      ```

---

# JSP Actions

JSP actions are XML-like tags used to control the behavior of the JSP engine. They are executed during the **request processing phase**.

## 1. `<jsp:forward>`

The **`<jsp:forward>`** action is used to forward the request and response from one JSP to another JSP or resource. It is equivalent to the `RequestDispatcher.forward()` method in servlets.

- **Syntax**:
  ```jsp
  <jsp:forward page="target.jsp"/>
  ```
  or
  ```jsp
  <jsp:forward page="target.jsp">
      <jsp:param name="param1" value="value1"/>
  </jsp:forward>
  ```
- **Attribute**:
    - **`page`**: Specifies the target resource (JSP, HTML, or servlet) to which the request is forwarded.
      ```jsp
      <jsp:forward page="welcome.jsp"/>
      ```

---

## 2. `<jsp:include>`

The **`<jsp:include>`** action is used to include the content of another JSP or resource in the current JSP during the **request processing phase**. It is equivalent to the `RequestDispatcher.include()` method in servlets.

- **Syntax**:
  ```jsp
  <jsp:include page="target.jsp"/>
  ```
  or
  ```jsp
  <jsp:include page="target.jsp">
      <jsp:param name="param1" value="value1"/>
  </jsp:include>
  ```
- **Attribute**:
    - **`page`**: Specifies the target resource (JSP, HTML, or servlet) to be included.
      ```jsp
      <jsp:include page="header.jsp"/>
      ```

---

# Difference Between Include Directive and Include Action

| Feature                  | Include Directive (`<%@include ... %>`)          | Include Action (`<jsp:include ... />`)          |
|--------------------------|--------------------------------------------------|------------------------------------------------|
| **Phase**                | Translation phase (when JSP is converted to a servlet). | Request processing phase (when the JSP is executed). |
| **Content Inclusion**    | Includes the content of the file statically.     | Includes the content of the file dynamically.   |
| **File Changes**         | Changes in the included file are not reflected until the JSP is recompiled. | Changes in the included file are reflected immediately. |
| **Performance**          | Faster because inclusion happens once during translation. | Slower because inclusion happens on every request. |
| **Usage**                | Best for static content (e.g., headers, footers). | Best for dynamic content (e.g., content that changes frequently). |
| **Syntax**               | `<%@include file="header.jsp"%>`                | `<jsp:include page="header.jsp"/>`             |

---

# Examples

## Include Directive Example

```jsp
<%@include file="header.jsp"%>
<h1>Welcome to the Home Page!</h1>
<%@include file="footer.html"%>
```

## Include Action Example

```jsp
<jsp:include page="header.jsp"/>
<h1>Welcome to the Home Page!</h1>
<jsp:include page="footer.html"/>
```

## `<jsp:forward>` Example

```jsp
<%
    String userType = request.getParameter("userType");
    if (userType.equals("admin")) {
%>
    <jsp:forward page="admin.jsp"/>
<%
    } else {
%>
    <jsp:forward page="user.jsp"/>
<%
    }
%>
```

## `<jsp:include>` Example

```jsp
<jsp:include page="header.jsp"/>
<h1>Welcome to the Home Page!</h1>
<jsp:include page="footer.jsp"/>
```
