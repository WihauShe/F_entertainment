package com.action;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.entity.Joke;
import com.entity.Music;
import com.entity.Report;
import com.opensymphony.xwork2.ActionSupport;
import com.server.JokeServer;
import com.server.MusicServer;
import com.server.ReportServer;
import com.server.UserServer;

public class DeleteReportAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int reportId;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		boolean result = false;
		ReportServer reportServer = new ReportServer();
		JokeServer jokeServer = new JokeServer();
		MusicServer musicServer = new MusicServer();
		UserServer userServer = new UserServer();
		Report report = null;
		report = reportServer.getReportById(reportId);
		if(report!=null){
			if(report.getType().equals("joke")){
				Joke joke = jokeServer.getJokeById(report.getContentId());
				if(joke!=null){
					jokeServer.deleteJokeById(report.getContentId());
					userServer.minusCreditByEmail(joke.getUserEmail());
				}
			}else if(report.getType().equals("music")){
				Music music = musicServer.getMusicById(report.getContentId());
				if(music!=null){
					musicServer.deleteMusicById(report.getContentId());
					userServer.minusCreditByEmail(music.getUserEmail());
				}
			}
			reportServer.deleteReportById(reportId);
			result = true;
		}
		HttpServletResponse resp = ServletActionContext.getResponse() ;
		resp.setCharacterEncoding("utf-8") ;
		resp.getWriter().print(result) ;
		return null;
	}

	public int getReportId() {
		return reportId;
	}

	public void setReportId(int reportId) {
		this.reportId = reportId;
	}
	
}

