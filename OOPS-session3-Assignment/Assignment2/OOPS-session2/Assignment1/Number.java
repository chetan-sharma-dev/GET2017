package oopsassignment2;

public class Number extends Questions{
	
	/**
	 * @Method isValidInput(String participant_answer)
	 * checking input is number or not  
	 * @param participant_answer
	 * @return boolean , true if input is valid number else return false 
	 * */
	public static boolean isValidInput(String participant_answer)
	{
		/*
		 * converting the string into int ,
		 * if participation_answer is not in number format handling exception and returning false
		 * else
		 * returning true
		 *  
		 * */
		try{
			Integer.parseInt(participant_answer);
				return true;
		}
		catch(NumberFormatException e)
		{
			return false;
		}
	}

}
