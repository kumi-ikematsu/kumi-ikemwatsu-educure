@Controller
public class WordController {

    // TODO: WordServiceをDIしてください
    ____________ WordService wordService;

    // TODO: 登録フォームを表示するGETメソッドを実装してください
    // パス：/register
    @____________("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("word", new Word());
        return "____________"; // テンプレート名
    }

    // TODO: 登録処理を行うPOSTメソッドを実装してください
    // パス：/register
    // 処理：wordServiceのregisterWordを呼び出し、登録後に /words へリダイレクト
    @____________("/register")
    public String registerWord(____________ Word word) {
        ____________;
        return "____________:____________"; // リダイレクト先
    }
}
