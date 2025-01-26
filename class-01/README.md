# Methods in Java  
A method in Java is a code block that groups instructions to perform a specific task, defining the behavior of objects or classes. Methods enhance code modularity and reusability, promoting good programming practices.

# Advantages of Methods  
- **Modularity**: Methods break programs into smaller, manageable parts, making the code easier to understand and maintain.  
- **Reusability**: Once written, a method can be reused multiple times, reducing code redundancy.  

# Types of Methods  
Java methods can be categorized based on whether they accept arguments and return values, resulting in four main types:

1. **Method with Arguments and Return Value**  
   A method that takes one or more arguments and returns a value.  
   **Syntax**:  
   ```java  
   ReturnType methodName(arg1, arg2, ...) {  
       // method body  
       return value;  // return a value of the specified type  
   }  
   ```  
   **Example**:  
   ```java  
   public int add(int a, int b) {  
       return a + b;  
   }  
   ```

2. **Method with Arguments and Without Return Value**  
   A method that takes arguments but does not return a value.  
   **Syntax**:  
   ```java  
   void methodName(arg1, arg2, ...) {  
       // method body  
   }  
   ```  
   **Example**:  
   ```java  
   public void printMessage(String message) {  
       System.out.println(message);  
   }  
   ```

3. **Method Without Arguments and With Return Value**  
   A method that does not take any arguments but returns a value.  
   **Syntax**:  
   ```java  
   ReturnType methodName() {  
       // method body  
       return value;  // return a value of the specified type  
   }  
   ```  
   **Example**:  
   ```java  
   public int getRandomNumber() {  
       return (int) (Math.random() * 100);  
   }  
   ```

4. **Method Without Arguments and Without Return Value**  
   A method that neither takes arguments nor returns a value.  
   **Syntax**:  
   ```java  
   objRef.methodName();  
   ```

# Data Types in Java

## Primitive Data Types
These are the basic, predefined data types in Java:

1. byte: 8-bit signed integer
2. short: 16-bit signed integer
3. int: 32-bit signed integer
4. long: 64-bit signed integer
5. float: 32-bit floating point
6. double: 64-bit floating point
7. char: 16-bit Unicode character
8. boolean: Represents true or false

## Reference Data Types
These refer to objects, instances of classes, arrays, and other non-primitive types:

- Arrays: Store multiple values of the same type.
- Strings: A sequence of characters.
- Classes: User-defined custom data types.
- Interfaces: Define contracts for class implementation.
