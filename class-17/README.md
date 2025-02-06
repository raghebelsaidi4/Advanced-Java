# Servlets and Web Applications

## Servlets
Servlets are a specification for developing web applications using the Java programming language. They provide a robust and scalable way to create dynamic web content.

## Web Application
A web application is a distributed application that runs on both the browser (client-side) and the server (server-side). It allows users to interact with the application through a web browser.

## Distributed Application
A distributed application is an application that is installed on one computer but runs on many computers. This allows for scalability and flexibility in handling user requests.

## Types of Web Applications
There are two main types of web applications:

1. **Static Web Applications**
2. **Dynamic Web Applications**

### Static Web Applications
- A static web application is pre-prepared and placed on the server.
- It resides on the server and runs in the browser.
- Static web applications are common to all users.
- The server sends the program to the browser whenever a request is made.
- Static web applications can be developed using HTML, CSS, JavaScript, VB Script, Applets, etc.

### Dynamic Web Applications
- A dynamic web application is prepared dynamically whenever a request is made to the server.
- It resides on the server and runs on the server only.
- Dynamic web applications are specific to the user.
- The server executes the program and sends the output to the browser whenever a request is made.
- Dynamic web applications can be developed using Servlets, Struts, JSF, Spring MVC, ASP, ColdFusion, ASP.NET, etc.

## Browser
A browser is a software application that executes web pages containing text, images, graphics, animations, audio, video, etc. It is also referred to as a web client.

### List of Web Browsers
1. Internet Explorer
2. Mozilla Firefox
3. Google Chrome (popular browser)
4. Opera
5. Netscape Navigator (powerful browser)
6. Mosaic (first browser)
7. Lynx (text-only browser)
8. Microsoft Edge
9. ...

## Server
A server is a software that receives requests from the client, processes the request, constructs the response, and sends the response back to the client.

### Types of Servers
1. **Web Servers**
2. **Application Servers**

#### Web Server
A web server contains only a web container, which includes web components such as Servlets and JSPs.

**List of Web Servers:**
1. Tomcat Web Server
2. iPlanet Web Server
3. Java Web Server
4. Personal Web Server
5. Jetty Web Server
6. ...

#### Application Server
An application server contains both a web container and an EJB (Enterprise Java Beans) container.

**List of Application Servers:**
1. WebLogic Application Server
2. WebSphere Application Server
3. Sun ONE Application Server
4. JBoss Application Server
5. GlassFish Application Server
6. ...

## Servlets in Web Containers
- Servlets run in a web container, which is available in both web servers and application servers.
- Servlet specifications are used by vendors to develop web containers.
- Servlet specifications are used by Java programmers to develop web applications.

## CGI vs. Servlets
- **CGI (Common Gateway Interface):** A specification for developing web applications using languages like C, C++, Perl, etc.
- **Servlets:** A specification for developing web applications using Java.

**Key Differences:**
- **CGI:** Creates a new process for every request.
- **Servlets:** Creates a new process for the first request only, and subsequent requests are handled by child processes.

## Applets vs. Servlets
- **Applets:** Java programs that reside on the server and run in the browser.
- **Servlets:** Java programs that reside on the server and run on the server only.

**Key Differences:**
- **Applets:** Extend the functionality of the browser.
- **Servlets:** Extend the functionality of the server.
- **Applets:** Do not have a `main()` method because they run in the browser.
- **Servlets:** Do not have a `main()` method because they run on the server.
- **Applets:** Have life cycle methods to run in the browser.
- **Servlets:** Have life cycle methods to run on the server.

### Life Cycle of an Applet
1. `init()`
2. `start()`
3. `paint()`
4. `stop()`
5. `destroy()`

### Life Cycle of a Servlet
1. `init()`
2. `service()`
3. `destroy()`

## Conclusion
Servlets provide a powerful way to create dynamic web applications in Java. They run on the server and handle client requests efficiently, making them a key component in modern web development. Understanding the differences between static and dynamic web applications, as well as the roles of browsers and servers, is crucial for developing robust web applications.