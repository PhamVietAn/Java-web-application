package ra.edu.ss02.Ex03.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ra.edu.ss02.Ex03.model.Order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Controller
public class OrderController {

    @GetMapping("/orders")
    public String showOrders(HttpSession session,
                             Model model,
                             ServletContext application) {

        String loggedUser = (String) session.getAttribute("loggedUser");
        if (loggedUser == null) {
            return "redirect:/login";
        }

        List<Order> orders = new ArrayList<>();
        orders.add(new Order("DH001", "Bàn phím cơ", 1250000, new Date()));
        orders.add(new Order("DH002", "Chuột không dây", 650000, new Date()));
        orders.add(new Order("DH003", "Tai nghe gaming", 1890000, new Date()));
        orders.add(new Order("DH004", "Màn hình 24 inch", 3250000, new Date()));

        model.addAttribute("orderList", orders);

        AtomicInteger counter = (AtomicInteger) application.getAttribute("totalViewCount");
        if (counter == null) {
            synchronized (application) {
                counter = (AtomicInteger) application.getAttribute("totalViewCount");
                if (counter == null) {
                    counter = new AtomicInteger(0);
                    application.setAttribute("totalViewCount", counter);
                }
            }
        }

        counter.incrementAndGet();

        return "orders";
    }
}