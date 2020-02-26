package com.entity;

public class Report {
	private Integer id;
	private Integer contentId;
	private String type;
	
	public Report(){
		
	}
	public Report(Integer id, Integer contentId, String type) {
		super();
		this.id = id;
		this.contentId = contentId;
		this.type = type;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getContentId() {
		return contentId;
	}
	public void setContentId(Integer contentId) {
		this.contentId = contentId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
