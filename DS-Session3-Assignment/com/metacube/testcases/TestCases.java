package com.metacube.testcases;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.metacube.tree.BinaryTree;

public class TestCases<E> {
	BinaryTree<Integer> binaryTreeObject;
	@Before
	public void createObject(){
		binaryTreeObject=new BinaryTree<Integer>();
		binaryTreeObject.insertInLeftSkewedBinaryTree(10);
		binaryTreeObject.insertInLeftSkewedBinaryTree(20);
		binaryTreeObject.insertInLeftSkewedBinaryTree(30);
		binaryTreeObject.insertInLeftSkewedBinaryTree(40);
		binaryTreeObject.insertInLeftSkewedBinaryTree(50);
		binaryTreeObject.insertInLeftSkewedBinaryTree(60);
		binaryTreeObject.insertInLeftSkewedBinaryTree(70);
	}
	@Test
	public void insertionPositiveTestCase(){
		BinaryTree<Integer> binaryTreeObject1=new BinaryTree<Integer>();
			boolean actualOutput=binaryTreeObject1.insertInLeftSkewedBinaryTree(10);
			boolean expectedOutput=true;
			assertEquals(expectedOutput, actualOutput);
	}
	@Test
	public void insertionNegativeTestCase(){
		BinaryTree<Integer> binaryTreeObject1=new BinaryTree<Integer>();
			boolean actualOutput=binaryTreeObject1.insertInLeftSkewedBinaryTree(null);
			boolean expectedOutput=false;
			assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	public void preOrderPositiveTestCase(){
		String actualPreOrder=binaryTreeObject.getPreOrder();
		String expectedPreOrder="10 20 40 60 70 50 30 ";
		assertEquals(expectedPreOrder,actualPreOrder);
	}
	@Test
	public void preOrderNegativeTestCase(){
		BinaryTree<Integer> binaryTreeObject2=new BinaryTree<Integer>();
		String actualPreOrder=binaryTreeObject2.getPreOrder();
		String expectedPreOrder="Empty tree";
		assertEquals(expectedPreOrder,actualPreOrder);
	}
	
	@Test
	public void postOrderTestCase(){
		String actualPostOrder=binaryTreeObject.getPostOrder();
		String expectedPostOrder="60 70 40 50 20 30 10 ";
		assertEquals(expectedPostOrder,actualPostOrder);
	}
	@Test
	public void inOrderTestCase(){
		String actualInOrder=binaryTreeObject.getInOrder();
		String expectedInOrder="60 40 70 20 50 10 30 ";
		assertEquals(expectedInOrder,actualInOrder);
	}
	
	@Test
	public void mirroredTreePositiveTestCase(){
		BinaryTree<Integer> binaryTreeObject2=new BinaryTree<Integer>();
		binaryTreeObject2.insertInRightSkewedBinaryTree(10);
		binaryTreeObject2.insertInRightSkewedBinaryTree(20);
		binaryTreeObject2.insertInRightSkewedBinaryTree(30);
		binaryTreeObject2.insertInRightSkewedBinaryTree(40);
		binaryTreeObject2.insertInRightSkewedBinaryTree(50);
		binaryTreeObject2.insertInRightSkewedBinaryTree(60);
		binaryTreeObject2.insertInRightSkewedBinaryTree(70);
		boolean actualOutput=binaryTreeObject.whetherMirrorOrNot(binaryTreeObject.getRoot(), binaryTreeObject2.getRoot());
		boolean expectedOutput=true;
		assertEquals(actualOutput,expectedOutput);
	}
	
	@Test
	public void mirroredTreeNegativeTestCase(){
		BinaryTree<Integer> binaryTreeObject2=new BinaryTree<Integer>();
		binaryTreeObject2.insertInRightSkewedBinaryTree(10);
		binaryTreeObject2.insertInRightSkewedBinaryTree(20);
		binaryTreeObject2.insertInRightSkewedBinaryTree(30);
		binaryTreeObject2.insertInRightSkewedBinaryTree(40);
		binaryTreeObject2.insertInRightSkewedBinaryTree(50);
		binaryTreeObject2.insertInRightSkewedBinaryTree(70);
		binaryTreeObject2.insertInRightSkewedBinaryTree(60);
		boolean actualOutput=binaryTreeObject.whetherMirrorOrNot(binaryTreeObject.getRoot(), binaryTreeObject2.getRoot());
		boolean expectedOutput=false;
		assertEquals(actualOutput,expectedOutput);
	}
	
	@Test
	public void clearMethodTestCase(){
		binaryTreeObject.clearTree();
		String actualOutput=binaryTreeObject.getPostOrder();
		String expectedOutput="Empty tree";
		assertEquals(expectedOutput, actualOutput);
	}
	
}
