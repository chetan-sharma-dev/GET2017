
package com.metacube.DAO;
import java.util.List;

import org.json.simple.JSONArray;

import com.metacube.entity.BaseEntity;
import com.metacube.entity.Employee;

/**
 * The Interface BaseDao.
 *
 *This DAO is the super DAO 
 * @param <T> the generic type

 */
public interface BaseDao{
    
    /**
     * Gets the all Employee.
     *
     * @param <Employee> the generic type
     * @return the list containing  all Employee
     */
    public List<Employee> getAllEmployee();
   
   /**
    * SearchEmployee.
    *
     * @param <Employee>
    * @param id the id
    * @return the t
    */
   public BaseEntity searchEmployee(String id);
   
}
