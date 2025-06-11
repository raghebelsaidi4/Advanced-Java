# JDBC API Overview

The **Java Database Connectivity (JDBC) API** is a Java API that enables access to tabular data, particularly in Relational Database Management Systems (RDBMS). It provides a standardized interface for interacting with databases.

## Packages in JDBC
1. **`java.sql`**: Core JDBC classes and interfaces.
2. **`javax.sql`**: Extensions for connection pooling, rowsets, and distributed transactions.
3. **`javax.sql.rowset`**: Specialized rowset implementations.

---

## `java.sql` Package Components
### Key Classes
- `DriverManager`: Manages JDBC drivers and connections.
- `SQLException`: Handles database errors.
- `Date`, `Time`, `Timestamp`: Represent SQL date/time types.
- `Types`: Defines SQL data type constants.

### Key Interfaces
- **Core Interfaces**:
  - `Driver`: Entry point for driver-specific implementations.
  - `Connection`: Represents a database session.
  - `Statement`, `PreparedStatement`, `CallableStatement`: Execute SQL queries.
  - `ResultSet`: Holds query results.
- **Metadata Interfaces**:
  - `ResultSetMetaData`: Describes `ResultSet` structure.
  - `DatabaseMetaData`: Provides database-level metadata.
- **LOB Interfaces**:
  - `Blob`: Binary Large Object (e.g., images).
  - `Clob`: Character Large Object (e.g., text files).

> **Note**: JDBC interfaces are implemented by database vendors in their driver software.

---

## JDBC URL Structure
A JDBC URL identifies a database connection. Its general format is:
```
jdbc:<subprotocol>:<subname>
```
- **Example for Oracle (Type 2 Driver)**:
  ```
  jdbc:oracle:oci8:@service-id
  ```
  - `jdbc`: Protocol.
  - `oracle`: Subprotocol (vendor-specific).
  - `oci8`: Logical name (Oracle Call Interface).
  - `service-id`: Database service identifier.

---

## JDBC Drivers

### Type 2 Driver (Native-API Driver)
- **Vendor**: Oracle Corporation.
- **Functionality**: Converts JDBC calls into native database API calls (e.g., OCI for Oracle).
- **Architecture**:
  ![Type 2 Driver Architecture](https://github.com/user-attachments/assets/92d9d148-ccc4-4b27-bff7-518d4c9eadf1)
- **Advantages**:
  - Faster than Type 1 (ODBC bridge) drivers.
- **Disadvantages**:
  - Platform-dependent (requires native libraries).
  - Database must be installed locally.
  - Not available for all databases.

---

### Type 3 Driver (Network Protocol Driver)
- **Functionality**: Uses middleware to translate JDBC calls into database-specific protocols.
- **Architecture**:
  ![Type 3 Driver Architecture](https://github.com/user-attachments/assets/c3ffd1f1-ce8b-4427-94aa-df1f20dc3fb7)
- **Advantages**:
  - Platform-independent.
  - No local database installation required.
- **Disadvantages**:
  - Extra middleware layer adds latency.
  - Middleware must support target databases.

---

### Type 4 Driver (Thin Driver)
- **Functionality**: Directly converts JDBC calls into database-native protocols (100% Java).
- **Oracle Example**:
  - **Driver Class**: `oracle.jdbc.driver.OracleDriver`
  - **URL Format**:
    ```
    jdbc:oracle:thin:@<domain>:<port>:<service-id>
    ```
    - Default Oracle port: `1521`.
- **Architecture**:
  ![Type 4 Driver Architecture](https://github.com/user-attachments/assets/8ca877ca-7f7f-49bc-8f16-93e1237258fd)
- **Advantages**:
  - Highest performance.
  - Platform-independent.
  - No local database installation.
- **Disadvantages**:
  - Database-specific drivers required.

---

## Choosing a Driver
- **Use Type 3**:
  - Applications requiring multiple databases.
  - Middleware infrastructure available.
- **Use Type 4**:
  - Single-database applications.
  - Optimal performance and simplicity.
---
