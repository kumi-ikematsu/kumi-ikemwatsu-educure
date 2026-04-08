@Service
public class WordService {

    @Autowired
    WordMapper wordMapper;

    public void registerWord(Word word) { ... } // 実装済み

    // TODO: 全件取得メソッドを実装してください
    public List<Word> getAllWords() {
        return ____________;
    }

    // TODO: IDで1件取得するメソッドを実装してください
    public Word getWordById(____________) {
        return ____________;
    }

    // TODO: 単語を更新するメソッドを実装してください
    public void updateWord(____________) {
        ____________;
    }

    // TODO: 単語を削除するメソッドを実装してください
    public void deleteWord(____________) {
        ____________;
    }
}
