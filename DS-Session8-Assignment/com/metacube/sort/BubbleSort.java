package com.metacube.sort;

import java.util.ArrayList;
import java.util.List;
/**
 * @class 
 * class for implementing Bubble sort logic
 * */
public class BubbleSort<E extends Comparable<E>> {

	/**
	 * @method sort()
	 * method for doing sorting using bubble sort algorithm
	 * @param takes generic list
	 * @return sorted list
	 * */
	public List<E> sort(List<E> list){
		/*
		 * checking null condition
		 */
		if(list!=null){
			/*
			 * binary sort logic 
			 */
			for(int i=0;i<list.size()-1;i++){
				for(int j=0;j<list.size()-i-1;j++)
				{
					if(list.get(j).compareTo(list.get(j+1))>0)
					{
						swap(list,j,j+1);
					}
					
				}
			}
		}
		return list;
	}
	/**
	 * @method swap()
	 * method for doing swapping in list at provided indexes 
	 * */
	private void swap(List<E> list ,int index1,int index2){
		E temp=list.get(index1);
		list.set(index1,list.get(index2));
		list.set(index2,temp);	
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
		System.out.println(bubObject.sort(list));
		
	}
}

