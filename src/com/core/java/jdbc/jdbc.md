# JDBC (Java Database Connectivity)

## 1. DriverManager

DriverManager is responsible for finding the correct JDBC driver.

## 2. Driver

A JDBC Driver is a Java library that allows Java applications to communicate with a specific database.

A JDBC Driver is only responsible for communicating between our Java application and the database. If we change the database (e.g., from MySQL to Oracle), we need the corresponding JDBC driver.

## 3. URL (Database URL)

The URL tells JDBC:
- Which database to connect to
- Where the database is running
- Which port to use
- Which database/schema to access

## 4. Dialect (Hibernate/JPA Concept)

Dialect is a Hibernate/JPA component that tells Hibernate how to generate database-specific SQL.

---

# What Is JDBC?

- JDBC (Java Database Connectivity) is a standard Java API that allows Java applications to communicate with relational databases such as MySQL, PostgreSQL, Oracle Database, and Microsoft SQL Server.
- JDBC uses JDBC drivers for connections.
- JDBC provides a common interface so that Java code can work with different databases without changing much application code.

## JDBC Architecture

    Java Application
           |
           v
        JDBC API
           |
           v
    JDBC DriverManager
           |
           v
        JDBC Driver
           |
           v
        Database

## Components of JDBC

1. DriverManager
2. JDBC Driver
3. JDBC API Interfaces:
    - Connection
    - Statement
    - PreparedStatement
    - ResultSet

---

# 1. What Is Connection?

- Connection is an interface responsible for database connections and represents an active session between a Java application and a database.

  Connection con = DriverManager.getConnection(url, user, password);

## Why Do We Need a Connection?

1. Locate the database server.
2. Open a network connection (TCP).
3. Authenticate the user.
4. Create a session.
5. Maintain transaction state.

All of this is represented by the Connection object.

## Step-by-Step Internal Working

### Step 1: Application Calls DriverManager

    DriverManager.getConnection(...);

DriverManager is responsible for finding the correct JDBC driver.

### Step 2: DriverManager Finds a Suitable Driver

Example URL:

    jdbc:mysql://localhost:3306/company

- Prefix: `jdbc:mysql:`
- Indicates that the MySQL driver should handle the connection request.

### Step 3: Driver Creates Socket Connection

The driver establishes communication with the database server.

### Step 4: Authentication

The driver sends the username and password to the database server.

- Database verifies the credentials.
- If valid, authentication succeeds.
- Otherwise, a SQLException is thrown.

### Step 5: Database Creates Session

The database creates a session for the connection.

### Step 6: Driver Returns Connection Object

The driver creates its database-specific Connection implementation and returns it as a `Connection` reference.

## Lifecycle of a Connection

    getConnection()
           |
           v
    Authentication using username & password
           |
           v
    Database Session Created
           |
           v
    Create Statement
           |
           v
    Execute SQL
           |
           v
    Commit / Rollback
           |
           v
    Close Connection

---

# 2. What Is Statement?

- After a Connection is established, the next step is to execute SQL.
- Statement is a JDBC interface used to execute SQL queries.

  Connection con = DriverManager.getConnection(url, username, password);

  Statement st = con.createStatement();

  ResultSet rs = st.executeQuery("SELECT * FROM employee");

## Why Do We Need Statement?

- A Connection only establishes communication with the database.
- No SQL has been executed yet.
- To execute a SQL query, we need a Statement.

## Internal Flow

    Statement st = con.createStatement();

- No SQL is executed yet.
- The driver creates a Statement object associated with that Connection.

## What Happens During createStatement()?

    Statement st = con.createStatement();

Step 1: Connection verifies that the database session exists. Otherwise, a SQLException may occur.

Step 2: Driver creates a Statement implementation.

    Statement
        |
        v
    MySQLStatement

## Executing SQL

    ResultSet rs = st.executeQuery("SELECT * FROM employee");

### Internal Steps

1. Application sends SQL to Statement.
2. Statement passes SQL to JDBC Driver.
3. Driver converts the SQL request into database protocol packets.
4. Driver sends packets through the socket.
5. Database parses and executes the SQL.
6. Database sends the result back, and the driver returns a ResultSet.

## Important Methods of Statement

### 1. executeQuery(sql)

Used for SELECT operations.

    ResultSet rs = st.executeQuery("SELECT * FROM employee");

### 2. executeUpdate(sql)

Used for INSERT, UPDATE, and DELETE operations.

    int count = st.executeUpdate("DELETE FROM employee WHERE id=1");

`count` represents the number of affected rows.

### 3. execute(sql)

Used when the type of SQL result is not known in advance.

    boolean result = st.execute(sql);

Returns:
- `true` → The result is a ResultSet.
- `false` → The result is an update count or there is no ResultSet.

## Drawbacks of Statement

### 1. SQL Injection
- User input is directly added to the SQL query.
- A malicious user can change the query and access unwanted data.

### 2. Performance
- When different SQL queries are executed repeatedly, the database may need to parse and compile each query again.
- This can make execution slower.

### 3. Limited Use for Dynamic Queries
- Statement is suitable for queries that do not change.
- For queries with values entered by users at runtime, PreparedStatement is preferred.

## Connection vs Statement

| Feature                  | Connection    | Statement   |
|--------------------------|---------------|-------------|
| Purpose                  | Connect to DB | Execute SQL |
| Creates Session          | Yes           | No          |
| Executes SQL             | No            | Yes         |
| Creates ResultSet        | No            | Yes         |
| Communicates With Driver | Yes           | Yes         |

---

# 3. What Is PreparedStatement?

- Internally, both Statement and PreparedStatement send SQL to the database through the JDBC driver.
- The major difference is when and how the SQL is parsed and how parameter values are handled.

  Statement         → SQL parsed during execution

  PreparedStatement → SQL parsed during creation

## Why Was PreparedStatement Introduced?

Suppose we use Statement:

    String sql = "SELECT * FROM employee WHERE id = " + id;
    Statement st = con.createStatement();
    ResultSet rs = st.executeQuery(sql);

### Problem 1: SQL Injection

If the user enters:

    1 OR 1=1

The SQL becomes:

    SELECT * FROM employee WHERE id = 1 OR 1=1

Since `1=1` is always true, the query may return all rows from the table.

Therefore, Statement can be vulnerable to SQL injection when dynamic values are concatenated directly into SQL.

### Problem 2: Repeated Parsing and Compilation

Consider the following code:

    for (int i = 1; i <= 1000; i++) {
        String sql = "SELECT * FROM employee WHERE id = " + i;
        st.executeQuery(sql);
    }

The database receives:

    SELECT * FROM employee WHERE id = 1
    SELECT * FROM employee WHERE id = 2
    SELECT * FROM employee WHERE id = 3
    ...

Although only the value changes, the database may treat each SQL statement as a different query.

For each execution, the database may perform:

    Receive SQL
         |
         v
    Parse SQL
         |
         v
    Validate Syntax
         |
         v
    Check Table/Column Existence
         |
         v
    Create Execution Plan
         |
         v
    Execute Query
         |
         v
    Return Result

Repeated parsing and compilation can reduce performance.

## Solution: PreparedStatement

To overcome these problems, PreparedStatement was introduced.

Instead of sending:

    SELECT * FROM employee WHERE id = 101

Use a parameterized query:

    SELECT * FROM employee WHERE id = ?

The SQL structure remains fixed, and only the parameter value changes at runtime.

## Benefits of PreparedStatement

- Helps prevent SQL injection by separating SQL code from parameter data.
- Can improve performance by allowing the database or driver to reuse prepared statements and execution plans.
- Supports parameter binding using `setInt()`, `setString()`, and other `setXXX()` methods.
- Produces cleaner and more maintainable code.

## Step-by-Step Internal Working of PreparedStatement

### Step 1: Create PreparedStatement

    PreparedStatement ps = con.prepareStatement(
        "SELECT * FROM employee WHERE id = ?"
    );

### Step 2: Prepare SQL

The SQL structure is provided to the JDBC driver.

    SELECT * FROM employee WHERE id = ?

The driver and database handle preparation according to their implementation. Preparation does not guarantee that the database will parse and compile the SQL only once.

### Step 3: Prepare Statement

The driver creates a PreparedStatement implementation and may communicate with the database to prepare the query.

### Step 4: Bind Parameter Values

Java code:

    ps.setInt(1, 101);

Parameter value:

    Parameter #1 = 101

### Step 5: Execute Query

    ResultSet rs = ps.executeQuery();

### Step 6: Execute Prepared Query

The driver sends the parameter value and executes the query. Prepared statements and execution plans may be reused, depending on the driver and database.

## Multiple Executions

    PreparedStatement ps = con.prepareStatement(
        "SELECT * FROM employee WHERE id = ?"
    );

    ps.setInt(1, 101);
    ps.executeQuery();

    ps.setInt(1, 102);
    ps.executeQuery();

    ps.setInt(1, 103);
    ps.executeQuery();

Conceptual flow:

    Prepare Once
         |
         v
    SQL Structure Defined
         |
         v
    Execute with 101
         |
         v
    Execute with 102
         |
         v
    Execute with 103

## Commonly Used PreparedStatement Methods

- `setInt()`
- `setString()`
- `setLong()`

### Execution Methods

- `executeQuery()`
- `executeUpdate()`
- `execute()`

### Batch Processing Methods

1. `addBatch()` - Adds the current parameter set to the batch.
2. `executeBatch()` - Executes the batched statements.
3. `clearBatch()` - Removes the statements from the batch.

---

## Statement

- Statement is generally intended for static SQL, where the query is already complete and no values need to be supplied later.

Example:

    Statement st = con.createStatement();
    ResultSet rs = st.executeQuery("SELECT * FROM employee");

Here, the SQL is fixed, and no runtime parameters are required.

## PreparedStatement

- PreparedStatement is used for parameterized SQL, where some values are supplied at runtime.

Example:

    PreparedStatement ps = con.prepareStatement(
        "SELECT * FROM employee WHERE id = ?"
    );

    ps.setInt(1, 101);

    ResultSet rs = ps.executeQuery();

The SQL structure is fixed, but the parameter value can change.

## Statement vs PreparedStatement

| Feature               | Statement                                 | PreparedStatement                                        |
|-----------------------|-------------------------------------------|----------------------------------------------------------|
| Purpose               | Executes SQL statements                   | Executes parameterized SQL                               |
| SQL Provided          | During execution                          | During creation                                          |
| SQL Syntax            | Complete SQL string                       | SQL with `?` placeholders                                |
| Parameter Binding     | Not supported                             | Supported using `setXXX()` methods                       |
| SQL Injection         | Vulnerable when values are concatenated   | Helps prevent injection through parameter binding        |
| Parsing & Compilation | May be repeated for different SQL strings | Preparation and plan reuse depend on the driver/database |
| Performance           | Can be slower for repeated execution      | Can be faster for repeated execution                     |
| Query Reusability     | Limited                                   | Supports reuse                                           |
| Runtime Values        | May require string concatenation          | Uses parameter binding                                   |
| Recommended Usage     | Static SQL when appropriate               | Preferred for parameterized SQL                          |

---

# JDBC ResultSet

- After Connection establishes communication and Statement/PreparedStatement executes SQL, the database returns data.
- That returned data is represented by the ResultSet interface.

## 1. What Is ResultSet?

ResultSet is a JDBC interface that represents the tabular data returned by a SQL SELECT query.

## 2. Why Do We Need ResultSet?

- The database returns data through the JDBC driver.
- Java applications need a standard way to access the returned records.
- The driver exposes the results through a ResultSet object.

## 3. Cursor Concept

The most important concept in ResultSet is the cursor.

When a ResultSet is created:

    ResultSet rs = st.executeQuery(sql);

The cursor is positioned before the first row.

    rs.next();

- Returns `true` if another row is available and moves the cursor to that row.
- Returns `false` if no next row is available.

## 4. Reading Column Values

    rs.getInt("id");
    rs.getInt(1);

Other commonly used methods:

- `getString()`
- `getDouble()`
- `getLong()`

## Methods of ResultSet

### Navigation

- `next()`
- `previous()`
- `first()`
- `last()`

Some navigation methods require a scrollable ResultSet rather than the default forward-only ResultSet.

### Data Retrieval

- `getInt()`
- `getString()`
- `getLong()`
- `getDouble()`
- `getFloat()`
- `getBoolean()`
- `getDate()`
- `getTimestamp()`
- `getObject()`

---

# JDBC Transactions

- A transaction is a group of SQL statements executed as a single unit of work.
- A transaction follows the ACID properties:
    - Atomicity
    - Consistency
    - Isolation
    - Durability

## Transaction Management Using JDBC

    con.setAutoCommit(false);

1. Disables the default auto-commit mode of the JDBC connection.
2. Allows multiple SQL statements to be executed as a single transaction.
3. Changes are committed when `commit()` is called.
4. If an error occurs, `rollback()` can undo uncommitted changes.

Example:

    try {
        con.setAutoCommit(false);

        // Execute SQL statements here.

        con.commit();
    } catch (SQLException e) {
        con.rollback();
        throw e;
    }

---

# Batch Processing in JDBC

- Batch processing allows multiple SQL statements or parameter sets to be grouped together and sent to the database efficiently.
- Instead of executing each query separately:

      ps.executeUpdate();
      ps.executeUpdate();
      ps.executeUpdate();

- Execute them as a batch:

      ps.addBatch();
      ps.addBatch();
      ps.addBatch();
      ps.executeBatch();

For PreparedStatement, set the parameter values before each `addBatch()` call.

---

# SQLException

- SQLException is the exception class used in JDBC to handle database-related errors.
- It can be thrown when an error occurs while:
    - Establishing a database connection
    - Executing SQL queries
    - Accessing database objects

---

# DataSource

DataSource is an interface that provides database connections to an application.

It is an alternative to:

    DriverManager.getConnection(...)

## Problems with DriverManager.getConnection()

- Creates a new physical connection when a new connection is required.
- Connection creation is expensive.
- Does not itself provide connection pooling.

## DriverManager Flow

    Application
         |
         v
    getConnection()
         |
         v
    Create New Connection
         |
         v
    Authenticate
         |
         v
    Return Connection

## Solution: DataSource

    Connection c = dataSource.getConnection();

## DataSource Flow with Connection Pooling

    Application
         |
         v
    DataSource
         |
         v
    Connection Pool
         |
         v
    Return Available Connection

A DataSource can provide connection pooling when configured with a pooling implementation.

## DriverManager vs DataSource

| Feature             | DriverManager                                     | DataSource                                |
|---------------------|---------------------------------------------------|-------------------------------------------|
| Connection Creation | Typically creates a new connection when requested | Can use pooled connections                |
| Performance         | Connection creation can be expensive              | Pooling can improve performance           |
| Connection Pooling  | Not provided by DriverManager itself              | Supported through pooling implementations |
| Enterprise Usage    | Less common in managed applications               | Common                                    |
| Spring Boot Usage   | Rare for application-level connection management  | Standard                                  |

---

# Connection Pooling

- Connection pooling is a technique where a set of database connections is created and maintained in a pool.
- Connections can be reused instead of creating a new physical database connection every time.
- It reduces connection-establishment overhead and helps control the number of concurrent database connections.

---

# Metadata

- Metadata means "data about data".
- Two important JDBC metadata interfaces are:
    1. DatabaseMetaData
    2. ResultSetMetaData

## 1. DatabaseMetaData

- Provides information about the database, JDBC driver, tables, schemas, and other database capabilities.

Example:

    Connection con = DriverManager.getConnection(url, user, password);

    DatabaseMetaData meta = con.getMetaData();

    meta.getDatabaseProductName(); // MySQL
    meta.getDriverName();

## 2. ResultSetMetaData

- Provides information about the columns in a ResultSet.

Example:

    ResultSet rs = st.executeQuery("SELECT * FROM employee");

    ResultSetMetaData meta = rs.getMetaData();

    meta.getColumnCount();
    meta.getColumnName(1);
    meta.getColumnTypeName(1);
    meta.getColumnLabel(1);

## DatabaseMetaData vs ResultSetMetaData

| Feature           | DatabaseMetaData                  | ResultSetMetaData                |
|-------------------|-----------------------------------|----------------------------------|
| Information About | Database and JDBC driver          | ResultSet columns                |
| Obtained From     | Connection                        | ResultSet                        |
| Interface Method  | `getMetaData()`                   | `getMetaData()`                  |
| Usage             | Database, driver, tables, schemas | Columns, column names, datatypes |

---