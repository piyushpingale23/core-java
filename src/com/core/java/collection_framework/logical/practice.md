# Java Collection Framework — Logical Questions & Answers

---

# 1. Remove Duplicates from a List

## Question

```text
Input:  [1, 2, 2, 3, 4, 4, 5]
Output: [1, 2, 3, 4, 5]
```

## Answer

Use a `Set` because a `Set` does not allow duplicate elements.

```java
public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
    Set<Integer> set = new LinkedHashSet<>(numbers);
    System.out.println(set);
}
```

Output:
```text
[1, 2, 3, 4, 5]
```

---

# 2. Find Duplicate Elements

## Question

```text
Input:  [1, 2, 3, 2, 4, 3, 5]
Output: [2, 3]
```

## Answer

```java
public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 2, 4, 3, 5);

    Set<Integer> nonDuplicates = new HashSet<>();
    Set<Integer> duplicates = new LinkedHashSet<>();
    for (Integer number : numbers) {
        if (nonDuplicates.contains(number)) {
            duplicates.add(number);
        } else {
            nonDuplicates.add(number);
        }
    }
    System.out.println(duplicates);
}
```

---

# 3. Find the Second-Largest Distinct Number

## Question

```text
Input:  [10, 5, 20, 8, 20, 15]
Output: 15
```

## Answer

Use `TreeSet`.

```java
public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(10, 5, 20, 8, 20, 15);
    TreeSet<Integer> set = new TreeSet<>(numbers);
    System.out.println(set);
    Integer secondLargest = set.lower(set.last());
    System.out.println(secondLargest);
}
```

Output:

```text
[5, 8, 10, 15, 20]
15
```

Useful methods:

```
set.first();       // smallest
set.last();        // largest
set.lower(x);      // greatest element strictly less than x
set.higher(x);     // smallest element strictly greater than x
```

---

# 4. Find Intersection of Two Lists

## Question

```text
List1 = [1, 2, 3, 4]
List2 = [3, 4, 5, 6]

Output = [3, 4]
```

## Answer

```java
import java.util.ArrayList;

public static void main(String[] args) {
    List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
    List<Integer> list2 = Arrays.asList(3, 4, 5, 6);
    List<Integer> intersectedElements = new ArrayList<>();
    for (Integer i : list2) {
        if (list1.contains(i)) {
            intersectedElements.add(i);
        }
    }
    System.out.println(intersectedElements);
    
    // OR
    
    list1.retainAll(list2);
    System.out.println(list1);
}
```

Output:

```text
[3, 4]
```

## Interview Note

`retainAll()` is useful for finding common elements between collections.

---

# 5. Merge Two Lists Without Duplicates

## Question

```text
List1 = [1, 2, 3, 4]
List2 = [3, 4, 5, 6]

Output = [1, 2, 3, 4, 5, 6]
```

## Answer

Use `LinkedHashSet`.

```java
public static void main(String[] args) {
    List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
    List<Integer> list2 = Arrays.asList(3, 4, 5, 6);

    Set<Integer> result = new LinkedHashSet<>();
    result.addAll(list1);
    result.addAll(list2);
    System.out.println(result);
}
```

Output:

```text
[1, 2, 3, 4, 5, 6]
```

## Why `LinkedHashSet`?

It provides:

```text
Uniqueness + Insertion order
```

---

# 6. Find Missing Number

## Question

```text
Input:  [1, 2, 3, 5, 6]
Output: 4
```

## Answer

Using a `Set`:

```java
public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 5, 6);
    Set<Integer> set = new HashSet<>(numbers);
    for (int i = 1; i <= 6; i++) {
        if (!set.contains(i)) {
            System.out.println(i);
            break;
        }
    }
}
```

Output:

```text
4
```

## Interview Note

If the problem guarantees numbers from `1` to `n` with exactly one missing number, another common solution is:

```text
Expected sum - Actual sum
```

```java
public static void main(String[] args) {
    int expected = n * (n + 1) / 2;
    int actual = 0;
    for (Integer number : numbers) {
        actual += number;
    }
    int missing = expected - actual;
}
```

---

# 7. Find Frequency of Each Element

## Question

```text
Input: [1, 2, 2, 3, 3, 3]

Output:
1 -> 1
2 -> 2
3 -> 3
```

## Answer

Use `Map`.

```java
public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 3, 3);
    Map<Integer, Integer> frequency = new HashMap<>();
    for (Integer number : numbers) {
        frequency.put(number, frequency.getOrDefault(number, 0) + 1);
    }
    System.out.println(frequency);

}
```

---

# 8. Why Does Set Remove Duplicates?

## Question

Why does this remove duplicates?

```java
List<Integer> list = Arrays.asList(1, 2, 2, 3, 3, 4);
Set<Integer> set = new HashSet<>(list);
```

## Answer

A `Set` is designed to store unique elements.

When inserting an element:

```text
Element
   |
   v
Is equivalent element already present?
   |
   +-- Yes --> Do not add
   |
   +-- No  --> Add
```

For `HashSet`, uniqueness is determined using `hashCode()` and `equals()`.

---

# 9. HashSet vs LinkedHashSet vs TreeSet

## Question

Given:

```
5, 2, 8, 1, 3
```

What happens with:

```java
Set<Integer> set1 = new HashSet<>();
Set<Integer> set2 = new LinkedHashSet<>();
Set<Integer> set3 = new TreeSet<>();
```

## Answer

### HashSet

```text
Duplicates removed
Order not guaranteed
```

Example output may be:

```text
[1, 2, 3, 5, 8]
```

but the order should not be relied upon.

### LinkedHashSet

```text
Duplicates removed
Insertion order maintained
```

Output:

```text
[5, 2, 8, 1, 3]
```

### TreeSet

```text
Duplicates removed
Sorted order maintained
```

Output:

```text
[1, 2, 3, 5, 8]
```

---

# 10. What Happens When Adding Duplicate Elements to HashSet?

## Question

```java
public static void main(String[] args) {
    Set<Integer> set = new HashSet<>();
    set.add(10);
    set.add(20);
    set.add(10);
    set.add(30);
}
```

What is the size?

## Answer

```text
3
```

The second `10` is not added.

```text
10 -> added
20 -> added
10 -> duplicate
30 -> added
```

Final:

```text
[10, 20, 30]
```

---

# 11. Custom Object in HashSet Without equals() and hashCode()

```java
class Employee {
    private int id;
    public Employee(int id) {
        this.id = id;
    }
}
```

```java
public static void main(String[] args) {
    Set<Employee> employees = new HashSet<>();
    employees.add(new Employee(1));
    employees.add(new Employee(1));
    System.out.println(employees.size());
}
```

## Answer

Normally:

```text
2
```

because these are two different objects.

The default `Object.equals()` compares object identity, and the default `hashCode()` is identity-related.

Therefore, Java does not know that both employees represent the same logical employee.

---

# 12. equals() Overridden but hashCode() Not Overridden

This can break hash-based collections such as:

```text
HashMap
HashSet
Hashtable
```

Example:

```java
class Employee {
    int id;
    @Override
    public boolean equals(Object obj) {
        Employee other = (Employee) obj;
        return this.id == other.id;
    }
}
```

Two objects can now be:

```
employee1.equals(employee2) == true
```

but may have different hash codes.

Then `HashSet` or `HashMap` may place them in different buckets.

---

# 13. Count Frequency of Characters

## Question

```text
Input: "banana"

Output:
b -> 1
a -> 3
n -> 2
```

## Answer

```java
public static void main(String[] args) {
    String value = "banana";
    Map<Character, Integer> frequency = new HashMap<>();
    for (char ch : value.toCharArray()) {
        frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
    }
    System.out.println(frequency);
}
```

---

# 14. Find First Non-Repeated Character

## Question

```text
Input: "swiss"
Output: w
```

## Answer

First count frequencies using `LinkedHashMap`.

```java
public static void main(String[] args) {
    String value = "swiss";
    Map<Character, Integer> frequency = new LinkedHashMap<>();
    for (char ch : value.toCharArray()) {
        frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
    }

    for (Map.Entry<Character, Integer> entry :frequency.entrySet()) {
        if (entry.getValue() == 1) {
            System.out.println(entry.getKey());
            break;
        }
    }
}
```

Output:

```text
w
```

---

# 15. Find Duplicate Characters

## Question

```text
Input: "programming"

Output:
r
g
m
```

## Answer

```java
public static void main(String[] args) {
    String value = "programming";
    Map<Character, Integer> frequency = new HashMap<>();
    for (char ch : value.toCharArray()) {
        frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
    }

    for (Map.Entry<Character, Integer> entry :frequency.entrySet()) {
        if (entry.getValue() > 1) {
            System.out.println(entry.getKey());
        }
    }
}
```

---

# 16. Find the Key Having Maximum Value

## Question

```java
Map<String, Integer> map = Map.of(
        "A", 10,
        "B", 50,
        "C", 30
);
```

Output:

```text
B
```

## Answer

```java
public static void main(String[] args) {
    String maxKey = null;
    int maxValue = Integer.MIN_VALUE;
    for (Map.Entry<String, Integer> entry :map.entrySet()) {
        if (entry.getValue() > maxValue) {
            maxValue = entry.getValue();
            maxKey = entry.getKey();
        }
    }
    System.out.println(maxKey);
}
```

Output:

```text
B
```

---

# 17. Sort a Map by Values

## Question

```text
Input:
A -> 30
B -> 10
C -> 20

Output:
B -> 10
C -> 20
A -> 30
```

## Answer

A `Map` itself does not provide a general `sortByValue()` operation.

Convert entries into a list and sort them.

```java
public static void main(String[] args) {
    Map<String, Integer> map = new HashMap<>();
    map.put("A", 30);
    map.put("B", 10);
    map.put("C", 20);

    List<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
    entries.sort(Map.Entry.comparingByValue()); //ascending order
    entries.sort(Map.Entry.<String, Integer>comparingByValue().reversed()); //descending order

    for (Map.Entry<String, Integer> entry : entries) {
        System.out.println(entry.getKey() + " -> " + entry.getValue());
    }
}
```

Output:

```text
B -> 10
C -> 20
A -> 30
```

---

# 18. Find Duplicate Values in a Map

## Question

```text
A -> 10
B -> 20
C -> 10
D -> 30

Output:
10
```

## Answer

Use a `Set` to track values already seen.

```java
public static void main(String[] args) {
    Map<String, Integer> map = new HashMap<>();
    map.put("A", 10);
    map.put("B", 20);
    map.put("C", 10);
    map.put("D", 30);

    Set<Integer> seen = new HashSet<>();
    Set<Integer> duplicates = new HashSet<>();

    for (Integer value : map.values()) {

        if (seen.contains(value)) {
            duplicates.add(value);
        } else {
            seen.add(value);
        }
    }

    System.out.println(duplicates);
}
```

Output:

```text
[10]
```

---

# 19. Group Employees by Department

## Question

```text
Piyush -> IT
Rahul  -> HR
Amit   -> IT
Neha   -> HR
```

Expected:

```text
IT -> [Piyush, Amit]
HR -> [Rahul, Neha]
```

## Answer

Use:

```text
Map<Department, List<Employee>>
```

Example:

```java
public static void main(String[] args) {
    Map<String, List<String>> employees = new HashMap<>();
}
```

Result:

```text
IT -> [Piyush, Amit]
HR -> [Rahul, Neha]
```

---

# 20. Sort Integers Using Collections

## Question

```java
List<Integer> numbers = Arrays.asList(50, 10, 30, 20, 40);
```

Sort ascending and descending.

## Answer

```java
import java.util.Collections;

public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(50, 10, 30, 20, 40);
    Collections.sort(numbers); //ascending order
    numbers.sort(Comparator.reverseOrder()); //descending order
    Collections.sort(numbers, (a, b) -> b - a); //descending order
}
```

---

# 21. Sort Employees by Different Fields

## Question

Given:

```java
class Employee {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
}
```

Sort by:

```text
1. Salary
2. Name
3. Salary descending
4. Salary and then name
```

## Answer

### Salary

```java
import com.core.java.marker_interface.serializable.with.Employee;

import java.util.ArrayList;
import java.util.List;

public static void main(String[] args) {
    List<Employee> employees = new ArrayList<>();
    Employee e1 = new Employee(1, "A", 100);
    Employee e2 = new Employee(2, "B", 200);
    employees.add(e1);
    employees.add(e2);

    employees.sort(Comparator.comparingDouble(Employee::getSalary)); //salary ascending order
    employees.sort(Comparator.comparingDouble(Employee::getSalary).reversed()); // salary descending order
    employees.sort(Comparator.comparing(Employee::getName)); //name ascending order
    employees.sort(Comparator.comparingDouble(Employee::getSalary).thenComparing(Employee::getName));
}
```

---

# 22. Can ArrayList<Employee> Use Comparable?

## Question

Can we sort:

```java
ArrayList<Employee> list;
```

using `Comparable`?

## Answer

Yes.

The class must implement:

```
Comparable<Employee>
```

Example:

```java
import java.util.Collections;

class Employee implements Comparable<Employee> {
    private int id;
    private String name;

    @Override
    public int compareTo(Employee other) {
        return Integer.compare(this.id, other.id);
    }
}

public class Test {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        Employee e1 = new Employee(1, "A");
        Employee e2 = new Employee(2, "B");
        employees.add(e1);
        employees.add(e2);

        Collections.sort(employees); //ascending order based on id
        Collections.sort(employees, (a,b) -> b - a); //descending order based on id
    }
}
```

---

# 23. Can We Use Different Sorting Criteria Without Modifying Employee?

## Question

Can we sort employees by salary, name, etc. without changing the `Employee` class?

## Answer

Yes. Use `Comparator`.

## Difference

```text
Comparable
    -> natural/default ordering
    -> implemented inside the class

Comparator
    -> external/custom ordering
    -> multiple sorting strategies possible
```

---

# 24. What Happens Internally in Collections.sort()?

```
Collections.sort(employees);
```

## Answer

For a list of `Comparable` objects, sorting uses their natural ordering.

Conceptually:

```text
Collections.sort(employees)
        |
        v
List.sort(...)
        |
        v
Sorting algorithm
        |
        v
compareTo()
        |
        v
Elements reordered
```

---

# 25. Problem with Raw List

## Question

What is wrong here?

```java
public static void main(String[] args) {
    List list = new ArrayList();
    list.add("Java");
    list.add(100);
    String value = (String) list.get(1);
}
```

## Answer

The list is a raw type, so it can contain different object types.

```text
"Java" -> String
100    -> Integer
```

At runtime:

```java
String value = (String) list.get(1);
```

causes:

```text
ClassCastException
```

because `100` is an `Integer`, not a `String`.

## Better Approach

```java
public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    list.add("Java");
    list.add("Spring");
}
```

Generics provide compile-time type safety.

---

# 26. Why Is List<String> Safer?

## Question

```java
public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    list.add("Java");
    list.add("Spring");
}
```

## Answer

The compiler knows that the list can contain only `String`.

Therefore:

```
list.add(100);
```

is rejected at compile time.

Also:

```java
String value = list.get(0);
```

does not require an explicit cast.

---

# 27. What Can We Do with List<? extends Number>?

## Question

```java
List<? extends Number> list;
```

Can we do:

```
list.add(10);
Number n = list.get(0);
```

## Answer

### Add

```
list.add(10);
```

Not allowed.

Why?

The actual list could be:

```
List<Integer>
List<Double>
List<Float>
```

If it were:

```
List<Double>
```

adding an `Integer` would be unsafe.

### Read

```java
Number n = list.get(0);
```

Allowed.

Because whatever the actual subtype is, it is guaranteed to be a `Number`.

---

# 28. What Can We Do with List<? super Integer>?

## Question

```java
List<? super Integer> list;
```

Can we:

```java
public static void main(String[] args) {
    list.add(10);
    Integer n = list.get(0);
    Object n = list.get(0);
}
```

## Answer

### Add Integer

Allowed:

```
list.add(10);
```

The actual list can be:

```text
List<Integer>
List<Number>
List<Object>
```

All of them can safely store an `Integer`.

### Read as Integer

Not safely allowed:

```java
Integer n = list.get(0);
```

The actual list could be:

```
List<Number>
```

and the object retrieved could be another `Number`.

### Read as Object

Allowed:

```java
Object n = list.get(0);
```

Every Java object is an `Object`.

---

# 29. Difference Between List<T> and List<?>

## Answer

### `List<T>`

`T` represents a specific generic type.

Example:

```java
<T> void print(List<T> list){}
```

The method has a type variable `T`.

### `List<?>`

`?` represents an unknown type.

Example:

```java
void print(List<?> list) {}
```

The method can accept:

```
List<String>
List<Integer>
List<Employee>
```

---

# 30. Why Can't Collections Use Primitive Types?

## Question

Why is this invalid?

```java
List<int> list;
```

but this is valid:

```java
List<Integer> list;
```

## Answer

Java Generics work only with reference types.

Primitive types are not objects:

```text
int
long
double
char
boolean
```

Use wrapper classes:

```text
int     -> Integer
long    -> Long
double  -> Double
char    -> Character
boolean -> Boolean
```

Java automatically performs boxing/unboxing.

---

# 31. Unique Elements + Insertion Order

## Question

You need:

```text
Unique elements + Insertion order maintained
```

Which collection?

## Answer

```
LinkedHashSet
```

Example:

```java
public static void main(String[] args) {
    Set<Integer> set = new LinkedHashSet<>();
    set.add(30);
    set.add(10);
    set.add(20);
    set.add(10);
    System.out.println(set);
}
```

Output:

```text
[30, 10, 20]
```

---

# 32. Unique Elements + Sorted Order

## Question

You need:

```text
Unique elements + Sorted order
```

Which collection?

## Answer

```
TreeSet
```

Example:

```java
public static void main(String[] args) {
    Set<Integer> set = new TreeSet<>();
    set.add(30);
    set.add(10);
    set.add(20);
    set.add(10);
    System.out.println(set);
}
```

Output:

```text
[10, 20, 30]
```

---

# 33. Key-Value Pairs + Fast Lookup

## Question

You need:

```text
Key-value pairs + Fast lookup by key
```

Which collection?

## Answer

Generally:

```
HashMap
```

Example:

```java
public static void main(String[] args) {
    Map<Integer, String> employees = new HashMap<>();
    employees.put(101, "Piyush");
    employees.put(102, "Rahul");
    System.out.println(employees.get(101));
}
```

Output:

```text
Piyush
```

---

# 34. Key-Value Pairs + Insertion Order

## Question

You need:

```text
Key-value pairs + Insertion order
```

Which collection?

## Answer

```
LinkedHashMap
```

Example:

```java
public static void main(String[] args) {
    Map<Integer, String> map = new LinkedHashMap<>();
    map.put(3, "C");
    map.put(1, "A");
    map.put(2, "B");
    System.out.println(map);
}
```

Output:

```text
{3=C, 1=A, 2=B}
```

---

# 35. Key-Value Pairs + Sorted Keys

## Question

You need:

```text
Key-value pairs + Keys automatically sorted
```

Which collection?

## Answer

```
TreeMap
```

Example:

```java
public static void main(String[] args) {
    Map<Integer, String> map = new TreeMap<>();
    map.put(3, "C");
    map.put(1, "A");
    map.put(2, "B");
    System.out.println(map);
}
```

Output:

```text
{1=A, 2=B, 3=C}
```

## Interview Note

`TreeMap` sorts by key, not by value.

---

# 36. Frequently Add, Remove and get(index)

## Question

You frequently perform:

```text
add()
remove()
get(index)
```

Which List implementation should you consider?

## Answer

The answer depends on the operation pattern.

### ArrayList

Best when random access is frequent:

```
list.get(index);
```

Because `ArrayList` is backed by an array.

```text
get(index) -> O(1)
```

Insertion/removal in the middle is generally `O(n)` because elements may need to shift.

### LinkedList

Can efficiently add/remove at known ends:

```text
addFirst()
addLast()
removeFirst()
removeLast()
```

But:

```
get(index)
```

is generally `O(n)`.

---

# 37. Frequently Calling contains()

## Question

You have 1 million elements and frequently execute:

```
collection.contains(value);
```

Which collection is generally preferable to `ArrayList`?

## Answer

Usually:

```
HashSet
```

because average-case lookup is generally `O(1)`.

For `ArrayList`:

```text
contains() -> O(n)
```

because it may scan elements one by one.

For `HashSet`:

```text
contains() -> average O(1)
```

assuming good hash distribution.

---

# 38. What Happens Internally in HashMap.put()?

## Question

What happens when:

```
map.put("Java", 100);
```

is executed?

## Conceptual Flow

```text
"Java"
   |
   v
hashCode()
   |
   v
HashMap hash calculation
   |
   v
Bucket/index calculation
   |
   v
Check existing entries
   |
   v
equals()
   |
   +-- Same key -> replace value
   |
   +-- Different key -> insert new entry
```

---

# 39. What Happens When Two Keys Have the Same Hash?

## Question

What happens when two different keys have the same hash value?

## Answer

This is called a hash collision.

Example:

```text
Key A -> hash = 100
Key B -> hash = 100
```

They may map to the same bucket.

`HashMap` then uses equality checking to distinguish them.

```text
Same bucket
    |
    +-- key.equals(existingKey) == true
    |       -> same key
    |
    +-- false
            -> different key
            -> store another entry
```

Modern Java `HashMap` can use a tree structure for heavily-collided buckets under certain conditions.

---

# 40. Does Same hashCode() Mean equals() is True?

## Question

If:

```
key1.hashCode() == key2.hashCode()
```

does that mean:

```
key1.equals(key2)
```

is always true?

## Answer

No.

Two different objects can have the same hash code.

```text
Same hashCode
     |
     +--> may be equal
     |
     +--> may NOT be equal
```

But:

```text
equals() == true => hashCode() must be same
```

---

# 41. Removing from List During for-each

## Question

What is wrong with:

```java
public static void main(String[] args) {
    List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
    for (Integer i : list) {
        if (i == 2) {
            list.remove(i);
        }
    }
}
```

## Answer

This can cause:

```text
ConcurrentModificationException
```

because the list is structurally modified while the iterator used by the enhanced `for` loop is active.

## Correct Approach

Use `Iterator.remove()`.

```java
public static void main(String[] args) {
    List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
    Iterator<Integer> iterator = list.iterator();
    while (iterator.hasNext()) {
        Integer value = iterator.next();
        if (value == 2) {
            iterator.remove();
        }
    }
}
```

---

# 42. How to Safely Remove Elements While Iterating?

## Answer

Use `Iterator`.

```java
public static void main(String[] args) {
    List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
    Iterator<Integer> iterator = list.iterator();
    while (iterator.hasNext()) {
        Integer value = iterator.next();
        if (value % 2 == 0) {
            iterator.remove();
        }
    }
}
```

This safely removes even numbers.

---

# 43. Implement LRU Cache Using Java Collections

## Question

```text
Capacity = 3

put(A)
put(B)
put(C)
get(A)
put(D)
```

Expected keys from least recently used to most recently used:

```text
B, C, A, D
```

## Answer

Use `LinkedHashMap`.

```java
class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;
    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }
}
```

Usage:

```java
class Test {
    public static void main(String[] args) {
        LRUCache<String, String> cache = new LRUCache<>(3);
        cache.put("A", "A");
        cache.put("B", "B");
        cache.put("C", "C");

        cache.get("A");

        cache.put("D", "D");

        System.out.println(cache.keySet());
    }
}
```

Output:

```text
[B, C, A, D]
```

---

# 44. Find Top 3 Highest Numbers

## Question

```text
Input:
[10, 50, 20, 80, 30, 70, 40]

Output:
80, 70, 50
```

## Answer

Use a `PriorityQueue` as a min-heap of size 3.

```java
public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(10, 50, 20, 80, 30, 70, 40);
    PriorityQueue<Integer> queue = new PriorityQueue<>(3);
    for (Integer number : numbers) {
        queue.offer(number);
        if (queue.size() > 3) {
            queue.poll();
        }
    }
    System.out.println(queue);

    List<Integer> result = new ArrayList<>(queue);
    result.sort(Comparator.reverseOrder());
    System.out.println(result);
}
```

The queue contains the top three values.

To retrieve them in descending order:

Output:

```text
[80, 70, 50]
```

## Why PriorityQueue?

We only need to keep the best 3 elements.

The smallest among those 3 stays at the head and can be removed when a larger element arrives.

## Interview Note

For top `K` elements:

```text
PriorityQueue of size K
```

is a common approach.

---

# 45. Find Top 3 Employees by Salary

## Question

Given employees:

```text
Piyush -> 50000
Rahul  -> 70000
Amit   -> 90000
Neha   -> 60000
Raj    -> 80000
```

Find top 3 by salary.

## Answer

Use a `PriorityQueue`.

```java
PriorityQueue<Employee> queue = new PriorityQueue<>(
                Comparator.comparingDouble(Employee::getSalary)
        );

for (Employee employee : employees) {

    queue.offer(employee);

    if (queue.size() > 3) {
        queue.poll();
    }
}
```

The queue contains the three highest-paid employees.

## Why?

The employee with the smallest salary among the current top 3 is at the head.

When a fourth employee enters:

```text
Add employee
    |
    v
Size > 3?
    |
    v
Remove smallest
```

## Interview Note

This is the same top-K pattern as the previous question.

---

# 51. Find Element with Highest Frequency

## Question

```text
Input:
[10, 20, 10, 30, 20, 40, 10]

Output:
10
```

## Answer

First create frequency map.

```java
List<Integer> numbers =
        Arrays.asList(10, 20, 10, 30, 20, 40, 10);

Map<Integer, Integer> frequency =
        new HashMap<>();

for (Integer number : numbers) {

    frequency.put(
            number,
            frequency.getOrDefault(number, 0) + 1
    );
}
```

Then find maximum frequency:

```java
Integer result = null;
int maxFrequency = 0;

for (Map.Entry<Integer, Integer> entry :
        frequency.entrySet()) {

    if (entry.getValue() > maxFrequency) {

        maxFrequency = entry.getValue();
        result = entry.getKey();
    }
}

System.out.println(result);
```

Output:

```text
10
```

## Interview Note

Common pattern:

```text
List
  |
  v
Frequency Map
  |
  v
Find maximum frequency
```

---

# 52. Group Employees and Find Highest Salary in Each Department

## Question

Given:

```text
Employee       Department    Salary

Piyush         IT            50000
Amit           IT            80000
Rahul          HR            60000
Neha           HR            70000
```

Expected:

```text
IT -> Amit
HR -> Neha
```

## Answer

Using `groupingBy()`:

```java
Map<String, Optional<Employee>> result =
        employees.stream()
                .collect(
                    Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.maxBy(
                            Comparator.comparingDouble(
                                Employee::getSalary
                            )
                        )
                    )
                );
```

## Concept

```text
Employees
    |
    v
groupingBy(department)
    |
    +---- IT
    |      |
    |      +--> highest salary
    |
    +---- HR
           |
           +--> highest salary
```

## Interview Note

This combines:

```text
Map
+
Grouping
+
Comparator
+
Collectors
```

It is a common advanced Collection/Stream interview problem.

---

# 53. Find Most Frequently Occurring Word

## Question

```text
Input:
["apple", "banana", "apple",
 "orange", "banana", "apple"]

Output:
apple
```

## Answer

```java
List<String> words =
        Arrays.asList(
                "apple",
                "banana",
                "apple",
                "orange",
                "banana",
                "apple"
        );

Map<String, Integer> frequency =
        new HashMap<>();

for (String word : words) {

    frequency.put(
            word,
            frequency.getOrDefault(word, 0) + 1
    );
}

String result = null;
int max = 0;

for (Map.Entry<String, Integer> entry :
        frequency.entrySet()) {

    if (entry.getValue() > max) {

        max = entry.getValue();
        result = entry.getKey();
    }
}

System.out.println(result);
```

Output:

```text
apple
```

---

# 54. Check Whether Two Lists Contain Same Elements Ignoring Order

## Question

```text
List1 = [1, 2, 3, 4]
List2 = [4, 3, 2, 1]

Output: true
```

## Answer

If duplicate frequency does not matter, compare `Set`s.

```java
List<Integer> list1 =
        Arrays.asList(1, 2, 3, 4);

List<Integer> list2 =
        Arrays.asList(4, 3, 2, 1);

boolean result =
        new HashSet<>(list1)
                .equals(new HashSet<>(list2));

System.out.println(result);
```

Output:

```text
true
```

## Important Difference

This ignores duplicates.

For example:

```text
[1, 2, 2, 3]
[1, 2, 3]
```

Both become:

```text
[1, 2, 3]
```

as sets.

Therefore, this approach is only correct when element frequency does not matter.

---

# 55. Check Whether Two Lists Contain Same Elements with Same Frequency

## Question

```text
List1 = [1, 2, 2, 3]
List2 = [2, 1, 3, 2]

Output: true
```

## Answer

Use frequency maps.

```java
List<Integer> list1 =
        Arrays.asList(1, 2, 2, 3);

List<Integer> list2 =
        Arrays.asList(2, 1, 3, 2);

Map<Integer, Integer> frequency1 =
        new HashMap<>();

Map<Integer, Integer> frequency2 =
        new HashMap<>();

for (Integer number : list1) {

    frequency1.put(
            number,
            frequency1.getOrDefault(number, 0) + 1
    );
}

for (Integer number : list2) {

    frequency2.put(
            number,
            frequency2.getOrDefault(number, 0) + 1
    );
}

boolean result = frequency1.equals(frequency2);

System.out.println(result);
```

Output:

```text
true
```

## Why Not Set?

Because `Set` removes duplicates.

Example:

```text
List1 = [1, 2, 2, 3]
List2 = [1, 2, 3]
```

Sets:

```text
Set1 = [1, 2, 3]
Set2 = [1, 2, 3]
```

So Set comparison incorrectly gives:

```text
true
```

But the lists do not have the same frequency.

Frequency maps preserve the count:

```text
List1:
1 -> 1
2 -> 2
3 -> 1

List2:
1 -> 1
2 -> 1
3 -> 1
```

Therefore:

```text
false
```

---
