package com.metacube.sort;

import java.util.ArrayList;
import java.util.List;

public class BubbleSort<E extends Comparable<E>> {

	public List<E> sortList(List<E> list){
		for(int i=0;i<list.size()-1;i++)
		{
			for(int j=0;j<list.size()-i-1;j++)
			{
				if(list.get(j).compareTo(list.get(j+1))>0)
				{
					swap(list,j,j+1);
				}
				
			}
		}
		return list;
	}
	public void swap(List<E> list ,int i,int j){
		E temp=list.get(i);
		list.set(i,list.get(j));
		list.set(j,temp);	
	}
	
	
	public static void main(String[] args) {
		List<Integer> list=new ArrayList<Integer>();
		BubbleSort<Integer> bubObject=new BubbleSort<Integer>();
		
		list.add(2);
		list.add(10);
		list.add(5);
		list.add(20);
		list.add(6);
		System.out.println(list);
		System.out.println(bubObject.sortList(list));
		
	}
}

