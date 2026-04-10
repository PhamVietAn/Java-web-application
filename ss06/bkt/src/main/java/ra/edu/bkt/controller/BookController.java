package ra.edu.bkt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ra.edu.bkt.model.Book;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {
    private final List<Book> books = new ArrayList<>();

    public BookController() {
        books.add(new Book(1, "Sách thánh", "F. Scott Fitzgerald", 275000.0));
        books.add(new Book(2, "Phật pháp cơ bản", "Harper Lee", 225000.0));
        books.add(new Book(3, "Phật pháp nâng cao", "George Orwell", 250000));
        books.add(new Book(4, "Thánh đức chúa trời", "Jane Austen", 200000.0));
        books.add(new Book(5, "Phép thuật nâng cao", "J.D. Salinger", 300000.0));
    }

    @GetMapping({"/", "/books"})
    public String listBooks(Model model) {
        model.addAttribute("books", books);
        model.addAttribute("pageTitle", "Danh sách sách");
        return "book-list";
    }

    @GetMapping("/books/{id}")
    public String bookDetail(@PathVariable("id") int id, Model model) {
        Book foundBook = books.stream().filter(b -> b.getId() == id).findFirst().orElse(null);

        model.addAttribute("book", foundBook);
        model.addAttribute("pageTitle", foundBook != null
                ? "Chi tiết sách - " + foundBook.getTitle()
                : "Không tìm thấy sách");
        return "book-detail";
    }
}
