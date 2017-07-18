package pfsession;



import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SortedArrayCheckTestCase {
	SortedArrayCheck check_array;
	@Before
	public void setUp(){
		check_array = new SortedArrayCheck();
	}
	/* negative test
	* will return Unordered
	*/
	@Test
    public void sortedArrayCheckingTest1() {
    		int[] input = {6,6,6,6};
		
    		int actual_output= check_array.sortedArrayCheck(input);
    		switch (actual_output) {
            case 0:
                System.out.println("Unordered");
                break;
            case 1:
                System.out.println("Accending ordered");
                break;
            case 2:
                System.out.println("Decending ordered");
                break;
        }
    		Assert.assertEquals("Array in ascending sorted order",1, actual_output);
    
    }
	
	/*positive test
	* Accending ordered
	*/
    @Test
    public void sortedArrayCheckingTest2() {
    		int[] input = {1, 2, 3, 4, 5, 89, 400};
		
    		int actual_output= check_array.sortedArrayCheck(input);
    		switch (actual_output) {
            case 0:
                System.out.println("Unordered");
                break;
            case 1:
                System.out.println("Accending ordered");
                break;
            case 2:
                System.out.println("Decending ordered");
                break;
        }
    		Assert.assertEquals("Array in ascending sorted order",1, actual_output);
    
    }
    /*	negative test
	* unordered
	*/
    @Test
    public void sortedArrayCheckingTest3() {
    	int[] input = {90, 89, 88, 88, 78, 67, 56};
		
    		int actual_output= check_array.sortedArrayCheck(input);
    		switch (actual_output) {
            case 0:
                System.out.println("Unordered");
                break;
            case 1:
                System.out.println("Accending ordered");
                break;
            case 2:
                System.out.println("Decending ordered");
                break;
        }
    		Assert.assertEquals("Array in ascending sorted order", 1, actual_output);
    
    }
    /*
	* exception handled 
	* 
	*/
	
    @Test
    public void sortedArrayCheckingTest4() {
    		int[] input = {6};
		
    		int actual_output= check_array.sortedArrayCheck(input);
    		
    		Assert.assertEquals("Array in ascending sorted order",1, actual_output);
    
    }
    public void sortedArrayCheckingTest5() {
    	try{
    		int[] input = {};
		
    		int actual_output= check_array.sortedArrayCheck(input);
    		switch (actual_output) {
            case 0:
                System.out.println("Unordered");
                break;
            case 1:
                System.out.println("Accending ordered");
                break;
            case 2:
                System.out.println("Decending ordered");
                break;
        }
    	
    		Assert.assertEquals("Array in ascending sorted order", 1, actual_output);
    	}
    	catch(Exception e)
    	{
    			System.out.println(e);
    	}
    }
}
