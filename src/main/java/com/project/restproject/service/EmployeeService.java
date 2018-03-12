package com.project.restproject.service;

import com.project.restproject.model.Employee;
import com.project.restproject.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


/**
 * <h1>Service for Employee Information</h1>
 * The Employee Service implements methods to
 * save, get, delete an Employee
 * <p>*
 * @author  Hiren Parmar
 * @version 1.0
 * @since   2018-03-04
 */
@Service
public class EmployeeService {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);


    //Employee Repository.
    @Autowired
    private EmployeeRepository employeeRepository;



    /**
     * This method is used to save employee.
     * @param employee This is the only parameter to save method
     * @return Nothing.
     */
    public Employee save(Employee employee) throws Exception{
        logger.debug("Saving Employee: {}", employee);
        return employeeRepository.save(employee);
    }

    /**
     * This method is used find an Employee by giving an id.
     * @param number This is the parameter to get method
     * @return Employee This returns Employee object for the id.
     */
    public Optional<Employee> get(Long number) throws Exception{
        logger.debug("Get Employee for number: {}", number);
        return employeeRepository.getByNumber(number);
    }

    /**
     * This method is used to delete employee.
     * @param id This is the parameter to delete method
     * @return Nothing.
     */
    public void delete(Long id){
        logger.debug("Delete Employee for Id: {}", id);
        employeeRepository.deleteById(id);
    }
}
