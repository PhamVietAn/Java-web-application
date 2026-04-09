package ra.edu.ex05.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ra.edu.ex05.model.Dish;
import ra.edu.ex05.service.AdminDishService;

@Controller
public class AdminDishController {

    @Autowired
    private AdminDishService adminDishService;

    @GetMapping("/bai5/dishes")
    public String showDishes(Model model) {
        model.addAttribute("dishes", adminDishService.getAllDishes());
        return "dish-list";
    }

    @GetMapping("/bai5/dishes/{id}")
    public String showDishDetail(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        return adminDishService.findById(id)
                .map(dish -> {
                    model.addAttribute("dish", dish);
                    return "dish-detail";
                })
                .orElseGet(() -> {
                    redirectAttributes.addFlashAttribute("errorMessage", "Không tìm thấy món ăn yêu cầu!");
                    return "redirect:/bai5/dishes";
                });
    }

    @GetMapping("/bai5/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        return adminDishService.findById(id)
                .map(dish -> {
                    model.addAttribute("dish", dish);
                    return "edit-dish";
                })
                .orElseGet(() -> {
                    redirectAttributes.addFlashAttribute("errorMessage", "Không tìm thấy món ăn yêu cầu!");
                    return "redirect:/bai5/dishes";
                });
    }

    @PostMapping("/bai5/edit/{id}")
    public String updateDish(@PathVariable Long id,
                             @ModelAttribute("dish") Dish dish,
                             RedirectAttributes redirectAttributes) {
        boolean updated = adminDishService.updateDish(id, dish);
        if (!updated) {
            redirectAttributes.addFlashAttribute("errorMessage", "Không tìm thấy món ăn yêu cầu!");
            return "redirect:/bai5/dishes";
        }

        redirectAttributes.addFlashAttribute("successMessage", "Cập nhật món ăn thành công!");
        return "redirect:/bai5/dishes";
    }
}