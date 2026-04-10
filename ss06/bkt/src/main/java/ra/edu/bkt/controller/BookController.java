package ra.edu.bkt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.edu.bkt.model.Book;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = {"/books","/"})
public class BookController {
    @GetMapping("/books")
    public String getBooks(Model model) {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "Sách thánh", "F. Scott Fitzgerald", 275000.0));
        books.add(new Book(2, "Phật pháp cơ bản", "Harper Lee", 225000.0));
        books.add(new Book(3, "Phật pháp nâng cao", "George Orwell", 250000));
        books.add(new Book(4, "Thánh đức chúa trời", "Jane Austen", 200000.0));
        books.add(new Book(5, "Phép thuật nâng cao", "J.D. Salinger", 300000.0));

        model.addAttribute("books", books);
        return "book-list";
    }

    @GetMapping("/books/{id}")
    public String getBook(@PathVariable int id, Model model) {

        return "book-detail";
    }
}
