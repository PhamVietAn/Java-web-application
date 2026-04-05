package ra.edu.ss01.btvn.ex03.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.edu.ss01.btvn.ex03.repository.InventoryRepository;
import ra.edu.ss01.btvn.ex03.repository.UserAccountRepository;

@Service
public class OrderFoodServiceImpl implements OrderFoodService {

    private final InventoryRepository inventoryRepository;
    private final UserAccountRepository userAccountRepository;

    @Autowired
    public OrderFoodServiceImpl(InventoryRepository inventoryRepository,
                                UserAccountRepository userAccountRepository) {
        this.inventoryRepository = inventoryRepository;
        this.userAccountRepository = userAccountRepository;
    }

    @Override
    public String orderFood(String username, String foodName, int quantity, double pricePerUnit) {
        if (username == null || username.isBlank()) {
            return "Thất bại: username không hợp lệ";
        }

        if (foodName == null || foodName.isBlank()) {
            return "Thất bại: tên món không hợp lệ";
        }

        if (quantity <= 0) {
            return "Thất bại: số lượng phải lớn hơn 0";
        }

        if (pricePerUnit <= 0) {
            return "Thất bại: giá món phải lớn hơn 0";
        }

        int stock = inventoryRepository.getStock(foodName);
        if (stock <= 0) {
            return "Thất bại: " + foodName + " đã hết hàng";
        }

        if (stock < quantity) {
            return "Thất bại: kho không đủ số lượng món " + foodName;
        }

        double balance = userAccountRepository.getBalance(username);
        if (balance < 0) {
            return "Thất bại: số dư tài khoản không hợp lệ hoặc tài khoản không tồn tại";
        }

        double totalPrice = quantity * pricePerUnit;
        if (balance < totalPrice) {
            return "Thất bại: tài khoản không đủ tiền";
        }

        userAccountRepository.deductBalance(username, totalPrice);
        inventoryRepository.decreaseStock(foodName, quantity);

        return "Đặt món thành công: " + foodName +
                " | Số lượng: " + quantity +
                " | Tổng tiền: " + totalPrice;
    }
}