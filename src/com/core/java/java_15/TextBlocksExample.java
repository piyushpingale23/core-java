package com.core.java.java_15;


/*
 * Java 15 Feature: Text Blocks
 *
 * Before Java 15:
 * - Multiline strings required \n, or multiple lines of code.
 * - Quotes inside strings often required escaping with \".
 *
 * Text Blocks (Java 15):
 * - Use three double quotes (""") to define a multiline string.
 * - Improve readability when writing JSON, SQL, HTML, and other multiline text.
 * - Preserve line breaks in the string.
 * - Incidental indentation is removed according to the closing delimiters position.
 * - Text blocks became permanent in Java 15 (JEP 378).
 */

public class TextBlocksExample {

    public static void main(String[] args) {

        // Traditional string
        String traditional = "{\n" +
                "    \"name\": \"Java\",\n" +
                "    \"version\": 15\n" +
                "}";

        System.out.println("Traditional String:");
        System.out.println(traditional);

        // Text block: multiline string with less syntax
        String textBlock = """
                {
                    "name": "Java",
                    "version": 15
                }""";

        System.out.println("\nText Block:");
        System.out.println(textBlock);

        // Text blocks are useful for SQL queries
        String sql = """
                SELECT name, salary
                FROM employee
                WHERE salary > 50000
                """;

        System.out.println("\nSQL Query:");
        System.out.println(sql);

        // Quotes can be included without escaping
        String message = """
                He said, "Java is powerful!"
                """;

        System.out.println("Message:");
        System.out.println(message);
    }
}
