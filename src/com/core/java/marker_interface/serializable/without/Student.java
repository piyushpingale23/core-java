package com.core.java.marker_interface.serializable.without;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

// Student class is NOT implementing Serializable
// So JVM will NOT allow this object to be serialized
public class Student {

    int id = 101;
}

class StudentTest {

    public static void main(String[] args) throws Exception {

        // Creating object in heap memory (RAM)
        Student s = new Student();

        // FileOutputStream → used to write raw bytes into file
        FileOutputStream fos = new FileOutputStream("studentTest.txt");

        // ObjectOutputStream → converts object into byte stream
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        // THIS IS THE IMPORTANT STEP
        // JVM will try to convert object "s" into byte stream

        // BUT:
        // Since Student class does NOT implement Serializable
        // JVM will throw: NotSerializableException

        oos.writeObject(s); // Runtime error here

        oos.close();
        fos.close();
    }
}