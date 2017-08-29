package com.metacube.notations;

import com.metacube.stack.Stack;

public class Notations {

	public String getPostFixNotation(String infixNotation)
	{
		Stack stackObject=new Stack();
		String postfixNotation="";
		
		for(int i=0;i<infixNotation.length();i++){
			Character dataElement=infixNotation.charAt(i);
			
			if(Character.isLetterOrDigit(dataElement))
			{
				postfixNotation+=dataElement;
			}else if(dataElement==')')
			{
					while(stackObject.getTopElement()!=null&&(char)stackObject.getTopElement()!='('){
						postfixNotation+=stackObject.pop();
					}
					if(stackObject.getTopElement()!=null)
					{
						stackObject.pop();
					}else{
						return "Invalid string entered";
					}
				
			}else if(dataElement=='*'||dataElement=='/'||dataElement=='+'||dataElement=='-'||dataElement=='^'){
				while(stackObject.getTopElement()!=null&&getPrecedence((char)stackObject.getTopElement())>=getPrecedence(dataElement)){
					postfixNotation+=stackObject.pop();
				}
				stackObject.push(dataElement);
			}else{
					stackObject.push(dataElement);
			}
			
		}
		while(stackObject.getTopElement()!=null)
		{
			if((char)stackObject.getTopElement()=='(')
			{
				return "Invalid string entered";
			}
			postfixNotation+=stackObject.pop();
		}
		return postfixNotation;
	}
	 public int getPrecedence(char c){
		 switch(c)
		 {
		 	case '+':
		 	case '-':
		 		return 1;
		 	case '*':
		 	case '/':
		 		return 2;
		 	case '^':
		 		return 3;
		 }
		 return 0;
		 
	 }
	
	 public static void main(String[] args) {
		Notations nObject=new Notations();
		System.out.println(nObject.getPostFixNotation("((123+12)^10)+4*6"));
		System.out.println(nObject.getPostFixNotation("((a+b*c^d-e)^(f+g*h)-i)"));
		System.out.println(nObject.getPostFixNotation("1+3-2"));
		System.out.println();
	}
}
