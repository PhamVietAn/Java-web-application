package ra.edu.ss01.btvn.ex03.repository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class InventoryRepositoryImpl implements InventoryRepository {

    private final Map<String, Integer> inventory = new HashMap<>();

    public InventoryRepositoryImpl() {
        inventory.put("Mì xào bò", 0);     // hết hàng để test
        inventory.put("Mì tôm", 10);
        inventory.put("Coca", 5);
        inventory.put("Bánh mì", 3);
    }

    @Override
    public int getStock(String foodName) {
        return inventory.getOrDefault(foodName, 0);
    }

    @Override
    public void decreaseStock(String foodName, int quantity) {
        int currentStock = inventory.getOrDefault(foodName, 0);
        inventory.put(foodName, currentStock - quantity);
    }
}