package oopsassignment2;

public class Multiple extends Questions{
	
	/**
	 * @Method isValidInput(String participant_answer,Questions question_object)
	 * checking input multiple choices are right or not 
	 * @param Question objects
	 * @return boolean , true if input is valid else return false 
	 * */
	public static boolean isValidInput(String participant_answer,Questions question_object)
	{
		/*
		 * Splitting input from / as delimiter and checking against multiple choice options
		 * */
		String[] multiple_choices = participant_answer.split("/");

		for (int j = 0; j < multiple_choices.length; j++) 
		{
			/*
			 * checking multiple choice options hashmap
			 * */
			if (question_object.multiple_choice_options.contains(multiple_choices[j]) != true) 
			{
				return false; 
				
			}
		}
		return true;
		
	}
	
	
}
