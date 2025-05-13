import java.util.*;
import java.lang.*;
import java.io.*;

class Parent {
    public static void displayMessage() {
        System.out.println("Static method from Parent class.");
    }
}

class Child extends Parent {
    public void callParentMethod() {
        Parent.displayMessage();
    }
}

class Codechef {
    public static void main(String[] args) {
        Child obj = new Child();
        obj.callParentMethod();
    }
}
