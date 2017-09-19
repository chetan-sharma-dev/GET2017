package com.metacube.dbpojos;

public class Titles {
	private int titleId;
	private String titleName;
	private int subjectId;
	private int publisherId;

	public Titles(int titleId,String titleName,int subjectId,int publisherId){
		this.titleId=titleId;
		this.titleName=titleName;
		this.subjectId=subjectId;
		this.publisherId=publisherId;
	}
	public int getTitleId() {
		return titleId;
	}

	public void setTitleId(int titleId) {
		this.titleId = titleId;
	}

	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public int getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}

	public String toString(){
		return titleId+"\t\t"
				+ titleName+"\t\t"
						+ subjectId+"\t\t\t"
								+publisherId +"\t\t";
	}

}
