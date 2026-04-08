@Controller
public class WordController {

    @Autowired
    WordService wordService;

    // TODO: 一覧画面を表示するGETメソッドを実装してください
    // パス：/words / 処理：全単語をModelに"words"として追加し words.html を返す
    @GetMapping("/words")
    public String showWordList(____________ model) {
        model.addAttribute("____________", ____________);
        return "____________";
    }

    // TODO: 編集フォームを表示するGETメソッドを実装してください
    // パス：/words/edit/{id} / 処理：idで単語を取得しModelに"word"として追加し edit.html を返す
    @GetMapping("/words/edit/____________")
    public String showEditForm(@____________("id") int id, Model model) {
        model.addAttribute("____________", ____________);
        return "____________";
    }

    // TODO: 更新処理を行うPOSTメソッドを実装してください
    // パス：/words/update / 処理：updateWordを呼び出し /words にリダイレクト
    @PostMapping("/words/update")
    public String updateWord(@ModelAttribute Word word) {
        ____________;
        return "____________";
    }

    // TODO: 削除処理を行うPOSTメソッドを実装してください
    // パス：/words/delete/{id} / 処理：deleteWordを呼び出し /words にリダイレクト
    @____________("/words/delete/{id}")
    public String deleteWord(@____________("id") ____________ id) {
        ____________;
        return "redirect:/words";
    }
}
