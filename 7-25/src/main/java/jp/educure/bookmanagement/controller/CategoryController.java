package jp.educure.bookmanagement.controller;

import jp.educure.bookmanagement.entity.Category;
import jp.educure.bookmanagement.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryMapper categoryMapper;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("categories", categoryMapper.findAll());
        return "categories";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("category", new Category());
        return "create-category";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Category category) {
        categoryMapper.insert(category);
        return "redirect:/categories";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable int id, Model model) {
        model.addAttribute("category", categoryMapper.findById(id));
        return "edit-category";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable int id, @ModelAttribute Category category) {
        category.setId(id);
        categoryMapper.update(category);
        return "redirect:/categories";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        categoryMapper.deleteBookCategories(id);
        categoryMapper.delete(id);
        return "redirect:/categories";
    }
}と
