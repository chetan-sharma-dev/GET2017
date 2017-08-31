package com.metacube.sort;

import java.util.ArrayList;
import java.util.List;

public class QuickSort<E extends Comparable<E>>{

	public List<E> sortList(List<E> list){
		quickSort(list, 0, list.size()-1);
		return list;
	}
	
	public void quickSort(List<E> list, int startIndex,int endIndex){
		
		if(startIndex<endIndex){
			
			int partitionIndex=partition(list,startIndex,endIndex);
			
			quickSort(list, startIndex, partitionIndex-1);
			quickSort(list, partitionIndex+1, endIndex);
			
		}
		
	}
	
	public int partition(List<E> list,int startIndex,int endIndex){
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
	
	public void swap(List<E> list ,int i,int j){
		E temp=list.get(i);
		list.set(i,list.get(j));
		list.set(j,temp);	
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
		System.out.println(quickObject.sortList(list));
		
	}
}
