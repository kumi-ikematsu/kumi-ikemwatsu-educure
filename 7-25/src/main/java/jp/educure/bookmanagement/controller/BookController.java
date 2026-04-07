package jp.educure.bookmanagement.controller;

import jp.educure.bookmanagement.entity.Book;
import jp.educure.bookmanagement.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookMapper bookMapper;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("books", bookMapper.findAll());
        return "index";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("book", new Book());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Book book) {
        bookMapper.insert(book);
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable int id, Model model) {
        model.addAttribute("book", bookMapper.findById(id));
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable int id, @ModelAttribute Book book) {
        book.setId(id);
        bookMapper.update(book);
        return "redirect:/books";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        bookMapper.delete(id);
        return "redirect:/books";
    }
}
