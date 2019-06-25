package service;

import dao.category.CategoryDao;
import entity.Category;
import entity.CategoryCode;

import java.util.HashSet;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    private CategoryDao categoryDao;

    public CategoryServiceImpl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public List<Category> findByCodes(List<CategoryCode> categoryCodes) {
        return categoryDao.findByCategoryCodes(new HashSet<>(categoryCodes));


    }
}
