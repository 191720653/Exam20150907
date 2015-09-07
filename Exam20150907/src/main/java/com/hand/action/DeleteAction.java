package com.hand.action;

import com.hand.dao.Dao;
import com.hand.dao.impl.DaoImpl;

public class DeleteAction {
private int id;

	public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

	public String delete() {
		Dao dao = new DaoImpl();
		dao.delete(id);
		System.out.println("delete end......");
		return "success";
	}
}
