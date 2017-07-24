/*
 *   program for printing pyramid which has a mirror image with respect to middle horizental line 
 */
package pfsession;

//class for printing pyramid 

public class PyramidPrintingFirst {

	// method returning string of spaces
	public String spaceString(int row, int n) {
		String spaces_string = "";
		try {
			/*
			 * row should not less then 1, n should not less than 1 and row should not exceed 2n 
			 * if above condition doesn't meet then throw exception 
			 * */
			if (row <= 0 || row >= 2 * n || n <= 0) {
				throw new Exception("invalid row and element no n entered");
			}
			/*
			 * if row exceeds then n then for printing lower part convert row no in reverse order 
			 * 
			 * */
			if (row > n) {
				row = 2 * n - row;
			}
			// appending spaces next to each other
			for (int i = row; i < n; i++) {
				spaces_string = spaces_string + "  ";

			}
		} catch (Exception e) {
			System.out.println("Wrong input" + e);
		}

		return spaces_string;
	}

	/*
	 * method returning string of numbers
	 */
	public String numberString(int row, int n) {
		String number_string = "";
		try {
			/*
			 * row should not less then 1, n should not less than 1 and row should not exceed 2n 
			 * if above condition doesn't meet then throw exception 
			 * */
			if (row <= 0 || row >= 2 * n || n <= 0) {
				throw new Exception("invalid row and element no n entered");
			}
			/*
			 * if row exceeds then n then for printing lower part convert row no in reverse order 
			 * 
			 * */
			if (row > n) {
				row = 2 * n - row;
			}
			/*
			 * creating string of left half of single row of pyramid
			 * and appending numbers next to each other
			 */
			for (int i = 1; i <= row; i++) {
				number_string = number_string + "" + i + " ";
			}
			/*
			 * creating string of right half of single row of pyramid
			 * and this, next to left half
			 */
			for (int i = row - 1; i >= 1; i--) {
				number_string = number_string + "" + i + " ";
			}
		} catch (Exception e) {
			System.out.println("Wrong input" + e);
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
		try {
			if (n <= 0) {
				throw new Exception("invalid input n");
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
		} catch (Exception e) {
			output_string = new String[0];
			System.out.println("Wrong input" + e);
			return output_string;
		}

	}

}
