
package pfsession;


public class SortedArrayCheck {
	
     public int sortedArrayCheck(int input[])
    {  int status=-1;
        int input_array_legth=input.length;
        /*if once status changed and remains same throughout the loop then it will return relative sorting sequence.
         * other wise it'll return unsorted
         * */
       if(input_array_legth!=1)
        {
            for(int i=1;i<input_array_legth;i++)
            {
                if(status==-1)
                 {
                    if(input[i-1]<input[i])
                        {
                            status=1;
                        }
                        else if(input[i-1]>input[i])
                        {
                            status=2;
                        }
                        else 
                        {
                            status=0;
                            break;
                        }
                }
                else if(status==1)
                {
                    if(input[i-1]<input[i])
                        {
                            continue;
                        }
                        else if(input[i-1]>=input[i])
                        {
                            status=0;
                            break;
                        }
                }
                else if(status==2)
                {
                    if(input[i-1]>input[i])
                        {
                            continue;
                        }
                        else if(input[i-1]<=input[i])
                        {
                            status=0;
                            break;
                        }
                }
        }
        }
            else
            {
                status=1;
            }
        return status;
    }
 
}