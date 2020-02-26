package com.action;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.server.SendEmailServer;

public class SendCodeAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userEmail;
	 
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		boolean result = false;
		try{
			if(userEmail.equals("noemail")){
				User user = (User)ActionContext.getContext().getSession().get("user");
				userEmail = user.getUserEmail();
			}
			System.out.println(userEmail);
			SendEmailServer sendEmailServer = new SendEmailServer();
			String code = String.valueOf((int)((Math.random()*9+1)*1000));
	        sendEmailServer.sendMail(userEmail, code);
	        ActionContext.getContext().getSession().put("emailCode", code);
	        System.out.println("SendSuccess"+code);
	        result = true;
	    } catch (MessagingException e) {
	        e.printStackTrace();
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

	 
}
