package ra.edu.ex05.repository;

import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {
    public String getOrder(Long id) {
        return "Hien thi don hang so: " + id;
    }

    public String createOrder() {
        return "Da tao 1 don hang moi thanh cong!";
    }

    public String deleteOrder(Long id) {
        return "Da huy don hang so: " + id;
    }
}
