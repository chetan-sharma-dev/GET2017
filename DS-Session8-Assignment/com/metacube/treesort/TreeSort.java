package com.metacube.treesort;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.metacube.node.Node;

public class TreeSort<E extends Comparable<E>> {
	private Node<E> root;
	
	public String getSortedList(List<E> listOfElements){
		generateBinarySearchTree(listOfElements);
		return getInOrder();
		 
	}
	public void generateBinarySearchTree(List<E> listOfElements){
		Iterator<E> itr = listOfElements.iterator();
		while(itr.hasNext()){
			Node<E> nodeToBeInserted=new Node<E>(itr.next());
			if(root==null){
				root=nodeToBeInserted;
			}else{
			iterateAndInsert(root, nodeToBeInserted);
			}
		}	
	}
	
	private boolean iterateAndInsert(Node<E> currentNode,Node<E> nodeToBeInserted){
			if(currentNode.getData().compareTo(nodeToBeInserted.getData())>0){
				if(currentNode.getLeftChild()==null){
					currentNode.setLeftChild(nodeToBeInserted);
					return true;
				}
				return iterateAndInsert(currentNode.getLeftChild(), nodeToBeInserted);
			}else if(currentNode.getData().compareTo(nodeToBeInserted.getData())<0){
				if(currentNode.getRightChild()==null){
					currentNode.setRightChild(nodeToBeInserted);
					return true;
				}
				return iterateAndInsert(currentNode.getRightChild(), nodeToBeInserted);
			}else if(currentNode.getData().compareTo(nodeToBeInserted.getData())==0){
				if(currentNode.getRightChild()==null){
					currentNode.setRightChild(nodeToBeInserted);
					return true;
				}
				return iterateAndInsert(currentNode.getRightChild(), nodeToBeInserted);
			}
			return false;
	}
	
	/**
	 * @method getInOrder()
	 * method for getting inOrder for given tree  
	 * */
	public String getInOrder(){
		/*
		 * checking whether root is null or not 
		 * */
		if(root==null)
		{
			return "Empty tree";
		}
		else{
			Node<E> currentNode=root;
		
			return inOrder(currentNode);
		}
	}
	/**
	 * @method inOrder()
	 * method for getting inOrder of given tree
	 * */
	private String inOrder(Node<E> currentNode){
		/**
		 * then iterating left sub tree 
		 * getting root data and appending it into string 
		 * after that, iterating right subtree
		 * */
		String response="";
		if(currentNode!=null)
		{
			response+=inOrder(currentNode.getLeftChild());
			response+=currentNode.getData()+" ";
			response+=inOrder(currentNode.getRightChild());
		}
		return response;		
	}
	
	public void inOrderTraversalOfTree(){
		
	}
	
	public static void main(String[] args) {
		TreeSort<Integer> treeObject=new TreeSort<Integer>();
		List<Integer> listOfDisorderedRollNos=new ArrayList<Integer>();
		listOfDisorderedRollNos.add(10);
		listOfDisorderedRollNos.add(0);
		listOfDisorderedRollNos.add(3);
		listOfDisorderedRollNos.add(6);
		listOfDisorderedRollNos.add(5);
		listOfDisorderedRollNos.add(60);
		treeObject.generateBinarySearchTree(listOfDisorderedRollNos);
		System.out.println(treeObject.getInOrder());
	}
	
	
}
