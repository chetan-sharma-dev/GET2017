package com.metacube.node;
/**
 * @class Node
 * POJO class for node
 */

public class Node<E>  {
	private Node<E> leftChild;
	private E data;
	private Node<E> rightChild;
	
	public Node(E data) {
		this.data=data;
		this.leftChild=null;
		this.rightChild=null;
	}

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
