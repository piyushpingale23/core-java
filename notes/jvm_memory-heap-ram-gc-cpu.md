# JVM Memory, Heap, RAM, Garbage Collection and CPU

## 1. System RAM vs JVM Memory

Suppose the system has:

```text
Physical RAM = 16 GB
```

The 16 GB RAM is shared by the entire operating system and all running processes.

```text
                    SYSTEM RAM = 16 GB
┌────────────────────────────────────────────────────┐
│                                                    │
│ Linux OS                                           │
│ IntelliJ                                           │
│ Browser                                            │
│ Docker                                             │
│ Other processes                                    │
│                                                    │
│ ┌──────────────────────────────────────────────┐   │
│ │              Spring Boot JVM                 │   │
│ │                                              │   │
│ │ Heap                                         │   │
│ │ Metaspace                                    │   │
│ │ Thread Stacks                                │   │
│ │ Code Cache                                   │   │
│ │ Direct Memory                                │   │
│ │ Native JVM Memory                            │   │
│ │                                              │   │
│ └──────────────────────────────────────────────┘   │
│                                                    │
└────────────────────────────────────────────────────┘
```

The JVM is only one process consuming the system's physical memory.

---

# 2. Starting a Spring Boot Application

Suppose the application is started with:

```bash
java -Xms1g -Xmx2g -jar app.jar
```

Configuration:

```text
-Xms = 1 GB
-Xmx = 2 GB
```

When the application starts, the JVM runs as an operating-system process.

```text
Linux
  │
  └── Java Process
        │
        ├── Java Heap
        ├── Metaspace
        ├── Thread Stacks
        ├── Code Cache
        ├── Direct Memory
        └── Other Native Memory
```

---

# 3. What is Xms?

`-Xms` specifies the initial heap size configuration.

Example:

```bash
-Xms1g
```

Conceptually:

```text
JVM Heap

Initial Heap
┌──────────────────────────────┐
│                              │
│            1 GB              │
│                              │
└──────────────────────────────┘
```

It tells the JVM the initial heap size to work with.

---

# 4. What is Xmx?

`-Xmx` specifies the maximum Java heap size.

Example:

```bash
-Xmx2g
```

Conceptually:

```text
Java Heap
Maximum = 2 GB

┌──────────────────────────────┐
│                              │
│                              │
│        Maximum Heap          │
│                              │
│           2 GB               │
│                              │
└──────────────────────────────┘
```

The Java heap cannot grow beyond the configured `Xmx`.

---

# 5. Important: Xmx is NOT Total JVM Memory

This is one of the most important concepts.

If:

```bash
-Xmx2g
```

it does NOT mean:

```text
JVM Process = maximum 2 GB
```

Instead:

```text
JVM Process
│
├── Java Heap             ← Xmx applies here
│
├── Metaspace
│
├── Thread Stacks
│
├── Code Cache
│
├── Direct Buffers
│
└── Other Native Memory
```

Therefore:

```text
Total JVM Process Memory
        >
Java Heap
```

For example, these are illustrative values:

```text
JVM Process
────────────────────────────
Heap                  2.0 GB
Metaspace             200 MB
Thread Stacks         100 MB
Code Cache             50 MB
Direct Memory         100 MB
Native overhead       100 MB
────────────────────────────
Total                 ~2.55 GB
```

The actual values depend on the JVM, application, thread count, libraries and configuration.

---

# 6. Java Heap

The Java Heap is the memory area where Java objects are allocated.

For example:

```java
User user = new User();

Order order = new Order();

List<Product> products = new ArrayList<>();
```

These objects consume heap memory.

Conceptually:

```text
                 JAVA HEAP
┌──────────────────────────────────────┐
│                                      │
│ User object                          │
│ Order object                         │
│ Product object                       │
│ ArrayList object                     │
│ String objects                       │
│ DTO objects                          │
│ JSON objects                         │
│ Temporary objects                    │
│                                      │
└──────────────────────────────────────┘
```

---

# 7. Application Requests Create Objects

Suppose your Spring Boot application receives HTTP requests.

```text
HTTP Request
     │
     ▼
Tomcat Thread
     │
     ▼
Spring Controller
     │
     ▼
Service
     │
     ▼
Java objects created
     │
     ▼
Objects allocated in Heap
```

For example:

```text
Request 1 ──► Objects ──► Heap
Request 2 ──► Objects ──► Heap
Request 3 ──► Objects ──► Heap
Request 4 ──► Objects ──► Heap
```

As requests create more objects, heap usage can increase.

---

# 8. Heap Usage Growth

Suppose:

```text
-Xms = 1 GB
-Xmx = 2 GB
```

Initially:

```text
Maximum Heap = 2 GB

┌────────────────────────────────────┐
│                                    │
│                                    │
│                                    │
│                                    │
│                                    │
└────────────────────────────────────┘
```

After the application creates objects:

```text
Used Heap = 500 MB

┌────────────────────────────────────┐
│████████                            │
│████████                            │
│                                    │
│                                    │
│                                    │
└────────────────────────────────────┘
```

Later:

```text
Used Heap = 1.2 GB

┌────────────────────────────────────┐
│██████████████████                  │
│██████████████████                  │
│                                    │
│                                    │
│                                    │
└────────────────────────────────────┘
```

Later:

```text
Used Heap = 1.8 GB

┌────────────────────────────────────┐
│████████████████████████████        │
│████████████████████████████        │
│████████████████████████████        │
│                                    │
└────────────────────────────────────┘
```

The heap is approaching its maximum capacity.

---

# 9. What Happens to Objects After a Request?

Not every object remains useful forever.

Example:

```java
public void process() {

    Order order = new Order();

    // process order
}
```

After the method completes, the `order` object may no longer be reachable.

Conceptually:

```text
Heap

┌──────────────────────────────┐
│ Order object                 │ ← still referenced
├──────────────────────────────┤
│ Customer object              │ ← still referenced
├──────────────────────────────┤
│ Temporary DTO                │ ← no longer referenced
├──────────────────────────────┤
│ Temporary String             │ ← no longer referenced
├──────────────────────────────┤
│ JSON object                  │ ← no longer referenced
└──────────────────────────────┘
```

Objects that are no longer reachable can eventually be reclaimed by the Garbage Collector.

---

# 10. Garbage Collector (GC)

The JVM has a Garbage Collector.

Its job is to identify objects that are no longer reachable and reclaim their heap memory.

Conceptually:

```text
Heap Before GC

┌──────────────────────────────┐
│ Live object                  │
│ Garbage                      │
│ Live object                  │
│ Garbage                      │
│ Garbage                      │
│ Live object                  │
│ Garbage                      │
└──────────────────────────────┘

             │
             │ Garbage Collection
             ▼

Heap After GC

┌──────────────────────────────┐
│ Live object                  │
│ Live object                  │
│ Live object                  │
│                              │
│                              │
│                              │
│                              │
└──────────────────────────────┘
```

GC makes memory available for future object allocations.

---

# 11. Heap Pressure

Heap pressure occurs when the application is creating objects faster than the JVM can comfortably reclaim memory.

Example:

```text
Application creates objects
          │
          ▼
       Heap grows
          │
          ▼
    Less free heap space
          │
          ▼
      GC activity
```

If object creation continues rapidly:

```text
Create objects
      ↓
Heap grows
      ↓
GC
      ↓
Memory reclaimed
      ↓
Create more objects
      ↓
Heap grows again
      ↓
GC again
      ↓
Repeat
```

---

# 12. Why Can CPU Usage Increase?

Garbage Collection itself requires CPU.

The CPU is used to perform GC work such as:

- Finding reachable objects
- Identifying garbage
- Reclaiming memory
- Compacting/moving objects depending on the GC
- Maintaining GC-related data structures

Therefore:

```text
More GC activity
       │
       ▼
More CPU work
       │
       ▼
Higher CPU utilization
```

Conceptually:

```text
                 JVM
                  │
        ┌─────────┴─────────┐
        ▼                   ▼
 Application Work          GC Work
        │                   │
        └─────────┬─────────┘
                  ▼
                 CPU
```

---

# 13. Normal Situation

Suppose the application is processing requests normally.

```text
Heap:

Used = 700 MB
Maximum = 2 GB

┌────────────────────────────────────┐
│██████████                          │
│██████████                          │
│                                    │
│                                    │
│                                    │
└────────────────────────────────────┘
```

There is plenty of free heap.

GC does not need to work aggressively.

CPU might look conceptually like:

```text
Application CPU
████████████

GC CPU
██
```

This is a healthy situation.

---

# 14. Heap Gets Close to Xmx

Suppose:

```text
Used Heap = 1.8 GB
Xmx       = 2 GB
```

Conceptually:

```text
                2 GB Maximum
┌────────────────────────────────────┐
│████████████████████████████        │
│████████████████████████████        │
│████████████████████████████        │
│                                    │
└────────────────────────────────────┘
        ↑
     1.8 GB used
```

The JVM needs more free space for new objects.

GC activity can increase.

```text
Heap pressure
     │
     ▼
GC activity
     │
     ▼
CPU usage
```

---

# 15. GC Can Successfully Reclaim Memory

Suppose:

```text
Before GC:

Used = 1.8 GB
Xmx  = 2 GB
```

GC runs and finds a lot of garbage.

```text
Before GC
┌────────────────────────────────────┐
│████████████████████████████        │
│████████████████████████████        │
│████████████████████████████        │
└────────────────────────────────────┘

             │
             │ GC
             ▼

After GC
┌────────────────────────────────────┐
│████████████████                    │
│████████████████                    │
│                                    │
│                                    │
└────────────────────────────────────┘

Used ≈ 800 MB
```

The application can continue running.

Therefore:

> High heap usage does not automatically mean OutOfMemoryError.

---

# 16. What Happens If Objects Are Still Alive?

Consider:

```
static List<byte[]> cache = new ArrayList<>();
while (true) {
    cache.add(new byte[1024 * 1024]);
}
```

The objects are still referenced by `cache`.

Therefore GC cannot reclaim them.

Conceptually:

```text
cache
  │
  ├──► Object
  ├──► Object
  ├──► Object
  ├──► Object
  ├──► Object
  └──► Object
```

The heap keeps filling.

```text
Heap

┌────────────────────────────────────┐
│████████████████████████████████████│
│████████████████████████████████████│
│████████████████████████████████████│
│████████████████████████████████████│
└────────────────────────────────────┘
              ↑
           Xmx = 2 GB
```

GC runs:

```text
GC
 │
 ├── Find garbage
 │
 ├── Very little garbage found
 │
 ├── Try again later
 │
 └── Still not enough memory
```

Eventually the JVM cannot allocate the required object.

This can result in:

```text
java.lang.OutOfMemoryError: Java heap space
```

---

# 17. High CPU Does NOT Automatically Mean OOM

These are different concepts.

## Case 1: High CPU Without OOM

```text
Application creates many objects
          │
          ▼
       Heap grows
          │
          ▼
       GC runs
          │
          ▼
   CPU usage increases
          │
          ▼
GC successfully reclaims memory
          │
          ▼
     Application continues
```

Example:

```text
CPU  = 90%
Heap = 1.5 GB / 2 GB
```

The application can continue running.

---

# 18. OOM Without Extremely High CPU

Another possibility:

```text
Heap fills
   │
   ▼
GC runs
   │
   ▼
Objects are still reachable
   │
   ▼
Not enough memory reclaimed
   │
   ▼
Heap cannot grow beyond Xmx
   │
   ▼
OutOfMemoryError
```

So:

```text
High CPU ≠ OOM
High Heap Usage ≠ OOM
Xmx Reached ≠ Immediately OOM
```

The JVM generally attempts GC before failing an allocation.

---

# 19. Full Memory Architecture

The complete picture is:

```text
                    PHYSICAL RAM
                       16 GB
┌───────────────────────────────────────────────────┐
│                                                   │
│ Linux OS                                          │
│                                                   │
│ Other Applications                                │
│                                                   │
│ IntelliJ                                          │
│                                                   │
│ Browser                                           │
│                                                   │
│ Docker                                            │
│                                                   │
│ ┌─────────────────────────────────────────────┐   │
│ │             SPRING BOOT JVM                 │   │
│ │                                             │   │
│ │  ┌───────────────────────────────────────┐  │   │
│ │  │              JAVA HEAP                │  │   │
│ │  │                                       │  │   │
│ │  │ Xms = 1 GB                            │  │   │
│ │  │                                       │  │   │
│ │  │ Java Objects                          │  │   │
│ │  │ DTOs                                  │  │   │
│ │  │ Collections                           │  │   │
│ │  │ Strings                               │  │   │
│ │  │ Temporary Objects                     │  │   │
│ │  │                                       │  │   │
│ │  │ Xmx = 2 GB                            │  │   │
│ │  └───────────────────────────────────────┘  │   │
│ │                                             │   │
│ │  Metaspace                                  │   │
│ │  Thread Stacks                              │   │
│ │  Code Cache                                 │   │
│ │  Direct Memory                              │   │
│ │  Other Native Memory                        │   │
│ │                                             │   │
│ └─────────────────────────────────────────────┘   │
│                                                   │
└───────────────────────────────────────────────────┘
```

---

# 20. Virtual Memory Layer

The JVM does not simply directly grab physical RAM.

There is an operating-system memory-management layer.

Conceptually:

```text
Java Application
       │
       ▼
      JVM
       │
       ▼
Virtual Memory / Process Address Space
       │
       ▼
Linux Memory Manager
       │
       ▼
Physical RAM
```

Therefore the simplified model is:

```text
JVM
 │
 │ requests/commits memory
 ▼
Operating System
 │
 │ maps memory pages
 ▼
Physical RAM
```

---

# 21. RAM vs Swap

Linux can also use swap.

For example, suppose your system has:

```text
RAM  = 16 GB
Swap = 30 GB
```

Conceptually:

```text
                 Memory
                    │
          ┌─────────┴─────────┐
          │                   │
          ▼                   ▼
     Physical RAM            Swap
        16 GB                30 GB
```

Swap is storage-backed memory and is significantly slower than physical RAM.

Heavy swapping can cause severe performance degradation.

Important:

> Swap does not increase the JVM's `Xmx`.

For example:

```text
-Xmx2g
```

still means the Java heap maximum is 2 GB, even if the system has 30 GB of swap.

---

# 22. Complete Request-to-OOM Flow

A useful mental model is:

```text
HTTP Request
     │
     ▼
Tomcat Thread
     │
     ▼
Spring Boot Application
     │
     ▼
Java objects created
     │
     ▼
Objects allocated in Heap
     │
     ▼
Heap usage increases
     │
     ▼
Heap pressure increases
     │
     ▼
Garbage Collector runs
     │
     ├───────────────┐
     │               │
     ▼               ▼
Garbage found    Objects still alive
     │               │
     ▼               ▼
Memory reclaimed   Memory remains occupied
     │               │
     ▼               ▼
Application       More GC pressure
continues              │
                       ▼
                 More CPU usage
                       │
                       ▼
              GC cannot reclaim enough
                       │
                       ▼
                 Heap approaches Xmx
                       │
                       ▼
              Cannot allocate object
                       │
                       ▼
          OutOfMemoryError: Java heap space
```

---

```text
More object allocation
         │
         ▼
Heap usage increases
         │
         ▼
Heap pressure increases
         │
         ▼
GC activity may increase
         │
         ▼
GC consumes CPU
         │
         ▼
CPU utilization may increase
         │
         ▼
If GC cannot reclaim enough memory
         │
         ▼
Heap reaches allocation limit
         │
         ▼
OutOfMemoryError
```

---

# 23. Complete CPU + Memory Relationship

The relationship can be summarized as:

```text
                    APPLICATION
                         │
                         │ creates objects
                         ▼
                       HEAP
                         │
                         │ heap usage increases
                         ▼
                  HEAP PRESSURE
                         │
                         ▼
                       GC
                         │
                         │ requires CPU
                         ▼
                    CPU USAGE
                         │
                         │
              ┌──────────┴──────────┐
              │                     │
              ▼                     ▼
     Garbage reclaimed       Not enough reclaimed
              │                     │
              ▼                     ▼
       Application             More GC
        continues                 │
                                  ▼
                           CPU may increase
                                  │
                                  ▼
                         Heap remains full
                                  │
                                  ▼
                              Xmx limit
                                  │
                                  ▼
                          OutOfMemoryError
```

---

# 24. Important Corrections to Remember

## Incorrect Understanding

```text
Application starts
      ↓
-Xms1g
      ↓
JVM takes exactly 1 GB physical RAM
      ↓
Heap reaches Xmx
      ↓
CPU automatically becomes high
      ↓
OOM
```

This is too simplistic.

## Better Understanding

```text
Application starts
      ↓
JVM process is created
      ↓
JVM manages Java Heap + other memory areas
      ↓
-Xms defines initial heap configuration
      ↓
-Xmx defines maximum Java heap
      ↓
Application creates objects
      ↓
Heap usage increases
      ↓
GC reclaims unreachable objects
      ↓
GC requires CPU
      ↓
If allocation/GC pressure becomes high
      ↓
CPU usage can increase
      ↓
If GC cannot reclaim enough memory
      ↓
Heap approaches Xmx
      ↓
Allocation may fail
      ↓
OutOfMemoryError
```

---

# 25. Key Terms

| Term | Meaning |
|---|---|
| Physical RAM | Actual memory installed in the machine |
| JVM Process | Operating-system process running the Java application |
| Java Heap | Memory area used for Java object allocation |
| Xms | Initial heap size configuration |
| Xmx | Maximum Java heap size |
| Metaspace | Native memory area used for class metadata |
| Thread Stack | Memory used by individual threads |
| Code Cache | Memory used by JVM for compiled code |
| Direct Memory | Off-heap memory used by APIs such as NIO |
| Garbage Collector | JVM component that reclaims unreachable objects |
| Heap Pressure | Increasing demand for heap memory |
| GC Pressure | Increasing frequency/intensity of garbage collection |
| OOM | `OutOfMemoryError`, when the JVM cannot satisfy a required memory allocation |
| Swap | Disk-backed memory used by the operating system |

---

# 26. Most Important Points to Remember

### 1. `Xmx` is not the total JVM memory

```text
JVM Process Memory
        >
Java Heap
```

### 2. `Xmx=2g` means Java Heap maximum is approximately 2 GB

```text
-Xmx2g
      ↓
Maximum Java Heap ≈ 2 GB
```

### 3. The JVM can consume more than Xmx

Because of:

```text
Metaspace
Thread Stacks
Code Cache
Direct Memory
Native Memory
```

### 4. Creating Java objects consumes heap

```text
Request
   ↓
Java objects
   ↓
Heap usage
```

### 5. Garbage Collection reclaims unreachable objects

```text
Unreachable Objects
        ↓
       GC
        ↓
Memory Reclaimed
```

### 6. GC consumes CPU

```text
GC Work
   ↓
CPU Work
   ↓
CPU Utilization
```

### 7. High CPU can be caused by excessive GC

```text
Many objects
   ↓
Heap pressure
   ↓
Frequent GC
   ↓
More CPU usage
```

### 8. High CPU does not automatically mean OOM

```text
High CPU
   ≠
OOM
```

### 9. High heap usage does not automatically mean OOM

```text
Heap = 1.9 GB / 2 GB
```

does not necessarily mean OOM.

If GC can reclaim memory:

```text
1.9 GB
  ↓ GC
800 MB
```

the application can continue.

### 10. OOM happens when the JVM cannot satisfy a memory allocation

A simplified flow:

```text
Need more heap
      ↓
GC
      ↓
Not enough memory reclaimed
      ↓
Cannot grow beyond Xmx
      ↓
Allocation fails
      ↓
OutOfMemoryError
```

---

# 27. One-Line Mental Model

Remember this:

```text
16 GB System RAM
      ↓
Linux manages memory
      ↓
JVM Process
      ↓
Java Heap + Non-Heap/Native Memory
      ↓
-Xms = Initial Heap
-Xmx = Maximum Heap
      ↓
Application creates objects
      ↓
Heap grows
      ↓
GC removes unreachable objects
      ↓
GC consumes CPU
      ↓
High allocation/GC pressure → CPU can increase
      ↓
GC cannot reclaim enough memory
      ↓
Heap reaches allocation limit
      ↓
OutOfMemoryError
```

---

# 28. Final Mental Model

The most important distinction is:

```text
                 SYSTEM MEMORY
                     16 GB
                       │
                       ▼
                 JVM PROCESS
                       │
          ┌────────────┴────────────┐
          │                         │
          ▼                         ▼
       JAVA HEAP              OTHER JVM MEMORY
          │                         │
      Xms / Xmx              Metaspace / Stacks /
          │                  Code Cache / Native /
          │                  Direct Memory
          ▼
   Java Object Allocation
          │
          ▼
      Heap Pressure
          │
          ▼
          GC
          │
          ├──► CPU is used for GC work
          │
          ▼
   Garbage Reclaimed?
       │           │
      YES          NO
       │           │
       ▼           ▼
   Continue      More GC
                  │
                  ▼
          Cannot reclaim enough
                  │
                  ▼
              Xmx limit
                  │
                  ▼
          Allocation failure
                  │
                  ▼
       OutOfMemoryError
```

> **Core concept:** `Xms` and `Xmx` control the Java heap, not the entire JVM process. The application continuously creates objects in the heap. Garbage Collection removes objects that are no longer reachable. GC requires CPU. Therefore, heavy object allocation and GC pressure can increase CPU usage. If GC cannot reclaim enough memory and the JVM cannot allocate beyond `Xmx`, the application can eventually throw `OutOfMemoryError`.

---

# JVM Xmx Configuration and Garbage Collection

## If I configure a larger Xmx, will Garbage Collection happen later, and can it affect performance?

### Answer

- Larger `Xmx` → more heap space.
- More heap → more room for object allocation.
- More room → heap pressure can be delayed.
- Lower heap pressure → GC may happen less frequently.
- GC uses CPU resources.
- Frequent GC → higher CPU utilization.
- Larger heap → does not eliminate GC.
- GC is not triggered at a fixed percentage of `Xmx`.
- GC timing depends on the GC algorithm and JVM behavior.
- Very large heaps can make some GC operations more expensive.
- Larger `Xmx` also leaves less RAM for OS and JVM native memory.
- A larger `Xmx` can delay OOM, but does not fix a memory leak.
- Therefore, larger `Xmx` is not always better.
- Set `Xmx` based on the application's actual memory requirement and available system RAM.


## What happens if I configure Xmx too small, such as 1 GB?

### Answer

- Small `Xmx` → less heap space.
- Less heap → less room for object allocation.
- Heap fills more quickly.
- Heap pressure increases.
- Higher heap pressure → GC may run more frequently.
- Frequent GC → more CPU work.
- More GC work → CPU utilization can increase.
- If GC successfully reclaims memory → application continues.
- If GC cannot reclaim enough memory → heap remains under pressure.
- JVM eventually reaches the maximum heap limit (`Xmx`).
- Required object allocation may fail.
- This can result in `OutOfMemoryError: Java heap space`.
- Therefore, a very small `Xmx` can cause frequent GC, higher CPU usage, and potentially OOM.
- However, OOM is not caused simply because `Xmx` is small; it occurs when the JVM cannot satisfy a memory allocation within the available heap.