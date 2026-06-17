package com.core.java.java_8.method_references;

// Instance Method Reference using Method References
public class MethodReferencesExample2 {

    public void display() {
        System.out.println("MethodReferencesExample2");
    }

    public static void main(String[] args) {

        MethodReferencesExample2 mr2 = new MethodReferencesExample2();

        Runnable r = mr2::display;
        r.run();
    }

}

// Instance Method Reference using Lambda Expression
class UsingLambdaExpression2 {

    public void display(String msg) {
        System.out.println(msg);
    }

    public static void main(String[] args) {

        UsingLambdaExpression2 demo = new UsingLambdaExpression2();

        Runnable r = () -> demo.display("UsingLambdaExpression2");
        r.run();
    }
}
