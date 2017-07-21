package oopsassignment2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import com.sun.javafx.collections.MappingChange.Map;

public class Survey {
	public static void main(String... s) throws IOException {
/*
 * question array creation
*/
		Questions[] question_object = new Questions[5];
		Single single_choice_option = new Single();
		Multiple multiple_choice_option = new Multiple();

		FileInputStream fin = new FileInputStream(
				"src/oopsassignment2/test.txt");
		BufferedReader bin = new BufferedReader(new InputStreamReader(fin));
		String question_line;

/*
 * reading input from file question file and initialization of question
 * class objects
 */

		int question_index = 0;
		while ((question_line = bin.readLine()) != null) {
/*
 *  Spliting from ,
 */
			String[] splited_field_values = question_line.split(", ");
			// System.out.println(question_index);
			if (splited_field_values.length > 2) {
				question_object[question_index] = new Questions(
						splited_field_values[0], splited_field_values[1],
						splited_field_values[2]);
				String[] choice_options = splited_field_values[2].split("/");
/*
 * Single select 
 * */
				if ("Single Select".compareTo(splited_field_values[1]) == 0) {
					for (int i = 0; i < choice_options.length; i++) {
						question_object[question_index].single_choice_options
								.put(choice_options[i], 0);
					}
					/*System.out
							.println(question_object[question_index].single_choice_options
									.toString());*/
				} 
		/*
		 * Multiple select 
		 * */				
				else if ("Multi Select".compareTo(splited_field_values[1]) == 0) {

					for (int i = 0; i < choice_options.length; i++) {
						
						 question_object[question_index].multiple_choice_options
						  .add(choice_options[i]);
						 
						/*question_object[question_index].multiple_choice_options
								.put(choice_options[i], 0);*/

					}
					System.out
							.println(question_object[question_index].multiple_choice_options
									.toString());
				}
				question_index++;
			} else
				question_object[question_index++] = new Questions(
						splited_field_values[0], splited_field_values[1], null);

			// System.out.println(question_object[question_index-1].options);
		}

		
/*
 * taking user input for given question
 * */
		Scanner scan_input = new Scanner(System.in);
		HashMap<String, String> all_participant_answers = new HashMap<String, String>();

		for (int i = 0; i < 3; i++) {
			System.out.println("User no "+(i+1));
			all_participant_answers.put("Participant" + (i + 1), "");
			for (question_index = 0; question_index < 5; question_index++) {
	/*
	 * doing Question Printing
	 * */			
				System.out
						.println(question_object[question_index].question_text
								+ ", "
								+ question_object[question_index].question_type
								+ ", "
								+ question_object[question_index].options);
	/*
	 * recording user input
	 * */
				String participant_answer = "";
		/*
		 * for single select
		 * */		
				if ("Single Select"
						.compareTo(question_object[question_index].question_type) == 0) {
					participant_answer = scan_input.nextLine();
					if (question_object[question_index].single_choice_options
							.containsKey(participant_answer) == true) {
						int current_counter = question_object[question_index].single_choice_options
								.get(participant_answer);
						question_object[question_index].single_choice_options
								.put(participant_answer, current_counter + 1);
					} else {
						System.out.println("Invalid Input");
						question_index--;
						continue;

					}

				} 
		/*
		 * for multiple select
		 * */		
						
				else if ("Multi Select"
						.compareTo(question_object[question_index].question_type) == 0) {
					participant_answer = scan_input.nextLine();
					String[] multiple_choices = participant_answer.split("/");

					//System.out.println(Arrays.toString(multiple_choices));

					for (int j = 0; j < multiple_choices.length; j++) {
						System.out.println(multiple_choices[j]);
						if (question_object[question_index].
								  multiple_choice_options
								  .contains(multiple_choices[j]) != true) {
							System.out.println("Invalid Input");
							question_index--;
							break;

							/*
							 * question_object[question_index].multiple_choice_options
								.containsKey(participant_answer)
							  
							 */
						} 
					}
				}
		/*
		 * for text select
		 * */		
				else if ("Text"
						.compareTo(question_object[question_index].question_type) == 0) {
					participant_answer = scan_input.nextLine();
				} 
		/*
		 * for Number select
		 * */			
				else {
					int answer = scan_input.nextInt();
					scan_input.nextLine();
					participant_answer = "" + answer;
				}
		/*
		 * updating all participant input in hash map
		 * */		
				String previous_responce = all_participant_answers
						.get("Participant" + (i + 1));
				// previous_responce+","+participant_answer;
				all_participant_answers.put("Participant" + (i + 1),
						previous_responce + "," + participant_answer);
			}
			// System.out.println(participant_answers.get("Participant"+(i+1)));
			// System.out.println(scan_input.next());
		}
		scan_input.close();
		bin.close();

	}
}
