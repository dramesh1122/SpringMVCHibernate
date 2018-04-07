package com.journaldev.spring.dao;

import java.util.List;
import java.util.Map;

import com.journaldev.spring.model.Category;

public interface CategoryDao {
	
	public List<Category> getAllCategories();

	List<Category> getCategoriesBySuperCategory(String id);

}
