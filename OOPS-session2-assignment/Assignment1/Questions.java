package oopsassignment2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Questions implements Comparable<Questions> {

	String question_text;
	String question_type;
	String options;
	/*
	 * single_choice_options storing all users single choice options 
	 * multiple_choice_option is storing all multiple choice options 
	 * we used these for checking input validation
	 * */
	HashMap<String,Integer> single_choice_options=new HashMap<String,Integer>();
	Set<String> multiple_choice_options=new HashSet<String>();
	
	/**
	 * @Constructor Questions()
	 * default constructor initializing Question object data members
	 * */
	public Questions() {
		this.question_text=null;
		this.question_type=null;
		this.options=null;
	}
	
	/**
	 * @Constructor Questions()
	 * parameterized constructor initializing Question object data members
	 * @param String question_text,String question_type,String options
	 * */
	public Questions(String question_text,String question_type,String options) {
		this.question_text=question_text;
		this.question_type=question_type;
		this.options=options;
		
		}
	
	/**
	 * @Method  createQuestionObject(int noOfObjects)
	 * creating questions class object array  
	 * @param no_of_objects
	 * @return Questions[] , Questions class array 
	 * */
	
	public static Questions[] createQuestionObject(int noOfObjects)
	{	
		return new Questions[noOfObjects];
	}
	
	/**
	 * @Method  initializeQuestionsParameters(String file_path,Questions[] question_object)
	 * initialize question objects
	 * @param file_path  and question_object array 
	 * @return void
	 * */
	public static void initializeQuestionsParameters(String file_path,
			Questions[] question_object) throws IOException {
		/*
		 * reading from file line by line in bufferedReader 
		 * */

		FileInputStream file_input = new FileInputStream(file_path);
		BufferedReader buffer_input = new BufferedReader(new InputStreamReader(
				file_input));
		String question_line;
		int question_index = 0;
		while ((question_line = buffer_input.readLine()) != null) {
			/*
			 * Splitting from , as a delimiter
			 */
			String[] splited_field_values = question_line.split(", ");
			/*
			 * if splited_field_values > 2 then it is Single or Multi select type 
			 * else it will be  of Text or Number type
			 * */
			if (splited_field_values.length > 2) {
				question_object[question_index] = new Questions(
						splited_field_values[0], splited_field_values[1],
						splited_field_values[2]);
				String option_string=splited_field_values[2].replace("(", "");
				option_string=option_string.replace(")", "");
				String[] choice_options = option_string.split("/");
				/*
				 * Single select choice initialization
				 */
				if ("Single Select".compareTo(splited_field_values[1]) == 0) {
					for (int i = 0; i < choice_options.length; i++) {
						question_object[question_index].single_choice_options
								.put(choice_options[i], 0);
					}
				}
				/*
				 * Multiple select choice initialization
				 */
				else if ("Multi Select".compareTo(splited_field_values[1]) == 0) {

					for (int i = 0; i < choice_options.length; i++) {

						question_object[question_index].multiple_choice_options
								.add(choice_options[i]);
					}
			}
				question_index++;
			} 
			/*
			 * otherwise in case of Text or Number just do initialization
			 * */
			else {
				question_object[question_index++] = new Questions(
						splited_field_values[0], splited_field_values[1], null);
			}
		}

	}
	
	/**
	 * @Method  compareTo(Questions object)
	 * over ridden method of comparator interface 
	 * @param question object 
	 * @return integer ,returning zero, positive or negative value
	 * */
	public int compareTo(Questions object)
	{
		/*
		 * comparing only according to Question_text and returning value accordingly
		 * */
		String[] split_one=question_text.split(". ");
		String[] split_second=object.question_text.split(". ");
		return split_one[1].compareTo(split_second[1]);
	}
}
