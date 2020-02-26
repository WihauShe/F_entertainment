package com.action;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.server.MusicServer;

public class AddMusicLikeAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int musicId;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		boolean result = false;
		MusicServer musicServer = new MusicServer();
		if(musicServer.addLikeById(musicId)){
			result = true;
		}
		HttpServletResponse resp = ServletActionContext.getResponse() ;
		
		resp.setCharacterEncoding("utf-8") ;
		resp.getWriter().print(result) ;
		return null;
	}
	
	public void setMusicId(int musicId){
		this.musicId  = musicId;
	}
	public int getMusicId(){
		return musicId;
	}
}
