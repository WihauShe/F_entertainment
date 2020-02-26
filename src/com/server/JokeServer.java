package com.server;

import java.util.ArrayList;
import com.dao.JokeDao;
import com.entity.Joke;

public class JokeServer {
	JokeDao jokeDao = new JokeDao();
	public boolean addLikeById(Integer id){
		boolean result = false;
		try {
			result = jokeDao.addLikeById(id)>0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	public Joke getJokeById(Integer id){
		Joke joke = null;
		try {
			joke = jokeDao.getJokeById(id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return joke;
	}
	public boolean addJoke(Joke joke){
		String content = joke.getContent();
		String userEmail = joke.getUserEmail();
		boolean result = false;
		try {
			result = jokeDao.addJoke(content, userEmail)>0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	public boolean deleteJokeById(Integer id){
		boolean result = false;
		try {
			result = jokeDao.deleteJokeById(id)>0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	public ArrayList<Joke> getJokeList(){
		ArrayList<Joke> jokeList = new ArrayList<Joke>();
		try {
			jokeList = jokeDao.getJokeList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return jokeList;
	}
	
}
