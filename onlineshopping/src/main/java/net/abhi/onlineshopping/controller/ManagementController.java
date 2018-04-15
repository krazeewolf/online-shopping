package net.abhi.onlineshopping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.abhi.backendshopping.dao.CategoryDAO;
import net.abhi.backendshopping.dao.ProductDAO;
import net.abhi.backendshopping.dto.Category;
import net.abhi.backendshopping.dto.Product;
import net.abhi.onlineshopping.util.FileUploadUtility;
import net.abhi.onlineshopping.validator.ProductValidator;

@Controller
@RequestMapping("/manage")
public class ManagementController {
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired 
	private ProductDAO productDAO;
	private static final Logger logger=LoggerFactory.getLogger(ManagementController.class); 
	@RequestMapping(value="/products",method=RequestMethod.GET)
	public ModelAndView showManageProducts(@RequestParam(name="operation",required=false)String operation){
		ModelAndView model=new ModelAndView("page");
		model.addObject("userClickManageProducts",true);
		model.addObject("title", "Manage Products");
		Product nProduct= new Product();
		//set few of fields
		nProduct.setSupplierId(1);
		nProduct.setActive(true);
		model.addObject("product", nProduct);
		if(operation!=null){
			if(operation.equals("product")){
				model.addObject("message","Product Submitted Successfully!");
			}
			else if(operation.equals("category"))
			{
				model.addObject("message","Category Submitted Successfully!");
			}
		}
		return model;
	
	}
	
	@RequestMapping(value="/{id}/product",method=RequestMethod.GET)
	public ModelAndView showEditProduct(@PathVariable  int id){
		ModelAndView model=new ModelAndView("page");
		model.addObject("userClickManageProducts",true);
		model.addObject("title", "Manage Products");
		//fetch the product from database
		Product nProduct= productDAO.get(id);
		//set the product fetched from database
		model.addObject("product", nProduct);
		return model;
	
	}
	
	//handling product submission
	@RequestMapping(value="/products",method=RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product mproduct,BindingResult results,Model model,HttpServletRequest request){
		//handle image validation for new Products
		if(mproduct.getId() == 0){
		new ProductValidator().validate(mproduct,results); 
		}
		else{
			if(!mproduct.getFile().getOriginalFilename().equals("")){
				new ProductValidator().validate(mproduct,results); 
			}
		}
		
		//check if there are any errors
		if(results.hasErrors()){
			model.addAttribute("userClickManageProducts",true);
			model.addAttribute("title", "Manage Products");
			model.addAttribute("message", "Validation failed for Product Submission!");
			return "page";
		}
		logger.info(mproduct.toString());
		
		if(mproduct.getId()==0){
			//create a new record if the id is 0
		productDAO.add(mproduct);
		}
		else{
			//update the product if id is not 0
			productDAO.update(mproduct);
		}
		if(!mproduct.getFile().getOriginalFilename().equals("")){
			FileUploadUtility.uploadFile(request,mproduct.getFile(),mproduct.getCode());
		}
		return "redirect:/manage/products?operation=product";
	}
	
	@RequestMapping(value="/product/{id}/activation",method=RequestMethod.POST)
	@ResponseBody
	public String handleProductActivation(@PathVariable int id){
		//is going to fetch from the database 
		Product product=productDAO.get(id);
		boolean isActive= product.isActive();
		//activating and deactivating based on the value of active field
		product.setActive(!product.isActive());
		//Updating the product
		productDAO.update(product);
		return (isActive)? 
				"You have successfully deactivated the product with id" +product.getId() : 
					"You have successfully activated the product with id" +product.getId() ;
 	}
	// to handle category submission
	@RequestMapping(value="/category", method=RequestMethod.POST)
	public String handleCategorySubmission(@ModelAttribute Category category){
		//add new category
		categoryDAO.add(category);
		return "redirect:/manage/products/?operation=category";
	}
	
//returning categorires for all the request mapping
	@ModelAttribute("categories")
	public List<Category> getCategories(){
		return categoryDAO.list();
	}
	@ModelAttribute("category")
	public Category getCategory(){
		return new Category();
	}
}
