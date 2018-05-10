package net.abhi.backendshopping.dao;

import java.util.List;

import net.abhi.backendshopping.dto.Address;
import net.abhi.backendshopping.dto.User;

public interface UserDAO {
	//add an user
	boolean addUser(User user);
	User getByEmail(String email);
	//add an address
	Address getAddress(int addressId);
	boolean addAddress(Address address);
	Address getBillingAddress(User user);
	List<Address> listShippingAddresses(User user);
	boolean updateAddress(Address address);
}
