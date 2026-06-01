package com.core.java.design_principle.solid.single_responsibility.violation;

public class UserService {

    public void createUser() {
        System.out.println("User created");
    }

    public void sendEmail() {
        System.out.println("Email sent");
    }

    public static void main(String[] args) {

        UserService userService = new UserService();
        userService.createUser();
        userService.sendEmail();

    }

    /*
     * Problem (SRP Violation):
     * This class handles multiple responsibilities:
     * - User-related operations (CRUD)
     * - Email sending functionality
     *
     * According to the Single Responsibility Principle (SRP),
     * a class should have only one reason to change.
     *
     * In this case:
     * - If user logic changes → this class changes
     * - If email logic changes → this class also changes
     *
     * This means the class has multiple reasons to change,
     * which violates SRP.
     *
     * Correct Approach:
     * - Keep user-related logic in UserService
     * - Move email functionality to a separate EmailService class
     */
}
