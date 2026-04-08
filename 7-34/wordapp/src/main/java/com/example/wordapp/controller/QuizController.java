@Controller
public class QuizController {

    // TODO: QuizServiceをDIしてください
    ____________ QuizService quizService;

    // TODO: クイズ画面を表示するGETメソッドを実装してください
    // パス：/quiz
    @GetMapping("/quiz")
    public String showQuiz(Model model, HttpSession session) {
        Word word = ____________;
        model.addAttribute("____________", word);

        if (session.getAttribute("correctCount") == ____________) {
            session.setAttribute("correctCount", ____________);
        }
        if (session.getAttribute("totalCount") == null) {
            session.setAttribute("____________", 0);
        }

        return "____________";
    }

    // TODO: 回答処理を行うPOSTメソッドを実装してください
    // パス：/quiz/answer
    @PostMapping("/quiz/answer")
    public String checkAnswer(
            @RequestParam int wordId,
            @RequestParam ____________ answer,
            HttpSession session,
            Model model) {

        boolean isCorrect = ____________;

        int total = (int) session.getAttribute("____________") + 1;
        session.setAttribute("totalCount", ____________);

        if (____________) {
            int correct = (int) session.getAttribute("____________") + 1;
            session.setAttribute("____________", correct);
        }

        model.addAttribute("____________", isCorrect);
        model.addAttribute("totalCount", total);
        model.addAttribute("correctCount", session.getAttribute("correctCount"));

        // TODO: wordIdで単語を取得し、japaneseをModelに"correctAnswer"として追加
        ____________

        return "____________";
    }

    // TODO: スコアをリセットするGETメソッドを実装してください
    // パス：/quiz/reset / 処理：セッションを無効化して /quiz にリダイレクト
    @GetMapping("/quiz/reset")
    public String resetQuiz(____________ session) {
        ____________;
        return "redirect:/quiz";
    }
}
