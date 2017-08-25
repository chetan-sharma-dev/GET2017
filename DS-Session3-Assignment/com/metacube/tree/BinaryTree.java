package com.metacube.tree;
import com.metacube.node.Node;
/**
 *@class BinaryTree
 *class for binary tree general operations like InOrder,PostOrder,PreOrder
 */
public class BinaryTree <E> {
	
	/**
	 * variable holding reference of root
	 */
	
	private Node<E> root;
	
	/**
	 *@constructor BinaryTree
	 *initializing root with null on instantiation
	 * */
	public BinaryTree() {
		this.root=null;
	}
	/**
	 * @method getRoot()
	 * getter method for private member root 
	 * */
	public Node<E> getRoot()
	{
		return this.root;
	}
	
	/**
	 * @method insertInLeftSkewedBinaryTree(E e)
	 * method for inserting element in leftSkewedTree
	 * @return true, if element inserted successfully 
	 * 		else, return false
	 * */
	public  boolean insertInLeftSkewedBinaryTree(E element)
	{
		/**
		 * checking whether element is null or not
		 * if yes, returning false
		 * else continue further
		 * */
		if(element==null)
		{
			return false;
		}else{
			/*
			 * creating new node and if root is null, inserting at root else, calling recursive method for inserting node
			 * */
			Node<E> newNode=new Node<E>(element);
			if(root==null)
			{
				root=newNode;
			}else{
				insertNodeInLeftSkewedTree(root,newNode);
			}
			return true;
		}	
	}

	/**
	 * @method insertInLeftSkewedBinaryTree(E e)
	 * method for inserting element in leftSkewedTree
	 * @return true, if element inserted successfully 
	 * 		else, return false
	 * */
	public  boolean insertInRightSkewedBinaryTree(E element)
	{
		/**
		 * checking whether element is null or not
		 * if yes, returning false
		 * else continue further
		 * */
		if(element==null)
		{
			return false;
		}else{
			/*
			 * creating new node and if root is null, inserting at root else, calling recursive method for inserting node
			 * */
			Node<E> newNode=new Node<E>(element);
			if(root==null)
			{
				root=newNode;
			}else{
				insertNodeInRightSkewedTree(root,newNode);
			}
			return true;
		}	
	}

	/**
	 * @method insertNodeInRightSkewedTree()
	 * method for inserting given node at appropriate position by iterating right subtree recursively 
	 */
	private void insertNodeInRightSkewedTree(Node<E> currentNode,Node<E> nodeToBeInserted)
	{	
		/*
		 * checking whether right child is null, if it is null , insert at right
		 *  else if not null checking for left child is null , if yes insert at left 
		 *  else calling method for root as right child 
		 * */
		if(currentNode.getRightChild()==null)
		{	
			currentNode.setRightChild(nodeToBeInserted);
		}else if(currentNode.getLeftChild()==null)
		{
			currentNode.setLeftChild(nodeToBeInserted);
		}else{
			insertNodeInRightSkewedTree(currentNode.getRightChild(), nodeToBeInserted);
		}
	}
	/**
	 * @method insertNodeInLeftSkewedTree()
	 * method for inserting given node at appropriate position by iterating left subtree recursively 
	 */
	private void insertNodeInLeftSkewedTree(Node<E> currentNode,Node<E> nodeToBeInserted)
	{
		/*
		 * checking whether left child is null, if it is null , insert at left
		 *  else if not null checking for right child is null , if yes insert at right 
		 *  else calling method for root as right child 
		 * */
		if(currentNode.getLeftChild()==null)
		{
			currentNode.setLeftChild(nodeToBeInserted);
		}else if(currentNode.getRightChild()==null)
		{
			currentNode.setRightChild(nodeToBeInserted);
		}else{
			insertNodeInLeftSkewedTree(currentNode.getLeftChild(), nodeToBeInserted);
		}
	}

	/**
	 * @method traverse()
	 * method  for traversing tree in all notation 
	 * */
	public void traverse(){
		if(root==null)
		{
			System.out.println("Empty tree");
		}
		else{
			Node<E> currentNode=root;
		
			System.out.println(preOrder(currentNode));
			System.out.println(inOrder(currentNode));
			System.out.println(postOrder(currentNode));
			
		}
	}
	/**
	 * @method getPreOrder()
	 * method for getting preOrder for given tree  
	 * */
	public String getPreOrder(){
		/** 
		 * checking whether root is null or not 
		 * */
		if(root==null)
		{
			return "Empty tree";
		}
		else{
			Node<E> currentNode=root;
		
			return preOrder(currentNode);
		}
	}
	/**
	 * @method getPostOrder()
	 * method for getting postOrder for given tree  
	 * */
	public String getPostOrder(){
		/** 
		 * checking whether root is null or not 
		 * */
		if(root==null)
		{
			return "Empty tree";
		}
		else{
			Node<E> currentNode=root;
		
			return postOrder(currentNode);
		}
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
	 * @method preOrder()
	 * method for getting preOrder of given tree
	 * */
	private String preOrder(Node<E> currentNode){
		/**
		 * getting root data and appending it into string 
		 * then iterating left sub tree for the same procedure 
		 * after left subtree iteration, iterating right subtree
		 * */
		String response="";
		if(currentNode!=null)
		{
			response+=currentNode.getData()+" ";
			response+=preOrder(currentNode.getLeftChild());
			response+=preOrder(currentNode.getRightChild());
		}
		return response;
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
	
	/**
	 * @method postOrder()
	 * method for getting inOrder of given tree
	 * */
	private String postOrder(Node<E> currentNode){
		String p="";
		if(currentNode!=null)
		{
			p+=postOrder(currentNode.getLeftChild());
			p+=postOrder(currentNode.getRightChild());
			p+=currentNode.getData()+" ";
			
		}
		return p;
	}
	
	/**
	 * @method whetherMirrorOrNot()
	 * method for fining whether given two subtrees are mirror or not
	 * @return true, if both subtrees are mirror else, return false
	 * */
	public boolean whetherMirrorOrNot(Node<E> currentNodeOfFirstTree,Node<E> currentNodeOfSecondTree)
	{
		/*
		 * if both tree current position is null than returning true 
		 * else if one of them of current node is null return false
		 * else iterating left subtree first, corresponding to the current node and then iterate right subtree 
		 * if node data equals on both current node then continue
		 * else return false 
		 * */
		if(currentNodeOfFirstTree==null&&currentNodeOfSecondTree==null)
		{
			return true;
		}
		else if(currentNodeOfFirstTree==null||currentNodeOfSecondTree==null)
		{
			return false;
		}
		else if(currentNodeOfFirstTree.getData().equals(currentNodeOfSecondTree.getData()))
		{
			if(!whetherMirrorOrNot(currentNodeOfFirstTree.getLeftChild(), currentNodeOfSecondTree.getRightChild()))
				return false;
			if(!whetherMirrorOrNot(currentNodeOfFirstTree.getRightChild(),currentNodeOfSecondTree.getLeftChild()))
				return false;
			return true;
		}else{
			return false;
		}
		
	}

	/**
	 * @method clearTree()
	 * clearing the tree
	 * */
	public void clearTree(){
		this.root=null;
	}
	

	
}
