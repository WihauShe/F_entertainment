package com.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.entity.Joke;
import com.entity.Music;
import com.entity.Report;
import com.entity.Result;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.server.JokeServer;
import com.server.MusicServer;
import com.server.SearchServer;

public class SearchResultAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String flag;
	private ArrayList<Music> musics;
	private ArrayList<Joke> jokes;
	private List<Result> results;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		MusicServer musicServer = new MusicServer();
		JokeServer jokeServer = new JokeServer();
		SearchServer searchServer = new SearchServer();
		setMusics(musicServer.getMusicList());
		setJokes(jokeServer.getJokeList());
		setResults(searchServer.searchResults(flag));
		ActionContext.getContext().put("jokes", jokes);
		ActionContext.getContext().put("results", results);
		return SUCCESS;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
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
	public List<Result> getResults() {
		return results;
	}
	public void setResults(List<Result> results) {
		this.results = results;
	}
	
}
