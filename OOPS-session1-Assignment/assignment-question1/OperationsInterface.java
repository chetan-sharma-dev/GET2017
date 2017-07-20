package oopsassignment1;

/**
 * Interface top force calculator to include basic arithmetic operations
 * **/

public interface OperationsInterface {
	public int add(int number1, int number);
	public int subtract(int number1, int number2);
	public long multiply(int number1, int number);
	public double divide(int number1, int number2);
	public long exponent(int number, int power);
	public int modulas(int dividend, int divisor);
	public Number evaluate(int number1, int number2, char operator);
}
