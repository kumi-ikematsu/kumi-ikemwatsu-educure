package jp.educure.webapp.controller;

import jp.educure.webapp.form.ToDoForm;
import jp.educure.webapp.service.ToDoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/todo")
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    // 一覧表示
    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("todoList", toDoService.findAll());
        return "todo/list";
    }

    // 新規登録画面表示
    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("toDoForm", new ToDoForm());
        return "todo/form";
    }

    // 新規登録処理
    @PostMapping("/create")
    public String create(
            @Valid @ModelAttribute ToDoForm toDoForm,
            BindingResult bindingResult,
            Model model) {

        // バリデーションエラーがあった場合はフォーム入力画面を表示
        if (bindingResult.hasErrors()) {
            return "todo/form";
        }

        toDoService.save(toDoForm);
        return "redirect:/todo/list";
    }

    // 編集画面表示
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("toDoForm", toDoService.findById(id));
        return "todo/form";
    }

    // 更新処理
    @PostMapping("/update/{id}")
    public String update(
            @PathVariable Long id,
            @Valid @ModelAttribute ToDoForm toDoForm,
            BindingResult bindingResult,
            Model model) {

        // バリデーションエラーがあった場合はフォーム入力画面を表示
        if (bindingResult.hasErrors()) {
            return "todo/form";
        }

        toDoService.update(id, toDoForm);
        return "redirect:/todo/list";
    }

    // 削除処理
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        toDoService.delete(id);
        return "redirect:/todo/list";
    }
}
