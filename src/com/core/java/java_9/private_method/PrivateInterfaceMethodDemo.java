package com.core.java.java_9.private_method;

interface NotificationService {

    // Private helper: only methods inside this interface can call it.
    private void validateNotification() {
        System.out.println("Validating notification");
    }

    // Default method: implementing classes inherit this behavior.
    default void sendEmail() {
        validateNotification();
        System.out.println("Sending email");
    }

    default void sendSMS() {
        validateNotification();
        System.out.println("Sending SMS");
    }
}

class NotificationServiceImpl implements NotificationService {
    // No implementation is required for the default methods.
}

public class PrivateInterfaceMethodDemo {

    public static void main(String[] args) {

        NotificationService service = new NotificationServiceImpl();

        service.sendEmail();
        service.sendSMS();
    }
}
