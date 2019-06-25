package service;

import dao.book.BookDao;
import dto.BookDto;
import entity.Book;
import entity.CategoryCode;
import org.pmw.tinylog.Logger;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class BookServiceImpl implements BookService {

    private BookDao bookDao;

    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public Book findById(Long id) {
        if (id != null) {
            return bookDao.find(id);
        } else {
            return new Book();
        }
    }

    @Override
    public Book update(Book book) {
        if (book.getId() != 0 && book.getTitle() != null) {
            return bookDao.update(book);
        } else {
            Logger.warn("wrong data");
            return null;
        }

    }

    @Override
    public void delete(Long id) {
        if (id != null) {
            bookDao.delete(new Book(id));
        }
    }

    @Override
    public Book insert(Book book) {

        if (book.getTitle() != null && !book.getTitle().isEmpty()) {
            bookDao.insert(book);
        }
        return null;
    }

    @Override
    public List<Book> find() {
        List<Book> books = bookDao.find();
        if (books != null) {
            return books;
        }
        return Collections.emptyList();
    }

    @Override
    public List<Book> findByTitle(String title) {
        if (title != null) {
            List<Book> books = bookDao.findByTitle(title);
            if (books != null) {
                return books;
            }
        }
        return Collections.emptyList();
    }

    @Override
    public List<Book> findByCategories(Set<CategoryCode> categories) {
        if (categories != null && !categories.isEmpty()) {
            List<Book> byCategories = bookDao.findByCategories(categories);
            if (byCategories != null) {
                return byCategories;
            }
        }
        return Collections.emptyList();
    }

    @Override
    public BookDto findByIsbn(long isbn) {
        BookDto byIsbn = bookDao.findByIsbn(isbn);

        return byIsbn;
    }

    @Override
    public List<Book> findBiggestBookWithPublisher() {
        return null;
    }

    @Override
    public List<BookDto> findByAuthorIdAndPagesRanges(long authorId, int lowerRange, int upperRanger) {
        if (lowerRange > 0 && upperRanger > 0) {
            return bookDao.findByAuthorIdAndPagesRanges(authorId, lowerRange, upperRanger);
        }
        return Collections.emptyList();
    }
}
