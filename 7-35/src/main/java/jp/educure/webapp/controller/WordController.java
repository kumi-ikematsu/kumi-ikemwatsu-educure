package jp.educure.webapp.controller;

import jakarta.validation.Valid;
import jp.educure.webapp.entity.Word;
import jp.educure.webapp.form.WordForm;
import jp.educure.webapp.helper.WordHelper;
import jp.educure.webapp.service.WordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/words")
public class WordController {

    private final WordService wordService;
    private final WordHelper wordHelper;

    public WordController(WordService wordService, WordHelper wordHelper) {
        this.wordService = wordService;
        this.wordHelper = wordHelper;
    }

    /** 単語一覧 */
    @GetMapping
    public String list(Model model) {
        List<Word> words = wordService.findAll();
        model.addAttribute("words", words);
        return "word/list";
    }

    /** 単語詳細 */
    @GetMapping("/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        Word word = wordService.findById(id);
        if (word == null) {
            return "redirect:/words";
        }
        model.addAttribute("word", word);
        return "word/detail";
    }

    /** 新規登録フォーム表示 */
    @GetMapping("/new")
    public String newForm(Model model) {
        model.addAttribute("wordForm", new WordForm());
        return "word/form";
    }

    /** 新規登録処理 */
    @PostMapping
    public String create(@Valid @ModelAttribute WordForm wordForm,
                         BindingResult bindingResult,
                         Model model,
                         RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "word/form";
        }
        Word word = wordHelper.toEntity(wordForm);
        wordService.save(word);
        redirectAttributes.addFlashAttribute("successMessage", "単語を登録しました。");
        return "redirect:/words";
    }

    /** 編集フォーム表示 */
    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Integer id, Model model) {
        Word word = wordService.findById(id);
        if (word == null) {
            return "redirect:/words";
        }
        model.addAttribute("wordForm", wordHelper.toForm(word));
        return "word/form";
    }

    /** 更新処理 */
    @PostMapping("/{id}")
    public String update(@PathVariable Integer id,
                         @Valid @ModelAttribute WordForm wordForm,
                         BindingResult bindingResult,
                         Model model,
                         RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "word/form";
        }
        wordForm.setId(id);
        Word word = wordHelper.toEntity(wordForm);

        boolean updated = wordService.update(word);
        if (!updated) {
            // 対象IDが存在しない場合はエラーメッセージを表示して一覧へ
            redirectAttributes.addFlashAttribute("errorMessage",
                    "更新対象の単語が見つかりませんでした。");
            return "redirect:/words";
        }

        redirectAttributes.addFlashAttribute("successMessage", "単語を更新しました。");
        return "redirect:/words/" + id;
    }

    /** 削除処理 */
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Integer id,
                         RedirectAttributes redirectAttributes) {

        boolean deleted = wordService.delete(id);
        if (!deleted) {
            // 対象IDが存在しない場合はエラーメッセージを表示
            redirectAttributes.addFlashAttribute("errorMessage",
                    "削除対象の単語が見つかりませんでした。");
            return "redirect:/words";
        }

        redirectAttributes.addFlashAttribute("successMessage", "単語を削除しました。");
        return "redirect:/words";
    }
}
