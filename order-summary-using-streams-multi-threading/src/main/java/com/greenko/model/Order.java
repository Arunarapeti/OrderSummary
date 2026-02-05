package com.greenko.model;

public class Order {
    private String orderId, customerId, category, city;
    private double amount;
    private OrderStatus status;

    public Order(String orderId, String customerId, String category,
                 double amount, String city, OrderStatus status) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.category = category;
        this.amount = amount;
        this.city = city;
        this.status = status;
    }


    public String getOrderId() { return orderId; }
    public String getCustomerId() { return customerId; }
    public String getCategory() { return category; }
    public double getAmount() { return amount; }
    public String getCity() { return city; }
    public OrderStatus getStatus() { return status; }

    @Override
    public String toString() {
        return String.format("%s: %s, %.2f, %s, %s",
                orderId, category, amount, city, status);
    }
}
