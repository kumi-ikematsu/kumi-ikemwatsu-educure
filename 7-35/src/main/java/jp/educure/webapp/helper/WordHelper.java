package jp.educure.webapp.helper;

import jp.educure.webapp.entity.Word;
import jp.educure.webapp.form.WordForm;
import org.springframework.stereotype.Component;

@Component
public class WordHelper {

    /** WordForm を Word エンティティに変換します */
    public Word toEntity(WordForm form) {
        Word word = new Word();
        word.setId(form.getId());
        word.setEnglish(form.getEnglish());
        word.setJapanese(form.getJapanese());
        return word;
    }

    /** Word エンティティを WordForm に変換します */
    public WordForm toForm(Word word) {
        WordForm form = new WordForm();
        form.setId(word.getId());
        form.setEnglish(word.getEnglish());
        form.setJapanese(word.getJapanese());
        return form;
    }
}
