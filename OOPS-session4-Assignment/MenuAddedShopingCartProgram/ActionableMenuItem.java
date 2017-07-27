package oopssession4;

public class ActionableMenuItem extends MenuItem{
	
	Action action;

	
	public void triggerAction(String displayname){
		this.action.performAction(displayname);
	}

	public ActionableMenuItem(Action action) {
		
		this.action = action;
	}


}
