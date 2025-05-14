import java.util.*;

class Product {
    String name;
    String category;
    double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String toString() {
        return name + " - " + category + " - $" + price;
    }
}

public class q14 {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", "Electronics", 1200.00));
        products.add(new Product("Headphones", "Electronics", 150.00));
        products.add(new Product("Apple", "Fruits", 1.20));
        products.add(new Product("Banana", "Fruits", 0.80));
        products.add(new Product("Chair", "Furniture", 85.00));

        products.sort(Comparator
            .comparing((Product p) -> p.category)
            .thenComparing(p -> p.price));

        for (Product p : products) {
            System.out.println(p);
        }
    }
}
