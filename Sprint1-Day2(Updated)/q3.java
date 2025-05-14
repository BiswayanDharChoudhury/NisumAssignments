import java.util.HashSet;
import java.util.Scanner;

public class EmailManager {

    private static final HashSet<String> emailSet = new HashSet<>();

    // Adds an email to the set if it's not already present
    public static void addEmail(String email) {
        if (emailSet.add(email)) {
            System.out.println("Email added successfully.");
        } else {
            System.out.println("Duplicate email. Already exists.");
        }
    }

    // Displays all unique email addresses
    public static void displayEmails() {
        if (emailSet.isEmpty()) {
            System.out.println("No email addresses to display.");
        } else {
            System.out.println("Unique email addresses:");
            for (String email : emailSet) {
                System.out.println(email);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nEmail Management Menu");
            System.out.println("1. Add Email");
            System.out.println("2. Show All Unique Emails");
            System.out.println("3. Exit");
            System.out.print("Choose an option (1-3): ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter an email address: ");
                    String email = scanner.nextLine();
                    addEmail(email);
                    break;

                case 2:
                    displayEmails();
                    break;

                case 3:
                    System.out.println("Exiting the program.");
                    break;

                default:
                    System.out.println("Invalid choice. Please select between 1 and 3.");
            }
        } while (choice != 3);

        scanner.close();
    }
}
