package jp.educure.webapp.repository;

import jp.educure.webapp.entity.Word;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface WordMapper {

    @Select("SELECT id, english, japanese, created_at, updated_at FROM words ORDER BY id")
    @Results({
        @Result(property = "id",        column = "id"),
        @Result(property = "english",   column = "english"),
        @Result(property = "japanese",  column = "japanese"),
        @Result(property = "createdAt", column = "created_at"),
        @Result(property = "updatedAt", column = "updated_at")
    })
    List<Word> findAll();

    @Select("SELECT id, english, japanese, created_at, updated_at FROM words WHERE id = #{id}")
    @Results({
        @Result(property = "id",        column = "id"),
        @Result(property = "english",   column = "english"),
        @Result(property = "japanese",  column = "japanese"),
        @Result(property = "createdAt", column = "created_at"),
        @Result(property = "updatedAt", column = "updated_at")
    })
    Word findById(Integer id);

    @Insert("INSERT INTO words (english, japanese) VALUES (#{english}, #{japanese})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Word word);

    @Update("UPDATE words SET japanese = #{japanese}, updated_at = CURRENT_TIMESTAMP WHERE id = #{id}")
    int update(Word word);

    @Delete("DELETE FROM words WHERE id = #{id}")
    int delete(Integer id);

    @Select("SELECT COUNT(*) FROM words")
