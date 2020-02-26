package com.action;

import java.util.ArrayList;

import com.entity.Joke;
import com.entity.Music;
import com.entity.Report;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.server.JokeServer;
import com.server.MusicServer;
import com.server.ReportServer;

public class EnterAdminAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Music> musics;
	private ArrayList<Joke> jokes;
	private ArrayList<Report> reports;
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		MusicServer musicServer = new MusicServer();
		JokeServer jokeServer = new JokeServer();
		ReportServer reportServer = new ReportServer();
		setMusics(musicServer.getMusicList());
		setJokes(jokeServer.getJokeList());
		setReports(reportServer.getReportList());
		ActionContext.getContext().put("jokes", jokes);
		ActionContext.getContext().put("reports", reports);
		return SUCCESS;
	}
	
	public ArrayList<Music> getMusics() {
		return musics;
	}

	public void setMusics(ArrayList<Music> musics) {
		this.musics = musics;
	}
	public ArrayList<Joke> getJokes() {
		return jokes;
	}

	public void setJokes(ArrayList<Joke> jokes) {
		this.jokes = jokes;
	}

	public ArrayList<Report> getReports() {
		return reports;
	}

	public void setReports(ArrayList<Report> reports) {
		this.reports = reports;
	}
}
