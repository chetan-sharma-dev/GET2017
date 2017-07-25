package oopsassignment2;

public class Text {
	/**
	 * @Method isValidInput(String participant_answer)
	 * checking input is not null
	 * @param participant_answer
	 * @return boolean , true if input is valid number else return false 
	 * */
	public static boolean isValidInput(String participant_answer)
	{
		
		
			if(participant_answer!=null&&participant_answer.length()>0)
				return true;
			else
				return false;
		
	}
}
