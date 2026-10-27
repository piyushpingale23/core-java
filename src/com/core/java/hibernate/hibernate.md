
# Hibernate and JPA

## 1. What Is Hibernate?

- Hibernate is an ORM (Object Relational Mapping) framework for Java.
- It maps Java objects to database tables.
- Hibernate internally uses JDBC to communicate with the database.
- JPA is a specification (standard/API).
- Hibernate is an implementation (provider) of the JPA specification.

### What Is JPA?

- JPA stands for Java Persistence API; it is now called Jakarta Persistence.
- JPA defines standard interfaces and annotations for mapping Java objects to relational databases.
- JPA does not perform database operations by itself. It requires an implementation such as Hibernate.
- Hibernate implements JPA and also provides additional Hibernate-specific features.

Example:

```java
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    private Long id;

    private String name;
}
```

Here:
- `@Entity`, `@Table`, and `@Id` are JPA annotations.
- Hibernate reads these annotations and performs the actual ORM operations.

### JDBC vs Hibernate vs JPA

| Feature               | JDBC                       | JPA                          | Hibernate                                |
|-----------------------|----------------------------|------------------------------|------------------------------------------|
| Type                  | Java database API          | Persistence specification    | ORM framework                            |
| SQL execution         | Through JDBC driver        | Through an implementation    | Through JDBC                             |
| SQL generation        | Generally written manually | Depends on provider          | Generated automatically when appropriate |
| Object mapping        | Manual                     | Standardized mapping         | Implements mapping                       |
| Database independence | Depends on SQL and driver  | Provider-dependent           | Supports multiple databases              |
| Implementation        | JDBC drivers               | Hibernate, EclipseLink, etc. | Hibernate ORM                            |

### Problems with JDBC

- Requires a lot of boilerplate code.
- SQL must generally be written manually.
- Java objects must be mapped to database rows manually.
- Transaction management requires explicit handling.
- Repeated mapping code can become difficult to maintain.

### Why Hibernate?

- Reduces database-related boilerplate code.
- Automatically generates SQL for many operations.
- Provides object-to-table mapping.
- Supports transaction management.
- Provides caching mechanisms.
- Handles entity relationships.
- Supports database independence through dialects and ORM mappings.

### Example

JDBC:

```
PreparedStatement ps = con.prepareStatement(
    "INSERT INTO student (id, name) VALUES (?, ?)"
);

ps.setLong(1, 1L);
ps.setString(2, "Piyush");

ps.executeUpdate();
```

Hibernate:

```
session.persist(student);
```

Hibernate manages the entity and generates the required SQL. The SQL may execute when Hibernate flushes the persistence context.

---

## 2. What Is ORM?

ORM stands for Object Relational Mapping.

ORM is a technique that maps Java objects to relational database tables.

It maps:

- Java class → Database table
- Java object → Database row
- Java field/property → Database column

### ORM Flow

```text
Java Object
     |
     v
    ORM
     |
     v
    SQL
     |
     v
  JDBC Driver
     |
     v
  Database
```

### Example

```java
@Entity
@Table(name = "student")
public class Student {

    @Id
    private Long id;

    private String name;

    private String email;
}
```

Hibernate uses mapping metadata to determine how the `Student` entity corresponds to the `student` table.

### How Does ORM Perform Mapping Internally?

1. Hibernate reads entity mapping information from annotations or XML.
2. Hibernate builds metadata during initialization.
3. It uses mapping metadata and entity state to determine the required database operations.
4. Hibernate generates SQL when necessary.
5. Hibernate executes SQL through JDBC.
6. Returned database data is mapped to Java objects.

Hibernate may use reflection and other internal mechanisms to access entity state.

### Interview Questions

**Q1. What is ORM?**

ORM is a technique that maps Java objects to relational database tables and converts data between Java objects and database records.

**Q2. Why is ORM required?**

Java applications work with objects, whereas relational databases store data in tables. ORM bridges this gap.

**Q3. Is Hibernate an ORM?**

Yes. Hibernate is a Java ORM framework that implements Object Relational Mapping.

**Q4. Does Hibernate replace JDBC?**

No. Hibernate uses JDBC internally to communicate with relational databases.

**Q5. Does Hibernate eliminate SQL completely?**

No. Hibernate can generate SQL automatically, but developers can still use HQL, JPQL, Criteria API, native SQL, and other query mechanisms.

---

## 3. Hibernate Architecture

The main components are:

1. Configuration
2. SessionFactory
3. Session
4. Transaction
5. Persistence Context
6. JDBC connection and database

### 3.1 Configuration

- Loads Hibernate configuration properties and entity mapping information.
- Used to bootstrap Hibernate in traditional native Hibernate applications.
- In Spring Boot, much of this configuration is managed automatically.

Traditional Hibernate example:

```
Configuration configuration = new Configuration();
configuration.configure("hibernate.cfg.xml");
```

### 3.2 SessionFactory

- A heavyweight, thread-safe object.
- Usually created once per database or persistence unit.
- Creates Session objects.
- Holds entity mapping metadata and configuration.
- Can coordinate second-level caching when configured.

```java
SessionFactory sessionFactory = configuration.buildSessionFactory();
```

### 3.3 Session

- A lightweight, non-thread-safe Hibernate object.
- Represents a unit of interaction with the persistence layer.
- Provides methods for CRUD operations.
- Maintains the persistence context, which acts as the first-level cache.

```java
Session session = sessionFactory.openSession();
```

Common methods include:

- `persist()`
- `merge()`
- `remove()`
- `find()` or `get()`, depending on the API/version
- `createQuery()`
- `beginTransaction()`
- `flush()`
- `clear()`
- `close()`

A Hibernate Session is not necessarily a permanent physical database connection. Connection acquisition and release depend on Hibernate configuration and the connection provider.

### 3.4 Transaction

- Represents a database transaction.
- Coordinates commit and rollback.
- Ensures that a group of database changes is committed or rolled back according to the transaction outcome.

```java
Transaction tx = session.beginTransaction();
```

### Hibernate Architecture Flow

```text
Application
     |
     v
Configuration / Bootstrap
     |
     v
SessionFactory
     |
     v
Session
     |
     v
Persistence Context
     |
     v
Hibernate SQL Generation
     |
     v
JDBC
     |
     v
Database
```

### Interview Questions

**Q1. What are the main components of Hibernate architecture?**

Configuration, SessionFactory, Session, and Transaction are the traditional core components.

**Q2. Which object is heavyweight?**

SessionFactory, because it maintains configuration and mapping metadata and coordinates shared resources.

**Q3. Which object is used for CRUD operations?**

Session in native Hibernate; EntityManager in standard JPA.

**Q4. Does Hibernate directly communicate with the database?**

Hibernate uses JDBC and a JDBC driver to communicate with the database.

**Q5. How many SessionFactory objects should be created?**

Typically, one per database or persistence unit, rather than one per request.

**Q6. Is SessionFactory thread-safe?**

Yes.

**Q7. Is Session thread-safe?**

No. A Session should not be shared concurrently across multiple threads.

---

## 4. Entity Class

An entity class is a Java class that represents a persistent entity, usually mapped to a database table.

### Important Entity Annotations

| Annotation           | Purpose                                        |
|----------------------|------------------------------------------------|
| `@Entity`            | Marks the class as an entity                   |
| `@Table`             | Specifies the table name                       |
| `@Id`                | Specifies the primary key                      |
| `@Column`            | Configures a column mapping                    |
| `@GeneratedValue`    | Configures primary-key generation              |
| `@Transient`         | Excludes a field/property from persistence     |
| `@Enumerated`        | Maps an enum                                   |
| `@Embedded`          | Maps an embeddable object                      |
| `@Embeddable`        | Defines an embeddable class                    |
| `@Version`           | Supports optimistic locking                    |
| `@SequenceGenerator` | Configures a sequence generator                |
| `@UniqueConstraint`  | Configures a table-level uniqueness constraint |

### Example

```java
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "employee_name", nullable = false)
    private String name;

    private double salary;

    @Transient
    private String temporaryValue;

    public Employee() {
    }

    // Getters and setters
}
```

Important points:

- An entity needs a primary key.
- A public or protected no-argument constructor is required by standard JPA entity rules.
- An entity can use field access or property access.
- By default, a field maps to a column with the same name unless mapping rules or naming strategies change it.
- `@Transient` prevents the property from being persisted; it is different from the Java `transient` keyword, although both can affect persistence mapping.

### Primary-Key Generation Strategies

| Strategy   | Description                              |
|------------|------------------------------------------|
| `AUTO`     | Provider selects an appropriate strategy |
| `IDENTITY` | Uses an identity/auto-increment column   |
| `SEQUENCE` | Uses a database sequence                 |
| `TABLE`    | Uses a table-based generator             |

The supported behavior and efficiency depend on the database and provider.

---

## 5. Entity Lifecycle States

An entity can be in four important lifecycle states.

### 5.1 Transient

- Object is created using `new`.
- It is not associated with a persistence context.
- Hibernate is not tracking it.

```
Employee employee = new Employee();
employee.setName("Piyush");
```

### 5.2 Persistent (Managed)

- Entity is associated with a persistence context.
- Hibernate tracks changes to the entity.
- Changes can be synchronized with the database during flush.

```
session.persist(employee);
```

### 5.3 Detached

- Entity was previously managed but is no longer associated with that persistence context.
- Changes made to the detached object are not automatically tracked by the old Session.

A managed entity may become detached when the Session closes, `clear()` is called, or the entity is evicted.

### 5.4 Removed

- Entity is marked for deletion from the database.
- The deletion is synchronized during flush.

```
session.remove(employee);
```

### Lifecycle Diagram

```text
        new Employee()
              |
              v
          Transient
              |
          persist()
              |
              v
           Managed
           /     \
      detach()  remove()
          |        |
          v        v
       Detached  Removed
```

The exact transitions depend on the operation used. For example, `merge()` returns a managed instance but does not make the supplied detached object itself managed.

---

## 6. SessionFactory vs Session

| Feature             | SessionFactory                         | Session                         |
|---------------------|----------------------------------------|---------------------------------|
| Nature              | Heavyweight                            | Lightweight                     |
| Thread safety       | Thread-safe                            | Not thread-safe                 |
| Creation            | Usually once per persistence unit      | Created for units of work       |
| Purpose             | Creates Sessions                       | Performs persistence operations |
| Metadata            | Holds configuration and mappings       | Uses the metadata               |
| Persistence context | Not the entity-level first-level cache | Maintains first-level cache     |
| Lifecycle           | Application/persistence-unit lifetime  | Shorter unit-of-work lifetime   |

---

## 7. save() vs persist() vs merge()

### save()

- Hibernate-specific legacy method.
- Returns the generated identifier.
- Not part of the JPA EntityManager API.
- Prefer modern JPA operations in new code.

```java
Serializable id = session.save(employee);
```

### persist()

- Standard JPA operation.
- Makes a new entity managed.
- Returns `void`.
- The database INSERT may occur during the operation or later during flush, depending on the identifier strategy and provider.

```
session.persist(employee);
```

### merge()

- Copies the state of a detached entity into a managed entity.
- Returns the managed instance.
- The supplied detached object does not itself become managed.

```java
Employee managedEmployee = session.merge(detachedEmployee);
```

### Comparison

| Feature                  | save()                                       | persist()                          | merge()                              |
|--------------------------|----------------------------------------------|------------------------------------|--------------------------------------|
| API                      | Hibernate-specific                           | JPA and Hibernate                  | JPA and Hibernate                    |
| Main purpose             | Save a new entity                            | Make a new entity managed          | Copy state into a managed entity     |
| Return type              | Generated identifier                         | `void`                             | Managed entity                       |
| Detached entity handling | Not intended as the standard merge operation | Not for reattaching detached state | Supports detached-state merging      |
| Modern preference        | Legacy usage                                 | Preferred for new entities         | Preferred for merging detached state |

---

## 8. get() vs load()

Both have historically been used to retrieve entities by primary key in Hibernate.

### get()

```java
Employee employee = session.get(Employee.class, 1L);
```

- Historically performs an immediate lookup when the entity is not already available in the persistence context or applicable cache.
- Returns the entity if found.
- Returns `null` if the entity does not exist.

### load()

```java
Employee employee = session.load(Employee.class, 1L);
```

- In older Hibernate APIs, could return a proxy and defer loading until needed.
- Accessing the entity could trigger a database query.
- If the row does not exist, accessing the proxy may cause an exception.

### Comparison

| Feature                     | get()                           | load()                                  |
|-----------------------------|---------------------------------|-----------------------------------------|
| Typical historical behavior | Retrieves the entity            | Can return a proxy                      |
| Missing row                 | Returns `null`                  | May throw an exception when initialized |
| Query timing                | Usually immediate if not cached | May be deferred                         |
| Modern usage                | Version-dependent API           | Legacy API in modern Hibernate          |

**Important:** In modern Hibernate, use the API appropriate to your version. `Session.find()` and `Session.getReference()` are common alternatives; JPA uses `EntityManager.find()` and `EntityManager.getReference()`.

---

## 9. How persist() Works Internally

1. Session receives the entity.
2. Hibernate checks entity mapping metadata.
3. Hibernate reads the required entity state.
4. The entity becomes managed in the persistence context.
5. Hibernate schedules the INSERT operation.
6. During flush, Hibernate generates and executes the required SQL through JDBC.

Example:

```
Employee employee = new Employee();
employee.setName("Piyush");
employee.setSalary(50000);

session.persist(employee);
```

The INSERT does not necessarily execute immediately at the `persist()` call. Timing depends on flush behavior and identifier generation.

## 10. How get() / find() Works Internally

1. Application requests an entity by primary key.
2. Hibernate checks the first-level cache.
3. If the entity is already managed, Hibernate returns it without another SELECT.
4. Depending on the operation and configuration, Hibernate may use the second-level cache.
5. If needed, Hibernate generates SQL.
6. Hibernate executes the query through JDBC.
7. The database returns the result.
8. Hibernate maps the result to an entity.
9. The entity becomes managed in the persistence context.

---

## 11. Hibernate Transactions

A transaction represents a single unit of database work.

### What Happens Internally?

- Session maintains the persistence context.
- Operations such as `persist()`, `remove()`, and changes to managed entities update the persistence context or schedule actions.
- At flush or commit, Hibernate synchronizes pending changes with the database.
- Commit finalizes the database transaction.
- Rollback cancels uncommitted transactional changes.

### Example

```java
class Ts {
    Transaction tx = null;
    void m1() {
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();

            Employee employee = new Employee();
            employee.setName("Piyush");
            employee.setSalary(50000);

            session.persist(employee);

            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }

            throw e;
        }
    }
}
```

### Can a Session Exist Without a Transaction?

Yes.

A Session can exist without an explicit transaction. However, database writes and transaction behavior should be managed correctly. Read operations may run without an explicit transaction in some configurations, but transactional reads are often preferable for consistency.

### Transaction Management in Spring Boot

In Spring applications, transaction management is usually handled using `@Transactional`.

```java
@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void createEmployee(Employee employee) {
        repository.save(employee);
    }
}
```

Spring manages the transaction boundary and coordinates commit or rollback according to its transaction rules.

---

## 12. First-Level Cache (Session Cache)

- The first-level cache is maintained inside a Hibernate Session.
- It is enabled by default.
- It stores managed entities in the persistence context.
- It avoids repeated entity loads for the same identity within that persistence context.
- Every Session has its own first-level cache.
- It is not shared between independent Sessions.

### Example

```java
Employee employee1 = session.get(Employee.class, 1L);
Employee employee2 = session.get(Employee.class, 1L);
```

If the entity remains managed in the same Session, the second lookup normally returns the same managed instance without another entity SELECT.

### Lifecycle

```text
Open Session
     |
     v
First-Level Cache Created
     |
     v
Load / Persist Entities
     |
     v
Managed Entities Stored
     |
     v
Close Session
     |
     v
Persistence Context Ends
```

### When Does the First-Level Cache Expire?

It is associated with the Session's persistence context.

It can be cleared manually:

```
session.clear();
```

A single entity can be evicted:

```
session.evict(employee);
```

Closing the Session ends its persistence context.

---

## 13. HQL (Hibernate Query Language)

- HQL is Hibernate object-oriented query language.
- It works with entity names and entity properties rather than database table names and column names.
- Hibernate translates HQL into SQL appropriate for the configured database dialect.

### Example Entity

```java
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    private Long id;
    private String name;
    private double salary;
}
```

### SQL

```sql
SELECT * FROM employee;
```

### HQL

```java
List<Employee> employees = session
        .createQuery("FROM Employee", Employee.class)
        .getResultList();
```

### HQL with a Condition

```java
List<Employee> employees = session.createQuery(
        "FROM Employee e WHERE e.salary > :salary",
        Employee.class
    )
    .setParameter("salary", 50000.0)
    .getResultList();
```

### SQL vs HQL

| Feature             | SQL                      | HQL                               |
|---------------------|--------------------------|-----------------------------------|
| Uses                | Tables and columns       | Entities and properties           |
| Database dependency | Can be database-specific | Generally database-independent    |
| Translation         | Executed by the database | Hibernate translates it to SQL    |
| Results             | Database rows            | Entity objects or selected values |

### Interview Questions

**Q1. Is HQL database-independent?**

Generally yes, because Hibernate translates it according to the database dialect. Database-specific functions and syntax can still reduce portability.

**Q2. Does HQL use table names?**

No. It normally uses entity names and Java entity properties.

**Q3. What does HQL return?**

It can return entities, scalar values, or projections depending on the query.

**Q4. Is HQL the same as JPQL?**

No. JPQL is standardized by JPA/Jakarta Persistence. HQL is Hibernate query language, which includes additional Hibernate-specific features.

---

## 14. JPA EntityManager and JPQL

### EntityManager

- `EntityManager` is a standard JPA interface.
- It manages entities and their persistence context.
- It supports CRUD operations, queries, flushing, and persistence operations.
- Hibernate provides an implementation of the JPA EntityManager API.

Common methods:

- `persist()`
- `find()`
- `getReference()`
- `merge()`
- `remove()`
- `flush()`
- `clear()`
- `createQuery()`

Example:

```java
Employee employee = entityManager.find(Employee.class, 1L);
```

### JPQL

- JPQL stands for Jakarta Persistence Query Language.
- It queries entities and their properties rather than physical table names.
- It is defined by the JPA specification.

```java
List<Employee> employees = entityManager.createQuery(
        "SELECT e FROM Employee e WHERE e.salary > :salary",
        Employee.class
    )
    .setParameter("salary", 50000.0)
    .getResultList();
```

---

## 15. Criteria API

- The Criteria API is a standard JPA API for building queries programmatically.
- It is useful when query conditions are constructed dynamically at runtime.
- It avoids building the entire query as a concatenated string.

### Steps to Create a Criteria Query

```
CriteriaBuilder cb = entityManager.getCriteriaBuilder();
CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
Root<Employee> root = cq.from(Employee.class);
cq.select(root).where(cb.greaterThan(root.get("salary"), 50000.0));
List<Employee> employees = entityManager
        .createQuery(cq)
        .getResultList();
```

### Steps

1. Obtain `CriteriaBuilder`.
2. Create `CriteriaQuery`.
3. Define the root entity.
4. Add selection and conditions.
5. Execute the query.

---

## 16. Native SQL Queries

- Native SQL allows developers to execute database SQL directly.
- It is useful for database-specific queries, complex SQL, or queries that are difficult to express in HQL/JPQL.
- Native SQL is less portable when it uses database-specific syntax.

---

## 17. Entity Relationships

Hibernate/JPA supports four common relationship types.

| Relationship | Annotation    | Example                                 |
|--------------|---------------|-----------------------------------------|
| One-to-One   | `@OneToOne`   | Person and passport                     |
| One-to-Many  | `@OneToMany`  | Department and employees                |
| Many-to-One  | `@ManyToOne`  | Many employees belong to one department |
| Many-to-Many | `@ManyToMany` | Students and courses                    |

### Many-to-One Example

```java
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;
}
```

```java
@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
```

The `department_id` column in the employee table references the department.

### Owning Side

- The owning side controls the relationship's database mapping.
- In a typical bidirectional relationship, the side containing the foreign key is the owning side.
- `mappedBy` identifies the inverse side.

Example:

```java
@Entity
public class Department {

    @Id
    private Long id;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees;
}
```

Here, `Employee.department` owns the relationship, and `Department.employees` is the inverse side.

---

## 18. Lazy vs Eager Loading

### Lazy Loading

Lazy loading means related data is loaded when it is accessed.


### Eager Loading

Eager loading means the data is loaded eagerly.

---

## 19. Cascade Types

Cascade determines whether a persistence operation on a parent entity is propagated to its associated entities.

| Cascade Type | Meaning                           |
|--------------|-----------------------------------|
| `PERSIST`    | Propagates persist                |
| `MERGE`      | Propagates merge                  |
| `REMOVE`     | Propagates remove                 |
| `REFRESH`    | Propagates refresh                |
| `DETACH`     | Propagates detach                 |
| `ALL`        | Includes all the above operations |

### Example

```java
@OneToMany(
    mappedBy = "department",
    cascade = CascadeType.PERSIST
)
private List<Employee> employees;
```

Persisting the department can also persist its associated employees.

Use `CascadeType.REMOVE` carefully. Removing a parent should not automatically delete associated entities unless that behavior is intended.

---

## 20. Dirty Checking

Dirty checking is a Hibernate feature that detects changes to managed entities and synchronizes those changes with the database.

You usually do not need to call `update()` explicitly for an entity already managed by the current Session.

### Step 1: Load the Entity

```java
Transaction tx = session.beginTransaction();

Employee emp = session.get(Employee.class, 1L);
```

Hibernate executes a SELECT if the entity is not already available in the applicable persistence context or cache.

Suppose:

```text
Employee Object:
id = 1
name = Piyush
salary = 50000

Original Snapshot:
id = 1
name = Piyush
salary = 50000
```

### Step 2: Modify the Entity

```
emp.setSalary(60000);
```

No UPDATE is necessarily executed at this point.

```text
Current Object:
id = 1
name = Piyush
salary = 60000

Original Snapshot:
id = 1
name = Piyush
salary = 50000
```

### Step 3: Flush or Commit

```
tx.commit();
```

During flush, Hibernate detects the change and may execute:

```sql
UPDATE employee
SET salary = 60000
WHERE id = 1;
```

### Dirty Checking Flow

```text
Load Entity
     |
     v
Entity Becomes Managed
     |
     v
Hibernate Tracks State
     |
     v
Modify Java Object
     |
     v
Flush / Commit
     |
     v
Detect Changes
     |
     v
Generate UPDATE SQL
     |
     v
Execute Through JDBC
```

### Interview Question

**When does dirty checking occur?**

Hibernate detects changes to managed entities during synchronization of the persistence context, commonly at flush or transaction commit. The exact internal mechanism can depend on the entity and Hibernate configuration.

---

## 21. Second-Level Cache (L2 Cache)

- The second-level cache is associated with the SessionFactory/persistence-unit scope.
- It can be shared across Sessions.
- It is optional and generally needs configuration.
- It can cache entity state and other supported cacheable data.

### Why Do We Need It?

Without second-level caching:

```text
User A
   |
Session 1
   |
Database

User B
   |
Session 2
   |
Database
```

Each Session has a separate first-level cache. The database may be queried by both Sessions.

With a suitable second-level cache:

```text
Session 1 --------+
                  |
                  v
          Second-Level Cache
                  ^
                  |
Session 2 --------+
                  |
                  v
              Database
```

A later Session may reuse cached entity state instead of retrieving it again from the database.

### Is It Enabled by Default?

The first-level cache is enabled by default. The second-level cache is optional and requires appropriate configuration.

### How to Enable It?

Configure Hibernate second-level cache and a compatible cache provider, such as Ehcache or another supported implementation.

Redis can also be used through an appropriate integration; it is not automatically a built-in Hibernate cache provider.

### Does Second-Level Cache Cache SQL Queries?

No. Entity caching and query-result caching are different mechanisms.

Hibernate query cache, when configured, caches query results or result identifiers depending on the query and cache configuration.

### First-Level vs Second-Level Cache

| Feature                | First-Level Cache            | Second-Level Cache                      |
|------------------------|------------------------------|-----------------------------------------|
| Scope                  | Session/persistence context  | SessionFactory/persistence-unit scope   |
| Shared across Sessions | No                           | Yes                                     |
| Default                | Enabled                      | Optional                                |
| Lifetime               | Persistence-context lifetime | Until eviction, expiration, or shutdown |
| Configuration          | Not required                 | Required                                |
| Main purpose           | Reuse managed entities       | Reuse cached state across Sessions      |

---

## 22. Flush vs Commit

### What Is Flush?

`flush()` synchronizes the persistence context with the database by executing pending SQL statements as required.

```
session.flush();
```

Flush does not commit the transaction.

### What Is Commit?

`commit()` finalizes the transaction. It normally triggers a flush before committing, depending on the transaction and configuration.

```
transaction.commit();
```

### Comparison

| Feature                     | flush()                      | commit()                      |
|-----------------------------|------------------------------|-------------------------------|
| Purpose                     | Synchronizes pending changes | Commits the transaction       |
| SQL execution               | May execute pending SQL      | Usually flushes before commit |
| Permanently commits changes | No                           | Yes                           |

**Important:** A flush can expose SQL errors before commit, but the transaction can still be rolled back if it remains active and the database permits rollback.

---

## 23. Persistence Context

The persistence context is the collection of managed entity instances associated with an EntityManager or Hibernate Session.

Each Hibernate Session has its own persistence context.

### Responsibilities

- Maintains entity identity within the persistence context.
- Acts as the first-level cache.
- Tracks entity changes for dirty checking.
- Coordinates entity lifecycle transitions.
- Synchronizes changes with the database during flush.

### Example

```java
Employee employee1 = entityManager.find(Employee.class, 1L);
Employee employee2 = entityManager.find(Employee.class, 1L);
```

Within the same persistence context, both lookups normally return the same managed Java object for the same entity identity.

---

## 24. How Hibernate Retrieves an Entity End-to-End

Example:

```java
Employee employee = session.get(Employee.class, 1L);
```

### Step 1: Application Calls Session

The request reaches the Hibernate Session.

### Step 2: Check First-Level Cache

Hibernate checks whether `Employee` with ID `1` is already managed in the current persistence context.

- Found: returns the managed entity without another entity SELECT.
- Not found: proceeds with retrieval.

### Step 3: Check Second-Level Cache

If configured and applicable, Hibernate may obtain the required entity state from the second-level cache.

### Step 4: Read Mapping Metadata

Hibernate uses mapping information such as:

```java
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    private Long id;

    private String name;
}
```

### Step 5: Generate SQL

Conceptually:

```sql
SELECT * FROM employee WHERE id = ?;
```

The actual SQL depends on mappings, database dialect, selected columns, and provider behavior.

### Step 6: Use JDBC

Hibernate delegates database communication to JDBC through the configured driver and connection infrastructure.

### Step 7: Database Executes SQL

The database processes the query.

### Step 8: Receive Result

The JDBC driver exposes the returned data to Hibernate.

### Step 9: Map Result to Entity

Hibernate maps the selected columns to the Java entity.

### Step 10: Store in First-Level Cache

The loaded entity is associated with the current persistence context.

### Complete Flow

```text
session.get(Employee.class, 1L)
               |
               v
      First-Level Cache
          /       \
       Found     Not Found
         |           |
         v           v
     Return     Second-Level Cache
                    /       \
                 Found     Not Found
                   |           |
                   v           v
                Return      Generate SQL
                                |
                                v
                               JDBC
                                |
                                v
                             Database
                                |
                                v
                           ResultSet Data
                                |
                                v
                         Map to Entity
                                |
                                v
                       First-Level Cache
                                |
                                v
                           Return Entity
```

---

## 25. N+1 Query Problem

The N+1 query problem occurs when an application executes one query to fetch a collection of parent entities and then executes an additional query for each parent to fetch related data.

### Example

```
List<Employee> employees = entityManager
        .createQuery("SELECT e FROM Employee e", Employee.class)
        .getResultList();

for (Employee employee : employees) {
    System.out.println(employee.getDepartment().getName());
}
```

If the employees belong to different departments and the departments are lazily loaded, Hibernate may execute:

- One query to fetch employees.
- Additional queries to fetch departments.

For N employees, the number of queries may approach N + 1, depending on caching, repeated associations, and provider behavior.

### Possible Solutions

#### 1. JOIN FETCH

```java
List<Employee> employees = entityManager.createQuery(
        "SELECT e FROM Employee e JOIN FETCH e.department",
        Employee.class
    )
    .getResultList();
```

#### 2. Entity Graphs

Use JPA entity graphs to specify which associations should be fetched.

#### 3. Batch Fetching

Configure batch fetching so Hibernate can load multiple associations together.

#### 4. DTO Projection

Fetch only the fields required for the use case.

**Important:** Use fetch joins carefully with pagination, especially when fetching collection associations, because they can produce duplicate parent rows or affect pagination behavior.

---

## 26. Hibernate Dialect

A dialect tells Hibernate how to generate SQL suitable for a particular database.

Examples include dialects for PostgreSQL, MySQL, and Oracle.

Hibernate uses dialect information to account for database-specific SQL syntax, functions, data types, and other capabilities.

The dialect can often be detected automatically when the database connection provides sufficient metadata.

---

## 27. Connection Pooling

Hibernate needs database connections to execute SQL. In application environments, a connection pool is commonly used.

### What Is Connection Pooling?

Connection pooling maintains reusable database connections so the application does not need to establish a new physical connection for every operation.

### Flow

```text
Spring Boot Application
          |
          v
      DataSource
          |
          v
    Connection Pool
          |
          v
    Available Connection
          |
          v
        JDBC
          |
          v
       Database
```

Spring Boot commonly uses HikariCP as its connection pool when JDBC/JPA starter dependencies are configured.

### Why Is Connection Pooling Important?

- Reduces connection-creation overhead.
- Reuses physical connections.
- Controls concurrent database connections.
- Improves application resource management.

A Hibernate Session is not the same as a connection-pool connection. Hibernate obtains and releases connections through its configured connection infrastructure.

---

## 28. Important Hibernate Annotations

| Annotation          | Purpose                                     |
|---------------------|---------------------------------------------|
| `@Entity`           | Defines a persistent entity                 |
| `@Table`            | Configures table mapping                    |
| `@Id`               | Defines primary key                         |
| `@GeneratedValue`   | Configures primary-key generation           |
| `@Column`           | Configures column mapping                   |
| `@Transient`        | Excludes a property from persistence        |
| `@Enumerated`       | Maps enum values                            |
| `@OneToOne`         | One-to-one association                      |
| `@OneToMany`        | One-to-many association                     |
| `@ManyToOne`        | Many-to-one association                     |
| `@ManyToMany`       | Many-to-many association                    |
| `@JoinColumn`       | Configures a join/foreign-key column        |
| `@JoinTable`        | Configures a join table                     |
| `@Embedded`         | Embeds a value object                       |
| `@Embeddable`       | Defines a value object mapping              |
| `@Version`          | Optimistic locking                          |
| `@MappedSuperclass` | Shares mapped fields with entity subclasses |
| `@Inheritance`      | Configures inheritance mapping              |
| `@NamedQuery`       | Defines a named JPQL query                  |

---

## Important Hibernate Questions

### Q1. What is Hibernate?

Hibernate is a Java ORM framework that maps Java objects to relational database tables and handles persistence operations.

### Q2. What is the difference between JPA and Hibernate?

JPA is a standard specification. Hibernate is an ORM framework that implements that specification.

### Q3. What is ORM?

ORM maps Java objects and their properties to database tables and columns.

### Q4. What is SessionFactory?

SessionFactory is a heavyweight, thread-safe object that creates Sessions and maintains mapping/configuration metadata.

### Q5. What is Session?

Session is a non-thread-safe Hibernate object used for persistence operations and maintaining a persistence context.

### Q6. What is the first-level cache?

It is the cache associated with a Session's persistence context and is enabled by default.

### Q7. What is the second-level cache?

It is an optional cache that can share entity state across Sessions.

### Q8. What is dirty checking?

Dirty checking detects changes to managed entities and synchronizes them with the database during flush.

### Q9. What is lazy loading?

Lazy loading defers loading associated data until it is accessed, when the association and persistence context permit it.

### Q10. What is eager loading?

Eager loading requires an association to be loaded eagerly, although the provider determines how to fetch it.

### Q11. What is HQL?

HQL is Hibernate object-oriented query language, which uses entity names and properties.

### Q12. What is JPQL?

JPQL is the standard query language defined by JPA/Jakarta Persistence.

### Q13. What is the Criteria API?

It is an API for constructing queries programmatically, especially useful for dynamic conditions.

### Q14. What is the N+1 query problem?

It occurs when one query loads parent records and additional queries load related data for each parent.

### Q15. What is the difference between flush and commit?

Flush synchronizes pending persistence changes with the database. Commit finalizes the transaction.

### Q16. What is the persistence context?

It manages entity instances, maintains the first-level cache, tracks changes, and coordinates synchronization with the database.

### Q17. What is cascade?

Cascade propagates selected persistence operations from one entity to associated entities.

### Q18. What is optimistic locking?

It detects conflicting concurrent updates, commonly using a version field annotated with `@Version`.

### Q19. What is the difference between persist and merge?

`persist()` makes a new entity managed. `merge()` copies entity state into a managed instance and returns that instance.

### Q20. Does Hibernate eliminate SQL?

No. Hibernate generates SQL for many operations, but developers can still use HQL, JPQL, Criteria API, and native SQL.

### Q21. What is a Hibernate dialect?

It provides database-specific SQL generation rules and capabilities.

### Q22. What is connection pooling?

It reuses physical database connections to reduce connection-establishment overhead and control resource usage.

### Q23. Can a Session be shared between threads?

No. A Hibernate Session is not thread-safe and should be confined to one unit of work at a time.

### Q24. What is the difference between Session and EntityManager?

Session is Hibernate-specific, whereas EntityManager is the standard JPA interface.

### Q25. What is @Transactional in Spring Boot?

It declares a transaction boundary managed by Spring, allowing transactional work to be committed or rolled back according to the configured rules.

---
