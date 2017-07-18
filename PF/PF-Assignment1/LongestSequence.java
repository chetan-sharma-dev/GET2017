package pfsession;

/*
 * program for finding LongestSequence 
 * */
public class LongestSequence {

	public int[] longestSequence(int input[]) {
		int start = 0, end = 0, tempstart = 0, tempend = 0;
		if (input.length != 1) {
			/*
			 * here we are calculating a sequence lenth by using 4 flags. 2 of
			 * them are temp.
			 */
			for (int i = 1; i < input.length; i++) {
				if (input[i - 1] < input[i]) {
					tempend = i;
					if ((end - start) < (tempend - tempstart)) {
						start = tempstart;
						end = tempend;
					}

					continue;
				} else {
					if ((end - start) < (tempend - tempstart)) {
						start = tempstart;
						end = tempend;
					}
					tempstart = i;
					tempend = i;
					continue;
				}
			}

		}
		/*
		 * if there is nothing in array return empty array
		 */
		else if (input.length == 0) {
			int[] final_output_array = {};

			return final_output_array;
		}
		int[] output = new int[end - start + 2];
		int i;
		for (i = 0; i < output.length - 1; i++) {
			output[i] = input[start++];
		}
		/*
		 * As a delimeter i used # char
		 */
		output[i] = '#';
		int[] final_output_array = new int[i];
		i = 0;
		/*
		 * creating final array to return
		 */
		while (output[i] != '#' && input.length != 0) {
			final_output_array[i] = output[i];
			i++;
		}
		return final_output_array;

	}

}
