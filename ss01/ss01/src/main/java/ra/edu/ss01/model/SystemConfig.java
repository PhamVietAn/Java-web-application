package ra.edu.ss01.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SystemConfig {

    @Value("WIfi router")
    private String branchName;

    @Value("08:00 - 22:00")
    private String openingHour;

    public String getBranchName() {
        return branchName;
    }

    public String getOpeningHour() {
        return openingHour;
    }
}