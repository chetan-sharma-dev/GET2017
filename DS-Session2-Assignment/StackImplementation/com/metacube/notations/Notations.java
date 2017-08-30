package com.metacube.notations;

import com.metacube.stack.Stack;
/**
 * @class Notations
 * for getting notations
 * */
public class Notations {

	/**
	 * @method getPostFixNotation()
	 * method returning postfix Notation for infixNotation 
	 * */
	public String getPostFixNotation(String infixNotation)
	{
		//instantiating stack
		Stack stackObject=new Stack();
		String postfixNotation="";
		
		for(int i=0;i<infixNotation.length();i++){
			// getting dataElement at loop index in infixNotation
			Character dataElement=infixNotation.charAt(i);
			/**
			 * checking whether it is letter or digit if yes, directly add in postfix string
			 * else if dataElement is ')' ,then pop stack till '(' found
			 * else if operator found then according to preference push in stack else pop and add  in postfix string 
			 * else push in stack 
			 * */
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
		/*
		 * at last pop all elements from stack 
		 * if '(' found returning error 
		 * else just add in postfix notation 
		 * */
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
	/**
	 * @method getPrecedence()
	 *  method returning precedence according to input operator  
	 * */
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
