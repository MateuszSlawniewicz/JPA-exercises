package dao.author;

import conntection.BookstoreEMF;
import entity.Author;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class AuthorDaoImpl implements AuthorDao {
    @Override
    public Author find(long id) {
        EntityManager entityManager = BookstoreEMF.createEntityManager();
        Author author = entityManager.find(Author.class, id);
        entityManager.close();
        return author;
    }

    @Override
    public void insert(Author author) {
        EntityManager entityManager = BookstoreEMF.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(author);
        transaction.commit();
        entityManager.close();
    }

    @Override
    public void delete(Author author) {
        EntityManager entityManager = BookstoreEMF.createEntityManager();
        entityManager.remove(author);
        entityManager.close();

    }

    @Override
    public Author update(Author author) {
        EntityManager entityManager = BookstoreEMF.createEntityManager();
        Author updatedAuthor = entityManager.merge(author);
        entityManager.close();
        return updatedAuthor;
    }

    @Override
    public Author findByBookTitle(String title) {
        EntityManager entityManager = BookstoreEMF.createEntityManager();
        Query nativeQuery = entityManager.createNativeQuery("select a.id, a.first_name, a.last_name, a.date_of_birth from authors a join books_authors ba on a.id = ba.author_id join books b on ba.book_id = b.id where b.title = :givenTitle");
        nativeQuery.setParameter("givenTitle", title);
        Author singleResult = (Author) nativeQuery.getSingleResult();
        entityManager.close();
        return singleResult;
    }
}
