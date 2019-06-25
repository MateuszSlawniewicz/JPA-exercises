package dao.category;

import dao.AbstractDao;
import entity.Category;
import entity.CategoryCode;

import java.util.List;
import java.util.Set;

public interface CategoryDao extends AbstractDao<Category> {
    List<Category> findByCategoryCodes(Set<CategoryCode> categoryCodes);
}
