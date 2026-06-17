package com.core.java.java_8.method_references;

import java.util.Arrays;
import java.util.List;

//Static Method Reference using Method References
public class MethodReferencesExample1 {

    public static void printName(String name) {
        System.out.println(name);
    }

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Java", "Python", "TypeScript");

        names.forEach(MethodReferencesExample1::printName);
    }
}


//Static Method Reference using Lambda Expression
class UsingLambdaExpression1 {

    public static void printName(String name) {
        System.out.println(name);
    }

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Java", "Python", "TypeScript");

        names.forEach(name -> UsingLambdaExpression1.printName(name));
    }
}