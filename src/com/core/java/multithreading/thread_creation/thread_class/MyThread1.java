package com.core.java.multithreading.thread_creation.thread_class;

// simple thread creation programme using Thread class.
public class MyThread1 extends Thread {

    public void run() {

        for (int i = 0; i < 10; i++) {
            System.out.println("Child Thread : " + i);
        }
    }

    public static void main(String[] args) {

        MyThread1 t1 = new MyThread1(); // main thread create the child thread object (child thread instantiation)
        t1.start(); // main thread start child thread
        System.out.println("Main Thread!");
    }
}

/*
 * How start() invokes run():
 *
 * 1. When we call t1.start(), we are NOT directly calling run().
 *
 * 2. The start() method is defined inside the Thread class.
 *    Internally, start() does the following:
 *
 *    - Registers this thread with the Thread Scheduler (JVM + OS)
 *    - Creates a new separate call stack for the thread
 *    - Then the JVM internally calls the run() method
 *
 * 3. So flow is:
 *
 *    main() --> t1.start()
 *             --> JVM creates new thread
 *             --> Thread Scheduler picks it
 *             --> JVM internally calls t1.run()
 *
 * 4. Important:
 *
 *    - If you call t1.run() directly:
 *        It will behave like a normal method call
 *        No new thread will be created
 *
 *    - If you call t1.start():
 *        A new thread is created
 *        run() executes in parallel with main thread
 *
 * 5. Output behavior:
 *
 *    Since two threads run simultaneously:
 *      - Main Thread
 *      - Child Thread
 *
 *    Output order is NOT guaranteed:
 *      Sometimes "Main Thread!" prints first
 *      Sometimes child thread prints first
 *
 * 6. Summary:
 *
 *    start() -> creates new thread -> JVM internally calls run()
 *    run()   -> contains actual task logic
 */
