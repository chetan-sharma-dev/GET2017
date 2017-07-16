/*
 *   program for printing lower left half triangle pyramid  
 */
package pfsession2;

//class for printing pyramid 

public class PyramidPrintingSecond {

	// method returning string of spaces
	public String spaceString(int row, int n) {
		String spaces_string = "";
		// appending spaces next to each other
		for (int i = 1; i < row; i++) {
			spaces_string = spaces_string + "  ";

		}

		return spaces_string;
	}

	// method returning string of numbers
	public String numberString(int row, int n) {
		String number_string = "";
		// creating string of left half of single row of trinagular pyramid and
		// appending numbers next to each other
		for (int i = 1; i <= n - row + 1; i++) {
			number_string = number_string + "" + i + " ";
		}

		return number_string;
	}

	public String[] printpyramid(int n) {
		String[] output_string;

		try {
			// if array length is 0 or negative , error will be handled in try
			// catch and program will show exception message but handle
			// exception.
			if (n <= 0) {
				throw new Exception("please insert natural no");
			}
			output_string = new String[n];
			int k = 0;
			/*
			 * creating lower left half of triangle
			 */

			for (int i = 1; i <= n; i++) {
				output_string[k++] = spaceString(i, n) + numberString(i, n);
			}
			return output_string;
		} catch (Exception e) {
			System.out.println("wrong input : " + e);
			output_string = new String[1];
			output_string[0] = "";
			return output_string;
		}
	}

	public static void main(String... s) {
		// creating object once only and using same object throuhout all test
		// cases
		PyramidPrintingSecond print_pyramid = new PyramidPrintingSecond();

		// happy test case
		String[] actual_output = print_pyramid.printpyramid(5);
		for (String element : actual_output) {
			System.out.println(element);
		}

		// negative test case
		actual_output = print_pyramid.printpyramid(-1);
		for (String element : actual_output) {
			System.out.println(element);
		}
	}
}
