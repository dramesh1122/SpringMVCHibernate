package com.journaldev.spring.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.journaldev.spring.dao.CategoryDao;
import com.journaldev.spring.model.Category;
import com.journaldev.spring.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	private CategoryDao categoryDao;

	public CategoryDao getCategoryDao() {
		return categoryDao;
	}

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	@Override
	@Transactional
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		return this.categoryDao.getAllCategories();
	}

	@Override
	@Transactional
	public Map<Category, Map<Category, List<Category>>> getCategoryTree() {
		Map<Category, Map<Category, List<Category>>> result = new LinkedHashMap<>();
		List<Category> superCategories = this.categoryDao.getCategoriesBySuperCategory("");
		Map<Category, List<Category>> subCategoryMap = null;
		List<Category> subCategories;
		for (Category superCategory : superCategories) {
			subCategories = this.categoryDao.getCategoriesBySuperCategory(superCategory.getId());
			subCategoryMap = new LinkedHashMap<>();
			for (Category subCategory : subCategories) {
				subCategoryMap.put(subCategory,
						this.categoryDao.getCategoriesBySuperCategory(subCategory.getId()));
			}
			result.put(superCategory, subCategoryMap);
		}
		return result;

	}

}
