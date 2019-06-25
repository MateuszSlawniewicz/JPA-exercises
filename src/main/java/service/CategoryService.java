package service;

import entity.Category;
import entity.CategoryCode;

import java.util.List;

public interface CategoryService {
    List<Category> findByCodes(List<CategoryCode> categoryCodes);
}
