package oopsassignment1;

public class Operations implements OperationsInterface{
	
	Buttons button = new Buttons();
	
	/**
	 * @Method	evaluate(int number1, int number2, char operator)
	 * when equals to operator is clicked evaluation can be done
	 * @param int number1, int number2, char operator(arithmetic operation to perform)
	 * @return	type = Number, super class of built-in data types
	 * */
	public Number evaluate(int number1, int number2, char operator) {
		// Here we are getting values and based on operator we calculate the result 
		switch(operator) {
		
			/* we'll have different cases according to functions 
			 * and we Call method to execute and return result on basis of operator clicked*/
		}
		
		return 0;
	}
	
	/** Addition */
	public int add(int number1, int number2) {
		return 0;
	}
	
	/** subtraction */
	public int subtract(int number1, int number2) {
		return 0;
	}
	
	/** multiplication*/
	public long multiply(int number1, int number2) {
		return 0;
	}
	
	/** division 
	 * 	 divide by zero exception should be handled 
	 * */
	public double divide(int dividend, int divisor) {
		return 0;
	}
	
	/** modulas calculation
	 * handle exception of divide by zero
	 **/
	public int modulas(int dividend, int divisor) {
		return 0;
	}
	
	
	/** find exponent of a numbers
	 * */
	public long exponent(int number, int power) {
		return 0;
	}	
}
