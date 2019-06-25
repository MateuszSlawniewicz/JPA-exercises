package dao.author;

import dao.AbstractDao;
import entity.Author;

public interface AuthorDao extends AbstractDao<Author> {
    Author findByBookTitle(String title);

}
