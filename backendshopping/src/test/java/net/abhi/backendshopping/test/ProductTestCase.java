package net.abhi.backendshopping.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.abhi.backendshopping.dao.ProductDAO;
import net.abhi.backendshopping.dto.Product;

public class ProductTestCase {
	private static AnnotationConfigApplicationContext context;
	private static ProductDAO productDAO;
	private Product product;
	
	@BeforeClass
	public static void init(){
		context=new AnnotationConfigApplicationContext();
		context.scan("net.abhi.backendshopping");
		context.refresh();
		productDAO=(ProductDAO) context.getBean("productDAO");
	}
/*
	@Test
	public void testCRUDProduct(){
		//create operation
		product=new Product();
		product.setName("Samsung j7 PRIME");
		product.setBrand("Samsung");
		product.setDescription("This is some description about Samsung PHONES");
		product.setUnitPrice(17000);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(3);
		
		assertEquals("SOMETHING WENT WRONG WHILE INSERTING A NEW PRODUCT!",true,productDAO.add(product));
		//reading and updating a category
		product=productDAO.get(2);
		product.setName("Samsung Galaxy S7");
		assertEquals("SOMETHING WENT WRONG WHILE DELETING A EXISTING PRODUCT!",true,productDAO.update(product));
		//DELETING A RECORD
		assertEquals("SOMETHING WENT WRONG WHILE UPDATING A EXISTING PRODUCT!",true,productDAO.delete(product));
		//list
		assertEquals("SOMETHING WENT WRONG WHILE FETCHING THE LIST OF PRODUCTS!",6,productDAO.list().size());
	}*/
	@Test
	public void testListActiveProducts(){
		assertEquals("SOMETHING WENT WRONG WHILE FETCHING THE LIST OF PRODUCTS!",5,productDAO.listActiveProducts().size());
		
	}
	@Test
	public void testListActiveProductsByCategory(){
		assertEquals("SOMETHING WENT WRONG WHILE FETCHING THE LIST OF PRODUCTS!",3,productDAO.listActiveProductsByCategory(3).size());
		assertEquals("SOMETHING WENT WRONG WHILE FETCHING THE LIST OF PRODUCTS!",2,productDAO.listActiveProductsByCategory(1).size());
	}
	@Test
	public void testGetLatestActiveProducts(){
		assertEquals("SOMETHING WENT WRONG WHILE FETCHING THE LIST OF PRODUCTS!",3,productDAO.getLatestActiveProducts(3).size());
		
	}
}
