package pfsession;
import static org.junit.Assert.*;

import org.junit.Test;


public class ConvertOctalTest {
	@Test
	 public void getOctalTest1()
	{
		ConvertionBinaryToOctal con=new ConvertionBinaryToOctal();	
		int var=Integer.parseInt("-1");
		int oct=con.convertBinaryToOctal(var);
		assertEquals(66, oct);
	}
	@Test
	public void getOctalTest2()
	{	ConvertionBinaryToOctal con=new ConvertionBinaryToOctal();
		int var=Integer.parseInt("0001000");
		 int oct=con.convertBinaryToOctal(var);
		 assertEquals(4, oct);
	}
	@Test
	public void getOctalTest3()
	{	ConvertionBinaryToOctal con=new ConvertionBinaryToOctal();
		int var=Integer.parseInt("110101");
		int oct=con.convertBinaryToOctal(var);
		assertEquals(65, oct);
	}
	@Test
	public void getOctalTest4()
	{	ConvertionBinaryToOctal con=new ConvertionBinaryToOctal();
		
			int var=Integer.parseInt("abcd");
			int oct=con.convertBinaryToOctal(var);
			assertEquals(65, oct);		
	
	}

	@Test
	public void getOctalTest5() {
		int var = 0;
		int oct = 0;
		ConvertionBinaryToOctal con = new ConvertionBinaryToOctal();
		try {
			var = Integer.parseInt("null");
			oct = con.convertBinaryToOctal(var);

		} catch (Exception e) {
			System.out.println(e);
		}
		assertEquals(65, oct);
	}
	@Test
	public void getOctalTest6()
	{	ConvertionBinaryToOctal con=new ConvertionBinaryToOctal();
		
			int var=Integer.parseInt("1256");
			int oct=con.convertBinaryToOctal(var);
			assertEquals(65, oct);
		
	}
}


