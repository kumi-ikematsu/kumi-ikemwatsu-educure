@Service
public class QuizService {

    // TODO: WordMapperをDIしてください
    ____________ WordMapper wordMapper;

    // TODO: ランダムに1単語を取得するメソッドを実装してください
    // メソッド名：getRandomWord / 戻り値：Word
    // 処理：全単語を取得し、Collectionsでシャッフルして先頭1件を返す
    public Word getRandomWord() {
        List<Word> words = ____________;
        ____________(words);
        return words.____________(0);
    }

    // TODO: 答え合わせをするメソッドを実装してください
    // メソッド名：checkAnswer
    // 引数：int wordId（出題された単語のID）, String answer（ユーザーの回答）
    // 戻り値：boolean（正解ならtrue）
    public boolean checkAnswer(____________, ____________) {
        Word word = ____________;
        return word.getJapanese().____________(answer);
    }
}
