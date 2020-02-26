package com.action;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.entity.Joke;
import com.entity.Music;
import com.entity.User;
import com.opensymphony.xwork2.ActionSupport;
import com.server.JokeServer;
import com.server.MusicServer;
import com.server.UserServer;

public class FileUploadActiion extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private File music;
	private String musicFileName;
	private String joke;
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
        Map<String, Object> session = ServletActionContext.getContext().getSession();
        User user = (User)session.get("user");
        UserServer userServer = new UserServer();
        if(music!=null){
	        //获取要保存文件夹的物理路径(绝对路径)
	        String realPath=ServletActionContext.getServletContext().getRealPath("/musics");
	        File file = new File(realPath);
	        
	        //测试此抽象路径名表示的文件或目录是否存在。若不存在，创建此抽象路径名指定的目录，包括所有必需但不存在的父目录。
	        if(!file.exists()) file.mkdirs();
	        System.out.println(realPath);
	        try {
	            //保存文件
	            FileUtils.copyFile(music, new File(file,musicFileName));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        Music newmusic = new Music();
	        MusicServer musicServer = new MusicServer();
	        newmusic.setName(musicFileName);
	        String path = "musics".concat("/"+musicFileName);
	        newmusic.setPath(path);
	        newmusic.setUserEmail(user.getUserEmail());
	        if(!musicServer.addMusic(newmusic)){
	        	return ERROR;
	        }else {
				userServer.addCreditByEmail(user.getUserEmail());
			}
        }
        if(!joke.equals("")){
        	JokeServer jokeServer = new JokeServer();
        	Joke newJoke = new Joke();
        	newJoke.setContent(joke);
        	newJoke.setUserEmail(user.getUserEmail());
        	if(!jokeServer.addJoke(newJoke)){
        		return ERROR;
        	}else {
				userServer.addCreditByEmail(user.getUserEmail());
			}
        }
		return SUCCESS;
	}
	
	public void setMusic(File music){
		this.music = music;
	}
	public File getMusic(){
		return music;
	}
	public void setMusicFileName(String musicFileName){
		this.musicFileName = musicFileName;
	}
	public String getMusicFileName(){
		return musicFileName;
	}
	public void setJoke(String joke){
		this.joke = joke;
	}
	public String getJoke(){
		return joke;
	}
	
}
