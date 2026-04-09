package jp.educure.webapp.controller;

import jp.educure.webapp.entity.Word;
import jp.educure.webapp.service.WordService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(WordController.class)
class WordControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WordService wordService;

    @MockBean
    private jp.educure.webapp.helper.WordHelper wordHelper;

    private Word buildWord(int id, String english, String japanese) {
        Word w = new Word();
        w.setId(id);
        w.setEnglish(english);
        w.setJapanese(japanese);
        w.setCreatedAt(LocalDateTime.now());
        w.setUpdatedAt(LocalDateTime.now());
        return w;
    }

    // --------------------------------------------------
    // No | テスト内容         | 入力値              | 期待される結果
    // 1-1| 基本的な単語登録   | apple / りんご      | リダイレクト＆成功メッセージ
    // --------------------------------------------------
    @Test
    @DisplayName("1-1: 基本的な単語登録 - 登録成功メッセージが表示されること")
    void test1_1_basicWordRegister() throws Exception {
        when(wordHelper.toEntity(any())).thenReturn(buildWord(0, "apple", "りんご"));

        mockMvc.perform(post("/words")
                .param("english", "apple")
                .param("japanese", "りんご"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/words"))
                .andExpect(flash().attribute("successMessage", "単語を登録しました。"));

        verify(wordService, times(1)).save(any());
    }

    // --------------------------------------------------
    // No | テスト内容              | 入力値                    | 期待される結果
    // 1-2| スペースを含む単語登録  | ice cream / アイスクリーム | リダイレクト
    // --------------------------------------------------
    @Test
    @DisplayName("1-2: スペースを含む単語登録 - 正常に登録されること")
    void test1_2_wordWithSpace() throws Exception {
        when(wordHelper.toEntity(any())).thenReturn(buildWord(0, "ice cream", "アイスクリーム"));

        mockMvc.perform(post("/words")
                .param("english", "ice cream")
                .param("japanese", "アイスクリーム"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/words"));

        verify(wordService, times(1)).save(any());
    }

    // --------------------------------------------------
    // No | テスト内容          | 入力値          | 期待される結果
    // 1-3| 記号を含む単語登録  | e-mail / メール | リダイレクト
    // --------------------------------------------------
    @Test
    @DisplayName("1-3: 記号を含む単語登録 - 正常に登録されること")
    void test1_3_wordWithSymbol() throws Exception {
        when(wordHelper.toEntity(any())).thenReturn(buildWord(0, "e-mail", "メール"));

        mockMvc.perform(post("/words")
                .param("english", "e-mail")
                .param("japanese", "メール"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/words"));

        verify(wordService, times(1)).save(any());
    }

    // --------------------------------------------------
    // No | テスト内容        | 入力値      | 期待される結果
    // 1-4| 空文字の入力      | "" / ""     | バリデーションエラー2件・保存されない
    // --------------------------------------------------
    @Test
    @DisplayName("1-4: 英単語・日本語訳ともに空文字 - バリデーションエラーになること")
    void test1_4_bothEmpty() throws Exception {
        mockMvc.perform(post("/words")
                .param("english", "")
                .param("japanese", ""))
                .andExpect(status().isOk())
                .andExpect(view().name("word/form"))
                .andExpect(model().attributeHasFieldErrors("wordForm", "english", "japanese"));

        verify(wordService, never()).save(any());
    }

    // --------------------------------------------------
    // No | テスト内容        | 入力値          | 期待される結果
    // 1-5| 英単語のみ空文字  | "" / りんご     | english にエラー・保存されない
    // --------------------------------------------------
    @Test
    @DisplayName("1-5: 英単語のみ空文字 - english にバリデーションエラーが発生すること")
    void test1_5_englishEmpty() throws Exception {
        mockMvc.perform(post("/words")
                .param("english", "")
                .param("japanese", "りんご"))
                .andExpect(status().isOk())
                .andExpect(view().name("word/form"))
                .andExpect(model().attributeHasFieldErrors("wordForm", "english"));

        verify(wordService, never()).save(any());
    }

    // --------------------------------------------------
    // No | テスト内容        | 入力値          | 期待される結果
    // 1-6| 日本語のみ空文字  | apple / ""      | japanese にエラー・保存されない
    // --------------------------------------------------
    @Test
    @DisplayName("1-6: 日本語訳のみ空文字 - japanese にバリデーションエラーが発生すること")
    void test1_6_japaneseEmpty() throws Exception {
        mockMvc.perform(post("/words")
                .param("english", "apple")
                .param("japanese", ""))
                .andExpect(status().isOk())
                .andExpect(view().name("word/form"))
                .andExpect(model().attributeHasFieldErrors("wordForm", "japanese"));

        verify(wordService, never()).save(any());
    }

    // --------------------------------------------------
    // No | テスト内容        | 入力値              | 期待される結果
    // 1-7| 文字数制限超過    | 101文字 / テスト    | english にエラー・保存されない
    // --------------------------------------------------
    @Test
    @DisplayName("1-7: 英単語が101文字 - english にバリデーションエラーが発生すること")
    void test1_7_englishTooLong() throws Exception {
        String longEnglish = "a".repeat(101);

        mockMvc.perform(post("/words")
                .param("english", longEnglish)
                .param("japanese", "テスト"))
                .andExpect(status().isOk())
                .andExpect(view().name("word/form"))
                .andExpect(model().attributeHasFieldErrors("wordForm", "english"));

        verify(wordService, never()).save(any());
    }

    // --------------------------------------------------
    // No | テスト内容  | 前提条件            | 期待される結果
    // 3-1| 単語の更新  | apple が登録済み    | リダイレクト＆成功メッセージ
    // --------------------------------------------------
    @Test
    @DisplayName("3-1: 単語の更新 - 更新成功メッセージが表示されること")
    void test3_1_updateWord() throws Exception {
        when(wordService.findById(1)).thenReturn(buildWord(1, "apple", "りんご"));
        when(wordHelper.toEntity(any())).thenReturn(buildWord(1, "apple", "アップル"));

        mockMvc.perform(post("/words/1")
                .param("english", "apple")
                .param("japanese", "アップル"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/words/1"))
                .andExpect(flash().attribute("successMessage", "単語を更新しました。"));

        verify(wordService, times(1)).update(any());
    }

    // --------------------------------------------------
    // No | テスト内容  | 前提条件            | 期待される結果
    // 3-3| 単語の削除  | apple が登録済み    | リダイレクト＆成功メッセージ
    // --------------------------------------------------
    @Test
    @DisplayName("3-3: 単語の削除 - 削除成功メッセージが表示されること")
    void test3_3_deleteWord() throws Exception {
        doNothing().when(wordService).delete(1);

        mockMvc.perform(post("/words/1/delete"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/words"))
                .andExpect(flash().attribute("successMessage", "単語を削除しました。"));

        verify(wordService, times(1)).delete(1);
    }

    // --------------------------------------------------
    // 単語一覧・詳細の補助テスト
    // --------------------------------------------------
    @Test
    @DisplayName("単語一覧 - 登録済み単語がモデルに渡されること")
    void wordList_displaysWords() throws Exception {
        when(wordService.findAll()).thenReturn(
                List.of(buildWord(1, "apple", "りんご"),
                        buildWord(2, "banana", "バナナ")));

        mockMvc.perform(get("/words"))
                .andExpect(status().isOk())
                .andExpect(view().name("word/list"))
                .andExpect(model().attributeExists("words"));
    }

    @Test
    @DisplayName("単語詳細 - 存在しないIDへのアクセスは一覧にリダイレクトされること")
    void wordDetail_notFound_redirectsToList() throws Exception {
        when(wordService.findById(999)).thenReturn(null);

        mockMvc.perform(get("/words/999"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/words"));
    }
}
