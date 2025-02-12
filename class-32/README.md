# JSP Using Java Beans

A **Java Bean** is a reusable software component that follows specific rules. A Java class is considered a Java Bean if it adheres to the following rules:

1. **Class must be public**.
2. **Class must implement `java.io.Serializable` interface**.
3. **Class must be in a package**.
4. **Class must contain a public default constructor**.
5. **All instance variables (properties) must be private**.
6. **Each property must have public setter and getter methods**.
7. **All setter and getter methods must be public**.

### Example of a Java Bean

```java
package com.example;

import java.io.Serializable;

public class UserBean implements Serializable {
    // Private properties
    private String name;
    private int age;

    // Public default constructor
    public UserBean() {}

    // Setter and Getter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
```

---

# JSP Actions for Java Beans

The following actions are used to access a Java Bean in a JSP:

## 1. `<jsp:useBean>`

This action is used to create an object of a Java Bean class.

- **Syntax**:
  ```jsp
  <jsp:useBean id="beanId" class="com.example.UserBean" scope="session"/>
  ```
- **Attributes**:
    - **`id`**: A unique identifier for the bean instance.
    - **`class`**: The fully qualified class name of the Java Bean.
    - **`scope`**: The scope of the bean instance. Possible values are:
        - `page` (default)
        - `request`
        - `session`
        - `application`

---

## 2. `<jsp:setProperty>`

This action is used to call the setter methods of a Java Bean.

- **Syntax**:
  ```jsp
  <jsp:setProperty name="beanId" property="propertyName" value="propertyValue"/>
  ```
- **Attributes**:
    - **`name`**: The `id` of the bean instance.
    - **`property`**: The name of the property to set.
    - **`value`**: The value to assign to the property.

---

## 3. `<jsp:getProperty>`

This action is used to call the getter methods of a Java Bean.

- **Syntax**:
  ```jsp
  <jsp:getProperty name="beanId" property="propertyName"/>
  ```
- **Attributes**:
    - **`name`**: The `id` of the bean instance.
    - **`property`**: The name of the property to retrieve.

---

### Example of Using Java Beans in JSP

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Java Bean Example</title>
</head>
<body>
    <jsp:useBean id="user" class="com.example.UserBean" scope="session"/>

    <jsp:setProperty name="user" property="name" value="John Doe"/>
    <jsp:setProperty name="user" property="age" value="30"/>

    <h1>User Details</h1>
    <p>Name: <jsp:getProperty name="user" property="name"/></p>
    <p>Age: <jsp:getProperty name="user" property="age"/></p>
</body>
</html>
```

---

# JSP Using Applets

Applets can be embedded in a JSP using the following actions:

## 1. `<jsp:plugin>`

This action is used to include an applet in a JSP.

- **Syntax**:
  ```jsp
  <jsp:plugin type="applet" code="com.example.MyApplet.class" width="300" height="200">
      <jsp:params>
          <jsp:param name="param1" value="value1"/>
      </jsp:params>
      <jsp:fallback>Unable to load applet!</jsp:fallback>
  </jsp:plugin>
  ```
- **Attributes**:
    - **`type`**: Specifies the type of plugin (`applet` or `bean`).
    - **`code`**: The name of the applet class.
    - **`width`**: The width of the applet.
    - **`height`**: The height of the applet.

---

## 2. `<jsp:fallback>`

This action is used to display a user-friendly error message if the applet fails to load.

- **Syntax**:
  ```jsp
  <jsp:fallback>Unable to load applet!</jsp:fallback>
  ```
- **Usage**: Must be used inside the `<jsp:plugin>` action.

---

## 3. `<jsp:params>`

This action is used to specify parameters for the applet.

- **Syntax**:
  ```jsp
  <jsp:params>
      <jsp:param name="param1" value="value1"/>
  </jsp:params>
  ```
- **Usage**: Must be used inside the `<jsp:plugin>` action.

---

## 4. `<jsp:param>`

This action is used to specify a parameter with a name and value.

- **Syntax**:
  ```jsp
  <jsp:param name="param1" value="value1"/>
  ```
- **Attributes**:
    - **`name`**: The name of the parameter.
    - **`value`**: The value of the parameter.

---

### Example of Using Applets in JSP

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Applet Example</title>
</head>
<body>
    <h1>Applet Example</h1>
    <jsp:plugin type="applet" code="com.example.MyApplet.class" width="300" height="200">
        <jsp:params>
            <jsp:param name="message" value="Hello, Applet!"/>
        </jsp:params>
        <jsp:fallback>Unable to load applet!</jsp:fallback>
    </jsp:plugin>
</body>
</html>
```
