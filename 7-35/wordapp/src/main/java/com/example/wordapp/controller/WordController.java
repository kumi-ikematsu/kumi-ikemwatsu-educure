package com.example.wordapp.controller;

import com.example.wordapp.entity.Word;
import com.example.wordapp.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WordController {

    @Autowired
    WordService wordService;

    // 一覧画面を表示するGETメソッド
    @GetMapping("/words")
    public String showWordList(Model model) {
        model.addAttribute("words", wordService.getAllWords());
        return "words";
    }

    // 編集フォームを表示するGETメソッド
    @GetMapping("/words/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        model.addAttribute("word", wordService.getWordById(id));
        return "edit";
    }

    // 更新処理を行うPOSTメソッド
    @PostMapping("/words/update")
    public String updateWord(@ModelAttribute Word word) {
        wordService.updateWord(word);
        return "redirect:/words";
    }

    // 削除処理を行うPOSTメソッド
    @PostMapping("/words/delete/{id}")
    public String deleteWord(@PathVariable("id") int id) {
        wordService.deleteWord(id);
        return "redirect:/words";
    }
}
