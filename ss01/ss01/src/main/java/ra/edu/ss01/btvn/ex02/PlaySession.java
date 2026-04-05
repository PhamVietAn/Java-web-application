package ra.edu.ss01.btvn.ex02;

import org.springframework.stereotype.Component;

@Component
public class PlaySession {
    private double playTime = 0;

    public void addTime(double time) {
        this.playTime += time;
    }
}
/*
    scope mặc định của Spring là Singleton.
    Điều đó có nghĩa là:
        - Trong toàn bộ ứng dụng chỉ có 1 object PlaySession duy nhất
        - Tất cả nơi nào inject Bean này vào đều dùng chung cùng một instance
        - Biến playTime trở thành dữ liệu dùng chung

    Nên khi:
        - máy 01 gọi addTime(...) → playTime tăng
        - máy 02 cũng dùng đúng object đó → tiếp tục tăng trên cùng một bộ đếm

    Kết quả là các máy trạm không có phiên chơi riêng, mà đang dùng chung trạng thái, nên bị tính nhầm tiền.
*/
