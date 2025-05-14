import java.util.*;

// Class to represent a menu item with name, description, and price
class MenuItem {
    String itemName;
    String itemDescription;
    double itemPrice;

    public MenuItem(String itemName, String itemDescription, double itemPrice) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemPrice = itemPrice;
    }

    @Override
    public String toString() {
        return itemName + " - " + itemDescription + " ($" + itemPrice + ")";
    }
}

public class RestaurantMenu {

    // LinkedHashMap to maintain category insertion order
    private static final LinkedHashMap<String, HashMap<String, MenuItem>> menuCatalog = new LinkedHashMap<>();

    // Adds a new item under a specific category
    public static void addMenuItem(String category, String name, String description, double price) {
        menuCatalog.putIfAbsent(category, new HashMap<>());
        menuCatalog.get(category).put(name, new MenuItem(name, description, price));
        System.out.println("Item added successfully to the " + category + " category.");
    }

    // Removes an item from a category
    public static void removeMenuItem(String category, String name) {
        if (menuCatalog.containsKey(category) && menuCatalog.get(category).containsKey(name)) {
            menuCatalog.get(category).remove(name);
            System.out.println("Item '" + name + "' removed from the " + category + " category.");
        } else {
            System.out.println("Item not found in the specified category.");
        }
    }

    // Updates an existing item's details
    public static void updateMenuItem(String category, String name, String newDesc, double newPrice) {
        if (menuCatalog.containsKey(category) && menuCatalog.get(category).containsKey(name)) {
            menuCatalog.get(category).put(name, new MenuItem(name, newDesc, newPrice));
            System.out.println("Item '" + name + "' updated successfully in the " + category + " category.");
        } else {
            System.out.println("Item not found in the specified category.");
        }
    }

    // Displays the full menu categorized
    public static void showFullMenu() {
        if (menuCatalog.isEmpty()) {
            System.out.println("The menu is currently empty.");
            return;
        }
        System.out.println("\nRestaurant Menu:");
        for (Map.Entry<String, HashMap<String, MenuItem>> entry : menuCatalog.entrySet()) {
            String category = entry.getKey();
            System.out.println("\n" + category + ":");
            for (MenuItem item : entry.getValue().values()) {
                System.out.println("  " + item);
            }
        }
    }

    // Show items from a specific category
    public static void showCategory(String category) {
        if (menuCatalog.containsKey(category)) {
            System.out.println("\n" + category + " Menu:");
            for (MenuItem item : menuCatalog.get(category).values()) {
                System.out.println("  " + item);
            }
        } else {
            System.out.println("Category '" + category + "' does not exist.");
        }
    }

    // List all categories
    public static void listAllCategories() {
        if (menuCatalog.isEmpty()) {
            System.out.println("No categories are available in the menu.");
        } else {
            System.out.println("\nAvailable Categories:");
            for (String category : menuCatalog.keySet()) {
                System.out.println(" - " + category);
            }
        }
    }

    // Check if a menu item exists
    public static void findItem(String category, String name) {
        if (menuCatalog.containsKey(category) && menuCatalog.get(category).containsKey(name)) {
            System.out.println("Found item: " + menuCatalog.get(category).get(name));
        } else {
            System.out.println("Item not found in the " + category + " category.");
        }
    }

    // Clear a whole category
    public static void clearCategory(String category) {
        if (menuCatalog.containsKey(category)) {
            menuCatalog.remove(category);
            System.out.println("All items in the '" + category + "' category have been cleared.");
        } else {
            System.out.println("No such category found to clear.");
        }
    }

    // Clear the entire menu
    public static void clearFullMenu() {
        menuCatalog.clear();
        System.out.println("The entire menu has been cleared.");
    }

    // Main method to interact with the menu system
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n--- Menu Management ---");
            System.out.println("1. Add Menu Item");
            System.out.println("2. Remove Menu Item");
            System.out.println("3. Update Menu Item");
            System.out.println("4. Show Full Menu");
            System.out.println("5. Show Menu by Category");
            System.out.println("6. List All Categories");
            System.out.println("7. Find Item by Name");
            System.out.println("8. Clear Category");
            System.out.println("9. Clear Full Menu");
            System.out.println("10. Exit");
            System.out.print("Choose an option (1-10): ");
            option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter category (e.g., Appetizer, Main Course, Dessert): ");
                    String category = scanner.nextLine();
                    System.out.print("Enter item name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter item description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter item price: ");
                    double price = scanner.nextDouble();
                    addMenuItem(category, name, description, price);
                    break;

                case 2:
                    System.out.print("Enter category: ");
                    String removeCategory = scanner.nextLine();
                    System.out.print("Enter item name to remove: ");
                    String removeName = scanner.nextLine();
                    removeMenuItem(removeCategory, removeName);
                    break;

                case 3:
                    System.out.print("Enter category: ");
                    String updateCategory = scanner.nextLine();
                    System.out.print("Enter item name to update: ");
                    String updateName = scanner.nextLine();
                    System.out.print("Enter new description: ");
                    String newDescription = scanner.nextLine();
                    System.out.print("Enter new price: ");
                    double newPrice = scanner.nextDouble();
                    updateMenuItem(updateCategory, updateName, newDescription, newPrice);
                    break;

                case 4:
                    showFullMenu();
                    break;

                case 5:
                    System.out.print("Enter category to display: ");
                    String categoryToShow = scanner.nextLine();
                    showCategory(categoryToShow);
                    break;

                case 6:
                    listAllCategories();
                    break;

                case 7:
                    System.out.print("Enter category: ");
                    String findCategory = scanner.nextLine();
                    System.out.print("Enter item name to find: ");
                    String findName = scanner.nextLine();
                    findItem(findCategory, findName);
                    break;

                case 8:
                    System.out.print("Enter category to clear: ");
                    String clearCategory = scanner.nextLine();
                    clearCategory(clearCategory);
                    break;

                case 9:
                    clearFullMenu();
                    break;

                case 10:
                    System.out.println("Exiting the menu system. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Please choose a number between 1 and 10.");
            }
        } while (option != 10);

        scanner.close();
    }
}
