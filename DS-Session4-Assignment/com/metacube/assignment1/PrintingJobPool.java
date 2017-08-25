package com.metacube.assignment1;
import java.util.HashMap;
import java.util.Map;


public class PrintingJobPool {
	private Job[] printerJobQueue;
	private int currentSequenceNo;
	private Map<Integer, String> priorityMap;
	
	public PrintingJobPool() {
		printerJobQueue=new Job[10];
		this.currentSequenceNo=1;
		priorityMap=new HashMap<Integer, String>();
		priorityMap.put(1,"UNDER GRADUATE");
		priorityMap.put(2,"GRADUATE STUDENT");
		priorityMap.put(3,"PROFESSOR");
		priorityMap.put(4,"DEPARTMENT CHAIR");
	}
	
	public void requestPrint(String documentData,int requesterChoiceInput)
	{
		
		Job jobObject=new Job(priorityMap.get(requesterChoiceInput),this.currentSequenceNo,documentData,requesterChoiceInput);
		this.printerJobQueue[this.currentSequenceNo-1]=jobObject;
		maxHeap(currentSequenceNo-1);
		currentSequenceNo++;
		//System.out.println(documentData+","+requesterChoiceInput+","+priorityMap.get(requesterChoiceInput));
		
	}
	public void maxHeap(int i){
		for(int j=i;j>=0;j--)
		{
			heapifyJobQueue(j);
		}
	}
	public void heapifyJobQueue(int i){
		
		if(i>=0){
				int leftChildIndex=2*i+1;
				int rightChildIndex=2*i+2;
				int higherPriorityJobIndex;
				
				if(leftChildIndex<currentSequenceNo&&(printerJobQueue[leftChildIndex].getRequesterJobPriority()>printerJobQueue[i].getRequesterJobPriority())){
					higherPriorityJobIndex=leftChildIndex;
				}else{
					higherPriorityJobIndex=i;
				}
		
				if(rightChildIndex<currentSequenceNo&&(printerJobQueue[rightChildIndex].getRequesterJobPriority()>printerJobQueue[i].getRequesterJobPriority())){
					higherPriorityJobIndex=rightChildIndex;
				}
				
				if(higherPriorityJobIndex!=i)
				{
					swap(higherPriorityJobIndex, i);
					//higherPriorityJobIndex=i;
					heapifyJobQueue(higherPriorityJobIndex);
					
				}
				
					
			}
		else{
			System.out.println("nothing");
				return;
		}
	}
	public void printAllJobs(){
		for(int i=0;i<currentSequenceNo-1;i++)
		{
			Job temp=printerJobQueue[0];
			printerJobQueue[0]=printerJobQueue[currentSequenceNo-1];
			currentSequenceNo--;
			System.out.println(temp.toString());
			maxHeap(currentSequenceNo);
			
			
		}
	}
	public void swap(int index1,int index2){
		Job temp=printerJobQueue[index1];
		printerJobQueue[index1]=printerJobQueue[index2];
		printerJobQueue[index2]=temp;
	}
}
