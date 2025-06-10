import java.util.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class InvalidAgeException2 extends RuntimeException {
    public InvalidAgeException2(String message) {
        super(message);
    }
}

public class q3 {

    public static void validateAge(int age) {
        if (age <= 0) {
            throw new InvalidAgeException2("Invalid age: Age must be greater than 0.");
        } else {
            System.out.println("Valid age: " + age);
        }
    }

    public static void main(String[] args) {
        File file = new File("ages.txt");

        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextInt()) {
                int age = sc.nextInt();
                try {
                    validateAge(age);
                } catch (InvalidAgeException2 e) {
                    System.out.println("Caught Exception: " + e.getMessage());
                } catch (Exception e) {
                    System.out.println("Unexpected error: " + e.getMessage());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found - " + e.getMessage());
        }
    }
}
