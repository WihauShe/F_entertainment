package com.action;

import java.util.ArrayList;

import com.entity.Joke;
import com.entity.Music;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.server.JokeServer;
import com.server.MusicServer;

public class EnterIndexAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Music> musics;
	private ArrayList<Joke> jokes;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		MusicServer musicServer = new MusicServer();
		JokeServer jokeServer = new JokeServer();
		setMusics(musicServer.getMusicList());
		setJokes(jokeServer.getJokeList());
		ActionContext.getContext().put("jokes", jokes);
		
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

	

		
}
