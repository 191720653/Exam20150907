package com.hand.action;

import java.util.List;

import com.hand.dao.Dao;
import com.hand.dao.impl.DaoImpl;
import com.hand.entity.Customer;

public class GetCustomersAction {

	public List<Customer> list;

	public List<Customer> getList() {
		return list;
	}

	public void setList(List<Customer> list) {
		this.list = list;
	}

	public String getCustomers() {
		Dao dao = new DaoImpl();
		list = dao.getAllCustomer();
		System.out.println("end......");
		return "success";
	}
}
