package jp.educure.webapp.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class WordForm {

    private Integer id;

    @NotBlank(message = "英単語を入力してください")
    @Size(max = 100, message = "英単語は100文字以内で入力してください")
    private String english;

    @NotBlank(message = "日本語訳を入力してください")
    @Size(max = 100, message = "日本語訳は100文字以内で入力してください")
    private String japanese;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getJapanese() {
        return japanese;
    }

    public void setJapanese(String japanese) {
        this.japanese = japanese;
    }
}
