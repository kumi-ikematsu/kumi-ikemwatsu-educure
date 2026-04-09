package jp.educure.webapp.model;

public class Quiz {

    private String english;
    private String correctJapanese;
    private String userAnswer;
    private boolean correct;
    private int correctCount;
    private int totalCount;

    public Quiz() {
    }

    public Quiz(String english, String correctJapanese) {
        this.english = english;
        this.correctJapanese = correctJapanese;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getCorrectJapanese() {
        return correctJapanese;
    }

    public void setCorrectJapanese(String correctJapanese) {
        this.correctJapanese = correctJapanese;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public void setCorrectCount(int correctCount) {
        this.correctCount = correctCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    /** 正解率（%）を返します。totalCount が 0 の場合は 0 を返します */
    public int getCorrectRate() {
        if (totalCount == 0) {
            return 0;
        }
        return (int) Math.round((double) correctCount / totalCount * 100);
    }
}
