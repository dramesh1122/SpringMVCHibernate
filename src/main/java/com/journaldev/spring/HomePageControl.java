package com.journaldev.spring;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.journaldev.spring.dao.PersonDAOImpl;
import com.journaldev.spring.model.Login;
import com.journaldev.spring.model.User;
import com.journaldev.spring.service.CategoryService;

@Controller
public class HomePageControl {
	private static final Logger logger = LoggerFactory.getLogger(HomePageControl.class);
	private CategoryService categoryService;

	public CategoryService getCategoryService() {
		return categoryService;
	}

	@Autowired(required = true)
	@Qualifier(value = "categoryService")
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getHomePage(Model model) {
		model.addAttribute("categories", this.categoryService.getCategoryTree());
		return "homepage";
	}
	@RequestMapping(value="/categorypage/{categoryid}",method=RequestMethod.GET)// categoryid is used to pathvarible purpose
	public String getCategorypage(Model model,@PathVariable("categoryid") String categoryid){
		logger.info("HomePageControlzCategory id is={}",categoryid);
	return "categorypage";
	}
	
	@RequestMapping(value="/registrationpage",method=RequestMethod.GET)
	public String getRegistrationform(Model model){
	     model.addAttribute("userForm", new User());
	     List<String> professionList = new ArrayList<>();
	        professionList.add("Developer");
	        professionList.add("Designer");
	        professionList.add("IT Manager");
	        model.addAttribute("professionList", professionList);
		return "registrationform";
	}
	
	@RequestMapping(value="/registrationsubmit",method = RequestMethod.POST)
    public String processRegistration(@ModelAttribute("userForm") User user) {
         
        // implement your own registration logic here...
         
        // for testing purpose:
        System.out.println("username: " + user.getUsername());
        System.out.println("password: " + user.getPassword());
        System.out.println("email: " + user.getEmail());
        System.out.println("birth date: " + user.getBirthDate());
        System.out.println("profession: " + user.getProfession());
         
        return "loginpage";
    }
	
	@RequestMapping(value="/loginpage",method=RequestMethod.GET)
	public String getLoginpage(Model model){
		model.addAttribute("loginForm", new Login());
		return "loginpage";
	}
	
	
}
//Test commit ******//