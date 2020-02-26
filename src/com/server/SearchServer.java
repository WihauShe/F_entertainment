package com.server;

import java.util.ArrayList;
import java.util.List;

import com.dao.SearchDao;
import com.entity.Result;

public class SearchServer {
	SearchDao searchDao = new SearchDao();
	
	public List<Result> searchResults(String flag){
		List<Result> results = new ArrayList<Result>();
		try {
			results = searchDao.searchResults(flag);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return results;
	}
	
}
