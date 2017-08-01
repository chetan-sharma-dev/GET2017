package oopssession5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Iterator;

public class FileOperations {
	/**
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
	
	/**
	 * @method appendInFile(String path,String data) 
	 * append line in file without over writing whole contents
	 */

	public static void appendInFile(String path,String data)
	{
		BufferedWriter bufferWriterObject = null;
		FileWriter fileWriterObject = null;

		try {
			File file = new File(path);
			if (!file.exists()) {
				file.createNewFile();
			}
			/*
			 * true is for appending mode
			 * */
			fileWriterObject = new FileWriter(file.getAbsoluteFile(), true);
			bufferWriterObject = new BufferedWriter(fileWriterObject);

			bufferWriterObject.write(data);
			bufferWriterObject.newLine();

		}catch(FileNotFoundException e)
		{
			System.out.println("no such file exist"+e);
		}
		catch (IOException e) {

			System.out.println("error in writting file"+e);
		} finally {

			try {

				if (bufferWriterObject != null)
					bufferWriterObject.close();

				if (fileWriterObject != null)
					fileWriterObject.close();

			} catch (IOException e) {
					System.out.println(e);
			}
		}

	
		
	}

	
}


