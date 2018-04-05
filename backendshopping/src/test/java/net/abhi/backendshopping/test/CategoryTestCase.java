package net.abhi.backendshopping.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.abhi.backendshopping.dao.CategoryDAO;
import net.abhi.backendshopping.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;
	private Category category;
	
	
	@BeforeClass
	public static void init(){
		context=new AnnotationConfigApplicationContext();
		context.scan("net.abhi.backendshopping");
		context.refresh();
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
		
	}
	
/*	@Test
	public void testAddCategory(){
		
		category=new Category();
		category.setName("Laptop");
		category.setDescription("This is some description about Laptop");
		category.setImageURL("CAT_3.png");
		assertEquals("SuccesFully added the category inside the table",true,categoryDAO.add(category));
	}*/
	
	/*@Test
	public void testGetCategory(){
		category=categoryDAO.get(1);
		assertEquals("SuccesFully fetched the category from the table","Mobile",category.getName());
	}
*/
	/*@Test
	public void testUpdateCategory(){
		category=categoryDAO.get(1);
		category.setName("Mobile Phones");
		assertEquals("SuccesFully updated the category in the table",true,categoryDAO.update(category));
	}*/
	
/*	@Test
	public void testDeleteCategory(){
		category=categoryDAO.get(1);
		assertEquals("SuccesFully deleted the category from the table",true,categoryDAO.delete(category));
	}*/
	/*@Test
	public void testListCategory(){
		category=categoryDAO.get(1);
		assertEquals("SuccesFully fetched the list of  categories from the table",2,categoryDAO.list().size());
	}*/
	
	@Test
	public void testCRUDCategory() {
		//add operation
		category=new Category();
		category.setName("Laptop");
		category.setDescription("This is some description about Laptop");
		category.setImageURL("CAT_3.png");
		assertEquals("SuccesFully added the category inside the table",true,categoryDAO.add(category));
		
		category=new Category();
		category.setName("Television");
		category.setDescription("This is some description about Television");
		category.setImageURL("CAT_4.png");
		assertEquals("SuccesFully added the category inside the table",true,categoryDAO.add(category));
	
		//fetching and updating the category
		category=categoryDAO.get(2);
		category.setName("Tv");
		assertEquals("SuccesFully updated the category in the table",true,categoryDAO.update(category));
	
	
	//delete the category
		assertEquals("SuccesFully deleted the category from the table",true,categoryDAO.delete(category));
	
		//fetching the list
		assertEquals("SuccesFully fetched the list of  categories from the table",1,categoryDAO.list().size());
	
	}	
}
