package jp.educure.webapp.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import jp.educure.webapp.entity.ToDo;
import jp.educure.webapp.form.ToDoForm;
import jp.educure.webapp.service.ToDoService;

@Controller
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    @GetMapping("/todo")
    public String index(Model model) {
        model.addAttribute("todoList", toDoService.findAll());
        return "todo/index";
    }

    @GetMapping("/todo/create")
    public String createForm(@ModelAttribute ToDoForm form) {
        return "todo/form";
    }

    @PostMapping("/todo/create")
    public String create(@Valid @ModelAttribute ToDoForm form, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "todo/form";
        }

        ToDo todo = new ToDo();
        BeanUtils.copyProperties(form, todo);
        toDoService.insert(todo);

        return "redirect:/todo";
    }

    @GetMapping("/todo/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        ToDo todo = toDoService.findById(id);

        ToDoForm form = new ToDoForm();
        BeanUtils.copyProperties(todo, form);

        model.addAttribute("toDoForm", form);
        return "todo/form";
    }

    @PostMapping("/todo/update")
    public String update(@Valid @ModelAttribute ToDoForm form, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "todo/form";
        }

        ToDo todo = new ToDo();
        BeanUtils.copyProperties(form, todo);
        toDoService.update(todo);

        return "redirect:/todo";
    }

    @PostMapping("/todo/delete")
    public String delete(@ModelAttribute ToDoForm form) {
        toDoService.delete(form.getId());
        return "redirect:/todo";
    }
}
