package ra.edu.ss01.btvn.ex03.service;

public interface OrderFoodService {
    String orderFood(String username, String foodName, int quantity, double pricePerUnit);
}