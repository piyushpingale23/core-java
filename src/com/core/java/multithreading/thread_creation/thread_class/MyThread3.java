package com.core.java.multithreading.thread_creation.thread_class;

/**
 * Scenario Explanation: Override run() method has empty implementation <br>
 * <br>
 * 1. The Thread class already has a default implementation of run(): <br>
 *    public void run() { <br>
 *        // empty implementation <br>
 *    } <br>
 * <br>
 * 2. In this case, we are overriding run() but leaving it empty. <br>
 * <br>
 * 3. When we call t3.start(): <br>
 *    - JVM creates a new thread <br>
 *    - JVM internally calls the overridden run() method <br>
 * <br>
 * 4. Since our overridden run() method is empty: <br>
 *    - No task is executed in the child thread <br>
 *    - So, no output is produced from the child thread <br>
 * <br>
 * 5. Only the main thread continues execution and prints output <br>
 * <br>
 * Conclusion: <br>
 * Even though a new thread is created, it does nothing because run() is empty. <br>
 */

public class MyThread3 extends Thread {

    // Overridden run() method with empty implementation
    @Override
    public void run() {
        // No task defined here
    }

    public static void main(String[] args) {

        MyThread3 t3 = new MyThread3();

        // Creates a new thread and invokes run()
        t3.start();

        // Executed by main thread
        System.out.println("Main Thread!");
    }
}