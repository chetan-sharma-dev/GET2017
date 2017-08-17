package Main;
import view.Display;

/**
 * Main Class of project
 * 
 * */

public class Main {
	public static void main(String...s)
	{
		/*
		 * initially creating Display class Object
		 * */
		Display displayObject=Display.getInstance();
		displayObject.displayMenu();
	}
}
