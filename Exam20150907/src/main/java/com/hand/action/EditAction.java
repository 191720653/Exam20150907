package com.hand.action;

import com.hand.dao.Dao;
import com.hand.dao.impl.DaoImpl;
import com.opensymphony.xwork2.ActionSupport;

public class EditAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String firstName;

	private String lastName;

	private String email;

	private String address;
	
	private int customerId;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String edit() {
		Dao dao = new DaoImpl();
		int id = dao.getAddressId(address);
		dao.update(firstName, lastName, email, id, customerId);
		System.out.println("update " + firstName + " end......");
		return "success";
	}

	public void validate() {
		// TODO Auto-generated method stub
		System.out.println(firstName + "//" + lastName + "//" + email + "//" + address);
		if (firstName == null || firstName.trim().equals("")) {
			addFieldError("firstName", "The firstName is required");
		}
		if (lastName == null || lastName.trim().equals("")) {
			addFieldError("lastName", "lastName is required");
		}
		if (email == null || email.trim().equals("")) {
			addFieldError("email", "email is required");
		}
		if (address == null || address.trim().equals("")) {
			addFieldError("address", "address is required");
		}
	}
}
