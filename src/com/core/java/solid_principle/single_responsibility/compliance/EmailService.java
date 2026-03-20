package com.core.java.solid_principle.single_responsibility.compliance;

public class EmailService {

    /*
     * Responsibility:
     * This class is responsible only for handling email-related operations.
     *
     * According to the Single Responsibility Principle (SRP),
     * a class should have only one reason to change.
     *
     * This class does NOT handle any user-related logic (like CRUD operations).
     * Its only responsibility is sending emails.
     */

    public void sendEmail() {
        System.out.println("Email sent");
    }

}
