/*
 *   program for printing pyramid which has a mirror image with respect to middle horizental line 
 */
package pfsession;

//class for printing pyramid 

public class PyramidPrintingFirst {

	// method returning string of spaces
	public String spaceString(int row, int n) {
		String spaces_string = "";
		if (row <= 0 || row >= 2 * n || n <= 0) {
			throw new NumberFormatException();
		}
		if (row > n) {
			row =  2*n-row;
		}
		// appending spaces next to each other
		for (int i = row; i < n; i++) {
			spaces_string = spaces_string + "  ";

		}

		return spaces_string;
	}

	/*
	 * method returning string of numbers
	 */
	public String numberString(int row, int n) {
		String number_string = "";
		if (row <= 0 || row >= 2 * n || n <= 0) {
			throw new NumberFormatException();
		}
		if (row > n) {
			row = 2*n-row;
		}
		/*
		 * creating string of left half of single row of triangular pyramid and
		 * appending numbers next to each other
		 */
		for (int i = 1; i <= row; i++) {
			number_string = number_string + "" + i + " ";
		}
		/*
		 * creating string of right half of single row of trinagular pyramid and
		 * this, next to left half
		 */
		for (int i = row - 1; i >= 1; i--) {
			number_string = number_string + "" + i + " ";
		}
		return number_string;
	}

	/*
	 * method returning array of string lines of final priamid
	 */
	public String[] printpyramid(int n) {
		String[] output_string;

		/*
		 * if array length is 0 or negative , error will be handled in try catch
		 * and program will show exception message but handle exception.
		 */
		if (n <= 0) {
			throw new NumberFormatException();
		}
		output_string = new String[n * 2 - 1];
		int k = 0;
		/*
		 * creating upper half of triangle including middle line
		 */
		for (int i = 1; i <= n; i++) {

			output_string[k++] = spaceString(i, n) + numberString(i, n);

		}
		/*
		 * creating lower half of triangle including middle line
		 */
		for (int i = n - 1; i >= 1; i--) {
			output_string[k++] = spaceString(i, n) + numberString(i, n);
		}
		return output_string;

	}

	public static void main(String[] a){
		System.out.println(new PyramidPrintingFirst().numberString(9, 5));
	}
	
}
