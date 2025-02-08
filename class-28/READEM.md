# Filters in Java Servlets

A **filter** is an object that can be declaratively inserted into the request-processing pipeline of a web application. Filters provide a mechanism to intercept and manipulate requests and responses before they reach the servlet or after the servlet has processed them. Filters are used for tasks such as logging, authentication, data compression, encryption, and more.

---

## Key Features of Filters
- **Dynamic Dispatching**: Filters support dynamic dispatching, unlike servlets, which support static dispatching.
- **No `main()` Method**: Filters run on the server and do not have a `main()` method.
- **Lifecycle Methods**: Filters have lifecycle methods (`init()`, `doFilter()`, `destroy()`) that are managed by the web container.

---

## Lifecycle Methods of a Filter

1. **`init(FilterConfig config)`**:
    - Called by the web container when the filter is instantiated.
    - Used for initialization tasks (e.g., loading configuration data).
    - Executed only once when the first request comes to the filter.

2. **`doFilter(ServletRequest request, ServletResponse response, FilterChain chain)`**:
    - Called by the web container for every request that matches the filter's URL pattern.
    - Used to perform filtering tasks (e.g., modifying request/response, logging, authentication).
    - The `FilterChain` object is used to pass control to the next filter or servlet in the chain.

3. **`destroy()`**:
    - Called by the web container when the filter is removed from service.
    - Used for cleanup tasks (e.g., releasing resources).
    - Executed when the web app is undeployed or the server shuts down.

---

## Filter Interface

The `jakarta.servlet.Filter` interface defines the lifecycle methods for filters:
- `void init(FilterConfig config)`
- `void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)`
- `void destroy()`

---

## Example of a Filter

### 1. Logging Filter
This filter logs the details of incoming requests.

**LoggingFilter.java**
```java
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*") // Applies to all requests
public class LoggingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("LoggingFilter initialized!");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // Log request details
        System.out.println("Request received from: " + request.getRemoteAddr());

        // Pass the request along the filter chain
        chain.doFilter(request, response);

        // Log response details
        System.out.println("Response sent to: " + request.getRemoteAddr());
    }

    @Override
    public void destroy() {
        System.out.println("LoggingFilter destroyed!");
    }
}
```

---

### 2. Authentication Filter
This filter checks if the user is authenticated before allowing access to a protected resource.

**AuthenticationFilter.java**
```java
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/protected/*") // Applies to requests under /protected
public class AuthenticationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("AuthenticationFilter initialized!");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Check if the user is logged in
        HttpSession session = httpRequest.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            // Redirect to login page if not authenticated
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.html");
        } else {
            // Pass the request along the filter chain
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        System.out.println("AuthenticationFilter destroyed!");
    }
}
```

---

### 3. Compression Filter
This filter compresses the response before sending it to the client.

**CompressionFilter.java**
```java
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

@WebFilter("/*") // Applies to all requests
public class CompressionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("CompressionFilter initialized!");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Check if the client supports GZIP compression
        String acceptEncoding = httpResponse.getHeader("Accept-Encoding");
        if (acceptEncoding != null && acceptEncoding.contains("gzip")) {
            // Wrap the response with GZIP compression
            httpResponse.setHeader("Content-Encoding", "gzip");
            GZIPResponseWrapper gzipResponse = new GZIPResponseWrapper(httpResponse);
            chain.doFilter(request, gzipResponse);
            gzipResponse.finish();
        } else {
            // Pass the request along the filter chain without compression
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        System.out.println("CompressionFilter destroyed!");
    }
}

class GZIPResponseWrapper extends jakarta.servlet.http.HttpServletResponseWrapper {
    private GZIPServletOutputStream gzipOutputStream;

    public GZIPResponseWrapper(HttpServletResponse response) throws IOException {
        super(response);
        gzipOutputStream = new GZIPServletOutputStream(response.getOutputStream());
    }

    @Override
    public jakarta.servlet.ServletOutputStream getOutputStream() throws IOException {
        return gzipOutputStream;
    }

    public void finish() throws IOException {
        gzipOutputStream.finish();
    }
}

class GZIPServletOutputStream extends jakarta.servlet.ServletOutputStream {
    private GZIPOutputStream gzipOutputStream;

    public GZIPServletOutputStream(OutputStream output) throws IOException {
        this.gzipOutputStream = new GZIPOutputStream(output);
    }

    @Override
    public void write(int b) throws IOException {
        gzipOutputStream.write(b);
    }

    @Override
    public void finish() throws IOException {
        gzipOutputStream.finish();
    }

    @Override
    public boolean isReady() {
        return true;
    }

    @Override
    public void setWriteListener(jakarta.servlet.WriteListener writeListener) {
        throw new UnsupportedOperationException();
    }
}
```

---

## Configuring Filters in `web.xml`

Filters can also be configured in the `web.xml` file instead of using annotations.

**web.xml**
```xml
<filter>
    <filter-name>LoggingFilter</filter-name>
    <filter-class>LoggingFilter</filter-class>
</filter>
<filter-mapping>
    <filter-name>LoggingFilter</filter-name>
    <url-pattern>/*</url-pattern>
</filter-mapping>
```