package oopssession4;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
/*
 * Class  where our execution starts
 * */

public class Main {
	/*
	 * single object created for scanning input
	 * */
	public static Scanner scan= new Scanner(System.in);
	/**
	 * @method createMenu()
	 * this method is adding elements in Menu
	 * @return Menu : return menu object 
	 * */
	public  static Menu createMenu(){
		/*
		 * creating menu
		 * */
		Menu mainMenu=new Menu();
		/*
		 * adding actionable menu item 
		 * */
		MenuItem mi=new ActionableMenuItem(new Controller());
		/*
		 * getting subMenu list reference
		 * */
		List<MenuItem> subMenu=mainMenu.getSubMenu();
		mi.setDisplayName("Display Product List");
		/*
		 * adding menu item to subMenu
		 * */
		subMenu.add(mi);
		/*
		 * creating menu item
		 * */
		mi=new Menu();
		mi.setDisplayName("Display Promotion List");
		/*
		 * adding this menu in subMenu 
		 * */
		subMenu.add(mi);
			/*
			 * now adding subMenu actionable  item into menu item
			 * */
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

	/**
	 * @method display(Menu menu)
	 * displaying menu by iterating subMenu list of menuItem
	 * */
	public static void display(Menu menu){
		
		Iterator<MenuItem> itr=menu.getSubMenu().iterator();
		int i=1;
		while(itr.hasNext()){
			System.out.println(i+"."+itr.next().getDisplayName());
			i++;
		}
		
		
	}
	
	/**
	 * @method getInput()
	 * method for taking user input along with validation
	 * */
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
	
	/**
	 * @method displayAndPerformAction(Menu menu)
	 * method which is displaying or calling actionable item according to user input
	 * */
	public static void displayAndPerformAction(Menu menu){
		/*
		 * displaying menu
		 * */
		display(menu);
		/*
		 * taking user input
		 * */
		int choice=getInput();
		/*
		 * selecting menu item according to user input
		 * */
		MenuItem menuItem= menu.getSelection(choice);
	
		/*
		 * checking menuItem type 
		 * */
		if(menuItem==null){
			System.out.println("Wrong input");
			displayAndPerformAction(menu);
		}
		else if(menuItem instanceof ActionableMenuItem){
			/*
			 * if menu is actionable then trigger action
			 * */
			((ActionableMenuItem)menuItem).triggerAction();
			
		}
		else{
			/*
			 * displaying subMenues 
			 * */
			displayAndPerformAction((Menu)menuItem);
		}
	}

	
	public static void main(String args[]){
		/*
		 * creating menu 
		 */
		Menu menu=createMenu();
		/*
		 * displaying subMenu repeatedly
		 * */
		while(true){
		displayAndPerformAction(menu);
		}
		
		
	}
}
