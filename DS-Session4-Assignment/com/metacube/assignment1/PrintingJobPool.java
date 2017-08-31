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
	 * @method heapifyJobQueue()
	 * */
	private void heapifyJobQueue(int i){
		/*
		 * if current node index is positive then iterate 
		 * */
		if(i>=0){
				int leftChildIndex=2*i+1;
				int rightChildIndex=2*i+2;
				int higherPriorityJobIndex;
				/*
				 * checking whether left child index is available in jobQueue or not 
				 * and comparing for their job Priorities,
				 * if job Priority is equal then compare according to sequence no,
				 * lower sequence no has more priority for same priority value
				 * */
				if(leftChildIndex<currentSequenceNo-1&&(printerJobQueue[leftChildIndex].getRequesterJobPriority()>=printerJobQueue[i].getRequesterJobPriority())){
					if(printerJobQueue[leftChildIndex].getRequesterJobPriority()==printerJobQueue[i].getRequesterJobPriority())
						{
							if(printerJobQueue[leftChildIndex].getRequesterSequenceNo()<printerJobQueue[i].getRequesterSequenceNo())
								{
									higherPriorityJobIndex=leftChildIndex;
								}
							else {
									higherPriorityJobIndex=i;
								}
						}else{
								higherPriorityJobIndex=leftChildIndex;
						}
				}else{
					higherPriorityJobIndex=i;
				}
		
				/*
				 * checking whether right child index is available or not
				 * and comparing job priority of right child indexed, higherPriorityIndexd Queue Priority Values
				 * if their priority is same then compare using their sequence no
				 * lower the sequence no , higher the priority
				 * */
				if(rightChildIndex<currentSequenceNo-1&&(printerJobQueue[rightChildIndex].getRequesterJobPriority()>=printerJobQueue[higherPriorityJobIndex].getRequesterJobPriority())){
					if(printerJobQueue[rightChildIndex].getRequesterJobPriority()==printerJobQueue[higherPriorityJobIndex].getRequesterJobPriority())
					{
						if(printerJobQueue[rightChildIndex].getRequesterSequenceNo()<printerJobQueue[higherPriorityJobIndex].getRequesterSequenceNo())
							higherPriorityJobIndex=rightChildIndex;
					}else{
							higherPriorityJobIndex=rightChildIndex;
					}
				}
				/*
				 * if higherPriorityIndex is updated then , swap the node values
				 * then again heapifyJobQueue
				 * */
				if(higherPriorityJobIndex!=i)
				{
					swap(higherPriorityJobIndex, i);
					heapifyJobQueue(higherPriorityJobIndex);
				}
			}
		else{
					return;
		}
	}
	
	/**
	 * @method buildHeap()
	 * method for building heap
	 * running from N/2 to 2 , lower the index by 1
	 * */
	private void buildHeap(){
		for(int i=(currentSequenceNo-1)/2;i>=0;i--){
			heapifyJobQueue(i);
		}
	}
	/**
	 * @method heapSort()
	 * method for sorting given array
	 * */
	private void heapSort(){
		/*
		 * first build heap, then do print Job queue ,lower currentSequenceNo by 1
		 * heapifyJobQueue at node 0
		 * */
		buildHeap();
		int seqNo=currentSequenceNo;
		for(int i=currentSequenceNo-2;i>=0;i--){
			swap(0,i);
			currentSequenceNo--;
			heapifyJobQueue(0);
		}
		currentSequenceNo=seqNo;
		System.out.println();
	}
	/**
	 * @method printAllJobs()
	 * method for printing all HeapVariables 
	 * */
	public List<String> getPrintOfAllJobs(){
		heapSort();
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
