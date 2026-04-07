package jp.educure.bookmanagement.service;

import jp.educure.bookmanagement.entity.Book;
import jp.educure.bookmanagement.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookService {

    @Autowired
    private BookMapper bookMapper;

    public List<Book> search(String title, String author, Integer minPrice, Integer maxPrice) {
        Map<String, Object> params = new HashMap<>();
        if (title != null && !title.isEmpty()) params.put("title", title);
        if (author != null && !author.isEmpty()) params.put("author", author);
        if (minPrice != null) params.put("minPrice", minPrice);
        if (maxPrice != null) params.put("maxPrice", maxPrice);
        return bookMapper.search(params);
    }
}
