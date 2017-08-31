package com.metacube.sort;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CountingSort {
	List<Integer> frequencyCountingList;
	List<Integer> resultIndexList;
	List<Integer> uniqueValuesOfList;
	
	public CountingSort() {
		//frequencyCountingList=Arrays.asList(new Integer[100]);
	//	resultIndexList=Arrays.asList(new Integer[100]);
	//	uniqueValuesOfList=new ArrayList<Integer>();
	}
	public void initializeAllList(){
		frequencyCountingList=Arrays.asList(new Integer[100]);
		resultIndexList=Arrays.asList(new Integer[100]);
		uniqueValuesOfList=new ArrayList<Integer>();
		
	}
	
	public void initializeFrequencyCountingList(List<Integer> list){
		Iterator<Integer> itr=list.iterator();
		while(itr.hasNext()){
			int element=itr.next();
			if(frequencyCountingList.get(element)==null){
				frequencyCountingList.set(element,1);
			}else{
				frequencyCountingList.set(element,frequencyCountingList.get(element)+1);
			}
			if(!uniqueValuesOfList.contains(element)){
				uniqueValuesOfList.add(element);
			}
		}
		
		Collections.sort(uniqueValuesOfList);
	}
	
	public void initializeResultIndexList(){
		Iterator<Integer> itr=uniqueValuesOfList.iterator();
		int previousElementPosition=0;
		while(itr.hasNext()){
				int element=itr.next();
				resultIndexList.set(element, frequencyCountingList.get(element)+previousElementPosition);
				previousElementPosition+=frequencyCountingList.get(element);
				
		}
	}
	
	public List<Integer> sortList(List<Integer> list){
		initializeAllList();
		initializeFrequencyCountingList(list);
		initializeResultIndexList();
		
	
		Iterator<Integer> itr=list.iterator();
		List<Integer> sortedList=Arrays.asList(new Integer[list.size()]);
		while(itr.hasNext()){
			int element=itr.next();
			resultIndexList.set(element, resultIndexList.get(element)-1);
			sortedList.set(resultIndexList.get(element),element);
			
		}
		return sortedList;
	}
	
	
	public List<Integer> sort(List<Integer> list){
		
		List<Integer> listOfNegativeNumberValuesOnly=new ArrayList<Integer>();
		List<Integer> listOfPositiveValues=new ArrayList<Integer>();
		List<Integer> finalSortedList=new ArrayList<Integer>();
		
		Iterator<Integer> itr=list.iterator();
		while(itr.hasNext()){
			int element=itr.next();
			if(element<0){
				listOfNegativeNumberValuesOnly.add(-1*element);
			}else{
				listOfPositiveValues.add(element);
			}
		}
		
		listOfNegativeNumberValuesOnly=sortList(listOfNegativeNumberValuesOnly);
		Collections.reverse(listOfNegativeNumberValuesOnly);
		itr=listOfNegativeNumberValuesOnly.iterator();
		while(itr.hasNext()){
			finalSortedList.add(-1*itr.next());
		}
		finalSortedList.addAll(sortList(listOfPositiveValues));
		
		return finalSortedList;
	}
	public static void main(String[] args) {
		CountingSort c=new CountingSort();
		List<Integer> list=new ArrayList<Integer>();
		list.add(2);
		list.add(10);
		list.add(5);
		list.add(2);
		list.add(6);
	
		System.out.println(c.sortList(list).toString());
	}
}
