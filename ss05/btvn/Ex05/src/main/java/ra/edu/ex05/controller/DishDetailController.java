package ra.edu.ex05.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ra.edu.ex05.model.Dish;
import ra.edu.ex05.model.Order;
import ra.edu.ex05.model.OrderItem;
import ra.edu.ex05.service.AdminDishService;
import ra.edu.ex05.service.OrderService;

import java.util.ArrayList;
import java.util.List;

/**
 * DishDetailController - Handles quick order operations
 * Architecture: Controller -> Service -> Repository (3-tier design)
 *
 * Features:
 * - Natural Templating: Templates contain mock data for designer preview
 * - Dumb View: All business logic (price calculations) stays in Service layer
 * - Exception Handling: Prevents unauthorized /WEB-INF/ access
 */
@Controller
@RequestMapping("/bai5")
public class DishDetailController {

    @Autowired
    private AdminDishService adminDishService;

    @Autowired
    private OrderService orderService;

    /**
     * GET /bai5/quick-order - Display quick order form with available dishes
     * Security: ViewResolver prevents direct access to /WEB-INF/views/quick-order.html
     *           - InternalResourceViewResolver uses RequestDispatcher.forward()
     *           - Direct HTTP requests to /WEB-INF/ are blocked by servlet container
     */
    @GetMapping("/quick-order")
    public String showQuickOrder(Model model) {
        try {
            List<Dish> availableDishes = adminDishService.getAllDishes();
            model.addAttribute("dishes", availableDishes);

            // Add service methods to model for template formatting
            model.addAttribute("orderService", orderService);

            return "quick-order";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMessage", "Có lỗi xảy ra khi tải danh sách món ăn: " + e.getMessage());
            return "quick-order";
        }
    }

    /**
     * POST /bai5/quick-order - Process order submission
     * Accepts array parameters: dishIds[] and quantities[]
     * All price calculations are performed server-side by OrderService
     */
    @PostMapping("/quick-order")
    public String submitOrder(
            @RequestParam(value = "customerName", required = false) String customerName,
            @RequestParam(value = "customerPhone", required = false) String customerPhone,
            @RequestParam(value = "dishIds", required = false) List<Long> dishIds,
            @RequestParam(value = "quantities", required = false) List<Integer> quantities,
            RedirectAttributes redirectAttributes,
            Model model) {

        try {
            // Validation: Customer name
            if (customerName == null || customerName.trim().isEmpty()) {
                model.addAttribute("errorMessage", "Vui lòng nhập tên khách hàng");
                return showQuickOrder(model);
            }

            // Validation: Customer phone
            if (customerPhone == null || customerPhone.trim().isEmpty()) {
                model.addAttribute("errorMessage", "Vui lòng nhập số điện thoại");
                return showQuickOrder(model);
            }

            // Validation: At least one dish selected
            if (dishIds == null || dishIds.isEmpty()) {
                model.addAttribute("errorMessage", "Vui lòng chọn ít nhất một món ăn");
                return showQuickOrder(model);
            }

            // Build order items from request parameters
            List<OrderItem> orderItems = new ArrayList<>();
            for (int i = 0; i < dishIds.size(); i++) {
                Long dishId = dishIds.get(i);
                Integer quantity = (quantities != null && i < quantities.size()) ? quantities.get(i) : 1;

                // Validation: Quantity must be positive
                if (quantity <= 0) {
                    model.addAttribute("errorMessage", "Số lượng phải lớn hơn 0");
                    return showQuickOrder(model);
                }

                // Fetch dish from repository
                var dishOpt = adminDishService.findById(dishId);
                if (dishOpt.isEmpty()) {
                    model.addAttribute("errorMessage", "Không tìm thấy món ăn ID: " + dishId);
                    return showQuickOrder(model);
                }

                Dish dish = dishOpt.get();

                // Validation: Dish must be available
                if (!dish.isAvailable()) {
                    model.addAttribute("errorMessage", "Món ăn '" + dish.getName() + "' không còn phục vụ");
                    return showQuickOrder(model);
                }

                // Create OrderItem - NO price calculation here, just data holding
                OrderItem item = new OrderItem(dishId, dish.getName(), dish.getPrice(), quantity);
                orderItems.add(item);
            }

            // Delegate to Service for order creation and price calculation
            // Service will calculate: totalPrice, taxAmount, finalPrice
            Order order = orderService.createOrder(customerName, customerPhone, orderItems);

            // Pass success message with formatted price to confirmation page
            redirectAttributes.addFlashAttribute(
                    "successMessage",
                    "Đặt hàng thành công! Mã đơn: #" + order.getId() +
                            " | Tổng tiền: " + orderService.formatPrice(order.getFinalPrice())
            );

            return "redirect:/bai5/order-confirmation/" + order.getId();

        } catch (IllegalArgumentException e) {
            // Service layer validation error
            model.addAttribute("errorMessage", e.getMessage());
            return showQuickOrder(model);
        } catch (Exception e) {
            // Unexpected error
            e.printStackTrace();
            model.addAttribute("errorMessage", "Có lỗi xảy ra khi xử lý đơn hàng: " + e.getMessage());
            return showQuickOrder(model);
        }
    }

    /**
     * GET /bai5/order-confirmation/{orderId} - Display order confirmation page
     * Shows the order with all server-calculated prices
     */
    @GetMapping("/order-confirmation/{orderId}")
    public String showOrderConfirmation(
            @PathVariable Long orderId,
            Model model,
            RedirectAttributes redirectAttributes) {

        try {
            var orderOpt = orderService.getOrderById(orderId);
            if (orderOpt.isEmpty()) {
                redirectAttributes.addFlashAttribute("errorMessage", "Không tìm thấy đơn hàng!");
                return "redirect:/bai5/quick-order";
            }

            Order order = orderOpt.get();
            model.addAttribute("order", order);
            model.addAttribute("orderService", orderService); // For template formatting methods

            return "order-confirmation";
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("errorMessage", "Có lỗi xảy ra: " + e.getMessage());
            return "redirect:/bai5/quick-order";
        }
    }

    /**
     * GET /bai5/order/{orderId} - View order details page
     */
    @GetMapping("/order/{orderId}")
    public String viewOrder(
            @PathVariable Long orderId,
            Model model,
            RedirectAttributes redirectAttributes) {

        try {
            var orderOpt = orderService.getOrderById(orderId);
            if (orderOpt.isEmpty()) {
                redirectAttributes.addFlashAttribute("errorMessage", "Không tìm thấy đơn hàng!");
                return "redirect:/bai5/quick-order";
            }

            Order order = orderOpt.get();
            model.addAttribute("order", order);
            model.addAttribute("orderService", orderService); // For template formatting methods

            return "order-detail";
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("errorMessage", "Có lỗi xảy ra: " + e.getMessage());
            return "redirect:/bai5/quick-order";
        }
    }

    /**
     * POST /bai5/order/{orderId}/cancel - Cancel an order
     */
    @PostMapping("/order/{orderId}/cancel")
    public String cancelOrder(
            @PathVariable Long orderId,
            RedirectAttributes redirectAttributes) {

        try {
            boolean cancelled = orderService.cancelOrder(orderId);
            if (cancelled) {
                redirectAttributes.addFlashAttribute("successMessage", "Đơn hàng đã được hủy!");
            } else {
                redirectAttributes.addFlashAttribute("errorMessage", "Không thể hủy đơn hàng này!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("errorMessage", "Có lỗi xảy ra: " + e.getMessage());
        }

        return "redirect:/bai5/quick-order";
    }

    /**
     * Exception handler for security exceptions
     * Explains: The ViewResolver mechanism prevents direct /WEB-INF/ access
     */
    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex, Model model) {
        model.addAttribute("errorMessage", "Có lỗi xảy ra: " + ex.getMessage());
        return "redirect:/bai5/quick-order";
    }
}