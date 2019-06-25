package service;

import dto.BookDto;
import entity.Book;
import entity.CategoryCode;

import java.util.List;
import java.util.Set;

public interface BookService {
    Book findById(Long id);

    Book update(Book book);

    void delete(Long id);

    Book insert(Book book);
    List<Book> find();

    List<Book> findByTitle(String title);

    List<Book> findByCategories(Set<CategoryCode> categories);

    BookDto findByIsbn(long isbn);

    List<Book> findBiggestBookWithPublisher();

    List<BookDto> findByAuthorIdAndPagesRanges(long authorId, int lowerRange, int upperRanger);
}
