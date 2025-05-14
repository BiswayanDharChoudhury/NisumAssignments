import java.util.HashMap;
import java.util.Scanner;

public class q4 {

    private static final HashMap<String, Integer> inventory = new HashMap<>();

    // Adds a new product to the inventory
    public static void addProduct(String name, int quantity) {
        if (inventory.containsKey(name)) {
            System.out.println("Product already exists. Use update option instead.");
        } else {
            inventory.put(name, quantity);
            System.out.println("Product added successfully.");
        }
    }

    // Updates the quantity of an existing product
    public static void updateProduct(String name, int quantity) {
        if (inventory.containsKey(name)) {
            inventory.put(name, quantity);
            System.out.println("Product quantity updated.");
        } else {
            System.out.println("Product not found in inventory.");
        }
    }

    // Removes a product from the inventory
    public static void removeProduct(String name) {
        if (inventory.containsKey(name)) {
            inventory.remove(name);
            System.out.println("Product removed.");
        } else {
            System.out.println("Product not found.");
        }
    }

    // Checks if a product is in stock
    public static void checkStock(String name) {
        if (inventory.containsKey(name)) {
            int quantity = inventory.get(name);
            System.out.println("Product: " + name + " | Quantity in stock: " + quantity);
        } else {
            System.out.println("Product not available in inventory.");
        }
    }

    // Displays the complete product list
    public static void displayInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            System.out.println("Current Inventory:");
            for (String product : inventory.keySet()) {
                System.out.println("Product: " + product + " | Quantity: " + inventory.get(product));
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nProduct Inventory Menu");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product Quantity");
            System.out.println("3. Remove Product");
            System.out.println("4. Check Product Stock");
            System.out.println("5. Display All Products");
            System.out.println("6. Exit");
            System.out.print("Choose an option (1-6): ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter product name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int newQty = scanner.nextInt();
                    addProduct(newName, newQty);
                    break;

                case 2:
                    System.out.print("Enter product name to update: ");
                    String updateName = scanner.nextLine();
                    System.out.print("Enter new quantity: ");
                    int updateQty = scanner.nextInt();
                    updateProduct(updateName, updateQty);
                    break;

                case 3:
                    System.out.print("Enter product name to remove: ");
                    String removeName = scanner.nextLine();
                    removeProduct(removeName);
                    break;

                case 4:
                    System.out.print("Enter product name to check: ");
                    String checkName = scanner.nextLine();
                    checkStock(checkName);
                    break;

                case 5:
                    displayInventory();
                    break;

                case 6:
                    System.out.println("Exiting inventory system.");
                    break;

                default:
                    System.out.println("Invalid choice. Please select between 1 and 6.");
            }
        } while (choice != 6);

        scanner.close();
    }
}
