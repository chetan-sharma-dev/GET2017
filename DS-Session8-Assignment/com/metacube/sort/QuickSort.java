package com.metacube.sort;

import java.util.ArrayList;
import java.util.List;
/**
 * @class 
 * class for implementing Quick sort logic
 * */
public class QuickSort<E extends Comparable<E>>{

	/**
	 * @method sort()
	 * method for sorting given list
	 * @param inputList
	 * @return sortedList
	 * */
	public List<E> sort(List<E> list){
		if(list!=null){
			quickSort(list, 0, list.size()-1);
		}
		return list;
	}
	
	/**
	 * @method quickSort()
	 * method for sorting list using quick sort divide and conquer strategy recursively
	 * */
	private void quickSort(List<E> list, int startIndex,int endIndex){
		
		if(startIndex<endIndex){
			int partitionIndex=partition(list,startIndex,endIndex);
			quickSort(list, startIndex, partitionIndex-1);
			quickSort(list, partitionIndex+1, endIndex);
		}
	}
	
	/**
	 * @method partition()
	 * method dividing problem and returning some partition index 
	 * */
	private int partition(List<E> list,int startIndex,int endIndex){
		//partition logic of quick sort
		/**
		 * taking end element as pivot element and after all iteration of partition loop
		 * the pivot element reach at its right position 
		 * we return that position now recursively we have to apply quick sort on left sublist and right sublist
		 * */
		E pivotElement=list.get(endIndex);
		int storeIndex=startIndex-1;
		
		for(int i=startIndex;i<=endIndex-1;i++){
			if(list.get(i).compareTo(pivotElement)<=0){
				storeIndex++;
				swap(list,storeIndex,i);
			}
			
		}
		swap(list,storeIndex+1,endIndex);
		
		return storeIndex+1;
	}
	/**
	 * method for swapping list elements according to given indexs
	 * */
	private void swap(List<E> list ,int index1,int index2){
		E temp=list.get(index1);
		list.set(index1,list.get(index2));
		list.set(index2,temp);	
	}
	public static void main(String[] args) {
		List<Integer> list=new ArrayList<Integer>();
		QuickSort<Integer> quickObject=new QuickSort<Integer>();
		list.add(2);
		list.add(10);
		list.add(5);
		list.add(20);
		list.add(6);
		System.out.println(list);
		System.out.println(quickObject.sort(list));
		
	}
}
