package ra.edu.ex05.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.edu.ex05.model.Order;
import ra.edu.ex05.model.OrderItem;
import ra.edu.ex05.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private static final double TAX_RATE = 0.1;
    private static final double DELIVERY_FEE = 25000;

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public Order createOrder(String customerName, String customerPhone, List<OrderItem> items) {
        if (items == null || items.isEmpty()) {
            throw new IllegalArgumentException("Đơn hàng phải có ít nhất một mục");
        }

        Order order = new Order(null, customerName, customerPhone);
        order.setItems(items);
        calculateOrderPrices(order);
        return orderRepository.save(order);
    }

    public void calculateOrderPrices(Order order) {
        List<OrderItem> items = order.getItems();

        double totalPrice = items.stream()
                .mapToDouble(OrderItem::getSubtotal)
                .sum();

        order.setTotalPrice(totalPrice);

        double taxAmount = totalPrice * TAX_RATE;
        order.setTaxAmount(taxAmount);

        double finalPrice = totalPrice + taxAmount + DELIVERY_FEE;
        order.setFinalPrice(finalPrice);
    }

    public boolean updateOrderStatus(Long orderId, String newStatus) {
        Optional<Order> orderOpt = orderRepository.findById(orderId);
        if (orderOpt.isEmpty()) {
            return false;
        }

        Order order = orderOpt.get();
        order.setStatus(newStatus);
        orderRepository.save(order);
        return true;
    }

    public boolean cancelOrder(Long orderId) {
        return updateOrderStatus(orderId, "CANCELLED");
    }

    public boolean confirmOrder(Long orderId) {
        return updateOrderStatus(orderId, "CONFIRMED");
    }

    public boolean deleteOrder(Long orderId) {
        return orderRepository.deleteById(orderId);
    }

    public static class FormattedPrice {
        public double amount;
        public String displayText;

        public FormattedPrice(double amount) {
            this.amount = amount;
            this.displayText = String.format("%,.0f VNĐ", amount);
        }
    }

    public String formatPrice(double price) {
        return String.format("%,.0f VNĐ", price);
    }

    /**
     * Get formatted total price for display
     */
    public String getFormattedTotalPrice(Order order) {
        return formatPrice(order.getTotalPrice());
    }

    /**
     * Get formatted tax amount for display
     */
    public String getFormattedTaxAmount(Order order) {
        return formatPrice(order.getTaxAmount());
    }

    /**
     * Get formatted final price for display
     */
    public String getFormattedFinalPrice(Order order) {
        return formatPrice(order.getFinalPrice());
    }

    /**
     * Get formatted delivery fee (constant value)
     */
    public String getFormattedDeliveryFee() {
        return formatPrice(DELIVERY_FEE);
    }

    /**
     * Get tax rate percentage for display (e.g., "10%")
     */
    public String getTaxRatePercentage() {
        return String.format("%.0f%%", TAX_RATE * 100);
    }

    /**
     * Get raw delivery fee value
     */
    public double getDeliveryFee() {
        return DELIVERY_FEE;
    }

    /**
     * Get raw tax rate
     */
    public double getTaxRate() {
        return TAX_RATE;
    }
}