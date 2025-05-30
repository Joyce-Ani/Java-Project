package javafxapp;

public class ExportOrder {
    private String id;
    private String destination;
    private String productDescription;
    private int quantity;
    private double price;

    public ExportOrder(String id, String destination, String productDescription, int quantity, double price) {
        this.id = id;
        this.destination = destination;
        this.productDescription = productDescription;
        this.quantity = quantity;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void update(String destination, String productDescription, int quantity, double price) {
        this.destination = destination;
        this.productDescription = productDescription;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order ID: " + id + "\nDestination: " + destination + "\nProduct: " + productDescription +
                "\nQuantity: " + quantity + "\nPrice: FCFA" + price;
    }
}