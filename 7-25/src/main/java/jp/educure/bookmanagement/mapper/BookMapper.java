package jp.educure.bookmanagement.mapper;

import jp.educure.bookmanagement.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import java.util.Map;

@Mapper
public interface BookMapper {
    List<Book> findAll();
    Book findById(int id);
    void insert(Book book);
    void update(Book book);
    void delete(int id);
    List<Book> search(Map<String, Object> params);
    void insertBookCategory(Map<String, Integer> params);
    void deleteBookCategories(int bookId);
    List<Integer> findCategoryIdsByBookId(int bookId);
}
