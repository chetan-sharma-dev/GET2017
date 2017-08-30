package com.metacube.main;

import com.metacube.notations.Notations;
import com.metacube.stack.Stack;

public class Main {

	public static void main(String[] args) {
		Stack stackObject=new Stack();
		for(int i=0;i<5;i++)
		{
			stackObject.push(i);
		}
		for(int i=0;i<5;i++)
		{
			System.out.println(stackObject.pop());
		}
	
		Notations notationObject=new Notations();
		System.out.println(notationObject.getPostFixNotation("((123+12)^10)+4*6"));
		System.out.println(notationObject.getPostFixNotation("(123+12)^10)+4*6"));
		System.out.println(notationObject.getPostFixNotation("((123+12)^10+4*6"));
		System.out.println(notationObject.getPostFixNotation("((a+b*c^d-e)^(f+g*h)-i)"));
		System.out.println(notationObject.getPostFixNotation("1+3-2"));
		System.out.println();
		
	}
}

