package com.hand.action;

import com.opensymphony.xwork2.ActionSupport;

public class LocaleAction extends ActionSupport {
	public String getForwardJsp() {
		return forwardJsp;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String forwardJsp = "index.jsp";

	public String index() {
		System.out.println("------coming here for change language------");
		return "forwardJsp";
	}
}
