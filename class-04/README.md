# JDBC (Java Database Connectivity)

## What is JDBC?

JDBC stands for **Java Database Connectivity**. It is a specification for developing database applications using the Java programming language. JDBC allows Java applications to interact with databases and perform operations such as querying, inserting, updating, and deleting data.

---

## Database Application

A **database application** is any application that communicates with a database. It uses SQL (Structured Query Language) to send requests and retrieve data.

---

## Application vs. Database

- **Application**: An application is a program with which we interact, usually on the desktop or through a web interface.
- **Database**: A database is software that stores data in an organized collection, typically in tables. Each table consists of fields and records.

---

## Components of a Database System

A typical database system consists of two primary parts:

1. **Database Application**: The front end that communicates with the user. Example: SQL Prompt.
2. **Database**: The back end where data is stored. Example: Oracle Database.

---

## Popular Database Management Systems

1. Oracle
2. MySQL
3. Derby
4. DB2
5. PostgreSQL
6. MongoDB
7. And more...

---

## SQL (Structured Query Language)

SQL is a language used by applications to interact with databases. It allows us to define, manipulate, and query data.

- **Client**: The software that sends requests to the database.
- **Server**: The software that receives requests, processes them, and sends back responses.

---

## JDBC Drivers

A **JDBC driver** is a software component that enables a Java application to connect to a database. JDBC drivers are developed by various vendors: first-party (e.g., Sun Microsystems), second-party (e.g., Oracle), and third-party vendors.

---

## Types of JDBC Drivers

There are four types of JDBC drivers:

1. **Type 1 Driver (JDBC-ODBC Bridge Driver)**
2. **Type 2 Driver (JDBC Native API Driver)**
3. **Type 3 Driver (JDBC Network Protocol Driver)**
4. **Type 4 Driver (JDBC 100% Pure Java Driver)**

---

## Types of Database Connectivity

- **JDBC-ODBC**: A method of connecting Java applications to databases using both JDBC and ODBC drivers.
- **JDBC-only**: The preferred method using only JDBC drivers to establish a connection between Java applications and databases.

---

## Type 1 JDBC Driver (JDBC-ODBC Bridge Driver)

- **Driver Class Name**: `sun.jdbc.odbc.JdbcOdbcDriver`
  
  - `sun`: Package
  - `jdbc.odbc`: Sub-package
  - `JdbcOdbcDriver`: Class

This driver converts Java instructions into ODBC-compliant instructions. It is part of the Java Development Kit (JDK).

### Type 1 Driver Architecture:

![Type 1 Driver Architecture](https://github.com/user-attachments/assets/5d6b1d89-c512-46d1-8413-622e9b3bd64d)

### Advantages of Type 1 Driver:
- One driver supports all ODBC-enabled databases.

### Disadvantages of Type 1 Driver:
- Performance overhead, as Java calls go through both the JDBC and ODBC drivers.
- Platform dependency.
- The database client software needs to be installed locally.

> **Note**: The Type 1 driver was removed from JDK 1.8 onwards.

---

## Type 2 JDBC Driver (JDBC Native API Driver)

The Type 2 driver is also known as the **partly Java-native driver** or **partial Java driver**.

---

## Steps to Develop a Database Application

### 1. Loading the JDBC Driver

You must load a specific JDBC driver using the following command:

`public static Class.forName("com.jdbc.driverName");`
### 2. Establishing a connection between application and database
### 3. Perfoming the task
### 4. Closing a connection
