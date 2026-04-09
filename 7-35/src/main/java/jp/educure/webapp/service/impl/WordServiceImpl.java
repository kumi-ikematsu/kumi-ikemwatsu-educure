package jp.educure.webapp.service;

import jp.educure.webapp.entity.Word;
import jp.educure.webapp.repository.WordMapper;
import jp.educure.webapp.service.impl.WordServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class WordServiceImplTest {

    @Mock
    private WordMapper wordMapper;

    @InjectMocks
    private WordServiceImpl wordService;

    private Word apple;

    @BeforeEach
    void setUp() {
        apple = new Word();
        apple.setId(1);
        apple.setEnglish("apple");
        apple.setJapanese("りんご");
    }

    // ============================================================
    // No.1-1  単語登録（サービス層）
    // ============================================================
    @Test
    @DisplayName("No.1-1 save() - WordMapper#insert が1回呼び出されること")
    void no1_1_saveCallsInsert() {
        doNothing().when(wordMapper).insert(any(Word.class));

        wordService.save(apple);

        verify(wordMapper, times(1)).insert(apple);
    }

    // ============================================================
    // No.3-1  単語の更新 - 成功（サービス層）
    // ============================================================
    @Test
    @DisplayName("No.3-1 update() - 影響行数1のとき true が返ること")
    void no3_1_update_returnsTrue() {
        when(wordMapper.update(any(Word.class))).thenReturn(1);
        apple.setJapanese("アップル");

        boolean result = wordService.update(apple);

        assertThat(result).isTrue();
        verify(wordMapper, times(1)).update(apple);
    }

    // ============================================================
    // No.3-2  存在しない単語の更新（サービス層）
    // ============================================================
    @Test
    @DisplayName("No.3-2 update() - 影響行数0のとき false が返ること")
    void no3_2_update_returnsFalse_whenNotFound() {
        when(wordMapper.update(any(Word.class))).thenReturn(0);

        boolean result = wordService.update(apple);

        assertThat(result).isFalse();
    }

    // ============================================================
    // No.3-3  単語の削除 - 成功（サービス層）
    // ============================================================
    @Test
    @DisplayName("No.3-3 delete() - 影響行数1のとき true が返ること")
    void no3_3_delete_returnsTrue() {
        when(wordMapper.delete(anyInt())).thenReturn(1);

        boolean result = wordService.delete(1);

        assertThat(result).isTrue();
        verify(wordMapper, times(1)).delete(1);
    }

    // ============================================================
    // No.3-4  存在しない単語の削除（サービス層）
    // ============================================================
    @Test
    @DisplayName("No.3-4 delete() - 影響行数0のとき false が返ること")
    void no3_4_delete_returnsFalse_whenNotFound() {
        when(wordMapper.delete(anyInt())).thenReturn(0);

        boolean result = wordService.delete(999);

        assertThat(result).isFalse();
    }

    // ============================================================
    // 補助：全件取得・ID検索・件数取得
    // ============================================================
    @Test
    @DisplayName("findAll() - 登録済み単語のリストが返ること")
    void findAll_returnsAllWords() {
        when(wordMapper.findAll()).thenReturn(List.of(apple));

        List<Word> result = wordService.findAll();

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getEnglish()).isEqualTo("apple");
    }

    @Test
    @DisplayName("findById() - 存在するIDで対応する Word が返ること")
    void findById_returnsWord() {
        when(wordMapper.findById(1)).thenReturn(apple);

        Word result = wordService.findById(1);

        assertThat(result).isNotNull();
        assertThat(result.getEnglish()).isEqualTo("apple");
    }

    @Test
    @DisplayName("findById() - 存在しないIDで null が返ること")
    void findById_notFound_returnsNull() {
        when(wordMapper.findById(999)).thenReturn(null);

        assertThat(wordService.findById(999)).isNull();
    }

    @Test
    @DisplayName("count() - 登録件数が返ること")
    void count_returnsCount() {
        when(wordMapper.count()).thenReturn(5);

        assertThat(wordService.count()).isEqualTo(5);
    }
}
