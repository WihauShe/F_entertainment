package com.server;

import java.util.ArrayList;

import com.dao.ReportDao;
import com.entity.Report;

public class ReportServer {
	ReportDao reportDao = new ReportDao();
	
	public boolean addReport(Report report){
		boolean result = false;
		try {
			result = reportDao.addReport(report.getContentId(), report.getType())>0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	public boolean deleteReportById(Integer id){
		boolean result = false;
		try {
			result = reportDao.deleteReportById(id)>0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	public Report getReportById(int id){
		Report report = null;
		try {
			report = reportDao.getReportById(id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return report;
	}
	public ArrayList<Report> getReportList(){
		ArrayList<Report> reportList = new ArrayList<Report>();
		try {
			reportList = reportDao.getReportList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return reportList;
	}
}
