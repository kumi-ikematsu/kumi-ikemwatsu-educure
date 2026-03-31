package com.example.vocab;

public class Vocabulary {

    private int id;
    private String word;
    private String meaning;

    public Vocabulary(int id, String word, String meaning) {
        this.id = id;
        this.word = word;
        this.meaning = meaning;
    }

    public int getId() {
        return id;
    }

    public String getWord() {
        return word;
    }

    public String getMeaning() {
        return meaning;
    }

    @Override
    public String toString() {
        return id + " | " + word + " | " + meaning;
    }
}
