# Life Cycle of a Servlet

The life cycle of a servlet is managed by the web container and consists of three main methods:

1. **`init()`**
2. **`service()`**
3. **`destroy()`**

### Description of Life Cycle Methods

1. **`init()`**:
    - This method is called by the web container when the servlet is first loaded into memory, typically when the first request is made to the servlet.
    - It is used for one-time initialization tasks, such as loading configuration data or establishing database connections.
    - The method is called only once during the servlet's life cycle.

2. **`service()`**:
    - This method is called by the web container for every request made to the servlet.
    - It handles the request and generates the response.
    - The `service()` method determines the type of HTTP request (GET, POST, etc.) and delegates it to the appropriate method (`doGet()`, `doPost()`, etc.).

3. **`destroy()`**:
    - This method is called by the web container when the servlet is being removed from memory.
    - It is typically invoked when the web application is undeployed or the server is shut down.
    - The `destroy()` method is used to clean up resources, such as closing database connections or releasing other system resources.

### When is a Servlet Instance Removed?
A servlet instance is removed from the web container in the following scenarios:
- The web application is undeployed from the server.
- The server is shut down.

### Life Cycle Methods and `javax.servlet.Servlet` Interface
- The life cycle methods (`init()`, `service()`, and `destroy()`) are part of the `javax.servlet.Servlet` interface.
- Every servlet must implement this interface to leverage these life cycle methods.
- The servlet class must be declared as `public` because the web container needs to access it to create an instance and call the life cycle methods.

---

## Declaration Rules for a Source File (`.java` File)

1. A source file can have only **one public class**.
2. A source file can have **any number of non-public classes**.
3. If the source file contains a public class, the file name must match the public class name.
4. If the source file does not contain a public class, there are no naming restrictions for the file name.

### Additional Notes:
- The Java compiler generates a `.class` file for every class in a source file.
- A class that contains the `main()` method is used to execute the program.

---

## Steps to Develop Web Applications

1. **Create a Web Application Folder Structure**:
    - Organize the web application files into a standard directory structure.

2. **Create and Compile Web Application Source Code**:
    - Write the servlet program (Java code) and compile it into a `.class` file.

3. **Write Deployment Descriptor (`web.xml`)**:
    - The `web.xml` file is used to configure the servlet and map it to a URL pattern.

4. **Create a WAR (Web Archive) File**:
    - Package the web application into a `.war` file for deployment on a server.

---

## Web Application Folder Structure

The standard folder structure for a web application is as follows:

```
WebAppName/
│
├── WEB-INF/
│   ├── web.xml           (Deployment Descriptor)
│   ├── classes/          (Compiled servlet classes)
│   └── lib/              (Third-party libraries/JAR files)
│
├── index.html            (Static web pages)
├── css/                  (CSS files)
├── js/                   (JavaScript files)
└── images/               (Image files)
```

### Explanation:
- **`WEB-INF/`**: This directory contains configuration files and resources that are not directly accessible to the client.
    - **`web.xml`**: The deployment descriptor file for configuring servlets and other web components.
    - **`classes/`**: Contains compiled servlet classes (`.class` files).
    - **`lib/`**: Contains third-party libraries (`.jar` files) required by the application.
- **Static Files**: HTML, CSS, JavaScript, and image files are placed in the root directory or their respective subdirectories.

---