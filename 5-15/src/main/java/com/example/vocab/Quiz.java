package com.example.vocab;

import java.util.List;
import java.util.Random;

public class Quiz {

    private WordManager wordManager;
    private int score;
    private int totalQuestions;

    public Quiz(WordManager wordManager) {
        this.wordManager = wordManager;
        this.score = 0;
        this.totalQuestions = 0;
    }

    public void reset() {
        this.score = 0;
        this.totalQuestions = 0;
    }

    public boolean checkAnswer(Word word, String answer) {
        totalQuestions++;
        if (answer.equalsIgnoreCase(word.getJapanese())) {
            score++;
            return true;
        }
        return false;
    }

    public Word getRandomWord() {
        List<Word> list = wordManager.getWords();
        if (list.isEmpty()) return null;
        return list.get(new Random().nextInt(list.size()));
    }

    public int getScore() {
        return score;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }
}
