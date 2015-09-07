package com.hand.action;

import com.opensymphony.xwork2.ActionSupport;

public class JumpAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String success() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("------Jump------");
		return SUCCESS;
	}

}
