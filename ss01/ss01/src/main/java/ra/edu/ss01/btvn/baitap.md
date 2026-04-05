### Bài 1: Hard-code Dependency trong `RechargeService`

### Vấn đề
`RechargeService` đang tự khởi tạo dependency bằng:


`new InternalPaymentGateway()`


### Phân tích
- Class bị gắn chặt với duy nhất `InternalPaymentGateway`.
- Vi phạm nguyên tắc IoC/DI vì tự quản lý dependency thay vì để container tiêm vào.

### Hậu quả
- Khó mở rộng sang cổng thanh toán khác.
- Khó test (khó mock/stub).
- Khó bảo trì khi thay đổi implementation.

### Bài 2: Sai lệch dữ liệu do `Singleton` scope

### Nguyên nhân
Scope mặc định của Spring là `singleton`, nên:
- Toàn ứng dụng chỉ có 1 object `PlaySession`.
- Mọi nơi inject đều dùng chung instance đó.
- Biến `playTime` trở thành trạng thái dùng chung.

### Tình huống xảy ra
- Máy 01 gọi `addTime(...)` -> `playTime` tăng.
- Máy 02 cũng thao tác trên cùng object -> tiếp tục tăng trên cùng bộ đếm.

### Kết quả
Các máy trạm không có phiên chơi riêng, dẫn đến tính tiền sai.

## Bài 3: Phân tích luồng xử lý đặt món

### Input
- `username`
- `foodName` (tên món)
- `quantity` (số lượng)

### Output
- Thành công: đặt món thành công, đã trừ tiền và cập nhật kho.
- Thất bại: trả về lỗi như `Hết món` hoặc `Không đủ tiền`.

### Các bước xử lý
1. Nhận thông tin đặt món từ người dùng.
2. Kiểm tra số lượng trong kho.
   - Nếu hết hàng -> trả về lỗi.
3. Kiểm tra số dư tài khoản.
   - Nếu không đủ tiền -> trả về lỗi.
4. Nếu hợp lệ:
   - Trừ số lượng trong kho.
   - Trừ tiền trong tài khoản.
5. Trả về kết quả thành công.

### Bài 4:


### 1. So sánh Constructor Injection và Field Injection

| Tiêu chí | Constructor Injection (Đề xuất) | Field Injection |
| :--- | :--- | :--- |
| **Cách tiêm** | Qua tham số hàm khởi tạo. | Trực tiếp vào biến (vd: `@Autowired`). |
| **Tính bất biến** | **Tốt** (Hỗ trợ từ khóa `final`). | **Kém** (Không dùng được `final`). |
| **Bảo đảm an toàn** | **Cao** (Báo lỗi compile nếu thiếu dependency). | **Thấp** (Dễ gặp `NullPointerException` lúc runtime). |
| **Khả năng Unit Test** | **Dễ** (Truyền mock object trực tiếp). | **Khó** (Phụ thuộc framework/thư viện test). |

### 2. Giải quyết bẫy dữ liệu (Đứt mạng SMS)
Việc đứt mạng là lỗi Runtime, không do cách chọn DI. Xử lý bằng cách: Bọc logic gọi SMS trong `try-catch`. Nếu SMS lỗi, hệ thống catch exception và **vẫn tiếp tục dùng `EmailSender`** để gửi thông báo thay thế.

### 3. Chốt lựa chọn
**-> Quyết định: Constructor Injection.**
* **Lý do:** Bắt buộc `NotificationService` phải có đủ cả 2 sender ngay khi khởi tạo, đảm bảo tính toàn vẹn (Best practice). Khi kết hợp với `try-catch`, service vẫn hoạt động ổn định nhờ `EmailSender` (đã được tiêm an toàn từ đầu) dù `SmsSender` gặp sự cố.