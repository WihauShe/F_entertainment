package com.interceptor;

import java.util.Map;

import com.entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		ActionContext context = arg0.getInvocationContext();
		Map<String, Object> session = context.getSession();
		User user = (User)session.get("user");
		if(user==null){
			return "login";
		}
		
		return arg0.invoke();
	}
	
}
