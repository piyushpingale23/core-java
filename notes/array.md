# Arrays

---

## What is an Array?

* An **array** is a collection of similar data types stored in **contiguous memory locations**.
* It is used to store multiple values in a single variable.

---

## Key Points

* Arrays are **fixed in size**
* Stores **homogeneous elements** (same data type)
* Index starts from **0**
* Stored in **Heap memory**
* Can store **primitive and object types**

---

## Syntax of Array Declaration

```java
dataType[] arrayName;
```

Example:

```java
int[] arr;
```

---

## Array Initialization

### 1. Static Initialization

```java
int[] arr = {10, 20, 30, 40};
```

---

### 2. Dynamic Initialization

```java
int[] arr = new int[5];
```

---

## Accessing Array Elements

```java
class AccessElement {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30};
        System.out.println(arr[0]); // 10
    }
}
```

---

## Types of Arrays in Java

---

## 1. Single Dimensional Array

### Definition:

Array with only one index.

### Example:

```java
public class SingleArrayExample {
    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40};

        for (int j : arr) {
            System.out.println(j);
        }
    }
}
```

---

## 2. Multi-Dimensional Array

### Definition:

Array with more than one index.

---

### 2D Array Example

```java
public class TwoDArrayExample {
    public static void main(String[] args) {

        int[][] arr = {
            {1, 2, 3},
            {4, 5, 6}
        };

        for (int[] intArray : arr) {
            for (int i : intArray) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
```

---

## 3. Jagged Array (Irregular Array)

### Definition:

Each row has different number of columns.

```java
public class JaggedArrayExample {
    public static void main(String[] args) {

        int[][] arr = new int[3][];

        arr[0] = new int[2];
        arr[1] = new int[3];
        arr[2] = new int[1];

        arr[0][0] = 10;
        arr[1][2] = 50;

        for (int[] intArray : arr) {
            for (int i : intArray) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
```

---

## Ways to Iterate Array

---

### 1. Using for loop

```
for (int i = 0; i < arr.length; i++) {
    System.out.println(arr[i]);
}
```

---

### 2. Using enhanced for loop

```
for (int num : arr) {
    System.out.println(num);
}
```

---

## Important Methods of Array

---

### length

```
System.out.println(arr.length);
```

---

### Arrays.toString()

```
import java.util.Arrays;

System.out.println(Arrays.toString(arr));
```

---

### Arrays.sort()

```
Arrays.sort(arr);
```

---

## Common Array Problems

---

### 1. Find Sum of Elements

```java
class SumElement {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println(sum);
    }
}
```

---

### 2. Find Maximum Element

```java
class MaxElement {
    public static void main(String[] args) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println(max);
    }
}
```

---

### 3. Reverse an Array

```java
class ReverseArray {
    public static void main(String[] args) {
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
    }
}
```

---

### 4. Find Second Largest Element

```java
class Example {
    public static void main(String[] args) {
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > first) {
                second = first;
                first = num;
            } else if (num > second && num != first) {
                second = num;
            }
        }

        System.out.println(second);
    }
}
```

---

## Advantages of Array

* Fast access using index (O(1))
* Easy to use
* Memory efficient

---

## Disadvantages of Array

* Fixed size
* Cannot grow dynamically
* Insertion/Deletion is costly

---

## One-Line Summary

**Array is a fixed-size data structure used to store similar type elements in contiguous memory locations.**

---

## Bonus Example (Object Array)

```java
class Student {
    String name;

    Student(String name) {
        this.name = name;
    }
}

public class ObjectArrayExample {
    public static void main(String[] args) {

        Student[] students = new Student[2];

        students[0] = new Student("Jack");
        students[1] = new Student("Rahul");

        for (Student s : students) {
            System.out.println(s.name);
        }
    }
}
```

---

## Final Conclusion

* Arrays are fundamental building blocks in Java
* Used internally in many data structures
* Understanding arrays is key for problem-solving

---
