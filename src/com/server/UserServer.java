package com.server;

import com.dao.UserDao;
import com.entity.User;

public class UserServer {
	UserDao userDao = new UserDao();
	
	public Boolean registerUser(User user){
		String userEmail = user.getUserEmail();
		String userPassword = user.getUserPassword();
		String userName = user.getUserName();
		String userSex = user.getUserSex();
		String birthDate = user.getBirthDate();
		boolean result = false;
		try {
			result = userDao.addUser(userEmail, userPassword, userName, userSex, birthDate)>0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} 
		return result;
	}
	public Boolean updateUser(User user){
		String userEmail = user.getUserEmail();
		String userName = user.getUserName();
		String userSex = user.getUserSex();
		String birthDate = user.getBirthDate();
		boolean result = false;
		try {
			result = userDao.updateUser(userEmail, userName, userSex, birthDate)>0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	public String getPwdByEmail(String userEmail){
		String userPassword = "";
		try {
			userPassword = userDao.getPwdByUserEmail(userEmail);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return userPassword;
	}
	public Boolean changePwdByEmail(String userEmail,String password){
		Boolean result = false;
		try {
			result = userDao.changePwdByUserEmail(userEmail, password)>0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	public int getCreditByEmail(String userEmail){
		int credit = 0;
		try {
			credit = userDao.getCreditByEmail(userEmail);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return credit;
	}
	public Boolean addCreditByEmail(String userEmail){
		Boolean result = false;
		try {
			result = userDao.addCreditByEmail(userEmail)>0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	public Boolean minusCreditByEmail(String userEmail){
		Boolean result = false;
		try {
			result = userDao.minusCreditByEmail(userEmail)>0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	public String getUserNameByEmail(String userEmail){
		String userName = "";
		try {
			userName = userDao.getUserNameByEmail(userEmail);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return userName;
	}
	public User getUserByEmail(String userEmail){
		User user = new User();
		try {
			user = userDao.getUserByEmail(userEmail);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return user;
	}
	public boolean testUserEmail(String userEmail){
		boolean result = false;
		try {
			result = userDao.testUserEmail(userEmail)>0;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
}
