public class Book extends Product {

    private String author;
    private String publisher;

    public Book(int id, String name, double price, String author, String publisher) {
        super(id, name, price);
        this.author = author;
        this.publisher = publisher;
    }

    public String getAuthor() { return author; }
    public String getPublisher() { return publisher; }

    @Override
    public double calculateTax() {
        return getPrice() * 0.05; // 5% tax
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Author: " + author);
        System.out.println("Publisher: " + publisher);
        System.out.printf("Tax: $%.2f%n", calculateTax());
    }
}