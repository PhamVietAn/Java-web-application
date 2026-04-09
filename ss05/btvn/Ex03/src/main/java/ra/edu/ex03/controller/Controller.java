package ra.edu.ex03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ra.edu.ex03.model.Dish;
import ra.edu.ex03.service.AdminDishService;

@Controller
public class AdminDishController {

    @Autowired
    private AdminDishService dishService;

    // 👉 Mở trang edit
    @GetMapping("/bai3/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Dish dish = dishService.findById(id);

        // ❌ Bẫy dữ liệu
        if (dish == null) {
            model.addAttribute("error", "Không tìm thấy món ăn yêu cầu!");
            return "redirect:/bai2/dishes";
        }

        model.addAttribute("dish", dish);
        return "edit-dish";
    }
}
