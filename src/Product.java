public abstract class Product {

    private int id;
    private String name;
    private double price; // The price can change due to discounts!

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    // SETTER ADDED for persistent discounts (required by the Discountable interface)
    public void setPrice(double price) { this.price = price; }

    public void displayDetails() {
        System.out.println("--- Product Details ---");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.printf("Price: $%.2f%n", price);
    }

    // Abstract method for Polymorphism
    public abstract double calculateTax();
}