# Java Garbage Collectors (GC) - Quick Notes

## 1. Serial GC
### JVM Flag
```bash
-XX:+UseSerialGC
```

### Characteristics
- Single GC thread
- Stop-The-World (STW) during Young and Old GC
- Uses one CPU core

### Best For
- Small applications
- Small heap sizes (< 1-2 GB)
- Single-core or low-memory environments

### Pros
- Simple
- Low overhead

### Cons
- Long GC pauses
- Poor scalability

---

## 2. Parallel GC (Throughput GC)
### JVM Flag
```bash
-XX:+UseParallelGC
```

### Characteristics
- Multiple GC threads
- STW during collection
- Focuses on maximum throughput

### Best For
- Batch jobs
- CPU-intensive applications
- Applications where pause time is less important

### Pros
- High throughput
- Faster collection than Serial GC

### Cons
- Longer pause times

---

## 3. CMS (Concurrent Mark Sweep) GC
### JVM Flag
```bash
-XX:+UseConcMarkSweepGC
```

### Characteristics
- Concurrent Old Generation collection
- Minimizes pause times
- Most GC work runs alongside application threads

### Best For
- Low-latency applications

### Pros
- Shorter pauses than Parallel GC

### Cons
- More CPU usage
- Heap fragmentation
- Deprecated in Java 9
- Removed in Java 14

---

## 4. G1 GC (Garbage First)
### JVM Flag
```bash
-XX:+UseG1GC
```

### Characteristics
- Heap divided into Regions
- Concurrent and parallel phases
- Predictable pause times

### Best For
- Large heaps (4GB+)
- General-purpose applications

### Pros
- Balanced throughput and latency
- Predictable pauses
- Handles large heaps efficiently

### Cons
- Slightly more complex than Parallel GC

### Default GC
- Java 9+ default collector

---

## 5. ZGC (Z Garbage Collector)
### JVM Flag
```bash
-XX:+UseZGC
```

### Characteristics
- Ultra-low latency
- Concurrent collection
- Pause times usually < 1 ms

### Best For
- Huge heaps (100GB+)
- Real-time systems
- Trading platforms

### Pros
- Extremely low pause times
- Scales to TB-sized heaps

### Cons
- Slightly lower throughput than G1

---

## 6. Shenandoah GC
### JVM Flag
```bash
-XX:+UseShenandoahGC
```

### Characteristics
- Concurrent collection
- Pause time independent of heap size
- Low-latency collector

### Best For
- Large heap applications requiring low pauses

### Pros
- Very small pause times
- Consistent latency

### Cons
- Slightly higher CPU overhead

---

# Quick Comparison

| GC         | Throughput | Pause Time      | Heap Size    |
|------------|------------|-----------------|--------------|
| Serial     | Low        | High            | Small        |
| Parallel   | Highest    | High            | Medium-Large |
| CMS        | Medium     | Low             | Medium-Large |
| G1         | High       | Low-Medium      | Large        |
| ZGC        | Medium     | Very Low (<1ms) | Very Large   |
| Shenandoah | Medium     | Very Low        | Large        |

---

# Which GC Should I Use?

| Scenario                    | Recommended GC  |
|-----------------------------|-----------------|
| Small application           | Serial GC       |
| Batch processing            | Parallel GC     |
| General Spring Boot app     | G1 GC           |
| Large heap with low latency | ZGC             |
| Very low pause requirements | Shenandoah      |
| Java 17/21 production app   | G1 GC (default) |

---

# Can We Change GC Using JVM Flags?

Yes.

GC is selected when the JVM starts.

Example:

```bash
java -XX:+UseG1GC -jar app.jar
```

```bash
java -XX:+UseZGC -jar app.jar
```

```bash
java -XX:+UseParallelGC -jar app.jar
```

---

# How To Verify Which GC Is Running?

```bash
java -XX:+PrintCommandLineFlags -version
```

or

```bash
jcmd <PID> VM.flags
```

or

```bash
jstat -gc <PID>
```

or check VisualVM:

Applications
└── JVM
└── Monitor
└── JVM Arguments