package oopsassignment2;

import java.util.HashMap;

public class Single extends Questions {
	
	
	/**
	 * @Method isValidInput(String participant_answer,Questions question_object)
	 * checking input single choice is right or not 
	 * @param participant_answer,Question objects
	 * @return boolean , true if input is valid else return false 
	 * */
	public static boolean isValidInput(String participant_answer,Questions question_object)
	{
		return question_object.single_choice_options.containsKey(participant_answer);
		
	}
	
	/**
	 * @Method recordUserInputForSingleSelect(String participant_answer,Questions question_object)
	 * recording single select question input of user
	 * @param participant_answer,Question objects
	 * @return void 
	 * */
	public static void recordUserInputForSingleSelect(String participant_answer,Questions question_object)
	{
		/*
		 * recording single_choice_options
		 * */
		int current_counter = question_object.single_choice_options.get(participant_answer);
		question_object.single_choice_options.put(participant_answer, current_counter + 1);
		
	}
	
}
