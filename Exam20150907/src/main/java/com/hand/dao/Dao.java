package com.hand.dao;

import java.util.List;

public interface Dao {
	
	public List<com.hand.entity.Customer> getAllCustomer();
	
	public String checkCustomer(String firstName, String lastName);
	
	public List<String> getAddress();
	
	public int getAddressId(String address);
	
	public boolean save(String fname, String lname, String emial, int address);
	
	public boolean delete(int customerId);
	
	public boolean update(String fname, String lname, String emial, int address, int customerId);

}
