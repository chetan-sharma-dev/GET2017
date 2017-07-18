package pfsession;

public class RemoveDuplicate {

    public int[] removeDuplicate(int input[]) {
        int[] output = new int[input.length + 1];
        int length_of_array = input.length;
        int k = 0;
        /*
         * adding elements in new array and cross checking
         * here we are adding # as delimeter
         * */
        for (int i = 0; i < length_of_array; i++) {
            if (k == 0) {
                output[k++] = input[i];
                output[k] = '#';
            } else {
                int j;
                for (j = 0; j < k; j++) {
                    if (input[i] == output[j]) {
                        break;
                    }
                }
                if (j == k) {
                    output[k++] = input[i];
                    output[k] = '#';
                }

            }

        }
        int[] final_output_array=new int[k];
        k=0;
        while(output[k]!='#'&&input.length!=0)
        {
        	final_output_array[k]=output[k];
        	k++;
        }
        return final_output_array;
    }

}
