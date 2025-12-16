public class Clothing extends Product implements Discountable {

    private String size;
    private String material;

    public Clothing(int id, String name, double price, String size, String material) {
        super(id, name, price);
        this.size = size;
        this.material = material;
    }

    public String getSize() { return size; }
    public String getMaterial() { return material; }

    @Override
    public double calculateTax() {
        return getPrice() * 0.08; // 8% tax
    }

    // Implementing the method from the Discountable interface
    @Override
    public void applyDiscount(double percentage) {
        double discountAmount = getPrice() * (percentage / 100.0);
        double discountedPrice = getPrice() - discountAmount;

        // Use the setPrice method from the Product parent to update the price
        setPrice(discountedPrice);

        System.out.printf("\n*** Discount Applied ***%n");
        System.out.printf("Name: %s | Original: $%.2f | Discount: $%.2f | New Price: $%.2f%n",
                getName(), (discountedPrice + discountAmount), discountAmount, discountedPrice);
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Size: " + size);
        System.out.println("Material: " + material);
        System.out.printf("Tax: $%.2f%n", calculateTax());
    }
}