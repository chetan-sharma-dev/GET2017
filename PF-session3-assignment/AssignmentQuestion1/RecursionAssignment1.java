package pfsession3;

public class RecursionAssignment1 {
	public int rem(int x, int y) {
		int remainder_result = -1;
		try {
			/*
			 * testing for given condition if fails return exception
			 * */
			if (x >= 0 && y > 0) {
				/*
				 * if x<y means we are having remainder so we returned x else continue do subtraction
				 * */
				if (x < y) {
					return x;
				} else {
					remainder_result = rem(x - y, y);
				}

			} else {
				throw new Exception("Input no is not in given range for remainder calculation");
			}
		} catch (Exception e) {
			System.out.println("wrong input:" + e);
		}
		return remainder_result;
	}

	public int gcd(int x, int y) {
		try {
			/*
			 * testing for given condition if fails return exception
			 * */
			if (x > 0 && y > 0) {
				/*here we are having x==y then we are at remainder condition so return x or y else if x>y then calculate remainder  */
				if (x == y) {
					return y;
				} else if (x > y) {
					return gcd(x - y, x);
				} else {
					return gcd(x, y - x);
				}
			} else {
				throw new Exception("Input no is not in given range for gcd calculation");
			}
		} catch (Exception e) {
			System.out.println("wrong input:" + e);
			return -1;
		}
	}

	public int largestDigit(int x) {
		int maximum_digit =0;
		try {
			/*
			 * testing for given condition if fails return exception
			 * */
			if (x >= 0) {
				if (x == 0) {
					return 0;
				} else {
					/*
					 * here we are extracting last digit and comparing the returned values recursively
					 * */
					int temp1 = x % 10;
					int temp2 = largestDigit(x / 10);
					if (temp1 > temp2)
						maximum_digit = temp1;
					else
						maximum_digit = temp2;
				}
			} else {
				throw new Exception("invalid input");
			}
		} catch (Exception e) {
			System.out.println("wrong input:" + e);
		}
		return maximum_digit;
	}

	

}
