package com.metacube.singlylinkedlist;

@SuppressWarnings("rawtypes")
public class Node<E extends Comparable> {

	private E element;
	private Node nextNode;
	
	public Node(E element) {
		this.element = element;
		this.nextNode = null;
	}
	/**
	 * @return the element
	 */
	public E getElement() {
		return element;
	}
	/**
	 * @param element the element to set
	 */
	public void setElement(E element) {
		this.element = element;
	}
	/**
	 * @return the nextNode
	 */
	public Node getNextNode() {
		return nextNode;
	}
	/**
	 * @param node the nextNode to set
	 */
	public void setNextNode(Node node) {
		this.nextNode = node;
	}
	
}