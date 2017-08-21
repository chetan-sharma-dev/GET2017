package com.metacube.tempconversion;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @class 
 * class which is implementing all methods of class
 * */
@WebService
public class FahrenheitToCelsiusConversionService {
	
	/**
	 * @method getValueInCelsius
	 * method converting Fahrenheit value into celsius
	 * */
	@WebMethod
	public Double getValueInCelsius(Double fahrenheitValue){
			return 	((fahrenheitValue-32)*5)/9;
		}

}
