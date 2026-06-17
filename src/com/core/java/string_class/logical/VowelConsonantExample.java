package com.core.java.string_class.logical;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VowelConsonantExample {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter String -> " );
        String s = sc.nextLine();
        List<Character> vowelList = new ArrayList<>();

        int vowelCount = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u' ||
                    s.charAt(i) == 'A' || s.charAt(i) == 'E' || s.charAt(i) == 'I' || s.charAt(i) == 'O' || s.charAt(i) == 'U') {

                vowelCount++;
                vowelList.add(s.charAt(i));
            }
        }

        System.out.println("Vowel Count -> " + vowelCount + vowelList);
        System.out.println("Consonant Count -> " + (s.length() - vowelCount));


    }
}
