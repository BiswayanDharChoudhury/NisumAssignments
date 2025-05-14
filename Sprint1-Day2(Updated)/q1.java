package Sprint1Day2;

import java.util.*;

// Represents a product in the shopping cart
class Product {
    String name;
    double price;
    int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Calculate total cost for this product
    public double getTotalCost() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return name + " - ₹" + price + " × " + quantity + " = ₹" + getTotalCost();
    }
}

// Shopping cart system using ArrayList
public class q1 {
    private static final ArrayList<Product> cart = new ArrayList<>();

    // Add a new product to the cart
    public static void addProduct(String name, double price, int quantity) {
        cart.add(new Product(name, price, quantity));
        System.out.println(name + " added to your cart.");
    }

    // Remove a product from the cart by name
    public static void removeProduct(String name) {
        boolean removed = false;
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).name.equalsIgnoreCase(name)) {
                cart.remove(i);
                System.out.println(name + " removed from your cart.");
                removed = true;
                break;
            }
        }
        if (!removed) {
            System.out.println("Item not found in cart.");
        }
    }

    // Display all items in the cart
    public static void showCart() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is currently empty.");
        } else {
            System.out.println("\nItems in your cart:");
            for (Product item : cart) {
                System.out.println(item);
            }
        }
    }

    // Calculate and show the total price
    public static void showTotalAmount() {
        double total = 0;
        for (Product item : cart) {
            total += item.getTotalCost();
        }
        System.out.printf("Total amount to pay: ₹%.2f\n", total);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        System.out.println("Welcome to the Simple Shopping Cart!");

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Add Item");
            System.out.println("2. Remove Item");
            System.out.println("3. View Cart");
            System.out.println("4. Get Total Price");
            System.out.println("5. Exit");
            System.out.print("Choose an option (1-5): ");

            option = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (option) {
                case 1:
                    System.out.print("Enter item name: ");
                    String itemName = scanner.nextLine();

                    System.out.print("Enter item price: ");
                    double itemPrice = scanner.nextDouble();

                    System.out.print("Enter quantity: ");
                    int itemQty = scanner.nextInt();

                    addProduct(itemName, itemPrice, itemQty);
                    break;

                case 2:
                    System.out.print("Enter the name of the item to remove: ");
                    String itemToRemove = scanner.nextLine();
                    removeProduct(itemToRemove);
                    break;

                case 3:
                    showCart();
                    break;

                case 4:
                    showTotalAmount();
                    break;

                case 5:
                    System.out.println("Thank you for using the Shopping Cart. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Please choose between 1 and 5.");
            }

        } while (option != 5);

        scanner.close();
    }
}
