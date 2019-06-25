package dao.category;

import conntection.BookstoreEMF;
import entity.Category;
import entity.CategoryCode;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Set;

public class CategoryDaoImpl implements CategoryDao {
    @Override
    public List<Category> findByCategoryCodes(Set<CategoryCode> categoryCodes) {
        EntityManager entityManager = BookstoreEMF.createEntityManager();
        Query namedQuery = entityManager.createNamedQuery("Category.findCodes");
        namedQuery.setParameter("categoryCodes", categoryCodes);
        List resultList = namedQuery.getResultList();
        entityManager.close();
        return resultList;
    }

    @Override
    public Category find(long id) {
        return null;
    }

    @Override
    public void insert(Category category) {

    }

    @Override
    public void delete(Category category) {

    }

    @Override
    public Category update(Category category) {
        return null;
    }
}
