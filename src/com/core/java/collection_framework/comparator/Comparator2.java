package com.core.java.collection_framework.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class                     Employee {

    public int id;
    public String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return ("Employee Id: " + id + " & name: " + name);
    }
}

class MyComparator implements Comparator<Employee> {


    @Override
    public int compare(Employee e1, Employee e2) {
//        return (e1.id < e2.id) ? 1 : (e1.id > e2.id) ? -1 : 0;
        return Integer.compare(e2.id, e1.id);
    }
}

public class Comparator2 {

    public static void main(String[] args) {

        List<Employee> arrayList = new ArrayList<>();
        arrayList.add(new Employee(101, "A"));
        arrayList.add(new Employee(105, "B"));
        arrayList.add(new Employee(103, "Y"));
        arrayList.add(new Employee(111, "C"));
        arrayList.add(new Employee(105, "H"));

        System.out.println("Before Sorting: " + arrayList);

//        Collections.sort(arrayList, new MyComparator());
        arrayList.sort(new MyComparator());

        System.out.println("After Sorting: " + arrayList);





    }


}
