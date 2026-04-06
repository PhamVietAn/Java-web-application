## Phân tích Scope & Implicit Objects

### 1. Vì sao thông báo lỗi đăng nhập phải lưu ở Request Scope?

Thông báo lỗi đăng nhập chỉ cần tồn tại trong đúng một lần xử lý request sau khi người dùng nhập sai tài khoản hoặc mật khẩu. Sau khi trang được render xong, thông báo này không còn giá trị sử dụng.

Nếu lưu thông báo lỗi vào Session Scope, lỗi sẽ tồn tại qua nhiều request khác nhau. Khi người dùng tải lại trang hoặc chuyển sang thao tác khác, thông báo cũ vẫn có thể xuất hiện lại dù lỗi đã không còn liên quan. Điều này làm sai nghiệp vụ và gây nhầm lẫn.

Vì vậy, thông báo lỗi nên lưu trong Request Scope để:
- Chỉ hiển thị đúng một lần
- Không lan sang các request tiếp theo
- Không làm bẩn dữ liệu phiên làm việc

### 2. Vì sao totalViewCount phải lưu ở Application Scope?

totalViewCount là bộ đếm tổng số lượt xem đơn hàng của toàn hệ thống. Giá trị này phải được chia sẻ cho tất cả người dùng và tất cả session.

Application Scope phù hợp vì:
- Dữ liệu dùng chung cho toàn bộ ứng dụng
- Mọi nhân viên đều nhìn thấy cùng một giá trị
- Không bị mất khi đổi người dùng hoặc tạo session mới

Nếu lưu vào Session Scope, mỗi nhân viên sẽ có một bộ đếm riêng. Khi đó:
- Nhân viên A có thể thấy 2
- Nhân viên B có thể thấy 1
- Hệ thống không còn phản ánh tổng lượt xem toàn cục

Do đó, Session Scope không phù hợp cho dữ liệu thống kê dùng chung.

### 3. Race Condition là gì?

Race Condition là tình huống nhiều luồng cùng truy cập và cập nhật một dữ liệu dùng chung tại cùng một thời điểm, làm kết quả cuối cùng bị sai hoặc không ổn định.

Đoạn code sau có nguy cơ Race Condition:

```java
Integer count = (Integer) application.getAttribute("totalViewCount");
if (count == null) count = 0;
count++;
application.setAttribute("totalViewCount", count);
```
### 4. Cách phòng tránh Race Condition
Cách đơn giản là đồng bộ hóa khi cập nhật Application Scope:

```java
ServletContext application = request.getServletContext();
synchronized (application) {
    Integer count = (Integer) application.getAttribute("totalViewCount");
    if (count == null) {
        count = 0;
    }
    application.setAttribute("totalViewCount", count + 1);
}
```