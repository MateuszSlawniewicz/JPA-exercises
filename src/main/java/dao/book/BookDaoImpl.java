package dao.book;

import conntection.BookstoreEMF;
import dto.BookDto;
import dto.BookDtoResultTransformer;
import entity.Book;
import entity.CategoryCode;
import org.hibernate.Session;
import org.hibernate.transform.ResultTransformer;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class BookDaoImpl implements BookDao {

    @Override
    public Book find(long id) {
        EntityManager entityManager = BookstoreEMF.createEntityManager();
        Book book = entityManager.find(Book.class, id);
        entityManager.close();
        return book;
    }

    @Override
    public void insert(Book book) {
        EntityManager entityManager = BookstoreEMF.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(book);
        transaction.commit();
        entityManager.close();
    }

    @Override
    public void delete(Book book) {
        EntityManager entityManager = BookstoreEMF.createEntityManager();
        entityManager.remove(book);
        entityManager.close();
    }

    @Override
    public Book update(Book book) {
        EntityManager entityManager = BookstoreEMF.createEntityManager();
        Book updated = entityManager.merge(book);
        entityManager.close();
        return updated;
    }

    @Override
    public List<Book> find() {
        EntityManager entityManager = BookstoreEMF.createEntityManager();
        Query query = entityManager.createQuery("select b from Book b");
        List resultList = query.getResultList();
        entityManager.close();
        return resultList;
    }

    @Override
    public List<Book> findByTitle(String title) {
        EntityManager entityManager = BookstoreEMF.createEntityManager();
        Query query = entityManager.createQuery("select b from Book b where b.title = :givenTitle");
        query.setParameter("givenTitle", title);
        List resultList = query.getResultList();
        entityManager.close();
        return resultList;
    }

    @Override
    public List<Book> findByCategories(Set<CategoryCode> categories) {
        EntityManager entityManager = BookstoreEMF.createEntityManager();
        Query query = entityManager.createQuery("select new Book(b.id, b.title, b.isbn)from Book b join b.category c where c.code in (:givenCategoriesCode)");
        query.setParameter("givenCategoriesCode", categories);
        List resultList = query.getResultList();
        entityManager.close();
        return resultList;
    }

    @Override
    public List<Book> findBiggestBookWithPublisher() {
        EntityManager entityManager = BookstoreEMF.createEntityManager();


        return null;
    }

    @Override
    public List<BookDto> findByAuthorIdAndPagesRanges(long authorId, int lowerRange, int upperRanger) {
        EntityManager entityManager = BookstoreEMF.createEntityManager();
        Session unwrap = entityManager.unwrap(Session.class);
        org.hibernate.query.Query query = unwrap.createQuery("select b.id as id, b.title as title, b.isbn as isbn, b.pagesNumber as pagesNumber," +
                " p.id as publisherId, p.name as publisherName" +
                " from Book b join b.publisher p join b.authors a where a.id = :authorId and b.pagesNumber between :min and :max");
        query.setParameter("authorId", authorId);
        query.setParameter("min", lowerRange);
        query.setParameter("max", upperRanger);
        query.setResultTransformer(new BookDtoResultTransformer());
        List resultList = query.getResultList();
        return resultList;
    }

    @Override
    public BookDto findByIsbn(long isbn) {
        EntityManager entityManager = BookstoreEMF.createEntityManager();
        Session unwrap = entityManager.unwrap(Session.class);
        org.hibernate.query.Query query = unwrap.createQuery("select b.id as id, b.title as title, b.isbn as isbn, b.pagesNumber " +
                "as pagesNumber from Book b where b.isbn = :givenIsbn");
        query.setParameter("givenIsbn", isbn);
        query.setResultTransformer(new BookDtoResultTransformer());
        BookDto dto = (BookDto) query.getSingleResult();
        return dto;
    }
}
