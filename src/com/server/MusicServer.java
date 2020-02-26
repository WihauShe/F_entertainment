package com.server;


import java.util.ArrayList;

import com.dao.MusicDao;
import com.entity.Music;

public class MusicServer {
	MusicDao musicDao = new MusicDao();
	
	public boolean addLikeById(Integer id){
		boolean result = false;
		try {
			result = musicDao.addLikeById(id)>0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	public Music getMusicById(int id){
		Music music = null;
		try {
			music = musicDao.getMusicById(id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return music;
	}
	public boolean addMusic(Music music){
		boolean result = false;
		try {
			result = musicDao.addMusic(music.getName(), music.getPath(), music.getUserEmail())>0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	public boolean deleteMusicById(Integer id){
		boolean result = false;
		try {
			result = musicDao.deleteMusicById(id)>0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	public ArrayList<Music> getMusicList(){
		ArrayList<Music> musicList = new ArrayList<Music>();
		try {
			musicList = musicDao.getMusicList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return musicList;
	}
}
