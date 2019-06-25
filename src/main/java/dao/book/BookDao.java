package dao.book;

import dao.AbstractDao;
import dto.BookDto;
import entity.Book;
import entity.CategoryCode;

import java.util.List;
import java.util.Set;

public interface BookDao extends AbstractDao<Book> {
    List<Book> find();

    List<Book> findByTitle(String title);

    List<Book> findByCategories(Set<CategoryCode> categories);

    List<Book> findBiggestBookWithPublisher();

    List<BookDto> findByAuthorIdAndPagesRanges(long authorId, int lowerRange, int upperRanger);

    BookDto findByIsbn(long isbn);


}
