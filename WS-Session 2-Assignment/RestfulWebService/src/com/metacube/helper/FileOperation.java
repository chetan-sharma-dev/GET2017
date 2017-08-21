package com.metacube.helper;

import java.io.File;


/**
 * The Class FileHelper.
 * 
 * The helper class will provide the object to read the file
 */
public class FileOperation {

	/** The file. object of File*/
	private File file;
	
	/**
	 * Instantiates a new file helper.
	 *
	 * @param fileName the file name
	 */
	public FileOperation(String fileName) {
		
	file =  new File(fileName);
	}
	
	/**
	 * Gets the file.
	 *
	 * @return the file object
	 */
	public File getFile(){
		return file;
	}
}
