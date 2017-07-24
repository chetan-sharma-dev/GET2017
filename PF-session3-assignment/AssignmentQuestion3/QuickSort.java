package pfsession3;

public class QuickSort {
	/**
	 * @Method	quickSort(int[] input_array, int start, int end)
	 * sorts input array by selecting a pivot element and diving the array into small sublists
	 * @param	input array that contains unsorted elements,start and end index
	 * @return	type = void, sorted sublist of input array
	 * */
	public void quickSort(int[] input_array, int start, int end) {
		try {
			/*
			 * here we are checking for allowed condition
			 * */
			if (start < end) {
				/*
				 * we call partition index ,from where our input_array divided into lists 
				 * */

				int partition_index = findPartitionIndex(input_array, start,
						end);
				/*
				 * we are creating 2 sublists for sorting  
				 * */
				quickSort(input_array, start, partition_index - 1);
				quickSort(input_array, partition_index+1, end);

			} 
			/*
			 * checking for all error conditions  
			 * */
			else if (start < -1 || end < -1 || start > end + 2) {
				throw new Exception("invalid input given");
			}

		} catch (Exception e) {
			System.out.println("Exception" + e);
		}

	}

	/**
	 * @Method	findPartitionIndex(int[] input_array, int start, int end)
	 * calculate partition index for creating small sublists
	 * @param	input array that contains unsorted elements,start and end index
	 * @return	type = int, sorts the input array
	 * */
	public int findPartitionIndex(int[] input_array, int start, int end) {
		/*
		 * i is storing the index where the lesser value is stored  
		 * */
		int i = start - 1;
		int pivot_element = input_array[end];

		for (int j = start; j < end; j++) {

			if (input_array[j] <= pivot_element) {
				i++;
				/*
				 * swaping ith and jth location
				 * */
				int temp = input_array[i];
				input_array[i] = input_array[j];
				input_array[j] = temp;
			}
		}
		/*
		 * placing pivot_element at it's right location 
		 * */
		int temp = input_array[i + 1];
		input_array[i + 1] = input_array[end];

		input_array[end] = temp;
/*
 * pivot element is now it's right location so we are returning it and then we sort left and right sublist separately.
 * */
		return i + 1;

	}

	

}
