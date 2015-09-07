package com.hand.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String logout() throws Exception {
		// TODO Auto-generated method stub
		Map session = (Map) ActionContext.getContext().getSession();
		String name = (String) session.get("user");
		System.out.println("------" + name + "退出成功！------");
		return LOGIN;
	}

}
