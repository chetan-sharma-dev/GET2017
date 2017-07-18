package pfsession;

public class ConvertionBinaryToOctal {

	public int convertBinaryToOctal(int n)  {
		
		int temp = n;
		try {
			int converted_decimal = 0;
			int pow = 1;
			if (temp >= 0) {
				/*
				 * this code is changing octal value to decimal value 
				 * eg. 111 will be calculated as (2^2)*1+(2^1)*1+(2^0)*1=7
				 * here ^ symbol used for power
				*/
				while (temp != 0) {
					if (temp % 10 == 0 || temp % 10 == 1) {
						converted_decimal = converted_decimal + (temp % 10) * pow;
						temp = temp / 10;
						pow = pow * 2;
					} else {

						throw new Exception("this is not converted_decimal buddy");

					}

				}
				int octal = 0;
				temp = converted_decimal;
				pow = 1;
				while (temp != 0) {
					/*this code is changing converted_decimal value to octal value 
					 * eg. 15 will be calculated as we first calculate remainder form 8 and progressively prepend current remainders to previous appended no
					 *   15/8 remainder=7 and divident=1
					 *   so final octal value is 10*1+7=17  
					 * here ^ symbol used for power
					*/
					
					octal = octal + (temp % 8) * pow;
					temp = temp / 8;
					pow = pow * 10;
				}
				return octal;
			} else {
				throw new Exception("this is negative no");
			}
		} catch (Exception e) {
			System.out.println(e);
			return -1;

		}
	}

}
