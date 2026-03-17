package com.core.java.hasA;

public class Association {

    public static void main(String[] args) {

        Teacher t = new Teacher("Jack");
        Student s = new Student("Jane");

        s.assignTeacher(t);
    }
}

class Teacher {

    String name;

    Teacher(String name) {
        this.name = name;
    }
}

class Student {

    String name;

    Student(String name) {
        this.name = name;
    }

    void assignTeacher(Teacher teacher) {
        System.out.println(this.name + " is assigned to teacher " + teacher.name);
    }
}

//Student class references a Teacher object temporarily via assignTeacher().
//Teacher can exist without a Student.
//Student can exist without a Teacher.

//What happens if Teacher is deleted?
//In Java, “deleting” an object usually means no reference points to it, and then it becomes eligible for garbage collection.

//Scenario 1: Only the local reference goes out of scope

//Teacher t = new Teacher("Jack");
//s.assignTeacher(t);
//t = null; // t no longer points to Teacher object

//The Student object does not store the Teacher reference permanently (in your code).
//So now the Teacher object has no references pointing to it, and it can be garbage collected.
//Student still exists — but it cannot access Teacher anymore, because it did not keep a reference.