import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.EOFException;

public class q5 {

    // Method to read a file and parse integers
    public static void readAndParseIntegers(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            System.out.println("Reading integers from file:");
            while ((line = reader.readLine()) != null) {
                int num = Integer.parseInt(line.trim()); // May throw NumberFormatException
                System.out.println("Parsed Integer: " + num);
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error occurred while reading or parsing: " + e.getMessage());
        }
    }

    // Main method to run the program
    public static void main(String[] args) {
        String filename = "numbers.txt"; // Make sure this file exists with numbers (and some bad lines for testing)
        readAndParseIntegers(filename);
    }
}
