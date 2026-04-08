package com.example.wordapp.controller;

import com.example.wordapp.model.Word;
import com.example.wordapp.service.QuizService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QuizController {

    @Autowired
    QuizService quizService;

    @GetMapping("/quiz")
    public String showQuiz(Model model, HttpSession session) {
        Word word = quizService.getRandomWord();
        model.addAttribute("word", word);

        if (session.getAttribute("correctCount") == null) {
            session.setAttribute("correctCount", 0);
        }
        if (session.getAttribute("totalCount") == null) {
            session.setAttribute("totalCount", 0);
        }

        return "quiz";
    }

    @PostMapping("/quiz/answer")
    public String checkAnswer(
            @RequestParam int wordId,
            @RequestParam String answer,
            HttpSession session,
            Model model) {

        boolean isCorrect = quizService.checkAnswer(wordId, answer);

        int total = (int) session.getAttribute("totalCount") + 1;
        session.setAttribute("totalCount", total);

        if (isCorrect) {
            int correct = (int) session.getAttribute("correctCount") + 1;
            session.setAttribute("correctCount", correct);
        }

        model.addAttribute("isCorrect", isCorrect);
        model.addAttribute("totalCount", total);
        model.addAttribute("correctCount", session.getAttribute("correctCount"));

        Word word = quizService.getWordById(wordId);
        model.addAttribute("correctAnswer", word.getJapanese());

        return "quiz";
    }

    @GetMapping("/quiz/reset")
    public String resetQuiz(HttpSession session) {
        session.invalidate();
        return "redirect:/quiz";
    }
}
