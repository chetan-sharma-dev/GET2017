
package com.metacube.DAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.metacube.entity.Employee;
import com.metacube.helper.FileOperation;
import com.metacube.constants.FilePathConstants;
/**
 * The Class FileDao.
 *
 * This class will perform the operation regarding the employeeFile operation
 */
public class FileDao  implements BaseDao {

    /**
     * The employeeFile.
     */
    private File employeeFile;

    /**
     * The employees.
     */
    private List<Employee> employeesList;

    /**
     * Instantiates a new employeeFile dao.
     */
    public FileDao() {
        employeeFile = new FileOperation(FilePathConstants.EMPLOYEE_JSON_FILE_PATH).getFile();
    }

    /**
     * Read the product from employeeFile specified
     *
     * @return the list containing the object of product class
     */
    @Override
    public List<Employee> getAllEmployee() {
        try {
            /**
             * Making a list to storing the product *
             */
        	employeesList = new ArrayList<Employee>();

            /**
             * Opening the stream to read from employeeFile*
             */
            FileInputStream fstream = new FileInputStream(employeeFile);

            BufferedReader sc = new BufferedReader(new InputStreamReader(fstream));

           
            /*
             * Making a parser to convert it to a Json object
             */
            JSONParser parser = new JSONParser();
           
            /**
             * Object of employee
             */
            Employee employeObject = null;

            /**
             * line denotes the line in employeeFile*
             */
            String line;
            while ((line = sc.readLine()) != null) {
                JSONObject js = (JSONObject)parser.parse(line);
                employeObject = new Employee();
                employeObject.setName((String)js.get("name"));
                employeObject.setAge((Integer)js.get("age"));
                employeObject.setId((String)js.get("id"));
                employeesList.add(employeObject);
            }
            /**
             * Closing the reader*
             */
            sc.close();
        } catch (IOException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println("Halting the code");
            System.exit(1);
        } catch (ParseException e) {
			System.out.println("Error while parsing the Json Object");
		}
        /**
         * returning the list*
         */
        return employeesList;
    }

    /**
     * @method searchEmployee
     *  method searching employee id and returning Employee Object
     * */
    @Override
    public Employee searchEmployee(String id) {
        Iterator<Employee> itr = employeesList.iterator();
        Employee employeeObject = null;
        boolean flag = false;
        while (itr.hasNext()) {
        	employeeObject = itr.next();
            if (employeeObject.getId().equals(id)) {
                flag = true;
                break;
            }
        }
        if(!flag){
        	employeeObject = null;
        }
        return employeeObject;
    }
   

}
