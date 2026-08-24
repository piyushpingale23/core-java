package com.core.java.multithreading.thread_creation.method_reference;

public class MethodReferenceExample {

    public static void customMethod() {

        for (int i = 1; i <= 5; i++) {

            System.out.println(Thread.currentThread().getName() + " : " + i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("Main start : " + Thread.currentThread().getName());

        Thread t1 = new Thread(MethodReferenceExample::customMethod, "Custom-Thread");
        t1.start();

        System.out.println("Main end : " + Thread.currentThread().getName());
    }
}
