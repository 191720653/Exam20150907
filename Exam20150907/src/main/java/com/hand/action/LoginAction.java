package com.hand.action;

import java.util.Map;

import com.hand.dao.Dao;
import com.hand.dao.impl.DaoImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	private Dao dao;

	private String user;
	private String password;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public String login() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(user + "/" + password);
		dao = new DaoImpl();
		String name = dao.checkCustomer(user, password);
		if (name == null) {
			System.out.println("------用户名或者密码错误！------");
			return LOGIN;
		} else {
			Map session = (Map) ActionContext.getContext().getSession();
			session.put("user", name);
			System.out.println("------" + name + "登陆成功！------");
			return SUCCESS;
		}
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void validate() {
		// TODO Auto-generated method stub
		System.out.println(user + "//" + password);
		if (user == null || user.trim().equals("")) {
			addFieldError("user", "The user is required");
		}
		if (password == null || password.trim().equals("")) {
			addFieldError("password", "password is required");
		}
	}

}
