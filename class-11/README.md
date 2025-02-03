# Batch Processing or Batch Updates

Batch processing allows executing multiple SQL queries at once. This feature helps in reducing network traffic in real-time applications, making database interactions more efficient.

### Methods for Batch Processing:
1. **addBatch(String sql)** - Adds a query to the batch.
2. **executeBatch()** - Executes all queries in the batch.
3. **clearBatch()** - Clears all the queries from the batch.

#### Example of Batch Processing
```java
Statement stmt = connection.createStatement();
stmt.addBatch("INSERT INTO users (name) VALUES ('Alice')");
stmt.addBatch("INSERT INTO users (name) VALUES ('Bob')");
int[] results = stmt.executeBatch();
System.out.println("Rows affected: " + results.length);
```

---

# Advanced Data Types

## 1. BLOB (Binary Large Object)
BLOB is used to store and retrieve large amounts of binary data as a single entity in/from the database. It supports all types of data, including:
- Text
- Images
- Graphics
- Animations
- Audio
- Video

### Methods for BLOB:
1. **setBlob(int parameterIndex, InputStream inputStream)** - Stores a binary stream.
2. **getBlob(String columnLabel)** - Retrieves binary data as a `Blob` object.
3. **getBinaryStream()** - Returns an input stream to read BLOB data.

#### Example of Using BLOB
```java
PreparedStatement pstmt = connection.prepareStatement("INSERT INTO files (data) VALUES (?)");
FileInputStream fis = new FileInputStream("image.jpg");
pstmt.setBlob(1, fis);
pstmt.executeUpdate();
```

---

## 2. CLOB (Character Large Object)
CLOB is used to store and retrieve large amounts of character data as a single entity in/from the database. It supports text data only.

### Methods for CLOB:
1. **setClob(int parameterIndex, Reader reader)** - Stores character data.
2. **getClob(String columnLabel)** - Retrieves character data as a `Clob` object.
3. **getCharacterStream()** - Returns a reader to read CLOB data.

#### Example of Using CLOB
```java
PreparedStatement pstmt = connection.prepareStatement("INSERT INTO documents (text) VALUES (?)");
FileReader reader = new FileReader("document.txt");
pstmt.setClob(1, reader);
pstmt.executeUpdate();
```

