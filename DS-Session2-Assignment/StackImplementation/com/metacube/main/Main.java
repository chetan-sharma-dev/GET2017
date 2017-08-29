package com.metacube.main;

import com.metacube.stack.Stack;

public class Main {

	public static void main(String[] args) {
		Stack stackObject=new Stack();
		for(int i=0;i<5;i++)
		{
			stackObject.push(1);
			System.out.println("");
		}
		for(int i=0;i<5;i++)
		{
			stackObject.pop();
			System.out.println("");
		}
	
		
	}
}

