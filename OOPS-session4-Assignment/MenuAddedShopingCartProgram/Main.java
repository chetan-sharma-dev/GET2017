package oopssession4;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class Main {
	public static Scanner scan= new Scanner(System.in);
	public  static Menu createMenu(){
		Menu mainMenu=new Menu();
		
		MenuItem mi=new ActionableMenuItem(new Controller());
		List<MenuItem> subMenu=mainMenu.getSubMenu();
		mi.setDisplayName("Display Product List");
		subMenu.add(mi);
		
		mi=new Menu();
		mi.setDisplayName("Display Promotion List");
		subMenu.add(mi);
		
			List<MenuItem> subPromoMenu=((Menu) mi).getSubMenu();
	        mi=new ActionableMenuItem(new Controller());
	        mi.setDisplayName("Display Product Promotion");
	        subPromoMenu.add(mi);
	        
	        mi=new ActionableMenuItem(new Controller());
	        mi.setDisplayName("Display Order Promotion");
	        subPromoMenu.add(mi);

		mi=new ActionableMenuItem(new Controller());
		mi.setDisplayName("Order Products");
		subMenu.add(mi);
		
		mi=new ActionableMenuItem(new Controller());
		mi.setDisplayName("Display Bill");
		subMenu.add(mi);
		
		mi=new ActionableMenuItem(new Controller());
		mi.setDisplayName("Exit");
		subMenu.add(mi);
		
		return mainMenu;
		
	}
	
	public static void display(Menu menu){
		
		Iterator<MenuItem> itr=menu.getSubMenu().iterator();
		int i=1;
		while(itr.hasNext()){
			System.out.println(i+"."+itr.next().getDisplayName());
			i++;
		}
		
		
	}
	
	public static int getInput(){
		try {
			
			System.out.print("Enter menu no:-");
			String choice = scan.next();
			int validChoice = Integer.parseInt(choice);
			return validChoice - 1;
		} catch (Exception e) {
			
			return -1;
		}
		
	}
	
	public static void displayAndPerformAction(Menu menu){
		
		display(menu);
		
		int choice=getInput();
		
		MenuItem menuItem= menu.getSelection(choice);
	
		
		if(menuItem==null){
			System.out.println("Wrong input");
			displayAndPerformAction(menu);
		}
		else if(menuItem instanceof ActionableMenuItem){
			
			((ActionableMenuItem)menuItem).triggerAction(menuItem.getDisplayName());
			
		}
		else{
			displayAndPerformAction((Menu)menuItem);
		}
	}
	
	public static void main(String args[]){
		Menu menu=createMenu();
		
		while(true){
		displayAndPerformAction(menu);
		}
		
		
	}
}
