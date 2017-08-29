package com.metacube.queue;

import java.util.Arrays;

public class MyQueue <E> {
	private E[] queueArray;
	private final int INITIALIZATION_SIZE=10;
	private int rear;
	
	public MyQueue(){
		queueArray=(E[])new Object[INITIALIZATION_SIZE];
		rear=-1;
	}
	
	public void enqueue(E elementToInsert){
		if(elementToInsert!=null){
			queueArray[++rear]=elementToInsert;
			if(rear>=queueArray.length)
			{
				increaseSize();
			}
		}
	}
	
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
	
	public void makeEmpty(){
		queueArray=(E[])new Object[INITIALIZATION_SIZE];
		rear=-1;
	}
	
	private void increaseSize(){
			queueArray = Arrays.copyOf(queueArray, queueArray.length + (queueArray.length / 2));
	}
	
	public E getFront(){
		if(size()>0){
			return queueArray[0];
		}
		else
			return null;
	}
	
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
