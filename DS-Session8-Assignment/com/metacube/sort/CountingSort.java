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
	
	public void initializeAllList(int listSize){
		frequencyCountingList=Arrays.asList(new Integer[listSize]);
		resultIndexList=Arrays.asList(new Integer[listSize]);
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
	
	public void initializeResultIndexList() {
		Iterator<Integer> itr = uniqueValuesOfList.iterator();
		int previousElementPosition = 0;
		while (itr.hasNext()) {
			int element = itr.next();
			resultIndexList.set(element, frequencyCountingList.get(element)+ previousElementPosition);
			previousElementPosition += frequencyCountingList.get(element);

		}
	}

	public List<Integer> sortList(List<Integer> list) {
		initializeAllList(Collections.max(list) + 1);
		initializeFrequencyCountingList(list);
		initializeResultIndexList();

		Iterator<Integer> itr = list.iterator();
		List<Integer> sortedList = Arrays.asList(new Integer[list.size()]);
		while (itr.hasNext()) {
			int element = itr.next();
			resultIndexList.set(element, resultIndexList.get(element) - 1);
			sortedList.set(resultIndexList.get(element), element);

		}
		return sortedList;
	}

	public List<Integer> sort(List<Integer> list) {

		int minimumNumber = Collections.min(list);
		if(minimumNumber<0){
			minimumNumber=Math.abs(minimumNumber);
				Iterator<Integer> itr = list.iterator();
				int currentIndex = 0;
				while (itr.hasNext()) {
					int element = itr.next();
					list.set(currentIndex++, element + minimumNumber);
				}
				list = sortList(list);
		
				itr = list.iterator();
				currentIndex = 0;
				while (itr.hasNext()) {
					int element = itr.next();
		
					list.set(currentIndex++, element - minimumNumber);
				}
		}else{
			list = sortList(list);
		}
		return list;
	}
	
	public static void main(String[] args) {
		CountingSort c=new CountingSort();
		List<Integer> list=new ArrayList<Integer>();
		list.add(1232);
		list.add(150);
		list.add(5);
		list.add(250);
		list.add(6);

		System.out.println(c.sort(list).toString());
	}
}
