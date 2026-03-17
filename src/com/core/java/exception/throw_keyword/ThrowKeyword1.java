package com.core.java.exception.throw_keyword;

import java.util.Scanner;

// Case: Unhandled runtime exception → JVM handles it → program terminates abnormally.
public class ThrowKeyword1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter age : ");
        int age = sc.nextInt();

        validateAgeForVoting (age);

/*        if caller method handle the exception
        try {
            validateAgeForVoting(age);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }*/

    }

    private static void validateAgeForVoting(int age) {

        if (age < 18) {
            throw new ArithmeticException("Not eligible to vote"); //here we throw the exception to handler method, but it could not be handled, so abnormal termination.
                                                                   // if caller method (main()) handled it by try-catch, then normal termination
        }

        System.out.println("You can vote");
    }

}

// 1. 'throw' keyword is used to manually create and throw an exception
// 2. It is generally used for validation or business rule failures
// 3. It creates an exception object in HEAP memory
// 4. After 'throw', JVM stops normal execution immediately
// 5. JVM checks for a matching catch block in the current method
// 6. If not found, it propagates the exception up the call stack (bubbling up the exception)
// 7. If no handler is found anywhere, JVM's Default Exception Handler handles it
// 8. Default handler prints:
//      - Exception type
//      - Error message
//      - Stack trace
// 9. Any code written after 'throw' becomes unreachable (logically)
