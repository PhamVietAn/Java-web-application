package ra.edu.ex05.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private Long id;
    private String customerName;
    private String customerPhone;
    private List<OrderItem> items;
    private double totalPrice;
    private double taxAmount;
    private double finalPrice;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Order() {
        this.items = new ArrayList<>();
        this.status = "PENDING";
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public Order(Long id, String customerName, String customerPhone) {
        this();
        this.id = id;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
    }

    public Long getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public List<OrderItem> getItems() {
        return new ArrayList<>(items);
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public double getTaxAmount() {
        return taxAmount;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items != null ? new ArrayList<>(items) : new ArrayList<>();
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setTaxAmount(double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public void setStatus(String status) {
        this.status = status;
        this.updatedAt = LocalDateTime.now();
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void addItem(OrderItem item) {
        if (item != null) {
            this.items.add(item);
        }
    }

    public void removeItem(OrderItem item) {
        if (item != null) {
            this.items.remove(item);
        }
    }

    public int getItemCount() {
        return items.size();
    }
}