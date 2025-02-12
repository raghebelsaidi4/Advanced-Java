# JSP (Jakarta Server Pages)

- **Renamed as Jakarta Server Pages**: JSP was originally known as Java Server Pages but has since been renamed to Jakarta Server Pages as part of the transition from Java EE to Jakarta EE.
- **JSP Specification**: JSP is a specification for developing web applications using the Java programming language.
- **JSP Engine**: The JSP engine is a piece of software that converts JSP into a servlet. It is a part of the web server and application server.
- **JSP Lifecycle**:
    - JSP -> JSP Engine -> Servlet

## JSP Architecture

The JSP architecture involves three main phases:

1. **Conversion**: The JSP engine converts the JSP file into a servlet.
2. **Compilation**: The Java compiler compiles the generated servlet into bytecode.
3. **Execution**: The Java Runtime Environment (JRE) executes the compiled servlet.

These processes are handled by the server whenever the first request comes to a JSP. For subsequent requests, the already converted servlet is executed, and the output is passed to the browser.

### JSP Architecture Diagram

```plaintext
+-------------------+       +-------------------+       +-------------------+
|   JSP File        |       |   Servlet         |       |   HTML Response    |
|   (example.jsp)   |  -->  |   (example.java)  |  -->  |   (output.html)    |
+-------------------+       +-------------------+       +-------------------+
        |                         |                         |
        |                         |                         |
        v                         v                         v
+-------------------+       +-------------------+       +-------------------+
|   JSP Engine      |       |   Java Compiler   |       |   JRE             |
|   (Conversion)    |       |   (Compilation)   |       |   (Execution)     |
+-------------------+       +-------------------+       +-------------------+
```

## JSP Elements

JSP elements are used to write JSP programs and are divided into three categories:

1. **Scripting Elements**
2. **Directives**
3. **Actions**

### Scripting Elements

There are four types of scripting elements:

1. **Scriptlets**
2. **Declarations**
3. **Expressions**
4. **Comments**

#### 1. Scriptlets

- **Syntax**: `<%....%>` or `<jsp:scriptlet>...</jsp:scriptlet>`
- **Example**:
  ```jsp
  <%
      int a = 10;
      int b = 20;
      int sum = a + b;
      out.println("Sum: " + sum);
  %>
  ```

#### 2. Declarations

- **Syntax**: `<%!....%>` or `<jsp:declaration>...</jsp:declaration>`
- **Example**:
  ```jsp
  <%!
      int a = 10;
      static int b = 20;
      void show() {
          out.println("Hello, World!");
      }
  %>
  ```

#### 3. Expressions

- **Syntax**: `<%=....%>` or `<jsp:expression>...</jsp:expression>`
- **Example**:
  ```jsp
  <%= a + b %>
  ```

#### 4. Comments

- **Syntax**: `<%--....--%>`
- **Example**:
  ```jsp
  <%-- This is a comment --%>
  ```

## JSP Implicit Object Reference

JSP provides several implicit objects that can be used directly in JSP pages:

1. **out**: `JspWriter`
2. **request**: `HttpServletRequest`
3. **response**: `HttpServletResponse`
4. **config**: `ServletConfig`
5. **application**: `ServletContext`
6. **page**: `Object`
7. **pageContext**: `PageContext`
8. **session**: `HttpSession`
9. **exception**: `Throwable`

## Implicitly Imported Packages in JSP

The following packages are implicitly imported in JSP:

1. `java.lang`
2. `jakarta.servlet`
3. `jakarta.servlet.http`
4. `jakarta.servlet.jsp`

## JSP Deployment Location in Tomcat Web Server

- **JSP Deployment Location**: `C:\Program Files\Apache Software Foundation\Tomcat 10.x\webapps\`
- **Converted Servlet Location**: `C:\Program Files\Apache Software Foundation\Tomcat 10.x\work\Catalina\localhost\`

### Notes:
- **Catalina**: The name of the web container in the Tomcat web server.
- **Jasper**: The name of the JSP engine in the Tomcat web server.

## Example JSP Program

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>First JSP Program</title>
</head>
<body>
    <h1>Hello, World!</h1>
    <%
        int a = 10;
        int b = 20;
        int sum = a + b;
        out.println("Sum of " + a + " and " + b + " is: " + sum);
    %>
</body>
</html>
```