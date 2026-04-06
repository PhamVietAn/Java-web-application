package ra.edu.ss02.Ex02;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class ReportController {

    @GetMapping("/report")
    public String showReport(Model model) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Nguyễn Thị Bình", 92));
        students.add(new Student("Trần Minh Khoa", 75));
        students.add(new Student("Lê Thu Hà", 55));
        students.add(new Student("Phạm Duy An", 48));

        model.addAttribute("studentList", students);
        model.addAttribute("reportTitle", "Báo cáo điểm cuối kỳ");
        return "report";
    }
}
