package com.metacube.arraylist;
import java.util.Iterator;

import com.metacube.enums.SortingOrder;
import com.metacube.listinterface.List;
import com.metacube.myutil.InitializationConstants;

@SuppressWarnings("rawtypes")
public class ArrayList<E extends Comparable> implements List<E> {
	private E[] dataArray;
	private int currentLocation;
	private static final int FIXED_SIZE = 5;
	/**
	 * @constructor  initializing data members
	 * */
	@SuppressWarnings("unchecked")
	public ArrayList() {
		dataArray = (E[]) new Comparable[FIXED_SIZE];
		this.currentLocation = InitializationConstants.INITIALIZE_WITH_NEGATIVE1;
	}
	/**
	 * @method size()
	 * return size of ArrayList
	 * */
	@Override
	public int size() {
		return this.currentLocation + 1;
	}
	/**
	 * @method add()
	 * method add element Of generic type in List
	 * if array size become full,resize array,else add element
	 * */
	public boolean add(E elementValue){
		if(dataArray.length==currentLocation+1)
			{	
				resizeArray();		
			}
		dataArray[++currentLocation]=elementValue;	
		return true;
	}
	
	/**
	 * @method add(int index,E elementValue)
	 * method for adding element in array at specified position
	 * where position starts from zero
	 * */
	public void add(int index,E elementValue){
		/*
		 * if last location entered then resize and then enter the element
		 * else if index is out of range from size of array throwing Exception  
		 * */
		if(currentLocation+1==index)
		{
			resizeArray();
		}
		else if(currentLocation+1<index){
			throw new IndexOutOfBoundsException("Error:entered index is not in range");
		}
		/*
		 * adding array elements at specified location
		 * coping left elements, inserting the element then coping remaining elements 
		 * */
		@SuppressWarnings("unchecked")
		E[] newDataArray=(E[]) new Comparable[dataArray.length];
		System.arraycopy(dataArray,	0 , newDataArray, 0, index);
		newDataArray[index]=elementValue;
		System.arraycopy(dataArray,	index , newDataArray, index+1,currentLocation-index+1);
		/*
		 * updating actual array reference and location variable
		 * */
		dataArray=newDataArray;
		currentLocation++;
	}
	
	/**
	 * @method resizeArray()
	 * method resizing array with just half additional length
	 * and copying array as it is in new array,
	 * updating old array reference with newArray reference  
	 * */
	public void resizeArray(){
		@SuppressWarnings("unchecked")
		E[] newDataArray=(E[]) new Comparable[dataArray.length+dataArray.length/2];
		System.arraycopy(dataArray, 0, newDataArray, 0, dataArray.length);
		dataArray=newDataArray;
	}
	
	/**
	 * @method indexOf(E element)
	 * method return index of list item
	 * if list doesn't contain any element then return -1
	 * else return that element index in list
	 * */
	public int indexOf(E element)
	{
		for(int i=0;i<=currentLocation;i++)
		{
			if(element==dataArray[i])
			{
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * @method reomve(int index)
	 * method for removing element from given index
	 * if invalid index entered ,then throwing exception to user console
	 * @return deletedElement 
	 * */
	public E remove(int index)
	{
		E deletedElement;
		if(currentLocation<index&&index<0){
			throw new IndexOutOfBoundsException();
		}else
		{	
			/*
			 * shifting array values one place left from the index,
			 * where we are deleting element 
			 * */
			deletedElement=dataArray[index];
			System.arraycopy(dataArray,	index+1 , dataArray, index,currentLocation-index);
			currentLocation--;	
		}
		
		return deletedElement;
	}
	/**
	 * @method remove(E element)
	 * overridden method for removing element from element value 
	 * @return true, if element successfully removed 
	 * else return false
	 * */
	public boolean remove(E element)
	{
		int index=indexOf(element);
		if(index!=-1)
			{
				remove(index);
				return true;
			}
		else
		{
			return false;
		}
	}
	
	/**
	 * @method get(int index)
	 * method for getting element from given index in list
	 * @return E, generic type data
	 * if entered index not in valid range , throwing Exception
	 * */
	public E get(int index) 
	{
		if(index>=0&&index<=currentLocation)
		{	
			return dataArray[index];
		}
		else
		{
			throw new IndexOutOfBoundsException("Invalid index no entered");
		}
	}
	/**
	 * @method reverse()
	 * method for reversing list 
	 * */
	public void reverse(){
		/**
		 * for half loop we are swapping elements from the respective location element after reversing 
		 * */
		for(int i=0;i<=currentLocation/2;i++)
		{
			swap(i,currentLocation-i);
		}	
	}
	/**
	 * @method swap(int i,int j)
	 * swapping given index data in array list
	 * */
	private void swap(int i,int j)
	{
		E temp=dataArray[i];
		dataArray[i]=dataArray[j];
		dataArray[j]=temp;
		
	}
	
	/**
	 * @method getList()
	 * this method return array
	 * */
	public E[] getList(){
		return dataArray;
	}
	
	/**
	 * @method clear()
	 * method clearing list
	 * */
	@SuppressWarnings("unchecked")
	public void clear()
	{
		currentLocation=0;
		dataArray= (E[]) new Comparable[0];
		currentLocation=-1;
	}
	
	/**
	 * @method iterator()
	 * this method is to iterate the list 
	 * has it's local methods named as hasNext() and nexr()
	 * */
	@Override
	public Iterator<E> iterator() {
		
		return new Iterator<E>() {
				
			int index = 0;

			@Override
			public boolean hasNext() {
			return index <= currentLocation;
			}

			@Override
			public E next() {
			return (E) dataArray[index++];
			}
		};
	}
	/**
	 * @method indexAfterPosition(E element, int i)
	 * searching occurrence index after of given element after given index
	 * if invalid index passed , Exception thrown 
	 * else returning location if element found else returning -1
	 * */
	@Override 
	public int indexAfterPosition(E element, int index) {
		if(index<currentLocation)
		{
			for(int j=index+1;j<=currentLocation;j++)
			{
				if(element==dataArray[j])
				{
						return j;	
				}
			}
		}
		else 
		{
			throw new IndexOutOfBoundsException("");
		}
	
		return -1;
	}
	
	/**
	 * @method addList(List<E> secondList)
	 *  method for adding list in another list 
	 * */
	@Override
	public void addList(List<E> secondList) {
		int totalElements = this.size() + secondList.size();
		/*
		 * resize array until have total element size array
		 * */
		while (totalElements > dataArray.length) {
			resizeArray();
		}
		/**
		 * now copy the second string  
		 */
		int firstListLength = size();
		E[] secondDataArray = (E[]) secondList.getList();
		for (int index = firstListLength; index < totalElements; index++) {
			dataArray[index] = secondDataArray[index - firstListLength];
		}
		this.currentLocation = totalElements - 1;

	}

	/**
	 * @method sort()
	 * method for sorting arrayList
	 * */
	@SuppressWarnings("unchecked")
	public void sort(SortingOrder sortingOrder) {
		switch(sortingOrder)
		{
		case Ascending:
			for (int firstIndex = 0; firstIndex < size(); firstIndex++) {
				for (int nextIndex = firstIndex + 1; nextIndex < size(); nextIndex++) {
					if (((Comparable<E>) dataArray[firstIndex]).compareTo(dataArray[nextIndex]) > 0) {
						swap(firstIndex, nextIndex);
					}
				}
			}
			break;
		case Descending:
			for (int firstIndex = 0; firstIndex < size(); firstIndex++) {
				for (int nextIndex = firstIndex + 1; nextIndex < size(); nextIndex++) {
					if (((Comparable<E>) dataArray[firstIndex]).compareTo(dataArray[nextIndex]) < 0) {
						swap(firstIndex, nextIndex);
						}
				}
			}
			break;
		}
		
	}

}
