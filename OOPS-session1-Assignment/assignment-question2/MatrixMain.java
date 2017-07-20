package oopsassignment1;

import java.util.Scanner;

public class MatrixMain {
	
	/**@Method	scanMatrix(int row, int column, Matrix matrix_object)
	 * take row , column no and Matrix Object and add elements in Matrix along with scanning
	 * */
	static void scanMatrix(int row, int column, Matrix matrix_object) {
		/*
		 * checking for valid row and column combination if fails returned error message
		 * */
		if (row > 0 && column > 0) {
			Scanner input = new Scanner(System.in);
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				matrix_object.addElements(i, j, input.nextInt());
			}
		
		}
		
		}
		else
		{
			System.out.println("Invalid input");
		}
	}
	/**@Method	printMatrix(int[][] matrix_output)
	 * simply taking array and printing it 
	 * */
	static void printMatrix(int[][] matrix_output) {
		/*
		 * simply checking the non empty array, if fails printing error
		 * */
		if (matrix_output.length > 0 && matrix_output[0].length > 0) {
			System.out.println("These are matrix elements:-");
			int rows = matrix_output.length;
			int columns = matrix_output[0].length;
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < columns; j++) {
					System.out.print(matrix_output[i][j] + ",");
				}
				System.out.println("");
			}
		} else {
			System.out.println("Invalid input");
		}

	}

	public static void main(String[] args) {
		// creating common Scanner object
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter size of matrix: ");
		int row = input.nextInt();
		int column = input.nextInt();

		// adding elements to matrix
		Matrix matrix_object = new Matrix(row, column);
		System.out.println("Enter ,matrix elementas:-");
		scanMatrix(row, column, matrix_object);
		printMatrix(matrix_object.show());

		// Multiplying two Matrixes
		
		System.out.println("Matrix Multiplication");		
		System.out.println("Enter dimensions of matrix1: ");
		row = input.nextInt();
		column = input.nextInt();
		Matrix multiply_matrix1=new Matrix(row, column);
		System.out.println("Scan elements of matrix1: ");
		scanMatrix(row,column,multiply_matrix1);
		
		System.out.println("Enter dimensions of matrix1: ");
		row = input.nextInt();
		column = input.nextInt();
		Matrix multiply_matrix2 = new Matrix(row, column);
		System.out.println("Scan elements of matrix1: ");
		scanMatrix(row,column,multiply_matrix2);
		
		System.out.println("multiplied matrix");
		printMatrix(multiply_matrix1.multiply(multiply_matrix2));

		// Transpose of a matrix
		System.out.println("Trasnsposing matrix \n metrix before transposing");
		printMatrix(matrix_object.show());
		System.out.println("metrix after transposing");
		printMatrix(matrix_object.transpose().show());
		
		input.close();
	}

}
