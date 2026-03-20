# JVM (Java Virtual Machine) Notes

---

## JVM Overview

* JVM is **platform dependent**
* JVM converts:

    * Java source code → **Bytecode**
    * Bytecode → **Machine Code**

---

## Components of JVM

1. Class Loader
2. Memory Areas
3. Execution Engine

---

## JVM Architecture

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

# Phase 1: Loading

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

# Phase 2: Linking

Linking has **3 sub-steps**:

* Verification
* Preparation
* Resolution

---

## 1. Verification

* Ensures bytecode is **safe and valid**
* JVM checks:

    * Bytecode format correctness
    * No memory corruption

---

## 2. Preparation

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

## 3. Resolution

* Converts **symbolic references → direct memory references**

### Example:

```java
Student s = new Student();
```

* `Student` is a symbolic reference
* JVM resolves it to an actual memory address

---

# Phase 3: Initialization

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

# Class Loader Subsystem Overview

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

## One-Line Revision

> JVM loads `.class` files using Class Loader, performs Linking (Verify, Prepare, Resolve), then Initialization, and uses Runtime Data Areas to execute the program.

---
