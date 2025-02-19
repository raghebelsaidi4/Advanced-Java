```markdown
# Java Reflection API 

## Table of Contents
- [Overview](#overview)
- [Key Features](#key-features)
- [Examples](#examples)
  - [1. Accessing Class Information](#1-accessing-class-information)
  - [2. Invoking Methods Dynamically](#2-invoking-methods-dynamically)
  - [3. Accessing Private Fields](#3-accessing-private-fields)
  - [4. Inspecting Constructors](#4-inspecting-constructors)
  - [5. Performance Considerations](#5-performance-considerations)
- [Best Practices](#best-practices)
- [Conclusion](#conclusion)

## Overview
Reflection is a powerful API that enables:
- Examination/modification of class behavior at runtime
- Access to private members and methods
- Dynamic method invocation
- Class information inspection

Contained in `java.lang.reflect` package, it's essential for frameworks, testing tools, and dynamic operations.

## Key Features
- Access private class members
- Instantiate objects dynamically
- Invoke methods by name
- Analyze class structures at runtime
- Create extensible applications

## Examples

### 1. Accessing Class Information
// Get class using object instance
String str = "Reflection Demo";
Class<?> cls = str.getClass();
System.out.println("Class name: " + cls.getName());

// Get class using Class.forName()
Class<?> personClass = Class.forName("com.example.Person");
System.out.println("Class: " + personClass.getSimpleName());
```

### 2. Invoking Methods Dynamically
```java
class Calculator {
    private int add(int a, int b) {
        return a + b;
    }
}

public class ReflectionDemo {
    public static void main(String[] args) throws Exception {
        Calculator calc = new Calculator();
        Class<?> cls = calc.getClass();
        
        // Access private method
        Method addMethod = cls.getDeclaredMethod("add", int.class, int.class);
        addMethod.setAccessible(true);
        
        // Invoke method
        int result = (int) addMethod.invoke(calc, 5, 3);
        System.out.println("Result: " + result);  // Output: 8
    }
}
```

### 3. Accessing Private Fields
```java
class SecretVault {
    private String secretCode = "XYZ-123";
}

public class FieldAccess {
    public static void main(String[] args) throws Exception {
        SecretVault vault = new SecretVault();
        Field field = vault.getClass().getDeclaredField("secretCode");
        
        field.setAccessible(true);
        String code = (String) field.get(vault);
        System.out.println("Secret Code: " + code);
        
        // Modify private field
        field.set(vault, "NEW-456");
        System.out.println("Updated Code: " + field.get(vault));
    }
}
```

### 4. Inspecting Constructors
```java
class Vehicle {
    public Vehicle() {}
    public Vehicle(String type) {}
}

public class ConstructorInspection {
    public static void main(String[] args) {
        Class<Vehicle> vehicleClass = Vehicle.class;
        Constructor<?>[] constructors = vehicleClass.getConstructors();
        
        System.out.println("Available Constructors:");
        for (Constructor<?> constructor : constructors) {
            System.out.println("- " + constructor);
        }
    }
}
```

### 5. Performance Considerations
```java
// Direct method call vs reflection benchmark
public class PerformanceTest {
    public static void main(String[] args) throws Exception {
        final int iterations = 1000000;
        long startTime, duration;
        
        // Direct invocation
        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            new String().isEmpty();
        }
        duration = System.nanoTime() - startTime;
        System.out.println("Direct call: " + duration + " ns");
        
        // Reflective invocation
        Method isEmpty = String.class.getMethod("isEmpty");
        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            isEmpty.invoke(new String());
        }
        duration = System.nanoTime() - startTime;
        System.out.println("Reflection call: " + duration + " ns");
    }
}
```

## Best Practices
1. **Avoid in Performance-Critical Sections**
    - Reflective operations are 50-100x slower than direct calls

2. **Security Considerations**
   ```java
   SecurityManager manager = System.getSecurityManager();
   if (manager != null) {
       manager.checkPermission(new ReflectPermission("suppressAccessChecks"));
   }
   ```

3. **Use Responsibly**
    - Combine with exception handling
    - Always reset accessibility flags
   ```java
   try {
       field.setAccessible(true);
       // perform operation
   } finally {
       field.setAccessible(false);
   }
   ```

4. **Prefer Direct Access**
    - Use reflection only when absolutely necessary

## Conclusion
**When to Use Reflection**:
- Building frameworks (e.g., Spring, Hibernate)
- Developing testing tools
- Creating dynamic proxies
- Implementing plugin architectures

**Trade-offs**:
- ⚠️ Bypasses access controls
- ⚡ Introduces performance overhead
- 💥 May break with JVM updates

Use judiciously and prefer conventional access methods when possible.

["I jot down key points from GeeksforGeeks for better understanding and reference."]