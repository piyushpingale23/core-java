package com.core.java.multithreading.thread_creation.thread_class;

/**
 * Scenario Explanation: Overriding start() method <br>
 * <br>
 * 1. The Thread class already provides a start() method: <br>
 *    public void start() <br>
 * <br>
 * 2. start() is responsible for: <br>
 *    - Creating a new thread <br>
 *    - Registering it with Thread Scheduler <br>
 *    - Internally calling run() <br>
 * <br>
 * 3. If we override start() method: <br>
 *    - JVM will NOT use Thread class's start() implementation <br>
 *    - Our overridden start() method will execute like a normal method call <br>
 *    - No new thread will be created <br>
 * <br>
 * 4. In this case: <br>
 *    - run() method will NOT be called automatically <br>
 *    - Because original start() logic is bypassed <br>
 * <br>
 * Conclusion: <br>
 * Overriding start() breaks the multithreading behavior and makes it a normal method call. <br>
 */

public class MyThread4 extends Thread {

    @Override
    public void start() {
        System.out.println("Start method (overridden) - No new thread created");
    }

    @Override
    public void run() {
        System.out.println("Child Thread!");
    }

    public static void main(String[] args) {

        MyThread4 t4 = new MyThread4();

        // This will NOT create a new thread
        // It will call overridden start() as a normal method
        t4.start();

        // Executed by main thread
        System.out.println("Main Thread!");
    }
}