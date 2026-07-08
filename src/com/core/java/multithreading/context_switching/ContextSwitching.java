package com.core.java.multithreading.context_switching;

public class ContextSwitching {

    /*
     * CONTEXT SWITCHING
     * -----------------
     * Context switching is the process where the CPU stops executing one thread
     * and starts executing another thread.
     *
     * Before switching, the Operating System saves the current thread's state:
     * - Program Counter (next instruction to execute)
     * - CPU Registers
     * - Stack Pointer
     *
     * Later, when the thread gets CPU time again, its state is restored and
     * execution continues from where it stopped.
     *
     * Why does context switching happen?
     * 1. Time slice (quantum) expires.
     * 2. Thread calls sleep().
     * 3. Thread waits for I/O.
     * 4. Thread waits for a lock/resource.
     * 5. Higher-priority thread becomes runnable.
     *
     * In this example:
     * - Thread-1 prints numbers from 1 to 5.
     * - After every print, it sleeps for 1 second.
     * - While Thread-1 is sleeping, the CPU can switch to Thread-2.
     * - This switch from one thread to another is called Context Switching.
     */

    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {

            for (int i = 1; i <= 5; i++) {

                System.out.println(
                        Thread.currentThread().getName() + " : " + i
                );

                try {

                    /*
                     * Thread-1 enters TIMED_WAITING state.
                     * It cannot use the CPU during this period.
                     *
                     * The scheduler may perform a context switch
                     * and allow Thread-2 to run.
                     */
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread-1");

        Thread thread2 = new Thread(() -> {

            for (char ch = 'A'; ch <= 'E'; ch++) {

                System.out.println(
                        Thread.currentThread().getName() + " : " + ch
                );

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread-2");

        thread1.start();
        thread2.start();
    }
}
