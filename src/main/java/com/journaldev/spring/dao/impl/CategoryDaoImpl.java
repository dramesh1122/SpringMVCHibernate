package com.journaldev.spring.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.journaldev.spring.dao.CategoryDao;
import com.journaldev.spring.model.Category;

@Repository
public class CategoryDaoImpl implements CategoryDao{
	
	private static final Logger logger = LoggerFactory.getLogger(CategoryDaoImpl.class);
	private static final String CATEGORY_TABLE="from Category";

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		logger.debug("getAllCategories()");
		Session session = this.sessionFactory.getCurrentSession();
		List<Category> categotyList = session.createQuery(CATEGORY_TABLE).list();
		return categotyList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getCategoriesBySuperCategory(String supercategory) {
		// TODO Auto-generated method stub
		logger.debug("getCategoriesBySuperCategory()");
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery(CATEGORY_TABLE+" WHERE supercategory='"+supercategory+"'").list();
	}
	

}
