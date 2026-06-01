# Multithreading & Multitasking

## 1. What is Multitasking?

Multitasking is the ability of an operating system to execute multiple tasks at the same time.

Example:
- Browsing the internet
- Playing music
- Running code

All happening simultaneously.

---

## 2. Types of Multitasking

### 2.1 Process-Based Multitasking

- Each task runs as an independent process
- Each process has its own memory space
- Also called heavyweight multitasking

Example:
- Running Chrome, VS Code, and Spotify together

Key Features:
- High memory consumption
- Slower context switching
- More secure (process isolation)

---

### 2.2 Thread-Based Multitasking

- Each task is a thread (part of a process)
- Threads share the same memory space
- Also called lightweight multitasking

Example:
- Typing in a document while auto-save runs in the background

Key Features:
- Low memory consumption
- Faster execution
- Requires synchronization (shared data issues)

---

## 3. What is Multithreading?

Within an application, there is multiple part of execution, each part is called thread. All threads become multithreading.

Multithreading means multiple tasks or multiple threads execute parallel.

Multithreading is a feature in Java that allows multiple threads to execute concurrently within a single process.

Purpose:
- Better CPU utilization
- Faster execution
- Perform multiple tasks simultaneously

---

## 4. What is a Thread?

A thread is the smallest unit of execution within a process.

Key Points:
- Threads are lightweight
- Threads share memory
- Multiple threads can run independently

---

## 5. What is Thread Scheduler?

Thread Scheduler is a part of the JVM that decides which thread should run at a given time.

Key Points:
- It uses priority and scheduling algorithms
- Behavior is JVM and OS dependent
- Common approaches:
    - Preemptive Scheduling (most common)
    - Time Slicing

---

## 6. Ways to Create Threads in Java

Java provides two main ways to create threads:

---

### 6.1 By Extending Thread Class

```java
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread is running using Thread class");
    }

    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start(); // starts a new thread
    }
}
```

Key Points:

- Override the run() method
- Call start() to begin execution
- Cannot extend another class (Java limitation)

#### 6.1.1. Difference: start() vs run() vs No Call

| Feature / Case          | `start()`                           | `run()` directly                     | No method call          |
|-------------------------|-------------------------------------|--------------------------------------|-------------------------|
| Thread creation         | New thread is created by JVM        | No new thread is created             | No thread is created    |
| Execution context       | Runs in separate call stack         | Runs in main thread stack            | No execution            |
| Method execution        | `run()` is called internally by JVM | `run()` is called like normal method | `run()` is never called |
| Multithreading behavior | Yes (true multithreading)           | No (single-threaded execution)       | No multithreading       |
| Scheduler involvement   | Yes (thread scheduler manages it)   | No scheduler involvement             | Not applicable          |
| Parallel execution      | Possible                            | Not possible                         | Not applicable          |
| CPU utilization         | Efficient (concurrent execution)    | Inefficient (sequential execution)   | No usage                |
| Output behavior         | Order not guaranteed                | Sequential output in main thread     | No output               |

---

### 6.2 By Implementing Runnable Interface

```java
class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Thread is running using Runnable interface");
    }

    public static void main(String[] args) {
        MyRunnable obj = new MyRunnable();
        Thread t1 = new Thread(obj);
        t1.start();
    }
}
```

Key Points:

- Implements Runnable interface
- Override run() method
- Better approach (supports multiple inheritance)

---

## 7. Difference: Thread vs Runnable

| Feature              | Thread Class                    | Runnable Interface               |
|----------------------|---------------------------------|----------------------------------|
| Type                 | Class                           | Interface                        |
| Definition           | Extends Thread class            | Implements Runnable interface    |
| Purpose              | Used to create and run a thread | Used to define a task            |
| Thread Creation      | Directly creates thread         | Passed to Thread object          |
| start() Method       | Available in Thread class       | Not available                    |
| run() Method         | Overridden in Thread class      | Overridden in Runnable interface |
| Multiple Inheritance | Not supported                   | Supported                        |
| Reusability          | Low                             | High                             |
| Coupling             | Tight coupling                  | Loose coupling                   |
| Memory Efficiency    | Less efficient                  | More efficient                   |
| Flexibility          | Less flexible                   | More flexible                    |
| Best Use Case        | Simple programs                 | Real-world applications          |

---

## Final Conclusion

- **Thread class** represents a thread itself and controls execution.
- **Runnable interface** represents only the task, and the Thread class executes it.

Runnable is generally preferred in real-world applications due to better design and flexibility.

---

## 8. Thread Life Cycle in Java

A thread goes through different states during its execution:

States: New -> Runnable -> Running -> Blocked / Waiting -> Terminated

````
        +---------+
        |  NEW    |
        +---------+
             |
             | start()
             v
        +-------------+
        |  RUNNABLE   |
        +-------------+
             |
             | CPU Scheduler
             v
        +-------------+
        |  RUNNING    |
        +-------------+
          |        |
          |        | run() completes
          |        v
          |   +-------------+
          |   | TERMINATED  |
          |   +-------------+
          |
          | wait()/sleep()/lock
          v
   +-------------------+
   | BLOCKED/WAITING   |
   +-------------------+
          |
          | notify / resume / lock released
          v
        RUNNABLE
````

---

## 9. Thread Priority


### What is Thread Priority?

Thread priority is a mechanism in Java that is used to **suggest the order of execution of threads** to the Thread Scheduler.

It helps the JVM decide which thread should get **more preference for execution**, but it does not guarantee execution order.

---

## Priority Range

In Java, thread priority ranges from:

| Constant      | Value | Description      |
|---------------|-------|------------------|
| MIN_PRIORITY  | 1     | Lowest priority  |
| NORM_PRIORITY | 5     | Default priority |
| MAX_PRIORITY  | 10    | Highest priority |

---

## Default Priority

- Every thread gets **priority 5 (NORM_PRIORITY)** by default.
- Main thread also has priority 5.

---

## Important Concept: Thread Priority is Only a Suggestion

Thread priority is only a suggestion to the Thread Scheduler.

When you set:

```
t1.setPriority(10);
```

You are only telling the scheduler:

“This thread is more important” 

Scheduler may or may not respect it

The scheduler:

May prefer higher priority threads
But can still ignore priorities
Depends on JVM + underlying OS


if 2 threads having same priority, then we cannot expect exact execution order, depends on thread scheduler.
thread class defines the following methods to get and set priority of threads

## Methods for Priority

### 1. setPriority(int value)
Used to set thread priority.

```
t1.setPriority(8);
```

allowed values range 1 to 10, otherwise RuntimeException IllegalArgumentException

### 2. getPriority()
Used to get current thread priority.

````
System.out.println(t1.getPriority()); 
````