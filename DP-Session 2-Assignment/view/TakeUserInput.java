package view;

import java.util.Scanner;
/**
 * @class
 * Dedicated class for taking user input 
 * */
public class TakeUserInput {
	/*
	 * common object created for scanner class
	 * */
	public static Scanner scanInput=new Scanner(System.in);
	
	/**
	 * @method
	 * method taking user input in string from console
	 * */
	public static String takeUserInput()
	{
		return scanInput.next();
	}

}
