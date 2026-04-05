package ra.edu.ss01.btvn.ex03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ra.edu.ss01.btvn.ex03.config.AppConfig;
import ra.edu.ss01.btvn.ex03.service.OrderFoodService;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        OrderFoodService orderFoodService = context.getBean(OrderFoodService.class);

        System.out.println("=== Test 1: Món hết hàng ===");
        System.out.println(orderFoodService.orderFood("an", "Mì xào bò", 1, 25000));

        System.out.println("\n=== Test 2: Tài khoản âm ===");
        System.out.println(orderFoodService.orderFood("cuong", "Mì tôm", 1, 15000));

        System.out.println("\n=== Test 3: Không đủ tiền ===");
        System.out.println(orderFoodService.orderFood("binh", "Mì tôm", 1, 15000));

        System.out.println("\n=== Test 4: Thành công ===");
        System.out.println(orderFoodService.orderFood("an", "Mì tôm", 2, 15000));

        System.out.println("\n=== Test 5: Input sai ===");
        System.out.println(orderFoodService.orderFood("", "Coca", 1, 10000));
    }
}