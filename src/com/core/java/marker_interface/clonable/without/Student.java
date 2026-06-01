//package com.core.java.marker_interface.clonable.without;
//
//// This class does NOT implement Cloneable
//// So cloning is NOT allowed
//public class Student {
//
//    int id = 10;
//}
//
//class Test {
//
//    public static void main(String[] args) throws Exception {
//
//        Student student = new Student();
//
//        // This will fail because:
//        // 1. clone() is not accessible
//        // 2. Student does not implement Cloneable
//        // 3. JVM will throw CloneNotSupportedException
//
//        Student student1 = (Student) student.clone(); // compile/runtime issue
//    }
//}