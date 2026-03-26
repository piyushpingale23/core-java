# JVM (Java Virtual Machine) Notes

---

## * JVM Overview

* JVM is **platform dependent**
* JVM converts:

    * Java source code → **Bytecode**
    * Bytecode → **Machine Code**

---

## * Components of JVM

1. Class Loader
2. Memory Areas
3. Execution Engine

---

## * JVM Architecture

```
Class Loader
      ↓
Runtime Data Areas
      ↓
Execution Engine
   → Interpreter
   → JIT Compiler
   → Garbage Collector
```

---

# 1. Class Loader

* A **Class Loader** is part of JVM responsible for loading `.class` files into memory at runtime.

---

## Class Loader Working Steps

1. **Loading** → Reads `.class` file

2. **Linking**

    * Verification
    * Preparation
    * Resolution

3. **Initialization**

    * Executes static blocks

* Class Loader follows **Delegation Hierarchy Algorithm**
* Input → `.class` file

---

## Phase 1: Loading

* JVM locates the `.class` file
* Reads bytecode into memory
* Creates a class object in **Method Area**
* Bootstrap / Extension / Application class loaders load the classes

---

## Types of Class Loaders

### 1. Bootstrap Class Loader

* Loads classes from **Java core libraries**
* Parent of all class loaders

---

### 2. Extension / Platform Class Loader

* Loads classes from **JDK extension libraries**
* Child of Bootstrap Class Loader

---

### 3. Application / System Class Loader

* Child of Extension Class Loader
* Loads application-specific classes (from current classpath)

---

## Parent Delegation Model

### Flow before loading a class:

1. Application Loader → asks Platform Loader
2. Platform Loader → asks Bootstrap Loader
3. If none can load → Bootstrap loads it

---

### Diagram

```
Bootstrap ClassLoader
 ↑ delegates      ↓ request
Extension ClassLoader
 ↑ delegates      ↓ request
Application ClassLoader

JVM Request → Class Loader Subsystem
```

---

## Phase 2: Linking

Linking has **3 sub-steps**:

* Verification
* Preparation
* Resolution

---

### 1. Verification

* Ensures bytecode is **safe and valid**
* JVM checks:

    * Bytecode format correctness
    * No memory corruption

---

### 2. Preparation

* Memory is allocated for **static variables**
* Default values are assigned

### Example:

```java
static int x = 10;
static String s = "Hello";
```

### After Preparation:

```
x = 0
s = null
```

---

### 3. Resolution

* Converts **symbolic references → direct memory references**

### Example:

```java
Student s = new Student();
```

* `Student` is a symbolic reference
* JVM resolves it to an actual memory address

---

## Phase 3: Initialization

* Final phase
* Actual values are assigned to variables
* Static blocks are executed
* Initialization happens **only once per class**

---

## Preparation vs Initialization

| Phase          | Behavior                |
|----------------|-------------------------|
| Preparation    | Default values assigned |
| Initialization | Actual values assigned  |

---

## Class Loader Subsystem Overview

```
Loading:
  Bootstrap Class Loader
        ↓
  Extension Class Loader
        ↓
  Application Class Loader

Linking:
  Verify
    ↓
  Prepare
    ↓
  Resolve

Initialization:
  Initialization
```

---

# 2. Runtime Data Area (Memory Area)

* Memory areas are parts of JVM created when JVM starts and used during program execution

* JVM runtime data areas are divided into **5 memory areas**:

    * Method Area (MetaSpace)
    * Heap Area
    * Stack Area
    * PC (Program Counter) Register
    * Native Method Stack

* For entire JVM:

    * One Method Area and one Heap Area

* For each thread:

    * Separate Stack is created

---

## 1. Method Area

* Stores:

    * Class metadata (class name, methods, fields)
    * Static variables
    * Method bytecode

* Shared across all threads

* Error:

  ```
  OutOfMemoryError: Metaspace
  ```

---

## 2. Heap Area

* Stores:

    * Java objects
    * Class instances
    * Arrays
    * Instance variables

* Managed by **Garbage Collector (GC)**

* Automatically removes unreferenced objects

* Shared across all threads

---

## 3. Stack Area

* Stores:

    * Method calls
    * Local variables
    * Object references

* Each method call creates a **stack frame**

* When method execution finishes → frame is removed

* Structure: **LIFO (Last In First Out)**

* Thread private

---

### Stack Frame

A stack frame represents the execution state of a method.

#### Structure:

1. **Local Variable Array**

    * Stores:

        * Method parameters
        * Local variables
        * Object references

2. **Operand Stack**

    * Used for bytecode execution

3. **Frame Metadata**

    * Return address
    * Method information
    * Pointer to constant pool

---

# 3. Execution Engine

* Execution engine is the JVM component that executes the bytecode loaded into memory.

**Components:**
Interpreter, JIT compiler, GC

Java compiler → it converts java source code into the bytecode.

---

## 1. Interpreter:

* Read bytecode line by line.
* Convert each instruction into machine language.

**Pros:** Fast
**Cons:** Slower for repeated code

* Same code interpret again and again.

---

## 2. JIT Compiler:

* Interpreter is slow for hot code (frequently executed code)
* So JVM uses JIT compiler to convert frequently executed bytecode into native machine code

**What is Hot code:**

* Methods, loops, block executed many times

Hotspot JVM detects hot code automatically using profiler.

---

### How JIT works:

1. Code starts executing in interpreter
2. JVM monitor execution frequency
3. When methods become “hot”, JIT compiles bytecode into machine code
4. Native code stored in code cache
5. Next executions use native code directly → no interpretation

---

### Optimization done by JIT:

* Method inlining
* Dead code elimination
* Loop unrolling
* Constant folding

---

## 3. Garbage Collection

* Garbage collector is responsible for garbage collection.
* Useless objects are garbage.
* Garbage collector is a part of JVM.

**Role:**

* To destroy useless objects.
* As a programmer, we are not responsible to destroy object, but it is highly recommended to make that object eligible for GC if it is no longer required.

---

## *The ways to make an object eligible for GC:*

* An object is said to be eligible for GC if and only if it does not contain any reference.

---

### 1. Nullify the reference variable:

* Assign null to its reference variable, then that object automatically eligible for GC.

**Eg:**

```
Student s1 = new Student();
Student s2 = new Student();

s1 = null; → s1 is eligible for GC, but still s2 not.
```

---

### 2. Reassigning the reference variable:

* If an object is no longer required, then reassign its reference variable to any other object. Old obj is eligible for GC.

```
Student s1 = new Student();
Student s2 = new Student();

s1 = new Student();
s2 = s1; → s1 eligible for GC
```

---

### 3. Object created inside a method:

* Objects created inside a method are by default eligible for GC once method completes (because the reference variables are local variables of that method & once method completes all local variables will be destroyed).

### Case 1:

```
public class Test {
    main() {
        Student s = m1();
    }

    public Student m1() {
        Student s1 = new Student();
        Student s2 = new Student();
        return s1;
    }
}
```

* After completing m1() method, s1 & s2 local variable gone
* But still returning object reference by ‘s’ variable
* So, s1 & s2 eligible for GC, but NOT ‘s’


### Case 2:

```
public class Test {
    main() {
        m1();
    }

    public Student m1() {
        Student s1 = new Student();
        Student s2 = new Student();
        return s1;
    }
}
```

* s1 & s2 eligible for GC. We are capture return obj in new ref variable.


### Case 3:

```
public class Test {
    static Student s;

    main() {
        m1();
    }

    Student m1() {
        s = new Student();
        Student s1 = new Student();
    }
}
```

* After completion m1(), s1 is eligible for GC
* But static variable belongs to class, not object
* So it is NOT eligible for GC

---

### 4. Island of Isolation:

* If an object does not have any reference variable then it is eligible for GC.

* Even though object having reference variable still sometimes it may be eligible for GC (if all references are internal)
* 
```
public class Test {
    Test t;

    main() {
        Test t1 = new Test();
        Test t2 = new Test();
        Test t3 = new Test();

        t1.t = t2;
        t2.t = t3;
        t3.t = t1;

        t1 = null; → no obj eligible for GC
        t2 = null; → no obj eligible for GC
        t3 = null; → all obj eligible for GC
    }
}
```

---

## Ways to request JVM to run GC:

### 1. Using System class:

```
System.gc();
```

---

### 2. Using Runtime class:

* A java application can communicate with JVM by using Runtime object.
* Runtime is a class present in java.lang package and it is singleton class.

```
Runtime r = Runtime.getRuntime(); → object created
r.freeMemory(); → return free memory bytes in heap
r.totalMemory(); → return total memory bytes in heap
r.gc();
```

---

## Finalization:

* Just before destroying an object, Garbage collector calls finalize() to perform cleanup activities.

* Once finalize() completes automatically GC destroy that object.

* finalize() present in object class:

```
protected void finalize() throws Throwable
```

* Based on our requirement we can override finalize() in our class to define our own cleanup activities.

---

### Case 1:

* Just before destroying an object, Garbage collector always call finalize() method on the object which is eligible for Garbage Collection.

* Then the corresponding class finalize() will be called.

* If String object is eligible for GC, String class finalize() calls

* If Test class obj is eligible for GC then Test class finalize() method will be called


### Case 2:

* Calling finalize() explicitly means it’s normal call (not destroy the object)
* But when GC call finalize() and completion of method execution, GC destroy that object


### Case 3:

- If a programmer calls finalize() explicitly and while executing that finalize() if any exception occurs which is uncaught then the programme will be terminated abnormally.

- But in Garbage Collector calls finalize() method & while executing that method any exception raised which is uncaught then JVM ignore that exception and rest of the programme executed normally.


### Case 4:

- On any object Garbage Collector call finalize() only once, even though that object eligible for GC multiple times.

---

## * Algorithm GC:

### 1) Reference Counting

- In this approach, every heap object maintains an integer field called reference count, which records how many references currently point to that object.

- Whenever a new reference is created to an object, its counter is incremented whereas a reference is removed or overwritten the counter is decremented.

- The moment counter becomes zero, the object is considered unreachable & its memory immediately reclaimed.

---

### 2) Mark & Sweep

- Mark & sweep one of the basic garbage collection in JVM.

- It works in two main steps: mark, sweep.

- In the mark phase, JVM starts from GC roots and marks all reachable objects alive.

- GC roots are special references (like stack variables, static fields and active threads) from which the JVM starts tracing all reachable objects during GC.

- Objects are not marked that considered as garbage.

- In the sweep phase, JVM scan the heap & deletes all unmarked objects.

- Mark & sweep can remove objects that have cyclic reference (Island of Isolation).

- The main disadvantage is that it creates fragmentation in memory, means free memory is broken into small holes.

---

### 3) Mark & Compact

- Mark & compact is an improved version of mark & sweep.

- In the mark phase, JVM finds all live objects by checking reachability from GC roots.

- In the compact phase, the live objects are move together to one side of the heap.

- While moving objects, all references are updated to point to new memory locations.

- After compaction, the heap becomes continuous & free of holes.

- The disadvantage of mark & compact is that moving objects takes time.

- Mark & compact mainly used for old (long-living) objects in JVM.

---

### 4) Copying GC

- Copying GC divided heap memory into 2 equal parts:  
  from-space & To-space.

- New objects are only created in from-space.

- When from-space becomes full, GC starts.

- All live objects copied from from-space to To-space.

- While copying, object references are updated to new memory locations.

- Dead objects are not copied.

- After copying, the entire from-space is cleared.

- Then from-space & To-space are swapped.

- It is mainly used in young generation of JVM.

---

# JVM Startup & Shutdown Process (Step-by-Step)

## A. JVM Startup Process

### A1. Application Execution

* When we run a Java program (`java ClassName`), the **Operating System (OS)** starts a new process.
* JVM is created as part of this process.

---

### A2. JVM Initialization

* JVM initializes its internal components.
* It prepares to execute the Java program.

---

### A3. Memory Allocation

* JVM requests memory (RAM) from the OS.
* Once allocated, JVM divides memory into runtime data areas:

#### JVM Memory Areas:

* **Method Area** → Class metadata, static variables, method code
* **Heap** → Objects and instance variables
* **Stack** → Method calls, local variables (per thread)
* **PC Register** → Stores current executing instruction (per thread)
* **Native Method Stack** → For native (non-Java) method execution

---

### A4. Class Loading Process

* **Class Loader** loads required `.class` files into memory.

#### Sub-steps:

1. **Loading** → Reads bytecode from `.class` file
2. **Linking**

    * Verification → checks bytecode correctness
    * Preparation → allocates memory for static variables
    * Resolution → resolves symbolic references
   
3. **Initialization** → Executes static blocks & initializes static variables

---

### A5. Execution Engine Starts

* Execution Engine begins execution of bytecode.

#### Components:

* **Interpreter** → Executes bytecode line by line
* **JIT Compiler** → Converts frequently used code into native machine code
* **Garbage Collector (GC)** → Manages memory by removing unused objects

---

### A6. Program Execution

* JVM calls the `main()` method.
* Program execution starts from here.

---

## B. JVM Shutdown Process

### JVM stops when:

### B1. Normal Termination

* When `main()` method completes execution
* AND all **non-daemon threads** finish execution

---

### B2. Explicit Termination

```
System.exit(0);
```

* Terminates JVM immediately

---

### 3. Abnormal Termination

* Due to:

    * Runtime errors (e.g., `OutOfMemoryError`)
    * Crashes or external kill signals

---

## Important Notes

* **Daemon threads** do NOT prevent JVM shutdown
* JVM continues running if any **non-daemon thread** is alive
* `System.exit()` forces shutdown even if threads are running

---

