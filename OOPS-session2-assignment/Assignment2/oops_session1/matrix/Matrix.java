package oops_session1;

import java.util.InputMismatchException;

public class Matrix {
	private int data[][];
	private int noRows;
	private int noCols;
/**
 * @constructor Matrix(int row, int col)
 * parameterized constructor for initializing parameters  
 * */
	public Matrix(int row, int col) {
		try{
			/*
			 * checking for valid possibilities of rows and columns combination 
			 * if fails throw an IllegalArgumentException   
			 * */
			if(row>0&&col>0)
			{
				this.noRows = row;
				this.noCols = col;
				data = new int[row][col];
			}
			else
			{
				throw new IllegalArgumentException();
			}
		}
		catch(IllegalArgumentException e)
		{
			System.out.println(e);
		}
	}
	/**
	 * @Method addElements(int row, int col, int value)
	 * this method add elements in Matrix data array on given location
	 * @param rows, columns and value to be entered
	 * @return void  
	 * */

	public void addElements(int row, int col, int value) {
		try {
			/*
			 * checking for valid possibilities of rows and columns combination 
			 * if fails throw an IllegalArgumentException   
			 * */
			if (row < noRows && col < noCols && row >= 0 && col >= 0) {
				/*
				 * entering values in matrix 
				 */
				this.data[row][col] = value;
			} else {
				throw new IllegalArgumentException(
						"please enter valid rows and column combination");
			}
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}
	}
	/**
	 * @Method transpose()
	 * do transpose the given matrix
	 * @param 
	 * @return Matrix class object
	 * */
	public Matrix transpose() {
		try {
			/**
			 * checking for valid possibilities of rows and columns combination 
			 * if fails throw an IllegalArgumentException   
			 * */
			Matrix transpose_matrix;
			if (noRows > 0 && noCols > 0) {
				transpose_matrix = new Matrix(this.noCols, this.noRows);
				/*
				 * transposing logic
				 * */
				for (int i = 0; i < noRows; i++) {
					for (int j = 0; j < noCols; j++) {
						transpose_matrix.data[j][i] = data[i][j];
					}

				}
				return transpose_matrix;
			} else {
				throw new IllegalArgumentException("Empty array");
			}
		} catch (IllegalArgumentException e) {
			System.out.println(e);
			// int[][] transposed_matrix_data = new int[0][0];
			return new Matrix(this.noCols, this.noRows);
		}

	}

	public int[][] show() {
		try {
			if (noRows > 0 && noCols > 0) {
				return data;
			} else {
				throw new IllegalAccessError("No data exist to show ");
			}
		} catch (IllegalAccessError e) {
			System.out.println(e);
			return new int[0][0];
		}

	}
	/**
	 * @Method multiply(Matrix matrix1)
	 * do multiply two given matrix
	 * @param second Matrix object 
	 * @return int[][]:a data array
	 * */
	public int[][] multiply(Matrix matrix1) {
		try {
			/*
			 * checking for matrix multiplication condition
			 * condition: no columns of first matrix should equal to no of rows in second one
			 * if condition fails throw InputMismatchException
			 * */
			if (this.noCols == matrix1.noRows) {
				/*
				 * creating temp matrix to hold multiplication output
				 * */
				int[][] multiply_output_matrix = new int[noRows][matrix1.noCols];
				for (int i = 0; i < this.noRows; i++) {
					for (int j = 0; j < matrix1.noCols; j++) {
						for (int k = 0; k < this.noCols; k++) {
							/*
							 * multiplication main logic
							 * */
							multiply_output_matrix[i][j] = multiply_output_matrix[i][j]
									+ data[i][k] * matrix1.data[k][j];
						}

					}
				}
				return multiply_output_matrix;
			} else {
				throw new InputMismatchException("matrix can't be multiplied ");
			}
		} catch (InputMismatchException e) {
			System.out.println(e);
			return new int[0][0];
		}
	}

	
}
