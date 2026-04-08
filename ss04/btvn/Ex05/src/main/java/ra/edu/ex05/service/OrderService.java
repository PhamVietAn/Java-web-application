package ra.edu.ex05.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.edu.ex05.repository.OrderRepository;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public String getOrder(Long id) {
        return orderRepository.getOrder(id);
    }

    public String createOrder() {
        return orderRepository.createOrder();
    }

    public String deleteOrder(Long id) {
        return orderRepository.deleteOrder(id);
    }
}
