public class Electronics extends Product {

    private String brand;
    private int warrantyMonths;

    public Electronics(int id, String name, double price, String brand, int warrantyMonths) {
        super(id, name, price);
        this.brand = brand;
        this.warrantyMonths = warrantyMonths;
    }

    public String getBrand() { return brand; }
    public int getWarrantyMonths() { return warrantyMonths; }

    @Override
    public double calculateTax() {
        return getPrice() * 0.15; // 15% tax
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Brand: " + brand);
        System.out.println("Warranty: " + warrantyMonths + " months");
        System.out.printf("Tax: $%.2f%n", calculateTax());
    }
}