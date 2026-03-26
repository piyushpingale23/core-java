package com.core.java.string_class.methods;

public class StringMethods {

    public static void main(String[] args) {

        //          0123456789012345678
        String s = "  Hello Jack Jane  ";
        String s2 = "HELLO JACK JANE";
        String s3 = "Hello";

        // 1. length()
        System.out.println("Length: " + s.length());

        // 2. charAt()
        System.out.println("charAt(2): " + s.charAt(2));

        // 3. substring()
        System.out.println("Substring(2): " + s.substring(2));
        System.out.println("Substring(2, 7): " + s.substring(2, 7));

        // 4. equals()
        System.out.println("Equals: " + s.equals(s2));

        // 5. equalsIgnoreCase()
        System.out.println("Equals Ignore Case: " + s.trim().equalsIgnoreCase(s2));

        // 6. compareTo()
        System.out.println("CompareTo: " + s3.compareTo("World"));

        // 7. compareToIgnoreCase()
        System.out.println("CompareTo IgnoreCase: " + s3.compareToIgnoreCase("hello"));

        // 8. toLowerCase()
        System.out.println("LowerCase: " + s.toLowerCase());

        // 9. toUpperCase()
        System.out.println("UpperCase: " + s.toUpperCase());

        // 10. trim()
        System.out.println("Trim: [" + s.trim() + "]");

        // 11. strip() (Java 11+)
        System.out.println("Strip: [" + s.strip() + "]");

        // 12. contains()
        System.out.println("Contains 'Jack': " + s.contains("Jack"));

        // 13. startsWith()
        System.out.println("StartsWith '  He': " + s.startsWith("  He"));

        // 14. endsWith()
        System.out.println("EndsWith '  ': " + s.endsWith("  "));

        // 15. indexOf()
        System.out.println("IndexOf 'P': " + s.indexOf('P'));

        // 16. lastIndexOf()
        System.out.println("LastIndexOf 'a': " + s.lastIndexOf('a'));

        // 17. replace()
        System.out.println("Replace: " + s.replace("Jack", "Java"));

        // 18. replaceAll() (regex)
        System.out.println("ReplaceAll: " + s.replaceAll("\\s", "_"));

        // 19. replaceFirst()
        System.out.println("ReplaceFirst: " + s.replaceFirst(" ", "_"));

        // 20. split()
        String[] arr = s.trim().split(" ");
        System.out.println("Split:");
        for (String word : arr) {
            System.out.println(word);
        }

        // 21. concat()
        System.out.println("Concat: " + s3.concat(" World"));

        // 22. isEmpty()
        System.out.println("IsEmpty: " + s.isEmpty());

        // 23. isBlank() (Java 11+)
        System.out.println("IsBlank: " + "   ".isBlank());

        // 24. toCharArray()
        char[] chars = s3.toCharArray();
        System.out.print("toCharArray: ");
        for (char c : chars) {
            System.out.print(c + " ");
        }
        System.out.println();

        // 25. valueOf()
        int num = 100;
        String numStr = String.valueOf(num);
        System.out.println("ValueOf: " + numStr);

        // 26. join()
        String joined = String.join("-", "Java", "is", "awesome");
        System.out.println("Join: " + joined);

        // 27. intern()
        String a = new String("Java");
        String b = a.intern();
        System.out.println("Intern: " + (a == b)); // false or true based on pool

        // 28. repeat() (Java 11+)
        System.out.println("Repeat: " + "Hi ".repeat(3));

        // 29. matches() (regex)
        System.out.println("Matches (only letters): " + "Hello".matches("[A-Za-z]+"));

        // 30. contentEquals()
        System.out.println("ContentEquals: " + s3.contentEquals("Hello"));

        // 31. regionMatches()
        System.out.println("RegionMatches: " + s.regionMatches(true, 2, "hello", 0, 5));

        // 32. subSequence()
        System.out.println("SubSequence: " + s.subSequence(2, 7));

        // 33. hashCode()
        System.out.println("HashCode: " + s.hashCode());

        // 34. toString()
        System.out.println("toString: " + s.toString());

        // 35. formatted() (Java 15+)
        String formatted = "My name is %s".formatted("Jack");
        System.out.println("Formatted: " + formatted);

        // 36. lines() (Java 11+)
        String multiLine = "Java\nPython\nC++";
        multiLine.lines().forEach(System.out::println);

        // 37. stripLeading() & stripTrailing()
        System.out.println("StripLeading: [" + s.stripLeading() + "]");
        System.out.println("StripTrailing: [" + s.stripTrailing() + "]");

        // 38. codePointAt()
        System.out.println("CodePointAt(0): " + s.codePointAt(0));

        // 39. getBytes()
        byte[] bytes = s3.getBytes();
        System.out.print("GetBytes: ");
        for (byte b1 : bytes) {
            System.out.print(b1 + " ");
        }
        System.out.println();

        // 40. getChars()
        char[] dst = new char[5];
        s3.getChars(0, 5, dst, 0);
        System.out.print("GetChars: ");
        for (char c : dst) {
            System.out.print(c + " ");
        }
        System.out.println();

    }
}