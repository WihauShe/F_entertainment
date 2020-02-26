package com.action;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.entity.Report;
import com.opensymphony.xwork2.ActionSupport;
import com.server.ReportServer;

public class AddJokeReportAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int jokeId;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		boolean result = false;
		ReportServer reportServer = new ReportServer();
		Report report = new Report();
		report.setContentId(jokeId);
		report.setType("joke");
		if(reportServer.addReport(report))
			result = true;
		HttpServletResponse resp = ServletActionContext.getResponse() ;
		
		resp.setCharacterEncoding("utf-8") ;
		resp.getWriter().print(result) ;
		return null;
	}
	
	public void setJokeId(int jokeId){
		this.jokeId  = jokeId;
	}
	public int getJokeId(){
		return jokeId;
	}
}

