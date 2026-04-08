package jp.educure.webapp.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ToDoForm {

    @NotBlank(message = "ToDoは必須です。")
    private String todo;

    @Size(min = 1, max = 100, message = "詳細は1〜100文字以内で入力してください。")
    private String detail;

    // Getter & Setter
    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
