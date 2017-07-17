/*
 *   program for printing lower left half triangle pyramid  
 */
package pfsession;

//class for printing pyramid 

public class PyramidPrintingSecond {

	// method returning string of spaces
	public String spaceString(int row, int n) {
		String spaces_string = "";
		try {
			if (row <= 0 || row > n || n <= 0) {
				throw new Exception("row and element no n entered");
			}
			// appending spaces next to each other
			for (int i = 1; i < row; i++) {
				spaces_string = spaces_string + "  ";

			}
		} catch (Exception e) {
			System.out.println("Wrong input" + e);
		}

		return spaces_string;
	}

	// method returning string of numbers
	public String numberString(int row, int n) {
		String number_string = "";
		try {
			if (row <= 0 || row > n || n <= 0) {
				throw new Exception("row and element no n entered");
			}
			/*
			 * creating string of left half of single row of pyramid and
			 * appending numbers next to each other
			 */
			for (int i = 1; i <= n - row + 1; i++) {
				number_string = number_string + "" + i + " ";
			}
		} catch (Exception e) {
			System.out.println("Wrong input" + e);
		}
		return number_string;
	}

	public String[] printpyramid(int n) {
		String[] output_string;

		/*
		 * if array length is 0 or negative , error will be handled in try catch
		 * and program will show exception message but handle exception.
		 */
		try {
			if (n <= 0) {
				throw new Exception("invalid n entered");
			}
			output_string = new String[n];
			int k = 0;
			/*
			 * creating lower left half of pyramid
			 */

			for (int i = 1; i <= n; i++) {
				output_string[k++] = spaceString(i, n) + numberString(i, n);
			}
			return output_string;
		} catch (Exception e) {
			output_string = new String[0];
			System.out.println("Wrong input" + e);
			return output_string;
		}
	}

}
