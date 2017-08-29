package com.metacube.stack;
import myutil.InitializationConstants;

import com.metacube.node.Node;
/**
 * @class Stack
 * class implementing stack using linked list concept
 * */
public class Stack{
	@SuppressWarnings("rawtypes")
	private Node head;
	private int length;
	
	/**
	 * @constructor 
	 * initializing data members
	 * */
	public Stack(){
		head = null;
		length=InitializationConstants.INITIALIZE_WITH_ZERO;
	}
	
	/**
	 * @method size()
	 * method for getting size of array
	 * */
	public int size(){
		return length;
	}
	/**
	 * @method push()
	 * method for entering data in array
	 * */
	@SuppressWarnings("rawtypes")
	public boolean push(Object elementData){
		/**
		 * applying null check  
		 * */
		if (elementData != null && elementData.toString().length()!=0 ) {
			/**
			 * if valid data entered then we create new node object
			 * and then appending it into the list
			 * */
			@SuppressWarnings("unchecked")
			Node nodeObject = new Node(elementData);
			/**
			 * if head is null, adding node at head
			 * else, adding head next to current node then making current  node as head
			 * */
			if (head == null) {
				head = nodeObject;
			} else {
				nodeObject.setNextNode(head);
				head = nodeObject;
			}
			/*
			 * increasing length with one and returning true;
			 * */
			length++;
			return true;
		} else if(elementData.toString().length()==0){
				System.out.println("NO Item entered");
				return false;
		}else{
			throw new NullPointerException();
		}
	}
	/**
	 * @method   pop()
	 * method to pop values from stack
	 * */
	@SuppressWarnings("unchecked")
	public Object pop() throws IndexOutOfBoundsException
	{
		if(length==0)
		{
			throw new IndexOutOfBoundsException("Empty Stack");
		}else{
			Object poppedElement=head.getData();
			head=head.getNextNode();
			length--;
			return poppedElement;
		}
	}
	
	public Object getTopElement(){
		if(head==null)
		{
			return null;
		}
		else
		{
			return head.getData();
		}
		
	}
	
	
}
