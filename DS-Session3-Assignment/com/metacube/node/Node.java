package com.metacube.node;
/**
 * Generic class for node
 * having left and right child along with data of generic type
 * */
public class Node<E> {
	private Node<E> leftChild;
	private E data;
	private Node<E> rightChild;
	
	/**
	 * @Constructor
	 * initializing data members
	 * */
	public Node(E elementData)
	{
		this.data=elementData;
		leftChild=null;
		rightChild=null;
	}
	/*
	 * all getter and setter methods of private data members
	 * */
	public Node<E> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node<E> leftChild) {
		this.leftChild = leftChild;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public Node<E> getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node<E> rightChild) {
		this.rightChild = rightChild;
	}
	
	
}
