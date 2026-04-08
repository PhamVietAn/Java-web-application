package ra.edu.ex01.config;

import org.jspecify.annotations.Nullable;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { AppConfig.class };
    }

    @Override
    protected Class<?> @Nullable [] getServletConfigClasses() {
        return new Class[] {AppConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}
