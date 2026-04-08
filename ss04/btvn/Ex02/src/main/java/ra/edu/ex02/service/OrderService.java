package ra.edu.ex02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.edu.ex02.repository.OrderRepository;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public String getAllOrders() {
        return orderRepository.getAllOrders();
    }

    public String getOrderById(Long id) {
        return orderRepository.getOrderById(id);
    }

    public String createOrder() {
        return orderRepository.createOrder();
    }
}
