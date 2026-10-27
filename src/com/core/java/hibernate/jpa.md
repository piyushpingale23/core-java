# JPA, Spring Data JPA, JPQL, and Native Query

## 1. What is JPA?

JPA (Jakarta Persistence API) is a Java specification that defines how Java objects are mapped to relational database tables.

JPA is a **specification, not an implementation**.

JPA provides:

- Annotations: `@Entity`, `@Id`, `@Table`
- Interfaces: `EntityManager`, `Query`, `TypedQuery`
- Query language: JPQL

Popular JPA implementations:

- Hibernate
- EclipseLink
- OpenJPA

Spring Boot commonly uses Hibernate as its JPA provider.

---

## 2. What is Spring Data JPA?

Spring Data JPA is a Spring module that simplifies database operations by automatically generating repository implementations.

Example:

```java
public interface OrderRepository extends JpaRepository<Order, Long> {
}
```

Common methods:

- `save(order)`
- `findById(101L)`
- `findAll()`
- `deleteById(101L)`

### JPA vs Spring Data JPA

| JPA                                | Spring Data JPA                      |
|------------------------------------|--------------------------------------|
| Java persistence specification     | Spring framework module              |
| Provides `EntityManager`           | Provides `JpaRepository`             |
| Defines persistence APIs and rules | Simplifies repository development    |
| Requires a JPA provider            | Generates repository implementations |

---

## 3. What is JPQL?

JPQL (Jakarta Persistence Query Language) is the standard query language defined by JPA.

It queries entity classes and Java attributes instead of database tables and columns.

Example:

```java
@Query("SELECT o FROM Order o WHERE o.id = :id")
Optional<Order> findOrderById(@Param("id") Long id);
```

Here:

- `Order` is the entity name.
- `o.id` is a Java entity attribute.
- `:id` is a named parameter.
- Hibernate converts JPQL into SQL.

Advantages:

- Generally database-independent.
- Supports entity relationships and joins.
- Uses entity names and Java attributes.

---

## 4. What is a Native Query?

A native query uses actual SQL executed against the database.

Example:

```java
@Query(value = "SELECT * FROM orders WHERE id = :id", nativeQuery = true)
Optional<Order> findOrderById(@Param("id") Long id);
```

Here:

- `orders` is the database table.
- `id` is the database column.
- SQL syntax may be database-specific.

### JPQL vs Native Query

| JPQL                    | Native Query                  |
|-------------------------|-------------------------------|
| Uses entity classes     | Uses database tables          |
| Uses Java attributes    | Uses database columns         |
| Generally more portable | Can use database-specific SQL |

---

## 5. Finding an Order by ID: Different Approaches

Assume `Order` is an entity mapped to the `orders` table, with `id` as its primary key.

### A. Using JPA `EntityManager`

```java
@PersistenceContext
private EntityManager entityManager;

Order order = entityManager.find(Order.class, 101L);
```

- `EntityManager` is a standard JPA interface.
- `find()` retrieves an entity by its primary key.
- Returns the entity or `null` if it does not exist.

### B. Using Spring Data JPA

Repository:

```java
public interface OrderRepository extends JpaRepository<Order, Long> {
}
```

Usage:

```java
Optional<Order> order = orderRepository.findById(101L);
```

- `findById()` is provided by `JpaRepository`.
- Spring Data JPA supplies the repository implementation at runtime.
- Returns an `Optional<Order>`.

### C. Using JPQL

```java
@Query("SELECT o FROM Order o WHERE o.id = :id")
Optional<Order> findOrderById(@Param("id") Long id);
```

- Spring Data JPA passes the JPQL query to the JPA provider.
- Hibernate translates it into SQL.

### D. Using a Native Query

```java
@Query(value = "SELECT * FROM orders WHERE id = :id", nativeQuery = true)
Optional<Order> findOrderById(@Param("id") Long id);
```

- The developer writes SQL directly.
- Hibernate executes it through JDBC and maps the result to `Order`.

## 6. Who Converts JPQL into SQL?

Hibernate converts JPQL into SQL. The JDBC driver does not convert JPQL.

Execution flow:

```text
Repository / EntityManager
          |
          v
         JPQL
          |
          v
       Hibernate
          |
          | Converts JPQL into SQL
          v
     JDBC Driver
          |
          v
       Database
```

Responsibilities:

- **Hibernate:** Translates JPQL into SQL and maps results to entities.
- **Hibernate Dialect:** Supplies database-specific SQL-generation rules.
- **JDBC Driver:** Communicates SQL and parameters to the database and receives results.
- **Database:** Executes SQL.

## 7. Should We Always Use JPQL?

JPQL is generally the first choice for common entity-based queries because it is more portable across databases.

For example, the same JPQL query can often work with PostgreSQL and Oracle without changing the query.

Use native SQL when you need database-specific features, complex SQL, or functionality unavailable through standard JPQL.

## 8. Are JPQL and HQL the Same?

No, but they are closely related.

- **JPQL:** Standard query language defined by JPA.
- **HQL:** Hibernate Query Language, which supports JPQL and Hibernate-specific extensions.
- Hibernate supports JPQL queries.

## Quick Interview Revision

| Question                      | Answer                                                                              |
|-------------------------------|-------------------------------------------------------------------------------------|
| What is JPA?                  | A Java persistence specification.                                                   |
| What is Hibernate?            | A popular JPA provider and ORM framework.                                           |
| What is Spring Data JPA?      | A Spring module that simplifies repository development.                             |
| What is `EntityManager`?      | A JPA interface for managing entities and persistence operations.                   |
| What is `JpaRepository`?      | A Spring Data JPA interface providing repository operations.                        |
| What is JPQL?                 | A query language using entity names and Java attributes.                            |
| What is a native query?       | SQL written directly for the database.                                              |
| Who converts JPQL into SQL?   | Hibernate or the active JPA provider.                                               |
| What does the JDBC driver do? | Communicates with the database using JDBC.                                          |
| What is Hibernate Dialect?    | Provides database-specific SQL-generation rules.                                    |
| Should we prefer JPQL?        | Generally yes, for portable entity-based queries.                                   |
| How does `findById()` work?   | Spring Data JPA provides the implementation, which uses JPA persistence operations. |
