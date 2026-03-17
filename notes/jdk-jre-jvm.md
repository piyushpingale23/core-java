# JDK vs JRE vs JVM (Java Architecture)

## 1. Introduction

Java follows the principle:

> **Write Once, Run Anywhere (WORA)**

This is possible because of three main components of Java architecture:

- **JDK (Java Development Kit)**
- **JRE (Java Runtime Environment)**
- **JVM (Java Virtual Machine)**

These components work together to **develop, compile, and run Java applications**.

---

# 2. JVM (Java Virtual Machine)

## Definition

**JVM (Java Virtual Machine)** is a virtual machine that runs Java bytecode.

It converts **compiled Java bytecode (.class file)** into **machine code** so that the program can run on the operating system.

JVM is responsible for **executing Java programs**.

---

## How JVM Works

1. Java source code is written in `.java` file.
2. Java compiler (`javac`) compiles it into **bytecode (.class)**.
3. JVM loads the bytecode.
4. JVM converts bytecode into **machine code**.
5. The program runs on the system.

---

## Responsibilities of JVM

JVM performs several important tasks:

- **Class Loading**
- **Bytecode Verification**
- **Execution of Code**
- **Memory Management**
- **Garbage Collection**

---

## JVM Memory Areas

JVM divides memory into different parts:

- **Method Area**
- **Heap Memory**
- **Stack Memory**
- **Program Counter Register**
- **Native Method Stack**

---

## Important Point

JVM is **platform dependent**.

Each operating system has its **own JVM implementation**, but all JVMs understand the **same Java bytecode**.

---

# 3. JRE (Java Runtime Environment)

## Definition

**JRE (Java Runtime Environment)** provides the **environment required to run Java programs**.

It contains:

- **JVM**
- **Core Java Libraries**
- **Supporting Files**

So JRE is used when you **only want to run Java applications**, not develop them.

---

## Components of JRE

JRE mainly contains:

1. **JVM (Java Virtual Machine)**
2. **Java Class Libraries**
3. **Runtime Supporting Files**

---

## Role of JRE

JRE provides:

- Runtime environment
- Standard Java libraries
- JVM for execution

Without JRE, **Java programs cannot run**.

---

# 4. JDK (Java Development Kit)

## Definition

**JDK (Java Development Kit)** is a complete **development package used to develop Java applications**.

It includes everything needed to:

- Write Java programs
- Compile Java programs
- Run Java programs

---

## Components of JDK

JDK contains:

- **JRE**
- **Java Compiler (javac)**
- **Java Debugger**
- **Java Documentation Tools**
- **Development Utilities**

---

## Important JDK Tools

Some commonly used JDK tools:

| Tool      | Description                |
|-----------|----------------------------|
| `javac`   | Compiles Java source code  |
| `java`    | Runs Java program          |
| `javadoc` | Generates documentation    |
| `jar`     | Creates Java archive files |
| `jdb`     | Java debugger              |

---

# 5. Relationship Between JDK, JRE, and JVM

The relationship can be represented as:

```
JDK
 └── JRE
      └── JVM
```

Meaning:

- **JDK contains JRE**
- **JRE contains JVM**

---

# 6. Simple Explanation

| Component | Purpose                                   |
|-----------|-------------------------------------------|
| JVM       | Runs Java bytecode                        |
| JRE       | Provides environment to run Java programs |
| JDK       | Provides tools to develop Java programs   |

---

# 7. Example Workflow

Step 1: Write Java program

```
Hello.java
```

Step 2: Compile program

```
javac Hello.java
```

Output:

```
Hello.class
```

Step 3: Run program

```
java Hello
```

Execution process:

```
Java Code (.java)
        ↓
Compiler (javac)
        ↓
Bytecode (.class)
        ↓
JVM
        ↓
Machine Code
        ↓
Program Output
```

---

# 8. Summary

- **JVM** executes Java bytecode.
- **JRE** provides the runtime environment to run Java programs.
- **JDK** provides development tools to create Java programs.
- JDK includes **JRE**, and JRE includes **JVM**.

Therefore:

```
JDK > JRE > JVM
```

---

# 9. Quick Overview

**JVM**  
A virtual machine that executes Java bytecode.

**JRE**  
A runtime environment that contains JVM and Java libraries required to run Java programs.

**JDK**  
A complete development kit that includes JRE, compiler, and tools required to develop Java applications.

---
