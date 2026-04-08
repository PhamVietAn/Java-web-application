package ra.edu.demo2.reponsitory.imp;

import org.springframework.stereotype.Repository;
import ra.edu.demo2.model.entity.Project;
import ra.edu.demo2.reponsitory.ProjectRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProjectRepositoryImpl  implements ProjectRepository {
    private ArrayList<Project> projects;

    public ProjectRepositoryImpl() {
        projects = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            projects.add(new Project(1,"Dự án nuôi An","Dự án quyên góp tiền cho an sống qua ngày","Phạm Việt An",sdf.parse("01/01/2024"), sdf.parse("31/12/2026"), 1));
            projects.add(new Project(2,"Dự án mở kênh đào Hormuz","Chúng tôi rất quan ngại nếu không mở","Đỗ Nam Trung",sdf.parse("01/03/2026"), sdf.parse("31/04/2026"), 2));
            projects.add(new Project(3,"Dự án kẹo rau củ Kera","Cam kết được làm từ 70% rau củ trồng tại nhà máy","Linh Tiên",sdf.parse("15/12/2024"), sdf.parse("20/08/2025"), 50));
            projects.add(new Project(4,"Dự án AI Agent cho doanh nghiệp nhỏ","Xây trợ lý AI tự động hóa CSKH, tổng hợp báo cáo và xử lý ticket đa kênh","Nguyễn Minh Trí",sdf.parse("10/01/2026"), sdf.parse("30/09/2026"), 18));
            projects.add(new Project(5,"Dự án trạm sạc xe điện xanh","Triển khai trạm sạc năng lượng mặt trời kết hợp ứng dụng đặt lịch theo thời gian thực","Trần Khánh Vy",sdf.parse("15/02/2026"), sdf.parse("20/12/2026"), 32));
            projects.add(new Project(6,"Dự án livestream social commerce","Nền tảng livestream bán hàng tích hợp AI gợi ý sản phẩm và đo hiệu quả chuyển đổi","Lê Hoàng Nam",sdf.parse("01/04/2026"), sdf.parse("31/10/2026"), 24));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Project> findAll() {
        return projects;
    }

    @Override
    public Project findById(int id) {
        return projects.get(id);
    }

    @Override
    public Project findByName(String prjName) {
        return projects.stream().filter(p -> p.getPrjName().equals(prjName)).findFirst().orElse(null);
    }
}
