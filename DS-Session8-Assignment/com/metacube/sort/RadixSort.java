package com.metacube.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class RadixSort {
	public List<Integer> sortList(List<Integer> list){
		if(list.size()>0)
		{
			int maxElement=Collections.max(list);
			int noOfDigitInMaxElement=getNoOfDigits(maxElement);
			int modulusFactor=10;
			for(int i=0;i<noOfDigitInMaxElement;i++){
				list=sort(list,modulusFactor);
				modulusFactor*=10;
			}
		}
		return list;
	}

	public List<Integer> sort(List<Integer> list,int modulusFactor){
		List[]  bucket = new List[10];
		List<Integer> listObject;
		Iterator<Integer> itr=list.iterator();
		int divisionFactor=modulusFactor/10;
		while(itr.hasNext()){
			int number=itr.next();
			int digit=(number%modulusFactor)/divisionFactor;
			if(bucket[digit]==null){
				listObject=new ArrayList<Integer>();
				listObject.add(number);
				bucket[digit]=listObject;
			}else{
				bucket[digit].add(number);
			}
		}
		List<Integer> updatedNewList=new ArrayList<Integer>();
		for(int i=0;i<bucket.length;i++){
			if(bucket[i]!=null){
				listObject=bucket[i];
				itr=listObject.iterator();
				while(itr.hasNext()){
					updatedNewList.add(itr.next());
				}
			}
		}
		return updatedNewList;
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
	
	public int getNoOfDigits(int number){
		return String.valueOf(number).length();
	}
	public static void main(String[] args) {
		List<Integer> list=new ArrayList<Integer>();
		list.add(0);
		list.add(-12345);
		list.add(53);
		list.add(-2);
		list.add(1);
		RadixSort r=new RadixSort();
		System.out.println(r.sort(list));
		
	}

}
