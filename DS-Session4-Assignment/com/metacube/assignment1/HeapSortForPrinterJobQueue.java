package com.metacube.assignment1;
/**
 * @class 
 * class responsible for sorting printing job pool entries  by applying heap sort 
 * */
public class HeapSortForPrinterJobQueue {
	private PrintingJob[] printerJobQueue;
	private int currentSequenceNo;
	
	
	public HeapSortForPrinterJobQueue( PrintingJob[] printerJobQueue,int currentSequenceNo){
		this.printerJobQueue=printerJobQueue;
		this.currentSequenceNo=currentSequenceNo;
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
	public PrintingJob[] heapSort(){
		/*
		 * first build heap, then do print Job queue ,lower currentSequenceNo by 1
		 * heapifyJobQueue at node 0
		 * */
		buildHeap();
		
		for(int i=currentSequenceNo-2;i>=0;i--){
			swap(0,i);
			currentSequenceNo--;
			heapifyJobQueue(0);
		}
		return printerJobQueue;
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
