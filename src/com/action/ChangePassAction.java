package com.action;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.server.UserServer;

public class ChangePassAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userEmail;
	private String code;
	private String userPassword;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		boolean result = false;
		String emailCode = (String)ActionContext.getContext().getSession().get("emailCode");
		if(emailCode.equals(code)&&!code.equals("")){
			UserServer userServer = new UserServer();
			if(userEmail.equals("noemail")){
				User user = (User)ActionContext.getContext().getSession().get("user");
				userEmail = user.getUserEmail();
			}
			if(userServer.changePwdByEmail(userEmail, userPassword)){
				ActionContext.getContext().getSession().remove("emailCode");
				result = true;
			}			
		}
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.getWriter().print(result);
		return null;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	
	
	
}
