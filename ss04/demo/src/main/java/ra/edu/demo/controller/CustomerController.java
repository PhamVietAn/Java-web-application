package ra.edu.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ra.edu.demo.model.Customer;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = {"/customer-list","/"})
public class CustomerController {
    List<Customer> customers = new ArrayList<>();

    public CustomerController() {
        customers.add(new Customer(1,"Phạm Việt An", "anpham@gmail.com","0123456789"));
        customers.add(new Customer(2,"Nguyễn Đăng Dương", "duongnguyen@gmail.com","0112233445"));
        customers.add(new Customer(3,"Phùng Quang Tiến", "tienphung@gmail.com","0912342345"));
        customers.add(new Customer(4,"Nguyễn Đình Sơn", "sonnguyen@gmail.com","0866123456"));
    }

    @GetMapping
    public String getCustomerList(Model model) {
        model.addAttribute("customerList", customers);
        return "customer-list";
    }

    @GetMapping("/detail")
    public String detail (@RequestParam("id") int id, Model model) throws ParseException {
        Customer customer = new Customer();
        for( Customer c : customers ) {
            if (c.getId() == id) {
                customer = c;
                break;
            }
        }
        model.addAttribute("customer", customer);
        return "customer-detail";
    }
}
