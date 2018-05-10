package net.abhi.backendshopping.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.abhi.backendshopping.dao.UserDAO;
import net.abhi.backendshopping.dto.Address;
import net.abhi.backendshopping.dto.Cart;
import net.abhi.backendshopping.dto.User;

public class UserTestCase {
	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user=null;
	private Address address=null;
	private Cart cart=null;
	
	
	@BeforeClass
	public static void init(){
		context=new AnnotationConfigApplicationContext();
		context.scan("net.abhi.backendshopping");
		context.refresh();
		userDAO=(UserDAO)context.getBean("userDAO");
		
	}

/*	@Test
	public void testAdd(){
		user=new User();
		user.setFirstName("Hrithik");
		user.setLastName("Roshan");
		user.setEmail("hr@gmail.com");
		user.setContactNumber("9810889765");
		user.setRole("USER");
		user.setPassword("123456");
		//add the user
		assertEquals("failed to add user!",true,userDAO.addUser(user));
	
		address=new Address();
		address.setAddressLineOne("393,Sector-16");
		address.setAddressLineTwo("near Moti Mahal");
		address.setCity("Faridabad");
		address.setState("Haryana");
		address.setCountry("India");
		address.setPostalCode("121002");
		address.setBilling(true);
	//link the user with the address using userid
	address.setUserId(user.getId());
	assertEquals("failed to add the Address!",true,userDAO.addAddress(address));
	
	if(user.getRole().equals("USER"))
	{
		//create a cart for the user
		cart=new Cart();
		cart.setUser(user);
		//add the cart
		assertEquals("failed to add the Cart!",true,userDAO.addCart(cart));
		
		//add a shipping address for this user
		address=new Address();
		address.setAddressLineOne("393,Sector-16");
		address.setAddressLineTwo("Near Moti Mahal");
		address.setCity("Faridabad");
		address.setState("Haryana");
		address.setCountry("India");
		address.setPostalCode("121002");
		address.setShipping(true);
		//link it with user
		address.setUserId(user.getId());
		//add the shipping address
	    assertEquals("failed to add the shipping address!",true,userDAO.addAddress(address));
	}
	}*/
	
/*	@Test
	public void testAdd(){
		user=new User();
		user.setFirstName("Hrithik");
		user.setLastName("Roshan");
		user.setEmail("hr@gmail.com");
		user.setContactNumber("9810889765");
		user.setRole("USER");
		user.setPassword("123456");
			
	if(user.getRole().equals("USER"))
	{
		//create a cart for the user
		cart=new Cart();
		cart.setUser(user);
		//attach cart with the user
		user.setCart(cart);
		
	}
	//add the user
			assertEquals("failed to add user!",true,userDAO.addUser(user));
		
		
	}
	@Test
	public void testUpdateCart(){
		//fetch the user by its email
		user=userDAO.getByEmail("hr@gmail.com");
		//get the cart of the user
		cart=user.getCart();
		cart.setGrandTotal(5555);
		cart.setCartLines(2);
		assertEquals("failed to update the cart",true,userDAO.updateCart(cart));
	}*/
	/*@Test
	public void testAddAddress(){
		//we need to add an user
		user=new User();
		user.setFirstName("Hrithik");
		user.setLastName("Roshan");
		user.setEmail("hr@gmail.com");
		user.setContactNumber("9810889765");
		user.setRole("USER");
		user.setPassword("123456");
		//add the user
		assertEquals("failed to add user!",true,userDAO.addUser(user));
		
		//we are going to address
		address=new Address();
		address.setAddressLineOne("393,Sector-16");
		address.setAddressLineTwo("near Moti Mahal");
		address.setCity("Faridabad");
		address.setState("Haryana");
		address.setCountry("India");
		address.setPostalCode("121002");
		address.setBilling(true);
		//attach the user to the address
		address.setUser(user);
	assertEquals("failed to add the Address!",true,userDAO.addAddress(address));
		
		//we are going to add shipping address
	address=new Address();
	address.setAddressLineOne("393,Sector-16");
	address.setAddressLineTwo("Near Moti Mahal");
	address.setCity("Faridabad");
	address.setState("Haryana");
	address.setCountry("India");
	address.setPostalCode("121002");
	address.setShipping(true);
	//attach the user to the address
			address.setUser(user);
		assertEquals("failed to add the Shippoing Address!",true,userDAO.addAddress(address));
	}*/
/*	@Test
	public void testAddAddress(){
		user=userDAO.getByEmail("hr@gmail.com");
		address=new Address();
		address.setAddressLineOne("393,Sector-16");
		address.setAddressLineTwo("Near Moti Mahal");
		address.setCity("Ballabgarh");
		address.setState("Haryana");
		address.setCountry("India");
		address.setPostalCode("121002");
		address.setShipping(true);
		//attach the user to the address
				address.setUser(user);
			assertEquals("failed to add the Address!",true,userDAO.addAddress(address));

}*/
	@Test
	public void testGetAddresses(){
		user = userDAO.getByEmail("hr@gmail.com");
		assertEquals("failed to fetch the list and size doesnot match!",2,userDAO.listShippingAddresses(user).size());
		assertEquals("failed to fetch the list and size doesnot match!","Faridabad",userDAO.getBillingAddress(user).getCity());
	}
}