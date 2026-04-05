package ra.edu.ss01.btvn.ex03.repository;

public interface UserAccountRepository {
    double getBalance(String username);
    void deductBalance(String username, double amount);
}
