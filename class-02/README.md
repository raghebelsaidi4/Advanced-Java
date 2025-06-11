# Class Methods

A **class method** is a method that is defined as a `static` member of a class. This means it belongs to the class rather than any particular instance of the class, and it can be called without creating an object of the class.

## Ways to Access Class Methods

There are four ways to access class methods:

### 1. Directly  
You can call the method directly if it is present in the same class.  

**Example**:  
```java
public class MyClass {
    public static void displayMessage() {
        System.out.println("Hello, World!");
    }

    public static void main(String[] args) {
        displayMessage(); // Direct access
    }
}
```

### 2. Using the Class Name  
If the method is defined in another class, use the class name to call the method. This is the **recommended approach** as it improves code clarity and maintainability.  

**Example**:  
```java
public class AnotherClass {
    public static void showInfo() {
        System.out.println("Class method called using class name.");
    }
}

public class MainClass {
    public static void main(String[] args) {
        AnotherClass.showInfo(); // Access via class name
    }
}
```

### 3. Using an Object (Not Recommended)  
Although it is possible to access a class method using an object of the class, this is **not recommended** because it creates unnecessary instances and can cause confusion.  

**Example**:  
```java
public class MyClass {
    public static void displayMessage() {
        System.out.println("Hello, World!");
    }

    public static void main(String[] args) {
        MyClass obj = new MyClass();
        obj.displayMessage(); // Not recommended
    }
}
```

### 4. Using an Object Reference (Not Recommended)  
Similarly, accessing class methods using an object reference is also **not recommended**. While this approach works, it is not a best practice as it can lead to misunderstandings in the code.  

**Example**:  
```java
public class MyClass {
    public static void displayMessage() {
        System.out.println("Hello, World!");
    }

    public static void main(String[] args) {
        MyClass obj = null; // Null reference
        obj.displayMessage(); // Works, but not recommended
    }
}
```

## Best Practices
- Always use **direct access** for class methods within the same class.
- Use the **class name** to access class methods defined in other classes.
- Avoid using objects or object references to call class methods as it violates clarity and best practices.
