package com.core.java.marker_interface.serializable.with;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

// This class implements Serializable
// So objects of this class CAN be serialized
public class Employee implements Serializable {

    int id = 101;
}

class EmployeeTest {

    public static void main(String[] args) throws Exception {

        // IMPORTANT POINT:
        // Serialization depends on the ACTUAL object class
        // NOT on the class where main method is written

        // Here object is created from a DIFFERENT package class:
        // com.core.java.marker_interface.serializable.without.Student

        // That class does NOT implement Serializable
        // So JVM will not allow serialization of this object

        Employee e = new Employee();

        // FileOutputStream:
        // Used to write raw bytes into a file
        FileOutputStream fos = new FileOutputStream("employeeTest.txt");

        // ObjectOutputStream:
        // Converts Java object into byte stream (serialization)
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        // JVM internally checks:
        // 1. What is actual runtime class of object 's'?
        // 2. Does it implement Serializable?

        // If YES → serialize object into byte stream
        // If NO  → throw NotSerializableException

        oos.writeObject(e); // Runtime exception occurs here

        // Closing streams is important to release system resources
        oos.close();
        fos.close();
    }
}