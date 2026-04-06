package ra.edu.ss01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ra.edu.ss01.config.AppConfig;
import ra.edu.ss01.model.SystemConfig;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        SystemConfig config = context.getBean(SystemConfig.class);

        System.out.println("===== THÔNG TIN HỆ THỐNG =====");
        System.out.println("Chi nhánh: " + config.getBranchName());
        System.out.println("Giờ mở cửa: " + config.getOpeningHour());
    }
}
