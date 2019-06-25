package service;

import dao.author.AuthorDao;
import entity.Author;
import org.pmw.tinylog.Logger;

public class AuthorServiceImpl implements AuthorService {


    private AuthorDao authorDao;


    public AuthorServiceImpl(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @Override
    public Author findById(Long id) {
        if (id != null) {
            return authorDao.find(id);
        }
        return new Author();
    }

    @Override
    public Author update(Author author) {
        if (author.getId() != 0 && author.getFirstName() != null && author.getLastName() != null) {
            return authorDao.update(author);
        } else {
            Logger.warn("wrong data");
            return null;
        }
    }

    @Override
    public void delete(Long id) {
        if (id != null) {
            authorDao.delete(new Author(id));
        }

    }

    @Override
    public Author insert(Author author) {
        if (author != null && author.getFirstName() != null && author.getLastName() != null && !author.getFirstName().isEmpty() && !author.getLastName().isEmpty()) {
            authorDao.insert(author);
        }
        return null;
    }

    @Override
    public Author findByBookTitle(String title) {
        if (title != null) {
            return authorDao.findByBookTitle(title);
        }
        return null;
    }


}

