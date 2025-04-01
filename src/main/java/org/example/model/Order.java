package org.example.model;

public class Order {
    private int id;
    private String product;
    private int quantity;

    public Order(int id, String product, int quantity) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
    }

    // Getter and Setter
    public int getId() { return id; }
    public String getProduct() { return product; }
    public int getQuantity() { return quantity; }

    @Override
    public String toString() {
        return "Order{id=" + id + ", product='" + product + "', quantity=" + quantity + "}";
    }
} 