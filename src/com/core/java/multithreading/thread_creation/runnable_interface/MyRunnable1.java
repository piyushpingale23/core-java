package com.core.java.multithreading.thread_creation.runnable_interface;

// simple thread creation programme using Runnable interface.
public class MyRunnable1 implements Runnable{

    @Override
    public void run() {
        System.out.println("Child Thread!");
    }

    public static void main(String[] args) {

        MyRunnable1 myRunnable1 = new MyRunnable1();
        Thread t1 = new Thread(myRunnable1);
        t1.start();
        System.out.println("main Thread!");

    }
}
