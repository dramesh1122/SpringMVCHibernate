package com.journaldev.spring.service;

import java.util.List;
import java.util.Map;

import com.journaldev.spring.model.Category;

public interface CategoryService {

	public List<Category> getAllCategories();

	Map<Category, Map<Category, List<Category>>> getCategoryTree();

}
