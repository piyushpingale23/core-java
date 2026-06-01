package com.core.java.design_principle.solid.single_responsibility.compliance;

public class UserService {

    /*
     * Responsibility:
     * This class is responsible only for user-related operations (CRUD).
     *
     * According to the Single Responsibility Principle (SRP),
     * a class should have only one reason to change.
     *
     * Any changes related to user logic (e.g., create, update, delete)
     * should be handled here.
     *
     * It does NOT handle other responsibilities like sending emails, messages.
     */

    public void createUser() {
        System.out.println("User created");
    }

    public static void main(String[] args) {

        UserService userService = new UserService();
        userService.createUser();

        EmailService emailService = new EmailService();
        emailService.sendEmail();

    }
}
