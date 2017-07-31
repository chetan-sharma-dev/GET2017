package oopssession5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Iterator;

public class FileOperations {
	/*
	 * @method countNoOfLinesInFile(String path)
	 * giving line count of given file.
	 * */
	public static int countNoOfLinesInFile(String path) throws IOException {
		FileInputStream file_input = new FileInputStream(path);
		BufferedReader buffer_input = new BufferedReader(new InputStreamReader(
				file_input));
		int line_count = 0;
		while ((buffer_input.readLine()) != null) {
			line_count++;
		}

		buffer_input.close();
		return line_count;
	}
	
	/*
	 * @method  generateBillFile(List<String> orderBill)
	 * storing orderedBill in file
	 * */
	public static void generateBillFile(List<String> orderBill)  {
		  try{
			    // Create file 
			    FileWriter fstream = new FileWriter("");
			        BufferedWriter out = new BufferedWriter(fstream);
			        Iterator<String> itr =orderBill.iterator();
			        /*
			         * iterating list and doing entry in file line by line
			         * */
			        	while (itr.hasNext()) {
			        		 out.write(itr.next());
			        		 out.newLine();
			    		}
			        	
			    //Close the output stream
			    out.close();
			    }catch (Exception e){//Catch exception if any
			      System.err.println("Error: " + e.getMessage());
			    }
		
	}


	public static void appendInFile(String path,String data)
	{
		BufferedWriter bw = null;
		FileWriter fw = null;

		try {

			

			File file = new File(path);

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			// true = append file
			fw = new FileWriter(file.getAbsoluteFile(), true);
			bw = new BufferedWriter(fw);

			bw.write(data);
			bw.newLine();
//			System.out.println("Done");

		} catch (IOException e) {

			System.out.println(e);
			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
		}

	
		
	}

	
}


