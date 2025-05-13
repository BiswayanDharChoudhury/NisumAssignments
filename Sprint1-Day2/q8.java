import java.util.*;


class Codechef {

    static int number;

    static {
        System.out.println("Static block is executed before the main method.");
        number = 10;
    }

    public static void main(String[] args) throws java.lang.Exception {
        System.out.println("Main method is running.");
        System.out.println("Value of number: " + number);
    }
}
