package ra.edu.ex01.controller;

import ra.edu.ex01.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("legacyControllerBai1")
public class LegacyController {

    private OrderService orderService;

    @Autowired
    public LegacyController(OrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping("/bai1/orders")
    @ResponseBody
    public String getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/bai1/orders/{id}")
    @ResponseBody
    public String getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @org.springframework.web.bind.annotation.PostMapping("/bai1/orders")
    @ResponseBody
    public String createOrder() {
        return orderService.createOrder();
    }
}