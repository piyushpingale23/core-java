package com.core.java.string_class.logical;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountCharacterTypes {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter String -> " );
        String s = sc.nextLine();

        List<Character> letterList = new ArrayList<>();
        List<Character> digitList = new ArrayList<>();
        List<Character> specialList = new ArrayList<>();

        int letters = 0, digits = 0, special = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isLetter(ch)) {
                letterList.add(ch);
                letters++;
            } else if (Character.isDigit(ch)) {
                digitList.add(ch);
                digits++;
            } else {
                specialList.add(ch);
                special++;
            }
        }

        System.out.println("Letters = " + letters + " -> " + letterList);
        System.out.println("Digits = " + digits + " -> " + digitList);
        System.out.println("Special = " + special + " -> " + specialList);
    }
}
