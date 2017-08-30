package com.metacube.queue;

import java.util.Arrays;
/**
 * @class Queue 
 * class implementing queue tasks 
 * */
public class MyQueue <E> {
	private E[] queueArray;
	private final int INITIALIZATION_SIZE=10;
	private int rear;
	
	public MyQueue(){
		queueArray=(E[])new Object[INITIALIZATION_SIZE];
		rear=-1;
	}
	
	/**
	 * method for enqueue element in queue  
	 * */
	public void enqueue(E elementToInsert){
		if(elementToInsert!=null){
			queueArray[++rear]=elementToInsert;
			if(rear>=queueArray.length)
			{
				increaseSize();
			}
		}
	}
	
	/**
	 * method for dequeue element from queue
	 * */
	public E dequeue(){
		E dequeuedElement=null;
		if(size()>0){
			dequeuedElement=queueArray[0];
			for(int index=0;index<size();index++){
				queueArray[index]=queueArray[index+1];
			}
		}
		rear--;
		return dequeuedElement;
	}
	/**
	 * method to make queue empty
	 * */
	public void makeEmpty(){
		queueArray=(E[])new Object[INITIALIZATION_SIZE];
		rear=-1;
	}
	/*
	 * method for increasing size
	 * */
	private void increaseSize(){
			queueArray = Arrays.copyOf(queueArray, queueArray.length + (queueArray.length / 2));
	}
	
	/*
	 * method returning front element
	 * */
	public E getFront(){
		if(size()>0){
			return queueArray[0];
		}
		else
			return null;
	}
	/**
	 * method returning queue size
	 * */
	public int size(){
		return rear+1;
	}
	
	public static void main(String[] args) {
		MyQueue<Integer> queueObject=new MyQueue<Integer>();
		queueObject.enqueue(10);
		queueObject.enqueue(20);
		queueObject.enqueue(30);
		queueObject.enqueue(40);
		System.out.println(queueObject.dequeue());
		System.out.println(queueObject.dequeue());
		System.out.println(queueObject.dequeue());
		queueObject.makeEmpty();
		System.out.println(queueObject.getFront());
		System.out.println(queueObject.dequeue());
		System.out.println(queueObject.dequeue());
		
		
		
		
		
		
	}
}
