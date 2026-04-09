package ra.edu.demo1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.edu.demo1.model.Product;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = {"/hello","/"})
public class HelloController {
    @GetMapping
    public String hello(Model model) {
        model.addAttribute("name", "Pham Viet An");
        return "home";
    }

    @GetMapping("/product-list")
    public String productList(Model model) throws ParseException {
        List<Product> products = new ArrayList<Product>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        products.add(new Product(1, "Iphone 14 Pro Max", "APPLE",2024, sdf.parse("01/01/2024"), 25000000.0));
        products.add(new Product(2, "Samsung S26 Ultra", "SAMSUNG",2026, sdf.parse("01/02/2026"), 40000000.0));
        products.add(new Product(3, "Oppo Reno 6", "OPPO",2025, sdf.parse("07/10/2025"), 25000000.0));
        products.add(new Product(4, "Samsung S26 Ultra", "SAMSUNG",2024, sdf.parse("01/02/2026"), 40000000.0));
        products.add(new Product(5, "Iphone 14 Pro Max", "APPLE ",2024, sdf.parse("01/01/2024"), 25000000.0));
        products.add(new Product(6, "Samsung S26 Ultra", "SAMSUNG",2024, sdf.parse("01/02/2026"), 40000000.0));
    }

}
