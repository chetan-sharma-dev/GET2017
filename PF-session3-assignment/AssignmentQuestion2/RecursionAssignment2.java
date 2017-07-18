package pfsession3;

public class RecursionAssignment2 {
	
	public Boolean linearSearch(int[] input_array,int index,int search_element)
	{ 
		try {
			/*
			 * if length is positive then allow to execute else return error
			 * */
			if (input_array.length > 0) {
				/*
				 * if we reached at boundary then return false
				 * */
				if(index==input_array.length)
				{
					return false;
				}
				else
				{
					/*
					 * if we found element return true from here itself else keep on searching linearly
					 * */
					if(input_array[index++]==search_element)
						{
							return true;
						
						}
					else
						{
							return linearSearch(input_array,index, search_element);
						}
				}
			}		
			 else {
				throw new Exception("invalid array input");
			}
		}
			 catch (Exception e) {
			System.out.println("wrong input:"+e);
			return false;
		}

		
	}

	
	public String binarySearch(int input[], int start, int end, int element) {
		int mid_index = (start + end) / 2;
		try{
			/*
			 * test for negative exception cases if any condition is true throw exception
			 * */
		if(start<0||end<0||input.length==0)
		{
			throw new Exception("invalid input in binary search");
		}
		else if (start >= end && input[mid_index] != element) {
			return "not found";
		} else if (input[mid_index] == element) {
			/*
			 * if element found return found 
			 * */
			return "found";
		} else {
			/*
			 * if current element is lesser go in left subarray else in rightone
			 * */
			if (element < input[mid_index]) {
				return binarySearch(input, start, mid_index - 1, element);
			} else {
				return binarySearch(input, mid_index + 1, end, element);
			}

		}

	}
		catch(Exception e)
		{
			System.out.println("Exception:"+e);
			return "invalid input";
			}
		}

	
}
