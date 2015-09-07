package com.hand.action;

import java.util.List;

import com.hand.dao.Dao;
import com.hand.dao.impl.DaoImpl;
import com.hand.entity.Customer;

public class GetAddressAction {

	public List<String> list;

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public String getAddress() {
		Dao dao = new DaoImpl();
		list = dao.getAddress();
		System.out.println("getAddress end......");
		return "success";
	}
}
