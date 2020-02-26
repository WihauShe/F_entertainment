package com.action;

import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;

import com.entity.Music;
import com.opensymphony.xwork2.ActionSupport;
import com.server.MusicServer;
import com.server.UserServer;

public class DeleteMusicAction extends ActionSupport{

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
		UserServer userServer = new UserServer();
		Music music = musicServer.getMusicById(musicId);
		if(musicServer.deleteMusicById(musicId)){
			userServer.minusCreditByEmail(music.getUserEmail());
			result = true;
		}
		
		HttpServletResponse resp = ServletActionContext.getResponse() ;
		resp.setCharacterEncoding("utf-8") ;
		resp.getWriter().print(result) ;
		return null;
	}

	public int getJokeId() {
		return musicId;
	}

	public void setJokeId(int musicId) {
		this.musicId = musicId;
	}
	
}
