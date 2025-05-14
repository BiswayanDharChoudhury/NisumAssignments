import java.util.Scanner;
import java.util.Stack;

public class BrowserHistory {

    private static final Stack<String> history = new Stack<>();
    private static String currentPage = "Home";

    // Visiting a new website
    public static void visitPage(String url) {
        history.push(currentPage);
        currentPage = url;
        System.out.println("Visited: " + currentPage);
    }

    // Going back to the previous site
    public static void goBack() {
        if (!history.isEmpty()) {
            currentPage = history.pop();
            System.out.println("Went back to: " + currentPage);
        } else {
            System.out.println("No previous pages in history.");
        }
    }

    // Viewing the current page
    public static void showCurrentPage() {
        System.out.println("Current Page: " + currentPage);
    }

    // Viewing entire history
    public static void showHistory() {
        if (history.isEmpty()) {
            System.out.println("No browsing history available.");
        } else {
            System.out.println("Browsing History:");
            for (int i = history.size() - 1; i >= 0; i--) {
                System.out.println(history.get(i));
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nBrowser History Menu");
            System.out.println("1. Visit New Page");
            System.out.println("2. Go Back");
            System.out.println("3. Show Current Page");
            System.out.println("4. Show History");
            System.out.println("5. Exit");
            System.out.print("Choose an option (1-5): ");
            choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter URL to visit: ");
                    String url = scanner.nextLine();
                    visitPage(url);
                    break;
                case 2:
                    goBack();
                    break;
                case 3:
                    showCurrentPage();
                    break;
                case 4:
                    showHistory();
                    break;
                case 5:
                    System.out.println("Exiting browser history.");
                    break;
                default:
                    System.out.println("Invalid option. Please choose between 1 and 5.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
