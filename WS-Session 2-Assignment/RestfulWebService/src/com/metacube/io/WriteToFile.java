package com.metacube.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;
import org.codehaus.jackson.map.ObjectMapper;
import com.metacube.constants.FilePathConstants;
import com.metacube.entity.Employee;

public class WriteToFile { 
	private static Employee employeeObject;
	public static void writeFile(Map<String,Employee> employeeDetail){
		try (
				FileWriter fileWriterObject = new FileWriter(FilePathConstants.EMPLOYEE_JSON_FILE_PATH,false);
				BufferedWriter bufferedWriterObject = new BufferedWriter(fileWriterObject);
				PrintWriter printWritterObject = new PrintWriter(bufferedWriterObject))
				{
						ObjectMapper mapperObject = new ObjectMapper();
					    Set<String> keySet = employeeDetail.keySet();
					    for(String key :keySet)
					    {
					    	employeeObject = employeeDetail.get(key);
							String jsonInString = mapperObject.writeValueAsString(employeeObject);
							printWritterObject.println(jsonInString);
					    }
					    printWritterObject.close();
				}catch (IOException e) {
					e.printStackTrace();

				}
	}

	
	public static void writeFile(Employee employee ){
		try(
				FileWriter fw = new FileWriter(FilePathConstants.EMPLOYEE_JSON_FILE_PATH,true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter printWritterObject = new PrintWriter(bw)){
			ObjectMapper mapperObject = new ObjectMapper();
			String jsonInString = mapperObject.writeValueAsString(employee);
			printWritterObject.println(jsonInString);
			printWritterObject.close();
		}catch(Exception e){
				System.out.println("");
		}

	}

}