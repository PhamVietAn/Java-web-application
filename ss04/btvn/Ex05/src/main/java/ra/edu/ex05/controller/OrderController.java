package ra.edu.ex05.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ra.edu.ex05.service.OrderService;

@RestController
@RequestMapping("/bai5/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{id}")
    public String viewOrder(@PathVariable("id") String idStr) {
        try {
            Long id = Long.parseLong(idStr);
            return orderService.getOrder(id);
        } catch (NumberFormatException e) {
            return "LOI: ID don hang phai la mot so hop le! Ban dang nhap chu '" + idStr + "' roi.";
        }
    }

    @PostMapping
    public String createOrder() {
        return orderService.createOrder();
    }

    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable("id") Long id) {
        return orderService.deleteOrder(id);
    }
}