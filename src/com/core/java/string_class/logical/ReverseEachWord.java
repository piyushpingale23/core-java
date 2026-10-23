package com.core.java.string_class.logical;

public class ReverseEachWord {

    public static void main(String[] args) {
        
        String s = "i love core java";
        String[] sArray = s.split(" ");
        String reverseEachWord = "";
        for (String s1 : sArray) {
            if (s1.length() == 1) {
                reverseEachWord = reverseEachWord + s1;
            } else {
                reverseEachWord = reverseAndAppendWord(s1, reverseEachWord);
            }
        }
        System.out.println(reverseEachWord);
    }

    private static String reverseAndAppendWord(String s1, String reverseEachWord) {
        String reverseWord = " ";
        char[] chars = s1.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            reverseWord = reverseWord + s1.charAt(i);
        }

        return reverseEachWord.concat(reverseWord);


    }
}
