package com.core.java.string_class.logical;

public class LargestWordInSentence {

    public static void main(String[] args) {

        String s = "Java is powerful language";
        String[] sArray = s.split(" ");

        int largestWordSize = 0;
        for (String s1 : sArray) {
            if (s1.length() > largestWordSize) {
                largestWordSize = s1.length();
            }
        }

        System.out.println("Largest word size in given string: " + largestWordSize);
    }
}
