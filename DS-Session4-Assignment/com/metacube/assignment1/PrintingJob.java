package com.metacube.assignment1;
/**
 * @class
 * class for printing Job description
 * */
public class PrintingJob {
	private String requesterType;
	private int requesterSequenceNo;
	private String requesterDocumentDataToPrint;
	private int requesterJobPriority;
	/**
	 * @constructor 
	 * initializing all values
	 * */
	public PrintingJob() {
		this.requesterType=null;
		this.requesterSequenceNo=0;
		this.requesterDocumentDataToPrint=null;
		this.requesterJobPriority=0;
	}
	public PrintingJob( String requesterType, int requesterSequenceNo,String requesterDocumentDataToPrint,int requesterJobPriority) {
		this.requesterType=requesterType;
		this.requesterSequenceNo=requesterSequenceNo;
		this.requesterDocumentDataToPrint=requesterDocumentDataToPrint;
		this.requesterJobPriority=requesterJobPriority;
	}

	/**
	 * Getter and Setter Method  
	 * */
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
	/**
	 * @method toString()
	 * method converting required information 
	 * */
	public String toString(){
		return "----------------------------------------------------------\n"
				+ "Sequence No :"+requesterSequenceNo+"\n"
				+ "Request Type :"+requesterType+"\n"
						+ "Job Priority :"+requesterJobPriority+"\n"
								+ "Document Data :"+requesterDocumentDataToPrint+"\n"
										+ "-------------------------------------------------------";
	}
}
