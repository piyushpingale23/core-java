package com.core.java.object_class;

/**
 * The Person record represents an immutable data carrier class in Java. <br>
 * <br>
 * A record is a special type of class introduced in Java 16 that is used to <br>
 * store immutable data. It automatically generates common methods such as: <br>
 * <br>
 * 1. Constructor <br>
 * 2. Getter methods <br>
 * 3. toString() <br>
 * 4. equals() <br>
 * 5. hashCode() <br>
 * <br>
 * Records help reduce boilerplate code when creating simple data classes. <br>
 * <br>
 * In this example: <br>
 * - id   : represents the unique identifier of a person <br>
 * - name : represents the name of the person <br>
 * <br>
 * Since this is a record: <br>
 * - The fields are automatically final <br>
 * - The class is immutable <br>
 * - Getter methods are automatically created with the same name as the field <br>
 * <br>
 * Example usage: <br>
 * <br>
 * Person p = new Person(1, "Jack"); <br>
 * <br>
 * Accessing values: <br>
 * p.id();    // returns id <br>
 * p.name();  // returns name <br>
 * <br>
 * Records are typically used for: <br>
 * - DTOs (Data Transfer Objects) <br>
 * - API responses <br>
 * - Configuration objects <br>
 * - Simple data holder classes <br>
 */
public record Person(int id, String name) {
}