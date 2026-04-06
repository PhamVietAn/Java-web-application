package ra.edu.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"/","/books"})
public class BookController {
    @GetMapping
    public String home(){
        return "listBook";
    }

    @GetMapping("/display")
    public String display(){
        return "display";
    }
}
