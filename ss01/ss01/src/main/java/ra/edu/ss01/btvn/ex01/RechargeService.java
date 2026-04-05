package ra.edu.ss01.btvn.ex01;

public class RechargeService {
    private PaymentGateway gateway;

    public RechargeService() {
        // Lỗi: Tự khởi tạo thủ công (Hard-code dependency)
        this.gateway = new InternalPaymentGateway();
    }

    public void processRecharge(String username, double amount) {
        gateway.pay(amount);
        System.out.println("Nạp " + amount + " cho " + username);
    }
}

/*
Lỗi: Tự khởi tạo thủ công (Hard-code dependency)
RechargeService đang tự tạo ra dependency của mình bằng new InternalPaymentGateway().
Điều này làm class bị gắn chặt với đúng một cổng thanh toán là InternalPaymentGateway.
khiến ứng dụng mất tính linh hoạt, khó mở rộng, khó bảo trì và đi ngược lại tinh thần IoC/DI.


* */