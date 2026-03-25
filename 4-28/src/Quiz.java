import java.util.List;
import java.util.Random;

public class Quiz {
    private WordManager wordManager;
    private int score;
    private int totalQuestions;
    private Random random;

    public Quiz(WordManager wordManager) {
        this.wordManager = wordManager;
        this.score = 0;
        this.totalQuestions = 0;
        this.random = new Random();
    }

    public Word getRandomWord() {
        List<Word> words = wordManager.getWords();
        if (words.isEmpty()) {
            return null;
        }
        int index = random.nextInt(words.size());
        return words.get(index);
    }

    public boolean checkAnswer(Word word, String answer) {
        totalQuestions++;

        if (word.getJapanese().equals(answer.trim())) {
            score++;
            return true;
        }
        return false;
    }

    public int getScore() {
        return score;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }
}