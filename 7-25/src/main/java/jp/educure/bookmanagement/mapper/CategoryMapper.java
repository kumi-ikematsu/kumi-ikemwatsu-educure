package jp.educure.bookmanagement.mapper;

import jp.educure.bookmanagement.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface CategoryMapper {
    List<Category> findAll();
    Category findById(int id);
    void insert(Category category);
    void update(Category category);
    void delete(int id);
    void deleteBookCategories(int categoryId);
}
