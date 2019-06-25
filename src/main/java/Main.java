import dao.book.BookDaoImpl;
import entity.Book;
import entity.Category;
import entity.CategoryCode;
import service.BookService;
import service.BookServiceImpl;

public class Main {

    public static void main(String[] args) {
        BookService bookService = new BookServiceImpl(new BookDaoImpl());
        Book byId = bookService.findById(2L);
        System.out.println(byId);

        Category category = new Category();
        category.setName("History");
        category.setCode(CategoryCode.HISTORY);

        Book book = new Book();
        book.setTitle("Ksiazka B");
        book.setPagesNumber(300);
        book.setIsbn(1010101210);
        book.setCategory(category);
        bookService.insert(book);
    }


}
