package jp.educure.webapp.controller;

import jakarta.servlet.http.HttpSession;
import jp.educure.webapp.entity.Word;
import jp.educure.webapp.model.Quiz;
import jp.educure.webapp.service.WordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/quiz")
public class QuizController {

    private static final String SESSION_WORDS   = "quizWords";
    private static final String SESSION_INDEX   = "quizIndex";
    private static final String SESSION_CORRECT = "quizCorrectCount";
    private static final String SESSION_TOTAL   = "quizTotalCount";

    private final WordService wordService;

    public QuizController(WordService wordService) {
        this.wordService = wordService;
    }

    /** クイズ開始 */
    @GetMapping
    public String start(HttpSession session, Model model) {
        List<Word> words = wordService.findAll();
        if (words.isEmpty()) {
            model.addAttribute("errorMessage", "登録された単語がありません。先に単語を登録してください。");
            return "quiz/question";
        }
        Collections.shuffle(words);
        session.setAttribute(SESSION_WORDS,   words);
        session.setAttribute(SESSION_INDEX,   0);
        session.setAttribute(SESSION_CORRECT, 0);
        session.setAttribute(SESSION_TOTAL,   0);
        return showQuestion(session, model, null);
    }

    /** 回答受付 */
    @PostMapping("/answer")
    public String answer(@RequestParam String answer,
                         HttpSession session,
                         Model model) {
        @SuppressWarnings("unchecked")
        List<Word> words     = (List<Word>) session.getAttribute(SESSION_WORDS);
        Integer index        = (Integer) session.getAttribute(SESSION_INDEX);
        Integer correctCount = (Integer) session.getAttribute(SESSION_CORRECT);
        Integer totalCount   = (Integer) session.getAttribute(SESSION_TOTAL);

        if (words == null || index == null) {
            return "redirect:/quiz";
        }

        Word current = words.get(index);
        boolean isCorrect = current.getJapanese().trim().equals(answer.trim());

        totalCount++;
        if (isCorrect) correctCount++;
        session.setAttribute(SESSION_CORRECT, correctCount);
        session.setAttribute(SESSION_TOTAL,   totalCount);
        session.setAttribute(SESSION_INDEX,   index + 1);

        Quiz result = new Quiz(current.getEnglish(), current.getJapanese());
        result.setUserAnswer(answer);
        result.setCorrect(isCorrect);
        result.setCorrectCount(correctCount);
        result.setTotalCount(totalCount);

        return showQuestion(session, model, result);
    }

    // ---------- private ----------

    private String showQuestion(HttpSession session, Model model, Quiz lastResult) {
        @SuppressWarnings("unchecked")
        List<Word> words     = (List<Word>) session.getAttribute(SESSION_WORDS);
        Integer index        = (Integer) session.getAttribute(SESSION_INDEX);
        Integer correctCount = (Integer) session.getAttribute(SESSION_CORRECT);
        Integer totalCount   = (Integer) session.getAttribute(SESSION_TOTAL);

        if (words == null) {
            return "redirect:/quiz";
        }

        model.addAttribute("lastResult",   lastResult);
        model.addAttribute("correctCount", correctCount != null ? correctCount : 0);
        model.addAttribute("totalCount",   totalCount  != null ? totalCount   : 0);

        if (index != null && index < words.size()) {
            Word next = words.get(index);
            model.addAttribute("quiz", new Quiz(next.getEnglish(), next.getJapanese()));
        } else {
            model.addAttribute("finished", true);
            int rate = (totalCount != null && totalCount > 0)
                    ? (int) Math.round((double) correctCount / totalCount * 100)
                    : 0;
            model.addAttribute("correctRate", rate);
        }
        return "quiz/question";
    }
}
