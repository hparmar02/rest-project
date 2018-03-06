package com.project.restproject.repository;

import com.project.restproject.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.HashMap;


/**
 * <h1>Repository for Employee Information</h1>
 * The Employee Repository implements methods to
 * save, get, delete an Employee
 * <p>*
 * @author  Hiren Parmar
 * @version 1.0
 * @since   2018-03-04
 */
@Repository
public class EmployeeRepository {

    //in memory data-structure for employee. HashMap having id as key, and employee object as value.
    private HashMap<Long, Employee> employeeHashMap = new HashMap<>();
    private static final Logger logger = LoggerFactory.getLogger(EmployeeRepository.class);

    /**
     * This method is used to save employee.
     * @param employee This is the only parameter to save method
     * @return Nothing.
     */
    public Employee save(Employee employee) throws Exception{
        logger.debug("Saving employee: {}", employee);
        employeeHashMap.put(employee.getId(), employee);
        return employee;
    }

    /**
     * This method is used find an Employee by giving an id.
     * @param id This is the parameter to get method
     * @return Employee This returns Employee object for the id.
     */
    public Employee get(Long id) throws Exception{
        Employee employee = employeeHashMap.get(id);
        logger.debug("Get Id: {} employee: {}", id, employee);
        return employee;
    }

    /**
     * This method is used to delete employee.
     * @param id This is the parameter to delete method
     * @return Nothing.
     */
    public void delete(Long id){
        logger.debug("Delete employee Id: {}", id);
        employeeHashMap.remove(id);
    }
}
