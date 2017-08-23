package com.metacube.listinterface;

import com.metacube.enums.SortingOrder;

public interface List<E> extends Iterable<E> {

	/* methods for adding element in list by value and index */
	public boolean add(E element);
	public void add(int index,E element) throws IndexOutOfBoundsException;
	/**
	 * method for getting index of given element
	 * */
	public int indexOf(E element);
	/**
	 * method for getting the position of element after given location 
	 * if not found return IndexOutOfBound Exception
	 * */
	public int indexAfterPosition(E element, int i) throws IndexOutOfBoundsException;
	
	/**
	 * method to get element at given index 
	 * */
	public E get(int index) throws IndexOutOfBoundsException;
	
	/**
	 * method for deleting item from given position
	 * if invalid index entered exception thrown
	 */
	public E remove(int index) throws IndexOutOfBoundsException;
	/**
	 * method for removing element from given index
	 * */
	public boolean remove(E element);
	
	/**
	 * method for getting size of array list
	 * */
	public int size();
	/**
	 * method for clearing list
	 * */
	public void clear();
	/**
	 * method for reversing list
	 * */
	public void reverse();
	/**
	 * method for getting list
	 * */
	public E[] getList();
	/**
	 * method for sorting list according to given input  
	 * */
	public void sort(SortingOrder sortingOrder);
	/**
	 * appending list into one list 
	 * */
	public void addList(List<E> secondList);
}
