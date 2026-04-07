package jp.educure.bookmanagement.controller;

import jp.educure.bookmanagement.entity.Book;
import jp.educure.bookmanagement.mapper.BookMapper;
import jp.educure.bookmanagement.mapper.CategoryMapper;
import jp.educure.bookmanagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private BookService bookService;

    @GetMapping
    public String index(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String author,
            @RequestParam(required = false) Integer minPrice,
            @RequestParam(required = false) Integer maxPrice,
            Model model) {

        boolean hasSearch = (title != null && !title.isEmpty())
                || (author != null && !author.isEmpty())
                || minPrice != null || maxPrice != null;

        if (hasSearch) {
            model.addAttribute("books", bookService.search(title, author, minPrice, maxPrice));
        } else {
            model.addAttribute("books", bookMapper.findAll());
        }

        model.addAttribute("title", title);
        model.addAttribute("author", author);
        model.addAttribute("minPrice", minPrice);
        model.addAttribute("maxPrice", maxPrice);
        return "index";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("allCategories", categoryMapper.findAll());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Book book,
                         @RequestParam(required = false) List<Integer> categoryIds) {
        bookMapper.insert(book);
        if (categoryIds != null) {
            for (Integer catId : categoryIds) {
                Map<String, Integer> params = new HashMap<>();
                params.put("bookId", book.getId());
                params.put("categoryId", catId);
                bookMapper.insertBookCategory(params);
            }
        }
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable int id, Model model) {
        Book book = bookMapper.findById(id);
        model.addAttribute("book", book);
        model.addAttribute("allCategories", categoryMapper.findAll());
        model.addAttribute("selectedCategoryIds", bookMapper.findCategoryIdsByBookId(id));
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable int id, @ModelAttribute Book book,
                       @RequestParam(required = false) List<Integer> categoryIds) {
        book.setId(id);
        bookMapper.update(book);
        bookMapper.deleteBookCategories(id);
        if (categoryIds != null) {
            for (Integer catId : categoryIds) {
                Map<String, Integer> params = new HashMap<>();
                params.put("bookId", id);
                params.put("categoryId", catId);
                bookMapper.insertBookCategory(params);
            }
        }
        return "redirect:/books";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        bookMapper.deleteBookCategories(id);
        bookMapper.delete(id);
        return "redirect:/books";
    }
}
