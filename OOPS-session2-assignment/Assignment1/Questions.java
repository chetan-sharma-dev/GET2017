package oopsassignment2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import oops_session2.Question;

public class Questions implements Comparable<Questions> {

	String question_text;
	String question_type;
	String options;
	HashMap<String,Integer> single_choice_options=new HashMap<String,Integer>();
	Set<String> multiple_choice_options=new HashSet<String>();
	//HashMap<String,Integer> multiple_choice_options=new HashMap<String,Integer>();
	
	public Questions() {
		this.question_text=null;
		this.question_type=null;
		this.options=null;
	}
	/*
	 * parameterized constructor 
	 * setting values for data members
	 * */
	public Questions(String question_text,String question_type,String options) {
		this.question_text=question_text;
		this.question_type=question_type;
		this.options=options;
		
		}
	
	public boolean validateAnswerChoice(String choice) {
		String[] choice_options = this.options.split("/");
		String[] choosed_options = choice.split("/");
		
		int correct_counter=0;
		boolean status=false;
		for (int i = 0; i < choice_options.length; i++) {
			for(int j=0;j< choosed_options.length;j++)
			{
				if (choice_options[i] == choosed_options[j])
				{
					correct_counter++;
				}
				
			}
		}
		if(correct_counter==choosed_options.length)
			return true;
		else
			return false;
	}
	
	public int compareTo(Questions object)
	{
		String[] split_one=question_text.split(". ");
		String[] split_second=object.question_text.split(". ");
		return split_one[1].compareTo(split_second[1]);
		//return question_text.compareTo(object.question_text);
	}
}
