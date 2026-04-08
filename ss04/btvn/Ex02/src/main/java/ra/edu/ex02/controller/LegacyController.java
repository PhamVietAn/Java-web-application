package ra.edu.ex02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ra.edu.ex02.service.OrderService;

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

    @GetMapping("/bai2/menu")
    @ResponseBody
    public String getMenu(@RequestParam(value = "category", required = false, defaultValue = "chay") String category) {
        return "Category: " + category;
    }
}