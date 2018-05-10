package net.abhi.backendshopping.dao;

import java.util.List;

import net.abhi.backendshopping.dto.Cart;
import net.abhi.backendshopping.dto.CartLine;
import net.abhi.backendshopping.dto.OrderDetail;

public interface CartLineDAO{
	public CartLine get(int id);
	public boolean add(CartLine cartLine);
	public boolean update(CartLine cartLine);
	public boolean delete(CartLine cartLine);
	public List<CartLine> list(int cartId);
	//other business methods related to cart lines
	public List<CartLine> listAvailable(int cartId);
	public CartLine getByCartAndProduct(int cartId,int productId);
	//add a cart
		boolean updateCart(Cart cart);
		public boolean addOrderDetail(OrderDetail orderDetail);
}
