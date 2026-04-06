## Báo cáo bảo mật JSTL, EL và phòng thủ XSS

### 1. XSS là gì?

XSS là lỗ hổng cho phép dữ liệu do người dùng nhập vào được trình duyệt hiểu như mã HTML hoặc JavaScript và thực thi trực tiếp trên trang web. Khi đó kẻ tấn công có thể chèn script độc hại để đánh cắp dữ liệu, chiếm phiên đăng nhập hoặc thay đổi nội dung hiển thị.

### 2. Vì sao <c:out value="${keyword}"/> an toàn hơn ${keyword}?

<c:out> mặc định escape XML/HTML, nên các ký tự đặc biệt như `<`, `>`, `"` sẽ được chuyển thành dạng text an toàn trước khi render ra trình duyệt.

Nếu input là:
<script>alert(1)</script>

- Với `${keyword}`:
  Trình duyệt có thể nhận trực tiếp thẻ `<script>` và thực thi JavaScript.
- Với `<c:out value="${keyword}"/>`:
  Kết quả xuất ra sẽ là text đã escape, ví dụ:
  `&lt;script&gt;alert(1)&lt;/script&gt;`
  nên trình duyệt chỉ hiển thị chuỗi này như văn bản, không chạy script.

Vì vậy trong bài này, mọi dữ liệu do người dùng nhập hoặc dữ liệu có thể chứa ký tự HTML đều nên đi qua `<c:out>`.

### 3. Khác nhau giữa <c:if> và <c:choose>

### <c:if>
- Dùng cho điều kiện đơn lẻ
- Chỉ kiểm tra đúng hoặc sai
- Phù hợp khi chỉ cần hiển thị hoặc không hiển thị một đoạn nội dung

### <c:choose>/<c:when>/<c:otherwise>
- Dùng khi có nhiều nhánh loại trừ lẫn nhau
- Tương đương if / else if / else
- Phù hợp khi một giá trị có nhiều trạng thái hiển thị khác nhau

### 4. Trong bài này nên dùng loại nào?

- Phần “Giá vé” nên dùng `<c:choose>` vì có 2 nhánh rõ ràng:
    - giá bằng 0
    - giá khác 0

- Phần “Vé còn lại” cũng nên dùng `<c:choose>` vì có 3 trạng thái:
    - hết vé
    - sắp hết
    - còn nhiều vé

Như vậy code rõ ràng hơn và tránh dùng nhiều `<c:if>` rời rạc.

### 5. <c:url> giải quyết vấn đề gì?

`<c:url>` tạo URL đúng theo context path hiện tại của ứng dụng.

Nếu hardcode:
`href="/events/1/book"`
thì URL này luôn trỏ từ root domain.

Khi ứng dụng deploy dưới context path `/ticketing`, đường dẫn đúng phải là:
`/ticketing/events/1/book`

Nếu vẫn hardcode `/events/1/book`, link sẽ sai và có thể dẫn tới 404.

Dùng `<c:url>` giúp:
- tự gắn đúng context path
- tránh lỗi khi đổi tên ứng dụng
- an toàn hơn khi deploy ở nhiều môi trường khác nhau