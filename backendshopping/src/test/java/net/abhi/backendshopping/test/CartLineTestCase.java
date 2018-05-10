package net.abhi.backendshopping.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.abhi.backendshopping.dao.CartLineDAO;
import net.abhi.backendshopping.dao.ProductDAO;
import net.abhi.backendshopping.dao.UserDAO;
import net.abhi.backendshopping.dto.Cart;
import net.abhi.backendshopping.dto.CartLine;
import net.abhi.backendshopping.dto.Product;
import net.abhi.backendshopping.dto.User;

public class CartLineTestCase {

	private static AnnotationConfigApplicationContext context;
	private static CartLineDAO cartLineDAO=null;
	private static ProductDAO productDAO=null;
	private static UserDAO userDAO=null;
	private Product product =null;
	private User user =null;
	private Cart cart=null;
	private CartLine cartLine=null;
	@BeforeClass
	public static void init(){
		context=new AnnotationConfigApplicationContext();
		context.scan("net.abhi.backendshopping");
		context.refresh();
		productDAO=(ProductDAO)context.getBean("productDAO");
		userDAO=(UserDAO)context.getBean("userDAO");
		cartLineDAO=(CartLineDAO)context.getBean("cartLineDAO");
	}
	@Test
	public void testAddNewCartLine(){
		//get the user
		user=userDAO.getByEmail("as@gmail.com");
		//fetch the cart
		cart=user.getCart();
		//get the product
		product=productDAO.get(1);
		//create a new cart line
		cartLine=new CartLine();
		cartLine.setBuyingPrice(product.getUnitPrice());
		cartLine.setProductCount(cartLine.getProductCount()+1);
		cartLine.setTotal(cartLine.getProductCount()*product.getUnitPrice());
		cartLine.setAvailable(true);
		cartLine.setCartId(cart.getId());
		cartLine.setProduct(product);
		assertEquals("FAiled to add the cart line",true,cartLineDAO.add(cartLine));
		//update the cart
		cart.setGrandTotal(cart.getGrandTotal()+cartLine.getTotal());
		cart.setCartLines(cart.getCartLines()+1);
		assertEquals("FAiled to update the cart",true,cartLineDAO.updateCart(cart));
	}
}
