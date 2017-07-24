package oopsassignment1;

public class Calculator {
	public int result;
	public int firstNumber;
	public int secondNumber;
	public char operator;

	public Calculator() {
		
	}
	
	
	public Calculator(int firstNumber, int secondNumber, char operator){
		this.firstNumber=firstNumber;
		this.secondNumber=secondNumber;
		this.operator = operator; 
	}
	

	/**@Method	calculate()
	 * Input numbers and operator is passed to Calculator class
	 * by event handling at Layout ActionListner (button click)
	 * When '=' operator is pressed
	 * expression must be evaluated
	 * */
	public Number calculate(){
		return new Operations().evaluate(firstNumber, secondNumber, operator);
	}
	
	/**@Method displayResult()
	 * Follows the hierarchy of calling Operations to evaluate result
	 * Then to Display result
	 * Then to Layout class
	 * to print onto screen
	 * */
	public void displayResult() {
		Display printResult = new Display();
		
		printResult.displayOutput(calculate());
		
	}
}
