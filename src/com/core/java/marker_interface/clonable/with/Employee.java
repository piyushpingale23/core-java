package com.core.java.marker_interface.clonable.with;

// Step 1: Employee class declares Cloneable marker interface
// This only gives JVM a "permission flag"
public class Employee implements Cloneable {

    int id = 10;

    // Step 2: We override clone() and expose it as public
    @Override
    public Object clone() throws CloneNotSupportedException {

        // DEBUG POINT 1:
        // Control enters here when employee.clone() is called

        System.out.println("Step 1: Inside Employee.clone() method");

        // Step 3: Call parent class clone() method (Object.clone)
        Object obj = super.clone();

        // DEBUG POINT 2:
        // Now execution moves inside JVM native cloning logic

        System.out.println("Step 2: Returned from super.clone()");

        return obj;
    }
}

class EmployeeTest {

    public static void main(String[] args) throws Exception {

        // Step 0: Object created in heap memory
        Employee employee = new Employee();

        System.out.println("Step 0: Original object created");

        // Step 2: Calling clone()
        Employee employee1 = (Employee) employee.clone();

        // ---------------- EXECUTION FLOW BELOW ----------------

        // Step 3: JVM checks method call
        // employee.clone() → calls Employee.clone()

        // Step 4: Inside Employee.clone()

        // Step 5: super.clone() is called
        // JVM goes to Object.clone()

        // Step 6: JVM internal check happens here:
        // if (this instanceof Cloneable)
        //     allow cloning
        // else
        //     throw CloneNotSupportedException

        // Step 7: If allowed → field-by-field copy created

        // Step 8: New object returned to employee1

        System.out.println("Step 3: Cloning completed");

        // Step 9: Verify both objects
        System.out.println("Original Employee id: " + employee.id);
        System.out.println("Cloned Employee id: " + employee1.id);

        System.out.println("Same reference? " + (employee == employee1));
    }
}