package com.metacube.assignment1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @class PrintingJobPool
 * class for Printing Job Pool
 * */
public class PrintingJobPool {
	private PrintingJob[] printerJobQueue;
	private int currentSequenceNo;
	private Map<Integer, String> priorityMap;
	private final int PRINTER_MAX_BUFFER_SIZE=20;
	
	/**
	 * @constructor PrinterJobPool
	 * Initializing all variable
	 * */
	public PrintingJobPool() {
		/*
		 * fixed Heap Size
		 * */
		printerJobQueue=new PrintingJob[PRINTER_MAX_BUFFER_SIZE];
		this.currentSequenceNo=1;
		priorityMap=new HashMap<Integer, String>();
		priorityMap.put(1,"UNDER GRADUATE");
		priorityMap.put(2,"GRADUATE STUDENT");
		priorityMap.put(3,"PROFESSOR");
		priorityMap.put(4,"DEPARTMENT CHAIR");
	}
	/**
	 * @method requestPrint()
	 * method for generating printing request
	 * */
	public void requestPrint(String documentData,int requesterChoiceInput)
	{
		if(currentSequenceNo<=printerJobQueue.length)
		{
			PrintingJob jobObject=new PrintingJob(priorityMap.get(requesterChoiceInput),this.currentSequenceNo,documentData,requesterChoiceInput);
			this.printerJobQueue[this.currentSequenceNo-1]=jobObject;
			currentSequenceNo++;
		}else{
			System.out.println("Job Queue is Full");
		}
	}
	

	/**
	 * @method printAllJobs()
	 * method for printing all HeapVariables 
	 * */
	public List<String> getPrintOfAllJobs(){
		HeapSortForPrinterJobQueue heapSortObject=new HeapSortForPrinterJobQueue(printerJobQueue, currentSequenceNo);
		printerJobQueue=heapSortObject.heapSort();
		
		List<String> dataToPrint=new ArrayList<String>();
		
		for(int i=currentSequenceNo-2;i>=0;i--)
		{
			dataToPrint.add(printerJobQueue[i].toString());
		}
		/*
		 * if currentSequenceNo is 1 then there is nothing in JobQueue, so printing empty job pool message
		 * else updating current Sequence No with 1
		 * */
		if(currentSequenceNo==1){
			dataToPrint.add("------------------------------------------------");
			dataToPrint.add("No Job In Job Pool To Print");
			dataToPrint.add("------------------------------------------------");
			}else{
				currentSequenceNo=1;
		}
		return dataToPrint;
	}
	
	/**
	 * @method swap(index1,index2)
	 * method for swapping given index values in Job Queue 
	 * */
	private void swap(int index1,int index2){
		PrintingJob temp=printerJobQueue[index1];
		printerJobQueue[index1]=printerJobQueue[index2];
		printerJobQueue[index2]=temp;
	}
}
