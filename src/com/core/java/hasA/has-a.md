# 1.  ASSOCIATION (Weaker relationship between 2 classes)

- Association is the general relationship between two classes where one object is connected to another.
- Association is a general relationship between two classes where:
    1. One class uses or interacts with another
    2. Objects are connected logically
    3. Both objects are independent
  
- Example: Teacher ↔ Student
    - Teacher teaches student
    - Student learns from teacher
    - Both can exist independently

- Aggregation and Composition are types of Association.
- So association is the parent concept.

---

## Types of Association: (cardinality)
1. One to One -> Person ↔ Passport
2. One to Many -> Teacher ↔ Student
3. May to Many -> Student ↔ Course
---

````java
class Student {
String name;
}

class Teacher {
    void teach(Student student) {
        System.out.println("Teaching " + student.name);
    }
}
````

✔ Why This Is Association?
- Teacher uses Student object
- Teacher does NOT create Student
- Student exists independently
---

## Spring / @Autowired Example

````java
@Service
class OrderService {

    @Autowired
    PaymentService paymentService;
}
````

This is association because:
- OrderService uses PaymentService
- Both beans exist independently
- Spring manages lifecycle

---

# 2.  AGGREGATION

- Aggregation is a weak Has-A relationship.
- Aggregation is a special type of association where:
    1. One class contains another class
    2. Relationship is "Has-A"
    3. But child object can exist independently
    4. Aggregation = Weak Ownership / Weak Association
- Example: Library & Books -> Books can exist outside of Library also.

---

````java
class Employee {
String name;
}

class Department {
    private List<Employee> employees;
    public Department(List<Employee> employees) {
        this.employees = employees;
    }
}
````

Why This Is Aggregation?
- Department contains employees
- Employees created outside department
- Employees survive if department deleted

````
Visualization:
Employee e1 = new Employee();
Employee e2 = new Employee();

List<Employee> list = new ArrayList<>();
list.add(e1);
list.add(e2);

Department dept = new Department(list);


Memory View:
e1 object  ─┐
├──► Department object
e2 object  ─┘

suppose, dept = null;
now, Department object → removed
Employee objects → STILL EXIST
Because:
Employees were created outside department
Other references may still point to them
````

---

# 3. COMPOSITION

- Composition is a strong "has-a" relationship between two classes where:
- One class is Parent (Whole)
- Another class is Child (Part)
- Child cannot exist independently
- Parent controls lifecycle of child
- Example: 1. House has-a rooms (House cannot exist without rooms)
           2. Human has-a Heart (Human cannot exist without heart

---

````java
class Engine {
    void start() {
        System.out.println("Engine started");
    }
}

class Car {
    private Engine engine;
    public Car() {
        engine = new Engine(); // Car creates Engine
    }
    void startCar() {
        engine.start();
    }
}
````

- Why This Is Composition?
- Car creates Engine
- Engine cannot exist separately
- Engine lifecycle tied to Car

````
Engine engine = new Engine();
Car car = new Car(engine);
if ,
car = null;
Car has a reference of Engine
so, engine = null;
````

---

# SUMMARY:

### Association
- General relationship between classes
- Objects interact but do not own each other
- Lifecycle independent

### Aggregation
- Weak "Has-A" relationship
- Parent references child
- Child exists independently
- Weak ownership

### Composition
- Strong "Part-Of" relationship
- Parent owns child
- Child lifecycle depends on parent
- Strong ownership
