
package pfsession;


public class Fcfs {
	public boolean isArrayEqual(int[][] expected, int[][] actual){
		boolean flag= true;
		for(int row=0; row<4; row++){
			for(int column=0; column<5; column++){
				if(actual[row][column] != expected[row][column]){
					flag= false;
					break;
				}
			}
		}
		return flag;
	}
	
 public int[][] FCFS( int arrival_time[], int job_size[] )
 {
     int[][] output=new int[arrival_time.length][job_size.length];
     /*
      * here output is multidimensional array whose first,second,third,fourth column is holding arrival, waiting, starting ,ending time of particular job
      * here waiting,starting,ending times are calculated
      */
     for(int i=0;i<job_size.length;i++)
     {
         int j=0;
            output[i][j]=arrival_time[i];
            
            if(i==0)
                output[i][j+2]=1;
            else
            {   if(output[i][j]>output[i-1][j+3]+1)
                {
                    output[i][j+2]=output[i][j];
                }
                else{
                    output[i][j+2]=output[i-1][j+3]+1;
                }
            }
            
            if(output[i][j+2]-output[i][j]>=0)
            {
                output[i][j+1]=output[i][j+2]-output[i][j];
            }
            else
            {
                output[i][j+1]=0;
            }  
            output[i][j+3]=output[i][j+2]+job_size[i]-1;
         
     }
     return output;
 }
  
}
