package com.metacube.assignment1;
public class Job {
	private String requesterType;
	private int requesterSequenceNo;
	private String requesterDocumentDataToPrint;
	private int requesterJobPriority;
	
	public Job() {
		this.requesterType=null;
		this.requesterSequenceNo=0;
		this.requesterDocumentDataToPrint=null;
		this.requesterJobPriority=0;
	}
		
	public Job( String requesterType, int requesterSequenceNo,String requesterDocumentDataToPrint,int requesterJobPriority) {
		this.requesterType=requesterType;
		this.requesterSequenceNo=requesterSequenceNo;
		this.requesterDocumentDataToPrint=requesterDocumentDataToPrint;
		this.requesterJobPriority=requesterJobPriority;
	}

	public String getRequesterType() {
		return requesterType;
	}

	public void setRequesterType(String requesterType) {
		this.requesterType = requesterType;
	}

	public int getRequesterSequenceNo() {
		return requesterSequenceNo;
	}

	public void setRequesterSequenceNo(int requesterSequenceNo) {
		this.requesterSequenceNo = requesterSequenceNo;
	}

	public String getRequesterDocumentDataToPrint() {
		return requesterDocumentDataToPrint;
	}

	public void setRequesterDocumentDataToPrint(
			String requesterDocumentDataToPrint) {
		this.requesterDocumentDataToPrint = requesterDocumentDataToPrint;
	}

	public int getRequesterJobPriority() {
		return requesterJobPriority;
	}

	public void setRequesterJobPriority(int requesterJobPriority) {
		this.requesterJobPriority = requesterJobPriority;
	}

	public String toString(){
		return requesterSequenceNo+","+requesterType +","+requesterJobPriority+","+requesterDocumentDataToPrint;
	}
}
