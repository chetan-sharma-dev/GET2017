package pfsession4;

public class NqueenProblem {

	/**
	 * @Method	getSolution(int[][] input)
	 * gives true if solution is possible else false
	 * @param	input array 
	 * @return	type = boolean, true or false 
	 * */
	public boolean getSolution(int[][] input,int startrow,int dimensionOfMatrix)
	{
		try {
			/*
			 * checking for valid condition if fails return Exception else returning status of solution true or false calculated in another Function
			*/
			if (input.length > 0 && input[0].length == input.length&&startrow==0&&dimensionOfMatrix==input.length)
			{ 
				int n=input.length;
				for(int i=0;i<n;i++)
				{
					for(int j=0;j<n;j++)
					{
						input[i][j]=0;
					}
				}
				return getNqueenSolution(input, 0);
			}
			else
			{
				throw new IllegalArgumentException(
						"here you passed illigal arguments");
			}
		}
		catch (IllegalArgumentException e) {
			System.out.println(e);
			return false;
		}
	}
	/**
	 * @Method	 getNqueenSolution(int[][] input, int column)
	 * gives true if solution is possible else false
	 * @param	input array and starting column to enter element
	 * @return	type = boolean, true or false 
	 * */
	public boolean getNqueenSolution(int[][] input, int column) {
		
				int input_length = input.length;
				/*
				 * if we successfully reached at last with correct placements of queen ,then return true else false
				 * */
				if (column >= input.length) {
					return true;
				} else {
					/*
					 * running loop from first to last column checking for validation
					 * */
					for (int row = 0; row < input_length; row++) {
						/*
						 * if validation done , enter Queen
						 * */
						if (isValidToEnter(input, row, column)) {
							input[row][column] = 1;
							if (getNqueenSolution(input, column + 1))
								return true;
							/*
							 * if true not returned do backtracking
							 * */
							input[row][column] = 0;
						}

					}
					return false;
				}
		
	}

	/**
	 * @Method	 isValidToEnter(int[][] input, int row, int column)
	 * gives true if no queen in horizontal and diagonal direction only in left of current location
	 * @param	input array and row and column no
	 * @return	type = boolean, true or false 
	 * */
	public boolean isValidToEnter(int[][] input, int row, int column) {
		int i, j;
		/*
		 * check for left horizontal row elements
		 * */
		for (i = 0; i < column; i++) {
			if (input[row][i] ==1)
				return false;
		}
		/*
		 * check for left diagonal elements in upper rows
		 * */
		for (i = row, j = column; i >= 0 && j >= 0; i--, j--) {
			if (input[i][j] == 1)
				return false;
		}
		/*
		 * check for left diagonal elements in lower rows
		 * */
		for (i = row, j = column; j >= 0 && i < input.length; i++, j--) {
			if (input[i][j] == 1)
				return false;
		}
		return true;
	}
	

}
