package ra.edu.ex05.repository;

import org.springframework.stereotype.Repository;
import ra.edu.ex05.model.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class OrderRepository {
    private final List<Order> orders = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    public OrderRepository() {
        Order order1 = new Order(1L, "Nguyễn Văn A", "0901234567");
        order1.setStatus("COMPLETED");
        orders.add(order1);

        Order order2 = new Order(2L, "Trần Thị B", "0912345678");
        order2.setStatus("PENDING");
        orders.add(order2);
    }

    public List<Order> findAll() {
        return new ArrayList<>(orders);
    }

    public Optional<Order> findById(Long id) {
        return orders.stream()
                .filter(order -> order.getId().equals(id))
                .findFirst();
    }

    public Order save(Order order) {
        if (order.getId() == null) {
            order.setId(idCounter.getAndIncrement());
            orders.add(order);
        } else {
            orders.stream()
                    .filter(o -> o.getId().equals(order.getId()))
                    .findFirst()
                    .ifPresent(existing -> {
                        existing.setCustomerName(order.getCustomerName());
                        existing.setCustomerPhone(order.getCustomerPhone());
                        existing.setItems(order.getItems());
                        existing.setTotalPrice(order.getTotalPrice());
                        existing.setTaxAmount(order.getTaxAmount());
                        existing.setFinalPrice(order.getFinalPrice());
                        existing.setStatus(order.getStatus());
                    });
        }
        return order;
    }

    public boolean deleteById(Long id) {
        return orders.removeIf(order -> order.getId().equals(id));
    }

    public long count() {
        return orders.size();
    }
}