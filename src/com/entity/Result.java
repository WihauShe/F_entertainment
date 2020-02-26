package com.entity;

public class Result {

	private Integer contentId;
	private String type;
	
	public Result(){
		
	}
	public Result( Integer contentId, String type) {
		super();
		this.contentId = contentId;
		this.type = type;
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
