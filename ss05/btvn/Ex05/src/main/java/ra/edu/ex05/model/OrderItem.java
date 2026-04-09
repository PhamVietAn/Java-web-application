package ra.edu.ex05.model;

public class OrderItem {
    private Long id;
    private Long dishId;
    private String dishName;
    private double unitPrice;
    private int quantity;
    private double subtotal;

    public OrderItem() {
    }

    public OrderItem(Long dishId, String dishName, double unitPrice, int quantity) {
        this.dishId = dishId;
        this.dishName = dishName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.subtotal = unitPrice * quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDishId() {
        return dishId;
    }

    public void setDishId(Long dishId) {
        this.dishId = dishId;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
        recalculateSubtotal();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        recalculateSubtotal();
    }

    public double getSubtotal() {
        return subtotal;
    }

    private void recalculateSubtotal() {
        this.subtotal = unitPrice * quantity;
    }
}