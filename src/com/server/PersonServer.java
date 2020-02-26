package com.server;

import com.dao.PersonDao;
import com.entity.Person;

public class PersonServer {
	PersonDao personDao = new PersonDao();
	
	public boolean insertSig(Person person){
		boolean result = false;
		try {
			result = personDao.insertPerson(person.getUserEmail(),person.getSignature())>0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	public String getSigByEmail(String userEmail){
		String signature = "";
		try {
			signature = personDao.getSigByEmail(userEmail);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return signature;
	}
	public Boolean updateSigByEmail(String userEmail,String signature){
		Boolean result = false;
		try {
			result = personDao.updateSigByEmail(userEmail, signature)>0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	public String getStatusByEmail(String userEmail){
		String userStatus = "";
		try {
			userStatus = personDao.getStatusByEmail(userEmail);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return userStatus;
	}
}
