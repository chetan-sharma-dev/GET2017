package myutils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * @class
 * class for doing fileOperations 
 * */
public class FileOperations {
	/**
	 * @method readFile(String path)
	 * method for reading file and returning list of string lines
	 * */
	public List<String> readFile(String filepPath) {
		List<String> fileContentLineByLine = new ArrayList<String>();
		/*
		 * reading form file and storing in list of string type
		 * */
		try (BufferedReader bufferedReaderObject = new BufferedReader(
				new FileReader(filepPath))) {
			String currentReadLine;
			while ((currentReadLine = bufferedReaderObject.readLine()) != null) {
				fileContentLineByLine.add(currentReadLine);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found" + e);
		} catch (IOException e) {
			System.out.println("IOException" + e);
		}
		return fileContentLineByLine;
	}
	
	public static void main(String[] args) {
		FileOperations fileOperationObject=new FileOperations();
		System.out.println(fileOperationObject.readFile("counselling.txt").toString());
	}
}
