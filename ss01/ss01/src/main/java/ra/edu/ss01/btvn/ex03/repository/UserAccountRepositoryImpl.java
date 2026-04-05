package ra.edu.ss01.btvn.ex03.repository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserAccountRepositoryImpl implements UserAccountRepository {

    private final Map<String, Double> accounts = new HashMap<>();

    public UserAccountRepositoryImpl() {
        accounts.put("an", 50000.0);
        accounts.put("binh", 10000.0);
        accounts.put("cuong", -5000.0);   // tài khoản âm để test
    }

    @Override
    public double getBalance(String username) {
        return accounts.getOrDefault(username, -1.0);
    }

    @Override
    public void deductBalance(String username, double amount) {
        double currentBalance = accounts.get(username);
        accounts.put(username, currentBalance - amount);
    }
}