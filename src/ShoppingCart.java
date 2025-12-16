import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    // Uses the parent type Product - this is the key to Polymorphism
    private final List<Product> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Product product) {
        items.add(product);
        System.out.println("\n-> " + product.getName() + " added to the cart.");
    }

    public void viewCartItems() {
        if (items.isEmpty()) {
            System.out.println("\nYour cart is empty.");
            return;
        }
        System.out.println("\n--- Shopping Cart Contents ---");
        for (Product item : items) {
            System.out.printf("- %s (ID: %d) | Current Price: $%.2f | Type: %s%n",
                    item.getName(), item.getId(), item.getPrice(), item.getClass().getSimpleName());
        }
    }

    // Crucial Method: Calculates the grand total using Polymorphism
    public double calculateGrandTotal() {
        double subtotal = 0.0;
        double totalTax = 0.0;

        System.out.println("\n--- Final Order Summary ---");
        for (Product item : items) {
            subtotal += item.getPrice();

            // Polymorphism: Calling the abstract method from the Product parent
            // Java executes the correct calculateTax() based on the actual object (Book, Electronics, etc.)
            double itemTax = item.calculateTax();
            totalTax += itemTax;

            System.out.printf("-> %-20s Price: $%.2f | Tax: $%.2f%n",
                    item.getName(), item.getPrice(), itemTax);
        }

        double grandTotal = subtotal + totalTax;

        System.out.println("---------------------------------");
        System.out.printf("%-20s Subtotal: $%.2f%n", "Total", subtotal);
        System.out.printf("%-20s Total Tax: $%.2f%n", "Total", totalTax);
        System.out.printf("%-20s GRAND TOTAL: $%.2f%n", "FINAL", grandTotal);
        System.out.println("---------------------------------");

        return grandTotal;
    }
}