package ra.edu.ex03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ra.edu.ex03.service.OrderService;

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
    public String getOrderById(@PathVariable("id") Long id) {
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

    @GetMapping("/bai3/orders/{id}")
    @ResponseBody
    public String getOrderDetailsBai3(@PathVariable("id") Long id) {
        return "Chi tiet don hang so " + id;
    }
}

/*
Cách A (/bai3/orders/5):
 - Số 5 nằm trực tiếp trong URI Path (đường dẫn tài nguyên).
 - Đây được xem là một thành phần đại diện cho tên hoặc định danh của tài nguyên đó.

Cách B (/bai3/orders?id=5):
 - Số 5 nằm ở Query String (chuỗi truy vấn),được biểu diễn dưới dạng tham số key-value id=5 ở cuối URL để truyền thêm dữ liệu vào.
 - Lựa chọn phù hợp hơn: Theo tiêu chuẩn thiết kế RESTful API, để lấy một đối tượng cụ thể dựa trên ID (định danh duy nhất), Cách A kết hợp cùng @PathVariable là
   chuẩn xác và phù hợp nhất. Nguyên tắc là các định danh của tài nguyên nên nằm trong Path, còn Query String phù hợp hơn cho các thao tác lọc (filering),
   phân trang (paging), sắp xếp (sorting) hoặc các tham số không bắt buộc.
 - Quyết định: Em sẽ chọn Cách A để thực hiện.
*/