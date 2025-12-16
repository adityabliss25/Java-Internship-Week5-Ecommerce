public class Main {
    public static void main(String[] args) {

        System.out.println("=== Week 5: E-commerce System Demo ===");

        // 1. Create instances of different Product types (Inheritance)
        Book javaBook = new Book(101, "Java OOP Mastery", 60.00, "J. Doe", "TechPress");
        Electronics monitor = new Electronics(205, "4K Monitor", 450.00, "LG", 12);
        Clothing shirt = new Clothing(310, "Cotton T-Shirt", 25.00, "L", "Cotton");

        // Display initial details and tax calculation
        System.out.println("\n--- Initial Product Details ---");
        javaBook.displayDetails();
        monitor.displayDetails();
        shirt.displayDetails();

        // 2. Interface Demonstration: Apply discount only to the Clothing item
        // The Book and Electronics objects do not have this method!
        shirt.applyDiscount(20.0); // Apply a 20% discount

        // 3. Shopping Cart Setup (Polymorphism)
        ShoppingCart cart = new ShoppingCart();

        // Add all products to the cart. The cart only sees them as generic 'Product' objects.
        cart.addItem(javaBook);
        cart.addItem(monitor);
        cart.addItem(shirt); // This item now has the discounted price

        // 4. View Items and Calculate Total
        cart.viewCartItems();

        // Polymorphism in action: The cart calls calculateTax() for ALL items,
        // but the correct tax rate (5%, 15%, or 8%) is executed for each item type.
        // Main.java - FIX: Capture and use the returned value
        double finalTotal = cart.calculateGrandTotal();
        System.out.printf("%nFinal Total Stored: $%.2f%n", finalTotal);
    }
}