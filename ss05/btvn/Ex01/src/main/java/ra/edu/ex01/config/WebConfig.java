package ra.edu.ex01.config;

import org.springframework.context.annotation.Bean;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;

public class WebConfig {
//    @Bean
//    public SpringResourceTemplateResolver templateResolver() {
//        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
//        resolver.setPrefix("/WEB-INF/views"); Sai thư mục prefix vì đât là thư mục dùng cho JSP, đúng là: /WEB-INF/templates/
//        resolver.setSuffix(".jsp"); Sai suffix vì đât là định dạng file JSP, đúng là: .html
//        resolver.setCharacterEncoding("UTF-8");
//        return resolver;
//    }

    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();

        resolver.setPrefix("/WEB-INF/templates/"); // đúng thư mục
        resolver.setSuffix(".html");               // đúng định dạng file
        resolver.setCharacterEncoding("UTF-8");
        resolver.setTemplateMode("HTML");          // thêm để đảm bảo render đúng

        return resolver;
    }
}
