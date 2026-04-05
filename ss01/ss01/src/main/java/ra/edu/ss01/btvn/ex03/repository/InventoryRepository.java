package ra.edu.ss01.btvn.ex03.repository;

public interface InventoryRepository {
    int getStock(String foodName);
    void decreaseStock(String foodName, int quantity);
}