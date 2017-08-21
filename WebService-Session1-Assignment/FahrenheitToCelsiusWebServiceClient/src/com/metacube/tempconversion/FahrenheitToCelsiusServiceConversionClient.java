package com.metacube.tempconversion;

public class FahrenheitToCelsiusServiceConversionClient {

	public static void main(String...s)
	{
		/*
		 * created locatorObject,using that locator object we set endPoints or port address
		 * then we create service object using locatorObject,and then we call that service method for conversion
		 * 
		 * */
		FahrenheitToCelsiusConversionServiceServiceLocator locatorObject=new FahrenheitToCelsiusConversionServiceServiceLocator();
		locatorObject.setFahrenheitToCelsiusConversionServiceEndpointAddress("http://localhost:8080/FahrenheitToCelsiusWebService/services/FahrenheitToCelsiusConversionService");
		try{
			FahrenheitToCelsiusConversionService serviceObject=locatorObject.getFahrenheitToCelsiusConversionService();
			Double fahrenheitValue=50.0;
			System.out.println(fahrenheitValue+" F = "+serviceObject.getValueInCelsius(fahrenheitValue)+" C");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
