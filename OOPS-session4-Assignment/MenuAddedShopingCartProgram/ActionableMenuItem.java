package oopssession4;
/*
 * class responsible for making menuItem actionAble
 * */
public class ActionableMenuItem extends MenuItem{
	
	Action action;

	/*
	 * triggering action
	 * */
	public void triggerAction(){
		//System.out.println(this.getDisplayName());
		this.action.performAction(getDisplayName());
	}

	public ActionableMenuItem(Action action) {
		
		this.action = action;
	}


}
