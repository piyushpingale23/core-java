# JVM Heap Memory Model and Garbage Collection

## 1. What is Java Heap?

- Java Heap is the JVM memory area where Java objects are allocated.
- Objects created using `new` are generally allocated in the heap.
- Garbage Collector (GC) manages the heap memory.
- The heap is controlled primarily by:
    - `-Xms` → initial heap size
    - `-Xmx` → maximum heap size

Example:

    java -Xms1g -Xmx2g -jar app.jar

Conceptually:

    JAVA HEAP
    ┌──────────────────────────────────────────────────────┐
    │                                                      │
    │                  Maximum Heap = 2 GB                 │
    │                                                      │
    │  ┌──────────────────────┐   ┌─────────────────────┐  │
    │  │  Young Generation    │   │    Old Generation   │  │
    │  │                      │   │                     │  │
    │  │  ┌──────┐ ┌───┐ ┌───┐│   │                     │  │
    │  │  │ Eden │ │S0 │ │S1 ││   │      Old Gen        │  │
    │  │  └──────┘ └───┘ └───┘│   │                     │  │
    │  └──────────────────────┘   └─────────────────────┘  │
    │                                                      │
    └──────────────────────────────────────────────────────┘

> Note: The Eden/S0/S1/Old Gen model is the traditional generational heap model. Modern collectors such as G1 use a region-based heap, so the exact physical layout differs.

---

# 2. High-Level Heap Structure

In the traditional generational model:

    JAVA HEAP
        │
        ├──────────────────────┐
        │                      │
        ▼                      ▼
    Young Generation      Old Generation
        │                      │
        ├── Eden               │
        ├── Survivor 0 (S0)    │
        └── Survivor 1 (S1)    │
                               │
                               ▼
                           Old Gen

The basic object lifecycle is:

    New Objects
         │
         ▼
       Eden
         │
         │ Young GC
         ▼
    Survivor Space
         │
         │ Survive multiple GC cycles
         ▼
     Old Generation
         │
         │ Old/Full GC depending on collector
         ▼
    Garbage Reclaimed

---

# 3. Young Generation

The Young Generation is where newly created objects are generally allocated in the traditional generational model.

It consists of:

    Young Generation
    │
    ├── Eden
    ├── Survivor 0 (S0)
    └── Survivor 1 (S1)

Conceptually:

                     YOUNG GENERATION
    ┌───────────────────────────────────────────────┐
    │                                               │
    │     Eden          S0             S1           │
    │  ┌─────────┐   ┌─────────┐   ┌─────────┐      │
    │  │         │   │         │   │         │      │
    │  │  New    │   │Survivors│   │Survivors│      │
    │  │ Objects │   │         │   │         │      │
    │  │         │   │         │   │         │      │
    │  └─────────┘   └─────────┘   └─────────┘      │
    │                                               │
    └───────────────────────────────────────────────┘

---

# 4. Eden Space

Eden is the primary allocation area for new objects in the traditional generational model.

For example:

    User user = new User();
    Order order = new Order();
    Product product = new Product();

Conceptually:

    Eden
    ┌──────────────────────────────────┐
    │ User object                      │
    │ Order object                     │
    │ Product object                   │
    │ String object                    │
    │ DTO object                       │
    │ ArrayList object                 │
    │ Temporary objects                │
    └──────────────────────────────────┘

As the application creates objects:

    Eden
    ┌──────────────────────────────────┐
    │██████████████████████████████████│
    └──────────────────────────────────┘
                 ↑
             Eden fills

When sufficient allocation pressure occurs, the JVM may perform a Young GC.

---

# 5. Survivor Spaces: S0 and S1

The Young Generation has two Survivor spaces:

    S0 = Survivor 0
    S1 = Survivor 1

They are used to hold objects that survive a Young GC.

Conceptually:

    Young Generation

    ┌─────────────┬─────────────┬─────────────┐
    │    Eden     │     S0      │     S1      │
    │             │             │             │
    │ New objects │ Survivors   │ Survivors   │
    └─────────────┴─────────────┴─────────────┘

Only one Survivor space is normally used as the active "to" space during a copying collection while the other acts as the "from" space.

The roles of S0 and S1 can swap between GC cycles.

---

# 6. Why Are There Two Survivor Spaces?

The two Survivor spaces allow the JVM to copy surviving objects between them during Young GC.

Conceptually:

    Before Young GC:

    ┌─────────────┬─────────────┬─────────────┐
    │    Eden     │     S0      │     S1      │
    │             │             │             │
    │ A  B  C  D  │ E  F        │ Empty       │
    │             │             │             │
    └─────────────┴─────────────┴─────────────┘

    Suppose:

    A, B, C, D → garbage
    E, F       → still alive

    After Young GC:

    ┌─────────────┬─────────────┬─────────────┐
    │    Eden     │     S0      │     S1      │
    │             │             │             │
    │   Empty     │ Empty       │ E  F        │
    │             │             │             │
    └─────────────┴─────────────┴─────────────┘

The surviving objects are copied to the available Survivor space.

The Survivor spaces then swap roles in the next cycle.

---

# 7. Young GC / Minor GC

A Young GC primarily collects the Young Generation.

Conceptually:

    Eden becomes full
          │
          ▼
      Young GC
          │
          ├── Remove unreachable objects
          │
          ├── Copy surviving objects
          │
          └── Age surviving objects
                   │
                   ▼
              Survivor Space

Example:

    Before Young GC:

    Young Generation

    ┌──────────────────────────────────────────┐
    │ Eden                                     │
    │                                          │
    │ Object A    ← Garbage                    │
    │ Object B    ← Alive                      │
    │ Object C    ← Garbage                    │
    │ Object D    ← Alive                      │
    │ Object E    ← Garbage                    │
    ├──────────────────────────────────────────┤
    │ S0                                       │
    │ Existing survivors                       │
    ├──────────────────────────────────────────┤
    │ S1                                       │
    │ Available                                │
    └──────────────────────────────────────────┘

                       │
                       │ Young GC
                       ▼

    After Young GC:

    ┌──────────────────────────────────────────┐
    │ Eden                                     │
    │ Empty / available                        │
    ├──────────────────────────────────────────┤
    │ S0                                       │
    │ Existing survivors                       │
    ├──────────────────────────────────────────┤
    │ S1                                       │
    │ Object B                                 │
    │ Object D                                 │
    └──────────────────────────────────────────┘

Most short-lived objects are reclaimed during Young GC.

---

# 8. Why Young GC Happens Frequently

Most Java applications create many temporary objects.

For example:

    HTTP Request
         │
         ▼
    Controller
         │
         ▼
    Service
         │
         ▼
    DTO creation
         │
         ▼
    JSON processing
         │
         ▼
    Temporary objects
         │
         ▼
       Eden

Many of these objects become unreachable quickly.

Therefore:

    Many short-lived objects
             │
             ▼
        Eden fills quickly
             │
             ▼
         Young GC
             │
             ▼
     Most objects reclaimed

This is one of the key ideas behind generational garbage collection.

---

# 9. Object Age

Objects that survive Young GC are considered older.

Conceptually:

    New object
        │
        ▼
      Eden
        │
        │ Survives GC
        ▼
    Survivor Space
        │
        │ Survives another GC
        ▼
    Survivor Space
        │
        │ Survives multiple GCs
        ▼
    Older object
        │
        ▼
    Old Generation

The JVM tracks object age.

After an object survives enough collection cycles, it may be promoted to the Old Generation.

---

# 10. Promotion to Old Generation

Suppose an object survives multiple Young GC cycles.

Conceptually:

    New Object
        │
        ▼
      Eden
        │
        │ Young GC
        ▼
       S0/S1
        │
        │ Young GC
        ▼
       S0/S1
        │
        │ Young GC
        ▼
       S0/S1
        │
        │ Enough age / promotion decision
        ▼
     Old Gen

The exact promotion behavior depends on the JVM and Garbage Collector.

---

# 11. Old Generation

The Old Generation contains objects that have survived enough GC cycles or are otherwise allocated/handled as long-lived objects according to the collector.

Conceptually:

    Old Generation
    ┌────────────────────────────────────┐
    │ Long-lived Object                  │
    │ Long-lived Object                  │
    │ Cache                              │
    │ Application state                  │
    │ Long-lived Collections             │
    │ Other long-lived objects           │
    └────────────────────────────────────┘

Examples of potentially long-lived objects:

    - Application caches
    - Long-lived collections
    - Objects referenced by application state
    - Objects referenced by static fields
    - Objects that survive many GC cycles

---

# 12. Old GC / Major GC

Terminology such as "Major GC" or "Old GC" varies between collectors and JVM implementations.

Conceptually, an old-generation collection focuses on reclaiming memory occupied by older objects.

Simplified flow:

    Old Generation fills / collection threshold reached
              │
              ▼
        Old-generation GC
              │
              ▼
     Identify unreachable objects
              │
              ▼
       Reclaim their memory

Important:

> The exact meaning and behavior of "Major GC" depends on the Garbage Collector being used.

Modern collectors such as G1 do not simply behave like the traditional Eden/S0/S1/Old Gen model.

---

# 13. Full GC

A Full GC generally represents a more comprehensive and potentially more expensive garbage collection operation.

Conceptually:

    Full GC
       │
       ├── Consider Young Generation
       │
       ├── Consider Old/long-lived objects
       │
       └── Perform broader heap processing

A Full GC can have a significant performance impact depending on the collector, heap size, application workload, and JVM configuration.

> The exact behavior of "Full GC" is collector-dependent.

---

# 14. Young GC vs Old/Full GC

Simplified comparison:

    Young GC

    Scope:
        Primarily Young Generation

    Typical objects:
        Short-lived objects

    Frequency:
        Usually more frequent

    Typical goal:
        Quickly reclaim short-lived garbage


    Old/Full GC

    Scope:
        Older objects / larger portion of heap

    Typical objects:
        Long-lived objects and objects that survived
        multiple collections

    Frequency:
        Usually less frequent

    Potential cost:
        Can be more expensive depending on collector

---

# 15. Object Lifecycle

A simplified object lifecycle:

    Object created
         │
         ▼
       Eden
         │
         │ Young GC
         ├───────────────────┐
         │                   │
         ▼                   ▼
      Garbage             Survives
         │                   │
         ▼                   ▼
      Reclaimed          Survivor S0/S1
                             │
                             │ Another Young GC
                             ▼
                        Survivor S0/S1
                             │
                             │ Survives repeatedly
                             ▼
                         Old Gen
                             │
                             │ Object becomes unreachable
                             ▼
                       Old/Full GC
                             │
                             ▼
                         Reclaimed

The key principle is:

    New objects
        ↓
    Young Generation
        ↓
    Short-lived objects → reclaimed quickly
        ↓
    Long-lived objects → promoted
        ↓
    Old Generation
        ↓
    Eventually reclaimed when unreachable

---

# 16. Complete Traditional Heap Model

```text
                         JAVA HEAP
┌────────────────────────────────────────────────────────────┐
│                                                            │
│                     YOUNG GENERATION                       │
│                                                            │
│    ┌────────────────┐ ┌────────────┐ ┌────────────┐        │
│    │      EDEN      │ │     S0     │ │     S1     │        │
│    │                │ │            │ │            │        │
│    │ New Objects    │ │ Survivors  │ │ Survivors  │        │
│    │                │ │            │ │            │        │
│    └────────────────┘ └────────────┘ └────────────┘        │
│                                                            │
├────────────────────────────────────────────────────────────┤
│                                                            │
│                    OLD GENERATION                          │
│                                                            │
│    ┌──────────────────────────────────────────────────┐    │
│    │                                                  │    │
│    │ Long-lived objects                               │    │
│    │ Objects promoted from Young Generation           │    │
│    │                                                  │    │
│    └──────────────────────────────────────────────────┘    │
│                                                            │
└────────────────────────────────────────────────────────────┘
```

---

# 17. Young GC Flow

```text
              Application creates objects
                         │
                         ▼
                       Eden
                         │
                         ▼
                    Eden fills
                         │
                         ▼
                     Young GC
                         │
             ┌───────────┴───────────┐
             │                       │
             ▼                       ▼
       Unreachable              Reachable
        objects                   objects
             │                       │
             ▼                       ▼
         Reclaimed             Survivor S0/S1
                                     │
                                     ▼
                              Age increases
```

---

# 18. Promotion Flow

```text
Object created
      │
      ▼
    Eden
      │
      │ Young GC
      ▼
   Survivor
      │
      │ Young GC
      ▼
   Survivor
      │
      │ Young GC
      ▼
   Survivor
      │
      │ Survives enough cycles
      ▼
   Old Gen
```

---

# 19. What Happens to Garbage?

Suppose the heap contains:

```text
Object A → reachable
Object B → unreachable
Object C → reachable
Object D → unreachable
Object E → reachable
```

GC identifies reachability.

```text
Before GC:

┌─────────────────────────────┐
│ Object A   ← Live           │
│ Object B   ← Garbage        │
│ Object C   ← Live           │
│ Object D   ← Garbage        │
│ Object E   ← Live           │
└─────────────────────────────┘

             │
             │ GC
             ▼

After GC:

┌─────────────────────────────┐
│ Object A   ← Live           │
│ Object C   ← Live           │
│ Object E   ← Live           │
│                             │
│ Free space                  │
└─────────────────────────────┘
```

The exact mechanics depend on the collector.

---

# 20. Reachability

GC generally determines whether an object is reachable from GC roots.

Examples of GC roots can include:

    - Active thread references
    - Local variables referenced by active stack frames
    - Static fields
    - JNI references
    - Other JVM-defined roots

Conceptually:

```text
GC Root
   │
   ▼
Object A
   │
   ▼
Object B
```

If the object is reachable:

```text
GC Root → A → B
```

then it is considered live.

If no GC root can reach an object:

```text
GC Root

Object A

Object B
```

and nothing references `A` or `B`, they may be garbage.

---

# 21. Why Generational GC Works Well

Most applications have many short-lived objects.

For example:

```text
Total objects created

100 objects
│
├── 90 become unreachable quickly
│
└── 10 survive longer
```

Therefore:

```text
Young Generation
       │
       ▼
Many short-lived objects
       │
       ▼
Young GC
       │
       ├── Most objects die
       │
       └── Few objects survive
```

This allows the collector to focus frequently on the area where most garbage is expected.

---

# 22. Heap Pressure and GC Pressure

These terms are related but different.

### Heap Pressure

Heap pressure means the application is demanding heap memory.

```text
More object allocation
        ↓
Heap usage increases
        ↓
Less free allocation space
        ↓
Heap pressure increases
```

### GC Pressure

GC pressure means the JVM needs to perform more garbage collection work to keep allocation going.

```text
Heap pressure
      ↓
More GC activity
      ↓
GC pressure
      ↓
More CPU work
```

---

# 23. CPU Usage and GC

Garbage Collection uses CPU.

But GC is NOT the only CPU consumer in a Java process.

```text
                 JAVA PROCESS
                      │
          ┌───────────┼────────────┐
          │           │            │
          ▼           ▼            ▼
    Application       GC          JIT
       Threads       Threads     Compiler
          │           │            │
          └───────────┼────────────┘
                      ▼
                     CPU
```

CPU can therefore be consumed by:

- Application business logic
- Loops and calculations
- JSON serialization/deserialization
- Encryption/decryption
- Database result processing
- Garbage Collection
- JIT compilation
- Other JVM internal work

Therefore:

> High Java process CPU does not automatically mean high GC CPU.

---

# 24. Relationship Between Heap, GC and CPU

A simplified relationship is:

```text
Application creates many objects
              │
              ▼
         Heap usage rises
              │
              ▼
        Heap pressure rises
              │
              ▼
         GC activity rises
              │
              ▼
        GC consumes CPU
              │
              ▼
      CPU utilization may rise
```

However:

> GC is not triggered simply because a fixed percentage of Xmx is reached.

GC timing depends on:

- Garbage Collector
- Allocation rate
- Available memory
- Heap layout
- GC goals
- Object lifetime
- JVM behavior
- Collector-specific policies

---

# 25. Small Xmx Example

Suppose:

```text
-Xms = 1 GB
-Xmx = 1 GB
```

Application continuously creates objects.

```text
Small Heap
    │
    ▼
Less allocation space
    │
    ▼
Heap fills faster
    │
    ▼
Heap pressure increases
    │
    ▼
GC may happen more frequently
    │
    ▼
More GC CPU work
    │
    ▼
CPU utilization may increase
```

If GC cannot reclaim enough memory:

```text
Heap nearly full
      │
      ▼
GC
      │
      ▼
Not enough memory reclaimed
      │
      ▼
Allocation fails
      │
      ▼
OutOfMemoryError
```

---

# 26. Large Xmx Example

Suppose:

```text
-Xmx = 10 GB
```

The application has more allocation space.

```text
Larger Heap
     │
     ▼
More allocation space
     │
     ▼
Heap pressure may be delayed
     │
     ▼
Some GC activity may happen less frequently
```

But:

```text
Larger Xmx
     ≠
No GC
```

A larger heap can delay memory pressure, but it does not eliminate garbage collection.

---

# 27. Memory Leak and Xmx

Increasing `Xmx` does not fix a memory leak.

Example:

```text
Xmx = 2 GB

Live objects:
500 MB
   ↓
800 MB
   ↓
1.2 GB
   ↓
1.6 GB
   ↓
1.9 GB
   ↓
2 GB
   ↓
OOM
```

Increase Xmx:

```text
Xmx = 10 GB

Live objects:
500 MB
   ↓
1 GB
   ↓
2 GB
   ↓
4 GB
   ↓
6 GB
   ↓
8 GB
   ↓
10 GB
   ↓
OOM
```

The larger heap only delays the failure.

The underlying memory leak must be fixed.

---

# 28. Young GC vs Old GC vs Full GC

| Type         | Main Area                      | Typical Purpose               | Frequency          | Cost             |
|--------------|--------------------------------|-------------------------------|--------------------|------------------|
| Young GC     | Young Generation               | Reclaim short-lived objects   | More frequent      | Usually lower    |
| Old/Major GC | Old Generation / older objects | Reclaim long-lived garbage    | Less frequent      | Can be higher    |
| Full GC      | Broader heap processing        | More comprehensive collection | Ideally infrequent | Can be expensive |

> These terms are simplified. Exact behavior varies by Garbage Collector.

---

# 29. Traditional Generational GC Mental Model

Remember this flow:

```text
                    JAVA HEAP
                        │
          ┌─────────────┴─────────────┐
          │                           │
          ▼                           ▼
     YOUNG GENERATION            OLD GENERATION
          │                           │
     ┌────┼────┐                      │
     │    │    │                      │
     ▼    ▼    ▼                      ▼
   Eden   S0   S1                  Old Gen
     │
     │
     ▼
 New Objects
     │
     │ Young GC
     ▼
Survivors
     │
     │ Multiple GC cycles
     ▼
  Old Gen
     │
     │ Collection
     ▼
 Garbage Reclaimed
```

---

# 30. Complete Object Lifecycle

```text
                   OBJECT CREATED
                         │
                         ▼
                       EDEN
                         │
                         │ Young GC
              ┌──────────┴──────────┐
              │                     │
              ▼                     ▼
          Garbage                 Alive
              │                     │
              ▼                     ▼
          Reclaimed             Survivor
                                    │
                                    │ Young GC
                                    ▼
                                Survivor
                                    │
                                    │ Young GC
                                    ▼
                                Survivor
                                    │
                                    │ Survives enough
                                    │ GC cycles
                                    ▼
                                 OLD GEN
                                    │
                                    │ Object becomes
                                    │ unreachable
                                    ▼
                              Old/Full GC
                                    │
                                    ▼
                               Reclaimed
```

---

# 31. Important Terms

| Term             | Meaning                                                           |
|------------------|-------------------------------------------------------------------|
| Heap             | JVM memory area used for Java object allocation                   |
| Young Generation | Area primarily containing newly allocated objects                 |
| Eden             | Primary allocation area for new objects in the traditional model  |
| S0               | Survivor space 0                                                  |
| S1               | Survivor space 1                                                  |
| Survivor Space   | Area holding objects that survived a Young GC                     |
| Old Generation   | Area containing older/long-lived objects                          |
| Young GC         | Collection focused primarily on Young Generation                  |
| Minor GC         | Common traditional term for Young GC                              |
| Major GC         | Term often used for old-generation collection, but meaning varies |
| Full GC          | More comprehensive heap collection, collector-dependent           |
| Promotion        | Moving/surviving an object into Old Generation                    |
| Object Age       | Number/level of collection cycles an object has survived          |
| Heap Pressure    | Increasing demand for heap allocation                             |
| GC Pressure      | Increasing garbage collection work                                |
| GC Root          | JVM reference from which object reachability is determined        |
| Xms              | Initial heap size configuration                                   |
| Xmx              | Maximum Java heap size                                            |

---

# 32. Important Notes About Modern JVMs

The traditional model:

```text
Eden + S0 + S1 + Old Gen
```

is useful for understanding **generational garbage collection**.

However, the exact implementation depends on the Garbage Collector.

For example, G1 GC uses:

```text
Heap
│
├── Many Regions
│
├── Eden Regions
├── Survivor Regions
└── Old Regions
```

Instead of one physically contiguous Young Generation and one physically contiguous Old Generation.

Conceptually:

```text
                  G1 HEAP
┌──────┬──────┬──────┬──────┬──────-┬──────┐
│ Eden │ Eden │ Old  │ Eden │Survive│ Old  │
├──────┼──────┼──────┼──────┼──────-┼──────┤
│ Old  │ Eden │ Old  │ Eden │ Eden  │ Old  │
└──────┴──────┴──────┴──────┴──────-┴──────┘
```

G1 divides the heap into regions and dynamically manages those regions.

Therefore, when learning:

```text
Eden
S0
S1
Old Gen
```

treat it as the **traditional generational model**, while remembering that modern collectors can implement generations differently.

---

# 33. Final Mental Model

The simplest way to remember JVM heap and GC is:

```text
                    JVM HEAP
                       │
              ┌────────┴────────┐
              │                 │
              ▼                 ▼
            YOUNG              OLD
              │                 │
        ┌─────┼─────┐           │
        ▼     ▼     ▼           ▼
      Eden   S0    S1         Old Gen
        │
        │ New objects
        ▼
      Object allocation
        │
        ▼
      Young GC
        │
        ├── Garbage → Reclaimed
        │
        └── Alive → Survivor
                       │
                       ▼
                 Multiple GCs
                       │
                       ▼
                    Old Gen
                       │
                       ▼
              Old/Full Collection
                       │
                       ▼
                 Garbage Reclaimed
```

The overall relationship is:

```text
Object Allocation
       ↓
Young Generation
       ↓
Eden fills
       ↓
Young GC
       ↓
Garbage reclaimed
       ↓
Surviving objects → Survivor Space
       ↓
Survive multiple GC cycles
       ↓
Promotion to Old Generation
       ↓
Old-generation collection
       ↓
Unreachable objects reclaimed
```

And the CPU relationship is:

```text
More Object Allocation
        ↓
More Heap Pressure
        ↓
More GC Activity
        ↓
More GC CPU Work
        ↓
Potentially Higher CPU Utilization
```

> **Core concept:** Java objects are generally created in the Young Generation, primarily in Eden in the traditional model. Objects that die quickly are reclaimed by Young GC. Objects that survive multiple collections can move through the Survivor spaces and eventually be promoted to Old Generation. Older garbage is reclaimed by appropriate old-generation or broader GC activity. Garbage Collection consumes CPU, but application threads and other JVM activities also consume CPU.