package com.metacube.tempconversion;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
public class F2CConversionTestCase {
	FahrenheitToCelsiusConversionService serviceObject;
	
	@Before
	public void creteObject(){
		serviceObject=new FahrenheitToCelsiusConversionService();
	}
	
	@Test
	public void positiveTestCase(){
		double actualOutput=serviceObject.getValueInCelsius(50.0);
		double expectedOutput=10.0;
		assertEquals(actualOutput,expectedOutput,0.0);
	}
	
	@Test
	public void negativeTestCase(){
		double actualOutput=serviceObject.getValueInCelsius(60.0);
		double expectedOutput=10.0;
		assertEquals(actualOutput,expectedOutput,0.0);
	}
	
}
