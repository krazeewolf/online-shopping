package net.abhi.onlineshopping.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.abhi.backendshopping.dao.CategoryDAO;
import net.abhi.backendshopping.dao.ProductDAO;
import net.abhi.backendshopping.dto.Category;
import net.abhi.backendshopping.dto.Product;
import net.abhi.onlineshopping.exception.ProductNotFoundException;

@Controller
public class PageController {
	private static final Logger logger= LoggerFactory.getLogger(PageController.class);
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private ProductDAO productDAO;

	@RequestMapping(value={"/","/home","/index"})
	public ModelAndView index(){
		ModelAndView model=new ModelAndView("page");
		model.addObject("title","Home");
		logger.info("Inside PageController index method - INFO");
		logger.debug("Inside PageController index method - DEBUG");
		//passing the list of categories
		model.addObject("categories", categoryDAO.list());
		model.addObject("userClickHome",true);
		return model;		
	}
	@RequestMapping(value="/about")
	public ModelAndView about(){
		ModelAndView model=new ModelAndView("page");
		model.addObject("title","About Us");
		model.addObject("userClickAbout",true);
		return model;		
	}
		
	@RequestMapping(value="/contact")
	public ModelAndView contact(){
		ModelAndView model=new ModelAndView("page");
		model.addObject("title","Contact Us");
		model.addObject("userClickContact",true);
		return model;		
	}
	
	/*
	 * Method to load all the product and based on category
	 */
	
	@RequestMapping(value="/show/all/products")
	public ModelAndView showAllProducts(){
		ModelAndView model=new ModelAndView("page");
		model.addObject("title","All Products");
		//passing the list of categories
		model.addObject("categories", categoryDAO.list());
		model.addObject("userClickAllProducts",true);
		return model;
}
	@RequestMapping(value="/show/category/{id}/products")
	public ModelAndView showCategoryProduct(@PathVariable("id") int id){
		ModelAndView model=new ModelAndView("page");
		
		//categoryDao to fetch a single category
		Category category=null;
		category=categoryDAO.get(id);
		
		model.addObject("title",category.getName());
		//passing the list of categories
		model.addObject("categories", categoryDAO.list());
		//passing the single category object
		model.addObject("category", category);
		model.addObject("userClickCategoryProducts",true);
		return model;
}
	/*
	 * Viewing a Single Product
	 * */
	@RequestMapping(value="/show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable int id) throws ProductNotFoundException{
		ModelAndView model=new ModelAndView("page");
		Product product=productDAO.get(id);
		if(product == null) throw new ProductNotFoundException();
		product.setViews(product.getViews()+1);
		//update the views
		productDAO.update(product);
		model.addObject("title", product.getName());
		model.addObject("product", product);
		model.addObject("userClickShowProduct",true);
		return model;
	}
}