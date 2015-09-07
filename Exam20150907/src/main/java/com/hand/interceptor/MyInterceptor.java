package com.hand.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class MyInterceptor extends AbstractInterceptor{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("start for intercept......");
		
		Map session = (Map) ActionContext.getContext().getSession();
		String name = (String) session.get("user");
		
		if(name!=null){
			System.out.println("------"+name+"提交请求------");
			String result = arg0.invoke();
			System.out.println("end for intercept......");
			return result;
		}else{
			System.out.println("------没有登录，返回登录页面------");
			System.out.println("end for intercept......");
			return com.opensymphony.xwork2.Action.LOGIN;
		}
		
	}

}
