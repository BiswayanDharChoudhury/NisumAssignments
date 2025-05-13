import java.util.*;

class Sample {
    int value;  // Instance variable

    // Constructor to initialize instance variable
    public Sample(int val) {
        this.value = val;
    }

    // Static method - cannot directly access instance variables
    public static void showStatic() {
        // This won't compile: System.out.println(value);
    }

    // Instance method - can access instance variables directly
    public void displayInstance() {
        System.out.println("Instance method accessing value: " + value);
    }

    // Static method using object reference to access instance variable
    public static void showUsingObject(Sample ref) {
        System.out.println("Static method accessing value via object: " + ref.value);
    }
}

public class Main {
    public static void main(String[] args) {
        Sample s = new Sample(10);

        s.displayInstance();              // Instance method call
        Sample.showUsingObject(s);       // Static method with object reference
    }
}
